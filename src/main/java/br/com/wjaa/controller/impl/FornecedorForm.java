package br.com.wjaa.controller.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.collections.CollectionUtils;
import org.apache.struts.action.ActionForm;

import br.com.wjaa.commons.model.entity.Fornecedor;

public class FornecedorForm extends ActionForm {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1415897728516999545L;
	
	private Integer id;
	private String nome;
	private String endereco;
	private String telefone1;
	private String telefone2;
	private String email;
	private String site;
	private String contato;
	private String dadosPagamento;
	private String observacao;
	private String dispatch;
	
	public FornecedorForm(){
		
	}
	
	public FornecedorForm(Fornecedor fornecedor) {
		if (fornecedor != null){
			try {
				BeanUtils.copyProperties(this, fornecedor);
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			}
		}
		
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getTelefone1() {
		return telefone1;
	}
	public void setTelefone1(String telefone1) {
		this.telefone1 = telefone1;
	}
	public String getTelefone2() {
		return telefone2;
	}
	public void setTelefone2(String telefone2) {
		this.telefone2 = telefone2;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSite() {
		return site;
	}
	public void setSite(String site) {
		this.site = site;
	}
	public String getContato() {
		return contato;
	}
	public void setContato(String contato) {
		this.contato = contato;
	}
	public String getDadosPagamento() {
		return dadosPagamento;
	}
	public void setDadosPagamento(String dadosPagamento) {
		this.dadosPagamento = dadosPagamento;
	}
	public String getObservacao() {
		return observacao;
	}
	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}
	/**
	 * @return the endereco
	 */
	public String getEndereco() {
		return endereco;
	}
	/**
	 * @param endereco the endereco to set
	 */
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	public static List<FornecedorForm> toList(List<Fornecedor> fornecedores) {
		List<FornecedorForm> fornecedoresForm = new ArrayList<FornecedorForm>();
		if (CollectionUtils.isNotEmpty(fornecedores)){
			for (Fornecedor fornecedor : fornecedores) {
				fornecedoresForm.add(new FornecedorForm(fornecedor));
			}
		}
		
		return fornecedoresForm;
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
	
	
	

}
