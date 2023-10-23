-- Database generated with pgModeler (PostgreSQL Database Modeler).
-- pgModeler version: 1.1.0-alpha
-- PostgreSQL version: 15.0
-- Project Site: pgmodeler.io
-- Model Author: ---

-- Database creation must be performed outside a multi lined SQL file. 
-- These commands were put in this file only as a convenience.
-- 
-- object: new_database | type: DATABASE --
-- DROP DATABASE IF EXISTS new_database;
CREATE DATABASE new_database;
-- ddl-end --


-- object: "Arena" | type: SCHEMA --
-- DROP SCHEMA IF EXISTS "Arena" CASCADE;
CREATE SCHEMA "Arena";
-- ddl-end --
ALTER SCHEMA "Arena" OWNER TO postgres;
-- ddl-end --

SET search_path TO pg_catalog,public,"Arena";
-- ddl-end --

-- object: public."Competidor" | type: TABLE --
-- DROP TABLE IF EXISTS public."Competidor" CASCADE;
CREATE TABLE public."Competidor" (
	id smallint NOT NULL GENERATED ALWAYS AS IDENTITY ,
	nome text NOT NULL,
	"dtNascimento" date NOT NULL,
	"id_Academia" smallint,
	"id_Faixa" smallint,
	"id_Endereco" smallint,
	CONSTRAINT "Competidores_pk" PRIMARY KEY (id)
);
-- ddl-end --
ALTER TABLE public."Competidor" OWNER TO postgres;
-- ddl-end --

-- object: public."Academia" | type: TABLE --
-- DROP TABLE IF EXISTS public."Academia" CASCADE;
CREATE TABLE public."Academia" (
	id smallint NOT NULL GENERATED ALWAYS AS IDENTITY ,
	"idProfessor" smallint NOT NULL,
	"id_Professor" smallint,
	nome text,
	CONSTRAINT "Academias_pk" PRIMARY KEY (id)
);
-- ddl-end --
ALTER TABLE public."Academia" OWNER TO postgres;
-- ddl-end --

-- object: public."Categoria" | type: TABLE --
-- DROP TABLE IF EXISTS public."Categoria" CASCADE;
CREATE TABLE public."Categoria" (
	id smallint NOT NULL GENERATED ALWAYS AS IDENTITY ,
	nome text,
	CONSTRAINT "Categorias_pk" PRIMARY KEY (id)
);
-- ddl-end --
ALTER TABLE public."Categoria" OWNER TO postgres;
-- ddl-end --

-- object: public."Faixa" | type: TABLE --
-- DROP TABLE IF EXISTS public."Faixa" CASCADE;
CREATE TABLE public."Faixa" (
	id smallint NOT NULL GENERATED ALWAYS AS IDENTITY ,
	cor smallint,
	CONSTRAINT "Faixas_pk" PRIMARY KEY (id)
);
-- ddl-end --
ALTER TABLE public."Faixa" OWNER TO postgres;
-- ddl-end --

-- object: public."Professor" | type: TABLE --
-- DROP TABLE IF EXISTS public."Professor" CASCADE;
CREATE TABLE public."Professor" (
	id smallint NOT NULL GENERATED ALWAYS AS IDENTITY ,
	nome text NOT NULL,
	email text NOT NULL,
	celular text NOT NULL,
	CONSTRAINT "Professor_pk" PRIMARY KEY (id)
);
-- ddl-end --
ALTER TABLE public."Professor" OWNER TO postgres;
-- ddl-end --

-- object: "Professor_fk" | type: CONSTRAINT --
-- ALTER TABLE public."Academia" DROP CONSTRAINT IF EXISTS "Professor_fk" CASCADE;
ALTER TABLE public."Academia" ADD CONSTRAINT "Professor_fk" FOREIGN KEY ("id_Professor")
REFERENCES public."Professor" (id) MATCH FULL
ON DELETE SET NULL ON UPDATE CASCADE;
-- ddl-end --

