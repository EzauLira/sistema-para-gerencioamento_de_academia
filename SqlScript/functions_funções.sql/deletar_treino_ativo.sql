-- FUNCTION: public.deletar_treino_ativo(integer)

-- DROP FUNCTION IF EXISTS public.deletar_treino_ativo(integer);

CREATE OR REPLACE FUNCTION public.deletar_treino_ativo(
	agendamento_id integer)
    RETURNS void
    LANGUAGE 'plpgsql'
    COST 100
    VOLATILE PARALLEL UNSAFE
AS $BODY$
BEGIN
    DELETE FROM public.agendamento
    WHERE public.agendamento.id = agendamento_id
    AND (public.agendamento.data::date > CURRENT_DATE OR (public.agendamento.data::date = CURRENT_DATE AND public.agendamento.hora::time > CURRENT_TIME));

    IF NOT FOUND THEN
        RAISE EXCEPTION 'Nenhum treino ativo encontrado para o agendamento fornecido.';
    END IF;
END;
$BODY$;

ALTER FUNCTION public.deletar_treino_ativo(integer)
    OWNER TO postgres;
