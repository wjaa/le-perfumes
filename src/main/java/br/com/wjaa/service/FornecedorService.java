package br.com.wjaa.service;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import br.com.wjaa.arquitetura.service.GenericService;
import br.com.wjaa.commons.model.entity.Fornecedor;
import br.com.wjaa.controller.impl.FornecedorForm;

public interface FornecedorService extends GenericService<Fornecedor, Integer> {

	public void salvarFornecedor(FornecedorForm fornecedorForm) throws IllegalAccessException, InvocationTargetException ;

	public List<FornecedorForm> buscar(String nome);

	public FornecedorForm getFornecedorById(Integer valueOf);

	public List<FornecedorForm> getAllFornecedorForm();

	public void removeFornecedor(Integer valueOf);
	
}
