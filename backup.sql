--
-- PostgreSQL database dump
--

\restrict SdIJ89sh4HB6YJXCuysYlB0cHblV1DzLKacsa19wSgVh6eke6fpxF6y1FgS3WBc

-- Dumped from database version 18.2
-- Dumped by pg_dump version 18.2

-- Started on 2026-05-08 09:10:28

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
1	Alice Johnson	2
2	Bob Smith	1
3	Carla Mendes	5
4	Diego Rivera	4
5	Eva Lopez	3
6	Frank White	7
7	Grace Kelly	6
8	Henry Adams	8
9	Isabel Torres	9
10	Jack Brown	10
11	Karen Davis	11
12	Leo Martin	12
13	Maria Silva	13
14	Nick Carter	14
15	Olivia Green	15
16	Peter Parker	16
17	Quinn Thompson	17
18	Rachel Kim	18
19	Steve Rogers	19
20	Tina Turner	20
21	Uma Thurman	21
22	Victor Hugo	1
23	Wendy Allen	2
24	Xavier Young	3
25	Yara Costa	4
\.


--
-- TOC entry 5038 (class 0 OID 30998)
-- Dependencies: 221
-- Data for Name: generos; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.generos (id_genero, nome) FROM stdin;
1	Rock
2	Pop
3	Jazz
4	Hip-Hop
5	Classical
6	Reggae
7	Blues
8	Electronic
9	Metal
10	Country
11	Funk
12	Soul
13	Punk
14	Disco
15	Folk
16	RnB
17	Indie
18	Gospel
19	Ska
20	Latin
21	Techno
\.


--
-- TOC entry 5040 (class 0 OID 31004)
-- Dependencies: 223
-- Data for Name: musicas; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.musicas (id_musica, titulo, duracao, ano, id_genero, artista) FROM stdin;
1	Sunrise Melody	03:45	2020	2	1
2	Thunder Road	04:12	2018	1	2
3	Blue Moon	05:05	2017	3	5
4	Rap Attack	03:30	2021	4	4
5	Symphony No.5	07:10	1808	5	3
6	Reggae Nights	04:50	2019	6	7
7	Blues Highway	06:20	2016	7	6
8	Electric Dreams	05:40	2022	8	8
9	Metal Storm	04:55	2020	9	9
10	Country Roads	03:35	2015	10	10
11	Funky Town	04:05	1980	11	11
12	Soul Train	05:15	1975	12	12
13	Punk Revolution	02:50	1977	13	13
14	Disco Fever	03:25	1979	14	14
15	Folk Tales	04:10	2010	15	15
16	RnB Groove	03:55	2021	16	16
17	Indie Waves	04:30	2022	17	17
18	Gospel Light	05:00	2018	18	18
19	Ska Parade	03:20	2019	19	19
20	Latin Fire	04:40	2020	20	20
21	Techno Pulse	06:00	2021	21	21
\.


--
-- TOC entry 5042 (class 0 OID 31012)
-- Dependencies: 225
-- Data for Name: musicas_playlist; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.musicas_playlist (id_playlist, id_musica) FROM stdin;
1	1
1	3
1	5
2	2
2	4
2	6
3	3
3	7
3	8
4	3
4	12
4	17
5	1
5	2
5	9
6	2
6	9
6	10
7	20
7	15
8	8
8	16
9	5
9	14
10	10
10	1
11	1
11	11
11	14
12	12
12	16
13	4
13	13
14	17
14	15
15	5
15	8
15	21
\.


--
-- TOC entry 5043 (class 0 OID 31017)
-- Dependencies: 226
-- Data for Name: playlists; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.playlists (id_playlist, nome) FROM stdin;
1	Morning Vibes
2	Workout Hits
3	Chillout Lounge
4	Jazz Essentials
5	Party Time
6	Rock Classics
7	Latin Beats
8	Focus Music
9	Evening Relax
10	Road Trip
11	Pop Favorites
12	Soulful Moments
13	Hip-Hop Vibes
14	Indie Discoveries
15	Sleep Tight
\.


--
-- TOC entry 5050 (class 0 OID 0)
-- Dependencies: 220
-- Name: autores_id_autor_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.autores_id_autor_seq', 25, true);


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


-- Completed on 2026-05-08 09:10:28

--
-- PostgreSQL database dump complete
--

\unrestrict SdIJ89sh4HB6YJXCuysYlB0cHblV1DzLKacsa19wSgVh6eke6fpxF6y1FgS3WBc

