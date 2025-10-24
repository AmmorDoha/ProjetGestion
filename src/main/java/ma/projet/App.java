package ma.projet;

import ma.projet.classes.Projet;
import ma.projet.classes.Tache;
import ma.projet.service.ProjetService;
import ma.projet.service.TacheService;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class App {
    public static void main(String[] args) {
        ProjetService projetService = new ProjetService();
        TacheService tacheService = new TacheService();


        // 🔹 Création d’un projet
        Projet projet = new Projet();
        projet.setNom("Gestion de stock");
        projet.setDateDebut(parseDate("14/01/2013"));
        projetService.save(projet);

        // 🔹 Création de 3 tâches pour ce projet
        Tache t1 = new Tache();
        t1.setNom("Analyse");
        t1.setPrix(1200);
        t1.setDateDebut(parseDate("10/02/2013"));
        t1.setDateFin(parseDate("20/02/2013"));
        t1.setProjet(projet);
        tacheService.save(t1);

        Tache t2 = new Tache();
        t2.setNom("Conception");
        t2.setPrix(1500);
        t2.setDateDebut(parseDate("10/03/2013"));
        t2.setDateFin(parseDate("15/03/2013"));
        t2.setProjet(projet);
        tacheService.save(t2);

        Tache t3 = new Tache();
        t3.setNom("Développement");
        t3.setPrix(3000);
        t3.setDateDebut(parseDate("10/04/2013"));
        t3.setDateFin(parseDate("25/04/2013"));
        t3.setProjet(projet);
        tacheService.save(t3);

        // 🔹 Affichage formaté du projet et de ses tâches
        afficherProjetEtTaches(projetService, projet.getId());
    }

    // Méthode d'affichage formaté
    private static void afficherProjetEtTaches(ProjetService projetService, int projetId) {
        Projet projet = projetService.findById(projetId);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.println("Projet : " + projet.getId() +
                "   Nom : " + projet.getNom() +
                "   Date début : " + sdf.format(projet.getDateDebut()));

        System.out.println("Liste des tâches:");
        System.out.println("Num  Nom             Date Début Réelle   Date Fin Réelle");

        List<Tache> taches = projetService.getTachesProjet(projetId);
        for (Tache t : taches) {
            System.out.printf("%-4d %-15s %-18s %-15s%n",
                    t.getId(),
                    t.getNom(),
                    sdf.format(t.getDateDebut()),
                    sdf.format(t.getDateFin()));
        }
    }

    // Méthode pour convertir une date String → Date
    private static Date parseDate(String dateStr) {
        try {
            return new SimpleDateFormat("dd/MM/yyyy").parse(dateStr);
        } catch (Exception e) {
            return new Date();
        }
    }
}
