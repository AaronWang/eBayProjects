package modelLayer;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DatabaseContext {
	public static EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.onlyleaf_mavenproject2_jar_1.0-SNAPSHOTPU2");
	public static EntityManager em = emf.createEntityManager();

	public static void persist(Object entity) {
		em.getTransaction().begin();
		em.persist(entity);
		em.getTransaction().commit();
	}

	public static void merge(Object entity) {
		em.getTransaction().begin();
		em.merge(entity);
		em.getTransaction().commit();
	}


}
