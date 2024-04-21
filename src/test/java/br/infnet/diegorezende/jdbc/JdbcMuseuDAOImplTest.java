package br.infnet.diegorezende.jdbc;

import br.infnet.diegorezende.jdbc.dao.JdbcMuseuDAOImpl;
import br.infnet.diegorezende.jdbc.model.Museu;
import br.infnet.diegorezende.jdbc.dao.MuseuDAO;
import org.junit.jupiter.api.*;


import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class JdbcMuseuDAOImplTest {
    private MuseuDAO dao = new JdbcMuseuDAOImpl();
    @Test
    @Order(1)
    public void findAll() throws Exception{
        List<Museu> museus = dao.findAll();
        System.out.println(museus);
        assertTrue(dao.findAll().size()>0);
    }
    @Test
    @Order(2)
    public void findById() throws Exception{
       for(Long id : dao.getIds()){
            assertNotNull(dao.findById(id));
        }
    }
    @Test
    @Order(3)
    public void save() throws Exception{
        Museu museu = new Museu("Musée Du Louvre","França");
        Long idGerado = dao.save(museu);
        System.out.println("Museu salvo: " +museu+" com id gerado: "+ idGerado);
        assertNotNull(idGerado);
    }

    @Test
    @Order(4)
    public void update() throws Exception{
        Comparator<Long> idComparator = Comparator.naturalOrder();
        Long idGerado = dao.getIds().stream().max(idComparator).orElse(1L);
        Museu museuSalvo = dao.findById(idGerado);
        Museu museuParaAtualizar = new Museu();
        museuParaAtualizar.setId(museuSalvo.getId());
        museuParaAtualizar.setNome(museuSalvo.getNome());
        museuParaAtualizar.setPais(museuSalvo.getPais());
        museuParaAtualizar.setPais("República França");
        System.out.println("Museu atualizado: " + museuParaAtualizar + " é diferente do museuAnterior: " + museuSalvo );
        assertNotEquals(museuParaAtualizar,museuSalvo);
        assertEquals(museuParaAtualizar.getId(),museuSalvo.getId());
    }
    @Test
    @Order(5)
    public void delete() throws Exception{
        Long maxId = dao.getIds().stream()
                .mapToLong(Long::longValue)
                .max()
                .orElse(1);
        System.out.println("maxId = " + maxId);
        Museu museu = dao.findById(maxId);
        dao.deleteById(museu);
        assertNull(dao.findById(maxId));
    }
    @Test
    @Order(6)
    public void getIds() throws Exception{
        System.out.println(dao.getIds());
    }
}
