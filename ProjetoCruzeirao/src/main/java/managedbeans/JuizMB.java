package managedbeans;

import java.util.*;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import entidades.Juiz;
import services.JuizService;

@SessionScoped
@ManagedBean
public class JuizMB {
	private Juiz juiz = new Juiz();
	private JuizService juizservice = new JuizService();
	
	public void salvar() {
		juizservice.salvar(juiz);
		juiz = new Juiz();
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
