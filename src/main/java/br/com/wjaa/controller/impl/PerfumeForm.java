package br.com.wjaa.controller.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.collections.CollectionUtils;

import br.com.wjaa.commons.model.entity.Perfume;


public class PerfumeForm implements Comparable<PerfumeForm> {
	
	private Integer id;
	private String nome;
	private String marca;
	private String tipo;
	private String tamanho;
	private String observacao;
	
	
	public PerfumeForm(){
		
	}
	
	public PerfumeForm(Perfume perfume){
		try {
			BeanUtils.copyProperties(this, perfume);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
	}
	
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
	
	
	@SuppressWarnings("unchecked")
	public static Collection<PerfumeForm> toList(List<Perfume> all) {
		Collection<PerfumeForm> perfumesForm = Collections.EMPTY_LIST;
		
		if (CollectionUtils.isNotEmpty(all)){
			perfumesForm = new java.util.TreeSet<PerfumeForm>();
			for (Perfume perfume : all) {
				perfumesForm.add(new PerfumeForm(perfume));
			}
		}
		return perfumesForm;
	}
	
	@Override
	public int compareTo(PerfumeForm o) {
		int comp = 0;
		
		if (this.nome != null && o.getNome() != null ){
			comp = this.nome.compareToIgnoreCase(o.getNome());
			
			if (comp == 0){
				comp = this.id.compareTo(o.getId());
			}
		}else if (this.id != null && o.getId() != null  ){
			comp = this.id.compareTo(o.getId());
		}
		
		return comp;
	}

	
	

}
