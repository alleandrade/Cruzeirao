package sistema.services;

import java.util.ArrayList;
import java.util.List;

import sistema.dao.LocalDAO;
import sistema.entidades.Campeonato;
import sistema.entidades.Local;

public class LocalService {

	LocalDAO localDAO = new LocalDAO();
	
	public Local salvar(Local local) {
		
		local = localDAO.save(local);
		localDAO.closeEntityManager();
		return local;
		
	}
	
	public void remover(Local local) {
		
		local = localDAO.getById(Local.class, local.getIdLocal());
		localDAO.remove(local);
		localDAO.closeEntityManager();
	}
	
	public void alterar(Local local) {

		localDAO.save(local);
		localDAO.closeEntityManager();
		
	}
	
	public List<Campeonato> pesquisarCampeonatosLocal(Local local) {

		List<Campeonato> campeonatos = new ArrayList<Campeonato>();
		List<Campeonato> percorreCampeonatos;
		CampeonatoService campeonato = new CampeonatoService();
		
		percorreCampeonatos = campeonato.getCampeonatos();
		
		for (Campeonato c : percorreCampeonatos) 
			for (Local l : c.getLocais())
				if (l.getIdLocal() == local.getIdLocal())
					campeonatos.add(c);
		
		return campeonatos;
	}

	public List<Local> getLocais() {
		
		List<Local> list = localDAO.getAll(Local.class);
		localDAO.closeEntityManager();
		return list;
	}
}