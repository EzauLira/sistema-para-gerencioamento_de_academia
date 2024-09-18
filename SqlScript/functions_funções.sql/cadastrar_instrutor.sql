-- FUNCTION: public.cadastrar_instrutor(character varying, character varying, integer, character varying, character varying, character varying)

-- DROP FUNCTION IF EXISTS public.cadastrar_instrutor(character varying, character varying, integer, character varying, character varying, character varying);

CREATE OR REPLACE FUNCTION public.cadastrar_instrutor(
	p_nome character varying,
	p_cpf character varying,
	p_genero integer,
	p_telefone character varying,
	p_email character varying,
	p_senha character varying)
    RETURNS text
    LANGUAGE 'plpgsql'
    COST 100
    VOLATILE PARALLEL UNSAFE
AS $BODY$
BEGIN
    -- Verifica se já existe um instrutor com o mesmo nome
    IF EXISTS (SELECT 1 FROM instrutor WHERE nome = p_nome) THEN
        RAISE EXCEPTION 'Erro: Nome já cadastrado.';
    END IF;

    -- Verifica se já existe um instrutor com o mesmo CPF
    IF EXISTS (SELECT 1 FROM instrutor WHERE cpf = p_cpf) THEN
        RAISE EXCEPTION 'Erro: CPF já cadastrado.';
    END IF;

    -- Verifica se já existe um instrutor com o mesmo telefone
    IF EXISTS (SELECT 1 FROM instrutor WHERE telefone = p_telefone) THEN
        RAISE EXCEPTION 'Erro: Telefone já cadastrado.';
    END IF;

    -- Verifica se já existe um instrutor com o mesmo email
    IF EXISTS (SELECT 1 FROM instrutor WHERE email = p_email) THEN
        RAISE EXCEPTION 'Erro: Email já cadastrado.';
    END IF;

    -- Verifica se a senha contém pelo menos uma letra maiúscula, um caractere especial, um número e tem pelo menos 5 caracteres
    IF p_senha !~ '[A-Z]' THEN
        RAISE EXCEPTION 'A senha deve conter pelo menos uma letra maiúscula';
    END IF;

    IF p_senha !~ '[@.]' THEN
        RAISE EXCEPTION 'A senha deve conter pelo menos um caractere especial (@ ou .)';
    END IF;

    IF p_senha !~ '[0-9]' THEN
        RAISE EXCEPTION 'A senha deve conter pelo menos um número';
    END IF;

    IF LENGTH(p_senha) < 5 THEN
        RAISE EXCEPTION 'A senha deve ter pelo menos 5 caracteres';
    END IF;

    -- Insere o novo instrutor se todas as verificações passarem
    INSERT INTO instrutor (nome, cpf, genero, telefone, email, senha)
    VALUES (p_nome, p_cpf, p_genero, p_telefone, p_email, p_senha);

    -- Retorna mensagem de sucesso
    RETURN 'Instrutor cadastrado com sucesso.';
END;
$BODY$;

ALTER FUNCTION public.cadastrar_instrutor(character varying, character varying, integer, character varying, character varying, character varying)
    OWNER TO postgres;
