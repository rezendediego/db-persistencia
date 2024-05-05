package br.infnet.diegorezende.springdata.service;

import br.infnet.diegorezende.springdata.exception.PintorNotFoundException;
import br.infnet.diegorezende.springdata.exception.PintorNotUpdatedException;
import br.infnet.diegorezende.springdata.model.Pintor;
import br.infnet.diegorezende.springdata.repository.PintorRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class PintorServiceTest {

    @Mock
    private PintorRepository pintorRepository;

    @InjectMocks
    private PintorService pintorService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllPintores() {
        // Prepare test data
        List<Pintor> pintorList = new ArrayList<>();
        pintorList.add(new Pintor("Pintor Teste 1", new Date(1898, 11, 21)));
        pintorList.add(new Pintor("Pintor Teste 2", new Date(1899, 12, 22)));

        // Mock repository behavior
        when(pintorRepository.findAll()).thenReturn(pintorList);

        // Call service method
        List<Pintor> result = pintorService.getAllPintores();

        // Verify result
        assertEquals(2, result.size());
        assertEquals("Pintor Teste 1", result.get(0).getNome());
        assertEquals("Pintor Teste 2", result.get(1).getNome());
    }

    @Test
    void testGetPintorById() {
        // Prepare test data
        Pintor pintor = new Pintor("Pintor Teste 3", new Date(1900, 1, 23));

        // Mock repository behavior
        when(pintorRepository.findById(1)).thenReturn(Optional.of(pintor));

        // Call service method
        Pintor result = pintorService.getPintorById(1);

        // Verify result
        assertNotNull(result);
        assertEquals("Pintor Teste 3", result.getNome());
    }

    @Test
    void testDeleteById() {
        // Call service method
        pintorService.deleteById(1);

        // Verify repository method was called
        verify(pintorRepository, times(1)).deleteById(1);
    }

    @Test
    void testCreate() {
        // Prepare test data
        Pintor pintor = new Pintor("Pintor Teste 4", new Date(1901, 2, 24));

        // Mock repository behavior
        when(pintorRepository.save(any(Pintor.class))).thenReturn(pintor);

        // Call service method
        Pintor result = pintorService.create(pintor);

        // Verify result
        assertNotNull(result);
        assertEquals("Pintor Teste 4", result.getNome());
    }

    @Test
    void testUpdate() {
        // Prepare test data
        Pintor pintor = new Pintor("Pintor Teste 5", new Date(1903, 3, 25));

        // Mock repository behavior
        when(pintorRepository.findById(1)).thenReturn(Optional.of(pintor));
        when(pintorRepository.save(any(Pintor.class))).thenReturn(pintor);

        // Call service method
        Pintor result = pintorService.update(1, pintor);

        // Verify result
        assertNotNull(result);
        assertEquals("Pintor Teste 5", result.getNome());
    }

    @Test
    void testUpdateNotFound() {
        // Prepare test data
        Pintor pintor = new Pintor("Pintor Teste 6", new Date(1904, 4, 26));

        // Mock repository behavior
        when(pintorRepository.findById(1)).thenReturn(Optional.empty());

        // Call service method and verify exception
        assertThrows(PintorNotUpdatedException.class, () -> {
            pintorService.update(1, pintor);
        });
    }
}