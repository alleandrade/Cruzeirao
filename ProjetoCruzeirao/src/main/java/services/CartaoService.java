package services;

import java.util.*;

import dados.Dados;
import entidades.Cartao;

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
