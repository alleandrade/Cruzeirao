//Import's
package entidades;

import java.io.Serializable;
import java.util.*;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
//Fim Import's
//Atributos
@Entity
public class PartidasFutebol extends Partida implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@OneToMany
	private ArrayList<Gol> golsMandantes = new ArrayList<Gol>();
	
	@OneToMany
	private ArrayList<Gol> golsVisitantes = new ArrayList<Gol>();
	
	@OneToMany
	private ArrayList<Gol> golsPenaltisMandantes = new ArrayList<Gol>();
	
	@OneToMany
	private ArrayList<Gol> golsPenaltisVisitantes = new ArrayList<Gol>();
	
	@OneToMany
	private ArrayList<Cartao> cartoesMandantes = new ArrayList<Cartao>();
	
	@OneToMany
	private ArrayList<Cartao> cartoesVisitantes = new ArrayList<Cartao>();
//Fim Atributos
	/*	Métodos:
	 *  - Getter's 			[X]
	 *  - Setter's 			[X]
	 *  - ToString 			[X]
	 *  - Construtores		[X]
	*/
	
	public PartidasFutebol() {
		super();
	}
	
	public PartidasFutebol(int numero, Inscricao equipeMandante, Inscricao equipeVisitante, Date data, Local local,
		Partida proxPartida, ArrayList<Juiz> juizes, Grupo grupo, String relatoJuiz, ArrayList<Gol> golsMandantes,
		ArrayList<Gol> golsVisitantes, ArrayList<Gol> golsPenaltisMandantes, ArrayList<Gol> golsPenaltisVisitantes,
		ArrayList<Cartao> cartoesMandantes, ArrayList<Cartao> cartoesVisitantes) {
		super(numero, equipeMandante, equipeVisitante, data, local, proxPartida, juizes, grupo, relatoJuiz);
		this.golsMandantes = golsMandantes;
		this.golsVisitantes = golsVisitantes;
		this.golsPenaltisMandantes = golsPenaltisMandantes;
		this.golsPenaltisVisitantes = golsPenaltisVisitantes;
		this.cartoesMandantes = cartoesMandantes;
		this.cartoesVisitantes = cartoesVisitantes;
	}

	public ArrayList<Gol> getGolsMandantes() {
		return golsMandantes;
	}
	
	public void setGolsMandantes(ArrayList<Gol> golsMandantes) {
		this.golsMandantes = golsMandantes;
	}
	
	public ArrayList<Gol> getGolsVisitantes() {
		return golsVisitantes;
	}
	
	public void setGolsVisitantes(ArrayList<Gol> golsVisitantes) {
		this.golsVisitantes = golsVisitantes;
	}
	
	public ArrayList<Gol> getGolsPenaltisMandantes() {
		return golsPenaltisMandantes;
	}
	
	public void setGolsPenaltisMandantes(ArrayList<Gol> golsPenaltisMandantes) {
		this.golsPenaltisMandantes = golsPenaltisMandantes;
	}
	
	public ArrayList<Gol> getGolsPenaltisVisitantes() {
		return golsPenaltisVisitantes;
	}
	
	public void setGolsPenaltisVisitantes(ArrayList<Gol> golsPenaltisVisitantes) {
		this.golsPenaltisVisitantes = golsPenaltisVisitantes;
	}

	@Override
	public String toString() {
		return Integer.toString(this.getIdPartida());
	}

	public ArrayList<Cartao> getCartoesMandantes() {
		return cartoesMandantes;
	}

	public void setCartoesMandantes(ArrayList<Cartao> cartoesMandantes) {
		this.cartoesMandantes = cartoesMandantes;
	}

	public ArrayList<Cartao> getCartoesVisitantes() {
		return cartoesVisitantes;
	}

	public void setCartoesVisitantes(ArrayList<Cartao> cartoesVisitantes) {
		this.cartoesVisitantes = cartoesVisitantes;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
	//Fim Métodos	
}
