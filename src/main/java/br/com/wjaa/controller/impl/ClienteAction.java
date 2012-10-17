package br.com.wjaa.controller.impl;

import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import br.com.wjaa.service.ClienteService;
import br.com.wjaa.service.impl.ClienteVo;
import br.com.wjaa.service.impl.ModeloBuscaCliente;

@Controller
public class ClienteAction extends DispatchAction{
	
	@Autowired
	private ClienteService clienteService; 
	
	public ActionForward salvar(ActionMapping mapping, ActionForm form, 
			HttpServletRequest request, HttpServletResponse response)throws Exception{

	try{
		
		ValidaDadosEntradaCliente vaCliente = new ValidaDadosEntradaCliente();
		
		ClienteForm clienteForm  = vaCliente.validaDadosSalvar(request);
		boolean existeCliente = clienteService.exixteCliente(clienteForm);
		
		if(existeCliente){
			this.escreveRespostaBoolean(response.getOutputStream(), existeCliente);
			return null;
		}else{
			this.escreveRespostaBoolean(response.getOutputStream(), existeCliente);
			return null;
		}
	}catch(Exception e){
		e.printStackTrace();
		return mapping.findForward("falha");
	}
}

	
	public ActionForward removerCliente(ActionMapping mapping, ActionForm form, 
			HttpServletRequest request, HttpServletResponse response)throws Exception{
		try{
			String idClienteStr = request.getParameter("idCliente");
			if (StringUtils.isNotBlank(idClienteStr)){
				this.clienteService.removeCliente(Integer.valueOf(idClienteStr));
			}
			escreveRespostaBoolean(response.getOutputStream(), true);
		}catch(Exception ex){
			ex.printStackTrace();
			escreveRespostaBoolean(response.getOutputStream(), false);
		}
		return null;
	}
	
	
	public ActionForward editar(ActionMapping mapping, ActionForm form, 
			HttpServletRequest request, HttpServletResponse response)throws Exception{

	try{
		
		ValidaDadosEntradaCliente vaCliente = new ValidaDadosEntradaCliente();
		ClienteForm clienteForm  = vaCliente.validaDadosSalvar(request);
		boolean alterou = clienteService.salvarCliente(clienteForm);
		this.escreveRespostaBoolean(response.getOutputStream(), alterou);
		return null;
		
	}catch(Exception e){
		this.escreveRespostaString(response.getOutputStream(), "erro");
		e.printStackTrace();
		return null;
	}
	
	
}
	
	
	
	public ActionForward buscarCliente(ActionMapping mapping, ActionForm form, 
			HttpServletRequest request, HttpServletResponse response)throws Exception{
	
	try{
		ValidaDadosEntradaCliente va = new ValidaDadosEntradaCliente();
		ClienteForm form1 = va.validaDadosBusca(request);
		ModeloBuscaCliente modelo = clienteService.buscaCliente(form1);
		request.setAttribute("formCliente", form1);
		request.setAttribute("modeloBusca", modelo);
		return mapping.findForward("resultadoBuscaCliente");/*resultadoConsultaLivros");*/
		
		
	}catch (Exception e) {
		e.printStackTrace();
		return mapping.findForward("falha");
	}
}
	
	
	public ActionForward editarCliente(ActionMapping mapping, ActionForm form, 
			HttpServletRequest request, HttpServletResponse response)throws Exception{
	
	try{
		ClienteVo clienteVo = null;
		String idCliente = request.getParameter("idCliente");
		
		if(idCliente != null){
			 clienteVo = clienteService.buscaClienteEdicao(idCliente);
		}
		
		request.setAttribute("clienteVo", clienteVo);
		return mapping.findForward("editarCliente");/*resultadoConsultaLivros");*/
		
		
	}catch (Exception e) {
		e.printStackTrace();
		return mapping.findForward("falha");
	}
}
	
	
	private void escreveRespostaString(OutputStream out, String retorno)throws IOException{
		String resp = retorno ;
		out.write(resp.getBytes());
		
	}
	
	
	private void escreveRespostaBoolean(OutputStream out, boolean retorno)throws IOException{
		String resp = Boolean.toString(retorno) ;
		out.write(resp.getBytes());
	}


	/**
	 * @param clienteService the clienteService to set
	 */
	public void setClienteService(ClienteService clienteService) {
		this.clienteService = clienteService;
	}
	

}
