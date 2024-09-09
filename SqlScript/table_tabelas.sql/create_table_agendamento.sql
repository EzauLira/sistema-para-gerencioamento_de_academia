-- Table: public.agendamento

-- DROP TABLE IF EXISTS public.agendamento;

CREATE TABLE IF NOT EXISTS public.agendamento
(
    id integer NOT NULL DEFAULT nextval('agendamento_id_seq'::regclass),
    cliente_nome character varying(50) COLLATE pg_catalog."default" NOT NULL,
    treino_id integer NOT NULL,
    data character varying(10) COLLATE pg_catalog."default" NOT NULL,
    hora character varying(8) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT agendamento_pkey PRIMARY KEY (id),
    CONSTRAINT fk_treino FOREIGN KEY (treino_id)
        REFERENCES public.treino (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.agendamento
    OWNER to postgres;