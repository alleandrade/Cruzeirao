package enums;

public enum TipoFase {
	FASES_INICIAIS("Fases iniciais"),OITAVAS("Oitavas de final"),QUARTAS("Quartas de final"),SEMI("Semifinais"),FINAL("Finais");
	
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
