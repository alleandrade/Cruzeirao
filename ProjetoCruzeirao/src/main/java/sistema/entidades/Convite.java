package sistema.entidades;


public class Convite {
	private Equipe equipe;
	private String texto,
				   email;
	private boolean aceito;
	
	public Equipe getEquipe() {
		return equipe;
	}
	
	public void setEquipe(Equipe equipe) {
		this.equipe = equipe;
	}
	
	public String getTexto() {
		return texto;
	}
	
	public void setTexto(String texto) {
		this.texto = texto;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public boolean isAceito() {
		return aceito;
	}
	
	public void setAceito(boolean aceito) {
		this.aceito = aceito;
	}
	
	
}
