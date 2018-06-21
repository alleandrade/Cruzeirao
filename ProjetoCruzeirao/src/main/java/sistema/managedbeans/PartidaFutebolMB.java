package sistema.managedbeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.event.RowEditEvent;

import sistema.entidades.Cartao;
import sistema.entidades.Gol;
import sistema.entidades.Inscrito;
import sistema.entidades.PartidasFutebol;
import sistema.services.CartaoService;
import sistema.services.GolService;
import sistema.services.PartidaFutebolService;

@ViewScoped
@ManagedBean
public class PartidaFutebolMB implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private PartidasFutebol partidaFutebol = new PartidasFutebol();
	private PartidaFutebolService partidasfutebolservice = new PartidaFutebolService();
	private PartidasFutebol partidaFutebolAux = new PartidasFutebol();
	private Gol gol = new Gol();
	private Cartao cartao = new Cartao();
	private ArrayList<Inscrito> jogadoresMandantes = new ArrayList<Inscrito>();
	private ArrayList<Inscrito> jogadoresVisitantes = new ArrayList<Inscrito>();
	private GolService golservice = new GolService();
	private CartaoService cartaoservice = new CartaoService();
	private List<PartidasFutebol> partidasfutebol;
	
	public void onRowEdit(RowEditEvent event) {

		PartidasFutebol p = ((PartidasFutebol) event.getObject());
		partidasfutebolservice.alterar(p);
	}
	
	public void salvar() {

		partidaFutebol = partidasfutebolservice.salvar(partidaFutebol);
		
		if (partidasfutebol != null)
			partidasfutebol.add(partidaFutebol);
		
		partidaFutebol = new PartidasFutebol();
	}

	public void atualizar() {
		for (Inscrito jog : partidaFutebolAux.getEquipeMandante().getInscritos()) {
			if (jog.getTipo().getTipo().equals("Jogador"))
				jogadoresMandantes.add(jog);	
		}
		
		for (Inscrito jog : partidaFutebolAux.getEquipeVisitante().getInscritos()) {
			if (jog.getTipo().getTipo().equals("Jogador"))
				jogadoresVisitantes.add(jog);
		}	
	}
	
	public void addGol() {
		if(partidaFutebolAux.getEquipeMandante().getInscritos().contains(gol.getInscrito())) {
			partidaFutebolAux.getGolsMandantes().add(gol);
		}
		
		if(partidaFutebolAux.getEquipeVisitante().getInscritos().contains(gol.getInscrito())) {
			partidaFutebolAux.getGolsVisitantes().add(gol);
		}
		
		golservice.salvar(gol);
	}
	
	public void addCartao() {
		if(partidaFutebolAux.getEquipeMandante().getInscritos().contains(gol.getInscrito())) {
			partidaFutebolAux.getCartoesMandantes().add(cartao);
		}
		
		if(partidaFutebolAux.getEquipeVisitante().getInscritos().contains(gol.getInscrito())) {
			partidaFutebolAux.getCartoesVisitantes().add(cartao);
		}
		
		cartaoservice.salvar(cartao);
	}
	
	public void finalizarPartida() {
		  
		if(partidaFutebolAux.getGolsMandantes().size() > partidaFutebolAux.getGolsVisitantes().size()) {
		   partidaFutebolAux.getGrupo().getEquipes().add(partidaFutebolAux.getEquipeMandante());   
		  }
		  
		  else if(partidaFutebolAux.getGolsMandantes().size() < partidaFutebolAux.getGolsVisitantes().size()) {
		   partidaFutebolAux.getGrupo().getEquipes().add(partidaFutebolAux.getEquipeVisitante());
		  }
		  
		  else {
		   if (partidaFutebolAux.getGolsPenaltisMandantes().size() > partidaFutebolAux.getGolsPenaltisVisitantes().size()) {
		    partidaFutebolAux.getGrupo().getEquipes().add(partidaFutebolAux.getEquipeMandante());
		   }
		   
		   else if(partidaFutebolAux.getGolsPenaltisMandantes().size() < partidaFutebolAux.getGolsPenaltisVisitantes().size()) {
		    partidaFutebolAux.getGrupo().getEquipes().add(partidaFutebolAux.getEquipeVisitante());
		   }
		   
		  }
		
		partidasfutebolservice.salvar(partidaFutebolAux);
		partidaFutebolAux = new PartidasFutebol();
	}
	
	public PartidasFutebol getPartidaFutebol() {
		return partidaFutebol;
	}

	public void setPartidasFutebol(PartidasFutebol partidafutebol) {
		this.partidaFutebol = partidafutebol;
	}
	
	public List<PartidasFutebol> getPartidasFutebol() {
		if (partidasfutebol == null)
			partidasfutebol = partidasfutebolservice.getPartidasfutebol();
		
		return partidasfutebol;
	}

	public PartidasFutebol getpartidaFutebolAux() {
		return partidaFutebolAux;
	}

	public void setpartidaFutebolAux(PartidasFutebol partidaFutebolAux) {
		this.partidaFutebolAux = partidaFutebolAux;
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

	public void setPartidaFutebol(PartidasFutebol partidaFutebol) {
		this.partidaFutebol = partidaFutebol;
	}
	
}

