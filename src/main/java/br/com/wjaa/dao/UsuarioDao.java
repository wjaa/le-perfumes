package br.com.wjaa.dao;

import java.util.List;

import br.com.wjaa.arquitetura.dao.GenericDao;
import br.com.wjaa.commons.model.entity.Usuario;

public interface UsuarioDao extends GenericDao<Usuario, Integer> {

	Usuario getUsuarioByName(String nome);

	List<Usuario> listUsuarioByName(String nomeUsuario);

}
