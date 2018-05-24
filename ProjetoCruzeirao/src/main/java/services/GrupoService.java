package services;

import java.util.ArrayList;
import java.util.List;

import dados.Dados;
import dao.GrupoDAO;
import entidades.Grupo;

public class GrupoService {
	private ArrayList<Grupo> grupos = Dados.grupos;
	GrupoDAO grupoDAO = new GrupoDAO();
	
	public GrupoService() {
		
	}
	
	public Grupo salvar(Grupo grupo) {
		grupos.add(grupo);
		
		grupo = grupoDAO.save(grupo);
		grupoDAO.closeEntityManager();
		return grupo;
	}
	
	public void alterar(Grupo grupo) {

		grupoDAO.save(grupo);
		grupoDAO.closeEntityManager();
		
	}
	
	public void remover(Grupo grupo) {
		grupos.remove(grupo);
		
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
