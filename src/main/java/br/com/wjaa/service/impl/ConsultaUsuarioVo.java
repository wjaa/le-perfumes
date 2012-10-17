package br.com.wjaa.service.impl;

import java.io.Serializable;

public  class ConsultaUsuarioVo implements Serializable{

	
	private static final long serialVersionUID = -7328252446920519137L;

	public ConsultaUsuarioVo() { }
	

	  private Integer idUsuario;
	  private String nome;
	  private String nomeFull;
	  private String email;
	  
	  

	public Integer getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getNomeFull() {
		return nomeFull;
	}
	public void setNomeFull(String nomeFull) {
		this.nomeFull = nomeFull;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	
	  
	
}
