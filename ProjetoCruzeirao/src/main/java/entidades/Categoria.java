//Import's
package entidades;

import java.util.*;
//Fim Import's
//Atributos
public class Categoria {
	String nome;
	int nascidosApartirDe,
		minJogadores,
		maxJogadores;
	ArrayList<Inscricao> inscricoes = new ArrayList<Inscricao>();
	Campeonato campeonato;
	ArrayList<Fase> fases = new ArrayList<Fase>();
	Enum sexo;
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
			ArrayList<Inscricao> inscricoes, Campeonato campeonato, ArrayList<Fase> fases, Enum sexo) {
		super();
		this.nome = nome;
		this.nascidosApartirDe = nascidosApartirDe;
		this.minJogadores = minJogadores;
		this.maxJogadores = maxJogadores;
		this.inscricoes = inscricoes;
		this.campeonato = campeonato;
		this.fases = fases;
		this.sexo = sexo;
	}

	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
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
	
	public Enum getSexo() {
		return sexo;
	}
	
	public void setSexo(Enum sexo) {
		this.sexo = sexo;
	}

	@Override
	public String toString() {
		return "Categoria [nome=" + nome + ", nascidosApartirDe=" + nascidosApartirDe + ", minJogadores=" + minJogadores
				+ ", maxJogadores=" + maxJogadores + ", campeonato=" + campeonato + ", sexo=" + sexo + "]";
	}	
//Fim Métodos
}
