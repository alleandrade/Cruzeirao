package managedbeans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.*;
import services.UsuarioService;
import entidades.Usuario;

@SessionScoped
@ManagedBean
public class UsuarioMB {
	private Usuario usuario = new Usuario();
	private UsuarioService usuarioservice = new UsuarioService();
	private Usuario auxUsuario;
	
	
	public Usuario getAuxUsuario() {
		return auxUsuario;
	}

	public void setAuxUsuario(Usuario auxUsuario) {
		this.auxUsuario = auxUsuario;
	}

	public void adicionaEquipe() {
		
	}
	
	public void removeEquipe() {
		
	}
	
	public void salvar() {
		usuarioservice.salvar(usuario);
		usuario = new Usuario();
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
	
	
}
