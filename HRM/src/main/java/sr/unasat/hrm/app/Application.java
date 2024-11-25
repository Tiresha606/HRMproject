package sr.unasat.hrm.app;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import sr.unasat.hrm.config.JPAConfig;
import sr.unasat.hrm.repositories.WerknemerRepository;
import sr.unasat.hrm.entities.Afdeling;
import sr.unasat.hrm.entities.Functie;
import sr.unasat.hrm.entities.Werknemer;

public class Application {

    public static void main(String[] args) {

        EntityManagerFactory entityManagerFactory = JPAConfig.getEntityMangerFactory();
        EntityManager entityManager = JPAConfig.getEntityManger();
        EntityTransaction transaction = entityManager.getTransaction();

        try {

//            AfdelingRepository afdelingRepository = new AfdelingRepository();
//            afdelingRepository.findAll();

            WerknemerRepository werknemerRepository = new WerknemerRepository();

            Werknemer werknemer1 = new Werknemer("Sam" , "Jackson" , "e" , "3456787" , new Afdeling(2) , new Functie(2));

            werknemerRepository.findAll();



        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            entityManager.close();
            entityManagerFactory.close();
        }
    }

















}

