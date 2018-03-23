package services;

import java.util.*;
import entidades.Usuario;

public class UsuarioService {
	private ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
	
	public UsuarioService() {
		
	}
	
	public void salvar(Usuario usuario) {
		usuarios.add(usuario);
	}

	public ArrayList<Usuario> getUsuarios() {
		return usuarios;
	}
}
