package services;

import java.util.*;




import dados.Dados;
import entidades.Equipe;

public class EquipeService {
	private ArrayList<Equipe> equipes = Dados.equipes;
	
	public EquipeService() {
		
	}
	
	public void salvar(Equipe equipe) {
		equipes.add(equipe);
	}
	
	public void remover(Equipe equipe) {
		equipes.remove(equipe);
	}

	public ArrayList<Equipe> getEquipes() {
		return equipes;
	}
	
}
