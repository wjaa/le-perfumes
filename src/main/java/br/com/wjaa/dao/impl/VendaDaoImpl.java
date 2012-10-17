package br.com.wjaa.dao.impl;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import br.com.wjaa.arquitetura.dao.impl.GenericDaoImpl;
import br.com.wjaa.commons.model.entity.Venda;
import br.com.wjaa.commons.model.entity.VendaPagamento;
import br.com.wjaa.controller.impl.VendaForm;
import br.com.wjaa.controller.impl.VendaItemForm;
import br.com.wjaa.controller.impl.VendaPagamentoForm;
import br.com.wjaa.controller.impl.VendaPrazoForm;
import br.com.wjaa.dao.VendaDao;

/**
 * 
 * @author Wagner
 *
 */
@Repository
public class VendaDaoImpl extends GenericDaoImpl<Venda, Integer> implements
		VendaDao {

	public VendaDaoImpl() {
		super(Venda.class);
	}

	@Override
	public Venda getVendaById(Integer idVenda) {
		
		return (Venda)this.getSession().get(Venda.class, idVenda);
		
		
	}

	@Override
	public Venda saveVenda(Venda venda) {
		venda = this.save(venda);
		this.getSession().flush();
		return this.get(venda.getId());
	}

	@Override
	public void removeAllVendaItem(Integer id) {
		String delete = "delete from venda_item where id_venda = :idVenda";
		this.getSession().createSQLQuery(delete).setInteger("idVenda", id).executeUpdate();
		
	}

	@Override
	public void removeAllVendaPrazo(Integer id) {
		String delete = "delete from venda_prazo where id_venda = :idVenda";
		this.getSession().createSQLQuery(delete).setInteger("idVenda", id).executeUpdate();
		
	}
	
	@Override
	public void removeAllVendaPagamento(Integer id) {
		String delete = "delete from venda_pagamento where id_venda = :idVenda";
		this.getSession().createSQLQuery(delete).setInteger("idVenda", id).executeUpdate();
		
	}

	@Override
	public List<VendaForm> buscaVenda(Date dataInicio, Date dataFim, String idVendedor,
			String idCliente) {
		
		StringBuilder sql = new StringBuilder();
		StringBuilder where = new StringBuilder();
		
		//*faz a busca das vendas*/
		sql.append(" select v.id, v.data_venda, cl.NOME_FULL,cl.loja, ve.nome, v.id_forma_pagamento, ");
		sql.append(" sum(vi.preco_unitario * vi.qtde) as valor_total from venda v " );
		sql.append(" left join venda_item vi on (vi.id_venda = v.id ) ");
		sql.append(" join cliente cl on (v.id_cliente = cl.id ) ");
		sql.append(" join vendedor ve ON (v.id_vendedor = ve.id) ");
		
		if (StringUtils.isNotBlank(idVendedor)){
			where.append(" where ve.id = :idVendedor ");
		}
		
		if (StringUtils.isNotBlank(idCliente)){
			
			if (where.length() == 0){
				where.append(" where ");
			}else{
				where.append(" and ");
			}
			where.append(" cl.id = :idCliente ");
		}
		
		if (dataInicio != null && dataFim != null){
			
			if (where.length() == 0){
				where.append(" where ");
			}else{
				where.append(" and ");
			}
			
			where.append(" v.data_venda between :dataInicio and :dataFim ");
		}
		
		if (where.length() == 0){
			sql.append(" where v.id < -1 ");
		}
		sql.append(where);
		sql.append(" group by 1, 2, 3 , 4, 5 "); 
		sql.append(" order by 2 desc, 1 ");
		
		Query q = this.getSession().createSQLQuery(sql.toString());
		
		if (StringUtils.isNotBlank(idVendedor)){
			q.setString("idVendedor", idVendedor);
		} 
		if (StringUtils.isNotBlank(idCliente)){
			q.setString("idCliente", idCliente);
		}
		if (dataInicio != null && dataFim != null){
			q.setDate("dataInicio", dataInicio);
			q.setDate("dataFim", dataFim);
		}
		
		Collection<?> result = q.list();
		
		return this.populaConsulta(result);
	}

	private List<VendaForm> populaConsulta(Collection<?> result) {
		
		List<VendaForm> vendas = new ArrayList<VendaForm>();
		if (CollectionUtils.isNotEmpty(result)){
			for (Object object : result) {
				Object[] dados = (Object[])object;
				VendaForm venda = new VendaForm();
				venda.setId((Integer)dados[0]);
				venda.setDataVenda((Date)dados[1]);
				venda.setNomeCliente((String)dados[2]);
				venda.setLoja((String)dados[3]);
				venda.setNomeVendedor((String)dados[4]);
				venda.setIdFormaPagamento((Integer)dados[5]);
				venda.setValorVenda((Double)dados[6]);
				vendas.add(venda);
			}
		}
		
		return vendas;
	}

	@Override
	public int getQtdeVendaAtrasada(Integer id) {
		StringBuilder sql = new StringBuilder();
		
		
		/*verifica se tem pgto a prazo atrasado*/
		sql.append(" select count(v.id) from venda v ");
		sql.append(" join venda_prazo vp on (vp.id_venda = v.id) ");
		sql.append(" where v.id = :idVenda and ");
		sql.append(" vp.data_vencimento < current_date ");
		sql.append(" and vp.pago = 0 ");
		
		
		return ((BigInteger)this.getSession().createSQLQuery(sql.toString())
				.setInteger("idVenda", id).uniqueResult()).intValue();
		
	}

	@Override
	public int getQtdeVendaNaoPaga(Integer id) {
		StringBuilder sql = new StringBuilder();
		/*verifica se está tudo pago*/
		sql.append(" select count(vp.id)  from venda_prazo vp ");
		sql.append(" where vp.id_venda = :idVenda ");
		sql.append(" and vp.pago = 0 ");

		
		return ((BigInteger)this.getSession().createSQLQuery(sql.toString())
				.setInteger("idVenda", id).uniqueResult()).intValue();
	}

	@Override
	public int getQtdeVendaVencendo(Integer id) {
		StringBuilder sql = new StringBuilder();
		
		/*verifica se tem pgto que vence hoje*/
		sql.append(" select count(v.id) from venda v ");
		sql.append(" join venda_prazo vp on (vp.id_venda = v.id) ");
		sql.append(" where v.id = :idVenda and ");
		sql.append(" vp.data_vencimento = current_date ");
		sql.append(" and vp.pago = 0 ");

		
		return ((BigInteger)this.getSession().createSQLQuery(sql.toString())
				.setInteger("idVenda", id).uniqueResult()).intValue();
	}

	@Override
	public int getVendaAtrasada(Integer id) {
		StringBuilder sql = new StringBuilder();
		/*venda avista atrasada*/
		sql.append(" select count(v.id)  from venda v ");
		sql.append(" where v.id = :idVenda ");
		sql.append(" and v.data_pgto is null ");
		
		return ((BigInteger)this.getSession().createSQLQuery(sql.toString())
				.setInteger("idVenda", id).uniqueResult()).intValue();
	}

	@Override
	public int getVendaNaoPaga(Integer id) {
		StringBuilder sql = new StringBuilder();
		/*venda avista liquidada*/
		sql.append(" select count(v.id)  from venda v ");
		sql.append(" where v.id = :idVenda ");
		sql.append(" and v.data_pgto is not null ");
		
		return ((BigInteger)this.getSession().createSQLQuery(sql.toString())
				.setInteger("idVenda", id).uniqueResult()).intValue();
	}

	@Override
	public void removeVenda(Integer idVenda) {
		String delete = "delete from venda where id = :idVenda";
		this.getSession().createSQLQuery(delete).setInteger("idVenda", idVenda).executeUpdate();
		
	}

	@Override
	public Collection<VendaItemForm> getVendaItem(Integer id) {
		StringBuilder sql = new StringBuilder();
		sql.append(" select concat(p.NOME , ' ' , p.TAMANHO , 'ml')as nomePerfume , ");
		sql.append(" i.preco_unitario ");
		sql.append(" from venda_item i "); 
		sql.append(" join perfume p ON i.id_perfume = p.id ");
		sql.append(" where i.id_venda = :idVenda ");
		sql.append(" order by 1 ");
		return this.populaVendaItemForm(this.getSession().createSQLQuery(sql.toString()).setInteger("idVenda", id).list());
	}

	private Collection<VendaItemForm> populaVendaItemForm(List<?> result) {
		Collection<VendaItemForm> vendaItems = new ArrayList<VendaItemForm>(); 
		for (Object o : result) {
			Object[] dados = (Object[]) o;
			VendaItemForm vif = new VendaItemForm();
			vif.setNomePerfume((String)dados[0]);
			vif.setPrecoUnitario((Double)dados[1]);
			vendaItems.add(vif);
		}
		return vendaItems;
	}

	@Override
	public Collection<VendaPrazoForm> getVendaPrazo(Integer id) {
		StringBuilder sql = new StringBuilder();
		sql.append(" select p.data_vencimento from venda_prazo p ");
		sql.append(" where p.id_venda = :idVenda ");
		sql.append(" order by 1 ");
		return this.populaVendaPrazoForm(this.getSession().createSQLQuery(sql.toString()).setInteger("idVenda", id).list());
		
	}

	private Collection<VendaPrazoForm> populaVendaPrazoForm(List<?> result) {
		Collection<VendaPrazoForm> vendaPrazos = new ArrayList<VendaPrazoForm>(); 
		for (Object o : result) {
			VendaPrazoForm vpf = new VendaPrazoForm();
			vpf.setDataVencimento((Date)o);
			vendaPrazos.add(vpf);
		}
		return vendaPrazos;
	}

	
	@Override
	public List<VendaPagamentoForm> getPagamentos(Integer idVenda) {
		StringBuilder sb = new StringBuilder();
		sb.append(" select vp.id, vp.data, vp.valor, vp.id_venda from venda_pagamento vp ");
		sb.append(" where vp.id_venda = :idVenda ");
		
		return this.populaVendaPagamentoForm(this.getSession().createSQLQuery(sb.toString()).setInteger("idVenda", idVenda).list());
	}

	private List<VendaPagamentoForm> populaVendaPagamentoForm(List<?> list) {
		List<VendaPagamentoForm> vendasPagamento = new ArrayList<VendaPagamentoForm>();
		
		for (Object object : list) {
			Object[] dados = (Object[])object;
			VendaPagamentoForm vpf = new VendaPagamentoForm();
			vpf.setId((Integer)dados[0]);
			vpf.setData((Date)dados[1]);
			vpf.setValor((Double)dados[2]);
			vpf.setIdVenda((Integer)dados[3]);
			vendasPagamento.add(vpf);
		}
		
		return vendasPagamento;
	}

	@Override
	public void savePagamento(VendaPagamento vp) {
		this.getSession().save(vp);
		
	}

	

}
