-- FUNCTION: public.listar_agendamentos_hoje()

-- DROP FUNCTION IF EXISTS public.listar_agendamentos_hoje();

CREATE OR REPLACE FUNCTION public.listar_agendamentos_hoje(
	)
    RETURNS TABLE(id integer, cliente_nome character varying, treino_nome character varying)
    LANGUAGE 'plpgsql'
    COST 100
    VOLATILE PARALLEL UNSAFE
    ROWS 1000

AS $BODY$
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
$BODY$;

ALTER FUNCTION public.listar_agendamentos_hoje()
    OWNER TO postgres;
