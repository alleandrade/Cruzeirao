package sistema.services;


import java.util.List;

import sistema.dao.CategoriaDAO;
import sistema.entidades.Categoria;
import sistema.entidades.Fase;
import sistema.entidades.Inscricao;

public class CategoriaService {

 	CategoriaDAO categoriaDAO = new CategoriaDAO();
	
	public Categoria salvar(Categoria categoria) {
		
		categoria = categoriaDAO.save(categoria);
		categoriaDAO.closeEntityManager();
		return categoria;
	}
	
	public void alterar(Categoria categoria) {

		categoriaDAO.save(categoria);
		categoriaDAO.closeEntityManager();
		
	}
		
	public void remover(Categoria categoria) {
		
		categoria = categoriaDAO.getById(Categoria.class, categoria.getIdCategoria());
		categoriaDAO.remove(categoria);
		categoriaDAO.closeEntityManager();
	}
	
	public List<Fase> pesquisarFasesCategoria(Categoria categoria) {

		List<Fase> fases;
		categoria = categoriaDAO.getById(Categoria.class, categoria.getIdCategoria());
		fases = categoria.getFases();
		return fases;
	}
	
	public List<Inscricao> pesquisarInscricoesCategoria(Categoria categoria) {

		List<Inscricao> inscricoes;
		categoria = categoriaDAO.getById(Categoria.class, categoria.getIdCategoria());
		inscricoes = categoria.getInscricoes();
		return inscricoes;
	}

	public List<Categoria> getCategorias() {
		
		List <Categoria> list = categoriaDAO.getAll(Categoria.class);
		categoriaDAO.closeEntityManager();
		return list;
	}
}