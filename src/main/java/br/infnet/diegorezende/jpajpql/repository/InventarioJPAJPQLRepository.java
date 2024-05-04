package br.infnet.diegorezende.jpajpql.repository;


import br.infnet.diegorezende.jpajpql.model.Inventario;
import br.infnet.diegorezende.jpajpql.model.Pintura;
import jakarta.persistence.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class InventarioJPAJPQLRepository {
    @PersistenceContext
    private final EntityManager entityManager;

    public InventarioJPAJPQLRepository() {
        EntityManagerFactory emfactory = Persistence.createEntityManagerFactory( "persistenciaconfig" );
        this.entityManager = emfactory.createEntityManager();
    }

    public Inventario buscarPorId(Long id) {
        return entityManager.find(Inventario.class, id);
    }

    public List<Inventario> buscarTodas() {
        return entityManager.createQuery("SELECT i FROM Inventario i", Inventario.class).getResultList();
    }

    public Inventario salvar(Inventario inventario) {
        entityManager.getTransaction().begin();
        entityManager.persist(inventario);
        entityManager.getTransaction().commit();
        return inventario;

    }

    public Inventario atualizar(Inventario inventario) {
        entityManager.getTransaction( ).begin();
        entityManager.merge(inventario);
        entityManager.getTransaction( ).commit( );
        return inventario;
    }

    /*
    public void excluir(Inventario inventario) {
        entityManager.getTransaction( ).begin( );
        entityManager.remove(inventario);
        entityManager.getTransaction( ).commit( );
    }
    */

    public List<Pintura> getPinturas(Inventario inventario) {
        String jpql = "SELECT p FROM Pintura p WHERE p.inventario = :inventario";
        TypedQuery<Pintura> query = entityManager.createQuery(jpql, Pintura.class);
        query.setParameter("inventario", inventario);
        return query.getResultList();
    }

    public void excluir(Inventario inventario) {
        entityManager.getTransaction().begin();

        // Antes de excluir o inventário, exclua as pinturas associadas a ele
        for (Pintura pintura : getPinturas(inventario)) {
            entityManager.remove(pintura);
        }

        entityManager.remove(inventario);
        entityManager.getTransaction().commit();
    }

}
