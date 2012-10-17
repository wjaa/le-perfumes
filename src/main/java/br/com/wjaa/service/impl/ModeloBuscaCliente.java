package br.com.wjaa.service.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;


public class ModeloBuscaCliente implements Serializable {

	private static final long serialVersionUID = 7732106301354588311L;
	
	
	private Collection<ClienteVo> clienteVo = new ArrayList<ClienteVo>();
	
	
	public Collection<ClienteVo> getClienteVo() {
		return clienteVo;
	}
	public void setClienteVo(Collection<ClienteVo> clienteVo) {
		this.clienteVo = clienteVo;
	}

	public void addClienteVo(ClienteVo vo){
		this.clienteVo.add(vo);
	}
	
	

}
