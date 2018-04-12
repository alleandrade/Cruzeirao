package managedbeans;

import java.util.*;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import entidades.Campeonato;
import entidades.Categoria;
import entidades.Juiz;
import entidades.Local;
import services.CampeonatoService;

@SessionScoped
@ManagedBean
public class CampeonatoMB {
	private Campeonato campeonato = new Campeonato();
	private CampeonatoService campeonatoservice = new CampeonatoService();
	private Local auxLocal;
	private Juiz auxJuiz;
	private Categoria auxCategoria;
	
	public void salvar() {
		campeonato.setIdCampeonato(0);
		campeonatoservice.salvar(campeonato);
		campeonato = new Campeonato();
	}
	
	public void adicionarCategoria() {
		campeonato.getCategorias().add(auxCategoria);
	}
	
	public void adicionarJuiz() {
		campeonato.getJuizes().add(auxJuiz);
		auxJuiz.getUsuario().getCampeonatos().add(campeonato);
	}
	
	public void adicionarLocal() {
		campeonato.getLocais().add(auxLocal);
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
		campeonatoservice.remover(campeonato);
		for (Categoria aux : campeonato.getCategorias()) {
			aux.setCampeonato(null);
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
	
	public ArrayList<Campeonato> getCampeonatos() {
		return campeonatoservice.getCampeonatos();
	}
}
