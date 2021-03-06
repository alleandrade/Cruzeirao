package sistema.daogeneric;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

public abstract class DAOImpl <T, I extends Serializable> {

    private static EntityManagerFactory emf;
    public EntityManager em;
    
     public DAOImpl() {
    	
    	emf = Persistence.createEntityManagerFactory("ProjetoCruzeirao");

	}


	public T save(T entity) {

		T saved = null;

		getEntityManager().getTransaction().begin();
		saved = getEntityManager().merge(entity);
		getEntityManager().getTransaction().commit();

		return saved;
	}
	

	public void remove(T entity) {
		getEntityManager().getTransaction().begin();
		getEntityManager().remove(entity);
		getEntityManager().getTransaction().commit();

	}


	public T getById(Class<T> classe, I pk) {

		try {
			T t = getEntityManager().find(classe, pk);
			getEntityManager().refresh(t);
			return t;
		} catch (NoResultException e) {
			return null;
		}

	}

	@SuppressWarnings("unchecked")
	public List<T> getAll(Class<T> classe) {

		return getEntityManager().createQuery("select o from " + classe.getSimpleName() + " o").getResultList();
	}


	public EntityManager getEntityManager() {
	  
	 if(em == null)
	 	em = emf.createEntityManager();
	  
	  return em;
	}
	

	public void closeEntityManager(){
		
		if(em != null)
			em.close();
		
		em = null;
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	protected T pesquisarUm(String namedQuery, Map parametros) {
		T resultado = null;

		try {
			Query query = em.createNamedQuery(namedQuery);
			if (parametros != null && !parametros.isEmpty()) {
				popularParametrosQuery(query, parametros);
			}
			resultado = (T) query.setMaxResults(1).getSingleResult();
		} catch (NoResultException e) {
			System.out.println(e);
		} catch (Exception e) {
			System.out.println(e);
		}

		return resultado;
	}
	
	
	protected void popularParametrosQuery(Query query,	Map<String, Object> parametros) {
		for (Map.Entry<String, Object> parametro : parametros.entrySet()) {
			query.setParameter(parametro.getKey(), parametro.getValue());
		}
	}	
	
}