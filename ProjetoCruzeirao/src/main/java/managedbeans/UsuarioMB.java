package managedbeans;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.RowEditEvent;

import dados.Dados;
import entidades.Campeonato;
import entidades.Equipe;
import entidades.Inscrito;
import entidades.Usuario;
import services.UsuarioService;

@SessionScoped
@ManagedBean
public class UsuarioMB {
	private Usuario usuario = new Usuario();
	private UsuarioService usuarioservice = new UsuarioService();
	private ArrayList<Usuario> diretores = Dados.usuarioDiretores;
	private ArrayList<Usuario> jogadores = Dados.usuarioJogadores;
	private ArrayList<Usuario> comissaoTecnica = Dados.usuarioComissao;
	private ArrayList<Usuario> juizes = Dados.usuarioJuizes;
	private Equipe auxEquipe;
	private List<Usuario> usuarios;
	
	public void onRowEdit(RowEditEvent event) {

		Usuario u = ((Usuario) event.getObject());
		usuarioservice.alterar(u);
	}
	
	
	public void adicionaEquipe() {		
		usuario.getEquipes().add(auxEquipe);
	}
	/*
	public void atualizaUsuario() {
		usuarios = usuarioservice.getUsuarios();
		
		for (Usuario u : usuarios) {
			if (u.getTipo().getTipo() == "Jogador") {
				jogadores.add(u);
			}
			
			else if (u.getTipo().getTipo() == "Diretor") {
				diretores.add(u);
			}
			
			else if (u.getTipo().getTipo() == "Massagista" || u.getTipo().getTipo() == "Preparador físico" || u.getTipo().getTipo() == "Técnico") {
				comissaoTecnica.add(u);
			}
		}
	}
	*/
	public void removerEquipe(Equipe equipe) {
		
		/*if (usuario.getTipo().getTipo().equals("Jogador")) {
			equipe.getJogadores().remove(usuario);
			usuario.getEquipes().remove(equipe);
		}			
		
		else if (usuario.getTipo().getTipo().equals("Diretor")) {
			equipe.getDiretores().remove(usuario);
			usuario.getEquipes().remove(equipe);
		}	
		
		else if (usuario.getTipo().getTipo().equals("Massagista") || usuario.getTipo().getTipo().equals("Preparador físico") || usuario.getTipo().getTipo().equals("Técnico")) {
			equipe.getComissaoTecnica().remove(usuario);
			usuario.getEquipes().remove(equipe);
		}
		
		else
			usuario.getEquipes().remove(equipe);*/
		
		usuario.getEquipes().remove(equipe);
		
		
	}
	
	public void removerInscricao(Inscrito inscrito) {
		usuario.getInscricoes().remove(inscrito);
	}
	
	public void removerCampeonato(Campeonato campeonato) {
		usuario.getCampeonatos().remove(campeonato);
	}
	
	public void salvar() {		
				
		if (usuario.getTipo().getTipo().equals("Preparador físico") && usuario.getCref() == "") 
		{
			FacesMessage mensagem = new FacesMessage("Preparador físico precisa ter CREF!");
			FacesContext.getCurrentInstance().addMessage(null, mensagem);				
		}
		
		
		else
		{			
			usuarioservice.salvar(usuario);
			FacesMessage mensagem = new FacesMessage("Usuário " + usuario.getNome() + " cadastrado com sucesso!");
			FacesContext.getCurrentInstance().addMessage(null, mensagem);	
			usuario = new Usuario();
		}
		
		usuario = new Usuario();
		
	
	}
	
	public void remover(Usuario usuario) {
		usuarioservice.remover(usuario);
		FacesMessage mensagem = new FacesMessage("Usuário " + usuario.getNome() + " removido com sucesso!");
		FacesContext.getCurrentInstance().addMessage(null, mensagem);		
	}
	
	public Usuario getUsuario() {
		return usuario;
	}
	
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public List<Usuario> getUsuarios() {
		if (usuarios == null)
			usuarios = usuarioservice.getUsuarios();
	
		return usuarios;
	}
	
	public ArrayList<Usuario> getJogadores()
	{
		return jogadores;
	}

	public void setJogadores(ArrayList<Usuario> jogadores) {
		this.jogadores = jogadores;
	}

	public ArrayList<Usuario> getComissaoTecnica() {
		return comissaoTecnica;
	}

	public void setComissaoTecnica(ArrayList<Usuario> comissaoTecnica) {
		this.comissaoTecnica = comissaoTecnica;
	}

	public ArrayList<Usuario> getDiretores() {
		return diretores;
	}

	public void setDiretores(ArrayList<Usuario> diretores) {
		this.diretores = diretores;
	}
	
	public Equipe getAuxEquipe() {
		return auxEquipe;
	}

	public void setAuxEquipe(Equipe auxEquipe) {
		this.auxEquipe = auxEquipe;
	}

	public ArrayList<Usuario> getJuizes() {
		return juizes;
	}

	public void setJuizes(ArrayList<Usuario> juizes) {
		this.juizes = juizes;
	}

	public UsuarioService getUsuarioservice() {
		return usuarioservice;
	}

	public void setUsuarioservice(UsuarioService usuarioservice) {
		this.usuarioservice = usuarioservice;
	}
	
	
	
	
}
