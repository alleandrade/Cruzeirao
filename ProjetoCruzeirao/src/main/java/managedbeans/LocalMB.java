package managedbeans;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.primefaces.event.RowEditEvent;

import entidades.Local;
import services.LocalService;

@SessionScoped
@ManagedBean
public class LocalMB {
	private Local local = new Local();
	private LocalService localservice = new LocalService();
	
	public void onRowEdit(RowEditEvent event) {

		Local u = ((Local) event.getObject());
		localservice.alterar(u);
	}
	
	public void salvar() {
		local.setIdLocal(0);
		localservice.salvar(local);
		local = new Local();
	}
	
	public void remover(Local local) {
		localservice.remover(local);
	}

	public Local getLocal() {
		return local;
	}

	public void setLocal(Local local) {
		this.local = local;
	}
	
	public List<Local> getLocais() {
		return localservice.getLocais();
	}
}
