package sr.unasat.hrm.repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import sr.unasat.hrm.config.JPAConfig;
import sr.unasat.hrm.services.EntityRepo;
import sr.unasat.hrm.entities.Werknemer;

import java.util.List;

public class WerknemerRepository implements EntityRepo<Werknemer> {

    EntityManager em = JPAConfig.getEntityManger();

    public void findAll(){
        List<Werknemer> werknemers = em.createQuery("SELECT w FROM Werknemer w" , Werknemer.class).getResultList();
        for (Werknemer werknemerList : werknemers){
            System.out.println(werknemerList);
        }
        if (werknemers.isEmpty()){
            System.out.println("NO DATA FOUND");
        }
    }

    public void findById(int id){
        Werknemer werknemer;
        werknemer = em.find(Werknemer.class , id);
        if (werknemer!= null){
            System.out.println(werknemer);
        } else {
            System.out.println("ID NOT FOUND");
        }
    }

//        public Werknemer findId(int id){
//        return em.find(Werknemer.class,id);
//    }

    public void save(Werknemer werknemer){
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(werknemer);
        transaction.commit();
    }

    public void update(Werknemer werknemer){
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        Werknemer updateWerknemer = em.find(Werknemer.class,werknemer.getId());
        updateWerknemer.setVoornaam(werknemer.getVoornaam());
        updateWerknemer.setAchternaam(werknemer.getAchternaam());
        updateWerknemer.setExtensie(werknemer.getExtensie());
        updateWerknemer.setTelefoon(werknemer.getTelefoon());
        updateWerknemer.setAfdeling(werknemer.getAfdeling());
        updateWerknemer.setFunctie(werknemer.getFunctie());
        transaction.commit();
    }

    public void delete(Werknemer werknemer){
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        werknemer = em.find(Werknemer.class, werknemer.getId());
        if (werknemer != null) {
            em.remove(werknemer);
        } else {
            System.out.println("Werknemer met ID " + werknemer.getId() + " not found.");
        }
        transaction.commit();
    }
}
