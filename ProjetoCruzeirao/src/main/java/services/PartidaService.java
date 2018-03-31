package services;

import java.util.*;

import dados.Dados;
import entidades.Partida;

public class PartidaService {
	private ArrayList<Partida> partidas = Dados.partidas;
	
	public PartidaService() {
		
	}
	
	public void salvar(Partida partida) {
		partidas.add(partida);
	}

	public ArrayList<Partida> getPartidas() {
		return partidas;
	}
}
