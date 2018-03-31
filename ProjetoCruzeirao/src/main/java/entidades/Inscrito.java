//Import's
package entidades;

import enums.TipoUsuario;

//Fim Import's
//Atributos
public class Inscrito {
	private TipoUsuario tipo;
	private Usuario usuario;
	private Inscricao inscricao;
	private boolean aceiteUsuario,
					suspensoJogos,
					inscricaoValidada;
//Fim Atributos	
	/*	Métodos:
	 *  - Getter's 			[X]
	 *  - Setter's 			[X]
	 *  - ToString 			[X]
	 *  - Construtores		[X]
	*/

	
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

	@Override
	public String toString() {
		return "Inscrito [tipo=" + getTipo() + ", usuario=" + usuario + ", inscricao=" + inscricao + ", aceiteUsuario="
				+ aceiteUsuario + ", suspensoJogos=" + suspensoJogos + ", inscricaoValidada=" + inscricaoValidada + "]";
	}
//Fim Métodos
}
