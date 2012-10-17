package br.com.wjaa.controller.impl;

import java.text.DecimalFormat;



public class VendaItemForm implements Comparable<VendaItemForm> {

	
	private Integer id;
	private Integer idVenda;
	private Integer idPerfume;
	private String nomePerfume;
	private Integer qtde;
	private Double precoUnitario;
	private DecimalFormat df = new DecimalFormat("##.00");
	
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
	 * @return the idVenda
	 */
	public Integer getIdVenda() {
		return idVenda;
	}
	/**
	 * @param idVenda the idVenda to set
	 */
	public void setIdVenda(Integer idVenda) {
		this.idVenda = idVenda;
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
	 * @return the precoUnitario
	 */
	public Double getPrecoUnitario() {
		return precoUnitario;
	}
	
	public String getPrecoUnitarioStr() {
		if (precoUnitario != null){
			return this.df.format(precoUnitario);
		}
		return "0,00";
	}
	/**
	 * @param precoUnitario the precoUnitario to set
	 */
	public void setPrecoUnitario(Double precoUnitario) {
		this.precoUnitario = precoUnitario;
	}
	@Override
	public int compareTo(VendaItemForm o) {
		int comp = this.nomePerfume.compareTo(o.getNomePerfume())*-1;
		if (comp == 0){
			comp = this.getIdPerfume().compareTo(o.getIdPerfume());
		}
		return comp;
	}

	
}
