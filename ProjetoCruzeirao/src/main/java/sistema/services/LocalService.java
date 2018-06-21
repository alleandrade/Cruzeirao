package sistema.services;

import java.util.*;

import sistema.dados.Dados;
import sistema.entidades.Local;

public class LocalService {
	private ArrayList<Local> locais = Dados.locais;
	
	public LocalService() {
		
	}
	
	public void salvar(Local local) {
		locais.add(local);
	}
	
	public void remover(Local local) {
		locais.remove(local);
	}

	public ArrayList<Local> getLocais() {
		return locais;
	}
}
