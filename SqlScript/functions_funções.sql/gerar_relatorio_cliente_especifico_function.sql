-- FUNCTION: public.gerar_relatorio_cliente_especifico(character varying)

-- DROP FUNCTION IF EXISTS public.gerar_relatorio_cliente_especifico(character varying);

CREATE OR REPLACE FUNCTION public.gerar_relatorio_cliente_especifico(
	p_cliente_nome character varying)
    RETURNS TABLE(cliente_nome character varying, plano_nome character varying, treino_nome character varying, data_treino character varying, hora_treino character varying) 
    LANGUAGE 'plpgsql'
    COST 100
    VOLATILE PARALLEL UNSAFE
    ROWS 1000

AS $BODY$
BEGIN
    RETURN QUERY
    SELECT 
        a.cliente_nome AS cliente_nome,
        p.nome AS plano_nome,
        t.nome AS treino_nome,
        a.data AS data_treino,
        a.hora AS hora_treino
    FROM 
        agendamento a
    JOIN 
        cliente c ON a.cliente_nome = c.nome
    JOIN 
        plano p ON c.plano_id = p.id
    JOIN 
        treino t ON a.treino_id = t.id
    WHERE 
        a.cliente_nome = p_cliente_nome;
END;
$BODY$;

ALTER FUNCTION public.gerar_relatorio_cliente_especifico(character varying)
    OWNER TO postgres;
