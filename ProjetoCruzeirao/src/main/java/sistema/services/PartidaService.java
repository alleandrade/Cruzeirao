package sistema.services;

import java.util.*;

import sistema.dados.Dados;
import sistema.entidades.Partida;

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
