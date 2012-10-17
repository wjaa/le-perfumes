/**
 * Date create 06/04/2009.
 */
package br.com.wjaa.commons.seguranca;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import sun.misc.BASE64Encoder;

/**
 * Class encritografa senha.
 * 
 * @author Pablo Leon (pablo.leon@arizona.com.br)
 */
public final class Criptografia {

	private static BASE64Encoder enc = new BASE64Encoder();
	
	private static Log log = LogFactory.getLog(Criptografia.class);

	/**
	 * Criptografa uma senha
	 * 
	 * @param texto o texto
	 * @param algor Algoritimo para criptografia
	 * @return String do texto em hash usando padro SHA-1 com Encode de
	 *         Base64Bits
	 */
	public static String criptografar(String texto, Algoritimo algor ) {
		byte[] gerado = null;
		
		String txtCript = ""; //$NON-NLS-1$
		StringBuffer sb = new StringBuffer();

		if (texto != null) {
			try {
				MessageDigest shaOne = MessageDigest.getInstance(algor.toString());
				shaOne.update(texto.getBytes());
				gerado = shaOne.digest();
				
				switch (algor) {
					case MD5:{
						for (int i = 0; i < gerado.length; i++) {
							sb.append(Integer.toHexString(gerado[i]));
						}
						txtCript = sb.toString();
					} break;

					case SHA_1:{
						txtCript = enc.encode(gerado);
					} break;
				}
				
			} catch (NoSuchAlgorithmException e) {
				log.error("Erro ao cripitografar senha em " + algor, e); //$NON-NLS-1$
			}
		}
		return txtCript;
	}
	

}
