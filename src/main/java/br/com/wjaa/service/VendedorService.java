package br.com.wjaa.service;

import java.util.List;

import br.com.wjaa.arquitetura.service.GenericService;
import br.com.wjaa.commons.model.entity.Vendedor;
import br.com.wjaa.controller.impl.VendedorForm;

public interface VendedorService extends GenericService<Vendedor, Integer>{

	VendedorForm getVendedorById(Integer idVendedor);
	
	List<VendedorForm> listVendedorByName(String nome);
	
	List<VendedorForm> listAllVendedor();
	
	void saveVendedor(VendedorForm vendedor);
	
	void removeVendedor(Integer idVendedor);
	
}
