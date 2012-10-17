package br.com.wjaa.service.impl;

import java.io.Serializable;
import java.util.Date;

public class ClienteVo implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5177763820056349841L;
	
	private Integer idCliente;
	private String nomeFull;
	private String endLogradouro;
	private String endNumero;
	private String endBairro;
	private String endComplemento;
	private String endCep;
	private String endCidade;
	private String endEstado;
	private String cpf;
	private Date dataNascimento;
	private String mokDataNascimento;
	private Integer sexo;
	private String dddFone1;
	private String fone1;
	private String dddFone2;
	private String fone2;
	private String localTrabalho;
	private String loja;
	private String email;
	private String contato; // usuário do sistema.
	private Date dataCadastro;
	private Integer idUsuario;
	private Integer status;
	

	public String getMokDataNascimento() {
		return mokDataNascimento;
	}
	public void setMokDataNascimento(String mokDataNascimento) {
		this.mokDataNascimento = mokDataNascimento;
	}
	public Integer getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}
	public String getNomeFull() {
		return nomeFull;
	}
	public void setNomeFull(String nomeFull) {
		this.nomeFull = nomeFull;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public Date getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public String getDddFone1() {
		return dddFone1;
	}
	public void setDddFone1(String dddFone1) {
		this.dddFone1 = dddFone1;
	}
	public String getFone1() {
		return fone1;
	}
	public void setFone1(String fone1) {
		this.fone1 = fone1;
	}
	public String getDddFone2() {
		return dddFone2;
	}
	public void setDddFone2(String dddFone2) {
		this.dddFone2 = dddFone2;
	}
	public String getFone2() {
		return fone2;
	}
	public void setFone2(String fone2) {
		this.fone2 = fone2;
	}
	public String getLocalTrabalho() {
		return localTrabalho;
	}
	public void setLocalTrabalho(String localTrabalho) {
		this.localTrabalho = localTrabalho;
	}
	public String getLoja() {
		return loja;
	}
	public void setLoja(String loja) {
		this.loja = loja;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getContato() {
		return contato;
	}
	public void setContato(String contato) {
		this.contato = contato;
	}
	public String getEndLogradouro() {
		return endLogradouro;
	}
	public void setEndLogradouro(String endLogradouro) {
		this.endLogradouro = endLogradouro;
	}
	public String getEndNumero() {
		return endNumero;
	}
	public void setEndNumero(String endNumero) {
		this.endNumero = endNumero;
	}
	public String getEndBairro() {
		return endBairro;
	}
	public void setEndBairro(String endBairro) {
		this.endBairro = endBairro;
	}
	public String getEndComplemento() {
		return endComplemento;
	}
	public void setEndComplemento(String endComplemento) {
		this.endComplemento = endComplemento;
	}
	public String getEndCep() {
		return endCep;
	}
	public void setEndCep(String endCep) {
		this.endCep = endCep;
	}
	public String getEndCidade() {
		return endCidade;
	}
	public void setEndCidade(String endCidade) {
		this.endCidade = endCidade;
	}
	public String getEndEstado() {
		return endEstado;
	}
	public void setEndEstado(String endEstado) {
		this.endEstado = endEstado;
	}
	public Integer getSexo() {
		return sexo;
	}
	public void setSexo(Integer sexo) {
		this.sexo = sexo;
	}
	public Date getDataCadastro() {
		return dataCadastro;
	}
	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
	public Integer getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	
	
	
	
	
}
