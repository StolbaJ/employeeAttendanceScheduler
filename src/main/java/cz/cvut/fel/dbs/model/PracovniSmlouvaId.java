package cz.cvut.fel.dbs.model;

import jakarta.persistence.Embeddable;

import java.util.Date;

@Embeddable
public class PracovniSmlouvaId {
    private Date pocatek;
    private String zamestnanec;

    // Konstruktor
    public PracovniSmlouvaId() {}

    public PracovniSmlouvaId(Date pocatek, String zamestnanec) {
        this.pocatek = pocatek;
        this.zamestnanec = zamestnanec;
    }

    // Gettery a settery
    public Date getPocatek() { return pocatek; }
    public void setPocatek(Date pocatek) { this.pocatek = pocatek; }

    public String getZamestnanec() { return zamestnanec; }
    public void setZamestnanec(String zamestnanec) { this.zamestnanec = zamestnanec; }
}
