package br.com.wjaa.controller.impl;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class VendaPagamentoForm implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7260702826748032179L;
	
	
	private Integer id;
	private Date data;
	private Double valor;
	private Integer idVenda;
	private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
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
	 * @return the data
	 */
	public Date getData() {
		return data;
	}
	/**
	 * @param data the data to set
	 */
	public String getDataStr() {
		if (this.data != null){
			return sdf.format(this.data);
		}
		return "";
	}
	
	
	/**
	 * @param data the data to set
	 */
	public void setData(Date data) {
		this.data = data;
	}
	
	/**
	 * @return the valor
	 */
	public Double getValor() {
		return valor;
	}
	
	
	public String getValorStr(){
		if (this.valor != null){
			return df.format(this.valor);
		}
		return "0,00";
		
	}
	
	/**
	 * @param valor the valor to set
	 */
	public void setValor(Double valor) {
		this.valor = valor;
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
	
}
