package sistema.managedbeans;

import java.util.*;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import sistema.entidades.Juiz;
import sistema.services.JuizService;

@SessionScoped
@ManagedBean
public class JuizMB {
	private Juiz juiz = new Juiz();
	private JuizService juizservice = new JuizService();
	
	public void salvar() {
		juiz.setIdJuiz(0);
		juizservice.salvar(juiz);
		juiz = new Juiz();
	}
	
	public void remover(Juiz juiz) {
		juizservice.remove(juiz);
	}

	public Juiz getJuiz() {
		return juiz;
	}

	public void setJuiz(Juiz juiz) {
		this.juiz = juiz;
	}
	
	public ArrayList<Juiz> getJuizes() {
		return juizservice.getJuizes();
	}
}
