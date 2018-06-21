package sistema.services;

import java.util.ArrayList;
import java.util.List;

import sistema.dao.JuizDAO;
import sistema.entidades.Campeonato;
import sistema.entidades.Juiz;

public class JuizService {

 	JuizDAO juizDAO = new JuizDAO();
	
	public void remove(Juiz juiz) {
		
		juiz = juizDAO.getById(Juiz.class, juiz.getIdJuiz());
		juizDAO.remove(juiz);
		juizDAO.closeEntityManager();
	}
	
	public void alterar(Juiz juiz) {

		juizDAO.save(juiz);
		juizDAO.closeEntityManager();
	}
	
	
	public Juiz salvar(Juiz juiz) {
		
		juiz = juizDAO.save(juiz);
		juizDAO.closeEntityManager();
		return juiz;
	}
	
	public List<Campeonato> pesquisarCampeonatosJuiz(Juiz juiz) {

		List<Campeonato> campeonatos = new ArrayList<Campeonato>();
		List<Campeonato> percorreCampeonatos;
		CampeonatoService campeonato = new CampeonatoService();
		
		percorreCampeonatos = campeonato.getCampeonatos();
		
		for (Campeonato c : percorreCampeonatos) 
			for (Juiz j : c.getJuizes())
				if (j.getIdJuiz() == juiz.getIdJuiz())
					campeonatos.add(c);
		
		return campeonatos;
	}

	public List<Juiz> getJuizes() {
		
		List <Juiz> list = juizDAO.getAll(Juiz.class);
		juizDAO.closeEntityManager();
		return list;
	}
}
