SET FOREIGN_KEY_CHECKS=0;

-- Drop tabelas existentes
DROP TABLE IF EXISTS museu;
DROP TABLE IF EXISTS pintor;
DROP TABLE IF EXISTS inventario;
DROP TABLE IF EXISTS exposicao;
DROP TABLE IF EXISTS museu_exposicao;
DROP TABLE IF EXISTS pintura;


-- Cria a tabela Museu
CREATE TABLE museu (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    pais VARCHAR(50)
);

-- Cria a tabela Pintor
CREATE TABLE pintor (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    nascimento DATE
);

-- Cria a tabela Inventario
CREATE TABLE inventario (
    id INT AUTO_INCREMENT PRIMARY KEY,
    codigo INT NOT NULL
);

-- Cria a tabela Pintura
CREATE TABLE pintura (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    pintor_id INT,
    museu_id INT,
    inventario_id INT,
    FOREIGN KEY (museu_id) REFERENCES museu(id),
    FOREIGN KEY (pintor_id) REFERENCES pintor(id),
    FOREIGN KEY (inventario_id) REFERENCES inventario(id)
);

-- Cria a tabela Exposicao
CREATE TABLE exposicao (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL
);


-- Cria a tabela de junção Museu_Exposicao
CREATE TABLE museu_exposicao (
    exposicao_id INT,
    museu_id INT,
    FOREIGN KEY (exposicao_id) REFERENCES exposicao (id),
    FOREIGN KEY (museu_id) REFERENCES museu(id),
    PRIMARY KEY (exposicao_id, museu_id) -- Define a composite primary key
);
