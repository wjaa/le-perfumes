package br.com.wjaa.controller.impl;

import java.text.SimpleDateFormat;
import java.util.Date;

public class VendaPrazoForm implements Comparable<VendaPrazoForm>{

	private Integer id;
	private Integer idVenda;
	private Integer dias;
	private Date dataVencimento;
	private boolean pago;
	private boolean vencida;
	
	
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
	 * @return the dias
	 */
	public Integer getDias() {
		return dias;
	}
	/**
	 * @param dias the dias to set
	 */
	public void setDias(Integer dias) {
		this.dias = dias;
	}
	/**
	 * @return the dataVencimento
	 */
	public Date getDataVencimento() {
		return dataVencimento;
	}
	
	/**
	 * @return the dataVencimento
	 */
	public String getDataVencimentoStr() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		return sdf.format(dataVencimento);
	}
	
	/**
	 * @param dataVencimento the dataVencimento to set
	 */
	public void setDataVencimento(Date dataVencimento) {
		this.dataVencimento = dataVencimento;
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
	 * @return the pago
	 */
	public boolean isPago() {
		return pago;
	}
	
	/**
	 * @return the pago
	 */
	public boolean getPago() {
		return pago;
	}
	/**
	 * @param pago the pago to set
	 */
	public void setPago(boolean pago) {
		this.pago = pago;
	}
	@Override
	public int compareTo(VendaPrazoForm o) {
		int comp = 1;
		if ( this.dataVencimento != null && o.getDataVencimento() != null){
			comp = this.dataVencimento.compareTo(o.getDataVencimento());
			
			if (comp ==0){
				comp = 1;
			}
		}
		return comp;
	}
	/**
	 * @return the vencida
	 */
	public boolean isVencida() {
		return vencida;
	}
	
	/**
	 * @return the vencida
	 */
	public boolean getVencida() {
		return vencida;
	}
	/**
	 * @param vencida the vencida to set
	 */
	public void setVencida(boolean vencida) {
		this.vencida = vencida;
	}

	
}
