package br.com.wjaa.dao;

import java.util.List;

import br.com.wjaa.arquitetura.dao.GenericDao;
import br.com.wjaa.commons.model.entity.Vendedor;

public interface VendedorDao extends GenericDao<Vendedor, Integer> {

	List<Vendedor> listVendedorByName(String name);
	
}
