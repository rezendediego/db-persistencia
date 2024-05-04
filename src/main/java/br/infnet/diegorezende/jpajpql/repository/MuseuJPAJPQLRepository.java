package br.infnet.diegorezende.jpajpql.repository;


import br.infnet.diegorezende.jpajpql.model.Museu;
import jakarta.persistence.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MuseuJPAJPQLRepository {
    @PersistenceContext
    private final EntityManager entityManager;

    public MuseuJPAJPQLRepository() {
        EntityManagerFactory emfactory = Persistence.createEntityManagerFactory( "persistenciaconfig" );
        this.entityManager = emfactory.createEntityManager();
    }

    public Museu buscarPorId(Long id) {
        return entityManager.find(Museu.class, id);
    }

    // Exemplo JPQL
    // Recupera todos os museus
    public List<Museu> buscarTodos() {
        return entityManager.createQuery("SELECT m FROM Museu m", Museu.class).getResultList();
    }

    //Exemplo JPQL
    //Encontre todos os museus em um país específico.
    public List<Museu> buscarMuseuPorPais(String pais) {
        Query query = entityManager.createQuery("SELECT m FROM Museu m WHERE m.pais = :pais", Museu.class);
        query.setParameter("pais", pais);
        return query.getResultList();
    }



    // Exemplo JPQL
    // Encontra todos os museus em um país específico
    public List<Museu> buscarMuseusPorPais(String nomePais) {
        Query query = entityManager.createQuery("SELECT m FROM Museu m WHERE m.pais = :nomePais", Museu.class);
        query.setParameter("nomePais", nomePais);
        return query.getResultList();
    }

    // Exemplo JPQL
    // Encontra todos os museus participantes de uma exposição específica
    public List<Museu> buscarMuseusPorExposicao(String nomeExposicao) {
        Query query = entityManager.createQuery("SELECT m FROM Museu m JOIN m.exposicoes e WHERE e.nome = :nomeExposicao", Museu.class);
        query.setParameter("nomeExposicao", nomeExposicao);
        return query.getResultList();
    }

    // Exemplo JPQL
    // Encontra todos os museus onde uma pintura específica é exibida
    public List<Museu> buscarMuseusPorPintura(String nomePintura) {
        Query query = entityManager.createQuery("SELECT m FROM Museu m JOIN m.pinturas pint WHERE pint.nome = :nomePintura", Museu.class);
        query.setParameter("nomePintura", nomePintura);
        return query.getResultList();
    }

    // Exemplo JPQL
    // Encontra todos os museus onde pelo menos uma pintura é exibida, mas nenhuma pertence a um pintor específico
    public List<Museu> buscarMuseusPorPinturaENaoPintor(String nomePintor) {
        Query query = entityManager.createQuery("SELECT m FROM Museu m WHERE SIZE(m.pinturas) > 0 AND NOT EXISTS (SELECT p FROM Pintura p WHERE p.pintor.nome = :nomePintor AND p.museu = m)", Museu.class);
        query.setParameter("nomePintor", nomePintor);
        return query.getResultList();
    }

    // Exemplo JPQL
    // Encontra todos os museus com uma pintura específica feita por um pintor específico
    public List<Museu> buscarMuseusPorPinturaEPintor(String nomePintura, String nomePintor) {
        Query query = entityManager.createQuery("SELECT m FROM Museu m JOIN m.pinturas p WHERE p.nome = :nomePintura AND p.pintor.nome = :nomePintor", Museu.class);
        query.setParameter("nomePintura", nomePintura);
        query.setParameter("nomePintor", nomePintor);
        return query.getResultList();
    }


    public Museu salvar(Museu museu) {
        entityManager.getTransaction().begin();
        entityManager.persist(museu);
        entityManager.getTransaction().commit();
        return museu;

    }

    public Museu atualizar(Museu museu) {
        entityManager.getTransaction( ).begin();
        entityManager.merge(museu);
        entityManager.getTransaction( ).commit( );
        return museu;
    }

    public void excluir(Museu museu) {
        entityManager.getTransaction( ).begin( );
        entityManager.remove(museu);
        entityManager.getTransaction( ).commit( );
    }
}
