//Import's
package entidades;

import java.io.Serializable;
import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import enums.Sexo;
//Fim Import's
//Atributos

@Entity
public class Categoria implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idCategoria;
	
	private String nome;
	private int nascidosAPartirDe,
		minJogadores,
		maxJogadores;

	private static int count = 1; 
	
	@OneToMany(mappedBy="categoria")
	private ArrayList<Inscricao> inscricoes = new ArrayList<Inscricao>();
	
	@ManyToOne
	private Campeonato campeonato;	
	
	@OneToMany(mappedBy="categoria")
	private ArrayList<Fase> fases = new ArrayList<Fase>();
	
	private Sexo sexo;
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

	public Categoria(String nome, int nascidosAPartirDe, int minJogadores, int maxJogadores,
			ArrayList<Inscricao> inscricoes, Campeonato campeonato, ArrayList<Fase> fases, Sexo sexo) {
		super();
		this.nome = nome;
		this.nascidosAPartirDe = nascidosAPartirDe;
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
	

	
	public int getNascidosAPartirDe() {
		return nascidosAPartirDe;
	}

	public void setNascidosAPartirDe(int nascidosAPartirDe) {
		this.nascidosAPartirDe = nascidosAPartirDe;
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
	
	public Sexo getSexo() {
		return sexo;
	}

	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}

	public int getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(int idCategoria) {
		this.idCategoria = count;
		count++;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return nome;
	}	
//Fim Métodos
}
