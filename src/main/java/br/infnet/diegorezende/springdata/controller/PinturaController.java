package br.infnet.diegorezende.springdata.controller;

import br.infnet.diegorezende.springdata.model.Pintura;
import br.infnet.diegorezende.springdata.service.PinturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pinturas")
public class PinturaController {
    @Autowired
    private PinturaService pinturaService;

    @GetMapping
    public ResponseEntity<List<Pintura>> getAllPinturas() {
        List<Pintura> pinturas = pinturaService.getAllPinturas();
        return new ResponseEntity<>(pinturas, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pintura> getPinturaById(@PathVariable Integer id) {
        Pintura pintura = pinturaService.getPinturaById(id);
        return new ResponseEntity<>(pintura, pintura != null ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public void Delete(@PathVariable int id){
        pinturaService.deleteById(id);

    }
    @PostMapping
    public ResponseEntity<Pintura> Create(@RequestBody Pintura pintura){
        Pintura created = pinturaService.create(pintura);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Pintura> Update(@PathVariable int id, @RequestBody Pintura pintura){
        Pintura created = pinturaService.update(id,pintura);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

}
