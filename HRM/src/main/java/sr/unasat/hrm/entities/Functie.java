package sr.unasat.hrm.entities;

import jakarta.persistence.*;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "functie")
public class Functie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "naam", nullable = false, length = 256)
    private String naam;

    @OneToMany(mappedBy = "functie")
    private Set<sr.unasat.hrm.entities.Werknemer> werknemers = new LinkedHashSet<>();

    public Functie() {
    }

    public Functie(Integer id) {
        this.id = id;
    }

    public Functie(String naam) {
        this.naam = naam;
    }

    public Functie(Integer id, String naam) {
        this.id = id;
        this.naam = naam;
    }

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

    public Set<sr.unasat.hrm.entities.Werknemer> getWerknemers() {
        return werknemers;
    }

    public void setWerknemers(Set<sr.unasat.hrm.entities.Werknemer> werknemers) {
        this.werknemers = werknemers;
    }

    @Override
    public String toString() {
        return "Functie{" +
                "id=" + id +
                ", naam='" + naam + '\'' +

                '}';
    }
}