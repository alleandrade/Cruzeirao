package sistema.managedbeans;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.event.RowEditEvent;

import sistema.entidades.Partida;
import sistema.services.PartidaService;

@ViewScoped
@ManagedBean
public class PartidaMB implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Partida partida = new Partida();
	private PartidaService partidaservice = new PartidaService();
	private List<Partida> partidas;

	public void onRowEdit(RowEditEvent event) {

		Partida p = ((Partida) event.getObject());
		partidaservice.alterar(p);
	}
	
	public void salvar() {
		
		partida = partidaservice.salvar(partida);
		
		if (partidas != null)
			partidas.add(partida);
		
		partida = new Partida();
	}

	public Partida getPartida() {
		return partida;
	}

	public void setPartida(Partida partida) {
		this.partida = partida;
	}
	
	public List<Partida> getPartidas() {
		if (partidas == null)
			partidas = partidaservice.getPartidas();
	
		return partidas;
	}
}
