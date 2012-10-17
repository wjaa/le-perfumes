package br.com.wjaa.dao;

import java.util.List;

import br.com.wjaa.arquitetura.dao.GenericDao;
import br.com.wjaa.commons.model.entity.Perfume;

public interface PerfumeDao extends GenericDao<Perfume, Integer> {

	

	List<Perfume> listPerfume(String marca, String nome);

}
