-- Table: public.treino

-- DROP TABLE IF EXISTS public.treino;

CREATE TABLE IF NOT EXISTS public.treino
(
    id integer NOT NULL DEFAULT nextval('treino_id_seq'::regclass),
    nome character varying(50) COLLATE pg_catalog."default" NOT NULL,
    descricao text COLLATE pg_catalog."default",
    CONSTRAINT treino_pkey PRIMARY KEY (id)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.treino
    OWNER to postgres;