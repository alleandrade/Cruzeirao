package managedbeans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import dados.Dados;

import java.util.*;
import services.UsuarioService;
import entidades.Equipe;
import entidades.Usuario;

@SessionScoped
@ManagedBean
public class UsuarioMB {
	private Usuario usuario = new Usuario();
	private UsuarioService usuarioservice = new UsuarioService();
	private ArrayList<Usuario> diretores = Dados.usuarioDiretores;
	private ArrayList<Usuario> jogadores = Dados.usuarioJogadores;
	private ArrayList<Usuario> comissaoTecnica = Dados.usuarioComissao;
	private Equipe auxEquipe;
	
	
	public void adicionaEquipe() {		
		usuario.getEquipes().add(auxEquipe);
	}
	
	public void removeEquipe(Equipe equipe) {
		usuario.getEquipes().remove(equipe);
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
	
	
}
