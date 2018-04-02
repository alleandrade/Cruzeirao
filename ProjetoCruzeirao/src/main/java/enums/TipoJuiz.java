package enums;

public enum TipoJuiz {
	ARBITRO("�rbitro"),QUARTO_ARBITRO("Quarto �rbitro"),AUXILIAR("Auxiliar");
	
	private String juiz;

	private TipoJuiz(String juiz) {
		this.setJuiz(juiz);
	}

	public String getJuiz() {
		return juiz;
	}

	public void setJuiz(String juiz) {
		this.juiz = juiz;
	}
}
