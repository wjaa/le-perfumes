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

import br.com.wjaa.service.PerfumeService;
import br.com.wjaa.service.impl.ModeloBuscaPerfume;
import br.com.wjaa.service.impl.PerfumeVo;

@Controller
public class PerfumeAction  extends DispatchAction{
	
	@Autowired
	private PerfumeService perfumeService;
	
	public ActionForward salvar(ActionMapping mapping, ActionForm form, 
			HttpServletRequest request, HttpServletResponse response)throws Exception{

	try{
		
		ValidaDadosEntradaPerfume vaPerfume = new ValidaDadosEntradaPerfume();
		PerfumeForm perfumeForm  = vaPerfume.validaDadosSalvar(request);
		boolean salvou = perfumeService.salvaPerfume(perfumeForm);
		
		
		this.escreveRespostaBoolean(response.getOutputStream(), salvou);
		return null;
		
	}catch(Exception e){
		this.escreveRespostaString(response.getOutputStream(), "erro");
		e.printStackTrace();
		return null;
	}
}
	
	
	public ActionForward editar(ActionMapping mapping, ActionForm form, 
			HttpServletRequest request, HttpServletResponse response)throws Exception{

	try{
		
		ValidaDadosEntradaPerfume vaPerfume = new ValidaDadosEntradaPerfume();
		PerfumeForm perfumeForm  = vaPerfume.validaDadosSalvar(request);
		boolean alterou = perfumeService.salvaPerfume(perfumeForm);
		
		
		if(alterou){
			this.escreveRespostaBoolean(response.getOutputStream(), alterou);
			return null;
		}else{
			this.escreveRespostaBoolean(response.getOutputStream(), alterou);
			return null;
		}
	}catch(Exception e){
		this.escreveRespostaString(response.getOutputStream(), "erro");
		e.printStackTrace();
		return null;
	}
	
	
}
	
	
	
	public ActionForward buscarPerfume(ActionMapping mapping, ActionForm form, 
			HttpServletRequest request, HttpServletResponse response)throws Exception{
	
	try{
		ValidaDadosEntradaPerfume va = new ValidaDadosEntradaPerfume();
		PerfumeForm form1 = va.validaDadosBusca(request);
		ModeloBuscaPerfume modelo = perfumeService.buscaPerfume(form1);
		
		request.setAttribute("perfumeForm",form1);
		request.setAttribute("modeloBusca", modelo);
		return mapping.findForward("resultadoBuscaPerfume");/*resultadoConsultaLivros");*/
		
		
	}catch (Exception e) {
		this.escreveRespostaString(response.getOutputStream(), "erro");
		e.printStackTrace();
		return null;
	}
}
	
	public ActionForward removerPerfume(ActionMapping mapping, ActionForm form, 
			HttpServletRequest request, HttpServletResponse response)throws Exception{
		try{
			String idPerfumeStr = request.getParameter("idPerfume");
			if (StringUtils.isNotBlank(idPerfumeStr)){
				perfumeService.removerPerfume(Integer.valueOf(idPerfumeStr));
			}
			escreveRespostaBoolean(response.getOutputStream(), true);
		}catch (Exception e) {
			e.printStackTrace();
			escreveRespostaBoolean(response.getOutputStream(), false);
		}
		
		return null;
		
	}
	
	public ActionForward editarPerfume(ActionMapping mapping, ActionForm form, 
			HttpServletRequest request, HttpServletResponse response)throws Exception{
	
	try{
		PerfumeVo perfumeVo = null;
		String idPerfume = request.getParameter("idPerfume");
		
		if(idPerfume != null){
			perfumeVo = perfumeService.buscaPerfumeEdicao(idPerfume);
		}
		
		request.setAttribute("perfumeVo", perfumeVo);
		return mapping.findForward("editarPerfume");/*resultadoConsultaLivros");*/
		
		
	}catch (Exception e) {
		this.escreveRespostaString(response.getOutputStream(), "erro");
		e.printStackTrace();
		return null;
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

}
