package br.com.wjaa.controller.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.collections.CollectionUtils;
import org.apache.struts.action.ActionForm;

import br.com.wjaa.commons.model.entity.Vendedor;

/**
 * 
 * @author Wagner
 *
 */
public class VendedorForm extends ActionForm {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4938253933194602614L;
	private Integer id;
	private String nome;
	private String telefone;
	private Integer qtde;

	
	public VendedorForm(){}
	
	public VendedorForm(Vendedor vendedor) {
		try {
			BeanUtils.copyProperties(this, vendedor);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
	}
	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}
	/**
	 * @param nome the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}
	/**
	 * @return the telefone
	 */
	public String getTelefone() {
		return telefone;
	}
	/**
	 * @param telefone the telefone to set
	 */
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	public static List<VendedorForm> toList(List<Vendedor> listVendedorByName) {
		List<VendedorForm> vendedores = new ArrayList<VendedorForm>();
		if (CollectionUtils.isNotEmpty(listVendedorByName)){
			for (Vendedor vendedor : listVendedorByName) {
				vendedores.add(new VendedorForm(vendedor));
			}
		}
		return vendedores;
	}

	/**
	 * @return the qtde
	 */
	public Integer getQtde() {
		return qtde;
	}

	/**
	 * @param qtde the qtde to set
	 */
	public void setQtde(Integer qtde) {
		this.qtde = qtde;
	}
	

}
