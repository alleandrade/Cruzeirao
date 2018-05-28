package services;

import java.util.ArrayList;
import java.util.List;

import dados.Dados;
import dao.GolDAO;
import entidades.Cartao;
import entidades.Gol;

public class GolService {
	private ArrayList<Gol> gols = Dados.gols;
 	GolDAO golDAO = new GolDAO();
	
	public GolService() {
		
	}
	
	public Gol salvar(Gol gol) {
		gols.add(gol);
		
		gol = golDAO.save(gol);
		golDAO.closeEntityManager();
		return gol;
	}
	
	public void alterar(Gol gol) {

		golDAO.save(gol);
		golDAO.closeEntityManager();
	}
	
	public void remover(Gol gol) {
		gols.remove(gol);		
		
		gol = golDAO.getById(Gol.class, gol.getIdGol());
		golDAO.remove(gol);
		golDAO.closeEntityManager();
	}

	public List<Gol> getGols() {
		List <Gol> list = golDAO.getAll(Gol.class);
		golDAO.closeEntityManager();
		return list;
	}
}
