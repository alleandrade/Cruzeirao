package managedbeans;

import java.util.*;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
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
	
	

	public void salvar() {
		categoria.setIdCategoria(0);
		categoriaservice.salvar(categoria);
		categoria.getCampeonato().getCategorias().add(categoria);
		
		for (Inscricao aux : categoria.getInscricoes())		
			for(Inscrito aux2 : aux.getInscritos())
				aux2.getUsuario().getCampeonatos().add(categoria.getCampeonato());

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
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
	public ArrayList<Categoria> getCategorias() {
		return categoriaservice.getCategorias();
	}
}
