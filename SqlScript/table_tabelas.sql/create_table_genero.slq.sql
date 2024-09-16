CREATE TABLE genero (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(20) NOT NULL
);

-- Inserção dos valores fixos
INSERT INTO genero (nome) VALUES
('MASCULINO'),
('FEMININO'),
('OUTROS');
