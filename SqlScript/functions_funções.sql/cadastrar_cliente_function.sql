-- FUNCTION: public.cadastrar_cliente(character varying, integer, character varying, character varying, character varying, character varying, integer)

-- DROP FUNCTION IF EXISTS public.cadastrar_cliente(character varying, integer, character varying, character varying, character varying, character varying, integer);

CREATE OR REPLACE FUNCTION public.cadastrar_cliente(
	p_nome character varying,
	p_idade integer,
	p_cpf character varying,
	p_genero character varying,
	p_telefone character varying,
	p_email character varying,
	p_plano_id integer)
    RETURNS text
    LANGUAGE 'plpgsql'
    COST 100
    VOLATILE PARALLEL UNSAFE
AS $BODY$
BEGIN
    -- Verifica se já existe um cliente com o mesmo nome
    IF EXISTS (SELECT 1 FROM cliente WHERE nome = p_nome) THEN
        RAISE EXCEPTION 'Erro: Nome já cadastrado.';
    END IF;

    -- Verifica se já existe um cliente com o mesmo CPF
    IF EXISTS (SELECT 1 FROM cliente WHERE cpf = p_cpf) THEN
        RAISE EXCEPTION 'Erro: CPF já cadastrado.';
    END IF;

    -- Verifica se já existe um cliente com o mesmo telefone
    IF EXISTS (SELECT 1 FROM cliente WHERE telefone = p_telefone) THEN
        RAISE EXCEPTION 'Erro: Telefone já cadastrado.';
    END IF;

    -- Verifica se já existe um cliente com o mesmo email
    IF EXISTS (SELECT 1 FROM cliente WHERE email = p_email) THEN
        RAISE EXCEPTION 'Erro: Email já cadastrado.';
    END IF;

    -- Insere o novo cliente se todas as verificações passarem
    INSERT INTO cliente (nome, idade, cpf, genero, telefone, email, plano_id)
    VALUES (p_nome, p_idade, p_cpf, p_genero, p_telefone, p_email, p_plano_id);

    -- Retorna mensagem de sucesso
    RETURN 'Cliente cadastrado com sucesso.';
END;
$BODY$;

ALTER FUNCTION public.cadastrar_cliente(character varying, integer, character varying, character varying, character varying, character varying, integer)
    OWNER TO postgres;
