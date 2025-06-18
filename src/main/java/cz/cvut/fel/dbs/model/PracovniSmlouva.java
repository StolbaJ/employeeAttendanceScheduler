package cz.cvut.fel.dbs.model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "PracovniSmlouva")
public class PracovniSmlouva {
    @EmbeddedId
    private PracovniSmlouvaId id;
    private Date konec;
    private double uvazek;

    // Gettery a settery
    public PracovniSmlouvaId getId() { return id; }
    public void setId(PracovniSmlouvaId id) { this.id = id; }

    public Date getKonec() { return konec; }
    public void setKonec(Date konec) { this.konec = konec; }

    public double getUvazek() { return uvazek; }
    public void setUvazek(double uvazek) { this.uvazek = uvazek; }
}

