package br.com.wjaa.controller.impl;


import java.math.BigDecimal;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;

import br.com.wjaa.validacao.ParametroDeEntradaInvalidoException;
import br.com.wjaa.validacao.ValidacaoComum;



public class ValidaDadosEntradaUsuario {

	
	public UsuarioForm validaDadosSalvar(HttpServletRequest request)throws Exception{
		
		UsuarioForm userForm = new UsuarioForm();
		ValidacaoComum va = new ValidacaoComum();
	
		userForm.setNome(va.verificaBrancoRequest(request, "nome"));
		userForm.setNomeFull(va.verificaBrancoRequest(request, "nomeFull"));
		userForm.setSenha(va.verificaSenhasIguais(request, "senha", "senhaConfirm"));
		userForm.setEmail(va.validaEmailRequest(request, "email"));
		
		String idUsuario = request.getParameter("idUsuario");
		if (StringUtils.isNotBlank(idUsuario)){
			userForm.setId_usuario(Integer.valueOf(idUsuario));
		}
		
	

		return userForm;
	}
	
	
	
	
	
	/**
	 * Valida dados para deletar o objeto do banco de dados
	 * @param request
	 * @return
	 */
	public EntradaUsuario validaDadosDelete(HttpServletRequest request){
		EntradaUsuario entrada = new EntradaUsuario();
		String idUsuario = request.getParameter("idUsuario");
		
		entrada.setIdUsuarioGi(Integer.valueOf(idUsuario));
		
		return entrada;
	}
	
	 /**
	  * 
	  * @param request
	  * @return
	  */
	public EntradaUsuario validaDadosEdicao(HttpServletRequest request){
		EntradaUsuario entrada = new EntradaUsuario();
		String idUsuario = request.getParameter("idUsuario");
		String permissoes = request.getParameter("permissoes");
		
		entrada.setIdUsuarioGi(Integer.valueOf(idUsuario));
		entrada.setPermissoes(permissoes);
		
		return entrada;
	}


	public EntradaUsuario validaDadosBusca(HttpServletRequest request){
		EntradaUsuario entrada = new EntradaUsuario();
		
		String nome = request.getParameter("nome");
		
		entrada.setNomeFull(nome);
		
		return entrada;
	}
	
	
}
