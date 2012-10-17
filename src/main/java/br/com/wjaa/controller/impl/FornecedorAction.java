package br.com.wjaa.controller.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import br.com.wjaa.service.FornecedorService;

@Controller
public class FornecedorAction extends DispatchAction {
	
	@Autowired
	private FornecedorService fornecedorService;
	
	public ActionForward salvar(ActionMapping mapping, ActionForm form, 
			HttpServletRequest request, HttpServletResponse response)throws Exception{

		try{
			this.fornecedorService.salvarFornecedor((FornecedorForm)form);
			return mapping.findForward("pergunta");
		}catch(Exception e){
			e.printStackTrace();
			return mapping.findForward("falha");
		}
	}
	
	public ActionForward remover(ActionMapping mapping, ActionForm form, 
			HttpServletRequest request, HttpServletResponse response)throws Exception{

		try{
			
			String idFornecedorStr = request.getParameter("idFornecedor");
			this.fornecedorService.removeFornecedor(Integer.valueOf(idFornecedorStr));
			response.getWriter().write("true");
			return null;
			
		}catch(Exception e){
			e.printStackTrace();
			return mapping.findForward("falha");
		}
	}
	
	public ActionForward editar(ActionMapping mapping, ActionForm form, 
			HttpServletRequest request, HttpServletResponse response)throws Exception{

		try{
			String idStr = request.getParameter("idFornecedor");
			if (StringUtils.isNotBlank(idStr)){
				FornecedorForm fornecForm = this.fornecedorService.getFornecedorById(Integer.valueOf(idStr));
				request.setAttribute("fornecedorVo", fornecForm);
				
			}
			return mapping.findForward("cadastro");
			
		}catch(Exception e){
			e.printStackTrace();
			return mapping.findForward("falha");
		}
	}	
	
	public ActionForward buscar(ActionMapping mapping, ActionForm form, 
			HttpServletRequest request, HttpServletResponse response)throws Exception{

		try{
			String nome  = request.getParameter("nome");
			request.setAttribute("paramBusca", nome);
			List<FornecedorForm> fornecedores = this.fornecedorService.buscar(nome);
			
			request.setAttribute("listFornecedorVo", fornecedores);
			
			return mapping.findForward("busca");
		}catch(Exception e){
			e.printStackTrace();
			return mapping.findForward("falha");
		}
	}	
	

	/**
	 * @param fornecedorService the fornecedorService to set
	 */
	public void setFornecedorService(FornecedorService fornecedorService) {
		this.fornecedorService = fornecedorService;
	}

}
