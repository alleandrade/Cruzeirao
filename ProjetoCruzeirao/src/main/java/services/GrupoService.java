package services;

import java.util.*;
import entidades.Grupo;

public class GrupoService {
	private ArrayList<Grupo> grupos = new ArrayList<Grupo>();
	
	public GrupoService() {
		
	}
	
	public void salvar(Grupo grupo) {
		grupos.add(grupo);
	}

	public ArrayList<Grupo> getGrupos() {
		return grupos;
	}
}
