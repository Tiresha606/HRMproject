package sr.unasat.hrm.DAO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import sr.unasat.hrm.DTO.WerknemerRegistratieDTO;
import sr.unasat.hrm.config.JPAConfig;

public class WerknemerRegistratieDAO {
    EntityManager em = JPAConfig.getEntityManger();

    public WerknemerRegistratieDTO getWerknemerRegistratieInfo(){
        EntityTransaction transaction = em.getTransaction();
        // schrijf een join die alle werknemer registratie velden vult.
        return  null;
    }
}
