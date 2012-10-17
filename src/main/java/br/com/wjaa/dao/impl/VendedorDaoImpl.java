package br.com.wjaa.dao.impl;

import java.util.List;

import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import br.com.wjaa.arquitetura.dao.impl.GenericDaoImpl;
import br.com.wjaa.commons.model.entity.Vendedor;
import br.com.wjaa.dao.VendedorDao;

@Repository
public class VendedorDaoImpl extends GenericDaoImpl<Vendedor, Integer> implements
		VendedorDao {

	public VendedorDaoImpl() {
		super(Vendedor.class);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Vendedor> listVendedorByName(String name) {
		return getSession().createCriteria(Vendedor.class)
		.add(Restrictions.like("nome", "%" + name + "%"))
		.add(Restrictions.like("ativo", true))
		.list();
		
	}
	
	 /**
     * {@inheritDoc}
     */
	@SuppressWarnings("unchecked")
	@Override
    public List<Vendedor> getAll() {
		return getSession().createCriteria(Vendedor.class)
		.add(Restrictions.like("ativo", true))
		.list();
    }

	

}
