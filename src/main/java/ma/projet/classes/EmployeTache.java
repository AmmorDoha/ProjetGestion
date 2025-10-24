package ma.projet.classes;

import jakarta.persistence.*;
import java.util.Date;

@Entity
public class EmployeTache {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    private Employe employe;

    @ManyToOne
    private Tache tache;

    @Temporal(TemporalType.DATE)
    private Date dateReelleDebut;

    @Temporal(TemporalType.DATE)
    private Date dateReelleFin;

    // --- Getters et Setters ---
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Employe getEmploye() {
        return employe;
    }

    public void setEmploye(Employe employe) {
        this.employe = employe;
    }

    public Tache getTache() {
        return tache;
    }

    public void setTache(Tache tache) {
        this.tache = tache;
    }

    public Date getDateReelleDebut() {
        return dateReelleDebut;
    }

    public void setDateReelleDebut(Date dateReelleDebut) {
        this.dateReelleDebut = dateReelleDebut;
    }

    public Date getDateReelleFin() {
        return dateReelleFin;
    }

    public void setDateReelleFin(Date dateReelleFin) {
        this.dateReelleFin = dateReelleFin;
    }
}
