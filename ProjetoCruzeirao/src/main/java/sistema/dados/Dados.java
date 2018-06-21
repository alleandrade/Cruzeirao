package sistema.dados;

import java.util.ArrayList;
import java.util.stream.Collectors;

import sistema.entidades.Campeonato;
import sistema.entidades.Cartao;
import sistema.entidades.Categoria;
import sistema.entidades.Equipe;
import sistema.entidades.Fase;
import sistema.entidades.Gol;
import sistema.entidades.Grupo;
import sistema.entidades.Inscricao;
import sistema.entidades.Inscrito;
import sistema.entidades.Juiz;
import sistema.entidades.Local;
import sistema.entidades.Partida;
import sistema.entidades.PartidasFutebol;
import sistema.entidades.Rodada;
import sistema.entidades.Usuario;
import sistema.managedbeans.UsuarioMB;
import sistema.services.EquipeService;
import sistema.services.UsuarioService;

public class Dados {
	private static EquipeService equipeservice = new EquipeService();
	public static ArrayList<Campeonato> campeonatos = new ArrayList<Campeonato>();
	public static ArrayList<Cartao> cartoes = new ArrayList<Cartao>();
	public static ArrayList<Categoria> categorias = new ArrayList<Categoria>();
	public static ArrayList<Equipe> equipes = equipeservice.getEquipes().stream().collect(Collectors.toCollection(ArrayList::new));
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
	public static UsuarioMB usuario = new UsuarioMB();
	
	public static ArrayList<Usuario> usuarioDiretores = usuarioservice.getUsuarios().stream().filter(n -> n.getTipo().getTipo().equals("Diretor")).collect(Collectors.toCollection(ArrayList::new));
	public static ArrayList<Usuario> usuarioJogadores = usuarioservice.getUsuarios().stream().filter(n -> n.getTipo().getTipo().equals("Jogador")).collect(Collectors.toCollection(ArrayList::new));
	public static ArrayList<Usuario> usuarioComissao = usuarioservice.getUsuarios().stream().filter(n -> n.getTipo().getTipo().equals("Preparador físico") || n.getTipo().getTipo().equals("Massagista") || n.getTipo().getTipo().equals("Técnico")).collect(Collectors.toCollection(ArrayList::new));
	public static ArrayList<Usuario> usuarioJuizes = usuarioservice.getUsuarios().stream().filter(n -> n.getTipo().getTipo().equals("Juiz")).collect(Collectors.toCollection(ArrayList::new));
	
}
