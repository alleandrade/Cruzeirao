package managedbeans;

import java.util.*;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import entidades.Grupo;
import entidades.Rodada;
import services.GrupoService;

@SessionScoped
@ManagedBean
public class GrupoMB {
	private Grupo grupo = new Grupo();
	private GrupoService gruposervice = new GrupoService();
	private Rodada auxRodada;
	
	public void salvar() {
		gruposervice.salvar(grupo);
		grupo = new Grupo();
	}
	
	public void adicionarRodada() {
		grupo.getRodadas().add(auxRodada);
	}

	public void remover(Grupo grupo) {
		gruposervice.remover(grupo);
	}
	
	public void removerRodada(Rodada rodada) {
		grupo.getRodadas().remove(rodada);
	}

	public Rodada getAuxRodada() {
		return auxRodada;
	}

	public void setAuxRodada(Rodada auxRodada) {
		this.auxRodada = auxRodada;
	}
	
	public Grupo getGrupo() {
		return grupo;
	}

	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}
	
	public ArrayList<Grupo> getGrupos() {
		return gruposervice.getGrupos();
	}
}
