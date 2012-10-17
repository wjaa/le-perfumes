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

@Entity(name =  "br.com.wjaa.commons.model.entity.PrazoVenda" )
@Table(name = "VENDA_PRAZO")
public class VendaPrazo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "ID_VENDA", nullable = false)
	private Integer idVenda;
	
	@ManyToOne
	@JoinColumn(name = "ID_VENDA", nullable = false, insertable =false, updatable = false)
	private Venda venda;
	
	@Column(name = "DIAS", nullable = false)
	private Integer dias;
	
	@Column(name = "DATA_VENCIMENTO", nullable = false)
	private Date dataVencimento;
	
	@Column(name = "PAGO", nullable = false)
	private Boolean pago;

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
	 * @return the dias
	 */
	public Integer getDias() {
		return this.dias;
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
		return this.dataVencimento;
	}

	/**
	 * @param dataVencimento the dataVencimento to set
	 */
	public void setDataVencimento(Date dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

	/**
	 * @return the pago
	 */
	public Boolean getPago() {
		return this.pago;
	}

	/**
	 * @param pago the pago to set
	 */
	public void setPago(Boolean pago) {
		this.pago = pago;
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
