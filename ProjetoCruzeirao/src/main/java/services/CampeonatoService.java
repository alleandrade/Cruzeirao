package services;

import java.util.*;
import entidades.Campeonato;

public class CampeonatoService {
	private ArrayList<Campeonato> campeonatos = new ArrayList<Campeonato>();
	
	public CampeonatoService() {
		
	}
	
	public void salvar(Campeonato campeonato) {
		campeonatos.add(campeonato);
	}

	public ArrayList<Campeonato> getCampeonatos() {
		return campeonatos;
	}
}
