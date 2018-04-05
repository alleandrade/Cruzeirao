package managedbeans;

import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import entidades.Inscricao;
import entidades.Inscrito;
import entidades.Partida;
import services.InscricaoService;

@SessionScoped
@ManagedBean
public class InscricaoMB {
	private Inscricao inscricao = new Inscricao();
	private InscricaoService inscricaoservice = new InscricaoService();
	private Partida auxPartida;
	private Inscrito auxInscrito;
	
	public void adicionarPartida() {
		inscricao.getPartidas().add(auxPartida);
	}
	
	public void adicionarInscrito() {
		inscricao.getInscritos().add(auxInscrito);
	}
	
	public void removerPartida(Partida partida) {
		inscricao.getPartidas().remove(partida);
	}
	
	public void removerInscrito(Inscrito inscrito) {
		inscricao.getInscritos().remove(inscrito);
	}
	
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

	public Partida getAuxPartida() {
		return auxPartida;
	}

	public void setAuxPartida(Partida auxPartida) {
		this.auxPartida = auxPartida;
	}

	public Inscrito getAuxInscrito() {
		return auxInscrito;
	}

	public void setAuxInscrito(Inscrito auxInscrito) {
		this.auxInscrito = auxInscrito;
	}
}
