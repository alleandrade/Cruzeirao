//Import's
package entidades;

import java.util.*;
//Fim Import's

//Atributos
public class Inscricao {
	long numero;
	boolean pagamento,
			validada;
	ArrayList<Inscrito> inscritos = new ArrayList<Inscrito>();
	ArrayList<Partida> partidas = new ArrayList<Partida>();
	Categoria categoria;
	Equipe equipe;
//Fim Atributos
	/*	M�todos:
	 *  - Getter's 			[X]
	 *  - Setter's 			[X]
	 *  - ToString 			[X]
	 *  - Construtores		[X]
	*/

	
	public Inscricao() {
		super();
	}

	public Inscricao(long numero, boolean pagamento, boolean validada, ArrayList<Inscrito> inscritos,
			ArrayList<Partida> partidas, Categoria categoria, Equipe equipe) {
		super();
		this.numero = numero;
		this.pagamento = pagamento;
		this.validada = validada;
		this.inscritos = inscritos;
		this.partidas = partidas;
		this.categoria = categoria;
		this.equipe = equipe;
	}

	public long getNumero() {
		return numero;
	}
	
	public void setNumero(long numero) {
		this.numero = numero;
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

	@Override
	public String toString() {
		return "Inscricao [numero=" + numero + ", pagamento=" + pagamento + ", validada=" + validada + ", inscritos="
				+ inscritos + ", categoria=" + categoria + ", equipe=" + equipe + "]";
	}
//Fim M�todos
}
