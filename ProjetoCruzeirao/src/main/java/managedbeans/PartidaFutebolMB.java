package managedbeans;

import java.util.*;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import entidades.Cartao;
import entidades.Gol;
import entidades.Inscrito;
import entidades.PartidasFutebol;
import services.CartaoService;
import services.GolService;
import services.PartidaFutebolService;

@SessionScoped
@ManagedBean
public class PartidaFutebolMB {
	private PartidasFutebol partidafutebol = new PartidasFutebol();
	private PartidaFutebolService partidasfutebolservice = new PartidaFutebolService();
	private PartidasFutebol partidafutebolaux = new PartidasFutebol();
	private Gol gol = new Gol();
	private Cartao cartao = new Cartao();
	private ArrayList<Inscrito> jogadoresMandantes = new ArrayList<Inscrito>();
	private ArrayList<Inscrito> jogadoresVisitantes = new ArrayList<Inscrito>();
	private GolService golservice = new GolService();
	private CartaoService cartaoservice = new CartaoService();
	
	public void salvar() {
		partidasfutebolservice.salvar(partidafutebol);
		partidafutebol = new PartidasFutebol();
	}

	public void atualizar() {
		for (Inscrito jog : partidafutebolaux.getEquipeMandante().getInscritos()) {
			jogadoresMandantes.add(jog);
			
		}
		
		for (Inscrito jog : partidafutebolaux.getEquipeVisitante().getInscritos()) {
			jogadoresVisitantes.add(jog);
			
		}	
	}
	
	public void addGol() {
		if(partidafutebolaux.getEquipeMandante().getInscritos().contains(gol.getInscrito())) {
			partidafutebolaux.getGolsMandantes().add(gol);
		}
		
		if(partidafutebolaux.getEquipeVisitante().getInscritos().contains(gol.getInscrito())) {
			partidafutebolaux.getGolsVisitantes().add(gol);
		}
		golservice.salvar(gol);
	}
	
	public void addCartao() {
		if(partidafutebolaux.getEquipeMandante().getInscritos().contains(gol.getInscrito())) {
			partidafutebolaux.getCartoesMandantes().add(cartao);
		}
		
		if(partidafutebolaux.getEquipeVisitante().getInscritos().contains(gol.getInscrito())) {
			partidafutebolaux.getCartoesVisitantes().add(cartao);
		}
		cartaoservice.salvar(cartao);
	}
	
	public PartidasFutebol getPartidasfutebol() {
		return partidafutebol;
	}

	public void setPartidasfutebol(PartidasFutebol partidafutebol) {
		this.partidafutebol = partidafutebol;
	}
	
	public ArrayList<PartidasFutebol> getPartidasFutebol() {
		return partidasfutebolservice.getPartidasfutebol();
	}

	public PartidasFutebol getPartidafutebolaux() {
		return partidafutebolaux;
	}

	public void setPartidafutebolaux(PartidasFutebol partidafutebolaux) {
		this.partidafutebolaux = partidafutebolaux;
	}

	public Gol getGol() {
		return gol;
	}

	public void setGol(Gol gol) {
		this.gol = gol;
	}

	public Cartao getCartao() {
		return cartao;
	}

	public void setCartao(Cartao cartao) {
		this.cartao = cartao;
	}

	public ArrayList<Inscrito> getJogadoresMandantes() {
		return jogadoresMandantes;
	}

	public void setJogadoresMandantes(ArrayList<Inscrito> jogadoresMandantes) {
		this.jogadoresMandantes = jogadoresMandantes;
	}

	public ArrayList<Inscrito> getJogadoresVisitantes() {
		return jogadoresVisitantes;
	}

	public void setJogadoresVisitantes(ArrayList<Inscrito> jogadoresVisitantes) {
		this.jogadoresVisitantes = jogadoresVisitantes;
	}

	
}

