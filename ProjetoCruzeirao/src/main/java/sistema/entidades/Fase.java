package sistema.entidades;

import java.io.Serializable;
import java.util.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import sistema.enums.TipoFase;

@Entity
public class Fase implements Serializable{
	
	private static final long serialVersionUID = 1L;
		
	@Temporal(TemporalType.DATE)
	private Date dataInicio;
	
	@Temporal(TemporalType.DATE)
	private Date dataFim;
	
	private TipoFase formato;
	
	@ManyToOne
	private Categoria categoria;
	
	@OneToMany(mappedBy="fase")
	private ArrayList<Grupo> grupos = new ArrayList<Grupo>();
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idFase;
	
	public Fase() {
		super();
	}

	public Fase(Date dataInicio, Date dataFim, TipoFase formato, Categoria categoria, ArrayList<Grupo> grupos, int idFase) {
		super();
		this.dataInicio = dataInicio;
		this.dataFim = dataFim;
		this.formato = formato;
		this.categoria = categoria;
		this.grupos = grupos;
		this.idFase = idFase;
	}

	public Date getDataInicio() {
		return dataInicio;
	}
	
	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}
	
	public TipoFase getFormato() {
		return formato;
	}

	public void setFormato(TipoFase formato) {
		this.formato = formato;
	}

	public Date getDataFim() {
		return dataFim;
	}
	
	public void setDataFim(Date dataFim) {
		this.dataFim = dataFim;
	}
	
	public Categoria getCategoria() {
		return categoria;
	}
	
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
	public ArrayList<Grupo> getGrupos() {
		return grupos;
	}
	
	public void setGrupos(ArrayList<Grupo> grupos) {
		this.grupos = grupos;
	}

	public int getIdFase() {
		return idFase;
	}

	public void setIdFase(int idFase) {
		this.idFase = idFase;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return Integer.toString((int)idFase);
	}

}
