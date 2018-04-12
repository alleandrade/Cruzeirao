package services;

import java.util.*;

import dados.Dados;
import entidades.Inscricao;

public class InscricaoService {
	private ArrayList<Inscricao> inscricoes = Dados.inscricoes;
	
	public InscricaoService() {
		
	}
	
	public void salvar(Inscricao inscricao) {
		inscricoes.add(inscricao);
	}
	
	public void remover(Inscricao inscricao) {
		inscricoes.remove(inscricao);
	}

	public ArrayList<Inscricao> getInscricoes() {
		return inscricoes;
	}
}
