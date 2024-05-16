#### Projeto Individual Disciplina Banco de Dados e Persistência em Java [23E4_2] - Pós-Graduação Engenharia de Software com Java | Instituto Infnet ####

**Aluno: Diego Henrique Cornelio de Rezende**

-------------------------------------------------------------------
#### ORGANIZAÇÃO DAS SOLUÇÕES - PROJETO PERSISTÊNCIA COM JDBC, JPA/HIBERNATE, SPRING DATA

> Nota Informativa
> - O banco de dados utilizado MySQL através do MYSQL Workbench.
>
> - Para verificação, favor habilitar o workbench e inicializar o App como Java Application
>
> - Cada Solução está em um branch próprio.


#### BRANCH HIBERNATE
![Diagrama Hibernate](/imagens/hibernate.png)

Demonstração da modelagem de dados ORM com uso de HIBERNATE para armazenar e realizar operações CRUD em um objeto que se relaciona com outros objetos.

```
Atividade proposta na Aula 03:

O objetivo desta tarefa é que consigam estabelecer operações no banco de dados configurado anteriormente, o que será necessário
para o projeto do curso.

Usando o exemplo de conexão JDBC da tarefa anterior (ou outra, se preferir ou caso tenha mudado de ideia sobre o projeto que
pretende realizar), faça a configuracão do Hibernate e crie o POJO (classe da entidade - por exemplo, Livro e Editora em nosso
exemplo), a classe de serviço (em nosso exemplo, LivroService e EditoraService) e uma classe de teste para executar as operações
básicas de CRUD (em nosso exemplo, HibernateService).

Faça pelo menos um exemplo usando anotações JPA. Se estiver testando mais de uma entidade, fique à vontade para usar um arquivo
hbm.xml para algum outro.

```



#### BRANCH JDBC
![Diagrama JDBC](/imagens/diagrama-jdbc.png)

```
Atividade proposta na Aula 02:

Demonstração do uso de JDBC e JDBC TEMPLATE para armazenar e realizar operações CRUD em um objeto.

O objetivo desta tarefa é que consigam estabelecer uma conexão do Java com um banco de dados, o que será necessário para o
projeto do curso.

Crie um exemplo de conexão JDBC usando Java com o banco de dados de sua escolha (em nossos exemplos, foi usado o MySQL).
Crie um banco de dados com ao menos uma tabela para ser acessada pelo código em Java. Pode fazer algo já relacionado ao
projeto que pretende fazer, cujo tema é livre mas que deverá atender aos requisitos técnicos do projeto.

Teste a conexão ao banco de dados no seu código Java com ao menos uma consulta (instrução SELECT usando o método
executeQuery da classe Statement) e ao menos uma instrução modificadora do banco de dados (instrução UPDATE, INSERT ou
DELETE usando o método executeUpdate da classe Statement).
```

#### BRANCH JDBC-TEMPLATE
![Diagrama JDBC](/imagens/diagrama-jdbc.png)

Demonstração do uso de JDBC e JDBC TEMPLATE para armazenar e realizar operações CRUD em um objeto.

```
2° versao atividade proposta na Aula 02:
```

#### BRANCH JPA-JPQL
![Diagrama JDBC](/imagens/jpa_jpql.png)

Demonstração sobre como manipular os Pojos: Museu, Pintor, Pintura, Exposicao e Inventario juntamente com suas relações 
@OneToMany, @ManyToOne, @OneToOne e @ManyToMany usando JPA através de operações CRUD e construção de buscas complexas com JPQL.

```
Atividade proposta na Aula 05:

O objetivo desta tarefa é que consigam estabelecer operações no banco de dados configurado anteriormente usando JPQL.

Faça consultas ao seu banco de dados utilizando a linguagem JPQL. Faça ao menos uma consulta buscando todos os registros da tabela,
uma utilizando algum parâmetro a ser utilitado na cláusula WHERE, e uma fazendo um JOIN e acessando atributos do objeto relacionado
em seu código JAVA (como fizemos em aula ao mostrar os atributos da editora dado um livro).

```

#### BRANCH SPRING DATA
![Diagrama Spring_Data](/imagens/springdata.png)
Demonstração da modelagem de dados ORM com uso de SPRING DATA para armazenar e realizar operações CRUD em um objeto que se relaciona com outros objetos.

Implementação Projeto Final solicitado ao final da disciplina

```
Esta aplicação deve ter as seguintes especificidades:

1) Banco de dados criado automaticamente no start da aplicação.

2) Configurações de criação e de acesso aos dados em arquivo de propriedade.

3) Adição das dependências necessárias para a utilização do Spring Data.

4) Adição das dependências necessárias para o hibernate/jpa.

5) Os atributos e os relacionamentos das classes de negócio devem ser mapeados.

6) O projeto precisa estar organizado em três camadas (podem, opcionalmente, incluir uma camada de visão caso caso queiram):
* controle;
* serviço;
* repository.

7) Todas as classes precisam ter as seguintes funcionalidades:
* incluir;
* excluir;
* alterar;
* obter lista;
* obter por id.

8) Classes loaders precisam ser criadas para incluir informações iniciais no banco.
* Realizado através do arquivo data.sql
```
