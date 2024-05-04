-- Drop tabelas existentes
DROP TABLE IF EXISTS Museu;
DROP TABLE IF EXISTS Pintor;
DROP TABLE IF EXISTS Pintura;
DROP TABLE IF EXISTS Exposicao;
DROP TABLE IF EXISTS Colecao;
DROP TABLE IF EXISTS Museu_Exposicao;

-- Cria a tabela Museu
CREATE TABLE Museu (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    pais VARCHAR(50)
);

-- Cria a tabela Pintor
CREATE TABLE Pintor (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    nascimento DATE
);

-- Cria a tabela Inventario
CREATE TABLE Inventario (
    id INT AUTO_INCREMENT PRIMARY KEY,
    codigo INT NOT NULL
);

-- Cria a tabela Pintura
CREATE TABLE Pintura (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    pintor_id INT,
    museu_id INT,
    inventario_id INT,
    FOREIGN KEY (museu_id) REFERENCES Museu(id),
    FOREIGN KEY (pintor_id) REFERENCES Pintor(id),
    FOREIGN KEY (inventario_id) REFERENCES Inventario(id)
);

-- Cria a tabela Exposicao
CREATE TABLE Exposicao (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL
);


-- Cria a tabela de junção Museu_Exposicao
CREATE TABLE Museu_Exposicao (
    exposicao_id INT,
    museu_id INT,
    FOREIGN KEY (exposicao_id) REFERENCES Exposicao(id),
    FOREIGN KEY (museu_id) REFERENCES Museu(id),
    PRIMARY KEY (exposicao_id, museu_id) -- Define a composite primary key
);
