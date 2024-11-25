package sr.unasat.hrm.repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.transaction.Transaction;
import sr.unasat.hrm.config.JPAConfig;
import sr.unasat.hrm.services.EntityRepo;
import sr.unasat.hrm.entities.Functie;

import java.util.List;

public class FunctieRepository implements EntityRepo<Functie> {

   EntityManager em = JPAConfig.getEntityManger();


    public void findAll(){
        List<Functie> functies = em.createQuery("SELECT f FROM Functie f" , Functie.class).getResultList();
        for (Functie functieList : functies){
            System.out.println(functieList);
        } if (functies.isEmpty()){
            System.out.println("NO DATA FOUND");
        }
    }

    public void findById(int id){

    }

    public void save(Functie functie){
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(functie);
        transaction.commit();

    }

    public void update(Functie functie){
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        Functie updateFunctie = em.find(Functie.class,functie.getId());
        updateFunctie.setNaam(functie.getNaam());
        transaction.commit();
    }

    public void delete(Functie functie){
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        functie = em.find(Functie.class, functie.getId());
        if (functie != null) {
            em.remove(functie);
        } else {
            System.out.println("Functie met ID " + functie.getId() + " not found.");
        }
        transaction.commit();
    }
}
