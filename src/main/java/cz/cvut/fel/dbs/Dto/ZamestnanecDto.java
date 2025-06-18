package cz.cvut.fel.dbs.Dto;


import cz.cvut.fel.dbs.model.Zamestnanec;
import jakarta.persistence.EntityManager;
import cz.cvut.fel.dbs.config.JpaConfig;
import java.util.List;

public class ZamestnanecDto {
    private EntityManager em = JpaConfig.getEntityManager();

    public void pridatZamestnance(Zamestnanec z) {
        em.getTransaction().begin();
        em.persist(z);
        em.getTransaction().commit();
    }

    public List<Zamestnanec> vypisVsechnyZamestnance() {
        return em.createQuery("SELECT z FROM Zamestnanec z", Zamestnanec.class).getResultList();
    }
}
