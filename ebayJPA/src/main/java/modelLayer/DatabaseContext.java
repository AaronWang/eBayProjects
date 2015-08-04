package modelLayer;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public class DatabaseContext {
	public static EntityManagerFactory emf = Persistence.createEntityManagerFactory("DerbyJPA");
	public static EntityManager em = emf.createEntityManager();
	public static CriteriaBuilder cb = em.getCriteriaBuilder();

	public static void persist(Object entity) {
		em.getTransaction().begin();
		em.persist(entity);
		em.getTransaction().commit();
	}

	public static void insertRecord(Object entity) {
		em.getTransaction().begin();
		em.persist(entity);
		em.getTransaction().commit();
	}

	public static void merge(Object entity) {
		em.getTransaction().begin();
		em.merge(entity);
		em.getTransaction().commit();
	}

	public static void delete(Object entity) {
		em.getTransaction().begin();
		em.remove(entity);
		em.getTransaction().commit();
	}

	public static <T> Object find(Class<T> entityClass, Object primarykey) {
		Object obj;
		em.getTransaction().begin();
		obj = em.find(entityClass, primarykey);
		em.getTransaction().commit();
		return obj;
	}

	public static <T> List findAll(Class<T> entityClass) {
		List<T> result = null;
		em.getTransaction().begin();

		// try {
		CriteriaQuery<T> cq = cb.createQuery(entityClass);
		if (cq != null) {
			Root<T> object = cq.from(entityClass);

			cq.select(object);
			TypedQuery<T> q = em.createQuery(cq);
			result = q.getResultList();
		}
		em.getTransaction().commit();
		return result;
	}
}
