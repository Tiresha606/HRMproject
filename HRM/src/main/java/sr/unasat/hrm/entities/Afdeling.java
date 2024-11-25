
package sr.unasat.hrm.entities;

import jakarta.persistence.*;
import org.hibernate.annotations.IdGeneratorType;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "afdeling")
public class Afdeling {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "id", nullable = false)
   private Integer id;
   @Column(name = "naam", length = 256 , nullable = false , unique = true)
   private String naam;
//    @OneToMany(mappedBy = "afdeling")
//  private Set<Werknemer> werknemers = new LinkedHashSet<>();


    public Afdeling() {
    }

    public Afdeling(Integer id) {
        this.id = id;
    }

    public Afdeling(String naam) {
        this.naam = naam;
    }

    public Afdeling(Integer id, String naam) {
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

    @Override
    public String toString() {
        return "Afdeling{" +
                "id=" + id +
                ", naam='" + naam + '\'' +
                '}';
    }
}
