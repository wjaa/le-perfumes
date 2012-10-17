package br.com.wjaa.controller.impl;

import java.io.Serializable;

/**
 * 
 * @author Thiago
 *
 */
public class EntradaLogin implements Serializable{

	private static final long serialVersionUID = -4972064626982337603L;
	

	private String usuario;
	private String senha;
	
	
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	
	
	
	
	

}
