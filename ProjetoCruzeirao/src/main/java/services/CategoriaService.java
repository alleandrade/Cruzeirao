package services;

import java.util.*;

import dados.Dados;
import entidades.Categoria;

public class CategoriaService {
	private ArrayList<Categoria> categorias = Dados.categorias;
	
	public CategoriaService() {
		
	}
	
	public void salvar(Categoria categoria) {
		categorias.add(categoria);
	}

	public ArrayList<Categoria> getCategorias() {
		return categorias;
	}
}
