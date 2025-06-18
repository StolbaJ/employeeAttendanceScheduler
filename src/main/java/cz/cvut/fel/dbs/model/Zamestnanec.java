package cz.cvut.fel.dbs.model;

import jakarta.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Zamestnanec")
public class Zamestnanec {
    @Id
    @Column(name = "rodne_cislo") // Explicit column name for clarity
    private String rodneCislo;

    private String jmeno;

    @Temporal(TemporalType.DATE) // Recommended for Date types
    private Date datumNarozeni;

    private String mesto;

    private String telefon;
    private String role;
    @Column(name = "PSC")
    private String psc;
    private String ulice;

    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "Oddeleni_zamereni", referencedColumnName = "Zamereni"),
            @JoinColumn(name = "Oddeleni_budova", referencedColumnName = "Budova")
    })
    private Oddeleni oddeleni;

    @ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    @JoinTable(
            name = "Nadrizeny", // Název spojovací tabulky
            joinColumns = @JoinColumn(name = "nadrizeny_rodne_cislo", referencedColumnName = "rodne_cislo"), // FK na ID nadřízeného v tabulce Nadrizeny
            inverseJoinColumns = @JoinColumn(name = "zamestnanec_rodne_cislo", referencedColumnName = "rodne_cislo") // FK na ID podřízeného v tabulce Nadrizeny
    )
    private Set<Zamestnanec> subordinates = new HashSet<>(); // Zaměstnanci, kterým tento zaměstnanec šéfuje

    @ManyToMany(mappedBy = "subordinates", cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    private Set<Zamestnanec> supervisors = new HashSet<>(); // Nadřízení tohoto zaměstnance

    // Gettery a settery
    public String getRodneCislo() { return rodneCislo; }
    public void setRodneCislo(String rodneCislo) { this.rodneCislo = rodneCislo; }

    public String getJmeno() { return jmeno; }
    public void setJmeno(String jmeno) { this.jmeno = jmeno; }

    public Date getDatumNarozeni() { return datumNarozeni; }
    public void setDatumNarozeni(Date datumNarozeni) { this.datumNarozeni = datumNarozeni; }

    public String getMesto() { return mesto; }
    public void setMesto(String mesto) { this.mesto = mesto; }

    public String getTelefon() { return telefon; }
    public void setTelefon(String telefon) { this.telefon = telefon; }

    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }

    public String getPsc() { return psc; }
    public void setPsc(String psc) { this.psc = psc; }

    public String getUlice() { return ulice; }
    public void setUlice(String ulice) { this.ulice = ulice; }

    public Oddeleni getOddeleni() { return oddeleni; }
    public void setOddeleni(Oddeleni oddeleni) { this.oddeleni = oddeleni; }

    public Set<Zamestnanec> getSubordinates() {
        return subordinates;
    }

    public void setSubordinates(Set<Zamestnanec> subordinates) {
        this.subordinates = subordinates;
    }

    public Set<Zamestnanec> getSupervisors() {
        return supervisors;
    }

    public void setSupervisors(Set<Zamestnanec> supervisors) {
        this.supervisors = supervisors;
    }

    // Metody pro pohodlné přidávání a odebírání vztahů (volitelné, ale doporučené)
    public void addSubordinate(Zamestnanec subordinate) {
        this.subordinates.add(subordinate);
        subordinate.getSupervisors().add(this);
    }

    public void removeSubordinate(Zamestnanec subordinate) {
        this.subordinates.remove(subordinate);
        subordinate.getSupervisors().remove(this);
    }

    public void addSupervisor(Zamestnanec supervisor) {
        this.supervisors.add(supervisor);
        supervisor.getSubordinates().add(this);
    }

    public void removeSupervisor(Zamestnanec supervisor) {
        this.supervisors.remove(supervisor);
        supervisor.getSubordinates().remove(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Zamestnanec that = (Zamestnanec) o;
        return rodneCislo != null ? rodneCislo.equals(that.rodneCislo) : that.rodneCislo == null;
    }

    @Override
    public int hashCode() {
        return rodneCislo != null ? rodneCislo.hashCode() : 0;
    }
}