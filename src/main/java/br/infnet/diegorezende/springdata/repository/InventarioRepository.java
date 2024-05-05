package br.infnet.diegorezende.springdata.repository;

import br.infnet.diegorezende.springdata.model.Inventario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InventarioRepository extends JpaRepository<Inventario,Integer> {
}
