package ma.projet.classes;

import jakarta.persistence.*;
import java.util.Set;

@Entity
public class Employe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nom;

    @OneToMany(mappedBy = "employe")
    private Set<EmployeTache> taches;

    // --- Getters et Setters ---
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Set<EmployeTache> getTaches() {
        return taches;
    }

    public void setTaches(Set<EmployeTache> taches) {
        this.taches = taches;
    }
}
