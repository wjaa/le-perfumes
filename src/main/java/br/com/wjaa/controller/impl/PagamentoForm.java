package br.com.wjaa.controller.impl;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


public class PagamentoForm implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 599712052234184800L;
	
	private String nomeCliente;
	private Date dataVenda;
	private Double valor;
	private Integer idVenda;
	private Integer qtdeParcela;
	private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	private DecimalFormat df = new DecimalFormat("##.00");
	
	private List<VendaPagamentoForm> pagamentos;

	/**
	 * @return the pagamentos
	 */
	public List<VendaPagamentoForm> getPagamentos() {
		return pagamentos;
	}

	/**
	 * @param pagamentos the pagamentos to set
	 */
	public void setPagamentos(List<VendaPagamentoForm> pagamentos) {
		this.pagamentos = pagamentos;
	}

	/**
	 * @return the valor
	 */
	public Double getValor() {
		return valor;
	}

	/**
	 * @param valor the valor to set
	 */
	public void setValor(Double valor) {
		this.valor = valor;
	}

	/**
	 * @return the nomeCliente
	 */
	public String getNomeCliente() {
		return nomeCliente;
	}

	/**
	 * @param nomeCliente the nomeCliente to set
	 */
	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	/**
	 * @return the dataVenda
	 */
	public Date getDataVenda() {
		return dataVenda;
	}
	
	/**
	 * @return the dataVenda
	 */
	public String getDataVendaStr() {
		if (this.dataVenda != null){
			return sdf.format(this.dataVenda);
		}
		return "";
	}

	/**
	 * @param dataVenda the dataVenda to set
	 */
	public void setDataVenda(Date dataVenda) {
		this.dataVenda = dataVenda;
	}
	
	public String getValorStr(){
		if (this.valor != null){
			return df.format(this.valor);
		}
		return "0,00";
		
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
	 * @return the qtdeParcela
	 */
	public Integer getQtdeParcela() {
		return qtdeParcela;
	}

	/**
	 * @param qtdeParcela the qtdeParcela to set
	 */
	public void setQtdeParcela(Integer qtdeParcela) {
		this.qtdeParcela = qtdeParcela;
	}
	
}
