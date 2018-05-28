package services;

import java.util.ArrayList;
import java.util.List;

import dados.Dados;
import dao.CartaoDAO;
import entidades.Cartao;
import entidades.Usuario;

public class CartaoService {
	private ArrayList<Cartao> cartoes = Dados.cartoes;
 	CartaoDAO cartaoDAO = new CartaoDAO();

	
	public CartaoService() {
		
	}
	
	public Cartao salvar(Cartao cartao) {
		cartoes.add(cartao);
		
		cartao = cartaoDAO.save(cartao);
		cartaoDAO.closeEntityManager();
		return cartao;
	}
	
	public void alterar(Cartao cartao) {

		cartaoDAO.save(cartao);
		cartaoDAO.closeEntityManager();
	}
	
	public void remover(Cartao cartao) {
		cartoes.remove(cartao);		
		
		cartao = cartaoDAO.getById(Cartao.class, cartao.getIdCartao());
		cartaoDAO.remove(cartao);
		cartaoDAO.closeEntityManager();
	}

	public List<Cartao> getCartoes() {
		List <Cartao> list = cartaoDAO.getAll(Cartao.class);
		cartaoDAO.closeEntityManager();
		return list;	
	}
}
