-- Criação da tabela cliente
DROP TABLE IF EXISTS cliente;

CREATE TABLE cliente (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    idade INT NOT NULL,
    cpf VARCHAR(11) NOT NULL,
    genero INT NOT NULL,
    telefone VARCHAR(15),
    email VARCHAR(100),
    senha VARCHAR(50),
    plano_id INT NOT NULL,
    FOREIGN KEY (plano_id) REFERENCES plano(id),
    FOREIGN KEY (genero) REFERENCES genero(id)
);