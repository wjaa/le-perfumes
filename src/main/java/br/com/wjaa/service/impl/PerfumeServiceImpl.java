package br.com.wjaa.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.wjaa.arquitetura.service.impl.GenericServiceImpl;
import br.com.wjaa.commons.model.entity.Perfume;
import br.com.wjaa.controller.impl.PerfumeForm;
import br.com.wjaa.dao.PerfumeDao;
import br.com.wjaa.service.PerfumeService;

@Service
public class PerfumeServiceImpl extends GenericServiceImpl<Perfume, Integer> 
implements PerfumeService{

	
	private PerfumeDao dao;
	
	@Autowired
	public PerfumeServiceImpl(PerfumeDao dao) {
		super(dao);
		this.dao = dao;
	}

	public boolean salvaPerfume(PerfumeForm form) {
		
		try{
			Perfume p = null;
			
			if(form.getId() == null){
				p = new Perfume();
			}else{
				p = (Perfume) dao.get(form.getId());
			}
			
			p.setMarca(form.getMarca());
			p.setNome(form.getNome());
			p.setObservacao(form.getObservacao());
			p.setTamanho(form.getTamanho());
			p.setTipo(form.getTipo());
			p.setAtivo(true);
			dao.save(p);
			
		}catch (Exception e) {
			System.out.println("ERRO AO SALVAR PERFUME");
			e.printStackTrace();
			
		}
		
		
		
		
		
		return false;
	}

	public ModeloBuscaPerfume buscaPerfume(PerfumeForm form1) {
		
		ModeloBuscaPerfume modelo = new ModeloBuscaPerfume();
		List<Perfume> perfumes = new ArrayList<Perfume>();
		
		String nome = form1.getNome();
		String marca = form1.getMarca();
		
		
			
		
		try{

			perfumes = dao.listPerfume(marca, nome);
			this.populaBuscaPerfume(modelo, perfumes);
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	
		
		return modelo;
	}
	

	
	private void populaBuscaPerfume(ModeloBuscaPerfume modelo, List<Perfume> perfumes) {
		
		for (Perfume c : perfumes) {
				PerfumeVo vo = new PerfumeVo();

				vo.setIdPerfume(c.getId());
				vo.setMarca(c.getMarca());
				vo.setNome(c.getNome());
				vo.setObservacao(c.getObservacao());
				vo.setTamanho(c.getTamanho() + " ml");
				vo.setTipo(c.getTipo());
				
				modelo.addPerfumeVo(vo);
		}
	}
	
	

	public PerfumeVo buscaPerfumeEdicao(String idPerfume) throws NumberFormatException{
		

		Perfume p = (Perfume) dao.get(Integer.valueOf(idPerfume) );
		
		PerfumeVo vo = new PerfumeVo(); 
		
		vo.setIdPerfume(p.getId());
		vo.setMarca(p.getMarca());
		vo.setNome(p.getNome());
		vo.setObservacao(p.getObservacao());
		vo.setTamanho(p.getTamanho());
		vo.setTipo(p.getTipo());
				
		return vo;
	}

	@Override
	public void removerPerfume(Integer idPerfume) {
		Perfume perfume = this.dao.get(idPerfume);
		
		if (perfume != null){
			perfume.setAtivo(false);
			this.dao.save(perfume);
		}
		
	}

	@Override
	public Collection<PerfumeForm> getAllPerfumeForm() {
		return PerfumeForm.toList(this.getAll());
		
	}

}
