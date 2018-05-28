package services;

import java.util.ArrayList;
import java.util.List;

import dados.Dados;
import dao.FaseDAO;
import entidades.Fase;

public class FaseService {
	private ArrayList<Fase> fases = Dados.fases;
 	FaseDAO faseDAO = new FaseDAO();

	public FaseService() {
		
	}
	
	public Fase salvar(Fase fase) {
		fases.add(fase);
		
		fase = faseDAO.save(fase);
		faseDAO.closeEntityManager();
		return fase;
	}
	
	public void alterar(Fase fase) {

		faseDAO.save(fase);
		faseDAO.closeEntityManager();
		
	}
	
	public void remover(Fase fase) {
		fases.remove(fase);		
		
		fase = faseDAO.getById(Fase.class, fase.getIdFase());
		faseDAO.remove(fase);
		faseDAO.closeEntityManager();
	}

	public List<Fase> getFases() {
		List <Fase> list = faseDAO.getAll(Fase.class);
		faseDAO.closeEntityManager();
		return list;
	}
}
