package managedbeans;

import java.util.*;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.primefaces.event.RowEditEvent;

import entidades.Fase;
import entidades.Gol;
import services.GolService;

@SessionScoped
@ManagedBean
public class GolMB {
	private Gol gol = new Gol();
	private GolService golservice = new GolService();
	private List<Gol> gols;
	
	public void onRowEdit(RowEditEvent event) {

		Gol u = ((Gol) event.getObject());
		golservice.alterar(u);
	}
	
	public void salvar() {
		gol.setIdGol(0);
		golservice.salvar(gol);
		gol = new Gol();
	}

	public Gol getGol() {
		return gol;
	}

	public void setGol(Gol gol) {
		this.gol = gol;
	}
	
	public List<Gol> getGols() {		
		if (gols == null)
			gols = golservice.getGols();
		
		return gols;
	}
}
