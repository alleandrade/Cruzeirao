package managedbeans;

import java.util.*;


import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


import entidades.Equipe;
import entidades.Usuario;
import services.EquipeService;

@SessionScoped
@ManagedBean
public class EquipeMB {
	private Equipe equipe = new Equipe();
	private EquipeService equipeservice = new EquipeService();
	private Usuario auxDiretor;
	private Usuario auxJogador;
	private Usuario auxComissao;
	


	public void removerDiretor(Usuario diretor) {
		equipe.getDiretores().remove(diretor);
		diretor.getEquipes().remove(equipe);
	}
	
	public void removerJogador(Usuario jogador) {
		equipe.getJogadores().remove(jogador);
		jogador.getEquipes().remove(equipe);
	}
	
	public void removerMembroComissao(Usuario membroComissao) {
		equipe.getComissaoTecnica().remove(membroComissao);
		membroComissao.getEquipes().remove(equipe);
	}
		
	public void adicionarDiretor() {
		equipe.getDiretores().add(auxDiretor);
		auxDiretor.getEquipes().add(equipe);
	}
	
	public void adicionarJogador() {
		equipe.getJogadores().add(auxJogador);
		auxJogador.getEquipes().add(equipe);
	}	

	public void adicionarMembroComissao() {
		equipe.getComissaoTecnica().add(auxComissao);
		auxComissao.getEquipes().add(equipe);
	}

	public void salvar() {
		equipeservice.salvar(equipe);
		equipe = new Equipe();
	}
	
	public void remover(Equipe equipe) {
		equipeservice.remover(equipe);
	}

	public Equipe getEquipe() {
		return equipe;
	}

	public void setEquipe(Equipe equipe) {
		this.equipe = equipe;
	}
	
	public ArrayList<Equipe> getEquipes() {
		return equipeservice.getEquipes();
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

	public Usuario getAuxDiretor() {
		return auxDiretor;
	}

	public void setAuxDiretor(Usuario auxDiretor) {
		this.auxDiretor = auxDiretor;
	}
}
