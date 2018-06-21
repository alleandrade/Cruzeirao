package sistema.entidades;

import java.util.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Rodada {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idRodada;

	@ManyToOne
	private Grupo grupo;
	
	@OneToMany
	private ArrayList<Partida> partidas = new ArrayList<Partida>();

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
		this.idRodada = idRodada;
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
	
}
