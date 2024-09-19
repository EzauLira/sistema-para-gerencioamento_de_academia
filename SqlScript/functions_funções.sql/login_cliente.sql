-- FUNCTION: public.login_cliente(character varying, character varying)

-- DROP FUNCTION IF EXISTS public.login_cliente(character varying, character varying);

CREATE OR REPLACE FUNCTION public.login_cliente(
	p_cpf character varying,
	p_senha character varying)
    RETURNS TABLE(cliente_id integer, status text)
    LANGUAGE 'plpgsql'
    COST 100
    VOLATILE PARALLEL UNSAFE
    ROWS 1000

AS $BODY$
DECLARE
   v_senha_db VARCHAR;
BEGIN
   -- Remover pontuação do CPF
   p_cpf := REPLACE(REPLACE(REPLACE(p_cpf, '.', ''), '-', ''), ' ', '');
   -- Buscar o ID do cliente e a senha associada
   SELECT id, senha INTO cliente_id, v_senha_db
   FROM cliente
   WHERE cpf = p_cpf;
   -- Se o CPF não for encontrado
   IF NOT FOUND THEN
       RAISE EXCEPTION 'CPF não cadastrado';
   END IF;
   -- Verificar se a senha está correta
   IF v_senha_db != p_senha THEN
       RAISE EXCEPTION 'Senha incorreta';
   END IF;
   -- Retornar o ID do cliente e a mensagem de sucesso
   RETURN QUERY SELECT cliente_id, 'Login realizado com sucesso';
END;
$BODY$;

ALTER FUNCTION public.login_cliente(character varying, character varying)
    OWNER TO postgres;
