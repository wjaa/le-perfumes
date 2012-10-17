package br.com.wjaa.service.impl;

public class PerfumeVo {
	
	
	private Integer idPerfume;
	private String nome;
	private String marca;
	private String tipo;
	private String tamanho;
	private String observacao;
	
	
	public String getObservacao() {
		return observacao;
	}
	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}
	public Integer getIdPerfume() {
		return idPerfume;
	}
	public void setIdPerfume(Integer idPerfume) {
		this.idPerfume = idPerfume;
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

}
