package br.infnet.diegorezende.springdata.controller;

import br.infnet.diegorezende.springdata.model.Inventario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import br.infnet.diegorezende.springdata.service.InventarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

@RestController
@RequestMapping("/inventarios")
public class InventarioController {
    @Autowired
    private InventarioService inventarioService;

    @GetMapping
    public ResponseEntity<List<Inventario>> getAllInventarios() {
        List<Inventario> inventarios = inventarioService.getAllInventarios();
        return new ResponseEntity<>(inventarios, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Inventario> getInventarioById(@PathVariable Integer id) {
        Inventario inventario = inventarioService.getInventarioById(id);
        return new ResponseEntity<>(inventario, inventario != null ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }


    @DeleteMapping("/{id}")
    public void Delete(@PathVariable int id){
        inventarioService.deleteById(id);

    }
    @PostMapping
    public ResponseEntity<Inventario> Create(@RequestBody Inventario inventario){
        Inventario created = inventarioService.create(inventario);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Inventario> Update(@PathVariable int id, @RequestBody Inventario inventario){
        Inventario created = inventarioService.update(id,inventario);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

}
