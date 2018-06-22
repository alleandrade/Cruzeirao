package sistema.entidades;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import sistema.enums.TipoUsuario;

@Entity
public class Inscrito implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private TipoUsuario tipo;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idInscrito;

	@ManyToOne
	private Usuario usuario;
	
	@ManyToOne
	private Inscricao inscricao;
	private boolean aceiteUsuario,
					suspensoJogos,
					inscricaoValidada;
	
	public Inscrito() {
		super();
	}

	
	
	public Inscrito(TipoUsuario tipo, Usuario usuario, Inscricao inscricao, boolean aceiteUsuario, boolean suspensoJogos,
		boolean inscricaoValidada) {
		super();
		this.tipo = tipo;
		this.usuario = usuario;
		this.inscricao = inscricao;
		this.aceiteUsuario = aceiteUsuario;
		this.suspensoJogos = suspensoJogos;
		this.inscricaoValidada = inscricaoValidada;
	}



	public Usuario getUsuario() {
		return usuario;
	}
	
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public TipoUsuario getTipo() {
		return tipo;
	}

	public void setTipo(TipoUsuario tipo) {
		this.tipo = tipo;
	}

	public Inscricao getInscricao() {
		return inscricao;
	}
	
	public void setInscricao(Inscricao inscricao) {
		this.inscricao = inscricao;
	}
	
	public boolean isAceiteUsuario() {
		return aceiteUsuario;
	}
	
	public void setAceiteUsuario(boolean aceiteUsuario) {
		this.aceiteUsuario = aceiteUsuario;
	}
	
	public boolean isSuspensoJogos() {
		return suspensoJogos;
	}
	
	public void setSuspensoJogos(boolean suspensoJogos) {
		this.suspensoJogos = suspensoJogos;
	}
	
	public boolean isInscricaoValidada() {
		return inscricaoValidada;
	}
	
	public void setInscricaoValidada(boolean inscricaoValidada) {
		this.inscricaoValidada = inscricaoValidada;
	}

	public int getIdInscrito() {
		return idInscrito;
	}

	public void setIdInscrito(int idInscrito) {
		this.idInscrito = idInscrito;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	@Override
	public String toString() {
		return usuario.getNome();
	}

}