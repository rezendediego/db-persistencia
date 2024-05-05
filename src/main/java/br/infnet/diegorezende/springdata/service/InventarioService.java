package br.infnet.diegorezende.springdata.service;
import br.infnet.diegorezende.springdata.exception.InventarioNotFoundException;
import br.infnet.diegorezende.springdata.exception.InventarioNotUpdatedException;
import br.infnet.diegorezende.springdata.model.Inventario;
import br.infnet.diegorezende.springdata.repository.InventarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InventarioService {
    @Autowired
    private InventarioRepository inventarioRepository;

    public List<Inventario> getAllInventarios() {
        return inventarioRepository.findAll();
    }

    public Inventario getInventarioById(Integer id) {
        return inventarioRepository.findById(id).orElseThrow(InventarioNotFoundException::new);
    }

    public void deleteById(Integer id) {
        inventarioRepository.deleteById(id);
    }

    public Inventario create(Inventario inventario) {
        return inventarioRepository.save(inventario);
    }

    public Inventario update(Integer id, Inventario inventario) {
        Optional<Inventario> optionalInventario = inventarioRepository.findById(id);
        if (optionalInventario.isPresent()) {
            Inventario existingInventario = optionalInventario.get();
            existingInventario.setId(inventario.getId());
            existingInventario.setCodigo(inventario.getCodigo());
            existingInventario.setPintura(inventario.getPintura());
            return inventarioRepository.save(existingInventario);
        } else {
            throw new InventarioNotUpdatedException("Nao foi possivel realizar atualização");
        }
    }
}
