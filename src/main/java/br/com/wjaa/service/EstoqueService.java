package br.com.wjaa.service;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import br.com.wjaa.arquitetura.service.GenericService;
import br.com.wjaa.commons.model.entity.EstoqueEntrada;
import br.com.wjaa.controller.impl.EstoqueAjusteSaidaForm;
import br.com.wjaa.controller.impl.EstoqueEntradaForm;
import br.com.wjaa.controller.impl.LoteForm;

/**
 * 
 * @author Wagner
 *
 */
public interface EstoqueService extends GenericService<EstoqueEntrada, Integer> {

	
	List<EstoqueEntradaForm> getEstoquePorVendedor();
	List<EstoqueEntradaForm> getEstoquePorPerfume();
	List<LoteForm> getEstoquePorLote(Integer integer);
	LoteForm getEstoquePorLoteAndPerfume(Integer idLote,
			Integer idPerfume);
	void saveEstoqueEntrada(Integer idLote, Integer idPerfume,
			Map<Integer, Integer> mapEntradaVendedores);
	void saveAjusteEstoque(Integer idLote, Integer idPerfume,
			Collection<EstoqueAjusteSaidaForm> ajustes);
	LoteForm getAjusteEstoquePorLoteAndPerfume(Integer idLote, Integer idPerfume);
	EstoqueEntradaForm getEstoquePorVendedorAndPerfume(Integer idVendedor,
			Integer idPerfume,Integer idVenda);
	
}
