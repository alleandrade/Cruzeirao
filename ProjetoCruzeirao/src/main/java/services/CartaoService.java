package services;

import java.util.*;
import entidades.Cartao;

public class CartaoService {
	private ArrayList<Cartao> cartoes = new ArrayList<Cartao>();
	
	public CartaoService() {
		
	}
	
	public void salvar(Cartao cartao) {
		cartoes.add(cartao);
	}

	public ArrayList<Cartao> getCartoes() {
		return cartoes;
	}
}
