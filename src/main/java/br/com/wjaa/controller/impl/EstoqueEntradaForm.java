package br.com.wjaa.controller.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts.action.ActionForm;


public class EstoqueEntradaForm extends ActionForm {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7721871032950309703L;
	
	private Integer id;
	private Integer idLote;
	private Integer idVendedor;
	private String nomeVendedor;
	private Integer idPerfume;
	private String nomePerfume;
	private Integer qtde;
	private Integer qtdeLote;
	private List<VendedorForm> vendedores;
	
	
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
	 * @return the idLote
	 */
	public Integer getIdLote() {
		return idLote;
	}
	/**
	 * @param idLote the idLote to set
	 */
	public void setIdLote(Integer idLote) {
		this.idLote = idLote;
	}
	/**
	 * @return the idVendedor
	 */
	public Integer getIdVendedor() {
		return idVendedor;
	}
	/**
	 * @param idVendedor the idVendedor to set
	 */
	public void setIdVendedor(Integer idVendedor) {
		this.idVendedor = idVendedor;
	}
	/**
	 * @return the nomeVendedor
	 */
	public String getNomeVendedor() {
		return nomeVendedor;
	}
	/**
	 * @param nomeVendedor the nomeVendedor to set
	 */
	public void setNomeVendedor(String nomeVendedor) {
		this.nomeVendedor = nomeVendedor;
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
	 * @return the qtde
	 */
	public Integer getQtde() {
		return qtde;
	}
	/**
	 * @param qtde the qtde to set
	 */
	public void setQtde(Integer qtde) {
		this.qtde = qtde;
	}
	/**
	 * @return the qtdeLote
	 */
	public Integer getQtdeLote() {
		return qtdeLote;
	}
	/**
	 * @param qtdeLote the qtdeLote to set
	 */
	public void setQtdeLote(Integer qtdeLote) {
		this.qtdeLote = qtdeLote;
	}
	/**
	 * @return the vendedores
	 */
	public List<VendedorForm> getVendedores() {
		return vendedores;
	}
	/**
	 * @param vendedores the vendedores to set
	 */
	public void setVendedores(List<VendedorForm> vendedores) {
		this.vendedores = vendedores;
	}
	
	public void addVendedor(VendedorForm vendedor){
		if (this.vendedores == null){
			this.vendedores = new ArrayList<VendedorForm>();
		}
		this.vendedores.add(vendedor);
	}
	
}
