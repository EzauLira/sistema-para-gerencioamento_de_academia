-- FUNCTION: public.buscar_dados_pessoais_pelo_primeiro_nome(character varying)

-- DROP FUNCTION IF EXISTS public.buscar_dados_pessoais_pelo_primeiro_nome(character varying);

CREATE OR REPLACE FUNCTION public.buscar_dados_pessoais_pelo_primeiro_nome(
	primeiro_nome character varying)
    RETURNS TABLE(nome character varying, cpf character varying, telefone character varying, email character varying, senha character varying, plano_nome character varying) 
    LANGUAGE 'plpgsql'
    COST 100
    VOLATILE PARALLEL UNSAFE
    ROWS 1000

AS $BODY$
BEGIN
    -- Verifica se a entrada não está vazia
    IF primeiro_nome IS NULL OR primeiro_nome = '' THEN
        RAISE EXCEPTION 'O nome não pode ser vazio. Por favor, forneça um nome válido.';
    END IF;

    -- Verifica se existe algum cliente com o nome fornecido
    IF NOT EXISTS (
        SELECT 1 
        FROM public.cliente c 
        WHERE c.nome ILIKE primeiro_nome || '%'
    ) THEN
        RAISE EXCEPTION 'Nome não encontrado. Verifique se o nome está correto ou talvez essa pessoa não esteja cadastrada.';
    END IF;

    -- Retorna os detalhes dos clientes que correspondem ao primeiro nome fornecido
    RETURN QUERY
    SELECT 
        c.nome,
        c.cpf,
        c.telefone,
        c.email,
        c.senha,
        p.nome AS plano_nome
    FROM 
        public.cliente c
    JOIN 
        public.plano p ON c.plano_id = p.id
    WHERE 
        c.nome ILIKE primeiro_nome || '%';
END;
$BODY$;

ALTER FUNCTION public.buscar_dados_pessoais_pelo_primeiro_nome(character varying)
    OWNER TO postgres;
