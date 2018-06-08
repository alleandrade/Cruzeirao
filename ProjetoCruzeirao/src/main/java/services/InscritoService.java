package services;

import java.util.ArrayList;
import java.util.List;

import dados.Dados;
import dao.InscritoDAO;
import entidades.Inscrito;

public class InscritoService {
	private ArrayList<Inscrito> inscritos = Dados.inscritos;
	InscritoDAO inscritoDAO = new InscritoDAO();

	
	public InscritoService() {
		
	}
	
	public Inscrito salvar(Inscrito inscrito) {
		inscritos.add(inscrito);
		
		inscrito = inscritoDAO.save(inscrito);
		inscritoDAO.closeEntityManager();
		return inscrito;
	}
	
	public void alterar(Inscrito inscrito) {

		inscritoDAO.save(inscrito);
		inscritoDAO.closeEntityManager();
	}
	
	public void remover(Inscrito inscrito) {
		inscritos.remove(inscrito);
		
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
