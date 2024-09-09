-- FUNCTION: public.buscar_pessoa_pelo_primeiro_nome(character varying)

-- DROP FUNCTION IF EXISTS public.buscar_pessoa_pelo_primeiro_nome(character varying);

CREATE OR REPLACE FUNCTION public.buscar_pessoa_pelo_primeiro_nome(
	primeiro_nome character varying)
    RETURNS TABLE(nome character varying) 
    LANGUAGE 'plpgsql'
    COST 100
    VOLATILE PARALLEL UNSAFE
    ROWS 1000

AS $BODY$
BEGIN
    -- Verifica se existe algum cliente com o nome fornecido
    IF NOT EXISTS (SELECT 1 FROM public.cliente c WHERE c.nome ILIKE primeiro_nome || '%') THEN
        RAISE EXCEPTION 'Nome não encontrado. Verifique se o nome está correto ou talvez essa pessoa não esteja cadastrada.';
    END IF;

    -- Retorna os nomes dos clientes que correspondem ao primeiro nome fornecido
    RETURN QUERY
    SELECT c.nome
    FROM public.cliente c
    WHERE c.nome ILIKE primeiro_nome || '%';
END;
$BODY$;

ALTER FUNCTION public.buscar_pessoa_pelo_primeiro_nome(character varying)
    OWNER TO postgres;
