package services;

import java.util.List;
import java.util.ArrayList;

import dados.Dados;
import dao.LocalDAO;
import entidades.Local;

public class LocalService {
	private ArrayList<Local> locais = Dados.locais;
	LocalDAO localDAO = new LocalDAO();
	
	public LocalService() {
		
	}
	
	public Local salvar(Local local) {
		locais.add(local);
		
		local = localDAO.save(local);
		localDAO.closeEntityManager();
		return local;
		
	}
	
	public void remover(Local local) {
		locais.remove(local);
		
		local = localDAO.getById(Local.class, local.getIdLocal());
		localDAO.remove(local);
		localDAO.closeEntityManager();
	}
	
	public void alterar(Local local) {

		localDAO.save(local);
		localDAO.closeEntityManager();
		
	}

	public List<Local> getLocais() {
		
		List<Local> list = localDAO.getAll(Local.class);
		localDAO.closeEntityManager();
		return list;
	}
}
