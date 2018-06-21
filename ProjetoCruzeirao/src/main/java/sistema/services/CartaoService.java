package sistema.services;

import java.util.*;

import sistema.dados.Dados;
import sistema.entidades.Cartao;

public class CartaoService {
	private ArrayList<Cartao> cartoes = Dados.cartoes;
	
	public CartaoService() {
		
	}
	
	public void salvar(Cartao cartao) {
		cartoes.add(cartao);
	}

	public ArrayList<Cartao> getCartoes() {
		return cartoes;
	}
}
