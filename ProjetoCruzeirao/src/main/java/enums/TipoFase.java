package enums;

public enum TipoFase {
	PRIMEIRA_FASE("Primeira Fase"),SEGUNDA_FASE("Segunda Fase");
	
	private String tipo;

	private TipoFase(String tipo) {
		this.tipo = tipo;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
}
