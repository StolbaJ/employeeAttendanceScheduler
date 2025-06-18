package cz.cvut.fel.dbs.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Oddeleni")
public class Oddeleni {
    @Id
    private String zamereni;
    private String budova;
    private int maxPocetZamestnancu;

    // Gettery a settery
    public String getZamereni() { return zamereni; }
    public void setZamereni(String zamereni) { this.zamereni = zamereni; }

    public String getBudova() { return budova; }
    public void setBudova(String budova) { this.budova = budova; }

    public int getMaxPocetZamestnancu() { return maxPocetZamestnancu; }
    public void setMaxPocetZamestnancu(int maxPocetZamestnancu) { this.maxPocetZamestnancu = maxPocetZamestnancu; }
}

