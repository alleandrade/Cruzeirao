package sistema.services;

import java.util.List;

import sistema.dao.InscricaoDAO;
import sistema.entidades.Inscricao;
import sistema.entidades.Inscrito;
import sistema.entidades.Partida;

public class InscricaoService {

	InscricaoDAO inscricaoDAO = new InscricaoDAO();
	
	public Inscricao salvar(Inscricao inscricao) {
		
		inscricao = inscricaoDAO.save(inscricao);
		inscricaoDAO.closeEntityManager();
		return inscricao;
	}
	
	public void alterar(Inscricao inscricao) {

		inscricaoDAO.save(inscricao);
		inscricaoDAO.closeEntityManager();
	}
	
	public void remover(Inscricao inscricao) {
		
		inscricao = inscricaoDAO.getById(Inscricao.class, inscricao.getIdInscricao());
		inscricaoDAO.remove(inscricao);
		inscricaoDAO.closeEntityManager();
	}
	
	public List<Inscrito> pesquisarInscritosInscricao(Inscricao inscricao) {

		List<Inscrito> inscritos;
		inscricao = inscricaoDAO.getById(Inscricao .class, inscricao.getIdInscricao());
		inscritos = inscricao.getInscritos();
		return inscritos;
	}
	
	public List<Partida> pesquisarPartidasInscricao(Inscricao inscricao) {

		List<Partida> inscritos;
		inscricao = inscricaoDAO.getById(Inscricao .class, inscricao.getIdInscricao());
		inscritos = inscricao.getPartidas();
		return inscritos;
	}

	public List<Inscricao> getInscricoes() {
		
		List <Inscricao> list = inscricaoDAO.getAll(Inscricao.class);
		inscricaoDAO.closeEntityManager();
		return list;
	}
}
