package br.com.wjaa.validacao;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;

/**
 * 
 * @author Thiago
 *
 */
public class ValidacaoComum {
	
	
	/**
	 * Verifica se uma determinada variavel do request a um numero natural maior que zero
	 * @param request
	 * @param nomeVariavel
	 * @return
	 * @throws ParametroDeEntradaInvalidoException
	 */
	public String ehNumeroNaturalServidor(HttpServletRequest request, String nomeVariavel)
			throws ParametroDeEntradaInvalidoException {
		String id = request.getParameter(nomeVariavel);
		try {
			id = this.ehNumeroNatural(id);
		} catch (ParametroDeEntradaInvalidoException e) {
			throw new ParametroDeEntradaInvalidoException("campo: '" + nomeVariavel + "' - " + e.getMessage());
		}
		return id;
	}
	
	
	
	
	public String validaEmailRequest(HttpServletRequest request, String email) throws Exception{
		 
		String mail = request.getParameter("email");
		
			if(!"".equalsIgnoreCase(mail) || mail != null){
				
				Pattern p = Pattern.compile("^[\\w-]+(\\.[\\w-]+)*@([\\w-]+\\.)+[a-zA-Z]{2,7}$");
				Matcher m = p.matcher(mail);
				
				if (!m.find()){
					throw new Exception("Email Invalido " + mail);
				}
			}else{
				throw new Exception("Email do Farmulario esta em branco");
			}
		
		return mail;
		
	}
	
	
	/**
	 * Recupera o paramentro da meu request e manda para validaaao do cpf,
	 * caso o cpf nao seja valido, sera lanaado uma exception
	 * @param request
	 * @param cpf
	 * @return
	 * @throws ParametroDeEntradaInvalidoException
	 */
	public Long validaCpfRequest(HttpServletRequest request, String cpf) throws ParametroDeEntradaInvalidoException{
		String c = request.getParameter(cpf);
		String stringCpf = "";
		Long retorno = null;
		
		if(!"".equalsIgnoreCase(c) || c != null){
				if(valida_CpfCnpj(c)){
					stringCpf = limpaCpf(c);
					retorno = Long.valueOf(stringCpf);
				}else{
					throw new ParametroDeEntradaInvalidoException("Cpf Invalido: " + cpf );
				}
		}else{
			throw new ParametroDeEntradaInvalidoException("Cpf em Branco: " + cpf );
		}
		
		return 	retorno;
	}
	
	/**
	 * Realiza a validacao de CPF E CNPJ
	 * @param s_aux
	 * @return
	 */
	public boolean valida_CpfCnpj(String s_aux){
		
		// Rotina para CPF
		
		s_aux = limpaCpf(s_aux);
        if (s_aux.length() == 11 ) {
        	int     d1, d2;
        	int     digito1, digito2, resto;
        	int     digitoCPF;
        	String  nDigResult;
        	d1 = d2 = 0;
        	digito1 = digito2 = resto = 0;
        	for (int n_Count = 1; n_Count < s_aux.length() -1; n_Count++) {
        		digitoCPF = Integer.valueOf (s_aux.substring(n_Count -1, n_Count)).intValue();
        		// Multiplique a ultima casa por 2 a seguinte por 3 a seguinte por 4 e assim por diante.
        		d1 = d1 + ( 11 - n_Count ) * digitoCPF;
        		// Para o segundo digito repita o procedimento incluindo o primeiro digito calculado no passo anterior.
        		d2 = d2 + ( 12 - n_Count ) * digitoCPF;
        	}
        	// Primeiro resto da divisao por 11.
        	resto = (d1 % 11);
        	// Se o resultado for 0 ou 1 o digito a 0 caso contrario o digito a 11 menos o resultado anterior.
        	if (resto < 2)
        		digito1 = 0;
        	else
              	digito1 = 11 - resto;
        	d2 += 2 * digito1;
        	// Segundo resto da divisao por 11.
        	resto = (d2 % 11);
        	// Se o resultado for 0 ou 1 o digito a 0 caso contrario o digito a 11 menos o resultado anterior.
        	if (resto < 2)
        		digito2 = 0;
        	else
        		digito2 = 11 - resto;
        	// Digito verificador do CPF que esta sendo validado.
        	String nDigVerific = s_aux.substring (s_aux.length()-2, s_aux.length());
        	// Concatenando o primeiro resto com o segundo.
        	nDigResult = String.valueOf(digito1) + String.valueOf(digito2);
        	// Comparar o digito verificador do cpf com o primeiro resto + o segundo resto.
        	
        	/*
        	if(!retorno){
        		throw new Exception("Erro au validar cpf ");
        	}*/
        	
        	
        	return nDigVerific.equals(nDigResult);
        }
        // Rotina para CNPJ        
        else if (s_aux.length() == 14) {
            int soma = 0, dig;
            String cnpj_calc = s_aux.substring(0,12);
            char[] chr_cnpj = s_aux.toCharArray();
            // Primeira parte
            for( int i = 0; i < 4; i++ )
            	if ( chr_cnpj[i]-48 >=0 && chr_cnpj[i]-48 <=9 )
            		soma += (chr_cnpj[i] - 48) * (6 - (i + 1));
            for( int i = 0; i < 8; i++ )
            	if ( chr_cnpj[i+4]-48 >=0 && chr_cnpj[i+4]-48 <=9 )
            		soma += (chr_cnpj[i+4] - 48) * (10 - (i + 1));
            dig = 11 - (soma % 11);
            cnpj_calc += ( dig == 10 || dig == 11 ) ?
                "0" : Integer.toString(dig);
            // Segunda parte
            soma = 0;
            for ( int i = 0; i < 5; i++ )
            	if ( chr_cnpj[i]-48 >=0 && chr_cnpj[i]-48 <=9 )
            		soma += (chr_cnpj[i] - 48) * (7 - (i + 1));
            for ( int i = 0; i < 8; i++ )
            	if ( chr_cnpj[i+5]-48 >=0 && chr_cnpj[i+5]-48 <=9 )
            		soma += (chr_cnpj[i+5] - 48) * (10 - (i + 1));
            dig = 11 - (soma % 11);
            cnpj_calc += ( dig == 10 || dig == 11 ) ?
                        "0" : Integer.toString(dig);
            return s_aux.equals(cnpj_calc);
        }
        else
            return false;
    }
	
