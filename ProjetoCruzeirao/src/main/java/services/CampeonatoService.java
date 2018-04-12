package services;

import java.util.*;

import dados.Dados;
import entidades.Campeonato;

public class CampeonatoService {
	private ArrayList<Campeonato> campeonatos = Dados.campeonatos;
	
	public CampeonatoService() {
		
	}
	
	public void salvar(Campeonato campeonato) {
		campeonatos.add(campeonato);
	}
	
	public void remover(Campeonato campeonato) {
		campeonatos.remove(campeonato);
	}

	public ArrayList<Campeonato> getCampeonatos() {
		return campeonatos;
	}
}
