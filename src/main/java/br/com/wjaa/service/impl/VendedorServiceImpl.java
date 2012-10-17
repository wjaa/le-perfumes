package br.com.wjaa.service.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.wjaa.arquitetura.service.impl.GenericServiceImpl;
import br.com.wjaa.commons.model.entity.Vendedor;
import br.com.wjaa.controller.impl.VendedorForm;
import br.com.wjaa.dao.VendedorDao;
import br.com.wjaa.service.VendedorService;


@Service
public class VendedorServiceImpl extends GenericServiceImpl<Vendedor, Integer> implements
		VendedorService {

	private VendedorDao vendedorDao;
	
	@Autowired
	public VendedorServiceImpl(VendedorDao vendedorDao) {
		super(vendedorDao);
		this.vendedorDao = vendedorDao;
	}

	@Override
	public List<VendedorForm> listVendedorByName(String nome) {
		return VendedorForm.toList(this.vendedorDao.listVendedorByName(nome));
	}

	@Override
	public VendedorForm getVendedorById(Integer idVendedor) {
		return new VendedorForm(this.vendedorDao.get(idVendedor));
		
	}

	@Override
	public void removeVendedor(Integer idVendedor) {
		Vendedor v = this.vendedorDao.get(idVendedor);
		v.setAtivo(false);
		this.vendedorDao.save(v);
	}

	@Override
	public void saveVendedor(VendedorForm vendedorForm) {
		Vendedor vendedor = new Vendedor();
		if (vendedorForm.getId() != null && vendedorForm.getId() > 0){
			vendedor = this.get(vendedorForm.getId());
		}else{
			vendedorForm.setId(null);
		}
		
		try {
			BeanUtils.copyProperties(vendedor, vendedorForm);
			vendedor.setAtivo(true);
			this.vendedorDao.save(vendedor);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public List<VendedorForm> listAllVendedor() {
		return VendedorForm.toList(this.vendedorDao.getAll());
	}

}
