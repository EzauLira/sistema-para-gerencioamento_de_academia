-- FUNCTION: public.gerar_relatorio_academia()

-- DROP FUNCTION IF EXISTS public.gerar_relatorio_academia();

CREATE OR REPLACE FUNCTION public.gerar_relatorio_academia(
	)
    RETURNS TABLE(total_clientes integer, plano_mensal_vendido integer, plano_anual_vendido integer, plano_trimestral_vendido integer) 
    LANGUAGE 'plpgsql'
    COST 100
    VOLATILE PARALLEL UNSAFE
    ROWS 1000

AS $BODY$
BEGIN
    RETURN QUERY
    SELECT 
        -- Quantidade total de clientes cadastrados
        (SELECT COUNT(*)::integer FROM cliente) AS total_clientes,

        -- Quantidade de planos mensais vendidos
        (SELECT COUNT(*)::integer 
         FROM cliente c 
         JOIN plano p ON c.plano_id = p.id 
         WHERE p.duracao = 1) AS plano_mensal_vendido,

        -- Quantidade de planos anuais vendidos
        (SELECT COUNT(*)::integer 
         FROM cliente c 
         JOIN plano p ON c.plano_id = p.id 
         WHERE p.duracao = 12) AS plano_anual_vendido,

        -- Quantidade de planos trimestrais vendidos
        (SELECT COUNT(*)::integer 
         FROM cliente c 
         JOIN plano p ON c.plano_id = p.id 
         WHERE p.duracao = 3) AS plano_trimestral_vendido;
END;
$BODY$;

ALTER FUNCTION public.gerar_relatorio_academia()
    OWNER TO postgres;
