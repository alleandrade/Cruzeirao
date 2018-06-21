package sistema.entidades;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import sistema.enums.TipoJuiz;


@Entity
public class Juiz implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idJuiz;

	private TipoJuiz tipo;
	
	@ManyToOne
	private Usuario usuario;
	
	public Juiz() {
		super();
	}

	public Juiz(TipoJuiz tipo, Usuario usuario) {
		super();
		this.tipo = tipo;
		this.usuario = usuario;
	}

	public Usuario getUsuario() {
		return usuario;
	}
	
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public TipoJuiz getTipo() {
		return tipo;
	}

	public void setTipo(TipoJuiz tipo) {
		this.tipo = tipo;
	}

	public int getIdJuiz() {
		return idJuiz;
	}

	public void setIdJuiz(int idJuiz) {
		this.idJuiz = idJuiz;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return usuario.getNome();
	}
	
}
