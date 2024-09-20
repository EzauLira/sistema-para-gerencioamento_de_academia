CREATE OR REPLACE FUNCTION listar_treinos_de_um_cliente_especifico(p_cliente_nome VARCHAR)
RETURNS TABLE (
    treino_nome VARCHAR,
    data VARCHAR,
    hora VARCHAR
) AS $$
BEGIN
    -- Verifica se o nome do cliente é válido (case insensitive)
    IF NOT EXISTS (SELECT 1 FROM cliente WHERE LOWER(nome) = LOWER(p_cliente_nome)) THEN
        RAISE EXCEPTION 'Cliente % não encontrado.', p_cliente_nome;
    END IF;

    RETURN QUERY
    SELECT 
        t.nome AS treino_nome,
        a.data,
        a.hora
    FROM 
        agendamento a
    JOIN 
        cliente c ON a.cliente_id = c.id
    JOIN 
        treino t ON a.treino_id = t.id
    WHERE 
        LOWER(c.nome) = LOWER(p_cliente_nome)
        AND TO_DATE(a.data, 'DD/MM/YYYY') >= CURRENT_DATE;

    IF NOT FOUND THEN
        RAISE EXCEPTION 'Nenhum treino ativo encontrado para o cliente %.', p_cliente_nome;
    END IF;
END;
$$ LANGUAGE plpgsql;