package br.com.wjaa.dao.impl;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import br.com.wjaa.arquitetura.dao.impl.GenericDaoImpl;
import br.com.wjaa.commons.model.entity.Perfume;
import br.com.wjaa.dao.PerfumeDao;

@Repository
public class PerfumeDaoImpl extends GenericDaoImpl<Perfume, Integer> implements PerfumeDao {

	public PerfumeDaoImpl() {
		super(Perfume.class);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Perfume> listPerfume(String marca, String nome) {
		Criteria crit = getSession().createCriteria(Perfume.class);
		
		if (StringUtils.isNotBlank(marca)){
			crit.add(Restrictions.like("marca", "%" + marca + "%"));	
		}
		
		if (StringUtils.isNotBlank(nome)){
			crit.add(Restrictions.like("nome", "%" + nome + "%"));	
		}
		
		crit.add(Restrictions.eq("ativo", true));	
 
	 return crit.list();
		
	}
	
}
