package services;

import java.util.*;

import dados.Dados;
import entidades.Usuario;

public class UsuarioService {
	private ArrayList<Usuario> usuarios = Dados.usuarios;
	
	public UsuarioService() {
		
	}
	
	public void salvar(Usuario usuario) {
		usuarios.add(usuario);
	}

	public ArrayList<Usuario> getUsuarios() {
		return usuarios;
	}
}
