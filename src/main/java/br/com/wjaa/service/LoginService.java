package br.com.wjaa.service;

import br.com.wjaa.arquitetura.service.GenericService;
import br.com.wjaa.commons.model.entity.Usuario;
import br.com.wjaa.controller.impl.EntradaLogin;


/**
 * 
 * @author Wagner
 *
 */
public interface LoginService extends GenericService<Usuario, Integer>{

	public Usuario verificaLoginUsuario(EntradaLogin entrada);
	
}
