//Import's
package entidades;

import java.util.*;
//Fim Import's
//Atributos
public class Rodada {
	private int numero;
	private Grupo grupo;
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

	public Rodada(int numero, Grupo grupo, ArrayList<Partida> partidas) {
	super();
	this.numero = numero;
	this.grupo = grupo;
	this.partidas = partidas;
	}

	public int getNumero() {
		return numero;
	}
	
	public void setNumero(int numero) {
		this.numero = numero;
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

	@Override
	public String toString() {
		return Integer.toString(numero);
	}
	
	
//Fim Métodos
}
