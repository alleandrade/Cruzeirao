package managedbeans;

import java.util.*;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import entidades.Local;
import services.LocalService;

@SessionScoped
@ManagedBean
public class LocalMB {
	private Local local = new Local();
	private LocalService localservice = new LocalService();
	
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
	
	public ArrayList<Local> getLocais() {
		return localservice.getLocais();
	}
}
