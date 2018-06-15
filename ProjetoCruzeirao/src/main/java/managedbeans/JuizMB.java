package managedbeans;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.RowEditEvent;

import entidades.Juiz;
import services.JuizService;

@SessionScoped
@ManagedBean
public class JuizMB {
	private Juiz juiz = new Juiz();
	private JuizService juizservice = new JuizService();
	private List<Juiz> juizes;
	
	public void onRowEdit(RowEditEvent event) {

		Juiz u = ((Juiz) event.getObject());
		juizservice.alterar(u);
	}
	
	public void salvar() {
		//juiz.setIdJuiz(0);
		juizservice.salvar(juiz);
		FacesMessage mensagem = new FacesMessage("Juiz " + juiz.getUsuario().getNome() + " cadastrado com sucesso!");
		FacesContext.getCurrentInstance().addMessage(null, mensagem);		
		juiz = new Juiz();
	}
	
	public void remover(Juiz juiz) {
		juizservice.remove(juiz);
		FacesMessage mensagem = new FacesMessage("Juiz " + juiz.getUsuario().getNome() + " removido com sucesso!");
		FacesContext.getCurrentInstance().addMessage(null, mensagem);	
	}

	public Juiz getJuiz() {
		return juiz;
	}

	public void setJuiz(Juiz juiz) {
		this.juiz = juiz;
	}
	
	public List<Juiz> getJuizes() {
		if (juizes== null)
			juizes = juizservice.getJuizes();
		
		return juizes;
	}
}
