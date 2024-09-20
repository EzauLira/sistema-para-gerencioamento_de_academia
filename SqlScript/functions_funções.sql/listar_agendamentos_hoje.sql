CREATE OR REPLACE FUNCTION listar_agendamentos_hoje()
RETURNS TABLE (
    id INTEGER,
    cliente_nome VARCHAR,
    treino_nome VARCHAR
) AS $$
BEGIN
    IF EXISTS (
        SELECT 1
        FROM agendamento a
        WHERE a.data = TO_CHAR(CURRENT_DATE, 'DD/MM/YYYY')
    ) THEN
        RETURN QUERY
        SELECT 
            a.id,
            c.nome AS cliente_nome,
            t.nome AS treino_nome
        FROM 
            agendamento a
        JOIN 
            cliente c ON a.cliente_id = c.id
        JOIN 
            treino t ON a.treino_id = t.id
        WHERE 
            a.data = TO_CHAR(CURRENT_DATE, 'DD/MM/YYYY');
    ELSE
        RAISE EXCEPTION 'Nenhum agendamento encontrado para a data atual.';
    END IF;
END;
$$ LANGUAGE plpgsql;


SELECT * FROM listar_agendamentos_hoje();

