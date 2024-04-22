# Persistência com JDBC TEMPLATE

Projeto minimalista para demonstrar como manipular o Pojo Museu
usando JDBC TEMPLATE através de operações CRUD.

### Como verificar:
1)  Prepare um container Docker com MySQL executando no terminal partir da pasta *jdbctemplate/db* o Bash script *mysqldb.sh*

Command Line:
>
> C:\Users\seu_usuario\jdbctemplate\db> bash mysqldb.sh

2) Run jdbctemplate app
* A demonstração foi realizada diretamente na classe *JdbctemplateApplication*

### Tecnologia Utilizada:
* MySQL 8.0
* WorkBench
* SpringBoot 3.2.5
* Java 17

### Dependências pom.xml:

	<dependencies>
		<dependency>
			<groupId>org.springframework</groupId>
			<artifactId>spring-core</artifactId>
		</dependency>
		<dependency>
			<groupId>org.springframework</groupId>
			<artifactId>spring-context</artifactId>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-jdbc</artifactId>
		</dependency>
		<dependency>
			<groupId>org.springframework</groupId>
			<artifactId>spring-jdbc</artifactId>
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

