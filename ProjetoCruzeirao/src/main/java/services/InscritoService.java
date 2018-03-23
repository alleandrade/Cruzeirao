package services;

import java.util.*;
import entidades.Inscrito;

public class InscritoService {
	private ArrayList<Inscrito> inscritos = new ArrayList<Inscrito>();
	
	public InscritoService() {
		
	}
	
	public void salvar(Inscrito inscrito) {
		inscritos.add(inscrito);
	}

	public ArrayList<Inscrito> getInscritos() {
		return inscritos;
	}
}
