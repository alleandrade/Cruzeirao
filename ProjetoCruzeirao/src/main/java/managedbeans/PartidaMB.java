package managedbeans;

import java.util.*;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import entidades.Partida;
import services.PartidaService;

@SessionScoped
@ManagedBean
public class PartidaMB {
	private Partida partida = new Partida();
	private PartidaService partidaservice = new PartidaService();
	
	public void salvar() {
		partidaservice.salvar(partida);
		partida = new Partida();
	}

	public Partida getPartida() {
		return partida;
	}

	public void setPartida(Partida partida) {
		this.partida = partida;
	}
	
	public ArrayList<Partida> getPartidas() {
		return partidaservice.getPartidas();
	}
}
