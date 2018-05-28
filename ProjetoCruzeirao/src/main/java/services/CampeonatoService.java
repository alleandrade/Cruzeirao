package services;

import java.util.ArrayList;
import java.util.List;

import dados.Dados;
import dao.CampeonatoDAO;
import entidades.Campeonato;

public class CampeonatoService {
	private ArrayList<Campeonato> campeonatos = Dados.campeonatos;
 	CampeonatoDAO campeonatoDAO = new CampeonatoDAO();

	
	public CampeonatoService() {
		
	}
	
	public Campeonato salvar(Campeonato campeonato) {
		campeonatos.add(campeonato);
		
		campeonato = campeonatoDAO.save(campeonato);
		campeonatoDAO.closeEntityManager();
		return campeonato;
	}
	

	public void alterar(Campeonato campeonato) {

		campeonatoDAO.save(campeonato);
		campeonatoDAO.closeEntityManager();
		
	}
	
	public void remover(Campeonato campeonato) {
		campeonatos.remove(campeonato);
		
		campeonato = campeonatoDAO.getById(Campeonato.class, campeonato.getIdCampeonato());
		campeonatoDAO.remove(campeonato);
		campeonatoDAO.closeEntityManager();
	}

	public List<Campeonato> getCampeonatos() {
		List <Campeonato> list = campeonatoDAO.getAll(Campeonato.class);
		campeonatoDAO.closeEntityManager();
		return list;	}
}
