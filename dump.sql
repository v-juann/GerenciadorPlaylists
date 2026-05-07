--
-- PostgreSQL database dump
--

\restrict e4nN3MB6cVY55zsJbFsdx8yyJcNFaJzaiFrBMBlkj3gIxqsPmRSq5PzjQ3AxFBt

-- Dumped from database version 18.2
-- Dumped by pg_dump version 18.2

-- Started on 2026-05-07 18:13:54

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET transaction_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 219 (class 1259 OID 30992)
-- Name: autores; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.autores (
    id_autor integer NOT NULL,
    nome character varying(35) NOT NULL,
    generos integer
);


ALTER TABLE public.autores OWNER TO postgres;

--
-- TOC entry 220 (class 1259 OID 30997)
-- Name: autores_id_autor_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

ALTER TABLE public.autores ALTER COLUMN id_autor ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.autores_id_autor_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- TOC entry 221 (class 1259 OID 30998)
-- Name: generos; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.generos (
    id_genero integer NOT NULL,
    nome character varying(15) NOT NULL
);


ALTER TABLE public.generos OWNER TO postgres;

--
-- TOC entry 222 (class 1259 OID 31003)
-- Name: generos_id_genero_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

ALTER TABLE public.generos ALTER COLUMN id_genero ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.generos_id_genero_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- TOC entry 223 (class 1259 OID 31004)
-- Name: musicas; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.musicas (
    id_musica integer NOT NULL,
    titulo character varying(40) NOT NULL,
    duracao character varying(8) NOT NULL,
    ano character varying(4),
    id_genero integer,
    artista integer NOT NULL
);


ALTER TABLE public.musicas OWNER TO postgres;

--
-- TOC entry 224 (class 1259 OID 31011)
-- Name: musicas_id_musica_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

ALTER TABLE public.musicas ALTER COLUMN id_musica ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.musicas_id_musica_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- TOC entry 225 (class 1259 OID 31012)
-- Name: musicas_playlist; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.musicas_playlist (
    id_playlist integer NOT NULL,
    id_musica integer NOT NULL
);


ALTER TABLE public.musicas_playlist OWNER TO postgres;

--
-- TOC entry 226 (class 1259 OID 31017)
-- Name: playlists; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.playlists (
    id_playlist integer NOT NULL,
    nome character varying(25) NOT NULL
);


ALTER TABLE public.playlists OWNER TO postgres;

--
-- TOC entry 227 (class 1259 OID 31025)
-- Name: playlists_id_playlist_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

ALTER TABLE public.playlists ALTER COLUMN id_playlist ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.playlists_id_playlist_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- TOC entry 5036 (class 0 OID 30992)
-- Dependencies: 219
-- Data for Name: autores; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.autores (id_autor, nome, generos) FROM stdin;
\.


--
-- TOC entry 5038 (class 0 OID 30998)
-- Dependencies: 221
-- Data for Name: generos; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.generos (id_genero, nome) FROM stdin;
\.


--
-- TOC entry 5040 (class 0 OID 31004)
-- Dependencies: 223
-- Data for Name: musicas; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.musicas (id_musica, titulo, duracao, ano, id_genero, artista) FROM stdin;
\.


--
-- TOC entry 5042 (class 0 OID 31012)
-- Dependencies: 225
-- Data for Name: musicas_playlist; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.musicas_playlist (id_playlist, id_musica) FROM stdin;
\.


--
-- TOC entry 5043 (class 0 OID 31017)
-- Dependencies: 226
-- Data for Name: playlists; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.playlists (id_playlist, nome) FROM stdin;
\.


--
-- TOC entry 5050 (class 0 OID 0)
-- Dependencies: 220
-- Name: autores_id_autor_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.autores_id_autor_seq', 26, true);


--
-- TOC entry 5051 (class 0 OID 0)
-- Dependencies: 222
-- Name: generos_id_genero_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.generos_id_genero_seq', 21, true);


--
-- TOC entry 5052 (class 0 OID 0)
-- Dependencies: 224
-- Name: musicas_id_musica_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.musicas_id_musica_seq', 21, true);


--
-- TOC entry 5053 (class 0 OID 0)
-- Dependencies: 227
-- Name: playlists_id_playlist_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.playlists_id_playlist_seq', 15, true);


--
-- TOC entry 4876 (class 2606 OID 31027)
-- Name: autores autores_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.autores
    ADD CONSTRAINT autores_pkey PRIMARY KEY (id_autor);


--
-- TOC entry 4878 (class 2606 OID 31029)
-- Name: generos generos_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.generos
    ADD CONSTRAINT generos_pkey PRIMARY KEY (id_genero);


--
-- TOC entry 4880 (class 2606 OID 31031)
-- Name: musicas musicas_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.musicas
    ADD CONSTRAINT musicas_pkey PRIMARY KEY (id_musica);


--
-- TOC entry 4882 (class 2606 OID 31033)
-- Name: musicas_playlist musicas_playlist_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.musicas_playlist
    ADD CONSTRAINT musicas_playlist_pkey PRIMARY KEY (id_playlist, id_musica);


--
-- TOC entry 4884 (class 2606 OID 31035)
-- Name: playlists playlists_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.playlists
    ADD CONSTRAINT playlists_pkey PRIMARY KEY (id_playlist);


--
-- TOC entry 4885 (class 2606 OID 31036)
-- Name: autores autores_generos_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.autores
    ADD CONSTRAINT autores_generos_fkey FOREIGN KEY (generos) REFERENCES public.generos(id_genero) NOT VALID;


--
-- TOC entry 4888 (class 2606 OID 31081)
-- Name: musicas_playlist fk_musicas_playlist_playlist; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.musicas_playlist
    ADD CONSTRAINT fk_musicas_playlist_playlist FOREIGN KEY (id_playlist) REFERENCES public.playlists(id_playlist) ON DELETE CASCADE;


--
-- TOC entry 4886 (class 2606 OID 31041)
-- Name: musicas musicas_artista_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.musicas
    ADD CONSTRAINT musicas_artista_fkey FOREIGN KEY (artista) REFERENCES public.autores(id_autor) NOT VALID;


--
-- TOC entry 4887 (class 2606 OID 31051)
-- Name: musicas musicas_id_genero_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.musicas
    ADD CONSTRAINT musicas_id_genero_fkey FOREIGN KEY (id_genero) REFERENCES public.generos(id_genero) NOT VALID;


-- Completed on 2026-05-07 18:13:54

--
-- PostgreSQL database dump complete
--

\unrestrict e4nN3MB6cVY55zsJbFsdx8yyJcNFaJzaiFrBMBlkj3gIxqsPmRSq5PzjQ3AxFBt

