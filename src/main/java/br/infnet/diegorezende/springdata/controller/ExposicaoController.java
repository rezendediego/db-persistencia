package br.infnet.diegorezende.springdata.controller;

import br.infnet.diegorezende.springdata.model.Exposicao;
import br.infnet.diegorezende.springdata.service.ExposicaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/exposicoes")
public class ExposicaoController {
    @Autowired
    private ExposicaoService exposicaoService;

    @GetMapping
    public ResponseEntity<List<Exposicao>> getAllExposicoes() {
        List<Exposicao> exposicoes = exposicaoService.getAllExposicoes();
        return new ResponseEntity<>(exposicoes, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Exposicao> getExposicaoById(@PathVariable Integer id) {
        Exposicao exposicao = exposicaoService.getExposicaoById(id);
        return new ResponseEntity<>(exposicao, exposicao != null ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }


    @DeleteMapping("/{id}")
    public void Delete(@PathVariable int id){
        exposicaoService.deleteById(id);

    }
    @PostMapping
    public ResponseEntity<Exposicao> Create(@RequestBody Exposicao exposicao){
        Exposicao created = exposicaoService.create(exposicao);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Exposicao> Update(@PathVariable int id, @RequestBody Exposicao exposicao){
        Exposicao created = exposicaoService.update(id,exposicao);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

}
