package services;

import java.util.*;
import entidades.Inscricao;

public class InscricaoService {
	private ArrayList<Inscricao> inscricoes = new ArrayList<Inscricao>();
	
	public InscricaoService() {
		
	}
	
	public void salvar(Inscricao inscricao) {
		inscricoes.add(inscricao);
	}

	public ArrayList<Inscricao> getInscricoes() {
		return inscricoes;
	}
}
