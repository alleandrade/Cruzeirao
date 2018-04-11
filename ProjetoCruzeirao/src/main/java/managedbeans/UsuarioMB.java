package managedbeans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import dados.Dados;

import java.util.*;
import services.UsuarioService;
import entidades.Campeonato;
import entidades.Equipe;
import entidades.Inscrito;
import entidades.Usuario;

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
	
	
	public void adicionaEquipe() {		
		usuario.getEquipes().add(auxEquipe);
	}
	
	public void removerEquipe(Equipe equipe) {
		
		if(usuario.getTipo().getTipo() == "Jogador") {
			equipe.getJogadores().remove(usuario);
			usuario.getEquipes().remove(equipe);
		}			
		
		else if(usuario.getTipo().getTipo() == "Diretor") {
			equipe.getDiretores().remove(usuario);
			usuario.getEquipes().remove(equipe);
		}	
		
		else if(usuario.getTipo().getTipo() == "Massagista" || usuario.getTipo().getTipo() == "Preparador f�sico" || usuario.getTipo().getTipo() == "T�cnico") {
			equipe.getComissaoTecnica().remove(usuario);
			usuario.getEquipes().remove(equipe);
		}
		
		else
			usuario.getEquipes().remove(equipe);
		
	}
	
	public void removerInscricao(Inscrito inscrito) {
		usuario.getInscricoes().remove(inscrito);
	}
	
	public void removerCampeonato(Campeonato campeonato) {
		usuario.getCampeonatos().remove(campeonato);
	}
	
	public void salvar() {
		
		usuarioservice.salvar(usuario);
		usuario = new Usuario();
	}
	
	public void remover(Usuario usuario) {
		usuarioservice.remover(usuario);
	}
	
	public Usuario getUsuario() {
		return usuario;
	}
	
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public ArrayList<Usuario> getUsuarios() {
		return usuarioservice.getUsuarios();
	}
	
	public ArrayList<Usuario> getJogadores() {
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
	
	
	
	
}
