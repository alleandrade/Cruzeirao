package services;

import java.util.*;
import entidades.Fase;

public class FaseService {
	private ArrayList<Fase> fases = new ArrayList<Fase>();
	
	public FaseService() {
		
	}
	
	public void salvar(Fase fase) {
		fases.add(fase);
	}

	public ArrayList<Fase> getFases() {
		return fases;
	}
}
