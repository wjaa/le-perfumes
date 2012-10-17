package br.com.wjaa.dao.impl;

import org.springframework.stereotype.Repository;

import br.com.wjaa.arquitetura.dao.impl.GenericDaoImpl;
import br.com.wjaa.commons.model.entity.Usuario;
import br.com.wjaa.dao.LoginDao;

/**
 * 
 * @author Wagner
 *
 */
@Repository
public class LoginDaoImpl extends GenericDaoImpl<Usuario, Integer> implements LoginDao  {

	public LoginDaoImpl() {
		super(Usuario.class);
	}

	public Usuario loginUsuario(String usuario, String senha) {
		String hql = "From " + Usuario.class.getName() + " u " +
		             " where u.nome = :nome " +
		             " and u.senha =:senha and u.ativo = true ";
		
		return (Usuario)getSession().createQuery(hql)
		.setString("nome", usuario)
		.setString("senha", senha)
		.uniqueResult();
		
	}

}
