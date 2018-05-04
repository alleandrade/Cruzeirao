package services;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import dados.Dados;
import entidades.Usuario;


public class UsuarioService {
	private ArrayList<Usuario> usuarios = Dados.usuarios;
	private ArrayList<Usuario> diretores = Dados.usuarioDiretores;
	private ArrayList<Usuario> jogadores = Dados.usuarioJogadores;
	private ArrayList<Usuario> comissaoTecnica = Dados.usuarioComissao;
	private ArrayList<Usuario> juizes = Dados.usuarioJuizes;
	private static EntityManagerFactory emf;
	
	public ArrayList<Usuario> getDiretores() {
		return diretores;
	}

	public void setDiretores(ArrayList<Usuario> diretores) {
		this.diretores = diretores;
	}

	public UsuarioService() {
		 emf = Persistence.createEntityManagerFactory("ProjetoCruzeirao");
	}
	
	public void salvar(Usuario usuario) {
		
		if(usuario.getTipo().getTipo().equals("Diretor"))
			diretores.add(usuario);
			
		if(usuario.getTipo().getTipo().equals("Jogador"))
			jogadores.add(usuario);
		
		if(usuario.getTipo().getTipo().equals("Juiz"))
			juizes.add(usuario);	
			
		if(usuario.getTipo().getTipo().equals("Preparador físico") || usuario.getTipo().getTipo().equals("Massagista") || usuario.getTipo().getTipo().equals("Técnico"))
			comissaoTecnica.add(usuario);			

		usuarios.add(usuario);
		

		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();	
			em.persist(usuario);
		em.getTransaction().commit();	
	    em.close();
		
	}
	
	public void alterar(Usuario usuario) {

		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();	
			em.merge(usuario);
		em.getTransaction().commit();	
	    em.close();		
		
	}
	
	public void remover(Usuario usuario) {
		usuarios.remove(usuario);
		
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();	
			usuario = em.find(Usuario.class,usuario.getIdUsuario());
			em.remove(usuario);
		em.getTransaction().commit();	
	    em.close();
	}

	@SuppressWarnings("unchecked")
	public List<Usuario> getUsuarios() {
		
		List<Usuario> users;
		
		EntityManager em = emf.createEntityManager();
		Query q = em.createQuery("Select u From Usuario u");
		users = q.getResultList();
		em.close();
		
		return users;
	}
	
	
}
