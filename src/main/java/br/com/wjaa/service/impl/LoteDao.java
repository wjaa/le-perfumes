package br.com.wjaa.service.impl;

import java.util.Collection;
import java.util.Date;

import br.com.wjaa.arquitetura.dao.GenericDao;
import br.com.wjaa.commons.model.entity.Lote;

public interface LoteDao extends GenericDao<Lote, Integer> {

	void saveLote(Lote lote);

	Collection<Lote> buscar(Date data, Date dataF, Integer idFornecedor);

	void removeLote(Integer idLote);
	
}
