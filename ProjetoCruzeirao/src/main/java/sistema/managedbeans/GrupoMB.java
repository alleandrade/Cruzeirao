package sistema.managedbeans;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.event.RowEditEvent;

import sistema.entidades.Grupo;
import sistema.entidades.Rodada;
import sistema.services.GrupoService;

@ViewScoped
@ManagedBean
public class GrupoMB implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Grupo grupo = new Grupo();
	private GrupoService gruposervice = new GrupoService();
	private Rodada auxRodada;
	private List<Grupo> grupos;
	
	public void onRowEdit(RowEditEvent event) {

		Grupo g = ((Grupo) event.getObject());
		gruposervice.alterar(g);
	}
	
	public void salvar() {
		
		grupo.getFase().getGrupos().add(grupo);		
		grupo = gruposervice.salvar(grupo);
		
		if (grupos != null) {
			grupos.add(grupo);					
		}

		grupo = new Grupo();
	}
	
	public void adicionarRodada() {
		grupo.getRodadas().add(auxRodada);
	}

	public void remover(Grupo grupo) {
		gruposervice.remover(grupo);
		grupos.remove(grupo);
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
		if (grupos == null)
			grupos = gruposervice.getGrupos();
		
		return grupos;
	}
}