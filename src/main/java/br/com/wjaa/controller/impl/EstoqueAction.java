package br.com.wjaa.controller.impl;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.math.NumberUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import br.com.wjaa.service.EstoqueService;
import br.com.wjaa.service.LoteService;
import br.com.wjaa.service.VendedorService;

@Controller
public class EstoqueAction extends DispatchAction {


	@Autowired
	private EstoqueService estoqueService;
	
	@Autowired
	private VendedorService vendedorService;
	
	@Autowired
	private LoteService loteService;
	
	public ActionForward controlar(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
	
		
		String por = request.getParameter("por");
		
		if (POR_LOTE.equals(por)){
			String idLote = request.getParameter("idLote");
			request.setAttribute("model", estoqueService.getEstoquePorLote(Integer.valueOf(idLote)));
			request.setAttribute("por", POR_LOTE);
			String dataInicio = request.getParameter("dataInicio");
			String dataFim = request.getParameter("dataFim");
			String paramFornecedor = request.getParameter("paramFornecedor");
			request.setAttribute("dataInicio", dataInicio);
			request.setAttribute("dataFim", dataFim);
			request.setAttribute("paramFornecedor", paramFornecedor);
			return mapping.findForward("detalhes");
		}else if (POR_VENDEDOR.equals(por)){
			request.setAttribute("model", estoqueService.getEstoquePorVendedor());
			request.setAttribute("por", POR_VENDEDOR);
		}else if (POR_PERFUME.equals(por)){
			request.setAttribute("model", estoqueService.getEstoquePorPerfume());
			request.setAttribute("por", POR_PERFUME);
		}
			
		return mapping.findForward("controlar");
	}
	
	
	public ActionForward alterar(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		Integer idLote = Integer.valueOf(request.getParameter("idLote"));
		Integer idPerfume = Integer.valueOf(request.getParameter("idPerfume"));
		
		LoteForm entradaVendedores = this.estoqueService.getEstoquePorLoteAndPerfume(idLote, idPerfume);
		LoteForm saidaVendedores = this.estoqueService.getAjusteEstoquePorLoteAndPerfume(idLote, idPerfume);
		LoteForm allPerfumes = this.loteService.getLoteById(idLote);
		
		request.setAttribute("listaEntradaVendedores", entradaVendedores);
		request.setAttribute("listaAjusteVendedores", saidaVendedores);
		request.setAttribute("vendedores", this.vendedorService.listAllVendedor());
		request.setAttribute("allPerfumes", allPerfumes);
		request.setAttribute("lote", this.loteService.getLoteByIdAndIdPerfume(idLote, idPerfume));
		
		String dataInicio = request.getParameter("dataInicio");
		String dataFim = request.getParameter("dataFim");
		String paramFornecedor = request.getParameter("paramFornecedor");
		
		String actionRetorno = "manterLote.do?dispatch=search&dataInicio=" + dataInicio + 
		"&dataFim=" + dataFim +"&paramFornecedor=" + paramFornecedor; 
		request.setAttribute("actionRetorno", actionRetorno);
		
		
		return mapping.findForward("alterar");
	}

	
	public ActionForward save(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		
		//idVendedor //aqui  uma lista. o valor a quantidade e o nome é id do vendedor
		Integer idLote = Integer.valueOf(request.getParameter("idLote"));
		Integer idPerfume = Integer.valueOf(request.getParameter("idPerfume"));
		Map<Integer,Integer> mapEntradaVendedores = this.getEntradaVendedores(request);
		
		
		this.estoqueService.saveEstoqueEntrada(idLote,idPerfume,mapEntradaVendedores);
		
		Collection<EstoqueAjusteSaidaForm> ajustes = this.getSaidaVendedores(request);
		
		this.estoqueService.saveAjusteEstoque(idLote,idPerfume,ajustes);
		
		ActionForward af = new ActionForward();
		af.setPath("/manterLote.do?dispatch=search");
		
		//ir para a busca.
		return af;
	}
	
	private Collection<EstoqueAjusteSaidaForm> getSaidaVendedores(HttpServletRequest request) {
		Map<Integer, EstoqueAjusteSaidaForm> mapVendedores = new HashMap<Integer, EstoqueAjusteSaidaForm>();
		for (Object key : request.getParameterMap().keySet()){
			String keyStr = (String)key;
			if (keyStr.contains("idVendedorSaida")){
				String idVendedorStr = keyStr.split(";")[1];
				String qtdeStr = request.getParameter(keyStr);
				
				if (NumberUtils.isNumber(idVendedorStr) &&  NumberUtils.isNumber(qtdeStr)){
					Integer idVendedor = Integer.valueOf(idVendedorStr);
					EstoqueAjusteSaidaForm estoqueAjuste = mapVendedores.get(idVendedor);
					
					if (estoqueAjuste == null){
						estoqueAjuste = new EstoqueAjusteSaidaForm();
						estoqueAjuste.setIdVendedor(idVendedor);
						mapVendedores.put(idVendedor,estoqueAjuste );
					}
					estoqueAjuste.setQtde(Integer.valueOf(qtdeStr));
					
				}
			}
			
			if (keyStr.contains("idVendedorSaidaObs")){
				String idVendedorStr = keyStr.split(";")[1];
				String obs = request.getParameter(keyStr);
				
				if (NumberUtils.isNumber(idVendedorStr)){
					Integer idVendedor = Integer.valueOf(idVendedorStr);
					EstoqueAjusteSaidaForm estoqueAjuste = mapVendedores.get(idVendedor);
					
					if (estoqueAjuste == null){
						estoqueAjuste = new EstoqueAjusteSaidaForm();
						estoqueAjuste.setIdVendedor(idVendedor);
						mapVendedores.put(idVendedor,estoqueAjuste );
					}
					estoqueAjuste.setObs(obs);
					
				}
			}
			
		}
		return mapVendedores.values();
	}
	
	private Map<Integer, Integer> getEntradaVendedores(HttpServletRequest request) {
		Map<Integer, Integer> mapVendedores = new HashMap<Integer, Integer>();
		for (Object key : request.getParameterMap().keySet()){
			String keyStr = (String)key;
			if (keyStr.contains("idVendedor") && !keyStr.contains("Saida")){
				String idVendedorStr = keyStr.split(";")[1];
				String qtdeStr = request.getParameter(keyStr);
				
				if (NumberUtils.isNumber(idVendedorStr) &&  NumberUtils.isNumber(qtdeStr)){
					mapVendedores.put(Integer.valueOf(idVendedorStr), Integer.valueOf(qtdeStr));
				}
			}
			
		}
		return mapVendedores;
	}

	private static final String POR_LOTE = "1";
	private final String POR_VENDEDOR = "2";
	private final String POR_PERFUME = "3";
	
}
