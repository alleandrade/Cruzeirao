package services;

import java.util.*;

import dados.Dados;
import entidades.Usuario;

public class UsuarioService {
	private ArrayList<Usuario> usuarios = Dados.usuarios;
	private ArrayList<Usuario> diretores = Dados.usuarioDiretores;
	private ArrayList<Usuario> jogadores = Dados.usuarioJogadores;
	private ArrayList<Usuario> comissaoTecnica = Dados.usuarioComissao;
	private ArrayList<Usuario> juizes = Dados.usuarioJuizes;
	
	public ArrayList<Usuario> getDiretores() {
		return diretores;
	}

	public void setDiretores(ArrayList<Usuario> diretores) {
		this.diretores = diretores;
	}

	public UsuarioService() {
		
	}
	
	public void salvar(Usuario usuario) {
		if(usuario.getTipo().getTipo().equals("Diretor"))		
			diretores.add(usuario);
			
		if(usuario.getTipo().getTipo().equals("Jogador"))
			
			jogadores.add(usuario);
		
		if(usuario.getTipo().getTipo().equals("Juiz"))
			juizes.add(usuario);	
			
		if(usuario.getTipo().getTipo().equals("Preparador Fisico") || usuario.getTipo().getTipo().equals("Massagista") || usuario.getTipo().getTipo().equals("Tecnico"))
			comissaoTecnica.add(usuario);		

		usuarios.add(usuario);
	}
	
	public void remover(Usuario usuario) {
		usuarios.remove(usuario);
	}

	public ArrayList<Usuario> getUsuarios() {
		return usuarios;
	}
}
