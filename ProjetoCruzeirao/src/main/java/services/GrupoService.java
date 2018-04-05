package services;

import java.util.*;

import dados.Dados;
import entidades.Grupo;

public class GrupoService {
	private ArrayList<Grupo> grupos = Dados.grupos;
	
	public GrupoService() {
		
	}
	
	public void salvar(Grupo grupo) {
		grupos.add(grupo);
	}
	
	public void remover(Grupo grupo) {
		grupos.remove(grupo);
	}

	public ArrayList<Grupo> getGrupos() {
		return grupos;
	}
}
