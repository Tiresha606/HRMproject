package sr.unasat.hrm.repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import sr.unasat.hrm.config.JPAConfig;
import sr.unasat.hrm.services.EntityRepo;
import sr.unasat.hrm.entities.Rol;

import java.util.List;

public class RolRepository implements EntityRepo<Rol> {

    EntityManager em = JPAConfig.getEntityManger();

    public void findAll(){
        List<Rol> rols = em.createQuery("SELECT r FROM Rol r" , Rol.class).getResultList();
        for (Rol rollist : rols){
            System.out.println(rollist);
        }
        if (rols.isEmpty()){
            System.out.println("NO DATA");
        }
    }

    public void findById(int id){

    }

    public void save(Rol rol){
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(rol);
        transaction.commit();
    }

    public void update(Rol rol){
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        Rol updateRol = em.find(Rol.class,rol.getId());
        updateRol.setNaam(rol.getNaam());
        transaction.commit();
    }

    public void delete(Rol rol){
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        rol = em.find(Rol.class, rol.getId());
        if (rol != null) {
            em.remove(rol);
        } else {
            System.out.println("Rol met ID " + rol.getId() + " not found.");
        }
        transaction.commit();
    }
}
