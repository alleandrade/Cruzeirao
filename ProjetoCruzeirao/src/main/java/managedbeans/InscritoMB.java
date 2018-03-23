package managedbeans;

import java.util.*;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import entidades.Inscrito;
import services.InscritoService;

@SessionScoped
@ManagedBean
public class InscritoMB {
	private Inscrito inscrito = new Inscrito();
	private InscritoService inscritoservice = new InscritoService();
	
	public void salvar() {
		inscritoservice.salvar(inscrito);
		inscrito = new Inscrito();
	}

	public Inscrito getInscrito() {
		return inscrito;
	}

	public void setInscrito(Inscrito inscrito) {
		this.inscrito = inscrito;
	}
	
	public ArrayList<Inscrito> getInscritos() {
		return inscritoservice.getInscritos();
	}
}
