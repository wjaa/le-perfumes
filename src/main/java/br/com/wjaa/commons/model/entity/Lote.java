package br.com.wjaa.commons.model.entity;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity(name =  "br.com.wjaa.commons.model.entity.Lote" )
@Table(name = "LOTE")
public class Lote {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "DATA_COMPRA")
	private Date dataCompra;
	
	@ManyToOne
	@JoinColumn(name = "ID_FORNECEDOR")
	private Fornecedor fornecedor;
	
	@Column(name = "OBSERVACAO")
	private String observacao;
	
	@OneToMany(fetch = FetchType.EAGER,cascade = {CascadeType.ALL})
	@JoinTable(name= "LOTEXPRODUTO" ,joinColumns = @JoinColumn(name = "ID_LOTE"),
			inverseJoinColumns = @JoinColumn (name = "ID"))
	private Collection<LoteProduto> produtos;

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
	 * @return the dataCompra
	 */
	public Date getDataCompra() {
		return this.dataCompra;
	}

	/**
	 * @param dataCompra the dataCompra to set
	 */
	public void setDataCompra(Date dataCompra) {
		this.dataCompra = dataCompra;
	}

	/**
	 * @return the fornecedor
	 */
	public Fornecedor getFornecedor() {
		return this.fornecedor;
	}

	/**
	 * @param fornecedor the fornecedor to set
	 */
	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}

	/**
	 * @return the observacao
	 */
	public String getObservacao() {
		return this.observacao;
	}

	/**
	 * @param observacao the observacao to set
	 */
	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	/**
	 * @return the produtos
	 */
	public Collection<LoteProduto> getProdutos() {
		return this.produtos;
	}

	/**
	 * @param produtos the produtos to set
	 */
	public void setProdutos(List<LoteProduto> produtos) {
		this.produtos = produtos;
	}
	
	
}
