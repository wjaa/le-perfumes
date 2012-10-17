package br.com.wjaa.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.wjaa.arquitetura.service.impl.GenericServiceImpl;
import br.com.wjaa.commons.model.entity.Cliente;
import br.com.wjaa.commons.model.entity.Perfume;
import br.com.wjaa.commons.model.entity.Venda;
import br.com.wjaa.commons.model.entity.VendaItem;
import br.com.wjaa.commons.model.entity.VendaPagamento;
import br.com.wjaa.commons.model.entity.VendaPrazo;
import br.com.wjaa.commons.model.entity.Vendedor;
import br.com.wjaa.controller.impl.ClienteForm;
import br.com.wjaa.controller.impl.EstoqueEntradaForm;
import br.com.wjaa.controller.impl.PerfumeForm;
import br.com.wjaa.controller.impl.VendaForm;
import br.com.wjaa.controller.impl.VendaItemForm;
import br.com.wjaa.controller.impl.VendaPagamentoForm;
import br.com.wjaa.controller.impl.VendaPrazoForm;
import br.com.wjaa.controller.impl.VendedorForm;
import br.com.wjaa.dao.VendaDao;
import br.com.wjaa.exception.BusinessException;
import br.com.wjaa.service.ClienteService;
import br.com.wjaa.service.EstoqueService;
import br.com.wjaa.service.PerfumeService;
import br.com.wjaa.service.VendaService;
import br.com.wjaa.service.VendedorService;

