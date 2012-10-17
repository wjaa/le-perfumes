package br.com.wjaa.commons.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity(name =  "br.com.wjaa.commons.model.entity.LoteProduto" )
@Table(name = "LOTEXPRODUTO")
public class LoteProduto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "PRECO")
	private Double preco;
	
	@Column(name = "QUANTIDADE")
	private Integer quantidade;
	
	@Column(name = "ID_PERFUME")
	private Integer idPerfume;
	
	@ManyToOne
	@JoinColumn(name = "ID_PERFUME", insertable = false, updatable = false)
	private Perfume perfume;
	
	@Column(name = "ID_LOTE")
	private Integer idLote;

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
	 * @return the preco
	 */
	public Double getPreco() {
		return this.preco;
	}

	/**
	 * @param preco the preco to set
	 */
	public void setPreco(Double preco) {
		this.preco = preco;
	}

	/**
	 * @return the quantidade
	 */
	public Integer getQuantidade() {
		return this.quantidade;
	}

	/**
	 * @param quantidade the quantidade to set
	 */
	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	/**
	 * @return the idLote
	 */
	public Integer getIdLote() {
		return this.idLote;
	}

	/**
	 * @param idLote the idLote to set
	 */
	public void setIdLote(Integer idLote) {
		this.idLote = idLote;
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
	 * @return the perfume
	 */
	public Perfume getPerfume() {
		return this.perfume;
	}

	/**
	 * @param perfume the perfume to set
	 */
	public void setPerfume(Perfume perfume) {
		this.perfume = perfume;
	}
	
	
}
