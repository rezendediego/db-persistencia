package br.infnet.diegorezende.jdbctemplate.dao;

import br.infnet.diegorezende.jdbctemplate.model.Museu;

import java.util.List;

public interface MuseuDAO{
    List<Museu> findAll();
    Museu findById(Long id);
    Long save(Museu museu);
    void update(Museu museu);
    void deleteById(Museu museu);
    void deleteAll();
    List<Long> getIds();
}
