//Import's
package entidades;

import enums.TipoJuiz;

//Fim Import's
//Atributos
public class Juiz {

	private TipoJuiz tipo;
	private Usuario usuario;
//Fim Atributos
	/*	Métodos:
	 *  - Getter's 			[X]
	 *  - Setter's 			[X]
	 *  - ToString 			[X]
	 *  - Construtores		[X]
	*/

	
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

	@Override
	public String toString() {
		return "Juiz [tipo=" + getTipo() + ", usuario=" + usuario + "]";
	}
//Fim Métodos
}
