package br.com.wjaa.controller.impl;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;

import br.com.wjaa.validacao.ParametroDeEntradaInvalidoException;
import br.com.wjaa.validacao.ValidacaoComum;

public class ValidaDadosEntradaCliente {

	public ClienteForm validaDadosSalvar(HttpServletRequest request) throws ParametroDeEntradaInvalidoException {
		
		ClienteForm form = new ClienteForm();
		ValidacaoComum va = new ValidacaoComum();
		//form.setIdUsuario(Integer.valueOf(va.ehNumeroNaturalServidor(request, "idUsuario")));
		
		String dth = request.getParameter("dataNascimento");
		
		if(StringUtils.isNotBlank(dth) ){
			form.setDataNascimento(va.validaDataRequest(dth, "dd/MM/yyyy" ));
		}
		 
		String idClienteStr = request.getParameter("idCli");
		if (StringUtils.isNotBlank(idClienteStr)){
			form.setIdCliente(Integer.valueOf(idClienteStr));
		}
		
		form.setStatus(Integer.valueOf(request.getParameter("status")));
		
		String sexoStr = request.getParameter("sexo");
		if (StringUtils.isNotBlank(sexoStr)){
			form.setSexo(Integer.valueOf(sexoStr));
		}
		
		form.setFone1(this.isNull(request, "fone1"));
		form.setFone2(this.isNull(request, "fone2"));
		form.setContato(this.isNull(request, "contato") );
		form.setCpf(this.isNull(request, "cpf") );
		form.setDddFone1(this.isNull(request, "dddFone1"));
		form.setDddFone2(this.isNull(request, "dddFone2"));
		form.setEmail(this.isNull(request, "email"));
		form.setEndBairro(this.isNull(request, "bairro"));
		form.setEndCep(this.isNull(request, "cep"));
		form.setEndCidade(this.isNull(request, "cidade"));
		form.setEndComplemento(this.isNull(request, "comple"));
		form.setEndEstado(this.isNull(request, "estado"));
		form.setEndLogradouro(this.isNull(request, "logra"));
		form.setEndNumero(this.isNull(request, "numero"));
		form.setLocalTrabalho(this.isNull(request, "localTRabalho"));
		form.setLoja(this.isNull(request, "loja"));
		form.setNomeFull(this.isNull(request, "nome"));
		
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


	public ClienteForm validaDadosBusca(HttpServletRequest request) {
		
		ClienteForm form = new ClienteForm();
		
		form.setCpf(request.getParameter("cpf"));
		form.setNomeFull(request.getParameter("nome"));
		form.setFone1(request.getParameter("fone"));
		form.setLocalTrabalho(request.getParameter("localTrab"));
		
		
		return form;
	}
	
	
	
}
