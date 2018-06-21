package sistema.managedbeans;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.event.RowEditEvent;

import sistema.entidades.PartidasFutebol;
import sistema.entidades.Rodada;
import sistema.services.RodadaService;

@ViewScoped
@ManagedBean
public class RodadaMB implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Rodada rodada = new Rodada();
	private RodadaService rodadaservice = new RodadaService();
	private PartidasFutebol auxPartidaFutebol;
	private List<Rodada> rodadas;
	
	public void onRowEdit(RowEditEvent event) {

		Rodada r = ((Rodada) event.getObject());
		rodadaservice.alterar(r);
	}
	
	public void salvar() {
		
		rodada.getGrupo().getRodadas().add(rodada);
		rodada = rodadaservice.salvar(rodada);
		
		if (rodadas != null)		
			rodadas.add(rodada);
		
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
		rodadas.remove(rodada);
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