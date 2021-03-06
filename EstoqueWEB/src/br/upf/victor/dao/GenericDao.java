package br.upf.victor.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.upf.victor.jpa.JPAFactory;

public class GenericDao<T> implements InterfaceDAO<T> {

	private Class classe;
	
	public GenericDao(Class classe) {
		super();
		this.classe = classe;
	}

	@Override
	public void persist(T instancia) throws Exception {
		EntityManager em = JPAFactory.getEntityManager();
		em.getTransaction().begin();
		em.persist(instancia);
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public T merge(T instancia) throws Exception {
		EntityManager em = JPAFactory.getEntityManager();
		em.getTransaction().begin();
		instancia = em.merge(instancia);
		em.getTransaction().commit();
		em.close();
		return instancia;
	}

	@Override
	public void remove(T instancia) throws Exception {
		EntityManager em = JPAFactory.getEntityManager();
		em.getTransaction().begin();
		em.remove(em.merge(instancia));
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public void remove(Integer id) throws Exception {
		EntityManager em = JPAFactory.getEntityManager();
		em.getTransaction().begin();
		em.remove( em.find(classe, id) );
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public T getInstancia(Integer id) throws Exception {
		EntityManager em = JPAFactory.getEntityManager();
		T ret = (T) em.find(classe, id);
		em.close();
		return ret;
	}

	@Override
	public List<T> getInstanciasList() {
		EntityManager em = JPAFactory.getEntityManager();
		List<T> ret = em.createQuery("from "+classe.getSimpleName()).getResultList();
		em.close();
		return ret;
	}

	@Override
	public List<T> getInstanciasList(String atributoOrdem) {
		EntityManager em = JPAFactory.getEntityManager();
		List<T> ret = em.createQuery("from "+classe.getSimpleName()+
				                     " order by "+atributoOrdem).getResultList();
		em.close();
		return ret;
	}

	@Override
	public List<T> getInstanciasList(String atributoOrdem, String atributoFiltro, String valorFiltro) {
		EntityManager em = JPAFactory.getEntityManager();
		List<T> ret = em.createQuery("from "+classe.getSimpleName()+
				                     " where upper(cast("+atributoFiltro+" as string)) like '%"+valorFiltro+"%' "+
				                     " order by "+atributoOrdem).getResultList();
		em.close();
		return ret;
	}

	@Override
	public List<T> getInstanciasList(String atributoOrdem, String atributoFiltro, String valorFiltro,
			Integer numObjetos, Integer posInicial) {
		EntityManager em = JPAFactory.getEntityManager();
		List<T> ret = em.createQuery("from "+classe.getSimpleName()+
				                     " where upper(cast("+atributoFiltro+" as string)) like '%"+valorFiltro.toUpperCase()+"%' "+
				                     " order by "+atributoOrdem).
				setFirstResult(posInicial).setMaxResults(numObjetos).
				getResultList();
		em.close();
		return ret;

	}

}
