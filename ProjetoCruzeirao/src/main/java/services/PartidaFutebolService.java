package services;

import java.util.ArrayList;
import java.util.List;

import dados.Dados;
import dao.PartidasFutebolDAO;
import entidades.PartidasFutebol;

public class PartidaFutebolService {
	private ArrayList<PartidasFutebol> partidasfutebol = Dados.partidasfutebol;
	PartidasFutebolDAO partidaFutebolDAO = new PartidasFutebolDAO();
	
	public PartidaFutebolService() {
		
	}
	
	public PartidasFutebol salvar(PartidasFutebol partidafutebol) {
		partidasfutebol.add(partidafutebol);
		
		partidafutebol = partidaFutebolDAO.save(partidafutebol);
		partidaFutebolDAO.closeEntityManager();
		return partidafutebol;
	}
	
	public void alterar(PartidasFutebol partidafutebol) {

		partidaFutebolDAO.save(partidafutebol);
		partidaFutebolDAO.closeEntityManager();
	}
	
	public void remover(PartidasFutebol partidafutebol) {
		partidasfutebol.remove(partidafutebol);		
		
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
