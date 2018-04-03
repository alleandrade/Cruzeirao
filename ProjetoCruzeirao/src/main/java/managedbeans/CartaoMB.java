package managedbeans;

import java.util.*;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import entidades.Cartao;
import services.CartaoService;

@SessionScoped
@ManagedBean
public class CartaoMB {
	private Cartao cartao = new Cartao();
	private CartaoService cartaoservice = new CartaoService();
	
	public void salvar() {
		cartaoservice.salvar(cartao);
		cartao = new Cartao();
	}

	public Cartao getCartao() {
		return cartao;
	}

	public void setCartao(Cartao cartao) {
		this.cartao = cartao;
	}
	
	public ArrayList<Cartao> getCartoes() {
		return cartaoservice.getCartoes();
	}
}
