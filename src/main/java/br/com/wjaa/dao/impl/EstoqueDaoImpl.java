package br.com.wjaa.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.wjaa.arquitetura.dao.impl.GenericDaoImpl;
import br.com.wjaa.commons.model.entity.EstoqueAjusteSaida;
import br.com.wjaa.commons.model.entity.EstoqueEntrada;
import br.com.wjaa.dao.EstoqueDao;

@Repository
public class EstoqueDaoImpl extends GenericDaoImpl<EstoqueEntrada, Integer>
		implements EstoqueDao {

	public EstoqueDaoImpl() {
		super(EstoqueEntrada.class);

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Object[]> listEstoquePorVendedor() {
		StringBuilder sql = new StringBuilder();
		
		sql.append(" select e.id_perfume, ");  
		sql.append("   concat(p.NOME , ' ' , p.TAMANHO , 'ml')as nomePerfume, e.id_vendedor, v.nome as nomeVendedor, ");  
		sql.append(" (IFNULL(sum(e.qtde),0) -  ");
		sql.append(" IFNULL((select sum(esaida.qtde) from estoque_ajuste_saida esaida ");
		sql.append(" where esaida.id_perfume = e.id_perfume and esaida.id_vendedor = e.id_vendedor),0) - "); 
		sql.append(" IFNULL((select sum(vi.qtde) from venda_item vi  ");
		sql.append(" join venda vixv on (vixv.id = vi.id_venda ) ");
		sql.append(" where vi.id_perfume = e.id_perfume and vixv.id_vendedor = v.id),0)) as qtdeTotal ");
		sql.append(" from estoque_entrada e  ");
		sql.append(" join vendedor v on (v.id = e.id_vendedor ) "); 
		sql.append(" join perfume p on (p.id = e.id_perfume )  ");
		sql.append(" left join estoque_ajuste_saida esaida on (esaida.id_lote = e.id_lote and ");  
		sql.append(" esaida.id_perfume = e.id_perfume and  ");
		sql.append(" esaida.id_vendedor = e.id_vendedor )  ");
		sql.append(" group by 1,3  ");
		sql.append(" order by 2  ");
		
		return getSession().createSQLQuery(sql.toString()).list();  
		
	}
	
	
	@SuppressWarnings("unchecked")
	public List<Object[]> listEstoquePorLote(Integer idLote){
		StringBuilder sql = new StringBuilder();
		sql.append(" select distinct l.id as idLote, l.data_compra, lp.quantidade, lp.id_perfume, "); 
		sql.append(" concat(p.NOME , ' ' , p.TAMANHO , 'ml')as nomePerfume, e.id_vendedor, v.nome as nomeVendedor, "); 
		sql.append(" IFNULL(e.qtde,0) as qtdeTotal ");  
		sql.append(" from lote l ");
		sql.append(" join lotexproduto lp on (lp.id_lote = l.id) ");
		sql.append(" join perfume p on (p.id = lp.id_perfume ) ");
		sql.append(" left join estoque_entrada e on (e.id_lote = l.id and lp.id_perfume = e.id_perfume) ");
		sql.append(" left join vendedor v on (v.id = e.id_vendedor ) ");
		sql.append(" where l.id = :idLote ");
		sql.append(" order by 1, 2 desc,5 ");
		
		return getSession().createSQLQuery(sql.toString()).setInteger("idLote", idLote).list();
	}
	
	
	

	@SuppressWarnings("unchecked")
	@Override
	public List<Object[]> listEstoquePorLoteAndPerfume(Integer idLote,
			Integer idPerfume) {
		StringBuilder sql = new StringBuilder();
		sql.append(" select distinct l.id as idLote, l.data_compra, lp.quantidade, lp.id_perfume, "); 
		sql.append(" concat(p.NOME , ' ' , p.TAMANHO , 'ml')as nomePerfume, e.id_vendedor, v.nome as nomeVendedor, "); 
		sql.append(" IFNULL(e.qtde,0) as qtdeVendedor ");  
		sql.append(" from lote l ");
		sql.append(" join lotexproduto lp on (lp.id_lote = l.id) ");
		sql.append(" join perfume p on (p.id = lp.id_perfume ) ");
		sql.append(" left join estoque_entrada e on (e.id_lote = l.id and lp.id_perfume = e.id_perfume) ");
		sql.append(" left join vendedor v on (v.id = e.id_vendedor ) ");
		sql.append(" left join estoque_ajuste_saida esaida on (esaida.id_lote = l.id and "); 
		sql.append(" esaida.id_perfume = e.id_perfume and  ");
		sql.append(" esaida.id_vendedor = e.id_vendedor ) ");
		sql.append(" left join venda_item vi on (vi.id_perfume = e.id_perfume ) ");
		sql.append(" where e.id_lote = :idLote and e.id_perfume = :idPerfume");
		sql.append(" order by 1, 2 desc,5 ");
		
		return getSession().createSQLQuery(sql.toString())
		.setInteger("idLote", idLote)
		.setInteger("idPerfume", idPerfume)
		.list();
	}

	@Override
	public void removeAllAjustes(Integer idLote, Integer idPerfume) {
		String delete = "delete from ESTOQUE_AJUSTE_SAIDA where id_lote = :idLote and id_perfume = :idPerfume";
		
		this.getSession().createSQLQuery(delete)
		.setInteger("idLote", idLote)
		.setInteger("idPerfume", idPerfume)
		.executeUpdate();
		
	}

	@Override
	public void removeAllEstoqueEntrada(Integer idLote, Integer idPerfume) {
		String delete = "delete from ESTOQUE_ENTRADA where id_lote = :idLote and id_perfume = :idPerfume";
		
		this.getSession().createSQLQuery(delete)
		.setInteger("idLote", idLote)
		.setInteger("idPerfume", idPerfume)
		.executeUpdate();
		
	}

	@Override
	public void saveAjuste(EstoqueAjusteSaida estoqueAjusteSaida) {
		this.getSession().saveOrUpdate(estoqueAjusteSaida);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Object[]> listAjusteEstoquePorLoteAndPerfume(Integer idLote,
			Integer idPerfume) {
		String sql  = " select v.nome, s.id_vendedor, s.qtde, s.obs from estoque_ajuste_saida s " +
					  " join vendedor v ON s.id_vendedor = v.id " +
					  " where s.id_perfume = :idPerfume and s.id_lote = :idLote ";
		
		return this.getSession().createSQLQuery(sql).
		setInteger("idPerfume", idPerfume)
		.setInteger("idLote", idLote)
		.list();

	}

	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings("unchecked")
	public List<Object[]> listEstoquePorPerfume(){
		StringBuilder sql = new StringBuilder();
		
		sql.append(" select p.id, ");  
		sql.append(" concat(p.NOME , ' ' , p.TAMANHO , 'ml')as nomePerfume, "); 
		sql.append(" (IFNULL(sum(e.qtde),0) -  ");
		sql.append(" IFNULL((select sum(esaida.qtde) from estoque_ajuste_saida esaida "); 
		sql.append(" where esaida.id_perfume = e.id_perfume),0)- ");
		sql.append(" IFNULL((select sum(vi.qtde) from venda_item vi  ");
		sql.append(" where vi.id_perfume = e.id_perfume),0)) as qtdeTotal "); 
		sql.append(" from  perfume p "); 
		sql.append(" left join estoque_entrada e on (e.id_perfume = p.id) ");
		sql.append(" group by 1 ");
		sql.append(" order by 2 "); 
		
		return getSession().createSQLQuery(sql.toString()).list(); 
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Object[]> listEstoquePorVendedorAndPerfume(Integer idVendedor,
			Integer idPerfume, Integer idVenda) {
		StringBuilder sql = new StringBuilder();
		
		sql.append(" select e.id_perfume, ");  
		sql.append("   concat(p.NOME , ' ' , p.TAMANHO , 'ml')as nomePerfume, e.id_vendedor, v.nome as nomeVendedor, ");  
		sql.append(" (IFNULL(sum(e.qtde),0) -  ");
		sql.append(" IFNULL((select sum(esaida.qtde) from estoque_ajuste_saida esaida ");
		sql.append(" where esaida.id_perfume = e.id_perfume and esaida.id_vendedor = e.id_vendedor),0) - "); 
		sql.append(" IFNULL((select sum(vi.qtde) from venda_item vi  ");
		sql.append(" join venda vixv on (vixv.id = vi.id_venda ) ");
		sql.append(" where vi.id_perfume = e.id_perfume and vixv.id_vendedor = v.id and vixv.id != :idVenda ),0)) as qtdeTotal ");
		sql.append(" from estoque_entrada e  ");
		sql.append(" join vendedor v on (v.id = e.id_vendedor ) "); 
		sql.append(" join perfume p on (p.id = e.id_perfume )  ");
		sql.append(" left join estoque_ajuste_saida esaida on (esaida.id_lote = e.id_lote and ");  
		sql.append(" esaida.id_perfume = e.id_perfume and  ");
		sql.append(" esaida.id_vendedor = e.id_vendedor )  ");
		sql.append(" where e.id_perfume = :idPerfume and e.id_vendedor = :idVendedor ");
		sql.append(" group by 1,3  ");
		sql.append(" order by 2  ");
		
		return getSession().createSQLQuery(sql.toString())
			.setInteger("idPerfume", idPerfume)
			.setInteger("idVendedor", idVendedor)
			.setInteger("idVenda", idVenda)
			.list();  
	}

}
