package sistema.managedbeans;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.RowEditEvent;

import sistema.dados.Dados;
import sistema.entidades.Campeonato;
import sistema.entidades.Equipe;
import sistema.entidades.Inscrito;
import sistema.entidades.Usuario;
import sistema.services.EquipeService;
import sistema.services.UsuarioService;

@ViewScoped
@ManagedBean
public class UsuarioMB implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Usuario usuario = new Usuario();
	private UsuarioService usuarioservice = new UsuarioService();
	private List<Usuario> diretores = Dados.usuarioDiretores;
	private List<Usuario> jogadores = Dados.usuarioJogadores;
	private List<Usuario> comissaoTecnica = Dados.usuarioComissao;
	private List<Usuario> juizes = Dados.usuarioJuizes;
	private Equipe auxEquipe;
	private List<Usuario> usuarios;
	private EquipeService equipeservice = new EquipeService();
	
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
		usuarioservice.alterar(usuario);
		equipeservice.alterar(equipe);
		
	}
	
	public void tiposUsuarios() {
		jogadores = usuarioservice.getUsuarios().stream().filter(p -> p.getTipo().getTipo().equals("Jogador")).collect(Collectors.toList());
		comissaoTecnica = usuarioservice.getUsuarios().stream().filter(p -> p.getTipo().getTipo().equals("Preparador físico") || p.getTipo().getTipo().equals("Massagista") || p.getTipo().getTipo().equals("Técnico")).collect(Collectors.toList());
		diretores = usuarioservice.getUsuarios().stream().filter(p -> p.getTipo().getTipo().equals("Diretor")).collect(Collectors.toList());
		juizes = usuarioservice.getUsuarios().stream().filter(p -> p.getTipo().getTipo().equals("Juiz")).collect(Collectors.toList());
	}
	
	public void removerInscricao(Inscrito inscrito) {
		usuario.getInscricoes().remove(inscrito);
	}
	
	public void removerCampeonato(Campeonato campeonato) {
		usuario.getCampeonatos().remove(campeonato);
	}
	
	public void salvar() {		
		
		int count = 0;
		
		for (Usuario u : this.getUsuarios())
			if (u.getNome().equals(usuario.getNome()) && u.getRg() == usuario.getRg())
				count++;
				
		if (usuario.getTipo().getTipo().equals("Preparador físico") && usuario.getCref() == "") 
		{
			FacesMessage mensagem = new FacesMessage("Preparador físico precisa ter CREF!");
			FacesContext.getCurrentInstance().addMessage(null, mensagem);				
		}
		
		else if (count > 0) {
			FacesMessage mensagem = new FacesMessage("Já existe um usuário com esse nome e RG!");
			FacesContext.getCurrentInstance().addMessage(null, mensagem);				
		}		
		
		
		else
		{			
			usuario = usuarioservice.salvar(usuario);
			
			if (usuarios != null) {
				usuarios.add(usuario);
				FacesMessage mensagem = new FacesMessage("Usuário " + usuario.getNome() + " cadastrado com sucesso!");
				FacesContext.getCurrentInstance().addMessage(null, mensagem);	
			}
			
		}
		
		usuario = new Usuario();
		
	
	}
	
	public void remover(Usuario usuario) {
		
		if (usuarioservice.pesquisarEquipesUsuario(usuario).size() > 0 || usuarioservice.pesquisarCampeonatosUsuario(usuario).size() > 0 || usuarioservice.pesquisarInscricoesUsuario(usuario).size() > 0) {
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Não é possível remover o usuário, pois há equipe (es), ou campeonato (os) ou inscrição (ões) amarradas a ele.", null));
			System.out.println(usuario.getCampeonatos());
		}
		
		else if (usuarioservice.pesquisarJuizUsuario(usuario).size() > 0) {
			FacesMessage mensagem = new FacesMessage("Não é possível remover o usuário, pois ele foi cadastrado como juiz.");
			FacesContext.getCurrentInstance().addMessage(null, mensagem);	
		}
		
		else {
			usuarioservice.remover(usuario);
			usuarios.remove(usuario);
			FacesMessage mensagem = new FacesMessage("Usuário " + usuario.getNome() + " removido com sucesso!");
			FacesContext.getCurrentInstance().addMessage(null, mensagem);	
		}
		
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
	
	public List<Usuario> getJogadores()
	{
		return jogadores;
	}

	public void setJogadores(List<Usuario> jogadores) {
		this.jogadores = jogadores;
	}

	public List<Usuario> getComissaoTecnica() {
		return comissaoTecnica;
	}

	public void setComissaoTecnica(List<Usuario> comissaoTecnica) {
		this.comissaoTecnica = comissaoTecnica;
	}

	public List<Usuario> getDiretores() {
		
		if (diretores == null)
			diretores = usuarioservice.getUsuarios().stream().filter(p -> p.getTipo().getTipo().equals("Diretor")).collect(Collectors.toList());
		
		return diretores;
	}

	public void setDiretores(List<Usuario> diretores) {
		this.diretores = diretores;
	}
	
	public Equipe getAuxEquipe() {
		return auxEquipe;
	}

	public void setAuxEquipe(Equipe auxEquipe) {
		this.auxEquipe = auxEquipe;
	}

	public List<Usuario> getJuizes() {
		return juizes;
	}

	public void setJuizes(List<Usuario> juizes) {
		this.juizes = juizes;
	}

	public UsuarioService getUsuarioservice() {
		return usuarioservice;
	}

	public void setUsuarioservice(UsuarioService usuarioservice) {
		this.usuarioservice = usuarioservice;
	}
	
	
	
	
}
