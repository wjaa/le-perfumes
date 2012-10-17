package br.com.wjaa.arquitetura.exception;

import java.util.Collection;

/**
 * @author Paul Kuit
 */
public abstract class BusinessException extends Exception {

	private static final long serialVersionUID = 1L;
	private String bundleString, property;
	private String[] args;
	private Collection<String> nomes;
	private Collection<?> collection;

	/**
	 * @param bundleString the bundleString
	 * @param property the property
	 */
	public BusinessException(String bundleString, String property) {
		this.bundleString = bundleString;
		this.property = property;
	}

	/**
	 * @param bundleString the bundleString
	 * @param property the propety
	 * @param args the arguments
	 */
	public BusinessException(String bundleString, String property,
			String... args) {
		this.bundleString = bundleString;
		this.property = property;
		this.args = args;
	}

	/**
	 * @param bundleString the bundleString
	 * @param property the propety
	 * @param nomes the nomes
	 */
	public BusinessException(String bundleString, String property,
			Collection<String> nomes) {
		this.bundleString = bundleString;
		this.property = property;
		this.nomes = nomes;
	}

	/**
	 * @param bundleString the bundleString
	 * @param collection the collection
	 */
	public BusinessException(String bundleString, Collection<?> collection) {
		this.bundleString = bundleString;
		this.bundleString = bundleString;
		this.collection = collection;
	}

	/**
	 * @return os argumentos da execao para parametrizacao da mensagem; por
	 *         exemplo; o valor deve ser menor que {0}
	 */
	public String[] getArgs() {
		return this.args;
	}

	/**
	 * @param args the arguments
	 */
	public void setArgs(String[] args) {
		this.args = args;
	}

	/**
	 * @return the bundleString
	 */
	public String getBundleString() {
		return this.bundleString;
	}

	/**
	 * @return the property
	 */
	public String getProperty() {
		return this.property;
	}

	/**
	 * @return the nomes
	 */
	public Collection<String> getNomes() {
		return this.nomes;
	}

	/**
	 * @param nomes the nomes to set
	 */
	public void setNomes(Collection<String> nomes) {
		this.nomes = nomes;
	}

	/**
	 * @return the collection
	 */
	public Collection<?> getCollection() {
		return this.collection;
	}

	/**
	 * @param collection the collection to set
	 */
	public void setCollection(Collection<?> collection) {
		this.collection = collection;
	}
}
