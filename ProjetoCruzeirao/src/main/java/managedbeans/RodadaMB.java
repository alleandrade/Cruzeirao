package managedbeans;

import java.util.*;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import entidades.Rodada;
import services.RodadaService;

@SessionScoped
@ManagedBean
public class RodadaMB {
	private Rodada rodada = new Rodada();
	private RodadaService rodadaservice = new RodadaService();
	
	public void salvar() {
		rodadaservice.salvar(rodada);
		rodada = new Rodada();
	}

	public Rodada getRodada() {
		return rodada;
	}

	public void setRodada(Rodada rodada) {
		this.rodada = rodada;
	}
	
	public ArrayList<Rodada> getRodadas() {
		return rodadaservice.getRodadas();
	}
}
