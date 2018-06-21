package sistema.services;

import java.util.List;

import sistema.dao.InscritoDAO;
import sistema.entidades.Inscrito;

public class InscritoService {

	InscritoDAO inscritoDAO = new InscritoDAO();
	
	public Inscrito salvar(Inscrito inscrito) {
		
		inscrito = inscritoDAO.save(inscrito);
		inscritoDAO.closeEntityManager();
		return inscrito;
	}
	
	public void alterar(Inscrito inscrito) {

		inscritoDAO.save(inscrito);
		inscritoDAO.closeEntityManager();
	}
	
	public void remover(Inscrito inscrito) {
		
		inscrito = inscritoDAO.getById(Inscrito.class, inscrito.getIdInscrito());
		inscritoDAO.remove(inscrito);
		inscritoDAO.closeEntityManager();
	}

	public List<Inscrito> getInscritos() {
		
		List <Inscrito> list = inscritoDAO.getAll(Inscrito.class);
		inscritoDAO.closeEntityManager();
		return list;
	}
}
