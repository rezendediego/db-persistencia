package br.infnet.diegorezende.hibernate.service;

import br.infnet.diegorezende.hibernate.model.Museu;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;
public class MuseuServiceHibernate {

    private final SessionFactory sessionFactory;

    public MuseuServiceHibernate() {
        Configuration config = new Configuration();
        config.configure("hibernate.cfg.xml");
        sessionFactory = config.buildSessionFactory();
    }

    public Museu buscarPorId(Long id) {
        Session sessao = sessionFactory.openSession();
        Museu museu = sessao.get(Museu.class, id);
        sessao.close();
        return museu;
    }

    public List<Museu> buscarTodas() {
        Session sessao = sessionFactory.openSession();
        List<Museu> museus = sessao.createQuery("FROM Museu", Museu.class).list();
        sessao.close();
        return museus;
    }

    public Museu salvar(Museu museu) {
        Session sessao = sessionFactory.openSession();
        sessao.beginTransaction();
        sessao.persist(museu);
        sessao.getTransaction().commit();
        sessao.close();
        return museu;
    }

    public Museu atualizar(Museu museu) {
        Session sessao = sessionFactory.openSession();
        sessao.beginTransaction();
        sessao.merge(museu);
        sessao.getTransaction().commit();
        sessao.close();
        return museu;
    }

    public void excluir(Museu museu) {
        Session sessao = sessionFactory.openSession();
        sessao.beginTransaction();
        sessao.remove(museu);
        sessao.getTransaction().commit();
        sessao.close();
    }
}