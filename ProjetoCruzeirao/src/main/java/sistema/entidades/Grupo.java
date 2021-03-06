package sistema.entidades;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Grupo implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String nome;
	
	@ManyToOne
	private Fase fase;
	
	@OneToMany(mappedBy="grupo")
	private ArrayList<Rodada> rodadas = new ArrayList<Rodada>();
	
	private List<Inscricao> equipes = new ArrayList<Inscricao>();
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idGrupo;

	public Grupo() {
		super();
	}

	public Grupo(String nome, Fase fase, ArrayList<Rodada> rodadas, int idGrupo) {
		super();
		this.nome = nome;
		this.fase = fase;
		this.rodadas = rodadas;
		this.idGrupo = idGrupo;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public Fase getFase() {
		return fase;
	}
	
	public void setFase(Fase fase) {
		this.fase = fase;
	}
	
	public ArrayList<Rodada> getRodadas() {
		return rodadas;
	}
	
	public void setRodadas(ArrayList<Rodada> rodadas) {
		this.rodadas = rodadas;
	}
	
	public int getIdGrupo() {
		return idGrupo;
	}

	public void setIdGrupo(int idGrupo) {
		this.idGrupo = idGrupo;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public List<Inscricao> getEquipes() {
		return equipes;
	}

	public void setEquipes(List<Inscricao> equipes) {
		this.equipes = equipes;
	}

	@Override
	public String toString() {
		return nome;
	}
	
}