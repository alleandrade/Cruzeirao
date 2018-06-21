package sistema.services;


import java.util.List;

import sistema.dao.CampeonatoDAO;
import sistema.entidades.Campeonato;
import sistema.entidades.Categoria;
import sistema.entidades.Juiz;
import sistema.entidades.Local;

public class CampeonatoService {

 	CampeonatoDAO campeonatoDAO = new CampeonatoDAO();
	
	public Campeonato salvar(Campeonato campeonato) {
		
		campeonato = campeonatoDAO.save(campeonato);
		campeonatoDAO.closeEntityManager();
		return campeonato;
	}	

	public void alterar(Campeonato campeonato) {

		campeonatoDAO.save(campeonato);
		campeonatoDAO.closeEntityManager();
		
	}
	
	public void remover(Campeonato campeonato) {
		
		campeonato = campeonatoDAO.getById(Campeonato.class, campeonato.getIdCampeonato());
		campeonatoDAO.remove(campeonato);
		campeonatoDAO.closeEntityManager();
	}
	
	public List<Local> pesquisarLocaisCampeonato(Campeonato campeonato) {

		List<Local> locais;
		campeonato = campeonatoDAO.getById(Campeonato.class, campeonato.getIdCampeonato());
		locais = campeonato.getLocais();
		return locais;
	}
	
	public List<Categoria> pesquisarCategoriasCampeonato(Campeonato campeonato) {

		List<Categoria> categorias;
		campeonato = campeonatoDAO.getById(Campeonato.class, campeonato.getIdCampeonato());
		categorias = campeonato.getCategorias();
		return categorias;
	}
	
	public List<Juiz> pesquisarJuizesCampeonato(Campeonato campeonato) {

		List<Juiz> juizes;
		campeonato = campeonatoDAO.getById(Campeonato.class, campeonato.getIdCampeonato());
		juizes = campeonato.getJuizes();
		return juizes;
	}

	public List<Campeonato> getCampeonatos() {
		
		List <Campeonato> list = campeonatoDAO.getAll(Campeonato.class);
		campeonatoDAO.closeEntityManager();
		return list;	
	}	
}
