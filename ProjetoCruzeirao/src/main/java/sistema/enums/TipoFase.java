package sistema.enums;

public enum TipoFase {
	 PRIMEIRA_FASE("Primeira fase"),SEGUNDA_FASE("Segunda fase");
	
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
