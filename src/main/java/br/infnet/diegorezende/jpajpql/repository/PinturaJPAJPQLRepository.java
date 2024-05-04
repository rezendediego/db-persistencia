package br.infnet.diegorezende.jpajpql.repository;


import br.infnet.diegorezende.jpajpql.model.Pintura;
import jakarta.persistence.*;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public class PinturaJPAJPQLRepository {
    @PersistenceContext
    private final EntityManager entityManager;

    public PinturaJPAJPQLRepository() {
        EntityManagerFactory emfactory = Persistence.createEntityManagerFactory( "persistenciaconfig" );
        this.entityManager = emfactory.createEntityManager();
    }

    public Pintura buscarPorId(Long id) {
        return entityManager.find(Pintura.class, id);
    }

    // Exemplo JPQL
    public List<Pintura> buscarTodas() {
        return entityManager.createQuery("SELECT pint FROM Pintura pint", Pintura.class).getResultList();
    }

    // Exemplo JPQL
    // Encontre todas as pinturas de pintores nascidos após uma determinada data
    public List<Pintura> buscarPinturasPorPintoresNascidosAposData(Date data) {
        Query query = entityManager.createQuery("SELECT p FROM Pintura p WHERE p.pintor.nascimento > :data");
        query.setParameter("data", data);
        return query.getResultList();
    }


    // Exemplo JPQL
    // Encontre todas as pinturas com um nome específico e pertencentes a um pintor específico
    public List<Pintura> buscarPinturasPorNomeEPintor(String nomePintura, String nomePintor) {
        Query query = entityManager.createQuery("SELECT p FROM Pintura p WHERE p.nome = :nomePintura AND p.pintor.nome = :nomePintor");
        query.setParameter("nomePintura", nomePintura);
        query.setParameter("nomePintor", nomePintor);
        return query.getResultList();
    }


    // Exemplo JPQL
    // Encontre todas as pinturas com inventários tendo códigos específicos
    public List<Pintura> buscarPinturasPorCodigosInventario(List<Integer> codigos) {
        Query query = entityManager.createQuery("SELECT p FROM Pintura p WHERE p.inventario.codigo IN :codigos");
        query.setParameter("codigos", codigos);
        return query.getResultList();
    }


    // Exemplo JPQL
    // Encontre todas as pinturas com um nome específico ou criadas após uma determinada data
    public List<Pintura> buscarPinturasPorNomeOuCriadasAposData(String nomePintura, Date data) {
        Query query = entityManager.createQuery("SELECT p FROM Pintura p WHERE p.nome = :nomePintura OR p.pintor.nascimento > :data");
        query.setParameter("nomePintura", nomePintura);
        query.setParameter("data", data);
        return query.getResultList();
    }


    // Exemplo JPQL
    // Encontre todas as pinturas com inventários tendo códigos em uma faixa específica
    public List<Pintura> buscarPinturasPorCodigosInventarioFaixa(int codigoInicio, int codigoFim) {
        Query query = entityManager.createQuery("SELECT p FROM Pintura p WHERE p.inventario.codigo BETWEEN :startCode AND :endCode");
        query.setParameter("startCode", codigoInicio);
        query.setParameter("endCode", codigoFim);
        return query.getResultList();
    }



    public Pintura salvar(Pintura pintura) {
        entityManager.getTransaction().begin();
        entityManager.persist(pintura);
        entityManager.getTransaction().commit();
        return pintura;

    }

    public Pintura atualizar(Pintura pintura) {
        entityManager.getTransaction( ).begin();
        entityManager.merge(pintura);
        entityManager.getTransaction( ).commit( );
        return pintura;
    }

    public void excluir(Pintura pintura) {
        entityManager.getTransaction( ).begin( );
        entityManager.remove(pintura);
        entityManager.getTransaction( ).commit( );
    }
}
