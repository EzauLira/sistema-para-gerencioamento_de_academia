CREATE TABLE agendamento (
    id SERIAL PRIMARY KEY,
    cliente_nome VARCHAR(100) NOT NULL,
    treino_id INT NOT NULL,
    data VARCHAR(10) NOT NULL,
    hora VARCHAR(5) NOT NULL,
    FOREIGN KEY (treino_id) REFERENCES treino(id)
);
