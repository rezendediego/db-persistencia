package br.infnet.diegorezende.jdbc.main;

import br.infnet.diegorezende.jdbc.dao.JdbcMuseuDAOImpl;
import br.infnet.diegorezende.jdbc.dao.MuseuDAO;
import br.infnet.diegorezende.jdbc.model.Museu;

import java.util.Comparator;
import java.util.List;

public class JdbcRunner {

    public static void main(String[] args) {
        MuseuDAO museuDAO = new JdbcMuseuDAOImpl();

        //Preparação de operações JDBC CRUD
        Museu museu = new Museu();
        museu.setNome("Masp");
        museu.setPais("Brasil");

        //Criar
        museuDAO.save(museu);

        //Ler depois de buscar por id
        //último ID gerado para museu mais recente salvo anteriormente
        Comparator<Long> idComparator = Comparator.naturalOrder();
        Long idGerado = museuDAO.getIds().stream().max(idComparator).orElse(1L);
        Museu museuSalvo = museuDAO.findById(idGerado);
        System.out.println("Museu salvo na ultima operacao: "+ museuSalvo);

        //Atualização
        museuSalvo.setNome("MASP - Museu de Arte de São Paulo Assis Chateaubriand");
        museuDAO.update(museuSalvo);

        //Encontrar Todos
        List<Museu> museuList = museuDAO.findAll();
        System.out.println(museuList);

        //Apagar por id
        museuDAO.deleteById(museuSalvo);

        //Comprovação de Apagamento por id
        System.out.println("Lista de Museus depois apagamento por id: " + museuDAO.findAll());

        //Apagar todos
        museuDAO.deleteAll();
        System.out.println("Lista de Museus depois apagamento de todos: " + museuDAO.findAll());
        System.out.println("\nFim Demonstração!!!");

    }

}
