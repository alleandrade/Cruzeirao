package managedbeans;

import java.util.*;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import entidades.Campeonato;
import services.CampeonatoService;

@SessionScoped
@ManagedBean
public class CampeonatoMB {
	private Campeonato campeonato = new Campeonato();
	private CampeonatoService campeonatoservice = new CampeonatoService();
	
	public void salvar() {
		campeonatoservice.salvar(campeonato);
		campeonato = new Campeonato();
	}

	public Campeonato getCampeonato() {
		return campeonato;
	}

	public void setCampeonato(Campeonato campeonato) {
		this.campeonato = campeonato;
	}
	
	public ArrayList<Campeonato> getCampeonatos() {
		return campeonatoservice.getCampeonatos();
	}
}
