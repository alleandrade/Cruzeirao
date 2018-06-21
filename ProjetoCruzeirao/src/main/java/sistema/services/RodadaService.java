package sistema.services;

import java.util.*;

import sistema.dados.Dados;
import sistema.entidades.Rodada;

public class RodadaService {
	private ArrayList<Rodada> rodadas = Dados.rodadas;
	
	public RodadaService() {
		
	}
	
	public void salvar(Rodada rodada) {
		rodadas.add(rodada);
	}
	
	public void remover(Rodada rodada) {
		rodadas.remove(rodada);
	}

	public ArrayList<Rodada> getRodadas() {
		return rodadas;
	}
}
