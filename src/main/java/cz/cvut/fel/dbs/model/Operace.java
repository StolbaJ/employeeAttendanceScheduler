package cz.cvut.fel.dbs.model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Operace")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Operace {
    @Id
    private Date casovaZnamka;
    private boolean validni;
}

