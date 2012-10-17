package br.com.wjaa.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.wjaa.arquitetura.service.impl.GenericServiceImpl;
import br.com.wjaa.commons.model.entity.Usuario;
import br.com.wjaa.controller.impl.EntradaUsuario;
import br.com.wjaa.controller.impl.UsuarioForm;
import br.com.wjaa.dao.UsuarioDao;
import br.com.wjaa.service.UsuarioService;


/**
 * 
 * @author Wagner
 *
 */
@Service
public class UsuarioServiceImpl extends GenericServiceImpl<Usuario, Integer> 
implements UsuarioService{
	
	
	private UsuarioDao dao;
	
	@Autowired
	public UsuarioServiceImpl(UsuarioDao dao) {
		super(dao);
		this.dao = dao;
	}


	public void salvarUsuario(UsuarioForm usuarioForm)throws Exception{
		
		try{
			Usuario usuario = null;
		
			if(usuarioForm.getId_usuario() == null){
				usuario = new Usuario();
				usuario.setDataCadastro(new Date());
			}else{
				usuario = (Usuario) dao.get(usuarioForm.getId_usuario());
			}
			
			usuario.setNomeUsuario(usuarioForm.getNomeFull());
			usuario.setNome(usuarioForm.getNome());
			usuario.setEmail(usuarioForm.getEmail());
			
			if ( StringUtils.isNotBlank(usuarioForm.getSenha())){
				usuario.setSenha(usuarioForm.getSenha());
			}
			
			usuario.setAtivo(true);
			dao.save(usuario);
			
		}catch(Exception e){
			e.printStackTrace();
			throw e;
		}
		
	}
	
	
	/**
	 * Verifica se já existe um usuario com o mesmo login ja cadastrado
	 * @param usuarioForm
	 * @return
	 * @throws Exception
	 */
	public boolean existeUsuario(UsuarioForm usuarioForm)throws Exception{
		boolean retorno = false;
		
		try{
			
			Usuario usuario = dao.getUsuarioByName(usuarioForm.getNome());
			if(usuario == null || usuarioForm.getId_usuario() != null){
				this.salvarUsuario(usuarioForm);
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
	
	
	public void removerUsuario(EntradaUsuario entrada) throws Exception{
		
		try{
			Usuario usuario = dao.get(entrada.getIdUsuarioGi());
			if (usuario != null){
				usuario.setAtivo(false);
				dao.save(usuario);
			}
			
		}catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		
		
	}

	public ModeloBuscaUsuario buscaUsuario(EntradaUsuario entrada) throws Exception{
		
		ModeloBuscaUsuario modelo = new ModeloBuscaUsuario();
		List<Usuario> objeto = new ArrayList<Usuario>();
		
		String nome = entrada.getNomeFull();
			
		try{
			
			if(nome != ""){
				objeto = dao.listUsuarioByName(nome);
			}else{
				objeto = dao.getAll();
			}
			
			
			this.populaBuscaUsuario(modelo, objeto);
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	
		
		return modelo;
	}



	private void populaBuscaUsuario(ModeloBuscaUsuario modelo, List<Usuario> usuarios) {
		
		for (Usuario user : usuarios) {
				ConsultaUsuarioVo vo = new ConsultaUsuarioVo();
				
				vo.setIdUsuario(user.getId());
				vo.setNome(user.getNome());
				vo.setNomeFull(user.getNomeUsuario());
				modelo.addConsultaUsuarioVo(vo);
		}
	}
	


	@Override
	public ModeloUsuarioEdicao getUsuarioEdicao(EntradaUsuario entrada) {
		ModeloUsuarioEdicao model = new ModeloUsuarioEdicao();
		
		Usuario usuario = this.dao.get(entrada.getIdUsuarioGi());
		
		UsuarioVo usuarioVo = new UsuarioVo(usuario);
		
		model.setUsuarioVo(usuarioVo);
		
		return model;
	}
	
}










