package br.com.wjaa.service.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;




public class ModeloBuscaUsuario implements Serializable{
	
	private static final long serialVersionUID = 7209134834011746705L;
	
	
	private Collection<ConsultaUsuarioVo> consultaUsuarioVo = new ArrayList<ConsultaUsuarioVo>();
	
	
	public Collection<ConsultaUsuarioVo> getConsultaUsuarioVo() {
		return consultaUsuarioVo;
	}

	public void setConsultaUsuarioVo(Collection<ConsultaUsuarioVo> consultaUsuarioVo) {
		this.consultaUsuarioVo = consultaUsuarioVo;
	}

	public void addConsultaUsuarioVo(ConsultaUsuarioVo vo){
		this.consultaUsuarioVo.add(vo);
	}
	
	

}
