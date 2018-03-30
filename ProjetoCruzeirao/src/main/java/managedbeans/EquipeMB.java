package managedbeans;

import java.util.*;


import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


import entidades.Equipe;
import entidades.Usuario;
import services.EquipeService;

@SessionScoped
@ManagedBean
public class EquipeMB {
	private Equipe equipe = new Equipe();
	private EquipeService equipeservice = new EquipeService();
	private Equipe auxEquipe;
	

	
	public Equipe getAuxEquipe() {
		return auxEquipe;
	}

	public void setAuxEquipe(Equipe auxEquipe) {
		this.auxEquipe = auxEquipe;
	}
	
	public void removeDiretor(Usuario diretor) {
		
	}
	
	public void adicionaDiretor() {
		
	}

	public void salvar() {
		equipeservice.salvar(equipe);
		equipe = new Equipe();
	}

	public Equipe getEquipe() {
		return equipe;
	}

	public void setEquipe(Equipe equipe) {
		this.equipe = equipe;
	}
	
	public ArrayList<Equipe> getEquipes() {
		return equipeservice.getEquipes();
	}
}
