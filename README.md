# Persistência com JDBC

Projeto minimalista para demonstrar como manipular o Pojo Museu através de operações CRUD
usando JDBC.

### Como verificar:
1)  Prepare um container Docker com MySQL executando no terminal partir da pasta *db/docker* o Bash script *mysqldb.sh*

Command Line:
>
> C:\Users\seu_usuario\jdbc\db\docker> bash mysqldb.sh

2) Run jdbc app

3) Run na classe teste JdbcMuseuDAOImplTest()

Path:
>
> src/test/java/br/infnet/diegorezende/jdbc/JdbcMuseuDAOImplTest.java

4) Run na classe JdbcRunner. Uma observação, este código testa o metodo apagar tudo *deleteAll()*, deste modo, caso necessite dos dados iniciais inseridos novamente execute o script *data.sql* no query console do seu Db.

Path:
> 
> src/main/java/br/infnet/diegorezende/jdbc/main/JdbcRunner.java


### Tecnologia Utilizada:
* MySQL 8.0
* WorkBench
* SpringBoot 3.2.5
* Java 17

### Dependências pom.xml:

	<dependencies>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-data-jdbc</artifactId>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-web</artifactId>
		</dependency>
		<dependency>
			<groupId>com.mysql</groupId>
			<artifactId>mysql-connector-j</artifactId>
			<version>8.1.0</version>
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

