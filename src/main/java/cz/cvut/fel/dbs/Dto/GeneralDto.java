package cz.cvut.fel.dbs.Dto;

import cz.cvut.fel.dbs.model.*;
import jakarta.persistence.*;
import java.util.List;

public class GeneralDto {
    private EntityManager em = Persistence.createEntityManagerFactory("cp5-persistence-unit").createEntityManager();

    // CRUD pro Zamestnanec
    public void pridatZamestnance(Zamestnanec z) {
        em.getTransaction().begin();
        em.persist(z);
        em.getTransaction().commit();
    }

    public Zamestnanec najitZamestnance(String rodneCislo) {
        return em.find(Zamestnanec.class, rodneCislo);
    }

    public List<Zamestnanec> vypisVsechnyZamestnance() {
        return em.createQuery("SELECT z FROM Zamestnanec z", Zamestnanec.class).getResultList();
    }

    public void smazatZamestnance(Zamestnanec z) {
        em.getTransaction().begin();
        em.remove(em.contains(z) ? z : em.merge(z));
        em.getTransaction().commit();
    }

    // CRUD pro Oddeleni
    public void pridatOddeleni(Oddeleni o) {
        em.getTransaction().begin();
        em.persist(o);
        em.getTransaction().commit();
    }

    public Oddeleni najitOddeleni(String zamereni) {
        return em.find(Oddeleni.class, zamereni);
    }

    // CRUD pro PracovniSmlouva
    public void pridatPracovniSmlouvu(PracovniSmlouva ps) {
        em.getTransaction().begin();
        em.persist(ps);
        em.getTransaction().commit();
    }

    // CRUD pro Operace (Prichod a Odchod)
    public void pridatOperaci(Operace op) {
        em.getTransaction().begin();
        em.persist(op);
        em.getTransaction().commit();
    }

    public List<Operace> vypisVsechnyOperace() {
        return em.createQuery("SELECT o FROM Operace o", Operace.class).getResultList();
    }

    public void smazatOperaci(Operace op) {
        em.getTransaction().begin();
        em.remove(em.contains(op) ? op : em.merge(op));
        em.getTransaction().commit();
    }
}

