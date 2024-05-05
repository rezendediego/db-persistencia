package br.infnet.diegorezende.springdata.repository;

import br.infnet.diegorezende.springdata.model.Pintura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PinturaRepository extends JpaRepository<Pintura,Integer> {
}
