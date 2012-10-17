/**
 * Date create 12/09/2008
 */
package br.com.wjaa.arquitetura.model;

/**
 * Base class for Model objects. Child objects should implement toString(),
 * equals() and hashCode() (Pattern Interface). All methods in a Interface are
 * 'public, static and final'.
 * 
 * @author <a href="mailto:emerson.mariano@arizona.com.br">Emerson Rodrigo
 *         Mariano</a>
 */
public interface ObjetoBasico {

	/**
	 * Returns a multi-line String with key=value pairs.
	 * 
	 * @return a String representation of this class.
	 */
	String toString();

	/**
	 * Compares object equality. When using Hibernate, the primary key should
	 * not be a part of this comparison.
	 * 
	 * @param o
	 *            object to compare to
	 * @return true/false based on equality tests
	 */
	boolean equals(Object o);

	/**
	 * When you override equals, you should override hashCode.
	 * 
	 * @return hashCode
	 */
	int hashCode();
}
