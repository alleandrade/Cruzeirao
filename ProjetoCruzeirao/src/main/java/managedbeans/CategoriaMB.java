package managedbeans;

import java.util.*;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import entidades.Categoria;
import services.CategoriaService;

@SessionScoped
@ManagedBean
public class CategoriaMB {
	private Categoria categoria = new Categoria();
	private CategoriaService categoriaservice = new CategoriaService();
	
	public void salvar() {
		categoriaservice.salvar(categoria);
		categoria = new Categoria();
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
