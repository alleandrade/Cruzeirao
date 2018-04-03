package services;

import java.util.*;

import dados.Dados;
import entidades.Rodada;

public class RodadaService {
	private ArrayList<Rodada> rodadas = Dados.rodadas;
	
	public RodadaService() {
		
	}
	
	public void salvar(Rodada rodada) {
		rodadas.add(rodada);
	}

	public ArrayList<Rodada> getRodadas() {
		return rodadas;
	}
}