@Service
public class VendaServiceImpl extends GenericServiceImpl<Venda, Integer>
		implements VendaService {

	private VendaDao vendaDao;
	
	@Autowired
	private ClienteService clienteService;
	@Autowired
	private VendedorService vendedorService;
	@Autowired
	private PerfumeService perfumeService;
	
	@Autowired
	private EstoqueService estoqueService;
	
	
	@Autowired
	public VendaServiceImpl(VendaDao vendaDao) {
		super(vendaDao);
		this.vendaDao = vendaDao;
	}


	@Override
	public VendaForm getVendaById(Integer idVenda) {
		VendaForm vendaForm = new VendaForm();
		if (idVenda != null){
			Venda venda = vendaDao.getVendaById(idVenda);
			vendaForm.populate(venda);
			
			VendedorForm vendedorForm = this.vendedorService.getVendedorById(venda.getIdVendedor());
			vendaForm.setNomeVendedor(vendedorForm.getNome());
			
			Cliente cliente = this.clienteService.get(venda.getIdCliente());
			vendaForm.setNomeCliente(cliente.getNomeFull());
			vendaForm.setVendaItem(new ArrayList<VendaItemForm>());
			
			if (CollectionUtils.isNotEmpty(venda.getVendaItem())){
				for (VendaItem vendaItem : venda.getVendaItem()){
					VendaItemForm vendaItemForm = new VendaItemForm();
					vendaItemForm.setId(vendaItem.getId());
					vendaItemForm.setIdPerfume(vendaItem.getIdPerfume());
					vendaItemForm.setIdVenda(vendaItem.getIdVenda());
					
					Perfume perfume = this.perfumeService.get(vendaItem.getIdPerfume());
					vendaItemForm.setNomePerfume(perfume.getNome() + " - " + perfume.getTamanho() + "ml");
					vendaItemForm.setPrecoUnitario(vendaItem.getPrecoUnitario());
					vendaItemForm.setQtde(vendaItem.getQtde());
					vendaForm.getVendaItem().add(vendaItemForm);
				}
			}
			
			vendaForm.setVendaPrazo(new TreeSet<VendaPrazoForm>());
			if(CollectionUtils.isNotEmpty(venda.getVendaPrazo())){
				for (VendaPrazo vendaPrazo : venda.getVendaPrazo()){
					VendaPrazoForm vendaPrazoForm = new VendaPrazoForm();
					vendaPrazoForm.setDataVencimento(vendaPrazo.getDataVencimento());
					vendaPrazoForm.setDias(vendaPrazo.getDias());
					vendaPrazoForm.setId(vendaPrazo.getId());
					vendaPrazoForm.setIdVenda(vendaPrazo.getIdVenda());
					vendaPrazoForm.setPago(vendaPrazo.getPago());
					vendaForm.getVendaPrazo().add(vendaPrazoForm);
				}
			}
			
		}
		
		vendaForm.setClientes(new ArrayList<ClienteForm>());
		vendaForm.getClientes().addAll(this.clienteService.getAllCliente());
		
		vendaForm.setVendedores(new ArrayList<VendedorForm>());
		vendaForm.getVendedores().addAll(this.vendedorService.listAllVendedor());
		
		vendaForm.setPerfumes(new ArrayList<PerfumeForm>());
		vendaForm.getPerfumes().addAll(this.perfumeService.getAllPerfumeForm());
		
		return vendaForm;
	}


	@Override
	public void saveVenda(VendaForm form) throws BusinessException {
		
		this.verificaPerfumeEstoque(form);
		
		
		Venda venda = null;
		if (form.getId() == null || form.getId() < 1){
			venda = new Venda();
		}else{
			venda = this.get(form.getId());
		}
		
		venda.setDataVenda(form.getDataVenda());
		venda.setDataPgto(form.getDataPgto());
		venda.setIdCliente(form.getIdCliente());
		venda.setIdFormaPagamento(form.getIdFormaPagamento());
		venda.setIdVendedor(form.getIdVendedor());
		venda.setObs(form.getObs());
		venda.setValorVenda(this.getValorVenda(form.getVendaItem()));
		
		if (venda.getId() != null && venda.getId() > 0){
			this.vendaDao.removeAllVendaItem(venda.getId());
			this.vendaDao.removeAllVendaPrazo(venda.getId());
		}
		
		
		venda = this.vendaDao.saveVenda(venda);
		Integer idVenda = venda.getId();
		
		venda.setVendaItem(this.getVendaItem(form.getVendaItem(), idVenda));
		venda.setVendaPrazo(this.getVendaPrazo(form.getVendaPrazo(), idVenda));
		
		this.vendaDao.saveVenda(venda);
	}


	private void verificaPerfumeEstoque(VendaForm form) throws BusinessException{
		Integer idVendedor = form.getIdVendedor();
		
		for(VendaItemForm viform : form.getVendaItem()){
			EstoqueEntradaForm estoque = this.estoqueService.getEstoquePorVendedorAndPerfume(idVendedor,viform.getIdPerfume(),
					form.getId() == null ? 0 : form.getId());
			
			if ( estoque == null ){
				estoque = new EstoqueEntradaForm();
				estoque.setQtde(0);
			}
			//se o estoque estiver vazio ou a quantidade for menor que vendida.
			if (estoque.getQtde() < viform.getQtde()){
				Vendedor v = vendedorService.get(idVendedor);
				Perfume p = perfumeService.get(viform.getIdPerfume());
				throw new BusinessException("O vendedor <b>" + v.getNome() + "</b>, tem apenas <b>" +
						estoque.getQtde() + " " + p.getNome() + "</b> em seu estoque. \nVerifique a quantidade de perfumes ou ajuste o estoque.");
			}
		}
		
	}


	private Set<VendaPrazo> getVendaPrazo(Collection<VendaPrazoForm> vendaPrazoForm, Integer idVenda) {
		Set<VendaPrazo> vendasPrazo = new HashSet<VendaPrazo>();
		if (CollectionUtils.isNotEmpty(vendaPrazoForm)){
			for (VendaPrazoForm prazoForm : vendaPrazoForm) {
				VendaPrazo prazo =  new VendaPrazo();
				prazo.setDataVencimento(prazoForm.getDataVencimento());
				prazo.setDias(prazoForm.getDias());
				prazo.setIdVenda(idVenda);
				prazo.setPago(prazoForm.getPago());
				
				vendasPrazo.add(prazo);
			}
		}
		return vendasPrazo;
	}


	private Set<VendaItem> getVendaItem(Collection<VendaItemForm> vendaItem, Integer idVenda) {
		Set<VendaItem> vendasItem = new HashSet<VendaItem>();
		if (CollectionUtils.isNotEmpty(vendaItem)){
			for (VendaItemForm vendaItemForm : vendaItem) {
				VendaItem item = new VendaItem();
				item.setIdPerfume(vendaItemForm.getIdPerfume());
				item.setIdVenda(idVenda);
				item.setPrecoUnitario(vendaItemForm.getPrecoUnitario());
				item.setQtde(vendaItemForm.getQtde());
				vendasItem.add(item);
			}
		}
		return vendasItem;
	}


	private Double getValorVenda(Collection<VendaItemForm> vendaItem) {
		Double total = 0.0;
		if (CollectionUtils.isNotEmpty(vendaItem)){
			for (VendaItemForm vendaItemForm : vendaItem) {
				total += vendaItemForm.getQtde() * vendaItemForm.getPrecoUnitario();
			}
		}
		return total;
	}


	@Override
	public List<VendaForm> buscaVenda(String dataInicio, String dataFim, String idVendedor,
			String idCliente, String idStatus) {
		
		Date dtInicio = null;
		Date dtFim = null;
		
		if (StringUtils.isNotBlank(dataInicio) &&  StringUtils.isNotBlank(dataFim)){
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			try {
				dtInicio = sdf.parse(dataInicio);
				dtFim = sdf.parse(dataFim);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			
		}
		
		List<VendaForm> vendas = this.vendaDao.buscaVenda(dtInicio, dtFim, idVendedor, idCliente);
		
		if (CollectionUtils.isNotEmpty(vendas)){
			for (VendaForm vendaForm : vendas) {
				vendaForm.setStatusVenda(VendaForm.ABERTO);
				Collection<VendaPrazoForm> prazos = this.vendaDao.getVendaPrazo(vendaForm.getId());
				List<VendaPagamentoForm> pagamentos = this.vendaDao.getPagamentos(vendaForm.getId());
				//verificando o status da venda a vista
				if ( vendaForm.getIdFormaPagamento() == 1 ){
					
					//verificando primeiro se a venda nao foi liquidada
					double totalPagamentos = 0.0;
					for (VendaPagamentoForm pgto : pagamentos) {
						totalPagamentos += pgto.getValor();
					}
					
					if (totalPagamentos >= vendaForm.getValorVenda()){
						vendaForm.setStatusVenda(VendaForm.LIQUIDADO);
					}else{
						vendaForm.setStatusVenda(VendaForm.ATRASADO);
					}
					
				}else{
					
					//verificando o status da venda a prazo.
					
					
					int status = this.getStatus(pagamentos,prazos,vendaForm.getValorVenda());
					
					/*if (this.vendaDao.getQtdeVendaAtrasada(vendaForm.getId()) > 0){
						vendaForm.setStatusVenda(VendaForm.ATRASADO);
					}else if (this.vendaDao.getQtdeVendaVencendo(vendaForm.getId()) > 0){
						vendaForm.setStatusVenda(VendaForm.VENCENDO);
					}else if (this.vendaDao.getQtdeVendaNaoPaga(vendaForm.getId()) == 0){
						vendaForm.setStatusVenda(VendaForm.LIQUIDADO);
					}*/
					vendaForm.setStatusVenda(status);
				}
				
				vendaForm.setVendaItem(this.vendaDao.getVendaItem(vendaForm.getId()));
				vendaForm.setVendaPrazo(prazos);
								
			}
		}
		
		if (StringUtils.isNotBlank(idStatus)){
			return this.filtraStatus(Integer.valueOf(idStatus),vendas);
		}
		return  vendas;
	}


	private int getStatus(List<VendaPagamentoForm> pagamentos,
			Collection<VendaPrazoForm> prazos, double totalVenda) {
		
		
		//verificando primeiro se a venda nao foi liquidada
		double totalPagamentos = 0.0;
		for (VendaPagamentoForm pgto : pagamentos) {
			totalPagamentos += pgto.getValor();
		}
		
		if (totalPagamentos >= totalVenda){
			return VendaForm.LIQUIDADO;
		}
		
		
		int status = VendaForm.ABERTO;
		Date dataHoje = new Date();
		int contPrazo = 1;
		
		for (VendaPrazoForm vendaPrazoForm : prazos) {
			//se a data de hj for depois do vencimento 
			if ( dataHoje.after(vendaPrazoForm.getDataVencimento())){
				//TODO aqui é um chute.
				//porque eu nao sei se pagamento se refere ao prazo.
				if (contPrazo <= pagamentos.size()){
					
					//nao está vencida porque ha pagamentos 
					vendaPrazoForm.setVencida(false);
					vendaPrazoForm.setPago(true);
				}else{
					vendaPrazoForm.setVencida(true);
					status = VendaForm.ATRASADO;
				}
			}else{
				if (contPrazo <= pagamentos.size()){
					
					//nao está vencida porque ha pagamentos 
					vendaPrazoForm.setVencida(false);
					vendaPrazoForm.setPago(true);
				}
			}
			
			contPrazo++;
		}
		
		return status;
	}


	private List<VendaForm> filtraStatus(Integer idStatus, List<VendaForm> vendas) {
		List<VendaForm> vendasFiltradas = new ArrayList<VendaForm>();
		for (VendaForm vendaForm : vendas) {
			if (idStatus.equals(vendaForm.getStatusVenda())){
				vendasFiltradas.add(vendaForm);
			}
		}
		
		return vendasFiltradas;
	}


	@Override
	public void removerVenda(Integer idVenda) {
		this.vendaDao.removeAllVendaItem(idVenda);
		this.vendaDao.removeAllVendaPrazo(idVenda);
		this.vendaDao.removeAllVendaPagamento(idVenda);
		this.vendaDao.removeVenda(idVenda);
		
	}


	@Override
	public List<VendaPagamentoForm> getPagamentos(Integer idVenda) {
		return this.vendaDao.getPagamentos(idVenda);
	}


	@Override
	public void savePagamentos(List<VendaPagamentoForm> pagamentos, Integer idVenda) {
		this.vendaDao.removeAllVendaPagamento(idVenda);
		for (VendaPagamentoForm vendaPagamentoForm : pagamentos) {
			VendaPagamento vp = new VendaPagamento();
			vp.setData(vendaPagamentoForm.getData());
			vp.setValor(vendaPagamentoForm.getValor());
			vp.setIdVenda(idVenda);
			this.vendaDao.savePagamento(vp);
		}
		
	}
	
	
}
