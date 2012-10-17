/**
 * Date create26/01/2009.
 */
package br.com.wjaa.arquitetura.exception;

/**
 * @author Emerson Rodrigo Mariano (emerson.mariano@arizona.com.br).
 */
public class ResultNotFoundException extends BusinessException {

	private static final long serialVersionUID = -9031247385449270121L;

	/**
	 * @param property the property
	 */
	public ResultNotFoundException(String property) {
		super("visto.ocorrencia.notFound", property); //$NON-NLS-1$
	}

	/**
	 * @param property the property
	 * @param args the arguments
	 */
	public ResultNotFoundException(String property, String... args) {
		super("visto.ocorrencia.notFound", property, args); //$NON-NLS-1$
	}
}