-- object: "Academia_fk" | type: CONSTRAINT --
-- ALTER TABLE public."Competidor" DROP CONSTRAINT IF EXISTS "Academia_fk" CASCADE;
ALTER TABLE public."Competidor" ADD CONSTRAINT "Academia_fk" FOREIGN KEY ("id_Academia")
REFERENCES public."Academia" (id) MATCH FULL
ON DELETE SET NULL ON UPDATE CASCADE;
-- ddl-end --

-- object: public."Endereco" | type: TABLE --
-- DROP TABLE IF EXISTS public."Endereco" CASCADE;
CREATE TABLE public."Endereco" (
	id smallint NOT NULL GENERATED ALWAYS AS IDENTITY ,
	rua text NOT NULL,
	complemento text,
	numero int4,
	"id_Cidade" smallint,
	"CEP" varchar(9),
	CONSTRAINT "Enderecos_pk" PRIMARY KEY (id)
);
-- ddl-end --
ALTER TABLE public."Endereco" OWNER TO postgres;
-- ddl-end --

-- object: public."Cidade" | type: TABLE --
-- DROP TABLE IF EXISTS public."Cidade" CASCADE;
CREATE TABLE public."Cidade" (
	id smallint NOT NULL GENERATED ALWAYS AS IDENTITY ,
	nome text NOT NULL,
	CONSTRAINT "Cidades_pk" PRIMARY KEY (id)
);
-- ddl-end --
ALTER TABLE public."Cidade" OWNER TO postgres;
-- ddl-end --

-- object: "Faixa_fk" | type: CONSTRAINT --
-- ALTER TABLE public."Competidor" DROP CONSTRAINT IF EXISTS "Faixa_fk" CASCADE;
ALTER TABLE public."Competidor" ADD CONSTRAINT "Faixa_fk" FOREIGN KEY ("id_Faixa")
REFERENCES public."Faixa" (id) MATCH FULL
ON DELETE SET NULL ON UPDATE CASCADE;
-- ddl-end --

-- object: "Cidade_fk" | type: CONSTRAINT --
-- ALTER TABLE public."Endereco" DROP CONSTRAINT IF EXISTS "Cidade_fk" CASCADE;
ALTER TABLE public."Endereco" ADD CONSTRAINT "Cidade_fk" FOREIGN KEY ("id_Cidade")
REFERENCES public."Cidade" (id) MATCH FULL
ON DELETE SET NULL ON UPDATE CASCADE;
-- ddl-end --

-- object: "Endereco_fk" | type: CONSTRAINT --
-- ALTER TABLE public."Competidor" DROP CONSTRAINT IF EXISTS "Endereco_fk" CASCADE;
ALTER TABLE public."Competidor" ADD CONSTRAINT "Endereco_fk" FOREIGN KEY ("id_Endereco")
REFERENCES public."Endereco" (id) MATCH FULL
ON DELETE SET NULL ON UPDATE CASCADE;
-- ddl-end --

-- object: "Competidor_uq" | type: CONSTRAINT --
-- ALTER TABLE public."Competidor" DROP CONSTRAINT IF EXISTS "Competidor_uq" CASCADE;
ALTER TABLE public."Competidor" ADD CONSTRAINT "Competidor_uq" UNIQUE ("id_Endereco");
-- ddl-end --

-- object: public."Area" | type: TABLE --
-- DROP TABLE IF EXISTS public."Area" CASCADE;
CREATE TABLE public."Area" (
	id smallint NOT NULL GENERATED ALWAYS AS IDENTITY ,
	nome text,
	"id_Chave" int8,
	obs text,
	"hrInicioCombate" timestamp,
	"hrFimCombate" timestamp,
	CONSTRAINT "Area_pk" PRIMARY KEY (id)
);
-- ddl-end --
ALTER TABLE public."Area" OWNER TO postgres;
-- ddl-end --

