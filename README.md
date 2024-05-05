# Persistência com SPRING DATA

Projeto minimalista para demonstrar como manipular os Pojo Museu, Pintor, Pintura, Exposicao e Inventario juntamente 
com suas relações @OneToMany, @ManyToOne, @OneToOne e @ManyToMany usando Spring Data através de operações CRUD.


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

2) SpringData app
* Run SpringData app ( Load Schema - schema.sql e Data Inicial - data.sql )

3) Run SpringdataApplication.java e inicialize SpringDataApp que estará disponível no http://localhost:8080
### Endpoints
* /museus
* /pintores
* /pinturas
* /exposicoes
* /inventarios

4) Run Testes na pasta test/java/br.infnet.diegorezende/service:
* MuseuServiceTest
* PintorServiceTest
* PinturaServiceTest
* ExposicaoServiceTest
* InventarioServiceTest


### Tecnologia Utilizada:
* MySQL 8.0
* WorkBench
* SpringBoot 3.2.5
* Java 17


### Dependências pom.xml:

		<dependencies>
		    <dependency>
			    <groupId>org.springframework.boot</groupId>
			    <artifactId>spring-boot-starter-data-jpa</artifactId>
		    </dependency>
		    <dependency>
			    <groupId>org.springframework.boot</groupId>
			    <artifactId>spring-boot-starter-web</artifactId>
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
