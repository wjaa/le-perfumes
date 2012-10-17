package br.com.wjaa.dao;

import java.util.List;

import br.com.wjaa.arquitetura.dao.GenericDao;
import br.com.wjaa.commons.model.entity.Cliente;

public interface ClienteDao extends GenericDao<Cliente, Integer>{

	Cliente getClienteByCpf(String cpf);
	
	public List<Cliente> buscaCliente(String nome, String cpf, String fone, String localTrab);

}
