package br.infnet.diegorezende.springdata.service;
import br.infnet.diegorezende.springdata.exception.MuseuNotFoundException;
import br.infnet.diegorezende.springdata.exception.MuseuNotUpdatedException;
import br.infnet.diegorezende.springdata.model.Museu;
import br.infnet.diegorezende.springdata.repository.MuseuRepository;
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


class MuseuServiceTest {

    @Mock
    private MuseuRepository museuRepository;

    @InjectMocks
    private MuseuService museuService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllMuseus() {
        // Prepare test data
        List<Museu> museuList = new ArrayList<>();
        museuList.add(new Museu(1, "Museu 1", "Pais 1"));
        museuList.add(new Museu(2, "Museu 2", "Pais 2"));

        // Mock repository behavior
        when(museuRepository.findAll()).thenReturn(museuList);

        // Call service method
        List<Museu> result = museuService.getAllMuseus();

        // Verify result
        assertEquals(2, result.size());
        assertEquals("Museu 1", result.get(0).getNome());
        assertEquals("Pais 1", result.get(0).getPais());
        assertEquals("Museu 2", result.get(1).getNome());
        assertEquals("Pais 2", result.get(1).getPais());
    }

    @Test
    void testGetMuseuById() {
        // Prepare test data
        Museu museu = new Museu(1, "Museu 1", "Pais 1");

        // Mock repository behavior
        when(museuRepository.findById(1)).thenReturn(Optional.of(museu));

        // Call service method
        Museu result = museuService.getMuseuById(1);

        // Verify result
        assertNotNull(result);
        assertEquals("Museu 1", result.getNome());
        assertEquals("Pais 1", result.getPais());
    }

    @Test
    void testDeleteById() {
        // Call service method
        museuService.deleteById(1);

        // Verify repository method was called
        verify(museuRepository, times(1)).deleteById(1);
    }

    @Test
    void testCreate() {
        // Prepare test data
        Museu museu = new Museu(1, "Museu 1", "Pais 1");

        // Mock repository behavior
        when(museuRepository.save(any(Museu.class))).thenReturn(museu);

        // Call service method
        Museu result = museuService.create(museu);

        // Verify result
        assertNotNull(result);
        assertEquals(1, result.getId());
        assertEquals("Museu 1", result.getNome());
        assertEquals("Pais 1", result.getPais());
    }

    @Test
    void testUpdate() {
        // Prepare test data
        Museu museu = new Museu(1, "Museu 1", "Pais 1");

        // Mock repository behavior
        when(museuRepository.findById(1)).thenReturn(Optional.of(museu));
        when(museuRepository.save(any(Museu.class))).thenReturn(museu);

        // Call service method
        Museu result = museuService.update(1, museu);

        // Verify result
        assertNotNull(result);
        assertEquals(1, result.getId());
        assertEquals("Museu 1", result.getNome());
        assertEquals("Pais 1", result.getPais());
    }

    @Test
    void testUpdateNotFound() {
        // Prepare test data
        Museu museu = new Museu(1, "Museu 1", "Pais 1");

        // Mock repository behavior
        when(museuRepository.findById(1)).thenReturn(Optional.empty());

        // Call service method and verify exception
        assertThrows(MuseuNotUpdatedException.class, () -> {
            museuService.update(1, museu);
        });
    }
}