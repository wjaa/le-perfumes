package br.com.wjaa.service;

import java.util.List;

import br.com.wjaa.arquitetura.service.GenericService;
import br.com.wjaa.commons.model.entity.Venda;
import br.com.wjaa.controller.impl.VendaForm;
import br.com.wjaa.controller.impl.VendaPagamentoForm;
import br.com.wjaa.exception.BusinessException;

/**
 * 
 * @author Wagner
 *
 */
public interface VendaService extends GenericService<Venda, Integer> {

	VendaForm getVendaById(Integer idVenda);

	void saveVenda(VendaForm form) throws BusinessException;

	List<VendaForm> buscaVenda(String dataInicio, String dataFim, String idVendedor,
			String idCliente, String idStatus);

	void removerVenda(Integer valueOf);

	List<VendaPagamentoForm> getPagamentos(Integer valueOf);

	void savePagamentos(List<VendaPagamentoForm> pagamentos, Integer idVenda);
	
}
