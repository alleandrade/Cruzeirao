//Import's
package entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

//Fim Import's
//Atributos
@Entity
public class Gol {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idGol;
	
	@ManyToOne
	private Inscrito inscrito;
	
	private int tempo;
	private boolean penalti;
//Fim Atributos
	/*	Métodos:
	 *  - Getter's 			[X]
	 *  - Setter's 			[X]
	 *  - ToString 			[X]
	 *  - Construtores		[X]
	*/
	
	public Gol() {
		super();
	}
	
	public Gol(Inscrito inscrito, int tempo, boolean penalti, int idGol) {
		super();
		this.inscrito = inscrito;
		this.tempo = tempo;
		this.penalti = penalti;
		this.idGol = idGol;
	}
	
	public Inscrito getInscrito() {
		return inscrito;
	}
	
	public void setInscrito(Inscrito inscrito) {
		this.inscrito = inscrito;
	}
	
	public int getTempo() {
		return tempo;
	}
	
	public void setTempo(int tempo) {
		this.tempo = tempo;
	}
	
	public boolean isPenalti() {
		return penalti;
	}
	
	public void setPenalti(boolean penalti) {
		this.penalti = penalti;
	}

	public int getIdGol() {
		return idGol;
	}

	public void setIdGol(int idGol) {
		this.idGol = idGol;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
//Fim Métodos
}
