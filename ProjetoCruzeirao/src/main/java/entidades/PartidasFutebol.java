//Import's
package entidades;

import java.io.Serializable;
import java.util.*;
//Fim Import's
//Atributos
public class PartidasFutebol extends Partida implements Serializable{
	private ArrayList<Gol> golsMandantes = new ArrayList<Gol>();
	private ArrayList<Gol> golsVisitantes = new ArrayList<Gol>();
	private ArrayList<Gol> golsPenaltisMandantes = new ArrayList<Gol>();
	private ArrayList<Gol> golsPenaltisVisitantes = new ArrayList<Gol>();
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
	
	public PartidasFutebol(ArrayList<Gol> golsMandantes, ArrayList<Gol> golsVisitantes,
			ArrayList<Gol> golsPenaltisMandantes, ArrayList<Gol> golsPenaltisVisitantes) {
		super();
		this.golsMandantes = golsMandantes;
		this.golsVisitantes = golsVisitantes;
		this.golsPenaltisMandantes = golsPenaltisMandantes;
		this.golsPenaltisVisitantes = golsPenaltisVisitantes;
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
		return Integer.toString(this.getNumero());
	}
	
	
//Fim Métodos	
}
