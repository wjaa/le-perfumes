package br.com.wjaa.commons.model.entity;

import java.util.Date;

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
@Entity(name =  "br.com.wjaa.commons.model.entity.Cliente" )
@Table(name = "CLIENTE")
public class Cliente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "NOME_FULL" ,length = 150)
	private String nomeFull;
	
	@Column(name = "LOGRADOURO" ,length = 150)
	private String endLogradouro;
	
	@Column(name = "NUMERO" ,length = 10)
	private String endNumero;
	
	@Column(name = "BAIRRO" ,length = 150)
	private String endBairro;
	
	@Column(name = "COMPLEMENTO" ,length = 150)
	private String endComplemento;
	
	@Column(name = "CEP" ,length = 10)
	private String endCep;
	
	@Column(name = "CIDADE" ,length = 80)
	private String endCidade;
	
	@Column(name = "ESTADO" ,length = 80)
	private String endEstado;
	
	@Column(name = "CPF" ,length = 14)
	private String cpf;
	
	@Column(name = "DATA_NASCIMENTO")
	private Date dataNascimento;
	
	@Column(name = "SEXO")
	private Integer sexo;
	
	@Column(name = "DDD_FONE1" ,length = 2)
	private String dddFone1;
	
	@Column(name = "FONE1" ,length = 9)
	private String fone1;
	
	@Column(name = "DDD_FONE2" ,length = 2)
	private String dddFone2;
	
	@Column(name = "FONE2" ,length = 9)
	private String fone2;
	
	@Column(name = "LOCAL_TRABALHO" ,length = 60)
	private String localTrabalho;
	
	@Column(name = "LOJA" ,length = 60)
	private String loja;
	
	@Column(name = "EMAIL" ,length = 80)
	private String email;
	
	@Column(name = "CONTATO" ,length = 60)
	private String contato; // usuário do sistema.
	
	@Column(name = "DATA_CADASTRO")
	private Date dataCadastro;
	
	@Column(name = "ID_USUARIO")
	private Integer idUsuario;
	
	@Column(name = "ATIVO")
	private Boolean ativo;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNomeFull() {
		return nomeFull;
	}
	public void setNomeFull(String nomeFull) {
		this.nomeFull = nomeFull;
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
	public Integer getSexo() {
		return sexo;
	}
	public void setSexo(Integer sexo) {
		this.sexo = sexo;
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
