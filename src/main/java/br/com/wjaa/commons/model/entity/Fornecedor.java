package br.com.wjaa.commons.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name =  "br.com.wjaa.commons.model.entity.Forncedor" )
@Table(name = "FORNECEDOR")
public class Fornecedor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "NOME", length = 80 )
	private String nome;
	
	@Column(name = "ENDERECO", length = 200 )
	private String endereco;
	
	@Column(name = "TELEFONE1", length = 10 )
	private String telefone1;
	
	@Column(name = "TELEFONE2", length = 10 )
	private String telefone2;
	
	@Column(name = "EMAIL", length = 100 )
	private String email;
	
	@Column(name = "SITE", length = 100 )
	private String site;
	
	@Column(name = "CONTATO", length = 80 )
	private String contato;
	
	@Column(name = "DADOS_PAGAMENTO", length = 255 )
	private String dadosPagamento;
	
	@Column(name = "OBSERVACAO", length = 255 )
	private String observacao;
	
	@Column(name = "ATIVO")
	private Boolean ativo;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getTelefone1() {
		return telefone1;
	}
	public void setTelefone1(String telefone1) {
		this.telefone1 = telefone1;
	}
	public String getTelefone2() {
		return telefone2;
	}
	public void setTelefone2(String telefone2) {
		this.telefone2 = telefone2;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSite() {
		return site;
	}
	public void setSite(String site) {
		this.site = site;
	}
	public String getContato() {
		return contato;
	}
	public void setContato(String contato) {
		this.contato = contato;
	}
	public String getDadosPagamento() {
		return dadosPagamento;
	}
	public void setDadosPagamento(String dadosPagamento) {
		this.dadosPagamento = dadosPagamento;
	}
	public String getObservacao() {
		return observacao;
	}
	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}
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
