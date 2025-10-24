package ma.projet.service;

import ma.projet.classes.Tache;
import ma.projet.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class TacheService {

    // ✅ Méthode save (alias de ajouterTache)
    public void save(Tache tache) {
        ajouterTache(tache);
    }

    // Ajouter une tâche
    public void ajouterTache(Tache tache) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(tache);
            transaction.commit();
            System.out.println("✅ Tâche ajoutée avec succès !");
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }

    // Récupérer une tâche par ID
    public Tache getTacheById(int id) {
        Tache tache = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tache = session.get(Tache.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tache;
    }

    // Récupérer toutes les tâches
    public List<Tache> getAllTaches() {
        List<Tache> taches = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            taches = session.createQuery("from Tache", Tache.class).list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return taches;
    }

    // Mettre à jour une tâche
    public void updateTache(Tache tache) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.update(tache);
            transaction.commit();
            System.out.println("✏️ Tâche mise à jour avec succès !");
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }

    // Supprimer une tâche
    public void deleteTache(int id) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Tache tache = session.get(Tache.class, id);
            if (tache != null) {
                session.delete(tache);
                System.out.println("🗑️ Tâche supprimée avec succès !");
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }
}
