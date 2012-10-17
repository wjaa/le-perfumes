package br.com.wjaa.commons.model.entity;

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
@Entity(name =  "br.com.wjaa.commons.model.entity.Perfume" )
@Table(name = "PERFUME")
public class Perfume {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "NOME", length = 100)
	private String nome;
	
	@Column(name = "MARCA", length = 100)
	private String marca;
	
	@Column(name = "TIPO", length = 80)
	private String tipo;
	
	@Column(name = "TAMANHO", length = 30)
	private String tamanho;
	
	@Column(name = "OBSERVACAO", length = 255)
	private String observacao;
	
	@Column(name = "ATIVO")
	private Boolean ativo;
	
	
	public String getObservacao() {
		return observacao;
	}
	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getTamanho() {
		return tamanho;
	}
	public void setTamanho(String tamanho) {
		this.tamanho = tamanho;
	}
	/**
	 * @return the ativo
	 */
	public Boolean getAtivo() {
		return this.ativo;
	}
	/**
	 * @param ativo the ativo to set
	 */
	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}
	
	
	

}
