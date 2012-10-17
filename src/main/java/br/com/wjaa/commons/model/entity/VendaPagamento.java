package br.com.wjaa.commons.model.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity(name =  "br.com.wjaa.commons.model.entity.VendaPagamento" )
@Table(name = "VENDA_PAGAMENTO")
public class VendaPagamento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "DATA", nullable = false)
	private Date data;
	
	@Column(name = "VALOR", nullable = false)
	private Double valor;
	
	@ManyToOne
	@JoinColumn(name = "ID_VENDA", nullable = false, insertable =false, updatable = false)
	private Venda venda;
	
	@Column(name = "ID_VENDA", nullable = false)
	private Integer idVenda;
	
	
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
	 * @return the data
	 */
	public Date getData() {
		return this.data;
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
		return this.valor;
	}
	/**
	 * @param valor the valor to set
	 */
	public void setValor(Double valor) {
		this.valor = valor;
	}
	/**
	 * @return the venda
	 */
	public Venda getVenda() {
		return this.venda;
	}
	/**
	 * @param venda the venda to set
	 */
	public void setVenda(Venda venda) {
		this.venda = venda;
	}
	/**
	 * @return the idVenda
	 */
	public Integer getIdVenda() {
		return this.idVenda;
	}
	/**
	 * @param idVenda the idVenda to set
	 */
	public void setIdVenda(Integer idVenda) {
		this.idVenda = idVenda;
	}
	
}
