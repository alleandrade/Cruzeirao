package services;

import java.util.*;
import entidades.Gol;

public class GolService {
	private ArrayList<Gol> gols = new ArrayList<Gol>();
	
	public GolService() {
		
	}
	
	public void salvar(Gol gol) {
		gols.add(gol);
	}

	public ArrayList<Gol> getGols() {
		return gols;
	}
}
