package br.infnet.diegorezende.hibernate.service;

import br.infnet.diegorezende.hibernate.model.Pintura;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class PinturaServiceHibernate {

    private final SessionFactory sessionFactory;

    public PinturaServiceHibernate() {
        Configuration config = new Configuration();
        config.configure("hibernate.cfg.xml");
        sessionFactory = config.buildSessionFactory();
    }

    public Pintura buscarPorId(int id) {
        Session session = sessionFactory.openSession();
        Pintura livro = session.get(Pintura.class, id);
        session.close();
        return livro;
    }

    public List<Pintura> buscarTodos() {
        Session session = sessionFactory.openSession();
        List<Pintura> pinturas = session.createQuery("FROM Pintura ", Pintura.class).list();
        session.close();
        return pinturas;
    }

    public void salvar(Pintura pintura) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.persist(pintura);
        session.getTransaction().commit();
        session.close();
    }

    public void atualizar(Pintura pintura) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.merge(pintura);
        session.getTransaction().commit();
        session.close();
    }

    public void excluir(Pintura pintura) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.remove(pintura);
        session.getTransaction().commit();
        session.close();
    }
}
