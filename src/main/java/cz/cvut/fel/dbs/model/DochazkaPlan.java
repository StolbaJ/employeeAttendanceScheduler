package cz.cvut.fel.dbs.model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "DochazkaPlan")
public class DochazkaPlan {
    @EmbeddedId
    private DochazkaPlanId id;
    private int povolenePrestavky;
}

@Embeddable
class DochazkaPlanId {
    private Date pocatek;
    private Date konec;
    private Date datum;
}