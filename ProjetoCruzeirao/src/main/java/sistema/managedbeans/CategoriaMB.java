package sistema.managedbeans;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.RowEditEvent;

import sistema.entidades.Categoria;
import sistema.entidades.Fase;
import sistema.entidades.Inscricao;
import sistema.entidades.Inscrito;
import sistema.services.CampeonatoService;
import sistema.services.CategoriaService;
import sistema.services.InscricaoService;

@ViewScoped
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
	private CampeonatoService campeonatoservice = new CampeonatoService();
	
	public void onRowEdit(RowEditEvent event) {

		Categoria c = ((Categoria) event.getObject());
		categoriaservice.alterar(c);
	}

	public void salvar() {
		
		int count = 0;		
		
		
		if (this.getCategorias() != null)
			for (Categoria c : this.getCategorias()) 
				if (c.getNome().equals(categoria.getNome()))
					count++;
			
		if (categoria.getMinJogadores() >= categoria.getMaxJogadores()) 
		{
			FacesMessage mensagem = new FacesMessage("O número mínimo de jogadores não pode ser maior ou igual ao número máximo!");
			FacesContext.getCurrentInstance().addMessage(null, mensagem);	
		}
		
		else if (count > 0) 
		{
			FacesMessage mensagem = new FacesMessage("Já existe uma categoria com esse nome!");
			FacesContext.getCurrentInstance().addMessage(null, mensagem);	
		}
		
		else
		{

			if (categoria.getCampeonato() != null) {
				categoria.getCampeonato().getCategorias().add(categoria);
				//campeonatoservice.alterar(categoria.getCampeonato());
			}
				
			
			categoria = categoriaservice.salvar(categoria);
			
			if (categorias != null) {
				categorias.add(categoria);
					
				
				FacesMessage mensagem = new FacesMessage("Categoria " + categoria.getNome() + " cadastrada com sucesso!");
				FacesContext.getCurrentInstance().addMessage(null, mensagem);	
				
				/*for (Inscricao aux : categoria.getInscricoes())		
					for (Inscrito aux2 : aux.getInscritos())
						aux2.getUsuario().getCampeonatos().add(categoria.getCampeonato());*/
				
			}
			
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
		
		if (categoria.getCampeonato() != null || categoriaservice.pesquisarFasesCategoria(categoria).size() > 0 || categoriaservice.pesquisarInscricoesCategoria(categoria).size() > 0) {
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Não é possível remover a categoria, pois há equipe (es), ou campeonato (os) ou inscrição (ões) amarradas a ele.", null));
		}
		
		else {
			categoriaservice.remover(categoria);
			categorias.remove(categoria);
			
			if (categoria.getCampeonato() != null)
				categoria.getCampeonato().getCategorias().remove(categoria);
			
			FacesMessage mensagem = new FacesMessage("Categoria " + categoria.getNome() + " removida com sucesso!");
			FacesContext.getCurrentInstance().addMessage(null, mensagem);
		}
		
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
