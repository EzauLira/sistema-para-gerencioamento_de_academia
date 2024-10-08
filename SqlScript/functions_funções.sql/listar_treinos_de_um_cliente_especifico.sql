-- FUNCTION: public.listar_treinos_de_um_cliente_especifico(character varying)

-- DROP FUNCTION IF EXISTS public.listar_treinos_de_um_cliente_especifico(character varying);

CREATE OR REPLACE FUNCTION public.listar_treinos_de_um_cliente_especifico(
	p_cliente_nome character varying)
    RETURNS TABLE(treino_nome character varying, data character varying, hora character varying) 
    LANGUAGE 'plpgsql'
    COST 100
    VOLATILE PARALLEL UNSAFE
    ROWS 1000

AS $BODY$
BEGIN
    -- Verifica se o nome do cliente é válido (case insensitive)
    IF NOT EXISTS (SELECT 1 FROM cliente WHERE LOWER(nome) = LOWER(p_cliente_nome)) THEN
        RAISE EXCEPTION 'Cliente não encontrado.';
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

    -- Verifica se a consulta retornou resultados
    IF NOT FOUND THEN
        RAISE EXCEPTION 'Nenhum treino ativo encontrado para o cliente.';
    END IF;
END;
$BODY$;

ALTER FUNCTION public.listar_treinos_de_um_cliente_especifico(character varying)
    OWNER TO postgres;
