-- Criação da tabela plano
CREATE TABLE plano (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(50) NOT NULL,
    descricao TEXT NOT NULL,
    duracao_meses INT NOT NULL,
    preco DECIMAL(10, 2) NOT NULL
);

-- Inserção dos valores fixos
INSERT INTO plano (nome, descricao, duracao_meses, preco) VALUES
('Mensal', 'Plano mensal sem fidelidade', 1, 100.00),
('Trimestral', 'Plano trimestral com desconto', 3, 270.00),
('Anual', 'Plano anual com maior desconto', 12, 900.00);