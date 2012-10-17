package br.com.wjaa.dao;

import java.util.List;

import br.com.wjaa.arquitetura.dao.GenericDao;
import br.com.wjaa.commons.model.entity.Fornecedor;


public interface FornecedorDao extends GenericDao<Fornecedor, Integer> {

	List<Fornecedor> buscar(String nome);

	List<Fornecedor> getAllFornecedor();
	
	
}
