package enums;

public enum TipoCartao {
	AMARELO("Amarelo"),VERMELHO("Vermelho");
	
	private String cartao;

	private TipoCartao(String cartao) {
		this.setCartao(cartao);
	}

	public String getCartao() {
		return cartao;
	}

	public void setCartao(String cartao) {
		this.cartao = cartao;
	}
}