-- object: public."Evento" | type: TABLE --
-- DROP TABLE IF EXISTS public."Evento" CASCADE;
CREATE TABLE public."Evento" (
	id smallint NOT NULL GENERATED ALWAYS AS IDENTITY ,
	nome text NOT NULL,
	"dtEvento" date NOT NULL,
	CONSTRAINT "Evento_pk" PRIMARY KEY (id)
);
-- ddl-end --
ALTER TABLE public."Evento" OWNER TO postgres;
-- ddl-end --

-- object: public."Chave" | type: TABLE --
-- DROP TABLE IF EXISTS public."Chave" CASCADE;
CREATE TABLE public."Chave" (
	id int8 NOT NULL,
	id_inscricao smallint,
	id_inscricao1 smallint,
	CONSTRAINT chaves_pk PRIMARY KEY (id)
);
-- ddl-end --
ALTER TABLE public."Chave" OWNER TO postgres;
-- ddl-end --

-- object: public.inscricao | type: TABLE --
-- DROP TABLE IF EXISTS public.inscricao CASCADE;
CREATE TABLE public.inscricao (
	id smallint NOT NULL GENERATED ALWAYS AS IDENTITY ,
	pago boolean,
	"dtIncricao" timestamp,
	"id_Evento" smallint,
	"id_Categoria" smallint,
	"id_Competidor" smallint,
	CONSTRAINT incricoes_pk PRIMARY KEY (id)
);
-- ddl-end --
ALTER TABLE public.inscricao OWNER TO postgres;
-- ddl-end --

-- object: "Evento_fk" | type: CONSTRAINT --
-- ALTER TABLE public.inscricao DROP CONSTRAINT IF EXISTS "Evento_fk" CASCADE;
ALTER TABLE public.inscricao ADD CONSTRAINT "Evento_fk" FOREIGN KEY ("id_Evento")
REFERENCES public."Evento" (id) MATCH FULL
ON DELETE SET NULL ON UPDATE CASCADE;
-- ddl-end --

-- object: "Categoria_fk" | type: CONSTRAINT --
-- ALTER TABLE public.inscricao DROP CONSTRAINT IF EXISTS "Categoria_fk" CASCADE;
ALTER TABLE public.inscricao ADD CONSTRAINT "Categoria_fk" FOREIGN KEY ("id_Categoria")
REFERENCES public."Categoria" (id) MATCH FULL
ON DELETE SET NULL ON UPDATE CASCADE;
-- ddl-end --

-- object: inscricao_uq | type: CONSTRAINT --
-- ALTER TABLE public.inscricao DROP CONSTRAINT IF EXISTS inscricao_uq CASCADE;
ALTER TABLE public.inscricao ADD CONSTRAINT inscricao_uq UNIQUE ("id_Categoria");
-- ddl-end --

-- object: "Competidor_fk" | type: CONSTRAINT --
-- ALTER TABLE public.inscricao DROP CONSTRAINT IF EXISTS "Competidor_fk" CASCADE;
ALTER TABLE public.inscricao ADD CONSTRAINT "Competidor_fk" FOREIGN KEY ("id_Competidor")
REFERENCES public."Competidor" (id) MATCH FULL
ON DELETE SET NULL ON UPDATE CASCADE;
-- ddl-end --

-- object: inscricao_fk | type: CONSTRAINT --
-- ALTER TABLE public."Chave" DROP CONSTRAINT IF EXISTS inscricao_fk CASCADE;
ALTER TABLE public."Chave" ADD CONSTRAINT inscricao_fk FOREIGN KEY (id_inscricao)
REFERENCES public.inscricao (id) MATCH FULL
ON DELETE SET NULL ON UPDATE CASCADE;
-- ddl-end --

-- object: inscricao_fk1 | type: CONSTRAINT --
-- ALTER TABLE public."Chave" DROP CONSTRAINT IF EXISTS inscricao_fk1 CASCADE;
ALTER TABLE public."Chave" ADD CONSTRAINT inscricao_fk1 FOREIGN KEY (id_inscricao1)
REFERENCES public.inscricao (id) MATCH FULL
ON DELETE SET NULL ON UPDATE CASCADE;
-- ddl-end --

