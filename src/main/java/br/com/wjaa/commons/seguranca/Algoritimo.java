/**
 * 
 */
package br.com.wjaa.commons.seguranca;

/**
 * @author arizona
 *
 */
public enum Algoritimo {
	
	/**
	 * Criptografia em SHA-1 com encode em Bas64Bits
	 */
	SHA_1 {
		@Override
		public String toString() {
	       	return "SHA-1"; //$NON-NLS-1$
		}
	}, 
	
	/**
	 * Criptografia em MD5 com encode em Bas64Bits
	 */
	MD5 { 
		@Override
		public String toString() {
			return "MD5"; //$NON-NLS-1$
		}
	};  
	
}
