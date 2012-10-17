package br.com.wjaa.dao;

import br.com.wjaa.arquitetura.dao.GenericDao;
import br.com.wjaa.commons.model.entity.Usuario;

/**
 * 
 * @author Wagner
 *
 */
public interface LoginDao extends GenericDao<Usuario, Integer> {
	
	public Usuario loginUsuario(String usuario, String senha);
	
	
}
