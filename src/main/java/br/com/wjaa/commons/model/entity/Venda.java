package br.com.wjaa.commons.model.entity;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity(name =  "br.com.wjaa.commons.model.entity.Venda" )
@Table(name = "VENDA")
public class Venda {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "ID_VENDEDOR", nullable = false)
	private Integer idVendedor;
	
	@Column(name = "ID_CLIENTE", nullable = false)
	private Integer idCliente;
	
	@Column(name = "DATA_VENDA", nullable = false)
	private Date dataVenda;
	
	@Column(name = "DATA_PGTO")
	private Date dataPgto;
	
	@Column(name = "ID_FORMA_PAGAMENTO", nullable = false)
	private Integer idFormaPagamento;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "venda")
	private Set<VendaPrazo> vendaPrazo;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "venda")
	private Set<VendaItem> vendaItem;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "venda")
	private Set<VendaPagamento> vendaPagamento;
	
	@Column(name = "VALOR_VENDA")
	private Double valorVenda;
	
	@Column(name = "OBS", length = 255)
	private String obs;
	
	/**
	 * @return the id
	 */
	public Integer getId() {
		return this.id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the idCliente
	 */
	public Integer getIdCliente() {
		return this.idCliente;
	}

	/**
	 * @param idCliente the idCliente to set
	 */
	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}

	/**
	 * @return the dataVenda
	 */
	public Date getDataVenda() {
		return this.dataVenda;
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
		return this.idFormaPagamento;
	}

	/**
	 * @param idFormaPagamento the idFormaPagamento to set
	 */
	public void setIdFormaPagamento(Integer idFormaPagamento) {
		this.idFormaPagamento = idFormaPagamento;
	}

	/**
	 * @return the vendaItem
	 */
	public Set<VendaItem> getVendaItem() {
		return this.vendaItem;
	}

	/**
	 * @param vendaItem the vendaItem to set
	 */
	public void setVendaItem(Set<VendaItem> vendaItem) {
		this.vendaItem = vendaItem;
	}

	/**
	 * @return the idVendedor
	 */
	public Integer getIdVendedor() {
		return this.idVendedor;
	}

	/**
	 * @param idVendedor the idVendedor to set
	 */
	public void setIdVendedor(Integer idVendedor) {
		this.idVendedor = idVendedor;
	}

	/**
	 * @return the valorVenda
	 */
	public Double getValorVenda() {
		return this.valorVenda;
	}

	/**
	 * @param valorVenda the valorVenda to set
	 */
	public void setValorVenda(Double valorVenda) {
		this.valorVenda = valorVenda;
	}

	/**
	 * @return the vendaPrazo
	 */
	public Set<VendaPrazo> getVendaPrazo() {
		return this.vendaPrazo;
	}

	/**
	 * @param vendaPrazo the vendaPrazo to set
	 */
	public void setVendaPrazo(Set<VendaPrazo> vendaPrazo) {
		this.vendaPrazo = vendaPrazo;
	}

	/**
	 * @return the obs
	 */
	public String getObs() {
		return this.obs;
	}

	/**
	 * @param obs the obs to set
	 */
	public void setObs(String obs) {
		this.obs = obs;
	}

	/**
	 * @return the dataPgto
	 */
	public Date getDataPgto() {
		return this.dataPgto;
	}

	/**
	 * @param dataPgto the dataPgto to set
	 */
	public void setDataPgto(Date dataPgto) {
		this.dataPgto = dataPgto;
	}

	/**
	 * @return the vendaPagamento
	 */
	public Set<VendaPagamento> getVendaPagamento() {
		return this.vendaPagamento;
	}

	/**
	 * @param vendaPagamento the vendaPagamento to set
	 */
	public void setVendaPagamento(Set<VendaPagamento> vendaPagamento) {
		this.vendaPagamento = vendaPagamento;
	}
	
}
