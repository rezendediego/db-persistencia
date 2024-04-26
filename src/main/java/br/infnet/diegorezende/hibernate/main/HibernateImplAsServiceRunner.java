package br.infnet.diegorezende.hibernate.main;

import br.infnet.diegorezende.hibernate.model.Museu;
import br.infnet.diegorezende.hibernate.model.Pintor;
import br.infnet.diegorezende.hibernate.model.Pintura;
import br.infnet.diegorezende.hibernate.service.MuseuServiceHibernate;
import br.infnet.diegorezende.hibernate.service.PintorServiceHibernate;
import br.infnet.diegorezende.hibernate.service.PinturaServiceHibernate;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class HibernateImplAsServiceRunner {
    public static void main(String[] args) {

        /*
        * O Hibernate foi utilizado para composição de classes Service
        * As funcoes CRUD utilizadas abaixo, demonstram o funcionamento
        * do hibernate envelopado por servicos
        * */

        //Set up Objetos para Teste
        Museu museuSoaresReis= new Museu("Museu Nacional Soares dos Reis","Portugal");
        Pintor pintorMarquesDeOliveira = new Pintor("João Marques de Oliveira", Date.valueOf("1853-08-23"));


        //Import Serviços
        PintorServiceHibernate pintorServiceHibernate = new PintorServiceHibernate();
        MuseuServiceHibernate museuServiceHibernate =  new MuseuServiceHibernate();
        PinturaServiceHibernate pinturaServiceHibernate = new PinturaServiceHibernate();


        List<Pintor> pintores= pintorServiceHibernate.buscarTodos();
        List<Pintura> pinturas= pinturaServiceHibernate.buscarTodos();
        List<Museu> museus= museuServiceHibernate.buscarTodas();

        System.out.println("\n\nLista de Pintores: " + pintores);
        System.out.println("\n\nLista de Pinturas: " + pinturas);
        System.out.println("\n\nLista de Museus: " + museus);

        //Criar novas Pinturas, Pintor e Museu
        pintorServiceHibernate.salvar(pintorMarquesDeOliveira);
        museuServiceHibernate.salvar(museuSoaresReis);

        Pintura pinturainteriorCostureiras = new Pintura("Interior (Costureiras trabalhando)",pintorMarquesDeOliveira,museuSoaresReis);
        Pintura pinturaRetratoSoaresReis = new Pintura("Retrato de Soares dos Reis",pintorMarquesDeOliveira,museuSoaresReis);
        Pintura pinturaCefaloProcris = new Pintura("Céfalo e Prócris",pintorMarquesDeOliveira,museuSoaresReis);

        pinturaServiceHibernate.salvar(pinturainteriorCostureiras);
        pinturaServiceHibernate.salvar(pinturaRetratoSoaresReis);
        pinturaServiceHibernate.salvar(pinturaCefaloProcris);


        System.out.println("\n\nLista de Pintores com pintor adicionado: " + pintores);
        System.out.println("\n\nLista de Pinturas com pinturas adicionadas: " + pinturas);

        List<Pintura> pinturasMarques = new ArrayList<>();
        pinturasMarques.add(pinturainteriorCostureiras);
        pinturasMarques.add(pinturaRetratoSoaresReis);
        pinturasMarques.add(pinturaCefaloProcris);

        System.out.println("\n\nLista de Museus com um novo museu adicionado: " + museus);

        pintorMarquesDeOliveira.setPinturas(pinturasMarques);
        pintorServiceHibernate.atualizar(pintorMarquesDeOliveira);

        System.out.println("\n\nLista de Pintores com pintor adicionado: " + pintorServiceHibernate.buscarTodos());

        pinturaServiceHibernate.excluir(pinturaRetratoSoaresReis);
        System.out.println("\n\nLista de Pinturas com pinturaRetratoSoaresReis apagada: " + pinturaServiceHibernate.buscarTodos());

    }
}
