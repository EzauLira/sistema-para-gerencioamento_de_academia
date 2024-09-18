CREATE TABLE agendamento (
    id SERIAL PRIMARY KEY,
    cliente_id INT NOT NULL,
    treino_id INT NOT NULL,
    data VARCHAR(10) NOT NULL,
    hora VARCHAR(5) NOT NULL,
    FOREIGN KEY (treino_id) REFERENCES treino(id),
    FOREIGN KEY (cliente_id) REFERENCES cliente(id)
);
