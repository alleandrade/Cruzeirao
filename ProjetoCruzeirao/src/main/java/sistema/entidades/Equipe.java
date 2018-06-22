package sistema.entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Equipe implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idEquipe;
	
	private String nome,
		   		   cidade;
	
	@Temporal(TemporalType.DATE)
	private Date dataFundacao;
	
	/*private ArrayList<Usuario> jogadores = new ArrayList<Usuario>();
	
	private ArrayList<Usuario> comissaoTecnica = new ArrayList<Usuario>();
	
	private ArrayList<Usuario> diretores = new ArrayList<Usuario>();*/
	
	@ManyToMany
	private ArrayList<Usuario> usuarios = new ArrayList<Usuario>();	

	public ArrayList<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(ArrayList<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public Equipe() {
		super();
	}

	public Equipe(String nome, String cidade, Date dataFundacao, ArrayList<Usuario> usuarios) {
		super();
		this.nome = nome;
		this.cidade = cidade;
		this.dataFundacao = dataFundacao;
		this.usuarios = usuarios;
		//this.diretores = diretores;
	}
	
	
/*
	public ArrayList<Usuario> getJogadores() {
		return jogadores;
	}
	public void setJogadores(ArrayList<Usuario> jogadores) {
		this.jogadores = jogadores;
	}
	public ArrayList<Usuario> getComissaoTecnica() {
		return comissaoTecnica;
	}
	public void setComissaoTecnica(ArrayList<Usuario> comissaoTecnica) {
		this.comissaoTecnica = comissaoTecnica;
	}*/

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
	
	/*
	public ArrayList<Usuario> getDiretores() {
		return diretores;
	}
	
	public void setDiretores(ArrayList<Usuario> diretores) {
		this.diretores = diretores;
	}*/
	
	public int getIdEquipe() {
		return idEquipe;
	}

	public void setIdEquipe(int idEquipe) {
		this.idEquipe = idEquipe;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return nome;
	}

}