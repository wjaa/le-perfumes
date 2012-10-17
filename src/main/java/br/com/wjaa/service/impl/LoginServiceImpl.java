package br.com.wjaa.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.wjaa.arquitetura.service.impl.GenericServiceImpl;
import br.com.wjaa.commons.model.entity.Usuario;
import br.com.wjaa.controller.impl.EntradaLogin;
import br.com.wjaa.dao.LoginDao;
import br.com.wjaa.validacao.ValidacaoComum;

@Service
public class LoginServiceImpl extends GenericServiceImpl<Usuario, Integer>{
	
	
	private LoginDao loginDao;
	
	@Autowired
	public LoginServiceImpl(LoginDao loginDao) {
		super(loginDao);
		this.loginDao = loginDao;
		
	}
	
	public  Usuario verificaLoginUsuario(EntradaLogin entrada) throws Exception{
		Usuario usuario = null;
		Usuario usuarioSessao = null;
		try{
		
			ValidacaoComum validacao = new ValidacaoComum();
			String senhaCrip = validacao.criptTxt(entrada.getSenha());			
			usuario = (Usuario) this.loginDao.loginUsuario(entrada.getUsuario(), senhaCrip);
		
			//Envia somente alguns dados do usuário para Sessao
			if(usuario != null){
				usuarioSessao = new Usuario();
				usuarioSessao.setNomeUsuario(usuario.getNomeUsuario());

			}
			
		}catch (Exception e) {
			System.out.println("Inserir log na auditoria");
			throw new Exception("Erro na fabrica de login " + e.getMessage());
		}
		
		return usuarioSessao;
	}
	

	public LoginDao getLoginDao() {
		return loginDao;
	}


	public void setLoginDao(LoginDao loginDao) {
		this.loginDao = loginDao;
	}

}
