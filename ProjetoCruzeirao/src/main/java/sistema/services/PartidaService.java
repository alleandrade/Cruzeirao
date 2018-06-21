package sistema.services;

import java.util.List;

import sistema.dao.PartidaDAO;
import sistema.entidades.Partida;

public class PartidaService {

 	PartidaDAO partidaDAO = new PartidaDAO();
	
	public Partida salvar(Partida partida) {
		
		partida = partidaDAO.save(partida);
		partidaDAO.closeEntityManager();
		return partida;
	}

	public void alterar(Partida partida) {

		partidaDAO.save(partida);
		partidaDAO.closeEntityManager();
	}
	
	public void remover(Partida partida) {
		
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
