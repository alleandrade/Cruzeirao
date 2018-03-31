//Import's
package entidades;

import java.util.*;

import enums.TipoFase;
//Fim Import's
//Atributos
public class Fase {
	private Date dataInicio,
		 		 dataFim;
	private TipoFase formato;
	private Categoria categoria;
	private ArrayList<Grupo> grupos = new ArrayList<Grupo>();
	private int numero;
//Fim Atributos	
	/*	Métodos:
	 *  - Getter's 			[X]
	 *  - Setter's 			[X]
	 *  - ToString 			[X]
	 *  - Construtores		[X]
	*/

	
	public Fase() {
		super();
	}

	public Fase(Date dataInicio, Date dataFim, TipoFase formato, Categoria categoria, ArrayList<Grupo> grupos, int numero) {
		super();
		this.dataInicio = dataInicio;
		this.dataFim = dataFim;
		this.formato = formato;
		this.categoria = categoria;
		this.grupos = grupos;
		this.numero = numero;
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
	
	public int getNumero() {
		return numero;
	}
	
	public void setNumero(int numero) {
		this.numero = numero;
	}

	@Override
	public String toString() {
		return "Fase [dataInicio=" + dataInicio + ", dataFim=" + dataFim + ", formato=" + getFormato() + ", categoria="
				+ categoria + ", numero=" + numero + "]";
	}
//Fim Métodos
}
