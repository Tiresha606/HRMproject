package sr.unasat.hrm.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import org.hibernate.Hibernate;

import java.util.Objects;

@Embeddable
public class WerknemerRolId implements java.io.Serializable {
    private static final long serialVersionUID = 158549608633245531L;
    @Column(name = "werknemerid", nullable = false)
    private Integer werknemerid;

    @Column(name = "rollid", nullable = false)
    private Integer rollid;

    public Integer getWerknemerid() {
        return werknemerid;
    }

    public void setWerknemerid(Integer werknemerid) {
        this.werknemerid = werknemerid;
    }

    public Integer getRollid() {
        return rollid;
    }

    public void setRollid(Integer rollid) {
        this.rollid = rollid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        WerknemerRolId entity = (WerknemerRolId) o;
        return Objects.equals(this.werknemerid, entity.werknemerid) &&
                Objects.equals(this.rollid, entity.rollid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(werknemerid, rollid);
    }

}