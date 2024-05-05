package br.infnet.diegorezende.springdata.controller;

import br.infnet.diegorezende.springdata.model.Pintor;
import br.infnet.diegorezende.springdata.service.PintorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pintores")
public class PintorController {
    @Autowired
    private PintorService pintorService;

    @GetMapping
    public ResponseEntity<List<Pintor>> getAllPintores() {
        List<Pintor> pintores = pintorService.getAllPintores();
        return new ResponseEntity<>(pintores, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pintor> getPintorById(@PathVariable Integer id) {
        Pintor pintor = pintorService.getPintorById(id);
        return new ResponseEntity<>(pintor, pintor != null ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public void Delete(@PathVariable int id){
        pintorService.deleteById(id);

    }
    @PostMapping
    public ResponseEntity<Pintor> Create(@RequestBody Pintor pintor){
        Pintor created = pintorService.create(pintor);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Pintor> Update(@PathVariable int id, @RequestBody Pintor pintor){
        Pintor created = pintorService.update(id,pintor);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }
}
