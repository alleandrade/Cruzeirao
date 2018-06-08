package services;

import java.util.ArrayList;
import java.util.List;

import dados.Dados;
import dao.InscricaoDAO;
import entidades.Inscricao;

public class InscricaoService {
	private ArrayList<Inscricao> inscricoes = Dados.inscricoes;
	InscricaoDAO inscricaoDAO = new InscricaoDAO();
	
	public InscricaoService() {
		
	}
	
	public Inscricao salvar(Inscricao inscricao) {
		inscricoes.add(inscricao);
		
		inscricao = inscricaoDAO.save(inscricao);
		inscricaoDAO.closeEntityManager();
		return inscricao;
	}
	
	public void alterar(Inscricao inscricao) {

		inscricaoDAO.save(inscricao);
		inscricaoDAO.closeEntityManager();
	}
	
	public void remover(Inscricao inscricao) {
		inscricoes.remove(inscricao);
		
		inscricao = inscricaoDAO.getById(Inscricao.class, inscricao.getIdInscricao());
		inscricaoDAO.remove(inscricao);
		inscricaoDAO.closeEntityManager();
	}

	public List<Inscricao> getInscricoes() {
		List <Inscricao> list = inscricaoDAO.getAll(Inscricao.class);
		inscricaoDAO.closeEntityManager();
		return list;
	}
}
