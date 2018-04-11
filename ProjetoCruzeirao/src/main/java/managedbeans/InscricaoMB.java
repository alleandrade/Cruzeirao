package managedbeans;

import java.util.*;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import entidades.Inscricao;
import entidades.Inscrito;
import entidades.PartidasFutebol;
import services.InscricaoService;

@SessionScoped
@ManagedBean
public class InscricaoMB {
	private Inscricao inscricao = new Inscricao();
	private InscricaoService inscricaoservice = new InscricaoService();
	private PartidasFutebol auxPartidaFutebol;
	private Inscrito auxInscrito;
	
	public void salvar() {
		inscricaoservice.salvar(inscricao);
		inscricao.getCategoria().getInscricoes().add(inscricao);
		inscricao = new Inscricao();
	}
	
	public void adicionarPartidaFutebol() {
		inscricao.getPartidas().add(auxPartidaFutebol);
	}
	
	public void adicionarInscrito() {
		inscricao.getInscritos().add(auxInscrito);
	}

	public void remover(Inscricao inscricao) {
		inscricaoservice.remover(inscricao);
	}
	
	public void removerPartidaFutebol(PartidasFutebol partida) {
		inscricao.getPartidas().remove(partida);
	}
	
	public void removerInscrito(Inscrito inscrito) {
		inscricao.getInscritos().remove(inscrito);
	}
	
	public Inscricao getInscricao() {
		return inscricao;
	}

	public void setInscricao(Inscricao inscricao) {
		this.inscricao = inscricao;
	}
		
	public PartidasFutebol getAuxPartidaFutebol() {
		return auxPartidaFutebol;
	}

	public void setAuxPartidaFutebol(PartidasFutebol auxPartidaFutebol) {
		this.auxPartidaFutebol = auxPartidaFutebol;
	}

	public Inscrito getAuxInscrito() {
		return auxInscrito;
	}

	public void setAuxInscrito(Inscrito auxInscrito) {
		this.auxInscrito = auxInscrito;
	}

	public ArrayList<Inscricao> getInscricoes() {
		return inscricaoservice.getInscricoes();
	}
}
