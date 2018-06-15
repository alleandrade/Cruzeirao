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

@SessionScoped
@ManagedBean
public class CategoriaMB {
	private Categoria categoria = new Categoria();
	private CategoriaService categoriaservice = new CategoriaService();
	private Inscricao auxInscricao;
	private Fase auxFase;
	private List<Categoria> categorias;
	
	public void onRowEdit(RowEditEvent event) {

		Categoria u = ((Categoria) event.getObject());
		categoriaservice.alterar(u);
	}

	public void salvar() {
		//categoria.setIdCategoria(0);
			
		if (categoria.getMinJogadores() >= categoria.getMaxJogadores()) 
		{
			FacesMessage mensagem = new FacesMessage("O número mínimo de jogadores não pode ser maior ou igual ao número máximo!");
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
}
