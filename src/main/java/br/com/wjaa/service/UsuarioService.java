package br.com.wjaa.service;

import br.com.wjaa.arquitetura.service.GenericService;
import br.com.wjaa.commons.model.entity.Usuario;
import br.com.wjaa.controller.impl.EntradaUsuario;
import br.com.wjaa.controller.impl.UsuarioForm;
import br.com.wjaa.service.impl.ModeloBuscaUsuario;
import br.com.wjaa.service.impl.ModeloUsuarioEdicao;

public interface UsuarioService extends GenericService<Usuario, Integer> {

	public void salvarUsuario(UsuarioForm usuarioForm)throws Exception;
	public boolean existeUsuario(UsuarioForm usuarioForm)throws Exception;
	public void removerUsuario(EntradaUsuario entrada) throws Exception;
	public ModeloBuscaUsuario buscaUsuario(EntradaUsuario entrada) throws Exception;
	public ModeloUsuarioEdicao getUsuarioEdicao(EntradaUsuario entrada);


	
	
	
}
