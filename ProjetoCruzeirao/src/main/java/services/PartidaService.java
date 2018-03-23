package services;

import java.util.*;
import entidades.Partida;

public class PartidaService {
	private ArrayList<Partida> partidas = new ArrayList<Partida>();
	
	public PartidaService() {
		
	}
	
	public void salvar(Partida partida) {
		partidas.add(partida);
	}

	public ArrayList<Partida> getPartidas() {
		return partidas;
	}
}
