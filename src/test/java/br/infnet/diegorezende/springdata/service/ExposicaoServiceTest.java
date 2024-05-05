package br.infnet.diegorezende.springdata.service;

import br.infnet.diegorezende.springdata.exception.ExposicaoNotUpdatedException;
import br.infnet.diegorezende.springdata.model.Exposicao;
import br.infnet.diegorezende.springdata.repository.ExposicaoRepository;
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

class ExposicaoServiceTest {

    @Mock
    private ExposicaoRepository exposicaoRepository;

    @InjectMocks
    private ExposicaoService exposicaoService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllExposicoes() {
        // Prepare test data
        List<Exposicao> exposicaoList = new ArrayList<>();
        exposicaoList.add(new Exposicao(1, "Exposicao 1"));
        exposicaoList.add(new Exposicao(2, "Exposicao 2"));

        // Mock repository behavior
        when(exposicaoRepository.findAll()).thenReturn(exposicaoList);

        // Call service method
        List<Exposicao> result = exposicaoService.getAllExposicoes();

        // Verify result
        assertEquals(2, result.size());
        assertEquals("Exposicao 1", result.get(0).getNome());
        assertEquals("Exposicao 2", result.get(1).getNome());
    }

    @Test
    void testGetExposicaoById() {
        // Prepare test data
        Exposicao exposicao = new Exposicao(1, "Exposicao 1");

        // Mock repository behavior
        when(exposicaoRepository.findById(1)).thenReturn(Optional.of(exposicao));

        // Call service method
        Exposicao result = exposicaoService.getExposicaoById(1);

        // Verify result
        assertNotNull(result);
        assertEquals("Exposicao 1", result.getNome());
    }

    @Test
    void testDeleteById() {
        // Call service method
        exposicaoService.deleteById(1);

        // Verify repository method was called
        verify(exposicaoRepository, times(1)).deleteById(1);
    }

    @Test
    void testCreate() {
        // Prepare test data
        Exposicao exposicao = new Exposicao(1, "Exposicao 1");

        // Mock repository behavior
        when(exposicaoRepository.save(any(Exposicao.class))).thenReturn(exposicao);

        // Call service method
        Exposicao result = exposicaoService.create(exposicao);

        // Verify result
        assertNotNull(result);
        assertEquals(1, result.getId());
        assertEquals("Exposicao 1", result.getNome());
    }

    @Test
    void testUpdate() {
        // Prepare test data
        Exposicao exposicao = new Exposicao(1, "Exposicao 1");

        // Mock repository behavior
        when(exposicaoRepository.findById(1)).thenReturn(Optional.of(exposicao));
        when(exposicaoRepository.save(any(Exposicao.class))).thenReturn(exposicao);

        // Call service method
        Exposicao result = exposicaoService.update(1, exposicao);

        // Verify result
        assertNotNull(result);
        assertEquals(1, result.getId());
        assertEquals("Exposicao 1", result.getNome());
    }

    @Test
    void testUpdateNotFound() {
        // Prepare test data
        Exposicao exposicao = new Exposicao(1, "Exposicao 1");

        // Mock repository behavior
        when(exposicaoRepository.findById(1)).thenReturn(Optional.empty());

        // Call service method and verify exception
        assertThrows(ExposicaoNotUpdatedException.class, () -> {
            exposicaoService.update(1, exposicao);
        });
    }

}