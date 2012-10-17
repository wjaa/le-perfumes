package br.com.wjaa.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.wjaa.arquitetura.service.impl.GenericServiceImpl;
import br.com.wjaa.commons.model.entity.Lote;
import br.com.wjaa.commons.model.entity.LoteProduto;
import br.com.wjaa.controller.impl.LoteForm;
import br.com.wjaa.controller.impl.LoteProdutoForm;
import br.com.wjaa.service.FornecedorService;
import br.com.wjaa.service.LoteService;

@Service
public class LoteServiceImpl extends GenericServiceImpl<Lote, Integer> implements
		LoteService {

	private LoteDao dao;
	
	@Autowired
	private FornecedorService fornecedorService;
	
	@Autowired
	public LoteServiceImpl(LoteDao loteDao) {
		super(loteDao);
		
		this.dao = loteDao;
	}

	@Override
	public LoteForm getLoteById(Integer id) {
		return new LoteForm(dao.get(id));
	}
	
	
	@Override
	public LoteForm getLoteByIdAndIdPerfume(Integer id, Integer idPerfume) {
		LoteForm  loteForm = new LoteForm(dao.get(id));
		
		for (LoteProdutoForm produto :loteForm.getLoteProdutoForm() ){
			if ( produto.getIdPerfume().equals(idPerfume) ){
				loteForm.setQtdeParcial(produto.getQuantidade());
				loteForm.setNomePerfume(produto.getNomePerfume());
				loteForm.setIdPerfume(idPerfume);
			}
		}
		return loteForm;
	}

	@Override
	public void saveLote(LoteForm form) {
		Lote lote = new Lote();
		
		if (form.getId() != null && form.getId() > 0){
			lote = this.get(form.getId());
		}
		
		lote.setDataCompra(form.getDataCompra());
		lote.setFornecedor(this.fornecedorService.get(form.getIdFornecedor()));
		lote.setObservacao(form.getObservacao());
		lote.setProdutos(null);
		lote = this.dao.save(lote);
		
		lote.setProdutos(this.getProdutos(form.getLoteProdutoForm(),lote.getId()));
		
		this.dao.saveLote(lote);
		
	}

	private List<LoteProduto> getProdutos(
			Collection<LoteProdutoForm> loteProdutoForm, Integer idLote) {
		List<LoteProduto> produtos = new ArrayList<LoteProduto>();
		
		if (CollectionUtils.isNotEmpty(loteProdutoForm)){
			for (LoteProdutoForm form : loteProdutoForm) {
				LoteProduto produto = new LoteProduto();
				
				produto.setIdPerfume(form.getIdPerfume());
				produto.setPreco(form.getPreco());
				produto.setQuantidade(form.getQuantidade());
				produto.setIdLote(idLote);
				produtos.add(produto);
			}
			
		}
		
		return produtos;
	}

	/**
	 * @param fornecedorService the fornecedorService to set
	 */
	public void setFornecedorService(FornecedorService fornecedorService) {
		this.fornecedorService = fornecedorService;
	}

	@Override
	public Collection<LoteForm> buscar(String dataInicio,String dataFim, String paramFornecedor) {
		Date dataIni = null;
		Date dataF = null;
		Integer idFornecedor = null;
		if (StringUtils.isNotBlank(dataInicio) && StringUtils.isNotBlank(dataFim) && 
				!"null".equals(dataInicio) && !"null".equals(dataFim)){
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			try {
				dataIni = sdf.parse(dataInicio);
				dataF = sdf.parse(dataFim);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		
		if (StringUtils.isNotBlank(paramFornecedor)){
			idFornecedor = Integer.valueOf(paramFornecedor);
		}
		
		return LoteForm.toList(this.dao.buscar(dataIni,dataF,idFornecedor));
		
	}

	@Override
	public void removeLote(Integer idLote) {
		this.dao.removeLote(idLote);
		
	}

}
