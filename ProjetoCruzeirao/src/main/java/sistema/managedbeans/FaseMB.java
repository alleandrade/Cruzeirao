package sistema.managedbeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.RowEditEvent;

import sistema.entidades.Categoria;
import sistema.entidades.Fase;
import sistema.entidades.Grupo;
import sistema.entidades.Inscricao;
import sistema.entidades.Juiz;
import sistema.entidades.Partida;
import sistema.entidades.Rodada;
import sistema.services.CategoriaService;
import sistema.services.FaseService;
import sistema.services.GrupoService;
import sistema.services.PartidaService;
import sistema.services.RodadaService;

@ViewScoped
@ManagedBean
public class FaseMB implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Fase fase = new Fase();
	private FaseService faseservice = new FaseService();
	private Grupo auxGrupo;
	private Categoria auxCat = new Categoria();
	private List<Inscricao> equipes = new ArrayList<Inscricao>();
	private List<Inscricao> cabecasChave = new ArrayList<Inscricao>();
	private Inscricao cabecaChaveAux = new Inscricao();
	private Grupo grupoAux = new Grupo();
	private GrupoService gruposervice = new GrupoService();
	String[] auxString = {"A","B","C","D","E","F","G","H"};
	Inscricao[] cabecasChaveAux;
	private List<Grupo> grupos = new ArrayList<Grupo>();
	private Partida partida = new Partida();
	private PartidaService partidaservice = new PartidaService();
	private Rodada rodada = new Rodada();
	private RodadaService rodadaservice = new RodadaService();
	private Juiz auxJuiz = new Juiz();
	private List<Fase> fases;
	private CategoriaService categoriaservice = new CategoriaService();
	private List<Categoria> campeonatos = categoriaservice.getCategorias();
	
	public void onRowEdit(RowEditEvent event) {
		
		Fase f = ((Fase) event.getObject());
		faseservice.alterar(f);
	}
	
	public void salvar() {
		//fase.setIdFase(0);
		fase = faseservice.salvar(fase);
		
		if (fases != null) {
			fases.add(fase);			
			fase.getCategoria().getFases().add(fase);			
		}

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
		partida.getEquipeMandante().getPartidas().add(partida);
		partida.getEquipeVisitante().getPartidas().add(partida);
		partida.setIdPartida(0);
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
			if (!equipes.contains(equipe))					//Verifica��o adicionada
				equipes.add(equipe);
		}
	}
	
	public void addCabecaChave() {
		if (cabecasChave.size() < 8) {
			if (getCabecaChaveAux().isValidada() ) {		//Verifica��o adicionada
				cabecasChave.add(getCabecaChaveAux());
				equipes.remove(getCabecaChaveAux());
				setCabecaChaveAux(new Inscricao());
			}
		}
	}
	
	public void gerarGrupos( ) {
		for(int i = 0; i < 8; i++) {
			grupoAux.setNome(auxString[i]);
			grupoAux.setFase(fase);
			//grupoAux.setIdGrupo(i + 1);
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
				if (equipes.get(i).isValidada()) {
					grupo.getEquipes().add(equipes.get(i));
					equipes.remove(0);
				}
			}
		}
		
		auxCat.getFases().add(fase);
		fase.setIdFase(0);
		faseservice.salvar(fase);
	}
	
	public void remover(Fase fase) {
		
		if (fase.getCategoria() != null || faseservice.pesquisarGruposFase(fase).size() > 0) {
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "N�o � poss�vel remover a fase, pois h� categoria ou grupo (os) amarrados a ele.", null));
		}
		
		else {
			faseservice.remover(fase);
			fases.remove(fase);
		}
		
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
	
	public List<Fase> getFases() {
		if (fases == null)
			fases = faseservice.getFases();
	
		return fases;
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