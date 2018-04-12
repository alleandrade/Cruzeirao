package services;

import java.util.*;

import dados.Dados;
import entidades.Gol;

public class GolService {
	private ArrayList<Gol> gols = Dados.gols;
	
	public GolService() {
		
	}
	
	public void salvar(Gol gol) {
		gols.add(gol);
	}

	public ArrayList<Gol> getGols() {
		return gols;
	}
}
