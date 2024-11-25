package sr.unasat.hrm.repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import sr.unasat.hrm.config.JPAConfig;
import sr.unasat.hrm.services.EntityRepo;
import sr.unasat.hrm.entities.Afdeling;

import java.util.List;

public class AfdelingRepository implements EntityRepo<Afdeling> {

    EntityManager em = JPAConfig.getEntityManger();

    public void findAll(){
        List<Afdeling> afdelings = em.createQuery("SELECT a FROM Afdeling a" , Afdeling.class).getResultList();
        for (Afdeling afdeling : afdelings){
            System.out.println(afdeling);
        }
        if (afdelings.isEmpty()){
            System.out.println("NO DATA FOUND");
        }
    }

    public void findById(int id){

    }

    public void save(Afdeling afdeling){
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(afdeling);
        transaction.commit();
    }

    public void update(Afdeling afdeling){
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        Afdeling updateAfdeling = em.find(Afdeling.class,afdeling.getId());
        updateAfdeling.setNaam(afdeling.getNaam());
        transaction.commit();
    }

    public void delete(Afdeling afdeling){
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        afdeling = em.find(Afdeling.class, afdeling.getId());
        if (afdeling != null) {
            em.remove(afdeling);
        } else {
            System.out.println("Afdeling with ID " + afdeling.getId() + " not found.");
        }
        transaction.commit();
    }
}
