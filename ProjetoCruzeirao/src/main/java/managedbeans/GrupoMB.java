package managedbeans;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.primefaces.event.RowEditEvent;

import entidades.Grupo;
import entidades.Rodada;
import services.GrupoService;

@SessionScoped
@ManagedBean
public class GrupoMB {
	private Grupo grupo = new Grupo();
	private GrupoService gruposervice = new GrupoService();
	private Rodada auxRodada;
	
	public void onRowEdit(RowEditEvent event) {

		Grupo u = ((Grupo) event.getObject());
		gruposervice.alterar(u);
	}
	
	public void salvar() {
		grupo.setIdGrupo(0);
		gruposervice.salvar(grupo);
		grupo.getFase().getGrupos().add(grupo);
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
	
	public List<Grupo> getGrupos() {
		return gruposervice.getGrupos();
	}
}
