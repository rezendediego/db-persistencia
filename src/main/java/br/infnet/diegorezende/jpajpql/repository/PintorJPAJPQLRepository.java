package br.infnet.diegorezende.jpajpql.repository;


import br.infnet.diegorezende.jpajpql.model.Pintor;
import jakarta.persistence.*;
import org.springframework.stereotype.Repository;


import java.util.Date;
import java.util.List;

@Repository
public class PintorJPAJPQLRepository {
    @PersistenceContext
    private final EntityManager entityManager;

    public PintorJPAJPQLRepository() {
        EntityManagerFactory emfactory = Persistence.createEntityManagerFactory( "persistenciaconfig" );
        this.entityManager = emfactory.createEntityManager();
    }

    public Pintor buscarPorId(Long id) {
        return entityManager.find(Pintor.class, id);
    }


    // Exemplo JPQL
    public List<Pintor> buscarTodos() {
        return entityManager.createQuery("SELECT p FROM Pintor p", Pintor.class).getResultList();
    }


    // Exemplo JPQL
    // Encontre todos os pintores que nasceram antes de uma determinada data
    public List<Pintor> buscarPintoresNascidosAntesData(Date data) {
        Query query = entityManager.createQuery("SELECT p FROM Pintor p WHERE p.nascimento < :data");
        query.setParameter("data", data);
        return query.getResultList();
    }


    // Exemplo JPQL
    // Encontre todos os pintores com mais de um certo número de pinturas
    public List<Pintor> buscarPintoresComMaisPinturasQue(int numeroPinturas) {
        Query query = entityManager.createQuery("SELECT p FROM Pintor p WHERE SIZE(p.pinturas) > :numeroPinturas");
        query.setParameter("numeroPinturas", numeroPinturas);
        return query.getResultList();
    }


    // Exemplo JPQL
    // Encontre todos os pintores que têm pinturas em museus localizados em um país específico
    public List<Pintor> buscarPintoresComPinturasEmMuseusPais(String pais) {
        Query query = entityManager.createQuery("SELECT DISTINCT p FROM Pintor p JOIN p.pinturas pt JOIN pt.museu m WHERE m.pais = :pais");
        query.setParameter("pais", pais);
        return query.getResultList();
    }


    // Exemplo JPQL
    // Encontre todos os pintores que têm pinturas em vários museus
    public List<Pintor> buscarPintoresComPinturasEmMultiplosMuseus() {
        Query query = entityManager.createQuery("SELECT DISTINCT p FROM Pintor p JOIN p.pinturas pt JOIN pt.museu m GROUP BY p HAVING COUNT(DISTINCT m) > 1");
        return query.getResultList();
    }


    public Pintor salvar(Pintor pintor) {
        entityManager.getTransaction().begin();
        entityManager.persist(pintor);
        entityManager.getTransaction().commit();
        return pintor;

    }

    public Pintor atualizar(Pintor pintor) {
        entityManager.getTransaction( ).begin();
        entityManager.merge(pintor);
        entityManager.getTransaction( ).commit( );
        return pintor;
    }

    public void excluir(Pintor pintor) {
        entityManager.getTransaction( ).begin( );
        entityManager.remove(pintor);
        entityManager.getTransaction( ).commit( );
    }
}
