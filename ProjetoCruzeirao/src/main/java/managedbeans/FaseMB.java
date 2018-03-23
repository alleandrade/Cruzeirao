package managedbeans;

import java.util.*;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import entidades.Fase;
import services.FaseService;

@SessionScoped
@ManagedBean
public class FaseMB {
	private Fase fase = new Fase();
	private FaseService faseservice = new FaseService();
	
	public void salvar() {
		faseservice.salvar(fase);
		fase = new Fase();
	}

	public Fase getFase() {
		return fase;
	}

	public void setFase(Fase fase) {
		this.fase = fase;
	}
	
	public ArrayList<Fase> getFases() {
		return faseservice.getFases();
	}
}
