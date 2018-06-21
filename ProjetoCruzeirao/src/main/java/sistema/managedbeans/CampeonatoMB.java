package sistema.managedbeans;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.RowEditEvent;

import sistema.entidades.Campeonato;
import sistema.entidades.Categoria;
import sistema.entidades.Juiz;
import sistema.entidades.Local;
import sistema.services.CampeonatoService;
import sistema.services.UsuarioService;

@ViewScoped
@ManagedBean
public class CampeonatoMB implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Campeonato campeonato = new Campeonato();
	private CampeonatoService campeonatoservice = new CampeonatoService();
	private Local auxLocal;
	private Juiz auxJuiz;
	private Categoria auxCategoria;
	private List<Campeonato> campeonatos;
	
	public void onRowEdit(RowEditEvent event) {

		Campeonato c = ((Campeonato) event.getObject());
		campeonatoservice.alterar(c);
	}
	
	public void salvar() {
		
		int count = 0;
		
		if (this.getCampeonatos() != null)
			for (Campeonato c : this.getCampeonatos())
				if (c.getNome().equals(campeonato.getNome()))
					count++;
		
		if (campeonato.getDataInicioCampeonato().after(campeonato.getDataFimCampeonato())  || campeonato.getDataInicioInscricao().after(campeonato.getDataFimInscricao())) 
		{
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Datas inválidas! A data fim do campeonato e do fim do prazo de inscrição não pode ocorrer antes das datas de início do campeonato e do prazo de inscrição, respectivamente", null));
		}
		
		else if (count > 0) {
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Já existe um campeonato com esse nome!", null));
		}
		
		else
		{
			campeonato = campeonatoservice.salvar(campeonato);
			
			if (campeonatos != null) {
				campeonatos.add(campeonato);			
				FacesContext context = FacesContext.getCurrentInstance();
				context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Campeonato " + campeonato.getNome() + " cadastrado com sucesso!", null));
			}

		}	

		campeonato = new Campeonato();
	}
	
	public void adicionarCategoria() {
		campeonato.getCategorias().add(auxCategoria);
	}
	
	public void adicionarJuiz() {
	
		int count = 0;
		
		if (campeonato.getJuizes() != null)
			for (Juiz j : campeonato.getJuizes())
				if (j.getIdJuiz() == auxJuiz.getIdJuiz())
					count++;
		
		if (count == 0) {
			campeonato.getJuizes().add(auxJuiz);
			auxJuiz.getUsuario().getCampeonatos().add(campeonato);		
		}

		
		else {
			FacesMessage mensagem = new FacesMessage("Juiz " + auxJuiz.getUsuario().getNome() + " já foi adicionado!");
			FacesContext.getCurrentInstance().addMessage(null, mensagem);	
		}
		
	}
	
	public void adicionarLocal() {
		
		int count = 0;
		
		if (campeonato.getLocais() != null)
			for (Local l : campeonato.getLocais())
				if (l.getIdLocal() == auxLocal.getIdLocal())
					count++;
		
		if (count == 0)
			campeonato.getLocais().add(auxLocal);
		
		else {
			FacesMessage mensagem = new FacesMessage("Local " + auxLocal.getNome() + " já foi adicionado!");
			FacesContext.getCurrentInstance().addMessage(null, mensagem);	
		}
	}
	
	public void removerLocal(Local local) {
		campeonato.getLocais().remove(local);
	}
	
	public void removerCategoria(Categoria categoria) {
		campeonato.getCategorias().remove(categoria);
	}
	
	public void removerJuiz(Juiz juiz) {
		campeonato.getJuizes().remove(juiz);
		auxJuiz.getUsuario().getCampeonatos().remove(campeonato);
	}
	
	public void remover(Campeonato campeonato) {
		
		
		if (campeonatoservice.pesquisarLocaisCampeonato(campeonato).size() > 0 || campeonatoservice.pesquisarJuizesCampeonato(campeonato).size() > 0 || campeonatoservice.pesquisarCategoriasCampeonato(campeonato).size() > 0) {
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Não é possível remover o campeonato, pois há local (is), ou juiz (es) ou categoria (as) amarrados a ele.", null));
		}
		
		
		else {
			campeonatoservice.remover(campeonato);
			campeonatos.remove(campeonato);
		
			for (Categoria aux : campeonato.getCategorias())
				aux.setCampeonato(null);
		
			FacesMessage mensagem = new FacesMessage("Campeonato " + campeonato.getNome() + " removido com sucesso!");
			FacesContext.getCurrentInstance().addMessage(null, mensagem);	
		}
				
	}	

	public Local getAuxLocal() {
		return auxLocal;
	}

	public void setAuxLocal(Local auxLocal) {
		this.auxLocal = auxLocal;
	}

	public Juiz getAuxJuiz() {
		return auxJuiz;
	}

	public void setAuxJuiz(Juiz auxJuiz) {
		this.auxJuiz = auxJuiz;
	}

	public Categoria getAuxCategoria() {
		return auxCategoria;
	}

	public void setAuxCategoria(Categoria auxCategoria) {
		this.auxCategoria = auxCategoria;
	}

	public Campeonato getCampeonato() {
		return campeonato;
	}

	public void setCampeonato(Campeonato campeonato) {
		this.campeonato = campeonato;
	}
	
	public List<Campeonato> getCampeonatos() {
		if (campeonatos == null)
			campeonatos = campeonatoservice.getCampeonatos();
		
		return campeonatos;
	}
}