package managedbeans;

import java.util.*;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import entidades.Inscricao;
import entidades.Inscrito;
import entidades.Usuario;
import services.InscritoService;

@SessionScoped
@ManagedBean
public class InscritoMB {
	private Inscrito inscrito = new Inscrito();
	private InscritoService inscritoservice = new InscritoService();
	private Inscricao auxInscricao;


	
	public void salvar() {
		inscritoservice.salvar(inscrito);
		inscrito = new Inscrito();
	}
	
	public void remover(Inscrito inscrito) {
		inscritoservice.remover(inscrito);
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

	public Inscricao getAuxInscricao() {
		return auxInscricao;
	}

	public void setAuxInscricao(Inscricao auxInscricao) {
		this.auxInscricao = auxInscricao;
	}

	
}
