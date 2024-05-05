package br.infnet.diegorezende.springdata.controller;

import br.infnet.diegorezende.springdata.model.Museu;
import br.infnet.diegorezende.springdata.service.MuseuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/museus")
public class MuseuController {
    @Autowired
    private MuseuService museuService;

    @GetMapping
    public ResponseEntity<List<Museu>> getAllMuseus() {
        List<Museu> museus = museuService.getAllMuseus();
        return new ResponseEntity<>(museus, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Museu> getMuseuById(@PathVariable Integer id) {
        Museu museu = museuService.getMuseuById(id);
        return new ResponseEntity<>(museu, museu != null ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public void Delete(@PathVariable int id){
        museuService.deleteById(id);

    }
    @PostMapping
    public ResponseEntity<Museu> Create(@RequestBody Museu museu){
        Museu created = museuService.create(museu);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Museu> Update(@PathVariable int id, @RequestBody Museu museu){
        Museu created = museuService.update(id,museu);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }
}
