package services;

import java.util.*;

import dados.Dados;
import entidades.Fase;

public class FaseService {
	private ArrayList<Fase> fases = Dados.fases;
	
	public FaseService() {
		
	}
	
	public void salvar(Fase fase) {
		fases.add(fase);
	}

	public ArrayList<Fase> getFases() {
		return fases;
	}
}
