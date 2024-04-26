-- Drop tables if they exist
DROP TABLE IF EXISTS pintura;
DROP TABLE IF EXISTS pintor;
DROP TABLE IF EXISTS museu;

-- Create the Museu table
CREATE TABLE Museu (
                       id INT AUTO_INCREMENT PRIMARY KEY,
                       nome VARCHAR(255) NOT NULL,
                       pais VARCHAR(50)
);

-- Create the Pintor table
CREATE TABLE Pintor (
                        id INT AUTO_INCREMENT PRIMARY KEY,
                        nome VARCHAR(255) NOT NULL,
                        nascimento DATE
);

-- Create the Pintura table
CREATE TABLE Pintura (
                         id INT AUTO_INCREMENT PRIMARY KEY,
                         nome VARCHAR(255) NOT NULL,
                         pintor_id INT,
                         museu_id INT,
                         FOREIGN KEY (museu_id) REFERENCES Museu(id),
                         FOREIGN KEY (pintor_id) REFERENCES Pintor(id)
);
