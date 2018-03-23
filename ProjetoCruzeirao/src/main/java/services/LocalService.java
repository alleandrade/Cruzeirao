package services;

import java.util.*;
import entidades.Local;

public class LocalService {
	private ArrayList<Local> locais = new ArrayList<Local>();
	
	public LocalService() {
		
	}
	
	public void salvar(Local local) {
		locais.add(local);
	}

	public ArrayList<Local> getLocais() {
		return locais;
	}
}
