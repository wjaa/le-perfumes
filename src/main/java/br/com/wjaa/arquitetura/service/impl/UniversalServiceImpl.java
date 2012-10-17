/**
 * Date create 10/10/2008.
 */
package br.com.wjaa.arquitetura.service.impl;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import br.com.wjaa.arquitetura.dao.UniversalDao;
import br.com.wjaa.arquitetura.service.UniversalService;

/**
 * Base class for Business Services - use this class for utility methods and
 * generic CRUD methods.
 * 
 * @author <a href="mailto:emerson.mariano@arizona.com.br">Emerson Rodrigo
 *         Mariano</a>
 */
public abstract class UniversalServiceImpl implements UniversalService {
	/**
	 * Log instance for all child classes.
	 */
	protected final Log log = LogFactory.getLog(getClass());

	/**
	 * UniversalDao instance, ready to charge forward and persist to the
	 * database
	 */
	protected UniversalDao dao;

	/**
	 * @param dao the dao
	 */
	public void setDao(UniversalDao dao) {
		this.dao = dao;
	}

	/**
	 * {@inheritDoc}
	 */
	public Object get(Class<?> clazz, Serializable id) {
		return this.dao.get(clazz, id);
	}

	/**
	 * {@inheritDoc}
	 */
	public List<?> getAll(Class<?> clazz) {
		return this.dao.getAll(clazz);
	}

	/**
	 * {@inheritDoc}
	 */
	public void remove(Class<?> clazz, Serializable id) {
		this.dao.remove(clazz, id);
	}

	/**
	 * {@inheritDoc}
	 */
	public Object save(Object o) {
		return this.dao.save(o);
	}
}
