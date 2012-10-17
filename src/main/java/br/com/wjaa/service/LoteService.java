package br.com.wjaa.service;

import java.util.Collection;

import br.com.wjaa.arquitetura.service.GenericService;
import br.com.wjaa.commons.model.entity.Lote;
import br.com.wjaa.controller.impl.LoteForm;

public interface LoteService extends GenericService<Lote, Integer> {

	LoteForm getLoteById(Integer id);
	
	LoteForm getLoteByIdAndIdPerfume(Integer id, Integer idPerfume);

	void saveLote(LoteForm form);

	Collection<LoteForm> buscar(String paramData, String paramFornecedor, String paramFornecedor2);

	void removeLote(Integer valueOf);

}
