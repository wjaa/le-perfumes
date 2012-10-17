package br.com.wjaa.controller.impl;

import java.util.HashMap;
import java.util.Map;

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
import br.com.wjaa.service.LoteService;
import br.com.wjaa.service.PerfumeService;

@Controller
public class LoteAction extends DispatchAction {
	
	@Autowired
	private LoteService loteService;
	
	@Autowired
	private FornecedorService fornecedorService;
	
	@Autowired
	private PerfumeService perfumeService;
	
	public ActionForward createEdit(ActionMapping mapping, ActionForm form, 
			HttpServletRequest request, HttpServletResponse response)throws Exception{
		
		try{
			LoteForm loteForm = new LoteForm();
			String idStrLote = request.getParameter("idLote");
			
			if (StringUtils.isNotBlank(idStrLote)){
				loteForm = this.loteService.getLoteById(Integer.valueOf(idStrLote));
			}
			
			loteForm.setFornecedores(this.fornecedorService.getAllFornecedorForm());
			loteForm.setPerfumes(perfumeService.getAllPerfumeForm());
			
			
			
			request.setAttribute("model", loteForm);
			return mapping.findForward("cadastro");
		}catch(Exception e){
			e.printStackTrace();
			return mapping.findForward("falha");
		}
	}
	
	
	public ActionForward save(ActionMapping mapping, ActionForm form, 
			HttpServletRequest request, HttpServletResponse response)throws Exception{
		
		this.recuperaParams(request,form);
		this.loteService.saveLote((LoteForm)form);
		
		return mapping.findForward("pergunta");
	}
	
	
	


	public ActionForward search(ActionMapping mapping, ActionForm form, 
			HttpServletRequest request, HttpServletResponse response)throws Exception{
		
		String dataInicio = request.getParameter("dataInicio");
		String dataFim = request.getParameter("dataFim");
		String paramFornecedor = request.getParameter("paramFornecedor");

		request.setAttribute("dataInicio", dataInicio);
		request.setAttribute("dataFim", dataFim);
		request.setAttribute("paramFornecedor", paramFornecedor);
		
		request.setAttribute("lotes", this.loteService.buscar(dataInicio,dataFim, paramFornecedor));
		request.setAttribute("fornecedores", this.fornecedorService.getAllFornecedorForm());
		
		return mapping.findForward("busca");
	}
	
	
	public ActionForward remover(ActionMapping mapping, ActionForm form, 
			HttpServletRequest request, HttpServletResponse response)throws Exception{
		 String idLoteStr = request.getParameter("idLote");
		 
		 this.loteService.removeLote(Integer.valueOf(idLoteStr));
		 
		 response.getWriter().write("true");
		 
		 return null;
	}
	
	private void recuperaParams(HttpServletRequest request, ActionForm form) {
		LoteForm loteForm = (LoteForm)form;
		Map<Integer, LoteProdutoForm> perfumes = new HashMap<Integer, LoteProdutoForm>();
		
		for (String p : loteForm.getPerfume() ){
			Integer idPerfume = Integer.valueOf(p);
			LoteProdutoForm loteProduto =  new LoteProdutoForm();
			loteProduto.setIdPerfume(idPerfume);
			perfumes.put(idPerfume, loteProduto);
		}
		
		for(Object key : request.getParameterMap().keySet()){
			String keyStr = (String) key;
			if (keyStr.contains("quantidade")){
				String qtd [] =keyStr.split(";");
				Integer idPerfume = Integer.valueOf(qtd[1]);
				LoteProdutoForm perf = perfumes.get(idPerfume);
				perf.setQuantidade(Integer.valueOf(request.getParameter(keyStr)));
				
			}
			
			if (keyStr.contains("preco")){
				String prec [] =keyStr.split(";");
				Integer idPerfume = Integer.valueOf(prec[1]);
				LoteProdutoForm perf = perfumes.get(idPerfume);
				String value = request.getParameter(keyStr).replace(",", ".");
				perf.setPreco(Double.valueOf(value));
				
			}
		}
		loteForm.setLoteProdutoForm(perfumes.values());
	}
	
	
	/**
	 * @param fornecedorService the fornecedorService to set
	 */
	public void setFornecedorService(FornecedorService fornecedorService) {
		this.fornecedorService = fornecedorService;
	}

	/**
	 * @param loteService the loteService to set
	 */
	public void setLoteService(LoteService loteService) {
		this.loteService = loteService;
	}


	/**
	 * @param perfumeService the perfumeService to set
	 */
	public void setPerfumeService(PerfumeService perfumeService) {
		this.perfumeService = perfumeService;
	}

}
