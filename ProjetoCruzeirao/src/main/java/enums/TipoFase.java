package enums;

public enum TipoFase {
	FASES_INICIAIS("Fases Iniciais"),OITAVAS("Oitavas de Final"),QUARTAS("Quartas de Final"),SEMI("Semi Finais"),FINAL("Finais");
	
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
