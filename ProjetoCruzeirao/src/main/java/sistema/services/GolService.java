package sistema.services;

import java.util.List;

import sistema.dao.GolDAO;
import sistema.entidades.Gol;

public class GolService {

 	GolDAO golDAO = new GolDAO();
	
	public Gol salvar(Gol gol) {
		
		gol = golDAO.save(gol);
		golDAO.closeEntityManager();
		return gol;
	}
	
	public void alterar(Gol gol) {

		golDAO.save(gol);
		golDAO.closeEntityManager();
	}
	
	public void remover(Gol gol) {	
		
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