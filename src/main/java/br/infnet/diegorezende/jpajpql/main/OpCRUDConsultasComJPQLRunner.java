package br.infnet.diegorezende.jpajpql.main;

import br.infnet.diegorezende.jpajpql.model.*;
import br.infnet.diegorezende.jpajpql.repository.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OpCRUDConsultasComJPQLRunner {

    public static void main(String[] args) {
        // Testando ExposicaoRepository
        ExposicaoJPAJPQLRepository exposicaoJPAJPQLRepository = new ExposicaoJPAJPQLRepository();
        testarExposicaoRepository(exposicaoJPAJPQLRepository);

        // Testando MuseuRepository
        MuseuJPAJPQLRepository museuJPAJPQLRepository = new MuseuJPAJPQLRepository();
        testarMuseuRepository(museuJPAJPQLRepository);

        // Testando PintorRepository
        PintorJPAJPQLRepository pintorJPAJPQLRepository = new PintorJPAJPQLRepository();
        testarPintorRepository(pintorJPAJPQLRepository);

        // Testando InventarioRepository
        InventarioJPAJPQLRepository inventarioJPAJPQLRepository = new InventarioJPAJPQLRepository();
        testarInventarioRepository(inventarioJPAJPQLRepository);


        // Testando PinturaRepository
        PinturaJPAJPQLRepository pinturaJPAJPQLRepository = new PinturaJPAJPQLRepository();
        testarPinturaRepository(pinturaJPAJPQLRepository);
    }

    private static void testarExposicaoRepository(ExposicaoJPAJPQLRepository exposicaoJPAJPQLRepository) {
        System.out.println("Testando ExposicaoRepository...");
        // Utilizando os métodos de ExposicaoRepository
        Exposicao exposicao = exposicaoJPAJPQLRepository.buscarPorId(1L);
        List<Exposicao> todasExposicoes = exposicaoJPAJPQLRepository.buscarTodas();
        Exposicao expoCriado = new Exposicao("Expo Magritte");
        exposicaoJPAJPQLRepository.salvar(expoCriado);
        expoCriado.setNome("Expo Novidades");
        exposicaoJPAJPQLRepository.atualizar(expoCriado);
        exposicaoJPAJPQLRepository.excluir(expoCriado);
        System.out.println("ExposicaoRepository testado com sucesso.");
    }

    private static void testarInventarioRepository(InventarioJPAJPQLRepository inventarioJPAJPQLRepository) {
        System.out.println("Testando InventarioRepository...");
        // Utilizando os métodos de InventarioRepository
        Inventario inventario = inventarioJPAJPQLRepository.buscarPorId(1L);
        List<Inventario> todosInventarios = inventarioJPAJPQLRepository.buscarTodas();
        Inventario inventarioCriado = new Inventario(20005);
        inventarioJPAJPQLRepository.salvar(inventarioCriado);
        inventarioCriado.setCodigo(10005);
        inventarioJPAJPQLRepository.atualizar(inventarioCriado);
        inventarioJPAJPQLRepository.excluir(inventarioCriado);
        System.out.println("InventarioRepository testado com sucesso.");
    }

    private static void testarMuseuRepository(MuseuJPAJPQLRepository museuRepository) {
        System.out.println("Testando MuseuRepository...");
        // Utilizando os métodos de MuseuRepository
        Museu museu = museuRepository.buscarPorId(1L);
        List<Museu> todosMuseus = museuRepository.buscarTodos();
        List<Museu> museusPorPais = museuRepository.buscarMuseuPorPais("Brasil");
        List<Museu> museusPorExposicao = museuRepository.buscarMuseusPorExposicao("Exposição Teste");
        List<Museu> museusPorPintura = museuRepository.buscarMuseusPorPintura("Mona Lisa");
        List<Museu> museusPorPinturaENaoPintor = museuRepository.buscarMuseusPorPinturaENaoPintor("Leonardo da Vinci");
        List<Museu> museusPorPinturaEPintor = museuRepository.buscarMuseusPorPinturaEPintor("A Noite Estrelada", "Van Gogh");

        Museu museuCriado = new Museu("The Musée Magritte Museum","Belgica");
        museuRepository.salvar(museuCriado);
        museuCriado.setNome("Museu Basel");
        museuRepository.atualizar(museuCriado);
        museuRepository.excluir(museuCriado);
        System.out.println("MuseuRepository testado com sucesso.");
    }

    private static void testarPintorRepository(PintorJPAJPQLRepository pintorRepository) {
        System.out.println("Testando PintorRepository...");
        // Utilizando os métodos de PintorRepository
        Pintor pintor = pintorRepository.buscarPorId(1L);
        List<Pintor> todosPintores = pintorRepository.buscarTodos();
        List<Pintor> pintoresAntesData = pintorRepository.buscarPintoresNascidosAntesData(new Date());
        List<Pintor> pintoresComMaisPinturas = pintorRepository.buscarPintoresComMaisPinturasQue(10);
        List<Pintor> pintoresComPinturasEmMuseus = pintorRepository.buscarPintoresComPinturasEmMuseusPais("Itália");
        List<Pintor> pintoresComPinturasEmMultiplosMuseus = pintorRepository.buscarPintoresComPinturasEmMultiplosMuseus();

        Pintor pintorCriado = new Pintor("Rene Magritte",new Date(1898, 11, 21));
        pintorRepository.salvar(pintorCriado);
        pintorCriado.setNome("Picasso");
        pintorRepository.atualizar(pintorCriado);
        pintorRepository.excluir(pintorCriado);
        System.out.println("PintorRepository testado com sucesso.");
    }

    private static void testarPinturaRepository(PinturaJPAJPQLRepository pinturaRepository) {
        System.out.println("Testando PinturaRepository...");

        // Utilizando os métodos de PinturaRepository
        Pintura pintura = pinturaRepository.buscarPorId(1L);
        List<Pintura> todasPinturas = pinturaRepository.buscarTodas();
        List<Pintura> pinturasPorPintoresAposData = pinturaRepository.buscarPinturasPorPintoresNascidosAposData(new Date());
        List<Pintura> pinturasPorNomeEPintor = pinturaRepository.buscarPinturasPorNomeEPintor("Mona Lisa", "Leonardo da Vinci");
        List<Pintura> pinturasPorCodigosInventario = pinturaRepository.buscarPinturasPorCodigosInventario(new ArrayList<>());
        List<Pintura> pinturasPorNomeOuCriadasAposData = pinturaRepository.buscarPinturasPorNomeOuCriadasAposData("Starry Night", new Date());
        List<Pintura> pinturasPorCodigosInventarioFaixa = pinturaRepository.buscarPinturasPorCodigosInventarioFaixa(100, 200);

        Pintor pintorMagritte = new Pintor("Rene Magritte",new Date(1898, 11, 21));
        PintorJPAJPQLRepository pintorRepository = new PintorJPAJPQLRepository();
        pintorRepository.salvar(pintorMagritte);

        Museu museuMagritte = new Museu("The Musée Magritte Museum","Belgica");
        MuseuJPAJPQLRepository museuRepository = new MuseuJPAJPQLRepository();
        museuRepository.salvar(museuMagritte);


        Pintura pinturaCriada= new Pintura("Découverte",pintorMagritte,museuMagritte);
        pinturaRepository.salvar(pinturaCriada);
        pinturaCriada.setNome("Guernica");
        pinturaRepository.atualizar(pinturaCriada);
        pinturaRepository.excluir(pinturaCriada);
        System.out.println("PinturaRepository testado com sucesso.");
    }
}