	/**
	 * Limpa a string cpf da mascara
	 * @param c
	 * @return
	 */
	public String limpaCpf(String c){
		
		String cpf = "";
		cpf = c.replace(".", "");
		cpf = cpf.replace("-", "");
		
		return cpf;
	}
	
	
	/**
	 * Verifica se a String esta nula
	 * @param str
	 * @return
	 */
	public String verificaBrancoRequest(HttpServletRequest request, String nomeVariavel)throws ParametroDeEntradaInvalidoException{
		
		String str = request.getParameter(nomeVariavel);
		
		try{
			str = this.verificaBranco(str);
		}catch (Exception e) {
			throw new ParametroDeEntradaInvalidoException(str + "a um parametro invalido");
		}
			return str;
	}

	
	
	/**
	 * Verifica se a string nao esta em branco ou nula
	 * @param str
	 * @return
	 * @throws ParametroDeEntradaInvalidoException
	 */
	public String verificaBranco(String str)throws ParametroDeEntradaInvalidoException{
		
		if("".equalsIgnoreCase(str) || " ".equalsIgnoreCase(str) || str == null){
			throw new ParametroDeEntradaInvalidoException(str + " esta invalido");
		}
		
		return str;
	}
	
	
	public String verificaSenhasIguais(HttpServletRequest request, String senha, String senhaConfirm) throws ParametroDeEntradaInvalidoException{
		String retorno=null;
		String passw = request.getParameter(senha);
		String confirma = request.getParameter(senhaConfirm);
		
		try{
			retorno = verificaSenhas(passw, confirma);
		}catch (Exception e) {
			throw new ParametroDeEntradaInvalidoException("Erro ao salvar senha " + e.getMessage());
		}		
		
		return retorno;
	}
	
	
	public String verificaSenhas(String senha, String senhaConfirm) throws ParametroDeEntradaInvalidoException{
		if(!senha.equals(senhaConfirm)){
			throw new ParametroDeEntradaInvalidoException("Erro ao verificar as senhas");
		}
		if (StringUtils.isNotBlank(senha)){
			return this.criptTxt(senha);
		}else{
			return "";
		}
		
	}
	
	
	
	/**
	 * 
	 * @param id
	 * @return
	 * @throws ParametroDeEntradaInvalidoException
	 */
	public String ehNumeroNatural(String id) throws ParametroDeEntradaInvalidoException  {
		String numero = id;
		
		if("".equals(numero) || "0".equals(numero) || (!this.stringContemSomenteDigitos(numero))) {
			throw new ParametroDeEntradaInvalidoException("'" + id + "' a invalido");
		}
		return id;
	}
	
	/**
	 * Verifica se uma Data obtida atraves do request a valida  
	 * @param mascara
	 * @param nomeVariavel
	 * @param request
	 * @return
	 * @throws ParametroDeEntradaInvalidoException
	 */
	public Date validaDataRequest(String data, String mascara) throws ParametroDeEntradaInvalidoException {
		 
		return this.validaData(mascara, data);
	}
	
	/**
	 * Converte uma Data numa String
	 * @param mascara
	 * @param data
	 * @return
	 * @throws ParametroDeEntradaInvalidoException
	 */
	public Date validaData(String mascara, String data) throws ParametroDeEntradaInvalidoException {
		
		DateFormat df = new SimpleDateFormat(mascara);
		Date dt;
		try {
			dt = (Date)df.parse(data);
			String teste = df.format(dt);
			System.out.println(teste);
		} catch (ParseException e) {
			throw new ParametroDeEntradaInvalidoException("Data: '" + data + 
					"' invalida para a mascara: '" + mascara + "'", e);
		}
		
		return dt;
	}
	
	/**
	 * Retorna verdadeiro se todos os 'chars' da string passada como parametro sao digitos: "Character.isDigit(str.charAt(i));"
	 * @param str a string a ser verificada
	 * @return verdadeiro se a string so contem digitos
	 */
	public boolean stringContemSomenteDigitos(String str) {
		boolean retorno = true;
		if(str != null && str.length() > 0) {
			for (int i = 0; i < str.length() ; i++) {
				retorno &= Character.isDigit(str.charAt(i));
			}
		} else {
			retorno = false;
		}
		
		return retorno;
	}
	

	
	/**
	 * Retira os espaaos em branco da string 
	 * @param str
	 * @return
	 */
	public String retiraBranco(String str){
		String retorno = str.replace(" ", "");
		
		return retorno;
	}

	
	/**
	 * Verifica se existe espaaos em branco na string
	 * @param str
	 * @return
	 */
	public boolean existeBranco(String str){
		boolean retorno = true;

		int existeBranco = str.indexOf(" ");
		
		if(existeBranco >= 0){
			retorno = false;
		}
		
		return retorno;
	}

	
	/**
	 * 
	 * @param msg
	 * @return
	 */
	 public  String criptTxt(String msg) {
        if(msg == null) return "";
        
        byte[] gerado = null;
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(msg.getBytes());
            gerado = md.digest();
             
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < gerado.length; i++) {
            sb.append(Integer.toHexString(gerado[i]));
        }
        return sb.toString();
	 }
	
	
}
