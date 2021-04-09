package br.com.cotiinformatica.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cotiinformatica.entities.Usuario;
import br.com.cotiinformatica.interfaces.IUsuarioRepository;

@Service //define como classe de servi�o do Spring
@Transactional //permite o uso de transa��es de banco de dados
public class UsuarioService {

	@Autowired //inje��o de depend�ncia
	private IUsuarioRepository usuarioRepository;
	
	//m�todo para salvar/atualizar um usu�rio no banco de dados
	public void createOrUpdate(Usuario usuario) throws Exception {
		
		//verificar se o email informado j� est� cadastrado
		if(usuario.getIdUsuario() == null && usuarioRepository.get(usuario.getEmail()).size() == 1)
			throw new Exception("O email informado j� encontra-se cadastrado.");
		
		usuarioRepository.save(usuario);
	}
	
	//m�todo para excluir um usu�rio no banco de dados
	public void delete(Usuario usuario) throws Exception {
		usuarioRepository.delete(usuario);
	}
	
	//m�todo para consultar todos os usu�rios do banco de dados
	public List<Usuario> getAll() throws Exception {
		return (List<Usuario>) usuarioRepository.findAll();
	}
	
	//m�todo para obter 1 usu�rio por id
	public Usuario get(Integer id) throws Exception{
		return usuarioRepository.findById(id).get();
	}
	
	//m�todo para buscar 1 usu�rio no banco de dados atraves do email e senha
	public Usuario get(String email, String senha) throws Exception{
		List<Usuario> result = usuarioRepository.get(email, senha);
		
		if(result.size() == 1)
			return result.get(0); //retornando o usuario obtido
		
		return null;
	}
}
