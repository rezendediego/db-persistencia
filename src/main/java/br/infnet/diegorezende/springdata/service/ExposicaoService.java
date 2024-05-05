package br.infnet.diegorezende.springdata.service;

import br.infnet.diegorezende.springdata.exception.ExposicaoNotFoundException;
import br.infnet.diegorezende.springdata.exception.ExposicaoNotUpdatedException;
import br.infnet.diegorezende.springdata.model.Exposicao;
import br.infnet.diegorezende.springdata.repository.ExposicaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExposicaoService {
    @Autowired
    private ExposicaoRepository exposicaoRepository;

    public List<Exposicao> getAllExposicoes() {
        return exposicaoRepository.findAll();
    }

    public Exposicao getExposicaoById(Integer id) {
        return exposicaoRepository.findById(id).orElseThrow(ExposicaoNotFoundException::new);
    }

    public void deleteById(Integer id) {
        exposicaoRepository.deleteById(id);
    }

    public Exposicao create(Exposicao exposicao) {
        return exposicaoRepository.save(exposicao);
    }

    public Exposicao update(Integer id, Exposicao exposicao) {
        Optional<Exposicao> optionalExposicao = exposicaoRepository.findById(id);
        if (optionalExposicao.isPresent()) {
            Exposicao existingExposicao = optionalExposicao.get();
            existingExposicao.setNome(exposicao.getNome());
            existingExposicao.setId(exposicao.getId());
            existingExposicao.setMuseus(exposicao.getMuseus());
            return exposicaoRepository.save(existingExposicao);
        } else {
            throw new ExposicaoNotUpdatedException("Nao foi possivel realizar atualização");
        }
    }

}
