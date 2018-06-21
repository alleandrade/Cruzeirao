package sistema.managedbeans;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.RowEditEvent;

import sistema.entidades.Inscricao;
import sistema.entidades.Inscrito;
import sistema.entidades.PartidasFutebol;
import sistema.entidades.Usuario;
import sistema.services.CategoriaService;
import sistema.services.InscricaoService;
import sistema.services.InscritoService;
import sistema.services.UsuarioService;

@ViewScoped
@ManagedBean
public class InscricaoMB implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Inscricao inscricao = new Inscricao();
	private InscricaoService inscricaoservice = new InscricaoService();
	private PartidasFutebol auxPartidaFutebol;
	private Inscrito auxInscrito;
	private List<Inscricao> inscricoes;
	private CategoriaService categoriaservice = new CategoriaService();
	
	public void onRowEdit(RowEditEvent event) {

		Inscricao i = ((Inscricao) event.getObject());
		inscricaoservice.alterar(i);
	}
	
	public void salvar() {
		
		Date date = new Date();
		
		if (inscricao.getCategoria().getCampeonato().getDataInicioInscricao().after(date)  || inscricao.getCategoria().getCampeonato().getDataFimInscricao().before(date)) 
		{
			FacesMessage mensagem = new FacesMessage("Não é possível realizar a inscrição fora do prazo de inscrição!");
			FacesContext.getCurrentInstance().addMessage(null, mensagem);			
		}
		
		
		else 
		{
			for (Usuario u : inscricao.getEquipe().getUsuarios()) {
				
				if (!u.getTipo().getTipo().equals("Diretor")) {
					
					Inscrito inscrito = new Inscrito();
					UsuarioService usuarioservice = new UsuarioService();
					InscritoService inscritoservice = new InscritoService();
					inscrito.setTipo(u.getTipo());
					inscrito.setAceiteUsuario(true);
					inscrito.setInscricaoValidada(true);
					inscrito.setSuspensoJogos(false);
					inscrito.setInscricao(inscricao);
					inscrito.setUsuario(u);
					u.getCampeonatos().add(inscricao.getCategoria().getCampeonato());
					u.getInscricoes().add(inscrito);
					usuarioservice.alterar(u);
					inscritoservice.salvar(inscrito);
					inscricao.getInscritos().add(inscrito);		
					
				}	
					
			}
			
			inscricao = inscricaoservice.salvar(inscricao);
			
			if (inscricoes != null) {
				inscricoes.add(inscricao);
				
				//if (inscricao.getCategoria() != null) {
					//inscricao.getCategoria().getInscricoes().add(inscricao);
					//categoriaservice.alterar(inscricao.getCategoria());
				//}
				

				FacesMessage mensagem = new FacesMessage("Inscrição realizada com sucesso!");
				FacesContext.getCurrentInstance().addMessage(null, mensagem);	
			}
			
			
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
		
		if (inscricao.getEquipe() != null || inscricaoservice.pesquisarInscritosInscricao(inscricao).size() > 0 || inscricaoservice.pesquisarPartidasInscricao(inscricao).size() > 0) {
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Não é possível remover a inscrição, pois há equipe, ou inscrito (os) ou partida (as) amarradas a ele.", null));
		}
		
		else {			
			inscricaoservice.remover(inscricao);
			inscricoes.remove(inscricao);
			
			if (inscricao.getCategoria() != null)
				inscricao.getCategoria().getInscricoes().remove(inscricao);
			
			FacesMessage mensagem = new FacesMessage("Inscrição removida com sucesso!");
			FacesContext.getCurrentInstance().addMessage(null, mensagem);	
		}		
			
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