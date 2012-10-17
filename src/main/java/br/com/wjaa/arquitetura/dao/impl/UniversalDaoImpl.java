package br.com.wjaa.arquitetura.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.orm.ObjectRetrievalFailureException;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import br.com.wjaa.arquitetura.dao.UniversalDao;

/**
 * This class serves as the a class that can CRUD any object witout any Spring
 * configuration. The only downside is it does require casting from Object to
 * the object class.
 * 
 * @author <a href="mailto:emerson.mariano@arizona.com.br">Emerson Rodrigo
 *         Mariano</a>
 */
public abstract class UniversalDaoImpl extends HibernateDaoSupport implements
		UniversalDao {
	/**
	 * Log variable for all child classes. Uses LogFactory.getLog(getClass())
	 * from Commons Logging
	 */
	protected final Log log = LogFactory.getLog(getClass());

	/**
	 * {@inheritDoc}
	 */
	public Object save(Object o) {
		return getHibernateTemplate().merge(o);
	}

	/**
	 * {@inheritDoc}
	 */
	public Object get(Class<?> clazz, Serializable id) {
		Object o = getHibernateTemplate().get(clazz, id);

		if (o == null) {
			throw new ObjectRetrievalFailureException(clazz, id);
		}

		return o;
	}

	/**
	 * {@inheritDoc}
	 */
	public List<?> getAll(Class<?> clazz) {
		return getHibernateTemplate().loadAll(clazz);
	}

	/**
	 * {@inheritDoc}
	 */
	public void remove(Class<?> clazz, Serializable id) {
		getHibernateTemplate().delete(get(clazz, id));
	}
}
