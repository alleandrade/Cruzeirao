package sistema.services;

import java.util.List;

import sistema.dao.PartidasFutebolDAO;
import sistema.entidades.PartidasFutebol;

public class PartidaFutebolService {

	PartidasFutebolDAO partidaFutebolDAO = new PartidasFutebolDAO();
	
	public PartidasFutebol salvar(PartidasFutebol partidafutebol) {
		
		partidafutebol = partidaFutebolDAO.save(partidafutebol);
		partidaFutebolDAO.closeEntityManager();
		return partidafutebol;
	}
	
	public void alterar(PartidasFutebol partidafutebol) {

		partidaFutebolDAO.save(partidafutebol);
		partidaFutebolDAO.closeEntityManager();
	}
	
	public void remover(PartidasFutebol partidafutebol) {	
		
		partidafutebol = partidaFutebolDAO.getById(PartidasFutebol.class, partidafutebol.getIdPartida());
		partidaFutebolDAO.remove(partidafutebol);
		partidaFutebolDAO.closeEntityManager();
	}

	public List<PartidasFutebol> getPartidasfutebol() {
		
		List <PartidasFutebol> list = partidaFutebolDAO.getAll(PartidasFutebol.class);
		partidaFutebolDAO.closeEntityManager();
		return list;
	}
}
