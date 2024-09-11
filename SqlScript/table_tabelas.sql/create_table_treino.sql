-- Criação da tabela treino
CREATE TABLE treino (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(50) NOT NULL,
    descricao TEXT NOT NULL
);

-- Inserção dos valores fixos
INSERT INTO treino (nome, descricao) VALUES
( 'Agachamento', 'Exercício para quadríceps, glúteos e isquiotibiais' ),
( 'Supino Reto', 'Exercício para peitoral, deltoides e tríceps' ),
( 'Levantamento Terra', 'Exercício para lombar, glúteos e isquiotibiais' );
