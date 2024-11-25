package sr.unasat.hrm.entities;

import jakarta.persistence.*;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "rol")
public class Rol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "naam", nullable = false, length = 256)
    private String naam;

    @ManyToMany
    @JoinTable(name = "werknemer_rol",
            joinColumns = @JoinColumn(name = "rollid"),
            inverseJoinColumns = @JoinColumn(name = "werknemerid"))
    private Set<Werknemer> werknemers = new LinkedHashSet<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public Set<Werknemer> getWerknemers() {
        return werknemers;
    }

    public void setWerknemers(Set<Werknemer> werknemers) {
        this.werknemers = werknemers;
    }

    @Override
    public String toString() {
        return "Rol{" +
                "id=" + id +
                ", naam='" + naam + '\'' +

                '}';
    }
}