package br.com.wjaa.dao.impl;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import br.com.wjaa.arquitetura.dao.impl.GenericDaoImpl;
import br.com.wjaa.commons.model.entity.Cliente;
import br.com.wjaa.dao.ClienteDao;

@Repository
public class ClienteDaoImpl extends GenericDaoImpl<Cliente, Integer> implements ClienteDao{
	
	public ClienteDaoImpl() {
		super(Cliente.class);
	}

	@Override
	public Cliente getClienteByCpf(String cpf) {
		Criteria crit = getSession().createCriteria(Cliente.class);
		crit.add(Restrictions.eq("cpf", cpf));
		crit.add(Restrictions.eq("ativo", true));
		return (Cliente)crit.uniqueResult();
	}
	
	
	@SuppressWarnings("unchecked")
	public List<Cliente> buscaCliente(String nome, String cpf, String fone, String localTrab){
		Criteria crit = getSession().createCriteria(Cliente.class);
		
			
		if(StringUtils.isNotBlank(nome)){
			crit.add(Restrictions.like("nomeFull", "%" + nome + "%"));
		}
		if(StringUtils.isNotBlank(cpf)){
			crit.add(Restrictions.like("cpf", "%" + cpf + "%"));
		}
		if(StringUtils.isNotBlank(fone)){
			crit.add(Restrictions.like("fone1", "%" + fone + "%"));
		}
		if(StringUtils.isNotBlank(localTrab)){
			crit.add(Restrictions.like("localTrabalho","%" +  localTrab + "%"));	
		}
		
		crit.add(Restrictions.eq("ativo", true));
		return crit.list();
	}

}
