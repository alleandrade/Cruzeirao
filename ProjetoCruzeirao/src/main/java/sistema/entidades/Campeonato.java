package sistema.entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
public class Campeonato implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idCampeonato;
	
	private String nome;
	
	@OneToMany
	private ArrayList<Local> locais = new ArrayList<Local>();
	
	@OneToMany
	private ArrayList<Juiz> juizes = new ArrayList<Juiz>();
	
	@OneToMany(mappedBy="campeonato")
	private ArrayList<Categoria> categorias = new ArrayList<Categoria>();
	
	@Temporal(TemporalType.DATE)
	private Date dataInicioInscricao;
	
	@Temporal(TemporalType.DATE)
	private Date dataFimInscricao;
	
	@Temporal(TemporalType.DATE)
	private Date dataInicioCampeonato;
	
	@Temporal(TemporalType.DATE)
	private Date dataFimCampeonato;
	
	private double valorTaxa;

	
	public Campeonato() {
		super();
	}

	public Campeonato(String nome, ArrayList<Local> locais, ArrayList<Juiz> juizes, ArrayList<Categoria> categorias,
			Date dataInicioInscricao, Date dataFimInscricao, Date dataInicioCampeonato, Date dataFimCampeonato,
			double valorTaxa) {
		super();
		this.nome = nome;
		this.locais = locais;
		this.juizes = juizes;
		this.categorias = categorias;
		this.dataInicioInscricao = dataInicioInscricao;
		this.dataFimInscricao = dataFimInscricao;
		this.dataInicioCampeonato = dataInicioCampeonato;
		this.dataFimCampeonato = dataFimCampeonato;
		this.valorTaxa = valorTaxa;
	}

	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public ArrayList<Local> getLocais() {
		return locais;
	}
	
	public void setLocais(ArrayList<Local> locais) {
		this.locais = locais;
	}
	
	public ArrayList<Juiz> getJuizes() {
		return juizes;
	}
	
	public void setJuizes(ArrayList<Juiz> juizes) {
		this.juizes = juizes;
	}
	
	public ArrayList<Categoria> getCategorias() {
		return categorias;
	}
	
	public void setCategorias(ArrayList<Categoria> categorias) {
		this.categorias = categorias;
	}
	
	public Date getDataInicioInscricao() {
		return dataInicioInscricao;
	}
	
	public void setDataInicioInscricao(Date dataInicioInscricao) {
		this.dataInicioInscricao = dataInicioInscricao;
	}
	
	public Date getDataFimInscricao() {
		return dataFimInscricao;
	}
	
	public void setDataFimInscricao(Date dataFimInscricao) {
		this.dataFimInscricao = dataFimInscricao;
	}
	
	public Date getDataInicioCampeonato() {
		return dataInicioCampeonato;
	}

	public void setDataInicioCampeonato(Date dataInicioCampeonato) {
		this.dataInicioCampeonato = dataInicioCampeonato;
	}

	public Date getDataFimCampeonato() {
		return dataFimCampeonato;
	}
	
	public void setDataFimCampeonato(Date dataFimCampeonato) {
		this.dataFimCampeonato = dataFimCampeonato;
	}
	
	public double getValorTaxa() {
		return valorTaxa;
	}
	
	public void setValorTaxa(double valorTaxa) {
		this.valorTaxa = valorTaxa;
	}	

	public int getIdCampeonato() {
		return idCampeonato;
	}

	public void setIdCampeonato(int idCampeonato) {
		this.idCampeonato = idCampeonato;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return nome;
	}
	
}
