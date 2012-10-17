package br.com.wjaa.arquitetura.model;

import java.io.Serializable;

/**
 *@author Paul Kuit
 */
public abstract class BaseModel implements ObjetoBasico, Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * @return a chave da entidade, usado para metodo equals, hashCode e
	 *         toString
	 */
	public abstract Integer getKey();

	/**
	 * {@inheritDoc}
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		try {
			if (!(obj.getClass().isAssignableFrom(this.getClass()) || this
					.getClass().isAssignableFrom(obj.getClass())))
				return false;
			BaseModel outro = (BaseModel) obj;
			return outro.getKey() != null
					&& outro.getKey().equals(this.getKey());
		} catch (Exception le) {
			return true;
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public final int hashCode() {
		return getKey() != null ? getKey().hashCode() : -1;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public final String toString() {
		return this.getClass().toString() + '#' + this.getKey();
	}
}
