package services;

import java.util.*;
import entidades.Juiz;

public class JuizService {
	private ArrayList<Juiz> juizes = new ArrayList<Juiz>();
	
	public JuizService() {
		
	}
	
	public void salvar(Juiz juiz) {
		juizes.add(juiz);
	}

	public ArrayList<Juiz> getJuizes() {
		return juizes;
	}
}
