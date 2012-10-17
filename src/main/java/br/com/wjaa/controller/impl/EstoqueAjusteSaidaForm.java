package br.com.wjaa.controller.impl;

public class EstoqueAjusteSaidaForm {


	private Integer idLote;
	private Integer qtde;
	private Integer idPerfume;
	private Integer idVendedor;
	private String nomeVendedor;
	private String obs;
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
	 * @return the obs
	 */
	public String getObs() {
		return obs;
	}
	/**
	 * @param obs the obs to set
	 */
	public void setObs(String obs) {
		this.obs = obs;
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
	
}
