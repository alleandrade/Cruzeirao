package managedbeans;

import java.util.*;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import entidades.Inscricao;
import services.InscricaoService;

@SessionScoped
@ManagedBean
public class InscricaoMB {
	private Inscricao inscricao = new Inscricao();
	private InscricaoService inscricaoservice = new InscricaoService();
	
	public void salvar() {
		inscricaoservice.salvar(inscricao);
		inscricao = new Inscricao();
	}

	public void remover(Inscricao inscricao) {
		inscricaoservice.remover(inscricao);
	}
	
	public Inscricao getInscricao() {
		return inscricao;
	}

	public void setInscricao(Inscricao inscricao) {
		this.inscricao = inscricao;
	}
	
	public ArrayList<Inscricao> getInscricoes() {
		return inscricaoservice.getInscricoes();
	}
}
