package br.com.wjaa.service.impl;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.wjaa.arquitetura.service.impl.GenericServiceImpl;
import br.com.wjaa.commons.model.entity.EstoqueAjusteSaida;
import br.com.wjaa.commons.model.entity.EstoqueEntrada;
import br.com.wjaa.controller.impl.EstoqueAjusteSaidaForm;
import br.com.wjaa.controller.impl.EstoqueEntradaForm;
import br.com.wjaa.controller.impl.LoteForm;
import br.com.wjaa.controller.impl.VendedorForm;
import br.com.wjaa.dao.EstoqueDao;
import br.com.wjaa.service.EstoqueService;

@Service
public class EstoqueServiceImpl extends
		GenericServiceImpl<EstoqueEntrada, Integer> implements EstoqueService {

	private EstoqueDao dao;
	
	@Autowired
	public EstoqueServiceImpl(EstoqueDao estoqueDao) {
		super(estoqueDao);
		this.dao = estoqueDao;
	}

	@Override
	public List<EstoqueEntradaForm> getEstoquePorVendedor() {
		return populaFormPorVendedor(this.dao.listEstoquePorVendedor());
	}
	
	@Override
	public LoteForm getEstoquePorLoteAndPerfume(Integer idLote,
			Integer idPerfume) {
		List<LoteForm> lotes = populaFormPorLote(this.dao.listEstoquePorLoteAndPerfume(idLote,idPerfume));
		return lotes.size() > 0 ? lotes.get(0) : new LoteForm();
	}
	
	

	@Override
	public List<LoteForm> getEstoquePorLote(Integer idLote) {
		return populaFormPorLote(this.dao.listEstoquePorLote(idLote));
	}


	
	private List<LoteForm> populaFormPorLote(List<Object[]> dados) {
		List<LoteForm> lotes = new ArrayList<LoteForm>();
		Map<Integer,LoteForm>  mapLotes = new HashMap<Integer, LoteForm>();
		Map<String,EstoqueEntradaForm>  mapEntradas = new HashMap<String, EstoqueEntradaForm>();
		if (CollectionUtils.isNotEmpty(dados)){
			for (Object[] d : dados) {
				LoteForm loteForm = mapLotes.get((Integer)d[0]);
				
				if (loteForm == null){
					loteForm = new LoteForm();
					loteForm.setId((Integer)d[0]);
					loteForm.setDataCompra((Date)d[1]);
					loteForm.setQtdeParcial((Integer)d[2]);
					lotes.add(loteForm);
					mapLotes.put((Integer)d[0], loteForm);
					
				}
				
				EstoqueEntradaForm estoque = mapEntradas.get(d[3].toString() + loteForm.getId().toString());
				if (estoque == null){
					estoque = new EstoqueEntradaForm();
					estoque.setQtdeLote((Integer)d[2]);
					estoque.setIdPerfume((Integer)d[3]);
					estoque.setNomePerfume((String)d[4]);
					mapEntradas.put(d[3].toString() + loteForm.getId().toString(), estoque);
					loteForm.addEstoqueEntradaForm(estoque);
					log.info("perfume " + (String)d[4] + " adicionado no lote " + loteForm.getId());
				}
				
				if ((Integer)d[5] != null){
					VendedorForm vendedor = new VendedorForm();
					vendedor.setId((Integer)d[5]);
					vendedor.setNome((String)d[6]);
					vendedor.setQtde(((BigInteger)d[7]).intValue());
					estoque.addVendedor(vendedor);
				}
				
				
			}
		}
		return lotes;
	}

	
	private List<EstoqueEntradaForm> populaFormPorVendedor(
			List<Object[]> dados) {
		List<EstoqueEntradaForm> estoqueEntrada = new ArrayList<EstoqueEntradaForm>();
		if (CollectionUtils.isNotEmpty(dados)){
			for (Object[] d : dados) {
				
				EstoqueEntradaForm estoque = new EstoqueEntradaForm();
				estoque.setIdPerfume((Integer)d[0]);
				estoque.setNomePerfume((String)d[1]);
				estoque.setIdVendedor((Integer)d[2]);
				estoque.setNomeVendedor((String)d[3]);
				estoque.setQtde(((BigDecimal)d[4]).intValue());
				estoqueEntrada.add(estoque);
			}
		}
		return estoqueEntrada;
	}

	@Override
	public void saveAjusteEstoque(Integer idLote, Integer idPerfume,
			Collection<EstoqueAjusteSaidaForm> ajustes) {
		
		this.dao.removeAllAjustes(idLote,idPerfume);
		
		if (CollectionUtils.isNotEmpty(ajustes)){
			for (EstoqueAjusteSaidaForm estoqueAjusteSaidaForm : ajustes) {
				EstoqueAjusteSaida estoqueAjusteSaida = new EstoqueAjusteSaida();
				estoqueAjusteSaida.setIdLote(idLote);
				estoqueAjusteSaida.setIdPerfume(idPerfume);
				estoqueAjusteSaida.setIdVendedor(estoqueAjusteSaidaForm.getIdVendedor());
				estoqueAjusteSaida.setObs(estoqueAjusteSaidaForm.getObs());
				estoqueAjusteSaida.setQtde(estoqueAjusteSaidaForm.getQtde());
				this.dao.saveAjuste(estoqueAjusteSaida);
			}
		}
		
		
		
	}

	@Override
	public void saveEstoqueEntrada(Integer idLote, Integer idPerfume,
			Map<Integer, Integer> mapEntradaVendedores) {
		
		this.dao.removeAllEstoqueEntrada(idLote,idPerfume);
		
		if (mapEntradaVendedores != null && mapEntradaVendedores.size() > 0){
			for (Integer idVendedor : mapEntradaVendedores.keySet()){
				EstoqueEntrada estoqueEntrada = new EstoqueEntrada();
				estoqueEntrada.setIdLote(idLote);
				estoqueEntrada.setIdPerfume(idPerfume);
				estoqueEntrada.setIdVendedor(idVendedor);
				estoqueEntrada.setQtde(mapEntradaVendedores.get(idVendedor));
				this.dao.save(estoqueEntrada);
			}
		}
		
		
	}

	@Override
	public LoteForm getAjusteEstoquePorLoteAndPerfume(Integer idLote,
			Integer idPerfume) {
		LoteForm loteForm = new LoteForm();
		loteForm.setId(idLote);
		loteForm.setIdPerfume(idPerfume);
		List<EstoqueAjusteSaidaForm> saidas = populaSaidaFormPorLote(this.dao.listAjusteEstoquePorLoteAndPerfume(idLote,idPerfume));
		loteForm.setEstoqueAjusteSaidaForm(saidas);
		return loteForm;
	}

	private List<EstoqueAjusteSaidaForm> populaSaidaFormPorLote(
			List<Object[]> listAjusteEstoquePorLoteAndPerfume) {
		List<EstoqueAjusteSaidaForm> saidas = new ArrayList<EstoqueAjusteSaidaForm>();
		for (Object[] dados : listAjusteEstoquePorLoteAndPerfume) {
			EstoqueAjusteSaidaForm saida = new EstoqueAjusteSaidaForm();
			saida.setNomeVendedor((String)dados[0]);
			saida.setIdVendedor((Integer)dados[1]);
			saida.setQtde((Integer)dados[2]);
			saida.setObs((String)dados[3]);
			saidas.add(saida);
		}
		
		return saidas;
	}

	@Override
	public List<EstoqueEntradaForm> getEstoquePorPerfume() {
		return populaFormPorPefume(this.dao.listEstoquePorPerfume());
	}

	private List<EstoqueEntradaForm> populaFormPorPefume(
			List<Object[]> dados) {
		
		List<EstoqueEntradaForm> estoqueEntrada = new ArrayList<EstoqueEntradaForm>();
		if (CollectionUtils.isNotEmpty(dados)){
			for (Object[] d : dados) {
				
				EstoqueEntradaForm estoque = new EstoqueEntradaForm();
				estoque.setIdPerfume((Integer)d[0]);
				estoque.setNomePerfume((String)d[1]);
				estoque.setQtde(((BigDecimal)d[2]).intValue());
				estoqueEntrada.add(estoque);
			}
		}
		return estoqueEntrada;
	}

	@Override
	public EstoqueEntradaForm getEstoquePorVendedorAndPerfume(
			Integer idVendedor, Integer idPerfume, Integer idVenda) {
		List<Object[]> result = this.dao.listEstoquePorVendedorAndPerfume(idVendedor,idPerfume, idVenda);
		return CollectionUtils.isEmpty(result)? null : populaFormPorVendedor(result).get(0);
		
	}
	
}
