package managedbeans;

import java.util.*;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import entidades.Grupo;
import services.GrupoService;

@SessionScoped
@ManagedBean
public class GrupoMB {
	private Grupo grupo = new Grupo();
	private GrupoService gruposervice = new GrupoService();
	
	public void salvar() {
		gruposervice.salvar(grupo);
		grupo = new Grupo();
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
