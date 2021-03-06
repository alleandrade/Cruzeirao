package sistema.entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import sistema.enums.Sexo;
import sistema.enums.TipoUsuario;

@Entity
@NamedQuery(name = "Usuario.pesquisarPorUserName", query = "select u from Usuario u where u.username = :username")
public class Usuario implements Serializable{

	private static final long serialVersionUID = 1L;

	public static final String PESQUISAR_POR_USERNAME = "Usuario.pesquisarPorUserName";
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idUsuario;

	private String email,
	  			   nome,
	  			   telefoneFixo,
	  			   telefoneMovel,
	  			   endereco,
	  			   rg,
	  			   cpf,
	  			   cref,
	  			   senha,
	  			   username,
	  			   password;
    	
	@Lob
	private byte [] foto;

	@OneToMany(mappedBy="usuario")
	private ArrayList<Inscrito> inscricoes = new ArrayList<	Inscrito>();
	
	@OneToMany
	private ArrayList<Campeonato> campeonatos = new ArrayList<Campeonato>();
	
	@Temporal(TemporalType.DATE)
	private Date dataNascimento;

	@ManyToMany
	private ArrayList<Equipe> equipes = new ArrayList<Equipe>();
	
	private TipoUsuario tipo;
	private Sexo sexo;
	
	
	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public Usuario() {
		super();
	}
	
	public Usuario(String email, String nome, String telefoneFixo, String telefoneMovel, String endereco, String rg,
		String cpf, String cref, byte [] foto, Date dataNascimento, ArrayList<Equipe> equipes, TipoUsuario tipo, Sexo sexo) {
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
	
	public ArrayList<Inscrito> getInscricoes() {
		return inscricoes;
	}

	public void setInscricoes(ArrayList<Inscrito> inscricoes) {
		this.inscricoes = inscricoes;
	}

	public ArrayList<Campeonato> getCampeonatos() {
		return campeonatos;
	}

	public void setCampeonatos(ArrayList<Campeonato> campeonatos) {
		this.campeonatos = campeonatos;
	}	
	
	public byte[] getFoto() {
		return foto;
	}

	public void setFoto(byte[] foto) {
		this.foto = foto;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return nome;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (idUsuario ^ (idUsuario >>> 32));
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		if (idUsuario != other.idUsuario)
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
}
