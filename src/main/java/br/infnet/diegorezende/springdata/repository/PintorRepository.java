package br.infnet.diegorezende.springdata.repository;

import br.infnet.diegorezende.springdata.model.Pintor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PintorRepository extends JpaRepository<Pintor,Integer> {
}
