package br.com.wjaa.controller.impl;

import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import br.com.wjaa.service.UsuarioService;
import br.com.wjaa.service.impl.ModeloBuscaUsuario;
import br.com.wjaa.service.impl.ModeloUsuarioEdicao;

@Controller
public class UsuarioAction extends DispatchAction{

	@Autowired
	private UsuarioService usuarioService;
	
	/**
	 * Salva o usuário 
	 * @param mapping
	 * @param forward
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward salvar(ActionMapping mapping, ActionForm form, 
				HttpServletRequest request, HttpServletResponse response)throws Exception{

		try{
			
			ValidaDadosEntradaUsuario vaUsuario = new ValidaDadosEntradaUsuario();
			UsuarioForm userForm  = vaUsuario.validaDadosSalvar(request);
			boolean existeUsuario = usuarioService.existeUsuario(userForm);
			this.escreveRespostaBoolean(response.getOutputStream(), existeUsuario);
			return null;
			
		}catch(Exception e){
			e.printStackTrace();
			return mapping.findForward("falha");
		}
		
		
	}
	
	/**
	 * Escreve resposta para o request, no form de cadastro de usuário
	 * @param out
	 * @param retorno
	 * @throws IOException
	 */
	private void escreveRespostaBoolean(OutputStream out, boolean retorno)throws IOException{
		String resp = Boolean.toString(retorno) ;
		out.write(resp.getBytes());
	}
	
	
	/**
	 * Edita os dados do usuário
	 * @param mapping
	 * @param forward
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward editar(ActionMapping mapping, ActionForm form, 
				HttpServletRequest request, HttpServletResponse response)throws Exception{
			
		try{
			
			ValidaDadosEntradaUsuario va = new ValidaDadosEntradaUsuario();
			EntradaUsuario entrada = va.validaDadosEdicao(request);
			ModeloUsuarioEdicao modeloEdicao = null;
			modeloEdicao = usuarioService.getUsuarioEdicao(entrada);
			request.setAttribute("modelo", modeloEdicao);
			return mapping.findForward("edit");
		}catch (Exception e) {
			log.error("Erro ao editar usuario", e);
			return mapping.findForward("falha");
		}
		
	}
	
	/**
	 * Deleta um usuario no banco de dados
	 * @param mapping
	 * @param forward
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward removerUsuario(ActionMapping mapping, ActionForm form, 
				HttpServletRequest request, HttpServletResponse response)throws Exception{	
		try{
			ValidaDadosEntradaUsuario va = new ValidaDadosEntradaUsuario();
			EntradaUsuario entrada  = va.validaDadosDelete(request);
			usuarioService.removerUsuario(entrada);
			
			this.escreveRespostaBoolean(response.getOutputStream(), true);
			
		}catch (Exception e) {
			e.printStackTrace();
			this.escreveRespostaBoolean(response.getOutputStream(), false);
		}
		
		return null;
		
	}
	
	
	
	
	
	
	
	/**
	 * Escreve resposta para o request, no form de cadastro de usuário
	 * @param out
	 * @param retorno
	 * @throws IOException
	 */
	private void escreveRespostaString(OutputStream out, String retorno)throws IOException{
		String resp = retorno ;
		out.write(resp.getBytes());
	}
	
	
	
	public ActionForward buscarUsuario(ActionMapping mapping, ActionForm form, 
				HttpServletRequest request, HttpServletResponse response)throws Exception{
		
		try{
			ValidaDadosEntradaUsuario va = new ValidaDadosEntradaUsuario();
			EntradaUsuario entrada = va.validaDadosBusca(request);
			ModeloBuscaUsuario modelo = usuarioService.buscaUsuario(entrada);
			
			request.setAttribute("paramBusca", entrada.getNomeFull());
			
			request.setAttribute("modeloBusca", modelo);
			return mapping.findForward("resultadoBuscaUsuario");/*resultadoConsultaLivros");*/
			
			
		}catch (Exception e) {
			e.printStackTrace();
			return mapping.findForward("falha");
		}
	}

	/**
	 * @param usuarioService the usuarioService to set
	 */
	public void setUsuarioService(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}
	
	
	
	
	
}
