package sistema.dao;

import sistema.daogeneric.DAOImpl;
import sistema.entidades.Usuario;

public class UsuarioDAO extends DAOImpl<Usuario, Integer>{
	
	protected Class<Usuario> getClasseEntidade() {
		return Usuario.class;
	}

}
