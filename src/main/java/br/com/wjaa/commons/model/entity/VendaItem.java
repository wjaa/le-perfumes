package br.com.wjaa.commons.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity(name =  "br.com.wjaa.commons.model.entity.VendaItem" )
@Table(name = "VENDA_ITEM")
public class VendaItem {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "ID_VENDA", nullable = false)
	private Integer idVenda;
	
	@ManyToOne
	@JoinColumn(name = "ID_VENDA", nullable = false, insertable =false, updatable = false)
	private Venda venda;
	
	@Column(name = "ID_PERFUME", nullable = false)
	private Integer idPerfume;
	
	@Column(name = "QTDE", nullable = false)
	private Integer qtde;
	
	@Column(name = "PRECO_UNITARIO", nullable = false)
	private Double precoUnitario;

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

	/**
	 * @return the idPerfume
	 */
	public Integer getIdPerfume() {
		return this.idPerfume;
	}

	/**
	 * @param idPerfume the idPerfume to set
	 */
	public void setIdPerfume(Integer idPerfume) {
		this.idPerfume = idPerfume;
	}

	/**
	 * @return the qtde
	 */
	public Integer getQtde() {
		return this.qtde;
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
		return this.precoUnitario;
	}

	/**
	 * @param precoUnitario the precoUnitario to set
	 */
	public void setPrecoUnitario(Double precoUnitario) {
		this.precoUnitario = precoUnitario;
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
	
}
