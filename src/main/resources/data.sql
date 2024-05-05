-- Insere dados de exemplo na tabela Museu
INSERT INTO museu (nome, pais) VALUES
      ('Van Gogh Museum', 'Holanda'),
      ('Museu do Louvre', 'França'),
      ('Museu de Arte Latino-Americana de Buenos Aires', 'Argentina');

-- Insere dados de exemplo na tabela Pintor
INSERT INTO pintor (nome, nascimento) VALUES
       ('Vincent Van Gogh', '1853-03-30'),
       ('Giuseppe Arcimboldo', '1527-01-01'),
       ('Tarsila do Amaral', '1886-09-01');

-- Insere dados de exemplo na tabela Inventario
INSERT INTO inventario (codigo) VALUES
       (10000),
       (10001),
       (10002),
       (10003),
       (10004);

-- Insere dados de exemplo na tabela Pintura
INSERT INTO pintura (nome, pintor_id, museu_id,inventario_id) VALUES
       ('Cottages', 1, 1, 1),
       ('Beach at Scheveningen in Stormy Weather', 1, 1, 2),
       ('Two Women in the Moor', 1, 1, 3),
       ('Autumn', 2, 2, 4),
       ('Abaporu', 3, 3, 5);

-- Insere dados de exemplo na tabela Exposicao
INSERT INTO exposicao (nome) VALUES
       ('Expo Van Gogh 1'),
       ('Expo Tarsila'),
       ('Expo Van Gogh 2'),
       ('Expo Giuseppe Arcimboldo'),
       ('Expo Brasil');



-- Insere dados de exemplo na tabela de junção livro_autor
INSERT INTO museu_exposicao (exposicao_id, museu_id) VALUES
        (1, 1),
        (2, 3),
        (3, 1),
        (4, 2),
        (5, 3);


