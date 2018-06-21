package sistema.services;

import java.util.List;

import sistema.dao.RodadaDAO;
import sistema.entidades.Rodada;


public class RodadaService {

 	RodadaDAO rodadaDAO = new RodadaDAO();
	
	public Rodada salvar(Rodada rodada) {
	
		rodada = rodadaDAO.save(rodada);
		rodadaDAO.closeEntityManager();
		return rodada;
	}
	
	public void alterar(Rodada rodada) {

		rodadaDAO.save(rodada);
		rodadaDAO.closeEntityManager();
	}
	
	public void remover(Rodada rodada) {
		
		rodada = rodadaDAO.getById(Rodada.class, rodada.getIdRodada());
		rodadaDAO.remove(rodada);
		rodadaDAO.closeEntityManager();
	}
	
	public List<Rodada> getRodadas() {
		
		List<Rodada> list = rodadaDAO.getAll(Rodada.class);
		rodadaDAO.closeEntityManager();
		return list;
	}
}
