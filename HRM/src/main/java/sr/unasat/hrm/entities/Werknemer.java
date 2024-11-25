package sr.unasat.hrm.entities;

import jakarta.persistence.*;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "werknemer")
public class Werknemer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "voornaam", nullable = false, length = 256)

    private String voornaam;

    @Column(name = "achternaam", nullable = false, length = 256)
    private String achternaam;

    @Column(name = "extensie", nullable = false, length = 256)
    private String extensie;

    @Column(name = "telefoon", nullable = false, length = 256)
    private String telefoon;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "afdeling", nullable = false)
    private Afdeling afdeling;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "functie", nullable = false)
    private Functie functie;

    public Werknemer() {
    }

    public Werknemer(Integer id) {
        this.id = id;
    }

    public Werknemer(String voornaam, String achternaam, String extensie, String telefoon, Afdeling afdeling, Functie functie) {
        this.voornaam = voornaam;
        this.achternaam = achternaam;
        this.extensie = extensie;
        this.telefoon = telefoon;
        this.afdeling = afdeling;
        this.functie = functie;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getVoornaam() {
        return voornaam;
    }

    public void setVoornaam(String voornaam) {
        this.voornaam = voornaam;
    }

    public String getAchternaam() {
        return achternaam;
    }

    public void setAchternaam(String achternaam) {
        this.achternaam = achternaam;
    }

    public String getExtensie() {
        return extensie;
    }

    public void setExtensie(String extensie) {
        this.extensie = extensie;
    }

    public String getTelefoon() {
        return telefoon;
    }

    public void setTelefoon(String telefoon) {
        this.telefoon = telefoon;
    }

    public Afdeling getAfdeling() {
        return afdeling;
    }

    public void setAfdeling(Afdeling afdeling) {
        this.afdeling = afdeling;
    }

    public Functie getFunctie() {
        return functie;
    }

    public void setFunctie(Functie functie) {
        this.functie = functie;
    }

    @Override
    public String toString() {
        return "Werknemer{" +
                "id=" + id +
                ", voornaam='" + voornaam + '\'' +
                ", achternaam='" + achternaam + '\'' +
                ", extensie='" + extensie + '\'' +
                ", telefoon='" + telefoon + '\'' +
                ", afdeling=" + afdeling +
                ", functie=" + functie +
                '}';
    }
}