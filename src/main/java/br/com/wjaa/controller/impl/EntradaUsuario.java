package br.com.wjaa.controller.impl;

import java.io.Serializable;

public class EntradaUsuario implements Serializable{

	
	private static final long serialVersionUID = -1398757204309937916L;

	
	private Integer idUsuarioGi;
	private String permissoes;
	private String nomeUsuario;
	private String nomeFull;
	
	
	public Integer getIdUsuarioGi() {
		return idUsuarioGi;
	}
	public void setIdUsuarioGi(Integer idUsuarioGi) {
		this.idUsuarioGi = idUsuarioGi;
	}
	public String getPermissoes() {
		return permissoes;
	}
	public void setPermissoes(String permissoes) {
		this.permissoes = permissoes;
	}
	public String getNomeUsuario() {
		return nomeUsuario;
	}
	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}
	public String getNomeFull() {
		return nomeFull;
	}
	public void setNomeFull(String nomeFull) {
		this.nomeFull = nomeFull;
	}
	
	
	
	
	
	
	
}
