package managedbeans;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.RowEditEvent;

import entidades.Categoria;
import entidades.Grupo;
import entidades.Inscricao;
import entidades.Inscrito;
import entidades.PartidasFutebol;
import entidades.Usuario;
import services.InscricaoService;
import services.InscritoService;

@SessionScoped
@ManagedBean
public class InscricaoMB {
	private Inscricao inscricao = new Inscricao();
	private InscricaoService inscricaoservice = new InscricaoService();
	private PartidasFutebol auxPartidaFutebol;
	private Inscrito auxInscrito;
	private List<Inscricao> inscricoes;
	
	public void onRowEdit(RowEditEvent event) {

		Inscricao u = ((Inscricao) event.getObject());
		inscricaoservice.alterar(u);
	}
	
	public void salvar() {
		
		Date date = new Date();
		//inscricao.setIdInscricao(0);
		
		if (inscricao.getCategoria().getCampeonato().getDataInicioInscricao().after(date)  || inscricao.getCategoria().getCampeonato().getDataFimInscricao().before(date)) 
		{
			FacesMessage mensagem = new FacesMessage("Não é possível realizar a inscrição fora do prazo de inscrição!");
			FacesContext.getCurrentInstance().addMessage(null, mensagem);			
		}
		
		
		else 
		{
			for (Usuario auxA : inscricao.getEquipe().getUsuarios()) {
				
				if (!auxA.getTipo().getTipo().equals("Diretor")) {
					
					Inscrito inscrito = new Inscrito();
					InscritoService auxInscrito = new InscritoService();
					inscrito.setTipo(auxA.getTipo());
					inscrito.setAceiteUsuario(true);
					inscrito.setInscricaoValidada(true);
					inscrito.setSuspensoJogos(false);
					inscrito.setInscricao(inscricao);
					inscrito.setUsuario(auxA);
					auxA.getCampeonatos().add(inscricao.getCategoria().getCampeonato());
					auxA.getInscricoes().add(inscrito);
					auxInscrito.salvar(inscrito);
					inscricao.getInscritos().add(inscrito);		
					
				}	
					
			}
			
			inscricaoservice.salvar(inscricao);
			inscricao.getCategoria().getInscricoes().add(inscricao);
			FacesMessage mensagem = new FacesMessage("Inscrição realizada com sucesso!");
			FacesContext.getCurrentInstance().addMessage(null, mensagem);				
			
		}	
		
		
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
		FacesMessage mensagem = new FacesMessage("Inscrição removida com sucesso!");
		FacesContext.getCurrentInstance().addMessage(null, mensagem);		
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

	public List<Inscricao> getInscricoes() {
		if (inscricoes == null)
			inscricoes = inscricaoservice.getInscricoes();
	
		return inscricoes;
	}
}
