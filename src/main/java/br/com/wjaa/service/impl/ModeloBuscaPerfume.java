package br.com.wjaa.service.impl;

import java.util.ArrayList;
import java.util.Collection;


public class ModeloBuscaPerfume {
	
	
	private Collection<PerfumeVo> perfumeVo = new ArrayList<PerfumeVo>();
	

	public void addPerfumeVo(PerfumeVo vo){
		this.perfumeVo.add(vo);
	}


	public Collection<PerfumeVo> getPerfumeVo() {
		return perfumeVo;
	}
	public void setPerfumeVo(Collection<PerfumeVo> perfumeVo) {
		this.perfumeVo = perfumeVo;
	}
	
	
	

}
