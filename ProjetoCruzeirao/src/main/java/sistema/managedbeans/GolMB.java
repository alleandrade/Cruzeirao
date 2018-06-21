package sistema.managedbeans;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.event.RowEditEvent;

import sistema.entidades.Gol;
import sistema.services.GolService;

@ViewScoped
@ManagedBean
public class GolMB implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Gol gol = new Gol();
	private GolService golservice = new GolService();
	private List<Gol> gols;
	
	public void onRowEdit(RowEditEvent event) {

		Gol g = ((Gol) event.getObject());
		golservice.alterar(g);
	}
	
	public void salvar() {
		gol = golservice.salvar(gol);
		
		if (gols != null)
			gols.add(gol);
		
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
