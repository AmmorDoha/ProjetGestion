package ma.projet.service;

import ma.projet.classes.Projet;
import ma.projet.classes.Tache;
import ma.projet.dao.IDao;
import ma.projet.util.HibernateUtil;
import org.hibernate.Session;

import java.util.List;

public class ProjetService implements IDao<Projet> {

    @Override
    public void save(Projet projet) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.persist(projet);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void update(Projet projet) { /* similaire à save */ }

    @Override
    public void delete(Projet projet) { /* similaire à save */ }

    @Override
    public Projet findById(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Projet p = session.get(Projet.class, id);
        session.close();
        return p;
    }

    @Override
    public List<Projet> findAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Projet> list = session.createQuery("from Projet", Projet.class).list();
        session.close();
        return list;
    }

    // Méthode spécifique : liste des tâches planifiées pour un projet
    public List<Tache> getTachesProjet(int projetId) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Tache> taches = session.createQuery("from Tache t where t.projet.id = :pid", Tache.class)
                .setParameter("pid", projetId).list();
        session.close();
        return taches;
    }
}