package br.com.wjaa.service;

import java.text.ParseException;
import java.util.Collection;
import br.com.wjaa.arquitetura.service.GenericService;
import br.com.wjaa.commons.model.entity.Cliente;
import br.com.wjaa.controller.impl.ClienteForm;
import br.com.wjaa.service.impl.ClienteVo;
import br.com.wjaa.service.impl.ModeloBuscaCliente;


/**
 * 
 * @author Wagner
 *
 */
public interface ClienteService extends GenericService<Cliente, Integer> {

	public boolean salvarCliente(ClienteForm form)throws Exception;

	public boolean exixteCliente(ClienteForm clienteForm) throws Exception ;

	
	public boolean editaCliente(ClienteForm clienteForm) throws Exception;
	
	
	public ModeloBuscaCliente buscaCliente(ClienteForm form);
	
	public ClienteVo buscaClienteEdicao(String idCliente) throws NumberFormatException, ParseException;

	public void removeCliente(Integer valueOf);

	public Collection<ClienteForm> getAllCliente();
	
}
