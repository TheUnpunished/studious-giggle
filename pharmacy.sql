--
-- PostgreSQL database dump
--

-- Dumped from database version 9.6.12
-- Dumped by pg_dump version 10.9 (Ubuntu 10.9-0ubuntu0.18.10.1)

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


--
-- Name: product_count_fun(); Type: FUNCTION; Schema: public; Owner: postgres
--

CREATE FUNCTION public.product_count_fun() RETURNS trigger
    LANGUAGE plpgsql
    AS $$BEGIN
	IF(TG_OP='INSERT') THEN
		UPDATE product set count = count - NEW.count where id = NEW.product_id;
	ELSIF(TG_OP='UPDATE') THEN
		UPDATE product set count = count - NEW.count + OLD.count where id = NEW.product_id;
	END IF;
	RETURN NULL;
END;
$$;


ALTER FUNCTION public.product_count_fun() OWNER TO postgres;

--
-- Name: shop_count_fun(); Type: FUNCTION; Schema: public; Owner: postgres
--

CREATE FUNCTION public.shop_count_fun() RETURNS trigger
    LANGUAGE plpgsql
    AS $$BEGIN
	IF (TG_OP = 'INSERT') THEN
		UPDATE shop set count = count + 1 where id = NEW.shop_id;
	ELSIF(TG_OP = 'DELETE') THEN
		UPDATE shop set count = count - 1 where id = OLD.shop_id;
	END IF;
	RETURN NULL;
END;
$$;


ALTER FUNCTION public.shop_count_fun() OWNER TO postgres;

--
-- Name: supplier_count_fun(); Type: FUNCTION; Schema: public; Owner: postgres
--

CREATE FUNCTION public.supplier_count_fun() RETURNS trigger
    LANGUAGE plpgsql
    AS $$BEGIN
	IF(TG_OP = 'DELETE') THEN
		UPDATE supplier set count = count - 1 where id = OLD.supplier_id;
	ELSIF(TG_OP = 'INSERT') THEN
		UPDATE supplier set count = count + 1 where id = NEW.supplier_id;
	END IF;
	RETURN NULL;
END;
$$;


ALTER FUNCTION public.supplier_count_fun() OWNER TO postgres;

--
-- Name: type_count_fun(); Type: FUNCTION; Schema: public; Owner: postgres
--

CREATE FUNCTION public.type_count_fun() RETURNS trigger
    LANGUAGE plpgsql
    AS $$BEGIN
	IF(TG_OP = 'INSERT') THEN
		UPDATE product_type set count = count + 1 where id = NEW.type_id;
	ELSIF(TG_OP = 'DELETE') THEN
		UPDATE product_type set count = count - 1 where id = OLD.type_id;
	END IF;
	RETURN NULL;
END;
$$;


ALTER FUNCTION public.type_count_fun() OWNER TO postgres;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: product; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.product (
    id bigint NOT NULL,
    name text,
    price double precision,
    count integer,
    supplier_id bigint,
    shop_id bigint,
    type_id bigint
);


ALTER TABLE public.product OWNER TO postgres;

--
-- Name: product_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.product_seq
    START WITH 0
    INCREMENT BY 1
    MINVALUE 0
    MAXVALUE 1000000000000000000
    CACHE 1;


ALTER TABLE public.product_seq OWNER TO postgres;

--
-- Name: product_type; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.product_type (
    id bigint NOT NULL,
    name text,
    count bigint DEFAULT 0
);


ALTER TABLE public.product_type OWNER TO postgres;

--
-- Name: purchase; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.purchase (
    id bigint NOT NULL,
    product_id bigint,
    count integer,
    total_price double precision,
    date date DEFAULT now()
);


ALTER TABLE public.purchase OWNER TO postgres;

--
-- Name: purchase_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.purchase_seq
    START WITH 0
    INCREMENT BY 1
    MINVALUE 0
    MAXVALUE 1000000000000000000
    CACHE 1;


ALTER TABLE public.purchase_seq OWNER TO postgres;

--
-- Name: shop; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.shop (
    id bigint NOT NULL,
    name text,
    address text,
    count bigint DEFAULT 0,
    phone character varying(12)
);


ALTER TABLE public.shop OWNER TO postgres;

--
-- Name: shop_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.shop_seq
    START WITH 0
    INCREMENT BY 1
    MINVALUE 0
    MAXVALUE 1000000000000000000
    CACHE 1;


ALTER TABLE public.shop_seq OWNER TO postgres;

--
-- Name: supplier; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.supplier (
    id bigint NOT NULL,
    name text,
    count bigint DEFAULT 0,
    phone text,
    address text
);


ALTER TABLE public.supplier OWNER TO postgres;

