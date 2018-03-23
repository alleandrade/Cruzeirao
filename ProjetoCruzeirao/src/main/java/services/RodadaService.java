package services;

import java.util.*;
import entidades.Rodada;

public class RodadaService {
	private ArrayList<Rodada> rodadas = new ArrayList<Rodada>();
	
	public RodadaService() {
		
	}
	
	public void salvar(Rodada rodada) {
		rodadas.add(rodada);
	}

	public ArrayList<Rodada> getRodadas() {
		return rodadas;
	}
}
