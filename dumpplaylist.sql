--
-- PostgreSQL database dump
--

-- Dumped from database version 17.5
-- Dumped by pg_dump version 17.5

-- Started on 2026-04-22 04:00:17

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
-- TOC entry 219 (class 1259 OID 17151)
-- Name: autores; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.autores (
    id_autor integer NOT NULL,
    nome character varying(35) NOT NULL,
    generos integer
);


ALTER TABLE public.autores OWNER TO postgres;

--
-- TOC entry 222 (class 1259 OID 17198)
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
-- TOC entry 220 (class 1259 OID 17158)
-- Name: generos; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.generos (
    id_genero integer NOT NULL,
    nome character varying(15) NOT NULL
);


ALTER TABLE public.generos OWNER TO postgres;

--
-- TOC entry 223 (class 1259 OID 17199)
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
-- TOC entry 217 (class 1259 OID 17141)
-- Name: musicas; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.musicas (
    id_musica integer NOT NULL,
    titulo character varying(40) NOT NULL,
    duracao character varying(8) NOT NULL,
    id_album integer,
    ano character varying(4),
    id_genero integer,
    artista integer NOT NULL
);


ALTER TABLE public.musicas OWNER TO postgres;

--
-- TOC entry 224 (class 1259 OID 17200)
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
-- TOC entry 221 (class 1259 OID 17163)
-- Name: musicas_playlist; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.musicas_playlist (
    id_playlist integer NOT NULL,
    id_musica integer NOT NULL
);


ALTER TABLE public.musicas_playlist OWNER TO postgres;

--
-- TOC entry 218 (class 1259 OID 17146)
-- Name: playlists; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.playlists (
    id_playlist integer NOT NULL,
    nome character varying(25) NOT NULL,
    tipo character varying[] NOT NULL
);


ALTER TABLE public.playlists OWNER TO postgres;

--
-- TOC entry 225 (class 1259 OID 17201)
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
-- TOC entry 4924 (class 0 OID 17151)
-- Dependencies: 219
-- Data for Name: autores; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.autores (id_autor, nome, generos) FROM stdin;
2	tom	1
3	car	1
4	petty	1
5	jogn	1
\.


--
-- TOC entry 4925 (class 0 OID 17158)
-- Dependencies: 220
-- Data for Name: generos; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.generos (id_genero, nome) FROM stdin;
1	a
2	g
4	funk
5	not brega
\.


--
-- TOC entry 4922 (class 0 OID 17141)
-- Dependencies: 217
-- Data for Name: musicas; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.musicas (id_musica, titulo, duracao, id_album, ano, id_genero, artista) FROM stdin;
\.


--
-- TOC entry 4926 (class 0 OID 17163)
-- Dependencies: 221
-- Data for Name: musicas_playlist; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.musicas_playlist (id_playlist, id_musica) FROM stdin;
\.


--
-- TOC entry 4923 (class 0 OID 17146)
-- Dependencies: 218
-- Data for Name: playlists; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.playlists (id_playlist, nome, tipo) FROM stdin;
\.


--
-- TOC entry 4936 (class 0 OID 0)
-- Dependencies: 222
-- Name: autores_id_autor_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.autores_id_autor_seq', 5, true);


--
-- TOC entry 4937 (class 0 OID 0)
-- Dependencies: 223
-- Name: generos_id_genero_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.generos_id_genero_seq', 5, true);


--
-- TOC entry 4938 (class 0 OID 0)
-- Dependencies: 224
-- Name: musicas_id_musica_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.musicas_id_musica_seq', 1, true);


--
-- TOC entry 4939 (class 0 OID 0)
-- Dependencies: 225
-- Name: playlists_id_playlist_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.playlists_id_playlist_seq', 1, false);


--
-- TOC entry 4766 (class 2606 OID 17155)
-- Name: autores autores_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.autores
    ADD CONSTRAINT autores_pkey PRIMARY KEY (id_autor);


--
-- TOC entry 4768 (class 2606 OID 17162)
-- Name: generos generos_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.generos
    ADD CONSTRAINT generos_pkey PRIMARY KEY (id_genero);


--
-- TOC entry 4762 (class 2606 OID 17145)
-- Name: musicas musicas_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.musicas
    ADD CONSTRAINT musicas_pkey PRIMARY KEY (id_musica);


--
-- TOC entry 4770 (class 2606 OID 17167)
-- Name: musicas_playlist musicas_playlist_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.musicas_playlist
    ADD CONSTRAINT musicas_playlist_pkey PRIMARY KEY (id_playlist, id_musica);


--
-- TOC entry 4764 (class 2606 OID 17150)
-- Name: playlists playlists_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.playlists
    ADD CONSTRAINT playlists_pkey PRIMARY KEY (id_playlist);


--
-- TOC entry 4774 (class 2606 OID 17168)
-- Name: autores autores_generos_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.autores
    ADD CONSTRAINT autores_generos_fkey FOREIGN KEY (generos) REFERENCES public.generos(id_genero) NOT VALID;


--
-- TOC entry 4771 (class 2606 OID 17178)
-- Name: musicas musicas_artista_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.musicas
    ADD CONSTRAINT musicas_artista_fkey FOREIGN KEY (artista) REFERENCES public.autores(id_autor) NOT VALID;


--
-- TOC entry 4772 (class 2606 OID 17173)
-- Name: musicas musicas_id_album_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.musicas
    ADD CONSTRAINT musicas_id_album_fkey FOREIGN KEY (id_album) REFERENCES public.playlists(id_playlist) NOT VALID;


--
-- TOC entry 4773 (class 2606 OID 17183)
-- Name: musicas musicas_id_genero_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.musicas
    ADD CONSTRAINT musicas_id_genero_fkey FOREIGN KEY (id_genero) REFERENCES public.generos(id_genero) NOT VALID;


--
-- TOC entry 4775 (class 2606 OID 17193)
-- Name: musicas_playlist musicas_playlist_id_musica_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.musicas_playlist
    ADD CONSTRAINT musicas_playlist_id_musica_fkey FOREIGN KEY (id_musica) REFERENCES public.musicas(id_musica) NOT VALID;


--
-- TOC entry 4776 (class 2606 OID 17188)
-- Name: musicas_playlist musicas_playlist_id_playlist_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.musicas_playlist
    ADD CONSTRAINT musicas_playlist_id_playlist_fkey FOREIGN KEY (id_playlist) REFERENCES public.playlists(id_playlist) NOT VALID;


-- Completed on 2026-04-22 04:00:17

--
-- PostgreSQL database dump complete
--

