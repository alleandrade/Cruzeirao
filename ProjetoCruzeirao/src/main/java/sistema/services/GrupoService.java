package sistema.services;

import java.util.List;

import sistema.dao.GrupoDAO;
import sistema.entidades.Grupo;

public class GrupoService {

	GrupoDAO grupoDAO = new GrupoDAO();
	
	public Grupo salvar(Grupo grupo) {
		
		grupo = grupoDAO.save(grupo);
		grupoDAO.closeEntityManager();
		return grupo;
	}
	
	public void alterar(Grupo grupo) {

		grupoDAO.save(grupo);
		grupoDAO.closeEntityManager();
		
	}
	
	public void remover(Grupo grupo) {
		
		grupo = grupoDAO.getById(Grupo.class, grupo.getIdGrupo());
		grupoDAO.remove(grupo);
		grupoDAO.closeEntityManager();
	}

	public List<Grupo> getGrupos() {
		
		List <Grupo> list = grupoDAO.getAll(Grupo.class);
		grupoDAO.closeEntityManager();
		return list;
	}
}