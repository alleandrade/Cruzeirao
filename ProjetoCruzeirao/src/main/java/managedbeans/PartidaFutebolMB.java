package managedbeans;

import java.util.*;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import entidades.PartidasFutebol;
import services.PartidaFutebolService;

@SessionScoped
@ManagedBean
public class PartidaFutebolMB {
	private PartidasFutebol partidasfutebol = new PartidasFutebol();
	private PartidaFutebolService partidasfutebolservice = new PartidaFutebolService();
	
	public void salvar() {
		partidasfutebolservice.salvar(partidasfutebol);
		partidasfutebol = new PartidasFutebol();
	}

	public PartidasFutebol getPartidasfutebol() {
		return partidasfutebol;
	}

	public void setPartidasfutebol(PartidasFutebol partidasfutebol) {
		this.partidasfutebol = partidasfutebol;
	}
	
	public ArrayList<PartidasFutebol> getPartidasFutebol() {
		return partidasfutebolservice.getPartidasfutebol();
	}
}
