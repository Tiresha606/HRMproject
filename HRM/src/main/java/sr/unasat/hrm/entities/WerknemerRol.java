package sr.unasat.hrm.entities;

import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "werknemer_rol")
public class WerknemerRol {
    @EmbeddedId
    private WerknemerRolId id;

    @MapsId("werknemerid")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "werknemerid", nullable = false)
    private Werknemer werknemerid;

    @MapsId("rollid")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "rollid", nullable = false)
    private Rol rollid;

    public WerknemerRolId getId() {
        return id;
    }

    public void setId(WerknemerRolId id) {
        this.id = id;
    }

    public Werknemer getWerknemerid() {
        return werknemerid;
    }

    public void setWerknemerid(Werknemer werknemerid) {
        this.werknemerid = werknemerid;
    }

    public Rol getRollid() {
        return rollid;
    }

    public void setRollid(Rol rollid) {
        this.rollid = rollid;
    }

}