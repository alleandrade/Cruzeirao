package services;

import java.util.*;
import entidades.PartidasFutebol;

public class PartidaFutebolService {
	private ArrayList<PartidasFutebol> partidasfutebol = new ArrayList<PartidasFutebol>();
	
	public PartidaFutebolService() {
		
	}
	
	public void salvar(PartidasFutebol partidafutebol) {
		partidasfutebol.add(partidafutebol);
	}

	public ArrayList<PartidasFutebol> getPartidasfutebol() {
		return partidasfutebol;
	}
}
