package managedbeans;

import java.util.*;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import entidades.Equipe;
import entidades.Fase;
import entidades.Grupo;
import services.FaseService;

@SessionScoped
@ManagedBean
public class FaseMB {
	private Fase fase = new Fase();
	private FaseService faseservice = new FaseService();
	private Grupo auxGrupo;
	
	public void salvar() {
		faseservice.salvar(fase);
		fase.getCategoria().getFases().add(fase);
		fase = new Fase();
	}
	
	public void remover(Fase fase) {
		faseservice.remover(fase);
	}
	
	public void adicionarGrupo() {
		fase.getGrupos().add(auxGrupo);
	}
	
	public void removerGrupo(Grupo grupo) {
		fase.getGrupos().remove(grupo);
	}

	public Grupo getAuxGrupo() {
		return auxGrupo;
	}

	public void setAuxGrupo(Grupo auxGrupo) {
		this.auxGrupo = auxGrupo;
	}

	public Fase getFase() {
		return fase;
	}

	public void setFase(Fase fase) {
		this.fase = fase;
	}
	
	public ArrayList<Fase> getFases() {
		return faseservice.getFases();
	}
}
