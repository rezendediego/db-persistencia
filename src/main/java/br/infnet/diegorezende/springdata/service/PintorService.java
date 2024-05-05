package br.infnet.diegorezende.springdata.service;

import br.infnet.diegorezende.springdata.exception.PintorNotFoundException;
import br.infnet.diegorezende.springdata.exception.PintorNotUpdatedException;
import br.infnet.diegorezende.springdata.model.Pintor;
import br.infnet.diegorezende.springdata.repository.PintorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PintorService {
    @Autowired
    private PintorRepository pintorRepository;

    public List<Pintor> getAllPintores() {
        return pintorRepository.findAll();
    }

    public Pintor getPintorById(Integer id) {
        return pintorRepository.findById(id).orElseThrow(PintorNotFoundException::new);
    }

    public void deleteById(Integer id) {
        pintorRepository.deleteById(id);
    }

    public Pintor create(Pintor pintor) {
        return pintorRepository.save(pintor);
    }

    public Pintor update(Integer id, Pintor pintor) {
        Optional<Pintor> optionalPintor = pintorRepository.findById(id);
        if (optionalPintor.isPresent()) {
            Pintor existingPintor = optionalPintor.get();
            existingPintor.setNome(pintor.getNome());
            existingPintor.setId(pintor.getId());
            existingPintor.setNascimento(pintor.getNascimento());
            existingPintor.setPinturas(pintor.getPinturas());
            return pintorRepository.save(existingPintor);
        } else {
            throw new PintorNotUpdatedException("Nao foi possivel atualizar o Pintor");
        }
    }
}
