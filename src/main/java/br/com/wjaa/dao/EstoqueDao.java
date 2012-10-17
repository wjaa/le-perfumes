package br.com.wjaa.dao;

import java.util.List;

import br.com.wjaa.arquitetura.dao.GenericDao;
import br.com.wjaa.commons.model.entity.EstoqueAjusteSaida;
import br.com.wjaa.commons.model.entity.EstoqueEntrada;

public interface EstoqueDao extends GenericDao<EstoqueEntrada, Integer> {

	
	List<Object[]> listEstoquePorVendedor();
	
	
	List<Object[]> listEstoquePorLote(Integer idLote);


	List<Object[]> listEstoquePorLoteAndPerfume(Integer idLote,
			Integer idPerfume);
	
	
	List<Object[]> listEstoquePorPerfume();


	void removeAllAjustes(Integer idLote, Integer idPerfume);


	void saveAjuste(EstoqueAjusteSaida estoqueAjusteSaida);


	void removeAllEstoqueEntrada(Integer idLote, Integer idPerfume);


	List<Object[]> listAjusteEstoquePorLoteAndPerfume(Integer idLote,
			Integer idPerfume);


	List<Object[]> listEstoquePorVendedorAndPerfume(Integer idVendedor,
			Integer idPerfume, Integer idVenda);
	
}
