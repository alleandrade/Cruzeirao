package managedbeans;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.primefaces.event.RowEditEvent;

import entidades.PartidasFutebol;
import entidades.Rodada;
import services.RodadaService;

@SessionScoped
@ManagedBean
public class RodadaMB {
	private Rodada rodada = new Rodada();
	private RodadaService rodadaservice = new RodadaService();
	private PartidasFutebol auxPartidaFutebol;
	private List<Rodada> rodadas;
	
	public void onRowEdit(RowEditEvent event) {

		Rodada u = ((Rodada) event.getObject());
		rodadaservice.alterar(u);
	}
	
	public void salvar() {
		rodada.setIdRodada(0);
		rodadaservice.salvar(rodada);
		rodada.getGrupo().getRodadas().add(rodada);
		rodada = new Rodada();
	}
	
	public void adicionarPartidaFutebol() {
		rodada.getPartidas().add(auxPartidaFutebol);
	}
	
	public void removerPartidaFutebol(PartidasFutebol partidaFutebol) {
		rodada.getPartidas().remove(partidaFutebol);
	}

	public void remover(Rodada rodada) {
		rodadaservice.remover(rodada);
	}
	
	public Rodada getRodada() {
		return rodada;
	}

	public void setRodada(Rodada rodada) {
		this.rodada = rodada;
	}
			
	public PartidasFutebol getAuxPartidaFutebol() {
		return auxPartidaFutebol;
	}

	public void setAuxPartidaFutebol(PartidasFutebol auxPartidaFutebol) {
		this.auxPartidaFutebol = auxPartidaFutebol;
	}

	public List<Rodada> getRodadas() {
		if (rodadas == null)
			rodadas = rodadaservice.getRodadas();
		
		return rodadas;
	}
}
