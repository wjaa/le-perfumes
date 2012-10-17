package br.com.wjaa.service.impl;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.wjaa.arquitetura.service.impl.GenericServiceImpl;
import br.com.wjaa.commons.model.entity.Cliente;
import br.com.wjaa.controller.impl.ClienteForm;
import br.com.wjaa.dao.ClienteDao;
import br.com.wjaa.service.ClienteService;

/**
 * 
 * @author Wagner
 *
 */
@Service
public class ClienteServiceImpl extends GenericServiceImpl<Cliente, Integer> implements ClienteService {
	
	
	private ClienteDao dao;
	
	@Autowired
	public ClienteServiceImpl(ClienteDao dao) {
		super(dao);
		this.dao = dao;
	}

	public boolean salvarCliente(ClienteForm form)throws Exception {
		
		try{
			
			Cliente c = null;
			
			if(form.getIdCliente() == null){
				c = new Cliente();
				c.setAtivo(form.getStatus() == 0);
				c.setDataCadastro(form.getDataCadastro());
				
				
			}else{
				c = (Cliente) get(form.getIdCliente());
			}
			
			c.setContato(form.getContato());
			c.setCpf(form.getCpf());
			c.setDataNascimento(form.getDataNascimento());//
			c.setDddFone1(form.getDddFone1());
			c.setDddFone2(form.getDddFone2());
			c.setEmail(form.getEmail());
			c.setEndBairro(form.getEndBairro());
			c.setEndCep(form.getEndCep());
			c.setEndCidade(form.getEndCidade());
			c.setEndComplemento(form.getEndComplemento());
			c.setEndEstado(form.getEndEstado());
			c.setEndLogradouro(form.getEndLogradouro());
			c.setEndNumero(form.getEndNumero());
			c.setFone1(form.getFone1());
			c.setFone2(form.getFone2());
			c.setIdUsuario(form.getIdUsuario());
			c.setSexo(form.getSexo());
			c.setNomeFull(form.getNomeFull());
			c.setLoja(form.getLoja());
			c.setLocalTrabalho(form.getLocalTrabalho());
			
			
			dao.save(c);
			
			
		}catch (Exception e) {
			System.out.println("ERRO AO SALVAR CLIENTE");
			e.printStackTrace();
			
		}
		
		
		
		return false;
	}

	
	
	private String tiraMascara(String c) {
		if (StringUtils.isNotEmpty(c)){
			Pattern p = Pattern.compile("[0-9]");
			Matcher m = p.matcher(c);
			StringBuilder retorno = new StringBuilder();
			while(m.find()){
				retorno.append(m.group());
			}
			return retorno.toString();
			
		}
		return null;
	}
	
	public boolean exixteCliente(ClienteForm clienteForm) throws Exception {
			boolean retorno = false;
		
		try{
			
			Cliente cliente = dao.getClienteByCpf(clienteForm.getCpf());
			
			if(cliente == null){
				this.salvarCliente(clienteForm);
			}else{
				retorno = true;
			}
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("Logar na table de auditoria");
			throw e;
		}
		return retorno;
	}

	
	public boolean editaCliente(ClienteForm clienteForm) throws Exception {
		boolean retorno = false;
		
		try{
			
			Cliente cliente = get(clienteForm.getIdCliente());
			
			if(cliente != null){
				this.salvarCliente(clienteForm);
			}else{
				retorno = true;
			}
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("Logar na table de auditoria");
			throw e;
		}
		
		return retorno; 
	}
	
	
	public ModeloBuscaCliente buscaCliente(ClienteForm form) {
		ModeloBuscaCliente modelo = new ModeloBuscaCliente();
		Collection<Cliente> result = new ArrayList<Cliente>();
		
		String nome = form.getNomeFull();
		String cpf = form.getCpf();
		String fone = form.getFone1();
		String localTrab = form.getLocalTrabalho();
		
		try{
			result = dao.buscaCliente(nome, cpf, fone, localTrab);
			this.populaBuscaCliente(modelo, result);
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	
		
		return modelo;
	}
	
	
	private void populaBuscaCliente(ModeloBuscaCliente modelo, Collection<Cliente> clientes) {
		
		for (Cliente c : clientes) {
				ClienteVo vo = new ClienteVo();

				vo.setContato(c.getContato());
				vo.setCpf(c.getCpf());
				vo.setDddFone1(c.getDddFone1());
				vo.setDddFone2(c.getDddFone2());
				vo.setEmail(c.getEmail());
				vo.setFone1(c.getFone1());
				vo.setFone2(c.getFone2());
				vo.setIdCliente(c.getId());
				vo.setLocalTrabalho(c.getLocalTrabalho());
				vo.setLoja(c.getLoja());
				vo.setNomeFull(c.getNomeFull());
				
				modelo.addClienteVo(vo);
		}
	}


	public ClienteVo buscaClienteEdicao(String idCliente) throws NumberFormatException, ParseException {
		
		
		Cliente c = get(Integer.valueOf(idCliente));
		
		ClienteVo vo = new ClienteVo(); 
		vo.setIdCliente(c.getId());
		vo.setContato(c.getContato());
		vo.setCpf(c.getCpf());
		
		vo.setDddFone1(c.getDddFone1());
		vo.setDddFone2(c.getDddFone2());
		vo.setEmail(c.getEmail());
		vo.setFone1(c.getFone1());
		vo.setFone2(c.getFone2());
		vo.setIdCliente(c.getId());
		vo.setLocalTrabalho(c.getLocalTrabalho());
		vo.setNomeFull(c.getNomeFull());
		vo.setEndBairro(c.getEndBairro());
		vo.setEndCep(c.getEndCep());
		vo.setStatus(c.getAtivo() ? 0 : 1);
		vo.setSexo(c.getSexo());
		vo.setLoja(c.getLoja());
		vo.setIdUsuario(c.getIdUsuario());
		vo.setEndNumero(c.getEndNumero());
		vo.setEndCidade(c.getEndCidade());
		vo.setEndComplemento(c.getEndComplemento());
		vo.setEndNumero(c.getEndNumero());
		vo.setEndLogradouro(c.getEndLogradouro());
		vo.setEndEstado(c.getEndEstado());
		
		if (c.getDataNascimento() != null){
			DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
			String dt;
			dt = df.format(c.getDataNascimento());
			vo.setMokDataNascimento(dt);
		}
		
		
		
		return vo;
	}

	@Override
	public void removeCliente(Integer idCliente) {
		Cliente cliente = this.get(idCliente);
		if (cliente != null){
			cliente.setAtivo(false);
			this.save(cliente);
		}
		
		
	}

	@Override
	public Collection<ClienteForm> getAllCliente() {
		return ClienteForm.toList(this.dao.getAll());
	}
	
	
}
