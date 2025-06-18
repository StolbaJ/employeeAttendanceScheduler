package cz.cvut.fel.dbs.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.util.Date;

@Entity
@Table(name = "Prichod")
public class Prichod extends Operace {
    private String zpozdeni;
    private String duvodZpozdeni;

    // Gettery a settery
    public String getZpozdeni() { return zpozdeni; }
    public void setZpozdeni(String zpozdeni) { this.zpozdeni = zpozdeni; }

    public String getDuvodZpozdeni() { return duvodZpozdeni; }
    public void setDuvodZpozdeni(String duvodZpozdeni) { this.duvodZpozdeni = duvodZpozdeni; }


}
