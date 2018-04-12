package enums;

public enum TipoUsuario {
	ORGANIZADOR("Organizador"),JOGADOR("Jogador"),DIRETOR("Diretor"),
	PREPARADOR_FISICO("Preparador f�sico"),MASSAGISTA("Massagista"),
	TECNICO("T�cnico"),JUIZ("Juiz");
	
	private String tipo;
	private TipoUsuario(String tipo) {
		setTipo(tipo);
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
}
