package sistema.services;


import java.util.List;

import sistema.dao.CartaoDAO;
import sistema.entidades.Cartao;


public class CartaoService {

 	CartaoDAO cartaoDAO = new CartaoDAO();

	public Cartao salvar(Cartao cartao) {
	
		cartao = cartaoDAO.save(cartao);
		cartaoDAO.closeEntityManager();
		return cartao;
	}
	
	public void alterar(Cartao cartao) {

		cartaoDAO.save(cartao);
		cartaoDAO.closeEntityManager();
	}
	
	public void remover(Cartao cartao) {
		
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
