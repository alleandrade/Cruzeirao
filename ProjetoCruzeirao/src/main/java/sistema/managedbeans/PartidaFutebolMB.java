package sistema.managedbeans;

import java.util.*;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import sistema.entidades.Cartao;
import sistema.entidades.Gol;
import sistema.entidades.Inscrito;
import sistema.entidades.PartidasFutebol;
import sistema.services.CartaoService;
import sistema.services.GolService;
import sistema.services.PartidaFutebolService;

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
		partidafutebol.setIdPartida(0);
		partidasfutebolservice.salvar(partidafutebol);
		partidafutebol = new PartidasFutebol();
	}

	public void atualizar() {
		for (Inscrito jog : partidafutebolaux.getEquipeMandante().getInscritos()) {
			if (jog.getTipo().getTipo().equals("Jogador"))
				jogadoresMandantes.add(jog);	
		}
		
		for (Inscrito jog : partidafutebolaux.getEquipeVisitante().getInscritos()) {
			if (jog.getTipo().getTipo().equals("Jogador"))
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
	
	public void finalizarPartida() {
		  
		if(partidafutebolaux.getGolsMandantes().size() > partidafutebolaux.getGolsVisitantes().size()) {
		   partidafutebolaux.getGrupo().getEquipes().add(partidafutebolaux.getEquipeMandante());   
		  }
		  
		  else if(partidafutebolaux.getGolsMandantes().size() < partidafutebolaux.getGolsVisitantes().size()) {
		   partidafutebolaux.getGrupo().getEquipes().add(partidafutebolaux.getEquipeVisitante());
		  }
		  
		  else {
		   if (partidafutebolaux.getGolsPenaltisMandantes().size() > partidafutebolaux.getGolsPenaltisVisitantes().size()) {
		    partidafutebolaux.getGrupo().getEquipes().add(partidafutebolaux.getEquipeMandante());
		   }
		   
		   else if(partidafutebolaux.getGolsPenaltisMandantes().size() < partidafutebolaux.getGolsPenaltisVisitantes().size()) {
		    partidafutebolaux.getGrupo().getEquipes().add(partidafutebolaux.getEquipeVisitante());
		   }
		   
		  }
		
		partidasfutebolservice.salvar(partidafutebolaux);
		partidafutebolaux = new PartidasFutebol();
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

