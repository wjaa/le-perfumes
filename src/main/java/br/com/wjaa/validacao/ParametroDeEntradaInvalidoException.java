package br.com.wjaa.validacao;

public class ParametroDeEntradaInvalidoException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1028254567724634106L;

	/**
	 * @param msg
	 */
	public ParametroDeEntradaInvalidoException(String msg) {
		super(msg);
	}
	
	/**
	 * @param msg
	 * @param t
	 */
	public ParametroDeEntradaInvalidoException(String msg, Throwable t) {
		super(msg, t);
	}
}

