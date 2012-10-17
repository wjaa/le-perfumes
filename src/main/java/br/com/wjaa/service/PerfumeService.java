package br.com.wjaa.service;


import java.util.Collection;
import br.com.wjaa.arquitetura.service.GenericService;
import br.com.wjaa.commons.model.entity.Perfume;
import br.com.wjaa.controller.impl.PerfumeForm;
import br.com.wjaa.service.impl.ModeloBuscaPerfume;
import br.com.wjaa.service.impl.PerfumeVo;

public interface PerfumeService extends GenericService<Perfume, Integer> {

	public boolean salvaPerfume(PerfumeForm form);
	public ModeloBuscaPerfume buscaPerfume(PerfumeForm form1);	
	public PerfumeVo buscaPerfumeEdicao(String idPerfume);
	public void removerPerfume(Integer valueOf);
	public Collection<PerfumeForm> getAllPerfumeForm();

	
}
