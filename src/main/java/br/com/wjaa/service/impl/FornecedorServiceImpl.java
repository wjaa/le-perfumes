package br.com.wjaa.service.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.wjaa.arquitetura.service.impl.GenericServiceImpl;
import br.com.wjaa.commons.model.entity.Fornecedor;
import br.com.wjaa.controller.impl.FornecedorForm;
import br.com.wjaa.dao.FornecedorDao;
import br.com.wjaa.service.FornecedorService;

@Service
public class FornecedorServiceImpl extends GenericServiceImpl<Fornecedor, Integer> 
implements FornecedorService{

	
	private FornecedorDao dao;
	
	@Autowired
	public FornecedorServiceImpl(FornecedorDao dao) {
		super(dao);
		this.dao = dao;
	}

	
	public void salvarFornecedor(FornecedorForm fornecedorForm) throws IllegalAccessException, InvocationTargetException {
		Fornecedor fornec = null;
		if (fornecedorForm.getId() != null && fornecedorForm.getId() > 0){
			fornec = this.dao.get(fornecedorForm.getId());
		}else{
			fornec = new Fornecedor();
		}
		fornec.setAtivo(true);
		BeanUtils.copyProperties(fornec, fornecedorForm);
		
		this.dao.save(fornec);
	}


	@Override
	public List<FornecedorForm> buscar(String nome) {
		List<Fornecedor> fornecedores = this.dao.buscar(nome);
		return FornecedorForm.toList(fornecedores);
		
	}


	@Override
	public FornecedorForm getFornecedorById(Integer id) {
		return new FornecedorForm(this.dao.get(id));
	}


	@Override
	public List<FornecedorForm> getAllFornecedorForm() {
		return FornecedorForm.toList(this.dao.getAllFornecedor());
		
	}


	@Override
	public void removeFornecedor(Integer idFornecedor) {
		Fornecedor fornecedor = this.get(idFornecedor);
		fornecedor.setAtivo(false);
		this.dao.save(fornecedor);
		
	}
	
	
	

}
