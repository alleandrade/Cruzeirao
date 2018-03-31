//Import's
package entidades;

import enums.TipoCartao;

//Fim Import's
//Atributos
public class Cartao {
	private Inscrito inscrito;
	private TipoCartao tipo;
	private int tempo;
//Fim Atributos
	/*	Métodos:
	 *  - Getter's 			[X]
	 *  - Setter's 			[X]
	 *  - ToString 			[X]
	 *  - Construtores		[X]
	*/
	
	public Cartao() {
		super();
	}
	
	public Cartao(Inscrito inscrito, TipoCartao tipo, int tempo) {
		super();
		this.inscrito = inscrito;
		this.tipo = tipo;
		this.tempo = tempo;
	}

	public Inscrito getInscrito() {
		return inscrito;
	}
	
	public void setInscrito(Inscrito inscrito) {
		this.inscrito = inscrito;
	}
	
	public TipoCartao getTipo() {
		return tipo;
	}

	public void setTipo(TipoCartao tipo) {
		this.tipo = tipo;
	}

	public int getTempo() {
		return tempo;
	}
	
	public void setTempo(int tempo) {
		this.tempo = tempo;
	}
//Fim Métodos
}