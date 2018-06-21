package sistema.managedbeans;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.event.RowEditEvent;

import sistema.entidades.Cartao;
import sistema.services.CartaoService;

@ViewScoped
@ManagedBean
public class CartaoMB implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Cartao cartao = new Cartao();
	private CartaoService cartaoservice = new CartaoService();
	private List<Cartao> cartoes;

	public void onRowEdit(RowEditEvent event) {

		Cartao c = ((Cartao) event.getObject());
		cartaoservice.alterar(c);
	}
	
	public void salvar() {
		cartao = cartaoservice.salvar(cartao);
		
		if (cartoes != null)
			cartoes.add(cartao);
		
		cartao = new Cartao();
	}
	
	public void remover(Cartao cartao) {
		cartaoservice.remover(cartao);
		cartoes.remove(cartao);

	}

	public Cartao getCartao() {
		return cartao;
	}

	public void setCartao(Cartao cartao) {
		this.cartao = cartao;
	}
	
	public List<Cartao> getCartoes() {
		if (cartoes == null)
			cartoes = cartaoservice.getCartoes();
		
		return cartoes;
	}
}
