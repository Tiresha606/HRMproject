package sr.unasat.hrm.config;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class JPAConfig {
    private static EntityManagerFactory emf ;
    private static EntityManager em ;
    private EntityTransaction transaction = em.getTransaction();

    public static EntityManagerFactory getEntityMangerFactory(){
        if (emf == null ) {
            emf = Persistence.createEntityManagerFactory("hrmPersistenceUnit");
        }
        return emf;
    }

    public static EntityManager getEntityManger(){
        if (em == null ) {
            em  = emf.createEntityManager();
        }
        return em;
    }

}
