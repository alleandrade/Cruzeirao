package services;

import java.util.*;
import entidades.Categoria;

public class CategoriaService {
	private ArrayList<Categoria> categorias = new ArrayList<Categoria>();
	
	public CategoriaService() {
		
	}
	
	public void salvar(Categoria categoria) {
		categorias.add(categoria);
	}

	public ArrayList<Categoria> getCategorias() {
		return categorias;
	}
}
