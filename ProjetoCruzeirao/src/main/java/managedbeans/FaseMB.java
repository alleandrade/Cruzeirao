package managedbeans;

import java.util.*;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import dados.Dados;
import entidades.Categoria;
import entidades.Equipe;
import entidades.Fase;
import entidades.Grupo;
import entidades.Inscricao;
import entidades.Juiz;
import entidades.Partida;
import entidades.Rodada;
import services.FaseService;
import services.GrupoService;
import services.PartidaService;
import services.RodadaService;

@SessionScoped
@ManagedBean
public class FaseMB {
	private Fase fase = new Fase();
	private FaseService faseservice = new FaseService();
	private Grupo auxGrupo;
	private Categoria auxCat = new Categoria();
	private List<Inscricao> equipes = new ArrayList<Inscricao>();
	private List<Inscricao> cabecasChave = new ArrayList<Inscricao>();
	private Inscricao cabecaChaveAux = new Inscricao();
	private Grupo grupoAux = new Grupo();
	private GrupoService gruposervice = new GrupoService();
	private List<Categoria> campeonatos = Dados.categorias;
	String[] auxString = {"A","B","C","D","E","F","G","H"};
	Inscricao[] cabecasChaveAux;
	private List<Grupo> grupos = new ArrayList<Grupo>();
	private Partida partida = new Partida();
	private PartidaService partidaservice = new PartidaService();
	private Rodada rodada = new Rodada();
	private RodadaService rodadaservice = new RodadaService();
	private Juiz auxJuiz = new Juiz();
	
	public void salvar() {
		faseservice.salvar(fase);
		fase = new Fase();
	}
	
	public void salvarRodada() {
		rodada.getGrupo().getRodadas().add(rodada);
		rodadaservice.salvar(rodada);
	}
	
	public void atualizarGrupos() {
		for (Fase fase : auxCat.getFases()) {
			for (Grupo grupo : fase.getGrupos()) {
				grupos.add(grupo);
			}
		}
	}
	
	public void addJuiz() {
		partida.getJuizes().add(auxJuiz);
		auxJuiz = new Juiz();
	}
//	public void atualizarEquipes() {
//		equipes = new ArrayList<Inscricao>();
//		for (Inscricao equipe : auxGrupo.getEquipes()) {
//			equipes.add(equipe);
//		}
//	}
	
	public void salvarPartida() {
		partida.getGrupo().getEquipes().remove(partida.getEquipeMandante());
		partida.getGrupo().getEquipes().remove(partida.getEquipeVisitante());
		rodada.getPartidas().add(partida);
		partidaservice.salvar(partida);
		partida = new Partida();
	}
	
	public void limpar() {
		auxCat = new Categoria();
		grupos = new ArrayList<Grupo>();
		auxGrupo = new Grupo();
		partida = new Partida();
		auxJuiz = new Juiz();
		
	}
	
	public void atualizarCamp() {
		for (Inscricao equipe : getAuxCat().getInscricoes()) {
			equipes.add(equipe);
		}
	}
	
	public void addCabecaChave() {
		if (cabecasChave.size() < 8) {
			cabecasChave.add(getCabecaChaveAux());
			equipes.remove(getCabecaChaveAux());
			setCabecaChaveAux(new Inscricao());
		}
	}
	
	public void gerarGrupos( ) {
		for(int i = 0; i < 8; i++) {
			grupoAux.setNome(auxString[i]);
			grupoAux.setFase(fase);
			grupoAux.setNumero(i + 1);
			fase.getGrupos().add(grupoAux);
			gruposervice.salvar(grupoAux);
			grupoAux = new Grupo();
		}
		
		int i = 0;
		for (Grupo grupo : fase.getGrupos()) {
			grupo.getEquipes().add(cabecasChave.get(i));
			i++;
		}
		
		while (equipes.size() > 0) {
			i = 0;
			for (Grupo grupo : fase.getGrupos()) {
				grupo.getEquipes().add(equipes.get(i));
				equipes.remove(0);
			}
		}
		
		faseservice.salvar(fase);
	}
	
	public void remover(Fase fase) {
		faseservice.remover(fase);
	}
	
	public void adicionarGrupo() {
		fase.getGrupos().add(auxGrupo);
	}
	
	public void removerGrupo(Grupo grupo) {
		fase.getGrupos().remove(grupo);
	}

	public Grupo getAuxGrupo() {
		return auxGrupo;
	}

	public void setAuxGrupo(Grupo auxGrupo) {
		this.auxGrupo = auxGrupo;
	}

	public Fase getFase() {
		return fase;
	}

	public void setFase(Fase fase) {
		this.fase = fase;
	}
	
	public ArrayList<Fase> getFases() {
		return faseservice.getFases();
	}

	public List<Inscricao> getEquipes() {
		return equipes;
	}

	public void setEquipes(List<Inscricao> equipes) {
		this.equipes = equipes;
	}

	public Categoria getAuxCat() {
		return auxCat;
	}

	public void setAuxCat(Categoria auxCat) {
		this.auxCat = auxCat;
	}

	public List<Inscricao> getCabecasChave() {
		return cabecasChave;
	}

	public void setCabecasChave(List<Inscricao> cabecasChave) {
		this.cabecasChave = cabecasChave;
	}

	public List<Categoria> getCampeonatos() {
		return campeonatos;
	}

	public void setCampeonatos(List<Categoria> campeonatos) {
		this.campeonatos = campeonatos;
	}

	public Inscricao getCabecaChaveAux() {
		return cabecaChaveAux;
	}

	public void setCabecaChaveAux(Inscricao cabecaChaveAux) {
		this.cabecaChaveAux = cabecaChaveAux;
	}

	public List<Grupo> getGrupos() {
		return grupos;
	}

	public void setGrupos(List<Grupo> grupos) {
		this.grupos = grupos;
	}

	public Partida getPartida() {
		return partida;
	}

	public void setPartida(Partida partida) {
		this.partida = partida;
	}

	public Rodada getRodada() {
		return rodada;
	}

	public void setRodada(Rodada rodada) {
		this.rodada = rodada;
	}

	public Juiz getAuxJuiz() {
		return auxJuiz;
	}

	public void setAuxJuiz(Juiz auxJuiz) {
		this.auxJuiz = auxJuiz;
	}
}
