package sistema.managedbeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.RowEditEvent;

import sistema.entidades.Equipe;
import sistema.entidades.Usuario;
import sistema.services.EquipeService;
import sistema.services.UsuarioService;

@ViewScoped
@ManagedBean
public class EquipeMB implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Equipe equipe = new Equipe();
	private EquipeService equipeservice = new EquipeService();
	private Usuario auxDiretor;
	private Usuario auxJogador;
	private Usuario auxComissao;
	private UsuarioService usuarioservice = new UsuarioService();
	private List<Equipe> equipes;
	private List<Usuario> usuariosDiretores;
	private List<Usuario> auxDiretores = new ArrayList<Usuario>();
	private ArrayList<Usuario> jogadores = equipe.getUsuarios().stream().filter(p -> p.getTipo().getTipo().equals("Jogador")).collect(Collectors.toCollection(ArrayList::new));
	private ArrayList<Usuario> comissao = equipe.getUsuarios().stream().filter(p -> p.getTipo().getTipo().equals("Preparador físico") || p.getTipo().getTipo().equals("Massagista") || p.getTipo().getTipo().equals("Técnico")).collect(Collectors.toCollection(ArrayList::new));
	private ArrayList<Usuario> diretores = equipe.getUsuarios().stream().filter(p -> p.getTipo().getTipo().equals("Diretor")).collect(Collectors.toCollection(ArrayList::new));
	
	public void onRowEdit(RowEditEvent event) {

		Equipe e = ((Equipe) event.getObject());
		equipeservice.alterar(e);
	}
	
	public void tiposUsuarios() {
		jogadores = equipe.getUsuarios().stream().filter(p -> p.getTipo().getTipo().equals("Jogador")).collect(Collectors.toCollection(ArrayList::new));
		comissao = equipe.getUsuarios().stream().filter(p -> p.getTipo().getTipo().equals("Preparador físico") || p.getTipo().getTipo().equals("Massagista") || p.getTipo().getTipo().equals("Técnico")).collect(Collectors.toCollection(ArrayList::new));
		diretores = equipe.getUsuarios().stream().filter(p -> p.getTipo().getTipo().equals("Diretor")).collect(Collectors.toCollection(ArrayList::new));
	}

	public void removerDiretor(Usuario diretor) {
		equipe.getUsuarios().remove(diretor);
		diretor.getEquipes().remove(equipe);
		auxDiretores.remove(diretor);
		//equipeservice.alterar(equipe);
		//usuarioservice.alterar(auxDiretor);
	}
	
	public void removerJogador(Usuario jogador) {
		equipe.getUsuarios().remove(jogador);
		jogador.getEquipes().remove(equipe);
		//equipeservice.alterar(equipe);
		//usuarioservice.alterar(jogador);
	}
	
	public void removerMembroComissao(Usuario membroComissao) {
		equipe.getUsuarios().remove(membroComissao);
		membroComissao.getEquipes().remove(equipe);
		equipeservice.alterar(equipe);
		usuarioservice.alterar(membroComissao);
		
	}
		
	public void adicionarDiretor() {
		
		int count = 0;
		
		if (equipe.getUsuarios() != null)
			for (Usuario u : equipe.getUsuarios())
				if (u.getIdUsuario() == auxDiretor.getIdUsuario())
					count ++;
		
		if (count == 0) {
			equipe.getUsuarios().add(auxDiretor);
			auxDiretor.getEquipes().add(equipe);
			auxDiretores.add(auxDiretor);
		}
	
		else {
			FacesMessage mensagem = new FacesMessage("Diretor " + auxDiretor.getNome() + " já foi adicionado!");
			FacesContext.getCurrentInstance().addMessage(null, mensagem);	
		}
	}
	
	public void adicionarJogador() {
			
		equipe.getUsuarios().add(auxJogador);
		auxJogador.getEquipes().add(equipe);
		equipeservice.alterar(equipe);
		usuarioservice.alterar(auxJogador);
	}	

	public void adicionarMembroComissao() {
		equipe.getUsuarios().add(auxComissao);
		auxComissao.getEquipes().add(equipe);
		equipeservice.alterar(equipe);
		usuarioservice.alterar(auxComissao);
	}

	public void salvar() {
		
		int count = 0;		
		
		if (this.getEquipes() != null)
			for (Equipe e : this.getEquipes()) 
				if (e.getNome().equals(equipe.getNome()))
					count++;
		
		if (count > 0) 
		{
			FacesMessage mensagem = new FacesMessage("Já existe uma equipe com esse nome!");
			FacesContext.getCurrentInstance().addMessage(null, mensagem);	
		}
		
		else
		{
			equipe = equipeservice.salvar(equipe);
			
			if (equipes != null) {
				equipes.add(equipe);
				FacesMessage mensagem = new FacesMessage("Equipe " + equipe.getNome() + " cadastrada com sucesso!");	
				FacesContext.getCurrentInstance().addMessage(null, mensagem);	
				
				//if (auxDiretores != null)
				//	for (Usuario u : auxDiretores)
					//	usuarioservice.alterar(u);
					
			}
			
		}
		
		auxDiretores = new ArrayList<Usuario>();
		equipe = new Equipe();
	}
	
	public void remover(Equipe equipe) {
		
		if (equipeservice.pesquisarUsuariosEquipe(equipe).size() > 0) {
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Não é possível remover a equipe, pois há usuários amarrados a ela.", null));
			}
		
		else {
			equipeservice.remover(equipe);
			equipes.remove(equipe);
			FacesMessage mensagem = new FacesMessage("Equipe " + equipe.getNome() + " removida com sucesso!");
			FacesContext.getCurrentInstance().addMessage(null, mensagem);
		}
	}

	public Equipe getEquipe() {
		return equipe;
	}

	public void setEquipe(Equipe equipe) {
		this.equipe = equipe;
	}	
	
	public List<Usuario> getAuxDiretores() {
		return auxDiretores;
	}

	public void setAuxDiretores(List<Usuario> auxDiretores) {
		this.auxDiretores = auxDiretores;
	}

	public ArrayList<Usuario> getDiretores() {
		return diretores;
	}

	public void setDiretores(ArrayList<Usuario> diretores) {
		this.diretores = diretores;
	}

	public List<Equipe> getEquipes() {
		if (equipes == null)
			equipes = equipeservice.getEquipes();
	
		return equipes;
	}
	
	public Usuario getAuxJogador() {
		return auxJogador;
	}

	public void setAuxJogador(Usuario auxJogador) {
		this.auxJogador = auxJogador;
	}

	public Usuario getAuxComissao() {
		return auxComissao;
	}

	public void setAuxComissao(Usuario auxComissao) {
		this.auxComissao = auxComissao;
	}	
	
	public ArrayList<Usuario> getJogadores() {
		return jogadores;
	}

	public void setJogadores(ArrayList<Usuario> jogadores) {
		this.jogadores = jogadores;
	}

	public ArrayList<Usuario> getComissao() {
		return comissao;
	}

	public void setComissao(ArrayList<Usuario> comissao) {
		this.comissao = comissao;
	}

	public Usuario getAuxDiretor() {
		return auxDiretor;
	}

	public void setAuxDiretor(Usuario auxDiretor) {
		this.auxDiretor = auxDiretor;
	}
	
	public List<Usuario> getUsuariosDiretores() {
		
		if (usuariosDiretores == null)
			usuariosDiretores = usuarioservice.getUsuarios().stream().filter(p -> p.getTipo().getTipo().equals("Diretor")).collect(Collectors.toList());
		
		return usuariosDiretores;
	}
}
