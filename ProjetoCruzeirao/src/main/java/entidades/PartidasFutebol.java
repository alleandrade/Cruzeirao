//Import's
package entidades;

import java.util.*;
//Fim Import's
//Atributos
public class PartidasFutebol extends Partida{
	private ArrayList<Gol> golsMandantes = new ArrayList<Gol>();
	private ArrayList<Gol> golsVisitantes = new ArrayList<Gol>();
	private ArrayList<Gol> golsPenaltisMandantes = new ArrayList<Gol>();
	private ArrayList<Gol> golsPenaltisVisitantes = new ArrayList<Gol>();
	private ArrayList<Cartao> cartoesMandantes = new ArrayList<Cartao>();
	private ArrayList<Cartao> cartoesVisitantes = new ArrayList<Cartao>();
//Fim Atributos
	/*	M�todos:
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
//Fim M�todos	



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
}
