package sistema.services;

import java.util.*;

import sistema.dados.Dados;
import sistema.entidades.PartidasFutebol;

public class PartidaFutebolService {
	private ArrayList<PartidasFutebol> partidasfutebol = Dados.partidasfutebol;
	
	public PartidaFutebolService() {
		
	}
	
	public void salvar(PartidasFutebol partidafutebol) {
		partidasfutebol.add(partidafutebol);
	}

	public ArrayList<PartidasFutebol> getPartidasfutebol() {
		return partidasfutebol;
	}
}
