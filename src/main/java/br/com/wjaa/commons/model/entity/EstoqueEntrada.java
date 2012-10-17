package br.com.wjaa.commons.model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * @author Wagner
 *
 */
@Entity(name =  "br.com.wjaa.commons.model.entity.EstoqueEntrada" )
@Table(name = "ESTOQUE_ENTRADA")
public class EstoqueEntrada implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5474687651158219713L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "ID_LOTE")
	private Integer idLote;
	
	@Column(name = "ID_VENDEDOR")
	private Integer idVendedor;
	
	@Column(name = "ID_PERFUME")
	private Integer idPerfume;
	
	@Column(name = "QTDE")
	private Integer qtde;
	
	
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
	
}
