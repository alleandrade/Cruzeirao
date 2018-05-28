package services;

import java.util.ArrayList;
import java.util.List;

import dados.Dados;
import dao.PartidaDAO;
import entidades.Partida;

public class PartidaService {
	private ArrayList<Partida> partidas = Dados.partidas;
 	PartidaDAO partidaDAO = new PartidaDAO();
	
	public PartidaService() {
		
	}
	
	public Partida salvar(Partida partida) {
		partidas.add(partida);
		
		partida = partidaDAO.save(partida);
		partidaDAO.closeEntityManager();
		return partida;
	}

	public void alterar(Partida partida) {

		partidaDAO.save(partida);
		partidaDAO.closeEntityManager();
	}
	
	public void remover(Partida partida) {
		partidas.remove(partida);		
		
		partida = partidaDAO.getById(Partida.class, partida.getIdPartida());
		partidaDAO.remove(partida);
		partidaDAO.closeEntityManager();
	}
	
	public List<Partida> getPartidas() {
		List <Partida> list = partidaDAO.getAll(Partida.class);
		partidaDAO.closeEntityManager();
		return list;
	}
}
