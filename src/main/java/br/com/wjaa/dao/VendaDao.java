package br.com.wjaa.dao;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import br.com.wjaa.arquitetura.dao.GenericDao;
import br.com.wjaa.commons.model.entity.Venda;
import br.com.wjaa.commons.model.entity.VendaPagamento;
import br.com.wjaa.controller.impl.VendaForm;
import br.com.wjaa.controller.impl.VendaItemForm;
import br.com.wjaa.controller.impl.VendaPagamentoForm;
import br.com.wjaa.controller.impl.VendaPrazoForm;

/**
 * 
 * @author Wagner
 *
 */
public interface VendaDao extends GenericDao<Venda, Integer> {

	Venda getVendaById(Integer idVenda);
	
	Venda saveVenda(Venda venda);

	void removeAllVendaItem(Integer id);

	void removeAllVendaPrazo(Integer id);
	
	void removeAllVendaPagamento(Integer id);

	List<VendaForm> buscaVenda(Date dataInicio, Date dataFim, String idVendedor,
			String idCliente);

	int getQtdeVendaAtrasada(Integer id);

	int getQtdeVendaVencendo(Integer id);

	int getQtdeVendaNaoPaga(Integer id);

	int getVendaAtrasada(Integer id);

	int getVendaNaoPaga(Integer id);

	void removeVenda(Integer idVenda);

	Collection<VendaItemForm> getVendaItem(Integer id);

	Collection<VendaPrazoForm> getVendaPrazo(Integer id);

	List<VendaPagamentoForm> getPagamentos(Integer idVenda);

	void savePagamento(VendaPagamento vp);
	

}
