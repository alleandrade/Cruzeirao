//Obs: Mudei o tipo da lista de equipes para ArrayList pois o List n�o estava funcionando.
//Import's
package entidades;

import java.io.Serializable;
import java.util.*;
//Fim Import's
//Atributos
public class Usuario implements Serializable {
	String email,
		   nome,
		   telefoneFixo,
		   telefoneMovel,
		   endereco,
		   rg,
		   cpf,
		   cref,
		   foto;
	Date dataNascimento;
	ArrayList<Equipe> equipes = new ArrayList<Equipe>();
	Enum tipo,
		 sexo;		//Obs: Procurar o porque de usar um tipo Enum nesta variavel
//Fim Atributos
	/*	M�todos:
	 *  - Getter's 			[X]
	 *  - Setter's 			[X]
	 *  - ToString 			[X]
	 *  - Construtores		[X]
	*/
	
	
	public Usuario() {
		super();
	}

	public Usuario(String email, String nome, String telefoneFixo, String telefoneMovel, String endereco, String rg,
			String cpf, String cref, String foto, Date dataNascimento, ArrayList<Equipe> equipes, Enum tipo,
			Enum sexo) {
		super();
		this.email = email;
		this.nome = nome;
		this.telefoneFixo = telefoneFixo;
		this.telefoneMovel = telefoneMovel;
		this.endereco = endereco;
		this.rg = rg;
		this.cpf = cpf;
		this.cref = cref;
		this.foto = foto;
		this.dataNascimento = dataNascimento;
		this.equipes = equipes;
		this.tipo = tipo;
		this.sexo = sexo;
	}

	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getTelefoneFixo() {
		return telefoneFixo;
	}
	
	public void setTelefoneFixo(String telefoneFixo) {
		this.telefoneFixo = telefoneFixo;
	}
	
	public String getTelefoneMovel() {
		return telefoneMovel;
	}
	
	public void setTelefoneMovel(String telefoneMovel) {
		this.telefoneMovel = telefoneMovel;
	}
	
	public String getEndereco() {
		return endereco;
	}
	
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	public String getRg() {
		return rg;
	}
	
	public void setRg(String rg) {
		this.rg = rg;
	}
	
	public String getCpf() {
		return cpf;
	}
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public String getCref() {
		return cref;
	}
	
	public void setCref(String cref) {
		this.cref = cref;
	}
	
	public String getFoto() {
		return foto;
	}
	
	public void setFoto(String foto) {
		this.foto = foto;
	}
	
	public Date getDataNascimento() {
		return dataNascimento;
	}
	
	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
	public ArrayList<Equipe> getEquipes() {
		return equipes;
	}
	
	public void setEquipes(ArrayList<Equipe> equipes) {
		this.equipes = equipes;
	}
	
	public Enum getTipo() {
		return tipo;
	}
	
	public void setTipo(Enum tipo) {
		this.tipo = tipo;
	}
	
	public Enum getSexo() {
		return sexo;
	}
	
	public void setSexo(Enum sexo) {
		this.sexo = sexo;
	}

	@Override
	public String toString() {
		return nome;
	}
//Fim M�todos	
}
