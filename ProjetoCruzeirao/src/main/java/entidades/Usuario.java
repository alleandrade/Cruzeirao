//Import's
package entidades;

import enums.*;

import java.util.*;
//Fim Import's
//Atributos


public class Usuario {

	private String email,
		   		   nome,
		   		   telefoneFixo,
		   		   telefoneMovel,
		   		   endereco,
		   		   rg,
		   		   cpf,
		   		   cref,
		   		   foto;
	private Date dataNascimento;
	private ArrayList<Equipe> equipes = new ArrayList<Equipe>();
	private TipoUsuario tipo;
	private Sexo sexo;
	
//Fim Atributos
	/*	Métodos:
	 *  - Getter's 			[X]
	 *  - Setter's 			[X]
	 *  - ToString 			[X]
	 *  - Construtores		[X]
	*/
	
	
	public Usuario() {
		super();
	}
	
	public Usuario(String email, String nome, String telefoneFixo, String telefoneMovel, String endereco, String rg,
		String cpf, String cref, String foto, Date dataNascimento, ArrayList<Equipe> equipes, TipoUsuario tipo, Sexo sexo) {
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
	
	public TipoUsuario getTipo() {
		return tipo;
	}

	public void setTipo(TipoUsuario tipo) {
		this.tipo = tipo;
	}

	public Sexo getSexo() {
		return sexo;
	}

	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
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

	@Override
	public String toString() {
		return "Usuario [email=" + email + ", nome=" + nome + ", telefoneFixo=" + telefoneFixo + ", telefoneMovel="
				+ telefoneMovel + ", endereco=" + endereco + ", rg=" + rg + ", cpf=" + cpf + ", cref=" + cref
				+ ", foto=" + foto + ", dataNascimento=" + dataNascimento + ", equipes=" + equipes + ", tipo=" + getTipo()
				+ ", sexo=" + getSexo() + "]";
	}
//Fim Métodos	

}
