package br.infnet.diegorezende.springdata.service;

import br.infnet.diegorezende.springdata.exception.PinturaNotUpdatedException;
import br.infnet.diegorezende.springdata.model.Pintura;
import br.infnet.diegorezende.springdata.repository.PinturaRepository;
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

class PinturaServiceTest {

    @Mock
    private PinturaRepository pinturaRepository;

    @InjectMocks
    private PinturaService pinturaService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllPinturas() {
        // Prepare test data
        List<Pintura> pinturaList = new ArrayList<>();
        pinturaList.add(new Pintura("Pintura 1"));
        pinturaList.add(new Pintura("Pintura 2"));

        // Mock repository behavior
        when(pinturaRepository.findAll()).thenReturn(pinturaList);

        // Call service method
        List<Pintura> result = pinturaService.getAllPinturas();

        // Verify result
        assertEquals(2, result.size());
        assertEquals("Pintura 1", result.get(0).getNome());
        assertEquals("Pintura 2", result.get(1).getNome());
    }

    @Test
    void testGetPinturaById() {
        // Prepare test data
        Pintura pintura = new Pintura("Pintura 1");

        // Mock repository behavior
        when(pinturaRepository.findById(1)).thenReturn(Optional.of(pintura));

        // Call service method
        Pintura result = pinturaService.getPinturaById(1);

        // Verify result
        assertNotNull(result);
        assertEquals("Pintura 1", result.getNome());
    }

    @Test
    void testDeleteById() {
        // Call service method
        pinturaService.deleteById(1);

        // Verify repository method was called
        verify(pinturaRepository, times(1)).deleteById(1);
    }

    @Test
    void testCreate() {
        // Prepare test data
        Pintura pintura = new Pintura("Pintura 4");

        // Mock repository behavior
        when(pinturaRepository.save(any(Pintura.class))).thenReturn(pintura);

        // Call service method
        Pintura result = pinturaService.create(pintura);

        // Verify result
        assertNotNull(result);
        assertEquals("Pintura 4", result.getNome());
    }

    @Test
    void testUpdate() {
        // Prepare test data
        Pintura pintura = new Pintura("Pintura 5");

        // Mock repository behavior
        when(pinturaRepository.findById(1)).thenReturn(Optional.of(pintura));
        when(pinturaRepository.save(any(Pintura.class))).thenReturn(pintura);

        // Call service method
        Pintura result = pinturaService.update(1, pintura);

        // Verify result
        assertNotNull(result);
        assertEquals("Pintura 5", result.getNome());
    }

    @Test
    void testUpdateNotFound() {
        // Prepare test data
        Pintura pintura = new Pintura("Pintura 6");

        // Mock repository behavior
        when(pinturaRepository.findById(1)).thenReturn(Optional.empty());

        // Call service method and verify exception
        assertThrows(PinturaNotUpdatedException.class, () -> {
            pinturaService.update(1, pintura);
        });
    }
}