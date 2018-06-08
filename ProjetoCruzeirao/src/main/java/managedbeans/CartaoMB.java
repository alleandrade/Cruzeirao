package managedbeans;

import java.util.*;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.primefaces.event.RowEditEvent;

import entidades.Campeonato;
import entidades.Cartao;
import services.CartaoService;

@SessionScoped
@ManagedBean
public class CartaoMB {
	private Cartao cartao = new Cartao();
	private CartaoService cartaoservice = new CartaoService();

	public void onRowEdit(RowEditEvent event) {

		Cartao u = ((Cartao) event.getObject());
		cartaoservice.alterar(u);
	}
	
	public void salvar() {
		cartao.setIdCartao(0);
		cartaoservice.salvar(cartao);
		cartao = new Cartao();
	}

	public Cartao getCartao() {
		return cartao;
	}

	public void setCartao(Cartao cartao) {
		this.cartao = cartao;
	}
	
	public List<Cartao> getCartoes() {
		return cartaoservice.getCartoes();
	}
}
