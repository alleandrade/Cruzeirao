package sistema.managedbeans;


import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.RowEditEvent;

import sistema.entidades.Local;
import sistema.services.LocalService;

@ViewScoped
@ManagedBean
public class LocalMB implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Local local = new Local();
	private LocalService localservice = new LocalService();
	private List<Local> locais;
	
	public void onRowEdit(RowEditEvent event) {

		Local l = ((Local) event.getObject());
		localservice.alterar(l);
		FacesMessage mensagem = new FacesMessage("O pedido de " + local.getNome() + " foi cadastrado com sucesso! Seu limite de crédito agora é de: R$ " + local.getNome());
	    FacesContext.getCurrentInstance().addMessage(null, mensagem);
	}
	
	public void salvar() {
		
		local = localservice.salvar(local);
		
		if (locais != null) {			
			locais.add(local);			
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Local " + local.getNome() + " cadastrado com sucesso!", null));
			FacesMessage mensagem = new FacesMessage("Local " + local.getNome() + " cadastrado com sucesso!");	
			FacesContext.getCurrentInstance().addMessage(null, mensagem);	
		}
		
		local = new Local();
	}
	
	public void remover(Local local) {
		
		if (localservice.pesquisarCampeonatosLocal(local).size() > 0) {
			FacesMessage mensagem = new FacesMessage("O pedido de " + local.getNome() + " foi cadastrado com sucesso! Seu limite de crédito agora é de: R$ " + local.getNome());
		    FacesContext.getCurrentInstance().addMessage(null, mensagem);
		}
		
		else {
			localservice.remover(local);
			locais.remove(local);	
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Local " + local.getNome() + " removido com sucesso!", null));
		}
		
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
