package br.com.wjaa.controller.impl;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;

import br.com.wjaa.commons.model.entity.LoteProduto;

public class LoteProdutoForm {

	private Integer id;
	private Double preco;
	private Integer quantidade;
	private String nomePerfume;
	private String tamanho;
	private Integer idPerfume;
	
	
	public LoteProdutoForm(){}
	public LoteProdutoForm(LoteProduto loteProduto){
		try {
			BeanUtils.copyProperties(this, loteProduto);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		this.idPerfume = loteProduto.getIdPerfume();
		this.nomePerfume = loteProduto.getPerfume().getNome();
		this.tamanho = loteProduto.getPerfume().getTamanho();
		
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
	 * @return the preco
	 */
	public Double getPreco() {
		return preco;
	}
	/**
	 * @param preco the preco to set
	 */
	public void setPreco(Double preco) {
		this.preco = preco;
	}
	/**
	 * @return the quantidade
	 */
	public Integer getQuantidade() {
		return quantidade;
	}
	/**
	 * @param quantidade the quantidade to set
	 */
	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
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
	 * @return the tamanho
	 */
	public String getTamanho() {
		return tamanho;
	}
	/**
	 * @param tamanho the tamanho to set
	 */
	public void setTamanho(String tamanho) {
		this.tamanho = tamanho;
	}
	
	
}
