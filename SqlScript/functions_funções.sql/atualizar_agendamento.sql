CREATE OR REPLACE FUNCTION atualizar_agendamento(
    agendamento_id INTEGER,
    novo_treino_id INTEGER,
    nova_data VARCHAR,
    nova_hora VARCHAR
) RETURNS VOID AS $$
BEGIN
    -- Atualiza o treino, data e hora do agendamento
    UPDATE public.agendamento
    SET treino_id = novo_treino_id,
        data = LEFT(nova_data, 10),  -- Trunca a data para 10 caracteres
        hora = LEFT(nova_hora, 5)    -- Trunca a hora para 5 caracteres
    WHERE id = agendamento_id;

    -- Verifica se a atualização foi bem-sucedida
    IF NOT FOUND THEN
        RAISE EXCEPTION 'Agendamento não encontrado ou não pertence ao cliente.';
    END IF;
END;
$$ LANGUAGE plpgsql;
