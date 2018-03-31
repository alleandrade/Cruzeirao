//Import's
package entidades;

import enums.*;
import java.util.*;
//Fim Import's
//Atributos
public class Categoria {
	private String nome;
	private int nascidosApartirDe,
				minJogadores,
				maxJogadores;
	private ArrayList<Inscricao> inscricoes = new ArrayList<Inscricao>();
	private Campeonato campeonato;
	private ArrayList<Fase> fases = new ArrayList<Fase>();
	private Sexo categoria;
//Fim Atributos
	/*	Métodos:
	 *  - Getter's 			[X]
	 *  - Setter's 			[X]
	 *  - ToString 			[X]
	 *  - Construtores		[X]
	*/

	
	public Categoria() {
		super();
	}
	
	public Categoria(String nome, int nascidosApartirDe, int minJogadores, int maxJogadores,
		ArrayList<Inscricao> inscricoes, Campeonato campeonato, ArrayList<Fase> fases, Sexo categoria) {
		super();
		this.nome = nome;
		this.nascidosApartirDe = nascidosApartirDe;
		this.minJogadores = minJogadores;
		this.maxJogadores = maxJogadores;
		this.inscricoes = inscricoes;
		this.campeonato = campeonato;
		this.fases = fases;
		this.categoria = categoria;
	}

	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public Sexo getCategoria() {
		return categoria;
	}

	public void setCategoria(Sexo categoria) {
		this.categoria = categoria;
	}

	public int getNascidosApartirDe() {
		return nascidosApartirDe;
	}
	
	public void setNascidosApartirDe(int nascidosApartirDe) {
		this.nascidosApartirDe = nascidosApartirDe;
	}
	
	public int getMinJogadores() {
		return minJogadores;
	}
	
	public void setMinJogadores(int minJogadores) {
		this.minJogadores = minJogadores;
	}
	
	public int getMaxJogadores() {
		return maxJogadores;
	}
	
	public void setMaxJogadores(int maxJogadores) {
		this.maxJogadores = maxJogadores;
	}
	
	public ArrayList<Inscricao> getInscricoes() {
		return inscricoes;
	}
	
	public void setInscricoes(ArrayList<Inscricao> inscricoes) {
		this.inscricoes = inscricoes;
	}
	
	public Campeonato getCampeonato() {
		return campeonato;
	}
	
	public void setCampeonato(Campeonato campeonato) {
		this.campeonato = campeonato;
	}
	
	public ArrayList<Fase> getFases() {
		return fases;
	}
	
	public void setFases(ArrayList<Fase> fases) {
		this.fases = fases;
	}

	@Override
	public String toString() {
		return "Categoria [nome=" + nome + ", nascidosApartirDe=" + nascidosApartirDe + ", minJogadores=" + minJogadores
				+ ", maxJogadores=" + maxJogadores + ", campeonato=" + campeonato + ", sexo=" + categoria + "]";
	}	
//Fim Métodos
}
