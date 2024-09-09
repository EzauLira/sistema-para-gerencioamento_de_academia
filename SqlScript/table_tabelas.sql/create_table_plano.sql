-- Table: public.plano

-- DROP TABLE IF EXISTS public.plano;

CREATE TABLE IF NOT EXISTS public.plano
(
    id integer NOT NULL DEFAULT nextval('plano_id_seq'::regclass),
    nome character varying(50) COLLATE pg_catalog."default" NOT NULL,
    descricao text COLLATE pg_catalog."default",
    duracao integer NOT NULL,
    preco numeric(10,2) NOT NULL,
    CONSTRAINT plano_pkey PRIMARY KEY (id)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.plano
    OWNER to postgres;