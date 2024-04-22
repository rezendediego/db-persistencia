package br.infnet.diegorezende.jdbctemplate;

import br.infnet.diegorezende.jdbctemplate.dao.JdbcTemplateMuseuDAOImpl;
import br.infnet.diegorezende.jdbctemplate.model.Museu;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Comparator;
import java.util.List;

@SpringBootApplication
public class JdbctemplateApplication {

	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(JdbctemplateApplication.class, args);

		Museu museu = context.getBean(Museu.class);
		museu.setNome("Masp");
		museu.setPais("Brasil");

		JdbcTemplateMuseuDAOImpl museuDAO = context.getBean(JdbcTemplateMuseuDAOImpl.class);

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


		//Fim
		System.out.println("\nFim Demonstração!!!");



	}

}
