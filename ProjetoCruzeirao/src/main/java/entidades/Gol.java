//Import's
package entidades;
//Fim Import's
//Atributos
public class Gol {
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
	
	public Gol(Inscrito inscrito, int tempo, boolean penalti) {
		super();
		this.inscrito = inscrito;
		this.tempo = tempo;
		this.penalti = penalti;
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
//Fim Métodos
}
