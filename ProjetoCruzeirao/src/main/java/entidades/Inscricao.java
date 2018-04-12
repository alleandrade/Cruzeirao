//Import's
package entidades;

import java.io.Serializable;
import java.util.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
//Fim Import's

//Atributos
@Entity
public class Inscricao implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long idInscricao;	

	private static int count = 1; 
	private boolean pagamento;
	private boolean validada;
	
	@OneToMany(mappedBy="inscricao")
	private ArrayList<Inscrito> inscritos = new ArrayList<Inscrito>();
	
	@OneToMany
	private ArrayList<Partida> partidas = new ArrayList<Partida>();
	
	@ManyToOne
	private Categoria categoria;
	
	@ManyToOne
	private Equipe equipe;
//Fim Atributos
	/*	Métodos:
	 *  - Getter's 			[X]
	 *  - Setter's 			[X]
	 *  - ToString 			[X]
	 *  - Construtores		[X]
	*/

	
	public Inscricao() {
		super();
	}

	public Inscricao(long idInscricao, boolean pagamento, boolean validada, ArrayList<Inscrito> inscritos,
			ArrayList<Partida> partidas, Categoria categoria, Equipe equipe) {
		super();
		this.idInscricao = idInscricao;
		this.pagamento = pagamento;
		this.validada = validada;
		this.inscritos = inscritos;
		this.partidas = partidas;
		this.categoria = categoria;
		this.equipe = equipe;
	}

	public long getIdInscricao() {
		return idInscricao;
	}

	public void setIdInscricao(long idInscricao) {
		this.idInscricao = count;
		count++;
	}
	
	public boolean isPagamento() {
		return pagamento;
	}
	
	public void setPagamento(boolean pagamento) {
		this.pagamento = pagamento;
	}
	
	public boolean isValidada() {
		return validada;
	}
	
	public void setValidada(boolean validada) {
		this.validada = validada;
	}
	
	public ArrayList<Inscrito> getInscritos() {
		return inscritos;
	}
	
	public void setInscritos(ArrayList<Inscrito> inscritos) {
		this.inscritos = inscritos;
	}
	
	public ArrayList<Partida> getPartidas() {
		return partidas;
	}
	
	public void setPartidas(ArrayList<Partida> partidas) {
		this.partidas = partidas;
	}
	
	public Categoria getCategoria() {
		return categoria;
	}
	
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
	public Equipe getEquipe() {
		return equipe;
	}
	
	public void setEquipe(Equipe equipe) {
		this.equipe = equipe;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return Integer.toString((int)idInscricao);
	}
//Fim Métodos
}