--
-- Name: supplier_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.supplier_seq
    START WITH 0
    INCREMENT BY 1
    MINVALUE 0
    MAXVALUE 1000000000000000000
    CACHE 1;


ALTER TABLE public.supplier_seq OWNER TO postgres;

--
-- Name: type_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.type_seq
    START WITH 0
    INCREMENT BY 1
    MINVALUE 0
    MAXVALUE 1000000000000000000
    CACHE 1;


ALTER TABLE public.type_seq OWNER TO postgres;

--
-- Name: worker; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.worker (
    id bigint NOT NULL,
    name text,
    sec_name text,
    phone character varying(12),
    shop_id bigint
);


ALTER TABLE public.worker OWNER TO postgres;

--
-- Name: worker_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.worker_seq
    START WITH 0
    INCREMENT BY 1
    MINVALUE 0
    MAXVALUE 1000000000000000000
    CACHE 1;


ALTER TABLE public.worker_seq OWNER TO postgres;

--
-- Data for Name: product; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.product (id, name, price, count, supplier_id, shop_id, type_id) FROM stdin;
\.


--
-- Data for Name: product_type; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.product_type (id, name, count) FROM stdin;
\.


--
-- Data for Name: purchase; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.purchase (id, product_id, count, total_price, date) FROM stdin;
\.


--
-- Data for Name: shop; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.shop (id, name, address, count, phone) FROM stdin;
\.


--
-- Data for Name: supplier; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.supplier (id, name, count, phone, address) FROM stdin;
\.


--
-- Data for Name: worker; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.worker (id, name, sec_name, phone, shop_id) FROM stdin;
\.


--
-- Name: product_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.product_seq', 0, true);


--
-- Name: purchase_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.purchase_seq', 0, true);


--
-- Name: shop_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.shop_seq', 0, true);


--
-- Name: supplier_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.supplier_seq', 0, true);


--
-- Name: type_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.type_seq', 0, true);


--
-- Name: worker_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.worker_seq', 0, true);


--
-- Name: product product_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.product
    ADD CONSTRAINT product_pkey PRIMARY KEY (id);


--
-- Name: purchase purchase_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.purchase
    ADD CONSTRAINT purchase_pkey PRIMARY KEY (id);


--
-- Name: shop shop_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.shop
    ADD CONSTRAINT shop_pkey PRIMARY KEY (id);


--
-- Name: supplier supplier_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.supplier
    ADD CONSTRAINT supplier_pkey PRIMARY KEY (id);


--
-- Name: product_type type_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.product_type
    ADD CONSTRAINT type_pkey PRIMARY KEY (id);


--
-- Name: worker worker_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.worker
    ADD CONSTRAINT worker_pkey PRIMARY KEY (id);


--
-- Name: purchase purchase_count; Type: TRIGGER; Schema: public; Owner: postgres
--

CREATE TRIGGER purchase_count AFTER INSERT OR UPDATE ON public.purchase FOR EACH ROW EXECUTE PROCEDURE public.product_count_fun();


--
-- Name: product shop_count; Type: TRIGGER; Schema: public; Owner: postgres
--

CREATE TRIGGER shop_count AFTER INSERT OR DELETE ON public.product FOR EACH ROW EXECUTE PROCEDURE public.shop_count_fun();


--
-- Name: product supplier_count; Type: TRIGGER; Schema: public; Owner: postgres
--

CREATE TRIGGER supplier_count AFTER INSERT OR DELETE ON public.product FOR EACH ROW EXECUTE PROCEDURE public.supplier_count_fun();


--
-- Name: product type_count; Type: TRIGGER; Schema: public; Owner: postgres
--

CREATE TRIGGER type_count AFTER INSERT OR DELETE ON public.product FOR EACH ROW EXECUTE PROCEDURE public.type_count_fun();


--
-- Name: product fk_product_product_type; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.product
    ADD CONSTRAINT fk_product_product_type FOREIGN KEY (type_id) REFERENCES public.product_type(id);


--
-- Name: product fk_product_shop; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.product
    ADD CONSTRAINT fk_product_shop FOREIGN KEY (shop_id) REFERENCES public.shop(id);


--
-- Name: product fk_product_supplier; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.product
    ADD CONSTRAINT fk_product_supplier FOREIGN KEY (supplier_id) REFERENCES public.supplier(id);


--
-- Name: purchase fk_purchase_product; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.purchase
    ADD CONSTRAINT fk_purchase_product FOREIGN KEY (product_id) REFERENCES public.product(id);


--
-- Name: worker fk_worker_shop; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.worker
    ADD CONSTRAINT fk_worker_shop FOREIGN KEY (shop_id) REFERENCES public.shop(id);


--
-- PostgreSQL database dump complete
--

