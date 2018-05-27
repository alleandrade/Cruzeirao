package services;

import java.util.ArrayList;
import java.util.List;

import dados.Dados;
import dao.UsuarioDAO;
import entidades.Usuario;


public class UsuarioService {
	private ArrayList<Usuario> usuarios = Dados.usuarios;
	private ArrayList<Usuario> diretores = Dados.usuarioDiretores;
	private ArrayList<Usuario> jogadores = Dados.usuarioJogadores;
	private ArrayList<Usuario> comissaoTecnica = Dados.usuarioComissao;
	private ArrayList<Usuario> juizes = Dados.usuarioJuizes;
 	UsuarioDAO usuarioDAO = new UsuarioDAO();
	
	public ArrayList<Usuario> getDiretores() {
		return diretores;
	}

	public void setDiretores(ArrayList<Usuario> diretores) {
		this.diretores = diretores;
	}
	
	public Usuario salvar(Usuario usuario) {
		
		if(usuario.getTipo().getTipo().equals("Diretor"))
			diretores.add(usuario);
			
		if(usuario.getTipo().getTipo().equals("Jogador"))
			jogadores.add(usuario);
		
		if(usuario.getTipo().getTipo().equals("Juiz"))
			juizes.add(usuario);	
			
		if(usuario.getTipo().getTipo().equals("Preparador físico") || usuario.getTipo().getTipo().equals("Massagista") || usuario.getTipo().getTipo().equals("Técnico"))
			comissaoTecnica.add(usuario);			

		usuarios.add(usuario);
		
		usuario = usuarioDAO.save(usuario);
		usuarioDAO.closeEntityManager();
		return usuario;
		
	}
	
	public void alterar(Usuario usuario) {

		usuarioDAO.save(usuario);
		usuarioDAO.closeEntityManager();
		
	}
	
	public void remover(Usuario usuario) {
		usuarios.remove(usuario);		
		
		usuario = usuarioDAO.getById(Usuario.class, usuario.getIdUsuario());
		usuarioDAO.remove(usuario);
		usuarioDAO.closeEntityManager();
	}

	public List<Usuario> getUsuarios() {
		
		List<Usuario> list = usuarioDAO.getAll(Usuario.class);
		usuarioDAO.closeEntityManager();
		return list;
	}
	
	
}
