package br.com.wjaa.controller.impl;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.struts.action.ActionForm;

import br.com.wjaa.commons.model.entity.Venda;

public class VendaForm extends ActionForm {

	/**
	 * 
	 */
	private static final long serialVersionUID = 680681034282754190L;
	
	public final static int ABERTO = 0;
	public final static int VENCENDO = 1;
	public final static int ATRASADO = 2;
	public final static int LIQUIDADO = 3;
	
	private Integer id;
	private Integer idVendedor;
	private String nomeVendedor;
	private Integer idCliente;
	private String nomeCliente;
	private String loja;
	private Date dataVenda;
	private Date dataPgto;
	private Integer idFormaPagamento;
	private Collection<VendaPrazoForm> vendaPrazo;
	private Collection<VendaItemForm> vendaItem;
	private Double valorVenda;
	private String obs;
	private List<VendedorForm> vendedores;
	private List<ClienteForm> clientes;
	private List<PerfumeForm> perfumes;
	private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	private String[] perfume;
	private int statusVenda;
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
	 * @return the idCliente
	 */
	public Integer getIdCliente() {
		return idCliente;
	}
	/**
	 * @param idCliente the idCliente to set
	 */
	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
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
	 * @param dataVenda the dataVenda to set
	 */
	public void setDataVenda(Date dataVenda) {
		this.dataVenda = dataVenda;
	}
	/**
	 * @return the idFormaPagamento
	 */
	public Integer getIdFormaPagamento() {
		return idFormaPagamento;
	}
	/**
	 * @param idFormaPagamento the idFormaPagamento to set
	 */
	public void setIdFormaPagamento(Integer idFormaPagamento) {
		this.idFormaPagamento = idFormaPagamento;
	}
	/**
	 * @return the vendaPrazo
	 */
	public Collection<VendaPrazoForm> getVendaPrazo() {
		return vendaPrazo;
	}
	/**
	 * @param vendaPrazo the vendaPrazo to set
	 */
	public void setVendaPrazo(Collection<VendaPrazoForm> vendaPrazo) {
		this.vendaPrazo = vendaPrazo;
	}
	/**
	 * @return the vendaItem
	 */
	public Collection<VendaItemForm> getVendaItem() {
		return vendaItem;
	}
	/**
	 * @param vendaItem the vendaItem to set
	 */
	public void setVendaItem(Collection<VendaItemForm> vendaItem) {
		this.vendaItem = vendaItem;
	}
	/**
	 * @return the valorVenda
	 */
	public Double getValorVenda() {
		return valorVenda == null ? 0.0 : valorVenda ;
	}
	
	public String getValorVendaStr() {
		
		if (this.valorVenda != null){
			return df.format(valorVenda);
		}
		return "0,00";
	}
	/**
	 * @param valorVenda the valorVenda to set
	 */
	public void setValorVenda(Double valorVenda) {
		this.valorVenda = valorVenda;
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
	/**
	 * @return the clientes
	 */
	public List<ClienteForm> getClientes() {
		return clientes;
	}
	/**
	 * @param clientes the clientes to set
	 */
	public void setClientes(List<ClienteForm> clientes) {
		this.clientes = clientes;
	}
	/**
	 * @return the perfumes
	 */
	public List<PerfumeForm> getPerfumes() {
		return perfumes;
	}
	/**
	 * @param perfumes the perfumes to set
	 */
	public void setPerfumes(List<PerfumeForm> perfumes) {
		this.perfumes = perfumes;
	}
	
	
	
	public void populate(Venda venda) {
		this.id = venda.getId();
		this.dataVenda = venda.getDataVenda();
		this.idCliente = venda.getIdCliente();
		this.idFormaPagamento = venda.getIdFormaPagamento();
		this.idVendedor = venda.getIdVendedor();
		this.obs = venda.getObs();
		this.valorVenda = venda.getValorVenda();
		this.dataPgto = venda.getDataPgto();
	}
	/**
	 * @return the dataVendaStr
	 */
	public String getDataVendaStr() {
		if (this.dataVenda != null){
			return sdf.format(this.dataVenda);
		}
		return "";
	}
	/**
	 * @param dataVendaStr the dataVendaStr to set
	 */
	public void setDataVendaStr(String dataVendaStr) {
		if (StringUtils.isNotBlank(dataVendaStr)){
			try {
				this.dataVenda = this.sdf.parse(dataVendaStr);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
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
	/**
	 * @return the statusVenda
	 */
	public int getStatusVenda() {
		return statusVenda;
	}
	/**
	 * @param statusVenda the statusVenda to set
	 */
	public void setStatusVenda(int statusVenda) {
		this.statusVenda = statusVenda;
	}
	/**
	 * @return the dataPgto
	 */
	public Date getDataPgto() {
		return dataPgto;
	}
	/**
	 * @param dataPgto the dataPgto to set
	 */
	public void setDataPgto(Date dataPgto) {
		this.dataPgto = dataPgto;
	}

	
	/**
	 * @return the dataVendaStr
	 */
	public String getDataPgtoStr() {
		if (this.dataPgto != null){
			return sdf.format(this.dataPgto);
		}
		return "";
	}
	/**
	 * @param dataVendaStr the dataVendaStr to set
	 */
	public void setDataPgtoStr(String dataPgtoStr) {
		if (StringUtils.isNotBlank(dataPgtoStr)){
			try {
				this.dataPgto = this.sdf.parse(dataPgtoStr);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
	}
	
	public String getIdFormaPagamentoStr(){
		return this.idFormaPagamento == 1 ? "À vista" : "A prazo";
	}
	/**
	 * @return the loja
	 */
	public String getLoja() {
		return loja;
	}
	/**
	 * @param loja the loja to set
	 */
	public void setLoja(String loja) {
		this.loja = loja;
	}
	
}
