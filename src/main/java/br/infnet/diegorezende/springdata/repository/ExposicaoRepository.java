package br.infnet.diegorezende.springdata.repository;

import br.infnet.diegorezende.springdata.model.Exposicao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExposicaoRepository extends JpaRepository<Exposicao,Integer> {
}
