package br.com.wjaa.controller.impl;

import java.io.IOException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import br.com.wjaa.exception.BusinessException;
import br.com.wjaa.service.ClienteService;
import br.com.wjaa.service.VendaService;
import br.com.wjaa.service.VendedorService;

@Controller
public class VendaAction extends DispatchAction {

	@Autowired
	private VendaService vendaService;
	
	@Autowired
	private VendedorService vendedorService;
	
	@Autowired
	private ClienteService clienteService;
	

	public ActionForward createEdit(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String idVendaStr = request.getParameter("idVenda");
		
		VendaForm vendaForm = vendaService.getVendaById(StringUtils.isNotBlank(idVendaStr)? Integer.valueOf(idVendaStr) : null);
		request.setAttribute("vendaForm", vendaForm);
		
		return mapping.findForward("createEdit");
	}
	
	public ActionForward search(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		String dataInicio = request.getParameter("dataInicio");
		String dataFim = request.getParameter("dataFim");
		String idVendedor = request.getParameter("idVendedor");
		String idCliente = request.getParameter("idCliente");
		String idStatus = request.getParameter("idStatus");
		
		if (StringUtils.isBlank(dataInicio) && StringUtils.isBlank(dataFim) && StringUtils.isBlank(idVendedor)
				&& StringUtils.isBlank(idCliente) && StringUtils.isBlank(idStatus) ){
			Calendar calendarIni = GregorianCalendar.getInstance();
	    	calendarIni.set(calendarIni.get(Calendar.YEAR), calendarIni.get(Calendar.MONTH), 1);
	    	
	    	Calendar calendarFim = GregorianCalendar.getInstance();
	    	calendarFim.set(calendarFim.get(Calendar.YEAR), calendarFim.get(Calendar.MONTH), calendarFim.getActualMaximum(Calendar.DAY_OF_MONTH));
	    	
	    	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	    	
	    	dataInicio = sdf.format(calendarIni.getTime()) ;
	    	dataFim = sdf.format(calendarFim.getTime()) ;
		}
		
		List<VendaForm> vendas = vendaService.buscaVenda(dataInicio,dataFim,idVendedor,idCliente, idStatus);
		
		request.setAttribute("vendedores", vendedorService.listAllVendedor());
		request.setAttribute("clientes", clienteService.getAllCliente());
		request.setAttribute("vendas", vendas);
		request.setAttribute("dataInicio", dataInicio);
		request.setAttribute("dataFim", dataFim);
		request.setAttribute("idVendedor", idVendedor);
		request.setAttribute("idCliente", idCliente);
		request.setAttribute("idStatus", idStatus);
		
		
		return mapping.findForward("search");
	}
	
	
	public ActionForward save(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response){
		
		try{
			this.recuperaParams(request, form);
			this.vendaService.saveVenda((VendaForm)form);
			return mapping.findForward("pergunta");
			
		}catch(BusinessException ex){
			log.error("Erro na regra de negocio.", ex);
			response.setCharacterEncoding("UTF-8");
			response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			
			try {
				response.getWriter().write(ex.getMessage());
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}catch(Exception ex){
			log.error("Erro ao salvar a venda", ex);
			response.setCharacterEncoding("UTF-8");
			response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			
		}
		return null;
		
		
	}
	
	
	private void recuperaParams(HttpServletRequest request, ActionForm form) {
		VendaForm vendaForm = (VendaForm)form;
		Map<Integer, VendaItemForm> perfumes = new HashMap<Integer, VendaItemForm>();
		Map<Integer, VendaPrazoForm> prazos = new HashMap<Integer, VendaPrazoForm>();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		if (!ArrayUtils.isEmpty(vendaForm.getPerfume())){
			for (String p : vendaForm.getPerfume() ){
				Integer idPerfume = Integer.valueOf(p);
				VendaItemForm vendaItemForm = new VendaItemForm();
				vendaItemForm.setIdPerfume(idPerfume);
				perfumes.put(idPerfume, vendaItemForm);
			}
		}
		
		
		for(Object key : request.getParameterMap().keySet()){
			String keyStr = (String) key;
			if (keyStr.contains("quantidade")){
				String qtd [] =keyStr.split(";");
				Integer idPerfume = Integer.valueOf(qtd[1]);
				VendaItemForm perf = perfumes.get(idPerfume);
				perf.setQtde(Integer.valueOf(request.getParameter(keyStr)));
				
			}else if (keyStr.contains("preco")){
				String prec [] =keyStr.split(";");
				Integer idPerfume = Integer.valueOf(prec[1]);
				VendaItemForm perf = perfumes.get(idPerfume);
				String value = request.getParameter(keyStr).replace(",", ".");
				perf.setPrecoUnitario(Double.valueOf(value));
				
			}else if (keyStr.contains("dataPrazo") && vendaForm.getIdFormaPagamento() == 2){
				Integer idPrazo = Integer.valueOf(keyStr.replace("dataPrazo", ""));
				VendaPrazoForm prazo = prazos.get(idPrazo);
				
				if (prazo == null){
					prazo = new VendaPrazoForm();
					prazos.put(idPrazo, prazo);
				}
				
				String data = request.getParameter(keyStr);
				
				try {
					prazo.setDataVencimento(sdf.parse(data));
				} catch (ParseException e) {
					e.printStackTrace();
				}
				
			}else if (keyStr.contains("diaPrazo") && vendaForm.getIdFormaPagamento() == 2){
				Integer idPrazo = Integer.valueOf(keyStr.replace("diaPrazo", ""));
				VendaPrazoForm prazo = prazos.get(idPrazo);
				
				if (prazo == null){
					prazo = new VendaPrazoForm();
					prazos.put(idPrazo, prazo);
				}
				
				String dia = request.getParameter(keyStr);
				prazo.setDias(Integer.valueOf(dia));
				
			}else if (keyStr.contains("pago") && vendaForm.getIdFormaPagamento() == 2){
				Integer idPrazo = Integer.valueOf(keyStr.replace("pago", ""));
				VendaPrazoForm prazo = prazos.get(idPrazo);
				
				if (prazo == null){
					prazo = new VendaPrazoForm();
					prazos.put(idPrazo, prazo);
				}
				
				String valuePago = request.getParameter(keyStr);
				prazo.setPago("on".equalsIgnoreCase(valuePago) );
				
			}
			
		}
		vendaForm.setVendaItem(perfumes.values());
		vendaForm.setVendaPrazo(prazos.values());
	}
	
	
	public ActionForward remover(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		String idVendaStr = request.getParameter("idVenda");
		this.vendaService.removerVenda(Integer.valueOf(idVendaStr));
		
		
		response.getWriter().write("true");
		
		
		return null;
	}
	
	public ActionForward pagamentos(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		String idVenda = request.getParameter("idVenda");
		
		List<VendaPagamentoForm> pagamentos = this.vendaService.getPagamentos(Integer.valueOf(idVenda));
		
		VendaForm venda = this.vendaService.getVendaById(Integer.valueOf(idVenda));
		PagamentoForm p = new PagamentoForm();
		p.setDataVenda(venda.getDataVenda());
		p.setNomeCliente(venda.getNomeCliente());
		p.setValor(venda.getValorVenda());
		p.setPagamentos(pagamentos);
		p.setIdVenda(venda.getId());
		int qtdeParcela = venda.getVendaPrazo() != null ? venda.getVendaPrazo().size() : 1;
		p.setQtdeParcela(qtdeParcela == 0 ? 1 : qtdeParcela);
		
		request.setAttribute("pgto",p);
		
		String dataInicio = request.getParameter("dataInicio");
		String dataFim = request.getParameter("dataFim");
		String idVendedor = request.getParameter("idVendedor");
		String idCliente = request.getParameter("idCliente");
		String idStatus = request.getParameter("idStatus");
		
		request.setAttribute("dataInicio", dataInicio);
		request.setAttribute("dataFim", dataFim);
		request.setAttribute("idVendedor", idVendedor);
		request.setAttribute("idCliente", idCliente);
		request.setAttribute("idStatus", idStatus);
		
		return mapping.findForward("pgto");
	}
	
	
	public ActionForward addPagamentos(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception{
		Integer idVenda = Integer.valueOf(request.getParameter("idVenda"));
		List<VendaPagamentoForm> pagamentos = this.getParams(request, idVenda);
		this.vendaService.savePagamentos(pagamentos, idVenda);
		
		
		return search(mapping, form, request, response);
	}

	private List<VendaPagamentoForm> getParams(HttpServletRequest request, Integer idVenda) throws ParseException {
		List<VendaPagamentoForm> pagamentos = new ArrayList<VendaPagamentoForm>();
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		DecimalFormat df = new DecimalFormat("##.00");
		
		for(Object key : request.getParameterMap().keySet()){
			String keyStr = (String) key;
			if (keyStr.contains("novoPgto") || keyStr.contains("pgto")){
				String v = request.getParameter(keyStr);
				String[] values = v.split(";");
				VendaPagamentoForm vpf = new VendaPagamentoForm();
				
				vpf.setData(sdf.parse(values[0]));
				vpf.setValor(df.parse(values[1]).doubleValue());
				vpf.setIdVenda(idVenda);
				pagamentos.add(vpf);
			}
		}
		
		
		return pagamentos;
	}
		
	
	
}
