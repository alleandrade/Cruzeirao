package dados;

import java.util.*;
import java.util.stream.Collectors;

import entidades.*;
import services.UsuarioService;

public class Dados {
	public static ArrayList<Campeonato> campeonatos = new ArrayList<Campeonato>();
	public static ArrayList<Cartao> cartoes = new ArrayList<Cartao>();
	public static ArrayList<Categoria> categorias = new ArrayList<Categoria>();
	public static ArrayList<Equipe> equipes = new ArrayList<Equipe>();
	public static ArrayList<Fase> fases = new ArrayList<Fase>();
	public static ArrayList<Gol> gols = new ArrayList<Gol>();
	public static ArrayList<Grupo> grupos = new ArrayList<Grupo>();
	public static ArrayList<Inscricao> inscricoes = new ArrayList<Inscricao>();
	public static ArrayList<Inscrito> inscritos = new ArrayList<Inscrito>();
	public static ArrayList<Juiz> juizes = new ArrayList<Juiz>();
	public static ArrayList<Local> locais = new ArrayList<Local>();
	public static ArrayList<Partida> partidas = new ArrayList<Partida>();
	public static ArrayList<PartidasFutebol> partidasfutebol = new ArrayList<PartidasFutebol>();
	public static ArrayList<Rodada> rodadas = new ArrayList<Rodada>();
	public static ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
	
	private static UsuarioService usuarioservice = new UsuarioService();
	// ArrayList's auxiliares de usuário
	
	public static ArrayList<Usuario> usuarioJuizes = usuarioservice.getUsuarios().stream().filter(n -> n.getTipo().getTipo().equals("Árbitro") || n.getTipo().getTipo().equals("Quarto árbitro") || n.getTipo().getTipo().equals("Auxiliar") ).collect(Collectors.toCollection(ArrayList::new));
	public static ArrayList<Usuario> usuarioDiretores = usuarioservice.getUsuarios().stream().filter(n -> n.getTipo().getTipo().equals("Diretor")).collect(Collectors.toCollection(ArrayList::new));
	public static ArrayList<Usuario> usuarioComissao = usuarioservice.getUsuarios().stream().filter(n -> n.getTipo().getTipo().equals("Preparador físico") || n.getTipo().getTipo().equals("Massagista") || n.getTipo().getTipo().equals("Técnico")).collect(Collectors.toCollection(ArrayList::new));
	public static ArrayList<Usuario> usuarioJogadores  = usuarioservice.getUsuarios().stream().filter(n -> n.getTipo().getTipo().equals("Jogador")).collect(Collectors.toCollection(ArrayList::new));
	
}
