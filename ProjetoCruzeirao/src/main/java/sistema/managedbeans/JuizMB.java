package sistema.managedbeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.RowEditEvent;

import sistema.entidades.Juiz;
import sistema.entidades.Usuario;
import sistema.services.JuizService;
import sistema.services.UsuarioService;

@ViewScoped
@ManagedBean
public class JuizMB implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Juiz juiz = new Juiz();
	private JuizService juizservice = new JuizService();
	private List<Juiz> juizes;
	UsuarioMB usuario = new UsuarioMB();
	private List<Usuario> usuariosJuizes;
	private UsuarioService usuarioservice = new UsuarioService();
	
	
	public void onRowEdit(RowEditEvent event) {

		Juiz j = ((Juiz) event.getObject());
		juizservice.alterar(j);
	}
	
	public void usuariosJuizes() {
		usuariosJuizes = usuarioservice.getUsuarios().stream().filter(p -> p.getTipo().getTipo().equals("Juiz")).collect(Collectors.toCollection(ArrayList::new));
	}
	
	public void salvar() {		
		
		int count = 0;

		if (this.getJuizes() != null)
			for (Juiz j : this.getJuizes() )
				if (j.getUsuario().getIdUsuario() == juiz.getUsuario().getIdUsuario())
					count++;
		
		if (count > 0) {
			FacesMessage mensagem = new FacesMessage("Esse usuário já é um juiz!");
			FacesContext.getCurrentInstance().addMessage(null, mensagem);	
		}
		
		
		else {	
			
			juiz = juizservice.salvar(juiz);
			
			if (juizes != null) {
				juizes.add(juiz);			
				FacesMessage mensagem = new FacesMessage("Juiz " + juiz.getUsuario().getNome() + " cadastrado com sucesso!");
				FacesContext.getCurrentInstance().addMessage(null, mensagem);		
			}
		}

		juiz = new Juiz();
	}
	
	public void remover(Juiz juiz) {
		
		if (juizservice.pesquisarCampeonatosJuiz(juiz).size() > 0) {
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Não é possível remover o juiz, pois há campeonato (os) amarrados a ele.", null));
		}
		
		
		else {
			juizservice.remove(juiz);
			juizes.remove(juiz);
			FacesMessage mensagem = new FacesMessage("Juiz " + juiz.getUsuario().getNome() + " removido com sucesso!");
			FacesContext.getCurrentInstance().addMessage(null, mensagem);
		}
		
	}

	public Juiz getJuiz() {
		return juiz;
	}

	public void setJuiz(Juiz juiz) {
		this.juiz = juiz;
	}
	
	public List<Juiz> getJuizes() {
		if (juizes == null)
			juizes = juizservice.getJuizes();
		
		return juizes;
	}

	public List<Usuario> getUsuariosJuizes() {
		usuariosJuizes = usuarioservice.getUsuarios().stream().filter(p -> p.getTipo().getTipo().equals("Juiz")).collect(Collectors.toCollection(ArrayList::new));
			
		return usuariosJuizes;
	}	
	
}
