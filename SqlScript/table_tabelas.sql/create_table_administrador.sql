-- Table: public.administrador

-- DROP TABLE IF EXISTS public.administrador;

CREATE TABLE IF NOT EXISTS public.administrador
(
    id integer SERIAL PRIMARY KEY,
    usuario character varying(20) COLLATE pg_catalog."default" NOT NULL,
    senha character varying(20) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT administrador_pkey PRIMARY KEY (id)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.administrador
    OWNER to postgres;