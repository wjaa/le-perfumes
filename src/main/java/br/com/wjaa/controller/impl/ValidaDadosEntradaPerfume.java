package br.com.wjaa.controller.impl;

import javax.servlet.http.HttpServletRequest;

import br.com.wjaa.validacao.ParametroDeEntradaInvalidoException;
import br.com.wjaa.validacao.ValidacaoComum;

public class ValidaDadosEntradaPerfume {

	public PerfumeForm validaDadosSalvar(HttpServletRequest request) throws NumberFormatException, ParametroDeEntradaInvalidoException {
		
		PerfumeForm form = new PerfumeForm();
		ValidacaoComum va = new ValidacaoComum();
		 
		form.setNome(this.isNull(request, "nome"));
		form.setMarca(this.isNull(request, "marca"));
		form.setObservacao(this.isNull(request, "observ"));
		form.setTamanho(this.isNull(request, "tamanho"));
		form.setTipo(this.isNull(request, "tipo"));
		
		String idPerfume = request.getParameter("idPerfume");
		
		if(idPerfume != null){
			form.setId(Integer.valueOf(idPerfume));
		}
		
		
		
		
		return form;
	}

	public PerfumeForm validaDadosBusca(HttpServletRequest request) {
		
		PerfumeForm form = new PerfumeForm();
		
		form.setNome(request.getParameter("nome"));
		form.setMarca(request.getParameter("marca"));
		
		return form;
	}

	
	
	public String isNull(HttpServletRequest request, String nomeVariavel){
		
		String retorno = null;
		
		String str = request.getParameter(nomeVariavel);
		
		if("".equalsIgnoreCase(str) || " ".equalsIgnoreCase(str) || str == null){
			retorno = " ";
		}else{
			retorno = str;
		}
		
		return retorno;
		
	}
}
