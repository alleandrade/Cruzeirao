//Obs: Mudei o tipo da lista de usuarios para ArrayList pois o List não estava funcionando.
//Import's
package entidades;

import java.io.Serializable;
import java.util.*;
//Fim Import's
//Atributos
public class Equipe implements Serializable {
	
	String nome,
		   cidade;
	Date dataFundacao;
	ArrayList<Usuario> diretores = new ArrayList<Usuario>();
//Fim Atributos	
	/*	Métodos:
	 *  - Getter's 			[X]
	 *  - Setter's 			[X]
	 *  - ToString 			[X]
	 *  - Construtores		[X]
	*/

	public Equipe() {
		super();
	}

	public Equipe(String nome, String cidade, Date dataFundacao, ArrayList<Usuario> diretores) {
		super();
		this.nome = nome;
		this.cidade = cidade;
		this.dataFundacao = dataFundacao;
		this.diretores = diretores;
	}

	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getCidade() {
		return cidade;
	}
	
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	
	public Date getDataFundacao() {
		return dataFundacao;
	}
	
	public void setDataFundacao(Date dataFundacao) {
		this.dataFundacao = dataFundacao;
	}
	
	public ArrayList<Usuario> getDiretores() {
		return diretores;
	}
	
	public void setDiretores(ArrayList<Usuario> diretores) {
		this.diretores = diretores;
	}

	@Override
	public String toString() {
		return nome;
	}
//Fim Métodos
}
