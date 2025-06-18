package cz.cvut.fel.dbs.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Webovky")
public class Webovky {
    @Id
    @Column(name = "Domena")
    private String domena;

    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "Oddeleni_zamereni", referencedColumnName = "Zamereni"),
            @JoinColumn(name = "Oddeleni_budova", referencedColumnName = "Budova")
    })
    private Oddeleni oddeleni;

    // Getters and setters
    public String getDomena() {
        return domena;
    }

    public void setDomena(String domena) {
        this.domena = domena;
    }

    public Oddeleni getOddeleni() {
        return oddeleni;
    }

    public void setOddeleni(Oddeleni oddeleni) {
        this.oddeleni = oddeleni;
    }
}