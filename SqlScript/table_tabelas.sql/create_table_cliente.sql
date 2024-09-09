-- Table: public.cliente

-- DROP TABLE IF EXISTS public.cliente;

CREATE TABLE IF NOT EXISTS public.cliente
(
    id integer NOT NULL DEFAULT nextval('cliente_id_seq'::regclass),
    nome character varying(100) COLLATE pg_catalog."default" NOT NULL,
    idade integer,
    cpf character(11) COLLATE pg_catalog."default" NOT NULL,
    genero character(10) COLLATE pg_catalog."default" NOT NULL,
    telefone character(20) COLLATE pg_catalog."default" NOT NULL,
    email character varying(50) COLLATE pg_catalog."default" NOT NULL,
    plano_id integer,
    CONSTRAINT cliente_pkey PRIMARY KEY (id),
    CONSTRAINT cliente_cpf_key UNIQUE (cpf),
    CONSTRAINT cliente_email_key UNIQUE (email),
    CONSTRAINT cliente_telefone_key UNIQUE (telefone),
    CONSTRAINT fk_plano FOREIGN KEY (plano_id)
        REFERENCES public.plano (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.cliente
    OWNER to postgres;