-- object: "Chave_fk" | type: CONSTRAINT --
-- ALTER TABLE public."Area" DROP CONSTRAINT IF EXISTS "Chave_fk" CASCADE;
ALTER TABLE public."Area" ADD CONSTRAINT "Chave_fk" FOREIGN KEY ("id_Chave")
REFERENCES public."Chave" (id) MATCH FULL
ON DELETE SET NULL ON UPDATE CASCADE;
-- ddl-end --

-- object: "Area_uq" | type: CONSTRAINT --
-- ALTER TABLE public."Area" DROP CONSTRAINT IF EXISTS "Area_uq" CASCADE;
ALTER TABLE public."Area" ADD CONSTRAINT "Area_uq" UNIQUE ("id_Chave");
-- ddl-end --

-- object: public."Mesario" | type: TABLE --
-- DROP TABLE IF EXISTS public."Mesario" CASCADE;
CREATE TABLE public."Mesario" (
	id smallint NOT NULL GENERATED ALWAYS AS IDENTITY ,
	nome text NOT NULL,
	"id_Area" smallint,
	CONSTRAINT "Mesario_pk" PRIMARY KEY (id)
);
-- ddl-end --
ALTER TABLE public."Mesario" OWNER TO postgres;
-- ddl-end --

-- object: "Area_fk" | type: CONSTRAINT --
-- ALTER TABLE public."Mesario" DROP CONSTRAINT IF EXISTS "Area_fk" CASCADE;
ALTER TABLE public."Mesario" ADD CONSTRAINT "Area_fk" FOREIGN KEY ("id_Area")
REFERENCES public."Area" (id) MATCH FULL
ON DELETE SET NULL ON UPDATE CASCADE;
-- ddl-end --

-- object: public.resultado_combate | type: TABLE --
-- DROP TABLE IF EXISTS public.resultado_combate CASCADE;
CREATE TABLE public.resultado_combate (
	id smallint NOT NULL GENERATED ALWAYS AS IDENTITY ,
	"id_Area" smallint,
	id_inscricao smallint,
	CONSTRAINT resultado_combate_pk PRIMARY KEY (id)
);
-- ddl-end --
ALTER TABLE public.resultado_combate OWNER TO postgres;
-- ddl-end --

-- object: "Area_fk" | type: CONSTRAINT --
-- ALTER TABLE public.resultado_combate DROP CONSTRAINT IF EXISTS "Area_fk" CASCADE;
ALTER TABLE public.resultado_combate ADD CONSTRAINT "Area_fk" FOREIGN KEY ("id_Area")
REFERENCES public."Area" (id) MATCH FULL
ON DELETE SET NULL ON UPDATE CASCADE;
-- ddl-end --

-- object: resultado_combate_uq | type: CONSTRAINT --
-- ALTER TABLE public.resultado_combate DROP CONSTRAINT IF EXISTS resultado_combate_uq CASCADE;
ALTER TABLE public.resultado_combate ADD CONSTRAINT resultado_combate_uq UNIQUE ("id_Area");
-- ddl-end --

-- object: inscricao_fk | type: CONSTRAINT --
-- ALTER TABLE public.resultado_combate DROP CONSTRAINT IF EXISTS inscricao_fk CASCADE;
ALTER TABLE public.resultado_combate ADD CONSTRAINT inscricao_fk FOREIGN KEY (id_inscricao)
REFERENCES public.inscricao (id) MATCH FULL
ON DELETE SET NULL ON UPDATE CASCADE;
-- ddl-end --

-- object: resultado_combate_uq1 | type: CONSTRAINT --
-- ALTER TABLE public.resultado_combate DROP CONSTRAINT IF EXISTS resultado_combate_uq1 CASCADE;
ALTER TABLE public.resultado_combate ADD CONSTRAINT resultado_combate_uq1 UNIQUE (id_inscricao);
-- ddl-end --


