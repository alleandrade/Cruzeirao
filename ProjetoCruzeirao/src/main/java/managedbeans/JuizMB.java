package managedbeans;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.primefaces.event.RowEditEvent;

import entidades.Juiz;
import services.JuizService;

@SessionScoped
@ManagedBean
public class JuizMB {
	private Juiz juiz = new Juiz();
	private JuizService juizservice = new JuizService();
	
	public void onRowEdit(RowEditEvent event) {

		Juiz u = ((Juiz) event.getObject());
		juizservice.alterar(u);
	}
	
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
	
	public List<Juiz> getJuizes() {
		return juizservice.getJuizes();
	}
}
