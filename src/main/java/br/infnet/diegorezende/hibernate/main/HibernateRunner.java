package br.infnet.diegorezende.hibernate.main;

import br.infnet.diegorezende.hibernate.model.Museu;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class HibernateRunner {

    public static void main(String[] args) {
        System.out.println("Início do teste");

        SessionFactory sessionFactory;
        Configuration config = new Configuration();
        config.configure("hibernate.cfg.xml");
        sessionFactory = config.buildSessionFactory();


        //Exemplo Busca Todos
        List<Museu> museus = buscarTodas(sessionFactory);
        System.out.println("Lista de Museus Cadastrados: " + museus);

        //Exemplo cria um museu
        Museu museuTeste =  new Museu("MOMA","USA");
        salvar(sessionFactory, museuTeste);
        System.out.println("Exemplo cria um museu: " + museus);

        //Exemplo atualiza o museu salvo anteriormente
        museuTeste.setNome("MOMA - The Museum of Modern Art");
        atualizar(sessionFactory, museuTeste);
        System.out.println("Exemplo atualiza o museu salvo anteriormente: " + buscarTodas(sessionFactory));

        //Exemplo exclusão do museu atualizado anteriormente
        excluir(sessionFactory,museuTeste);
        System.out.println("Exemplo exclusão do museu atualizado anteriormente: " + buscarTodas(sessionFactory));

        System.out.println("Fim do teste");

    }




    public static Museu buscarPorId(SessionFactory sessionFactory,Long id) {
        Session sessao = sessionFactory.openSession();
        Museu museu = sessao.get(Museu.class, id);
        sessao.close();
        return museu;
    }

    public static List<Museu> buscarTodas(SessionFactory sessionFactory) {
        Session sessao = sessionFactory.openSession();
        List<Museu> museus = sessao.createQuery("FROM Museu ", Museu.class).list();
        sessao.close();
        return museus;
    }

    public static Museu salvar(SessionFactory sessionFactory,Museu museu) {
        Session sessao = sessionFactory.openSession();
        sessao.beginTransaction();
        sessao.persist(museu);
        sessao.getTransaction().commit();
        sessao.close();
        return museu;
    }

    public static Museu atualizar(SessionFactory sessionFactory,Museu museu) {

        Session sessao = sessionFactory.openSession();
        sessao.beginTransaction();
        Museu museuAtualizado = sessao.merge(museu);
        sessao.getTransaction().commit();
        sessao.close();
        return museuAtualizado;
    }

    public static void excluir(SessionFactory sessionFactory, Museu museu) {
        Session sessao = sessionFactory.openSession();
        sessao.beginTransaction();
        sessao.remove(museu);
        sessao.getTransaction().commit();
        sessao.close();
    }

}

