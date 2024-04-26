# Persistência com HIBERNATE

Projeto minimalista para demonstrar como manipular o Pojo Museu
usando HIBERNATE através de operações CRUD. As configurações estão localizadas nos arquivos>
* hibernate.cfg.xml
* Museu.hbm.xml
* Pintor.hbm.xml
* Pintura.hbm.xml

### Relações ORM Trabalhadas:
* @OneToMany
* @ManyToOne

### Como verificar:
1)  Prepare um container Docker com MySQL executando no terminal partir da pasta *hibernate/db* o Bash script *mysqldb.sh*

Command Line:
>
> C:\Users\seu_usuario\jdbctemplate\db> bash mysqldb.sh

2) Hibernate app
* Run hibernate app ( Load Schema - schema.sql e Data Inicial - data.sql )

3) Run Testes no src/main/java/br/infnet/diegorezende/hibernate/main
* Run HibernateRunner.java ( Demonstração de Funcionamento Hibernate sobre o modelo Museu )
* Run HibernateImplAsServiceRunner.java ( Demonstração de Funcionamento Hibernate sobre o modelo Museu,Pintor Pintura e suas relações)


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

