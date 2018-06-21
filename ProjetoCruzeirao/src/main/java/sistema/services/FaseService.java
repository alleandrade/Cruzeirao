package sistema.services;

import java.util.List;

import sistema.dao.FaseDAO;
import sistema.entidades.Fase;
import sistema.entidades.Grupo;

public class FaseService {

 	FaseDAO faseDAO = new FaseDAO();

	public Fase salvar(Fase fase) {
		
		fase = faseDAO.save(fase);
		faseDAO.closeEntityManager();
		return fase;
	}
	
	public void alterar(Fase fase) {

		faseDAO.save(fase);
		faseDAO.closeEntityManager();
		
	}
	
	public void remover(Fase fase) {
		
		fase = faseDAO.getById(Fase.class, fase.getIdFase());
		faseDAO.remove(fase);
		faseDAO.closeEntityManager();
	}
	
	public List<Grupo> pesquisarGruposFase(Fase fase) {

		List<Grupo> grupos;
		fase = faseDAO.getById(Fase.class, fase.getIdFase());
		grupos = fase.getGrupos();
		return grupos;
	}

	public List<Fase> getFases() {
		
		List <Fase> list = faseDAO.getAll(Fase.class);
		faseDAO.closeEntityManager();
		return list;
	}
}
