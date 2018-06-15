package managedbeans;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.RowEditEvent;

import entidades.Inscrito;
import services.InscritoService;

@SessionScoped
@ManagedBean
public class InscritoMB {
	private Inscrito inscrito = new Inscrito();
	private InscritoService inscritoservice = new InscritoService();
	private List<Inscrito> inscritos;
	
	public void onRowEdit(RowEditEvent event) {

		Inscrito u = ((Inscrito) event.getObject());
		inscritoservice.alterar(u);
	}
	
	public void salvar() {
		//inscrito.setIdInscrito(0);
		inscritoservice.salvar(inscrito);
		inscrito.getInscricao().getInscritos().add(inscrito);
		inscrito.getUsuario().getInscricoes().add(inscrito);
		FacesMessage mensagem = new FacesMessage("Inscrito " + inscrito.getUsuario().getNome() + " cadastrado com sucesso!");
		FacesContext.getCurrentInstance().addMessage(null, mensagem);		
		inscrito = new Inscrito();
	}
	
	public void remover(Inscrito inscrito) {
		inscritoservice.remover(inscrito);
		FacesMessage mensagem = new FacesMessage("Inscrito " + inscrito.getUsuario().getNome() + " removido com sucesso!");
		FacesContext.getCurrentInstance().addMessage(null, mensagem);		
	}

	public Inscrito getInscrito() {
		return inscrito;
	}

	public void setInscrito(Inscrito inscrito) {
		this.inscrito = inscrito;
	}
	
	public List<Inscrito> getInscritos() {
		if (inscritos == null)
			inscritos = inscritoservice.getInscritos();
	
		return inscritos;
	}
	
}
