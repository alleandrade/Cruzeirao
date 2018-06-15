package managedbeans;

import java.util.*;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.RowEditEvent;

import entidades.Cartao;
import entidades.Categoria;
import entidades.Fase;
import entidades.Inscricao;
import entidades.Inscrito;
import services.CategoriaService;
import services.InscricaoService;

@SessionScoped
@ManagedBean
public class CategoriaMB {
	private Categoria categoria = new Categoria();
	private CategoriaService categoriaservice = new CategoriaService();
	private Inscricao auxInscricao;
	private Fase auxFase;
	private List<Categoria> categorias;
	private Categoria auxCat;
	private List<Inscricao> inscricoes = new ArrayList<Inscricao>();
	private InscricaoService inscricaoservice = new InscricaoService();
	
	public void onRowEdit(RowEditEvent event) {

		Categoria u = ((Categoria) event.getObject());
		categoriaservice.alterar(u);
	}

	public void salvar() {
		//categoria.setIdCategoria(0);
			
		if (categoria.getMinJogadores() >= categoria.getMaxJogadores()) 
		{
			FacesMessage mensagem = new FacesMessage("O n�mero m�nimo de jogadores n�o pode ser maior ou igual ao n�mero m�ximo!");
			FacesContext.getCurrentInstance().addMessage(null, mensagem);	
		}
		
		else
		{
			categoriaservice.salvar(categoria);
			categoria.getCampeonato().getCategorias().add(categoria);
			FacesMessage mensagem = new FacesMessage("Categoria " + categoria.getNome() + " cadastrada com sucesso!");
			FacesContext.getCurrentInstance().addMessage(null, mensagem);	
			for (Inscricao aux : categoria.getInscricoes())		
				for(Inscrito aux2 : aux.getInscritos())
					aux2.getUsuario().getCampeonatos().add(categoria.getCampeonato());
			
		}

		categoria = new Categoria();
	}
	
	public void atualizarInscricoes() {
		for (Inscricao i : auxCat.getInscricoes()) {
			if (!i.isValidada())
				inscricoes.add(i);
		}
	}
	
	public void validarInscricao() {
		int count = 0;
		if ((auxInscricao.getInscritos().size() >= auxInscricao.getCategoria().getMinJogadores()) && (auxInscricao.getInscritos().size() <= auxInscricao.getCategoria().getMaxJogadores())) {			// Quantidade minima e maxima de jogadores
			for (Inscrito inscritosatual : auxInscricao.getInscritos()) {
				/*if (inscritosatual.getUsuario().getDataNascimento().getYear() < auxCat.getNascidosAPartirDe())
					count++;
				*/
				for (Inscricao i : auxCat.getInscricoes()) {
					for (Inscrito inscritos : i.getInscritos()) {
						if (inscritosatual.getUsuario() == inscritos.getUsuario())
							count++;
					}
				}
			}
			
			if (count == 0) {
				auxInscricao.setValidada(true);
				inscricoes.remove(auxInscricao);
				inscricaoservice.alterar(auxInscricao);
			}
		}
	}
	
	public void adicionarInscricao() {
		categoria.getInscricoes().add(auxInscricao);
	}
	
	public void adicionarFase() {
		categoria.getFases().add(auxFase);
	}
	
	public void removerFase(Fase fase) {
		categoria.getFases().remove(fase);
	}
	
	public void removerInscricao(Inscricao inscricao) {
		categoria.getInscricoes().remove(inscricao);
	}
		
	public Fase getAuxFase() {
		return auxFase;
	}

	public void setAuxFase(Fase auxFase) {
		this.auxFase = auxFase;
	}
	
	public Inscricao getAuxInscricao() {
		return auxInscricao;
	}

	public void setAuxInscricao(Inscricao auxInscricao) {
		this.auxInscricao = auxInscricao;
	}

	public void remover(Categoria categoria) {
		categoriaservice.remover(categoria);
		categoria.getCampeonato().getCategorias().remove(categoria);
		FacesMessage mensagem = new FacesMessage("Categoria " + categoria.getNome() + " removida com sucesso!");
		FacesContext.getCurrentInstance().addMessage(null, mensagem);
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
	public List<Categoria> getCategorias() {
		if (categorias == null)
			categorias = categoriaservice.getCategorias();
		
		return categorias;
	}

	public Categoria getAuxCat() {
		return auxCat;
	}

	public void setAuxCat(Categoria auxCat) {
		this.auxCat = auxCat;
	}

	public List<Inscricao> getInscricoes() {
		return inscricoes;
	}

	public void setInscricoes(List<Inscricao> inscricoes) {
		this.inscricoes = inscricoes;
	}
}
