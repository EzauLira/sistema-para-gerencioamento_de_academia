-- FUNCTION: public.atualizar_agendamento(integer, integer, character varying, character varying)

-- DROP FUNCTION IF EXISTS public.atualizar_agendamento(integer, integer, character varying, character varying);

CREATE OR REPLACE FUNCTION public.atualizar_agendamento(
	agendamento_id integer,
	novo_treino_id integer,
	nova_data character varying,
	nova_hora character varying)
    RETURNS void
    LANGUAGE 'plpgsql'
    COST 100
    VOLATILE PARALLEL UNSAFE
AS $BODY$
BEGIN
   -- Atualiza o treino, data e hora do agendamento
   UPDATE public.agendamento
   SET treino_id = novo_treino_id,
       data = LEFT(nova_data, 10),  -- Trunca a data para 10 caracteres
       hora = LEFT(nova_hora, 5)    -- Trunca a hora para 5 caracteres
   WHERE id = agendamento_id;
   -- Verifica se a atualização foi bem-sucedida
   IF NOT FOUND THEN
       RAISE EXCEPTION 'Agendamento não encontrado ou não pertence ao cliente.';
   END IF;
END;
$BODY$;

ALTER FUNCTION public.atualizar_agendamento(integer, integer, character varying, character varying)
    OWNER TO postgres;
