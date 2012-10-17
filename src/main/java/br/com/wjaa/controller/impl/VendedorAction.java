package br.com.wjaa.controller.impl;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import br.com.wjaa.service.VendedorService;

/**
 * 
 * @author Wagner
 *
 */
@Controller
public class VendedorAction extends DispatchAction {

	
	@Autowired
	private VendedorService vendedorService;
	
	public ActionForward saveEdit(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		try{
			this.vendedorService.saveVendedor((VendedorForm)form);
			return mapping.findForward("pergunta");
		}catch(Exception ex){
			return mapping.findForward("falha");
		}
		
	}
	
	
	public ActionForward list(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		try{
			String nome = request.getParameter("nome");
			List<VendedorForm> models = this.vendedorService.listVendedorByName(nome);
			
			request.setAttribute("pnome", nome);
			request.setAttribute("models", models);
			
			return mapping.findForward("busca");
		}catch(Exception ex){
			return mapping.findForward("falha");
		}
	}

	
	
	public ActionForward remove(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		try{
			String idVendedor = request.getParameter("idVendedor");
			this.vendedorService.remove(Integer.valueOf(idVendedor));
			this.escreveRespostaBoolean(response.getOutputStream(),true);
			return null;
		}catch(Exception ex){
			return mapping.findForward("falha");
		}
	}
	
	
	
	private void escreveRespostaBoolean(OutputStream out, boolean retorno)throws IOException{
		String resp = Boolean.toString(retorno) ;
		out.write(resp.getBytes());
	}
	
	public ActionForward viewCreate(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		try{
			String idVendedor = request.getParameter("idVendedor");
			VendedorForm vForm = this.vendedorService.getVendedorById(Integer.valueOf(idVendedor));
			request.setAttribute("model", vForm);
			return mapping.findForward("cadastro");
		}catch(Exception ex){
			return mapping.findForward("falha");
		}
	}
	
}
