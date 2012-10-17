package br.com.wjaa.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.wjaa.arquitetura.dao.impl.GenericDaoImpl;
import br.com.wjaa.commons.model.entity.Usuario;
import br.com.wjaa.dao.UsuarioDao;

@Repository
public class UsuarioDaoImpl extends GenericDaoImpl<Usuario, Integer> implements UsuarioDao {

	public UsuarioDaoImpl() {
		super(Usuario.class);
	}

	@Override
	public Usuario getUsuarioByName(String nomeUsuario) {
		String sql = "From " + Usuario.class.getName() + " u where u.nomeUsuario = :nomeUsuario and u.ativo = true";
		return (Usuario)getSession().createQuery(sql)
		.setString("nomeUsuario", nomeUsuario)
		.uniqueResult();
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Usuario> listUsuarioByName(String nome) {
		String sql = "From " + Usuario.class.getName() + " u where upper(u.nomeUsuario) like :nomeUsuario and u.ativo = true";
		return getSession().createQuery(sql)
		.setString("nomeUsuario", nome != null ? "%" + nome.toUpperCase() + "%" : "")
		.list();
		
	}

}
