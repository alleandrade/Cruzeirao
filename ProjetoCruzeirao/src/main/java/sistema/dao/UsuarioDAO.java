package sistema.dao;

import java.util.HashMap;
import java.util.Map;

import sistema.daogeneric.DAOImpl;
import sistema.entidades.Usuario;

public class UsuarioDAO extends DAOImpl<Usuario, Integer>{
	
	protected Class<Usuario> getClasseEntidade() {
		return Usuario.class;
	}
	
	public Usuario pesquisarPorEmail(String email) {
		Map<String, Object> parametros = new HashMap<String, Object>();
		parametros.put("email", email);

		return super.pesquisarUm(Usuario.PESQUISAR_POR_EMAIL, parametros);
}

}
