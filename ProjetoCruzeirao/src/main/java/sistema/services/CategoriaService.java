package sistema.services;

import java.util.*;

import sistema.dados.Dados;
import sistema.entidades.Categoria;

public class CategoriaService {
	private ArrayList<Categoria> categorias = Dados.categorias;
	
	public CategoriaService() {
		
	}
	
	public void salvar(Categoria categoria) {
		categorias.add(categoria);
	}
	
	public void remover(Categoria categoria) {
		categorias.remove(categoria);
	}

	public ArrayList<Categoria> getCategorias() {
		return categorias;
	}
}
