package cz.cvut.fel.dbs.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "Odchod")
public class Odchod extends Operace {
    private String prescas;
}

