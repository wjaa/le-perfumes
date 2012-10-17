package br.com.wjaa.service.impl;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import br.com.wjaa.commons.model.entity.Usuario;

public class UsuarioVo implements Serializable{

	
	private static final long serialVersionUID = -1214834647417998980L;
	
	
	public UsuarioVo() {}
	
	public UsuarioVo(Usuario usuario){
		this.idUsuarioGi = usuario.getId();
		this.dataCadastro = usuario.getDataCadastro();
		this.nome = usuario.getNome();
		this.nomeFull = usuario.getNomeUsuario();
		this.email = usuario.getEmail();
		
	}
	
	
	
	  private Integer idUsuarioGi;
	  private Integer idClienteGi;
	  private String nome;
	  private String nomeFull;
	  private String senha;
	  private Integer nivel;
	  private Integer acessos;
	  private Date dataCadastro;
	  private String filtroEmpresa;
	  private String filtroFilial;
	  private String filtroCliente;
	  private String filtroContrato;
	  private String filtroTipoFat;
	  private String filtroCusto;
	  private String filtroFuncionario;
	  private Integer status;
	  private String email;
	  private BigDecimal cpf;
	  private Date dataNasc;
	  private String rg;
	  private String urlSite;
	  private Integer active;
	  private String permissoes;
	  private Integer id90;
	  private Integer id80;
	  private Integer id70;
	  private Integer id60;
	  private Integer id50;
	  private Integer id40;
	  private Integer id30;
	  private Integer id20;
	  private Integer id10;


	public Integer getIdUsuarioGi() {
		return idUsuarioGi;
	}
	public void setIdUsuarioGi(Integer idUsuarioGi) {
		this.idUsuarioGi = idUsuarioGi;
	}
	public Integer getIdClienteGi() {
		return idClienteGi;
	}
	public void setIdClienteGi(Integer idClienteGi) {
		this.idClienteGi = idClienteGi;
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
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public Integer getNivel() {
		return nivel;
	}
	public void setNivel(Integer nivel) {
		this.nivel = nivel;
	}
	public Integer getAcessos() {
		return acessos;
	}
	public void setAcessos(Integer acessos) {
		this.acessos = acessos;
	}
	public Date getDataCadastro() {
		return dataCadastro;
	}
	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
	public String getFiltroEmpresa() {
		return filtroEmpresa;
	}
	public void setFiltroEmpresa(String filtroEmpresa) {
		this.filtroEmpresa = filtroEmpresa;
	}
	public String getFiltroFilial() {
		return filtroFilial;
	}
	public void setFiltroFilial(String filtroFilial) {
		this.filtroFilial = filtroFilial;
	}
	public String getFiltroCliente() {
		return filtroCliente;
	}
	public void setFiltroCliente(String filtroCliente) {
		this.filtroCliente = filtroCliente;
	}
	public String getFiltroContrato() {
		return filtroContrato;
	}
	public void setFiltroContrato(String filtroContrato) {
		this.filtroContrato = filtroContrato;
	}
	public String getFiltroTipoFat() {
		return filtroTipoFat;
	}
	public void setFiltroTipoFat(String filtroTipoFat) {
		this.filtroTipoFat = filtroTipoFat;
	}
	public String getFiltroCusto() {
		return filtroCusto;
	}
	public void setFiltroCusto(String filtroCusto) {
		this.filtroCusto = filtroCusto;
	}
	public String getFiltroFuncionario() {
		return filtroFuncionario;
	}
	public void setFiltroFuncionario(String filtroFuncionario) {
		this.filtroFuncionario = filtroFuncionario;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public BigDecimal getCpf() {
		return cpf;
	}
	public void setCpf(BigDecimal cpf) {
		this.cpf = cpf;
	}
	public Date getDataNasc() {
		return dataNasc;
	}
	public void setDataNasc(Date dataNasc) {
		this.dataNasc = dataNasc;
	}
	public String getRg() {
		return rg;
	}
	public void setRg(String rg) {
		this.rg = rg;
	}
	public String getUrlSite() {
		return urlSite;
	}
	public void setUrlSite(String urlSite) {
		this.urlSite = urlSite;
	}
	public Integer getActive() {
		return active;
	}
	public void setActive(Integer active) {
		this.active = active;
	}
	public String getPermissoes() {
		return permissoes;
	}
	public void setPermissoes(String permissoes) {
		this.permissoes = permissoes;
	}
	public Integer getId90() {
		return id90;
	}
	public void setId90(Integer id90) {
		this.id90 = id90;
	}
	public Integer getId80() {
		return id80;
	}
	public void setId80(Integer id80) {
		this.id80 = id80;
	}
	public Integer getId70() {
		return id70;
	}
	public void setId70(Integer id70) {
		this.id70 = id70;
	}
	public Integer getId60() {
		return id60;
	}
	public void setId60(Integer id60) {
		this.id60 = id60;
	}
	public Integer getId50() {
		return id50;
	}
	public void setId50(Integer id50) {
		this.id50 = id50;
	}
	public Integer getId40() {
		return id40;
	}
	public void setId40(Integer id40) {
		this.id40 = id40;
	}
	public Integer getId30() {
		return id30;
	}
	public void setId30(Integer id30) {
		this.id30 = id30;
	}
	public Integer getId20() {
		return id20;
	}
	public void setId20(Integer id20) {
		this.id20 = id20;
	}
	public Integer getId10() {
		return id10;
	}
	public void setId10(Integer id10) {
		this.id10 = id10;
	}

	
	
}
