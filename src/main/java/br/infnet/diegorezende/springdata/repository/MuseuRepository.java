package br.infnet.diegorezende.springdata.repository;

import br.infnet.diegorezende.springdata.model.Museu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MuseuRepository extends JpaRepository<Museu,Integer> {
}
