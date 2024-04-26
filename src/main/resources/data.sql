-- Insere dados de exemplo na tabela Museu
INSERT INTO Museu (nome, pais) VALUES
                                   ('Van Gogh Museum', 'Holanda'),
                                   ('Museu do Louvre', 'França'),
                                   ('Museu de Arte Latino-Americana de Buenos Aires', 'Argentina');

-- Insere dados de exemplo na tabela Pintor
INSERT INTO Pintor (nome, nascimento) VALUES
                                          ('Vincent Van Gogh', '1853-03-30'),
                                          ('Giuseppe Arcimboldo', '1527-01-01'),
                                          ('Tarsila do Amaral', '1886-09-01');

-- Insere dados de exemplo na tabela Pintura
INSERT INTO Pintura (nome, pintor_id, museu_id) VALUES
                                                    ('Cottages', 1, 1),
                                                    ('Beach at Scheveningen in Stormy Weather', 1, 1),
                                                    ('Two Women in the Moor', 1, 1),
                                                    ('Autumn', 2, 2),
                                                    ('Abaporu', 3, 3);




