package sistema.managedbeans;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.RowEditEvent;

import sistema.entidades.Inscrito;
import sistema.services.InscritoService;

@ViewScoped
@ManagedBean
public class InscritoMB implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Inscrito inscrito = new Inscrito();
	private InscritoService inscritoservice = new InscritoService();
	private List<Inscrito> inscritos;
	
	public void onRowEdit(RowEditEvent event) {

		Inscrito i = ((Inscrito) event.getObject());
		inscritoservice.alterar(i);
	}
	
	public void salvar() {
		
		inscrito.getInscricao().getInscritos().add(inscrito);
		inscrito.getUsuario().getInscricoes().add(inscrito);		
		inscrito = inscritoservice.salvar(inscrito);
		
		if (inscritos != null) {
			inscritos.add(inscrito);	
			FacesMessage mensagem = new FacesMessage("Inscrito " + inscrito.getUsuario().getNome() + " cadastrado com sucesso!");
			FacesContext.getCurrentInstance().addMessage(null, mensagem);			
		}
		
		inscrito = new Inscrito();
	}
	
	public void remover(Inscrito inscrito) {
		
		if (inscrito.getInscricao() != null || inscrito.getUsuario() != null) {
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Não é possível remover o inscrito, pois há inscrição ou usuário amarrado a ele.", null));
		}
		
		else {
			inscritoservice.remover(inscrito);
			inscritos.remove(inscrito);
			FacesMessage mensagem = new FacesMessage("Inscrito " + inscrito.getUsuario().getNome() + " removido com sucesso!");
			FacesContext.getCurrentInstance().addMessage(null, mensagem);
		}
				
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