package services;

import java.util.ArrayList;

import dados.Dados;
import dao.RodadaDAO;
import entidades.Rodada;

public class RodadaService {
	private ArrayList<Rodada> rodadas = Dados.rodadas;
 	RodadaDAO rodadaDAO = new RodadaDAO();
	
	public RodadaService() {
		
	}
	
	public Rodada salvar(Rodada rodada) {
		rodadas.add(rodada);
	
		rodada = rodadaDAO.save(rodada);
		rodadaDAO.closeEntityManager();
		return rodada;
	}
	
	public void alterar(Rodada rodada) {

		rodadaDAO.save(rodada);
		rodadaDAO.closeEntityManager();
	}
	
	public void remover(Rodada rodada) {
		rodadas.remove(rodada);
		
		rodada = rodadaDAO.getById(Rodada.class, rodada.getIdRodada());
		rodadaDAO.remove(rodada);
		rodadaDAO.closeEntityManager();
	}

	public ArrayList<Rodada> getRodadas() {
		return rodadas;
	}
}
