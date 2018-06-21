package sistema.services;

import java.util.ArrayList;
import java.util.List;

import sistema.dao.UsuarioDAO;
import sistema.entidades.Campeonato;
import sistema.entidades.Equipe;
import sistema.entidades.Inscrito;
import sistema.entidades.Juiz;
import sistema.entidades.Local;
import sistema.entidades.Usuario;


public class UsuarioService {

 	UsuarioDAO usuarioDAO = new UsuarioDAO();
	
	public Usuario salvar(Usuario usuario) {
		
		/*
		if(usuario.getTipo().getTipo().equals("Diretor"))
			diretores.add(usuario);
			
		if(usuario.getTipo().getTipo().equals("Jogador"))
			jogadores.add(usuario);
		
		if(usuario.getTipo().getTipo().equals("Juiz"))
			juizes.add(usuario);	
			
		if(usuario.getTipo().getTipo().equals("Preparador físico") || usuario.getTipo().getTipo().equals("Massagista") || usuario.getTipo().getTipo().equals("Técnico"))
			comissaoTecnica.add(usuario);*/
		
		usuario = usuarioDAO.save(usuario);
		usuarioDAO.closeEntityManager();
		return usuario;
		
	}
	
	public void alterar(Usuario usuario) {
		
		usuarioDAO.save(usuario);
		usuarioDAO.closeEntityManager();
		
	}
	
	public void remover(Usuario usuario) {	
		
		usuario = usuarioDAO.getById(Usuario.class, usuario.getIdUsuario());
		usuarioDAO.remove(usuario);
		usuarioDAO.closeEntityManager();
	}
	
	public List<Equipe> pesquisarEquipesUsuario(Usuario usuario) {

		List<Equipe> equipes;
		usuario = usuarioDAO.getById(Usuario.class, usuario.getIdUsuario());
		equipes = usuario.getEquipes();
		return equipes;
	}
	
	public List<Campeonato> pesquisarCampeonatosUsuario(Usuario usuario) {

		List<Campeonato> campeonatos;
		usuario = usuarioDAO.getById(Usuario.class, usuario.getIdUsuario());
		campeonatos = usuario.getCampeonatos();
		return campeonatos;
	}
	
	public List<Inscrito> pesquisarInscricoesUsuario(Usuario usuario) {

		List<Inscrito> inscricoes;
		usuario = usuarioDAO.getById(Usuario.class, usuario.getIdUsuario());
		inscricoes = usuario.getInscricoes();
		return inscricoes;
	}
	
	public List<Juiz> pesquisarJuizUsuario(Usuario usuario) {

		List<Juiz> juizes = new ArrayList<Juiz>();
		List<Juiz> percorreJuizes;
		JuizService juiz = new JuizService();
		
		percorreJuizes = juiz.getJuizes();
		
		for (Juiz j : percorreJuizes) 
			if (j.getUsuario().getIdUsuario() == usuario.getIdUsuario())
				juizes.add(j);
		
		return juizes;
	}

	public List<Usuario> getUsuarios() {
		
		List<Usuario> list = usuarioDAO.getAll(Usuario.class);
		usuarioDAO.closeEntityManager();
		return list;
	}
	
}
