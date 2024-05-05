package br.infnet.diegorezende.springdata.service;
import br.infnet.diegorezende.springdata.exception.MuseuNotFoundException;
import br.infnet.diegorezende.springdata.exception.MuseuNotUpdatedException;
import br.infnet.diegorezende.springdata.model.Museu;
import br.infnet.diegorezende.springdata.repository.MuseuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MuseuService {
    @Autowired
    private MuseuRepository museuRepository;

    public List<Museu> getAllMuseus() {
        return museuRepository.findAll();
    }

    public Museu getMuseuById(Integer id) {
        return museuRepository.findById(id).orElseThrow(MuseuNotFoundException::new);
    }

    public void deleteById(Integer id) {
        museuRepository.deleteById(id);
    }

    public Museu create(Museu museu) {
        return museuRepository.save(museu);
    }

    public Museu update(Integer id, Museu museu) {
        Optional<Museu> optionalMuseu = museuRepository.findById(id);
        if (optionalMuseu.isPresent()) {
            Museu existingMuseu = optionalMuseu.get();
            existingMuseu.setNome(museu.getNome());
            existingMuseu.setId(museu.getId());
            existingMuseu.setPais(museu.getPais());
            existingMuseu.setPinturas(museu.getPinturas());
            existingMuseu.setExposicoes(museu.getExposicoes());
            return museuRepository.save(existingMuseu);
        } else {
            throw new MuseuNotUpdatedException("Nao foi possivel realizar atualização");
        }
    }
}