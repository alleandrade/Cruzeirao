package services;

import java.util.ArrayList;
import java.util.List;

import dados.Dados;
import dao.CategoriaDAO;
import entidades.Categoria;

public class CategoriaService {
	private ArrayList<Categoria> categorias = Dados.categorias;
 	CategoriaDAO categoriaDAO = new CategoriaDAO();
	
	public CategoriaService() {
		
	}
	
	public Categoria salvar(Categoria categoria) {
		categorias.add(categoria);
		
		categoria = categoriaDAO.save(categoria);
		categoriaDAO.closeEntityManager();
		return categoria;
	}
	
	public void alterar(Categoria categoria) {

		categoriaDAO.save(categoria);
		categoriaDAO.closeEntityManager();
		
	}
		
	public void remover(Categoria categoria) {
		categorias.remove(categoria);
		
		categoria = categoriaDAO.getById(Categoria.class, categoria.getIdCategoria());
		categoriaDAO.remove(categoria);
		categoriaDAO.closeEntityManager();
	}

	public List<Categoria> getCategorias() {
		List <Categoria> list = categoriaDAO.getAll(Categoria.class);
		categoriaDAO.closeEntityManager();
		return list;
	}
}
