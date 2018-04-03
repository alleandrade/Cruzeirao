package managedbeans;

import java.util.*;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import entidades.Gol;
import services.GolService;

@SessionScoped
@ManagedBean
public class GolMB {
	private Gol gol = new Gol();
	private GolService golservice = new GolService();
	
	public void salvar() {
		golservice.salvar(gol);
		gol = new Gol();
	}

	public Gol getGol() {
		return gol;
	}

	public void setGol(Gol gol) {
		this.gol = gol;
	}
	
	public ArrayList<Gol> getGols() {
		return golservice.getGols();
	}
}
