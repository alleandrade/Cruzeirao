package managedbeans;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.primefaces.event.RowEditEvent;

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
	
	public void onRowEdit(RowEditEvent event) {

		Partida u = ((Partida) event.getObject());
		partidaservice.alterar(u);
	}

	public Partida getPartida() {
		return partida;
	}

	public void setPartida(Partida partida) {
		this.partida = partida;
	}
	
	public List<Partida> getPartidas() {
		return partidaservice.getPartidas();
	}
}
