-- FUNCTION: public.login_admin(character varying, character varying)

-- DROP FUNCTION IF EXISTS public.login_admin(character varying, character varying);

CREATE OR REPLACE FUNCTION public.login_admin(
	novo_usuario character varying,
	nova_senha character varying)
    RETURNS void
    LANGUAGE 'plpgsql'
    COST 100
    VOLATILE PARALLEL UNSAFE
AS $BODY$
DECLARE
    usuario_existente RECORD;
BEGIN
    -- Verifica se o usuário ou a senha são vazios
    IF novo_usuario IS NULL OR novo_usuario = '' THEN
        RAISE EXCEPTION 'O nome do usuário não pode ser vazio';
    ELSIF nova_senha IS NULL OR nova_senha = '' THEN
        RAISE EXCEPTION 'A senha não pode ser vazia';
    END IF;

    -- Verifica se o usuário já existe e a senha está correta
    SELECT * INTO usuario_existente
    FROM administrador
    WHERE LOWER(usuario) = LOWER(novo_usuario);

    IF usuario_existente IS NULL THEN
        RAISE EXCEPTION 'Usuário não encontrado na base de dados';
    ELSIF LOWER(usuario_existente.senha) <> LOWER(nova_senha) THEN
        RAISE EXCEPTION 'Senha incorreta';
    END IF;
    -- Se passar por todas as verificações, a função termina sem erros
END;
$BODY$;

ALTER FUNCTION public.login_admin(character varying, character varying)
    OWNER TO postgres;
