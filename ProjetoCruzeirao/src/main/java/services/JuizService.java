package services;

import java.util.ArrayList;
import java.util.List;

import dados.Dados;
import dao.JuizDAO;
import entidades.Juiz;

public class JuizService {
	private ArrayList<Juiz> juizes = Dados.juizes;
 	JuizDAO juizDAO = new JuizDAO();

	public JuizService() {
		
	}
	
	public void remove(Juiz juiz) {
		juizes.remove(juiz);
		
		juiz = juizDAO.getById(Juiz.class, juiz.getIdJuiz());
		juizDAO.remove(juiz);
		juizDAO.closeEntityManager();
	}
	
	public void alterar(Juiz juiz) {

		juizDAO.save(juiz);
		juizDAO.closeEntityManager();
	}
	
	
	public Juiz salvar(Juiz juiz) {
		juizes.add(juiz);
		
		juiz = juizDAO.save(juiz);
		juizDAO.closeEntityManager();
		return juiz;
	}

	public List<Juiz> getJuizes() {
		List <Juiz> list = juizDAO.getAll(Juiz.class);
		juizDAO.closeEntityManager();
		return list;
	}
}
