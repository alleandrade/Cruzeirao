//Import's
package entidades;

import java.util.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
//Fim Import's
//Atributos
@Entity
public class Rodada {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idRodada;

	private static int count = 1; 
	@ManyToOne
	private Grupo grupo;
	
	@OneToMany
	private ArrayList<Partida> partidas = new ArrayList<Partida>();
//Fim Atributos
	/*	Métodos:
	 *  - Getter's 			[X]
	 *  - Setter's 			[X]
	 *  - ToString 			[X]
	 *  - Construtores		[X]
	*/
	
	public Rodada() {
	super();
	}

	public Rodada(int idRodada, Grupo grupo, ArrayList<Partida> partidas) {
	super();
	this.idRodada = idRodada;
	this.grupo = grupo;
	this.partidas = partidas;
	}
	
	public int getIdRodada() {
		return idRodada;
	}

	public void setIdRodada(int idRodada) {
		this.idRodada = count;
		count++;
	}

	public Grupo getGrupo() {
		return grupo;
	}
	
	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}
	
	public ArrayList<Partida> getPartidas() {
		return partidas;
	}
	
	public void setPartidas(ArrayList<Partida> partidas) {
		this.partidas = partidas;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return Integer.toString(idRodada);
	}
	
	
//Fim Métodos
}
