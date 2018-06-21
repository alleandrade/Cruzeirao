package sistema.entidades;

import java.util.ArrayList;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Partida {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idPartida;

	@ManyToOne
	private Inscricao equipeMandante;
	
	@ManyToOne
	private Inscricao equipeVisitante;
	
	@Temporal(TemporalType.DATE)
	private Date data;
	
	private Local local;
	private Partida proxPartida;
	
	@OneToMany
	private ArrayList<Juiz> juizes = new ArrayList<Juiz>();
	
	@ManyToOne
	private Grupo grupo;
	private String relatoJuiz;
	
	public Partida(int idPartida, Inscricao equipeMandante, Inscricao equipeVisitante, Date data, Local local,
			Partida proxPartida, ArrayList<Juiz> juizes, Grupo grupo, String relatoJuiz) {
		super();
		this.idPartida = idPartida;
		this.equipeMandante = equipeMandante;
		this.equipeVisitante = equipeVisitante;
		this.data = data;
		this.local = local;
		this.proxPartida = proxPartida;
		this.juizes = juizes;
		this.grupo = grupo;
		this.relatoJuiz = relatoJuiz;
	}
	
	public Partida() {
	super();
	}

	
	
	public int getIdPartida() {
		return idPartida;
	}

	public void setIdPartida(int idPartida) {
		this.idPartida = idPartida;
	}

	public Inscricao getEquipeMandante() {
		return equipeMandante;
	}
	
	public void setEquipeMandante(Inscricao equipeMandante) {
		this.equipeMandante = equipeMandante;
	}
	
	public Inscricao getEquipeVisitante() {
		return equipeVisitante;
	}
	
	public void setEquipeVisitante(Inscricao equipeVisitante) {
		this.equipeVisitante = equipeVisitante;
	}
	
	public Date getData() {
		return data;
	}
	
	public void setData(Date data) {
		this.data = data;
	}
	
	public Local getLocal() {
		return local;
	}
	
	public void setLocal(Local local) {
		this.local = local;
	}
	
	public Partida getProxPartida() {
		return proxPartida;
	}
	
	public void setProxPartida(Partida proxPartida) {
		this.proxPartida = proxPartida;
	}
	
	public ArrayList<Juiz> getJuizes() {
		return juizes;
	}
	public void setJuizes(ArrayList<Juiz> juizes) {
		this.juizes = juizes;
	}
	
	public Grupo getGrupo() {
		return grupo;
	}
	
	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}
	
	public String getRelatoJuiz() {
		return relatoJuiz;
	}
	
	public void setRelatoJuiz(String relatoJuiz) {
		this.relatoJuiz = relatoJuiz;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return Integer.toString(idPartida);
	}	
	
	
}