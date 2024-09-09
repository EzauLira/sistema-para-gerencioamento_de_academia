-- FUNCTION: public.agendar_treino(character varying, integer, character varying, character varying)

-- DROP FUNCTION IF EXISTS public.agendar_treino(character varying, integer, character varying, character varying);

CREATE OR REPLACE FUNCTION public.agendar_treino(
	p_cliente_nome character varying,
	p_treino_id integer,
	p_data character varying,
	p_hora character varying)
    RETURNS void
    LANGUAGE 'plpgsql'
    COST 100
    VOLATILE PARALLEL UNSAFE
AS $BODY$
BEGIN
    -- Verificar se o cliente já existe na tabela cliente
    IF NOT EXISTS (
        SELECT 1
        FROM cliente
        WHERE nome = p_cliente_nome
    ) THEN
        RAISE EXCEPTION 'Cliente não encontrado: %', p_cliente_nome;
    END IF;

    -- Verificar se já existe um treino agendado para o mesmo cliente na mesma data e hora
    IF EXISTS (
        SELECT 1
        FROM agendamento
        WHERE cliente_nome = p_cliente_nome
        AND treino_id = p_treino_id
        AND data = p_data
    ) THEN
        RAISE EXCEPTION 'O mesmo treino já está agendado para este cliente nesta data.';
    END IF;

    -- Verificar se já existe um treino agendado para o mesmo cliente na mesma hora
    IF EXISTS (
        SELECT 1
        FROM agendamento
        WHERE cliente_nome = p_cliente_nome
        AND data = p_data
        AND ABS(EXTRACT(EPOCH FROM (hora::time - p_hora::time)) / 60) < 30
    ) THEN
        RAISE EXCEPTION 'Já existe um treino agendado para este cliente nesta data e hora. Deve haver pelo menos 30 minutos de diferença entre os treinos.';
    END IF;

    -- Inserir o novo agendamento
    INSERT INTO agendamento (cliente_nome, treino_id, data, hora)
    VALUES (p_cliente_nome, p_treino_id, p_data, p_hora);
END;
$BODY$;

ALTER FUNCTION public.agendar_treino(character varying, integer, character varying, character varying)
    OWNER TO postgres;
