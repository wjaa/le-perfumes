package br.com.wjaa.controller.impl; 

import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import br.com.wjaa.commons.model.entity.Usuario;
import br.com.wjaa.service.impl.LoginServiceImpl;

/**
 * 
 * @author Wagner
 *
 */
@Controller
public class LoginAction extends DispatchAction{

	
	
	private static Log log = LogFactory.getLog(LoginAction.class);
	
	@Autowired
	private LoginServiceImpl loginService;


	public LoginAction() {
		super();
	}
	
	
	
	public ActionForward verificaUsuario(ActionMapping mapping,ActionForm form,
			HttpServletRequest request,HttpServletResponse response)throws Exception{
		
		try{
			
			ValidaEntradaLogin va = new ValidaEntradaLogin();
			EntradaLogin entrada = va.validaDadosLogin(request);
			Usuario usuario = this.loginService.verificaLoginUsuario(entrada);
			String erro = "";
			
			if(usuario == null){
				erro = "error";
				 this.escreveRespostaString(response.getOutputStream(), erro);
				
				 return null;
			}else{
				erro = "logado";
				this.escreveRespostaString(response.getOutputStream(), erro);
				return null;
				
			}
		}catch(Exception e){
			System.out.println("Logar na auditoria " + e.getMessage());
			return mapping.findForward("login");
		}
	}
	
	
	public ActionForward login(ActionMapping mapping,ActionForm form,
			HttpServletRequest request,HttpServletResponse response)throws Exception{
		
		try{
			ValidaEntradaLogin va = new ValidaEntradaLogin();
			EntradaLogin entrada = va.validaDadosLogin(request);
			Usuario usuario = this.loginService.verificaLoginUsuario(entrada);
			
			if(usuario == null){
				request.setAttribute("erro", "erro");
				return mapping.findForward("login");
			}else{
				
				HttpSession session = request.getSession(true);
				session.setMaxInactiveInterval(30*60);
				request.setAttribute("user", usuario);
				session.setAttribute("usuario", usuario);
				
				return mapping.findForward("logado");
			}
		}catch(Exception e){
			System.out.println("Logar na auditoria " + e.getMessage());
			return mapping.findForward("login");
		}
	}
	
	
	/**
	 * Escreve resposta para o request, no form de login de usuário
	 * @param out
	 * @param retorno
	 * @throws IOException
	 */
	private void escreveRespostaString(OutputStream out, String erro)throws IOException{
		String resp = erro ;
		out.write(resp.getBytes());
	}
	
	public void setLoginService(LoginServiceImpl loginService) {
		this.loginService = loginService;
	}
	
}
