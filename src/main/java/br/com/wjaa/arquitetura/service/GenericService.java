package br.com.wjaa.arquitetura.service;

import java.io.Serializable;
import java.util.List;

/**
 * Generic Manager that talks to GenericDao to CRUD POJOs.
 * 
 * <p>
 * Extend this interface if you want typesafe (no casting necessary) managers
 * for your domain objects.
 * 
 * @param <T> a type variable
 * @param <PK> the primary key for that type
 * @author <a href="mailto:emerson.mariano@arizona.com.br">Emerson Rodrigo
 *         Mariano</a>
 */
public interface GenericService<T, PK extends Serializable> {

	/**
	 * Generic method used to get all objects of a particular type. This is the
	 * same as lookup up all rows in a table.
	 * 
	 * @return List of populated objects
	 */
	List<T> getAll();

	/**
	 * Generic method to get an object based on class and identifier. An
	 * ObjectRetrievalFailureException Runtime Exception is thrown if nothing is
	 * found.
	 * 
	 * @param id
	 *            the identifier (primary key) of the object to get
	 * @return a populated object
	 * @see org.springframework.orm.ObjectRetrievalFailureException
	 */
	T get(PK id);

	/**
	 * Checks for existence of an object of type T using the id arg.
	 * 
	 * @param id
	 *            the identifier (primary key) of the object to get
	 * @return - true if it exists, false if it doesn't
	 */
	boolean exists(PK id);

	/**
	 * Generic method to save an object - handles both update and insert.
	 * 
	 * @param object
	 *            the object to save
	 * @return the updated object
	 */
	T save(T object);

	/**
	 * Generic method to delete an object based on class and id
	 * 
	 * @param id
	 *            the identifier (primary key) of the object to remove
	 */
	void remove(PK id);
}
