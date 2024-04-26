package br.infnet.diegorezende.hibernate.service;


import br.infnet.diegorezende.hibernate.model.Pintor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


import java.util.List;

public class PintorServiceHibernate {

    private final SessionFactory sessionFactory;

    public PintorServiceHibernate() {
        Configuration config = new Configuration();
        config.configure("hibernate.cfg.xml");
        sessionFactory = config.buildSessionFactory();
    }

    public Pintor buscarPorId(Long id) {
        Session session = sessionFactory.openSession();
        Pintor pintor = session.get(Pintor.class, id);
        session.close();
        return pintor;
    }

    public List<Pintor> buscarTodos() {
        Session session = sessionFactory.openSession();
        List<Pintor> pintor = session.createQuery("FROM Pintor", Pintor.class).list();
        session.close();
        return pintor;
    }

    public void salvar(Pintor pintor) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.persist(pintor);
        session.getTransaction().commit();
        session.close();
    }

    public void atualizar(Pintor pintor) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.merge(pintor);
        session.getTransaction().commit();
        session.close();
    }

    public void excluir(Pintor pintor) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.remove(pintor);
        session.getTransaction().commit();
        session.close();
    }
}
