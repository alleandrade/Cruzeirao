package sistema.services;

import java.util.*;

import sistema.dados.Dados;
import sistema.entidades.Inscrito;

public class InscritoService {
	private ArrayList<Inscrito> inscritos = Dados.inscritos;
	
	public InscritoService() {
		
	}
	
	public void salvar(Inscrito inscrito) {
		inscritos.add(inscrito);
	}
	
	public void remover(Inscrito inscrito) {
		inscritos.remove(inscrito);
	}

	public ArrayList<Inscrito> getInscritos() {
		return inscritos;
	}
}
