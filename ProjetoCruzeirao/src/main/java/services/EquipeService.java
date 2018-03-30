package services;

import java.util.*;


import entidades.Equipe;

public class EquipeService {
	private ArrayList<Equipe> equipes = new ArrayList<Equipe>();
	
	public EquipeService() {
		
	}
	
	public void salvar(Equipe equipe) {
		equipes.add(equipe);
	}

	public ArrayList<Equipe> getEquipes() {
		return equipes;
	}
	
}
