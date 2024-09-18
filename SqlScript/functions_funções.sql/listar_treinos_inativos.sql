-- FUNCTION: public.listar_treinos_inativos(integer)

-- DROP FUNCTION IF EXISTS public.listar_treinos_inativos(integer);

CREATE OR REPLACE FUNCTION public.listar_treinos_inativos(
	p_cliente_id integer)
    RETURNS TABLE(agendamento_id integer, treino_nome character varying, data character varying, hora character varying) 
    LANGUAGE 'plpgsql'
    COST 100
    VOLATILE PARALLEL UNSAFE
    ROWS 1000

AS $BODY$
BEGIN
    RETURN QUERY
    SELECT 
        a.id AS agendamento_id,
        t.nome AS treino_nome,
        a.data,
        a.hora
    FROM 
        public.agendamento a
    JOIN 
        public.treino t ON a.treino_id = t.id
    JOIN
        public.cliente c ON a.cliente_id = c.id
    WHERE 
        c.id = p_cliente_id
        AND (a.data::date < CURRENT_DATE OR (a.data::date = CURRENT_DATE AND a.hora::time <= CURRENT_TIME));

    IF NOT FOUND THEN
        RAISE EXCEPTION 'Nenhum treino inativo encontrado para o cliente.';
    END IF;
END;
$BODY$;

ALTER FUNCTION public.listar_treinos_inativos(integer)
    OWNER TO postgres;
