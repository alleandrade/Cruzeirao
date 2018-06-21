package sistema.services;

import java.util.*;

import sistema.dados.Dados;
import sistema.entidades.Equipe;

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
