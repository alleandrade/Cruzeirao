package services;

import java.util.ArrayList;
import java.util.List;

import dados.Dados;
import dao.EquipeDAO;
import entidades.Categoria;
import entidades.Equipe;

public class EquipeService {
	private ArrayList<Equipe> equipes = Dados.equipes;
	EquipeDAO equipeDAO = new EquipeDAO();
	
	public EquipeService() {
		
	}
	
	public Equipe salvar(Equipe equipe) {
		equipes.add(equipe);
		
		equipe = equipeDAO.save(equipe);
		equipeDAO.closeEntityManager();
		return equipe;
	}
	
	public void alterar(Equipe equipe) {

		equipeDAO.save(equipe);
		equipeDAO.closeEntityManager();
		
	}
	
	public void remover(Equipe equipe) {
		equipes.remove(equipe);
		
		equipe = equipeDAO.getById(Equipe.class, equipe.getIdEquipe());
		equipeDAO.remove(equipe);
		equipeDAO.closeEntityManager();
	}

	public List<Equipe> getEquipes() {
		List <Equipe> list = equipeDAO.getAll(Equipe.class);
		equipeDAO.closeEntityManager();
		return list;
	}
}
