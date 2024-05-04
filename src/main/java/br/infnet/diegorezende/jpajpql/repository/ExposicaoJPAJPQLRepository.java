package br.infnet.diegorezende.jpajpql.repository;


import br.infnet.diegorezende.jpajpql.model.Exposicao;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ExposicaoJPAJPQLRepository {
    @PersistenceContext
    private final EntityManager entityManager;

    public ExposicaoJPAJPQLRepository() {
        EntityManagerFactory emfactory = Persistence.createEntityManagerFactory( "persistenciaconfig" );
        this.entityManager = emfactory.createEntityManager();
    }

    public Exposicao buscarPorId(Long id) {
        return entityManager.find(Exposicao.class, id);
    }

    public List<Exposicao> buscarTodas() {
        return entityManager.createQuery("SELECT e FROM Exposicao e", Exposicao.class).getResultList();
    }

    public Exposicao salvar(Exposicao exposicao) {
        entityManager.getTransaction().begin();
        entityManager.persist(exposicao);
        entityManager.getTransaction().commit();
        return exposicao;

    }

    public Exposicao atualizar(Exposicao exposicao) {
        entityManager.getTransaction( ).begin();
        entityManager.merge(exposicao);
        entityManager.getTransaction( ).commit( );
        return exposicao;
    }

    public void excluir(Exposicao exposicao) {
        entityManager.getTransaction( ).begin( );
        entityManager.remove(exposicao);
        entityManager.getTransaction( ).commit( );
    }
}
