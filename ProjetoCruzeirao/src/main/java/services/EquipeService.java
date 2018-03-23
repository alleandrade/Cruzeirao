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

	public ArrayList<Equipe> getEquipes() {
		return equipes;
	}
}
