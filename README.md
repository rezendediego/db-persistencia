# Persistência com JPA e JPQL para buscas complexas

Projeto minimalista para demonstrar como manipular os Pojo Museu, Pintor, Pintura, Exposicao e Inventario juntamente 
com suas relações @OneToMany, @ManyToOne, @OneToOne e @ManyToMany usando JPA através de operações CRUD e construção de 
buscas complexas com JPQL.


As configurações estão localizadas nos arquivos>
* persistence.xml


### Relações ORM Trabalhadas:
* @OneToMany
* @ManyToOne
* @OneToOne
* @ManyToMany

### Como verificar:
1)  Prepare um container Docker com MySQL executando no terminal partir da pasta *hibernate/db* o Bash script *mysqldb.sh*

Command Line:
>
> C:\Users\seu_usuario\jdbctemplate\db> bash mysqldb.sh

2) Jpa-Jpql app
* Run Jpa-Jpql app ( Load Schema - schema.sql e Data Inicial - data.sql )

3) Run Testes no src/main/java/br/infnet/diegorezende/jpajpql/main
* Run OpCRUDConsultasComJPQLRunner.java ( Demonstração de Funcionamento JPA e JPQL para operações CRUD e para buscas Complexas )


### Tecnologia Utilizada:
* MySQL 8.0
* WorkBench
* SpringBoot 3.2.5
* Java 17

### Dependências pom.xml:

	<dependencies>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter</artifactId>
		</dependency>
		<dependency>
			<groupId>org.hibernate</groupId>
			<artifactId>hibernate-core</artifactId>
			<version>6.3.0.CR1</version>
		</dependency>
		<dependency>
			<groupId>com.mysql</groupId>
			<artifactId>mysql-connector-j</artifactId>
			<scope>runtime</scope>
		</dependency>
		<dependency>
			<groupId>org.projectlombok</groupId>
			<artifactId>lombok</artifactId>
			<optional>true</optional>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-test</artifactId>
			<scope>test</scope>
		</dependency>
	</dependencies>

