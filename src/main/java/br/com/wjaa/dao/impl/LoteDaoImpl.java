package br.com.wjaa.dao.impl;

import java.util.Collection;
import java.util.Collections;
import java.util.Date;

import org.hibernate.Criteria;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import br.com.wjaa.arquitetura.dao.impl.GenericDaoImpl;
import br.com.wjaa.commons.model.entity.Lote;
import br.com.wjaa.service.impl.LoteDao;

@Repository
public class LoteDaoImpl extends GenericDaoImpl<Lote, Integer> implements LoteDao {

	public LoteDaoImpl() {
		super(Lote.class);
	}

	@Override
	public void saveLote(Lote lote) {
		this.getSession().saveOrUpdate(lote);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Collection<Lote> buscar(Date dataInicio,Date dataFim, Integer idFornecedor) {
		Criteria crit = this.getSession().createCriteria(Lote.class);
		if (dataInicio != null && dataFim != null){
			crit.add(Restrictions.between("dataCompra", dataInicio, dataFim));
		}
		
		if (idFornecedor != null){
			crit.add(Restrictions.eq("fornecedor.id", idFornecedor));
		}
		
		if ( ( dataInicio != null && dataFim != null ) || idFornecedor != null){
			crit.setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY);
			return crit.list();
		}
		
		return Collections.EMPTY_LIST;
	}
	
	@Override
	public void removeLote(Integer idLote){
		String deleteProds = "delete from Lotexproduto where id_lote = :idLote";
		String deleteLote = "delete from Lote where id = :idLote";
		
		this.getSession().createSQLQuery(deleteProds).setInteger("idLote", idLote).executeUpdate();
		this.getSession().createSQLQuery(deleteLote).setInteger("idLote", idLote).executeUpdate();
	}

	

}
