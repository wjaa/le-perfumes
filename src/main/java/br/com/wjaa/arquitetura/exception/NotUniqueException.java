package br.com.wjaa.arquitetura.exception;

/**
 * @author Paul Kuit
 */
public class NotUniqueException extends BusinessException {

	private static final long serialVersionUID = -9031247385449270121L;

	/**
	 * @param property the property
	 */
	public NotUniqueException(String property) {
		super("visto.ocorrencia.notUnique", property); //$NON-NLS-1$
	}

	/**
	 * @param property the property
	 * @param args the arguments
	 */
	public NotUniqueException(String property, String... args) {
		super("visto.ocorrencia.notUnique", property, args); //$NON-NLS-1$
	}
}
