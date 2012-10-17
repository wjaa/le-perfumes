package br.com.wjaa.controller.impl;

import javax.servlet.http.HttpServletRequest;

import br.com.wjaa.validacao.ParametroDeEntradaInvalidoException;
import br.com.wjaa.validacao.ValidacaoComum;


public class ValidaEntradaLogin{

	
	public EntradaLogin validaDadosLogin(HttpServletRequest request) throws ParametroDeEntradaInvalidoException {
		
		ValidacaoComum validacao = new ValidacaoComum();
		EntradaLogin entrada = new EntradaLogin();
		
		String usuario = validacao.verificaBrancoRequest(request, "login"); 
		String senha = validacao.verificaBrancoRequest(request, "senha");
		
		entrada.setUsuario(usuario);
		entrada.setSenha(senha);
		
		return entrada;
	}

	
	
	
}
