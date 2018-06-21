package sistema.services;

import java.util.*;

import sistema.dados.Dados;
import sistema.entidades.Gol;

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
