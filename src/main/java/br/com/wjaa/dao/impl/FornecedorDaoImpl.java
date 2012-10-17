package br.com.wjaa.dao.impl;

import java.util.List;

import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import br.com.wjaa.arquitetura.dao.impl.GenericDaoImpl;
import br.com.wjaa.commons.model.entity.Fornecedor;
import br.com.wjaa.dao.FornecedorDao;

@Repository
public class FornecedorDaoImpl extends GenericDaoImpl<Fornecedor, Integer> implements
		FornecedorDao {

	public FornecedorDaoImpl() {
		super(Fornecedor.class);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Fornecedor> buscar(String nome) {
		return getSession().createCriteria(Fornecedor.class)
		.add(Restrictions.like("nome", "%" + nome + "%"))
		.add(Restrictions.eq("ativo", true))
		.list();
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Fornecedor> getAllFornecedor() {
		return getSession().createCriteria(Fornecedor.class)
		.add(Restrictions.eq("ativo", true))
		.list();
	}

}
