package sistema.services;

import java.util.List;

import sistema.dao.EquipeDAO;
import sistema.entidades.Equipe;
import sistema.entidades.Usuario;

public class EquipeService {

	EquipeDAO equipeDAO = new EquipeDAO();
	
	public EquipeService() {
		
	}
	
	public Equipe salvar(Equipe equipe) {
				
		equipe = equipeDAO.save(equipe);
		equipeDAO.closeEntityManager();
		return equipe;
	}
	
	public void alterar(Equipe equipe) {

		equipeDAO.save(equipe);
		equipeDAO.closeEntityManager();
		
	}
	
	public void remover(Equipe equipe) {
		
		equipe = equipeDAO.getById(Equipe.class, equipe.getIdEquipe());
		equipeDAO.remove(equipe);
		equipeDAO.closeEntityManager();
	}
	
	public List<Usuario> pesquisarUsuariosEquipe(Equipe equipe) {

		List<Usuario> usuarios;
		equipe = equipeDAO.getById(Equipe.class, equipe.getIdEquipe());
		usuarios = equipe.getUsuarios();
		return usuarios;
	}

	public List<Equipe> getEquipes() {
		
		List <Equipe> list = equipeDAO.getAll(Equipe.class);
		equipeDAO.closeEntityManager();
		return list;
	}
}