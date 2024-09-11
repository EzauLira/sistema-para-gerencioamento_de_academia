-- Criação da tabela cliente
CREATE TABLE cliente (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    idade INT NOT NULL,
    cpf VARCHAR(11) NOT NULL,
    genero VARCHAR(10) NOT NULL,
    telefone VARCHAR(15),
    email VARCHAR(100),
    plano_id INT NOT NULL,
    FOREIGN KEY (plano_id) REFERENCES plano(id)
);
