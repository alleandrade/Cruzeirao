package services;

import java.util.*;

import dados.Dados;
import entidades.Juiz;

public class JuizService {
	private ArrayList<Juiz> juizes = Dados.juizes;
	
	public JuizService() {
		
	}
	
	public void salvar(Juiz juiz) {
		juizes.add(juiz);
	}

	public ArrayList<Juiz> getJuizes() {
		return juizes;
	}
}
