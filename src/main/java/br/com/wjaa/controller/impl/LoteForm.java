package br.com.wjaa.controller.impl;

import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.struts.action.ActionForm;

import br.com.wjaa.commons.model.entity.Lote;
import br.com.wjaa.commons.model.entity.LoteProduto;

public class LoteForm extends ActionForm {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1044257869886784461L;

	private Integer id;
	private Date dataCompra;
	private Integer idFornecedor;
	private String observacao;
	private List<FornecedorForm> fornecedores;
	private Collection<PerfumeForm> perfumes;
	private String dispatch;
	private Collection<LoteProdutoForm> loteProdutoForm;
	private String[] perfume;
	private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	private List<EstoqueEntradaForm> estoqueEntradaForm;
	private List<EstoqueAjusteSaidaForm> estoqueAjusteSaidaForm;
	private Integer qtdeParcial;
	
	//usado apenas no cadastro de vendedorxqtde perfumes.
	private String nomePerfume;
	private Integer idPerfume;

	public LoteForm(){}
	
	public LoteForm(Lote lote) {
		if (lote != null){
			try {
				BeanUtils.copyProperties(this, lote);
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			}
			this.idFornecedor = lote.getFornecedor().getId();
			if (CollectionUtils.isNotEmpty(lote.getProdutos()) ){
				this.loteProdutoForm = new ArrayList<LoteProdutoForm>();
				for (LoteProduto produto : lote.getProdutos()) {
					this.loteProdutoForm.add(new LoteProdutoForm(produto));
				}
			}
		}
		
	}


	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}


	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}


	/**
	 * @return the dataCompra
	 */
	public Date getDataCompra() {
		return dataCompra;
	}
	
	public String getStrDataCompra() {
		if (dataCompra != null){
			return sdf.format(this.dataCompra);
		}
		return "";
	}

	public void setStrDataCompra(String strDate) {
		if (StringUtils.isNotBlank(strDate)){
			try {
				this.dataCompra = sdf.parse(strDate);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
	}


	/**
	 * @param dataCompra the dataCompra to set
	 */
	public void setDataCompra(Date dataCompra) {
		this.dataCompra = dataCompra;
	}


	/**
	 * @return the idFornecedor
	 */
	public Integer getIdFornecedor() {
		return idFornecedor;
	}


	/**
	 * @param idFornecedor the idFornecedor to set
	 */
	public void setIdFornecedor(Integer idFornecedor) {
		this.idFornecedor = idFornecedor;
	}


	/**
	 * @return the observacao
	 */
	public String getObservacao() {
		return observacao;
	}


	/**
	 * @param observacao the observacao to set
	 */
	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}


	/**
	 * @return the fornecedores
	 */
	public List<FornecedorForm> getFornecedores() {
		return fornecedores;
	}


	/**
	 * @param fornecedores the fornecedores to set
	 */
	public void setFornecedores(List<FornecedorForm> fornecedores) {
		this.fornecedores = fornecedores;
	}


	/**
	 * @return the dispatch
	 */
	public String getDispatch() {
		return dispatch;
	}


	/**
	 * @param dispatch the dispatch to set
	 */
	public void setDispatch(String dispatch) {
		this.dispatch = dispatch;
	}


	/**
	 * @return the perfumes
	 */
	public Collection<PerfumeForm> getPerfumes() {
		return perfumes;
	}


	/**
	 * @param perfumes the perfumes to set
	 */
	public void setPerfumes(Collection<PerfumeForm> perfumes) {
		this.perfumes = perfumes;
	}


	/**
	 * @return the loteProdutoForm
	 */
	public Collection<LoteProdutoForm> getLoteProdutoForm() {
		return loteProdutoForm;
	}


	/**
	 * @param loteProdutoForm the loteProdutoForm to set
	 */
	public void setLoteProdutoForm(Collection<LoteProdutoForm> loteProdutoForm) {
		this.loteProdutoForm = loteProdutoForm;
	}

	/**
	 * @return the perfume
	 */
	public String[] getPerfume() {
		return perfume;
	}

	/**
	 * @param perfume the perfume to set
	 */
	public void setPerfume(String[] perfume) {
		this.perfume = perfume;
	}

	
	@SuppressWarnings("unchecked")
	public static Collection<LoteForm> toList(Collection<Lote> lotes) {
		Collection<LoteForm> loteForm = Collections.EMPTY_LIST;
		
		if (CollectionUtils.isNotEmpty(lotes)){
			loteForm = new ArrayList<LoteForm>();
			for (Lote lote : lotes) {
				loteForm.add(new LoteForm(lote));
			}
		}
		
		return loteForm;
	}

	/**
	 * @return the estoqueEntradaForm
	 */
	public List<EstoqueEntradaForm> getEstoqueEntradaForm() {
		return estoqueEntradaForm;
	}

	/**
	 * @param estoqueEntradaForm the estoqueEntradaForm to set
	 */
	public void setEstoqueEntradaForm(List<EstoqueEntradaForm> estoqueEntradaForm) {
		this.estoqueEntradaForm = estoqueEntradaForm;
	}
	
	public void addEstoqueEntradaForm(EstoqueEntradaForm e){
		if (this.estoqueEntradaForm == null){
			this.estoqueEntradaForm = new ArrayList<EstoqueEntradaForm>();
		}
		this.estoqueEntradaForm.add(e);
	}

	/**
	 * @return the qtdeParcial
	 */
	public Integer getQtdeParcial() {
		return qtdeParcial;
	}

	/**
	 * @param qtdeParcial the qtdeParcial to set
	 */
	public void setQtdeParcial(Integer qtdeParcial) {
		this.qtdeParcial = qtdeParcial;
	}

	/**
	 * @return the nomePerfume
	 */
	public String getNomePerfume() {
		return nomePerfume;
	}

	/**
	 * @param nomePerfume the nomePerfume to set
	 */
	public void setNomePerfume(String nomePerfume) {
		this.nomePerfume = nomePerfume;
	}

	/**
	 * @return the idPerfume
	 */
	public Integer getIdPerfume() {
		return idPerfume;
	}

	/**
	 * @param idPerfume the idPerfume to set
	 */
	public void setIdPerfume(Integer idPerfume) {
		this.idPerfume = idPerfume;
	}

	/**
	 * @return the estoqueAjusteSaidaForm
	 */
	public List<EstoqueAjusteSaidaForm> getEstoqueAjusteSaidaForm() {
		return estoqueAjusteSaidaForm;
	}

	/**
	 * @param estoqueAjusteSaidaForm the estoqueAjusteSaidaForm to set
	 */
	public void setEstoqueAjusteSaidaForm(
			List<EstoqueAjusteSaidaForm> estoqueAjusteSaidaForm) {
		this.estoqueAjusteSaidaForm = estoqueAjusteSaidaForm;
	}

	
}
