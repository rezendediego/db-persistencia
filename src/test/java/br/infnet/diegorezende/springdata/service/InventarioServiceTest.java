package br.infnet.diegorezende.springdata.service;

import br.infnet.diegorezende.springdata.exception.InventarioNotUpdatedException;
import br.infnet.diegorezende.springdata.model.Inventario;
import br.infnet.diegorezende.springdata.model.Pintura;
import br.infnet.diegorezende.springdata.repository.InventarioRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class InventarioServiceTest {

    @Mock
    private InventarioRepository inventarioRepository;

    @InjectMocks
    private InventarioService inventarioService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllInventarios() {
        // Prepare test data
        List<Inventario> inventarioList = new ArrayList<>();
        inventarioList.add(new Inventario(1, 50000, new Pintura("Pintura 1")));
        inventarioList.add(new Inventario(2, 50001, new Pintura("Pintura 2")));

        // Mock repository behavior
        when(inventarioRepository.findAll()).thenReturn(inventarioList);

        // Call service method
        List<Inventario> result = inventarioService.getAllInventarios();

        // Verify result
        assertEquals(2, result.size());
        assertEquals(50000, result.get(0).getCodigo());
        assertEquals("Pintura 1", result.get(0).getPintura().getNome());
        assertEquals(50001, result.get(1).getCodigo());
        assertEquals("Pintura 2", result.get(1).getPintura().getNome());
    }

    @Test
    void testGetInventarioById() {
        // Prepare test data
        Inventario inventario = new Inventario(1, 50002, new Pintura("Pintura 3"));

        // Mock repository behavior
        when(inventarioRepository.findById(1)).thenReturn(Optional.of(inventario));

        // Call service method
        Inventario result = inventarioService.getInventarioById(1);

        // Verify result
        assertNotNull(result);
        assertEquals(50002, result.getCodigo());
        assertEquals("Pintura 3", result.getPintura().getNome());
    }

    @Test
    void testDeleteById() {
        // Call service method
        inventarioService.deleteById(1);

        // Verify repository method was called
        verify(inventarioRepository, times(1)).deleteById(1);
    }

    @Test
    void testCreate() {
        // Prepare test data
        Inventario inventario = new Inventario(1, 50013, new Pintura("Pintura 1"));

        // Mock repository behavior
        when(inventarioRepository.save(any(Inventario.class))).thenReturn(inventario);

        // Call service method
        Inventario result = inventarioService.create(inventario);

        // Verify result
        assertNotNull(result);
        assertEquals(1, result.getId());
        assertEquals(50013, result.getCodigo());
        assertEquals("Pintura 1", result.getPintura().getNome());
    }

    @Test
    void testUpdate() {
        // Prepare test data
        Inventario inventario = new Inventario(1, 50003, new Pintura("Pintura 10"));

        // Mock repository behavior
        when(inventarioRepository.findById(1)).thenReturn(Optional.of(inventario));
        when(inventarioRepository.save(any(Inventario.class))).thenReturn(inventario);

        // Call service method
        Inventario result = inventarioService.update(1, inventario);

        // Verify result
        assertNotNull(result);
        assertEquals(1, result.getId());
        assertEquals(50003, result.getCodigo());
        assertEquals("Pintura 10", result.getPintura().getNome());
    }

    @Test
    void testUpdateNotFound() {
        // Prepare test data
        Inventario inventario = new Inventario(1, 50005, new Pintura("Pintura 11"));

        // Mock repository behavior
        when(inventarioRepository.findById(1)).thenReturn(Optional.empty());

        // Call service method and verify exception
        assertThrows(InventarioNotUpdatedException.class, () -> {
            inventarioService.update(1, inventario);
        });
    }
}