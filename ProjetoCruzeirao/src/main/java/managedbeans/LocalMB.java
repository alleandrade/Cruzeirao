package managedbeans;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.RowEditEvent;

import entidades.Local;
import services.LocalService;

@SessionScoped
@ManagedBean
public class LocalMB {
	private Local local = new Local();
	private LocalService localservice = new LocalService();
	private List<Local> locais;
	
	public void onRowEdit(RowEditEvent event) {

		Local u = ((Local) event.getObject());
		localservice.alterar(u);		
	}
	
	public void salvar() {
		//local.setIdLocal(0);
		localservice.salvar(local);
		FacesMessage mensagem = new FacesMessage("Local " + local.getNome() + " cadastrado com sucesso!");
		FacesContext.getCurrentInstance().addMessage(null, mensagem);	
		local = new Local();
	}
	
	public void remover(Local local) {
		localservice.remover(local);
		FacesMessage mensagem = new FacesMessage("Local " + local.getNome() + " removido com sucesso!");
		FacesContext.getCurrentInstance().addMessage(null, mensagem);	
	}

	public Local getLocal() {
		return local;
	}

	public void setLocal(Local local) {
		this.local = local;
	}
	
	public List<Local> getLocais() {
		if (locais == null)
			locais = localservice.getLocais();
		
		return locais;
	}	
}
