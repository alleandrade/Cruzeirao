package managedbeans;

import java.util.*;
import java.util.stream.Collectors;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.RowEditEvent;

import dados.Dados;
import entidades.Campeonato;
import entidades.Categoria;
import entidades.Equipe;
import entidades.Usuario;
import services.EquipeService;
import services.UsuarioService;

@SessionScoped
@ManagedBean
public class EquipeMB {
	private Equipe equipe = new Equipe();
	private EquipeService equipeservice = new EquipeService();
	private Usuario auxDiretor;
	private Usuario auxJogador;
	private Usuario auxComissao;
	private UsuarioService usuarioservice = new UsuarioService();
	private List<Equipe> equipes = Dados.equipes;
	private List<Usuario> auxDiretores = new ArrayList<Usuario>();
	private ArrayList<Usuario> jogadores = equipe.getUsuarios().stream().filter(p -> p.getTipo().getTipo().equals("Jogador")).collect(Collectors.toCollection(ArrayList::new));
	private ArrayList<Usuario> comissao = equipe.getUsuarios().stream().filter(p -> p.getTipo().getTipo().equals("Preparador físico") || p.getTipo().getTipo().equals("Massagista") || p.getTipo().getTipo().equals("Técnico")).collect(Collectors.toCollection(ArrayList::new));
	private ArrayList<Usuario> diretores = equipe.getUsuarios().stream().filter(p -> p.getTipo().getTipo().equals("Diretor")).collect(Collectors.toCollection(ArrayList::new));
	
	public void onRowEdit(RowEditEvent event) {

		Equipe u = ((Equipe) event.getObject());
		equipeservice.alterar(u);
	}
	
	public void Metodo() {
		jogadores = equipe.getUsuarios().stream().filter(p -> p.getTipo().getTipo().equals("Jogador")).collect(Collectors.toCollection(ArrayList::new));
		comissao = equipe.getUsuarios().stream().filter(p -> p.getTipo().getTipo().equals("Preparador físico") || p.getTipo().getTipo().equals("Massagista") || p.getTipo().getTipo().equals("Técnico")).collect(Collectors.toCollection(ArrayList::new));
		diretores = equipe.getUsuarios().stream().filter(p -> p.getTipo().getTipo().equals("Diretor")).collect(Collectors.toCollection(ArrayList::new));
	}

	public void removerDiretor(Usuario diretor) {
		equipe.getUsuarios().remove(diretor);
		diretor.getEquipes().remove(equipe);
		auxDiretores.remove(diretor);
	}
	
	public void removerJogador(Usuario jogador) {
		equipe.getUsuarios().remove(jogador);
		jogador.getEquipes().remove(equipe);
		equipeservice.alterar(equipe);
		usuarioservice.alterar(jogador);
	}
	
	public void removerMembroComissao(Usuario membroComissao) {
		equipe.getUsuarios().remove(membroComissao);
		membroComissao.getEquipes().remove(equipe);
		equipeservice.alterar(equipe);
		usuarioservice.alterar(membroComissao);
		
	}
		
	public void adicionarDiretor() {
		equipe.getUsuarios().add(auxDiretor);
		auxDiretor.getEquipes().add(equipe);
		auxDiretores.add(auxDiretor);
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
		//equipe.setIdEquipe(0);
		
		for (Equipe e : equipes) 
			if (e.getNome().equals(equipe.getNome()))
				count++;
		
		System.out.println(equipe.getNome());
		
		if (count > 0) 
		{
			FacesMessage mensagem = new FacesMessage("Já existe uma equipe com esse nome!");
			FacesContext.getCurrentInstance().addMessage(null, mensagem);		
		}
		
		else
		{
			equipeservice.salvar(equipe);
			FacesMessage mensagem = new FacesMessage("Equipe " + equipe.getNome() + " cadastrada com sucesso!");	
			FacesContext.getCurrentInstance().addMessage(null, mensagem);	
			
		}
		
		auxDiretores = new ArrayList<Usuario>();
		equipe = new Equipe();
	}
	
	public void remover(Equipe equipe) {
		equipeservice.remover(equipe);
		FacesMessage mensagem = new FacesMessage("Equipe " + equipe.getNome() + " removida com sucesso!");
		FacesContext.getCurrentInstance().addMessage(null, mensagem);
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
}
