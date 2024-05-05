package br.infnet.diegorezende.springdata.service;

import br.infnet.diegorezende.springdata.exception.PinturaNotFoundException;
import br.infnet.diegorezende.springdata.exception.PinturaNotUpdatedException;
import br.infnet.diegorezende.springdata.model.Pintura;
import br.infnet.diegorezende.springdata.repository.PinturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PinturaService {
    @Autowired
    private PinturaRepository pinturaRepository;

    public List<Pintura> getAllPinturas() {
        return pinturaRepository.findAll();
    }

    public Pintura getPinturaById(Integer id) {
        return pinturaRepository.findById(id).orElseThrow(PinturaNotFoundException::new);
    }

    public void deleteById(Integer id) {
        pinturaRepository.deleteById(id);
    }

    public Pintura create(Pintura pintura) {
        return pinturaRepository.save(pintura);
    }

    public Pintura update(Integer id, Pintura pintura) {
        Optional<Pintura> optionalPintura = pinturaRepository.findById(id);
        if (optionalPintura.isPresent()) {
            Pintura existingPintura = optionalPintura.get();
            existingPintura.setNome(pintura.getNome());
            existingPintura.setId(pintura.getId());
            existingPintura.setMuseu(pintura.getMuseu());
            existingPintura.setPintor(pintura.getPintor());
            existingPintura.setInventario(pintura.getInventario());
            return pinturaRepository.save(existingPintura);
        } else {
           throw new PinturaNotUpdatedException("Nao foi possivel realizar atualização");
        }
    }
}
