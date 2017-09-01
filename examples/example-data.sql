--
-- PostgreSQL database dump
--

-- Dumped from database version 9.5.7
-- Dumped by pg_dump version 9.5.7

-- Started on 2017-07-18 15:11:03 CEST

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

SET search_path = public, pg_catalog;

--
-- TOC entry 4005 (class 0 OID 111150)
-- Dependencies: 205
-- Data for Name: codespace; Type: TABLE DATA; Schema: public; Owner: sos_user
--

COPY codespace (id, codespace) FROM stdin;
1	http://www.opengis.net/def/nil/OGC/0/unknown
\.


--
-- TOC entry 4013 (class 0 OID 111193)
-- Dependencies: 213
-- Data for Name: featuretype; Type: TABLE DATA; Schema: public; Owner: sos_user
--

COPY featuretype (id, type) FROM stdin;
1	http://www.opengis.net/def/samplingFeatureType/OGC-OM/2.0/SF_SamplingPoint
2	http://www.opengis.net/def/nil/OGC/0/unknown
\.


--
-- TOC entry 4012 (class 0 OID 111185)
-- Dependencies: 212
-- Data for Name: feature; Type: TABLE DATA; Schema: public; Owner: sos_user
--

COPY feature (id, hibernatediscriminator, featuretype, domainid, codespace, name, codespacename, description, geom, descriptionxml, url) FROM stdin;
1	\N	2	http://www.52north.org/test/featureOfInterest/world	1	\N	1	\N	\N	\N	\N
2	\N	2	http://www.52north.org/test/featureOfInterest/1	1	con terra	1	\N	0101000020E61000003F726BD26DE91E407D5EF1D423F14940	\N	\N
3	\N	2	http://www.52north.org/test/featureOfInterest/2	1	ESRI	1	\N	0101000020E6100000EB1D6E87864C5DC08255F5F23B074140	\N	\N
4	\N	2	http://www.52north.org/test/featureOfInterest/3	1	Kisters	1	\N	0101000020E610000014AAB2C82E8718400576C70892644940	\N	\N
5	\N	2	http://www.52north.org/test/featureOfInterest/4	1	con terra	1	\N	0101000020E61000003F726BD26DE91E407D5EF1D423F14940	\N	\N
6	\N	2	http://www.52north.org/test/featureOfInterest/5	1	TU-Dresden	1	\N	0101000020E6100000404EB4AB90722B401DE6CB0BB0834940	\N	\N
7	\N	2	http://www.52north.org/test/featureOfInterest/6	1	Hochschule Bochum	1	\N	0101000020E6100000083E062B4E151D4090D959F44EB94940	\N	\N
8	\N	2	http://www.52north.org/test/featureOfInterest/7	1	ITC	1	\N	0101000020E610000000958FEE31221140E45F15B9F1054A40	\N	\N
9	\N	2	http://www.52north.org/test/featureOfInterest/8	1	DLZ-IT	1	\N	\N	\N	\N
10	\N	2	http://www.52north.org/test/featureOfInterest/Heiden	1	Heiden	1	\N	0101000020E61000008C118942CBBA1B404D874ECFBBE94940	\N	\N
11	\N	2	http://www.52north.org/test/featureOfInterest/Münster/FE101	1	Münster/FE101	1	\N	0101000020E610000099B9C0E5B1861E405473B9C150F94940	\N	\N
12	\N	2	http://www.52north.org/test/featureOfInterest/Portland	1	Portland	1	\N	0101000020E61000001DC9E53FA4AB5EC0C3F5285C8FC24640	\N	\N
13	\N	2	http://www.52north.org/test/featureOfInterest/TODO	1	TODO	1	\N	0101000020E610000000000000000000000000000000000000	\N	\N
\.


--
-- TOC entry 4020 (class 0 OID 111231)
-- Dependencies: 220
-- Data for Name: observableproperty; Type: TABLE DATA; Schema: public; Owner: sos_user
--

COPY observableproperty (id, domainid, codespace, name, codespacename, description, disabled, hiddenchild) FROM stdin;
1	http://www.52north.org/test/observableProperty/1	1	test_observable_property_1	1	\N	F	F
2	http://www.52north.org/test/observableProperty/2	1	test_observable_property_2	1	\N	F	F
3	http://www.52north.org/test/observableProperty/3	1	test_observable_property_3	1	\N	F	F
4	http://www.52north.org/test/observableProperty/4	1	test_observable_property_4	1	\N	F	F
5	http://www.52north.org/test/observableProperty/5	1	test_observable_property_5	1	\N	F	F
6	http://www.52north.org/test/observableProperty/6	1	test_observable_property_6	1	\N	F	F
7	http://www.52north.org/test/observableProperty/7	1	test_observable_property_7	1	\N	F	F
8	http://www.52north.org/test/observableProperty/8	1	test_observable_property_8	1	\N	F	F
9	http://www.52north.org/test/observableProperty/developer	1	developer	1	\N	F	F
\.



COPY category (id, domainid, name, description) FROM stdin;
1	http://www.52north.org/test/observableProperty/1	test_observable_property_1	\N
2	http://www.52north.org/test/observableProperty/2	test_observable_property_2	\N
3	http://www.52north.org/test/observableProperty/3	test_observable_property_3	\N
4	http://www.52north.org/test/observableProperty/4	test_observable_property_4	\N
5	http://www.52north.org/test/observableProperty/5	test_observable_property_5	\N
6	http://www.52north.org/test/observableProperty/6	test_observable_property_6	\N
7	http://www.52north.org/test/observableProperty/7	test_observable_property_7	\N
8	http://www.52north.org/test/observableProperty/8	test_observable_property_8	\N
9	http://www.52north.org/test/observableProperty/developer	developer	\N
\.



--
-- TOC entry 4025 (class 0 OID 111276)
-- Dependencies: 225
-- Data for Name: offering; Type: TABLE DATA; Schema: public; Owner: sos_user
--

COPY offering (id, domainid, codespace, name, codespacename, description, disabled, phenomenontimestart, phenomenontimeend, resulttimestart, resulttimeend) FROM stdin;
1	http://www.52north.org/test/offering/1	\N	Offering for sensor 1	\N	\N	F	1970-01-01 00:00:00	1970-01-01 00:00:00	1970-01-01 00:00:00	1970-01-01 00:00:00
2	http://www.52north.org/test/offering/2	\N	Offering for sensor 2	\N	\N	F	1970-01-01 00:00:00	1970-01-01 00:00:00	1970-01-01 00:00:00	1970-01-01 00:00:00
3	http://www.52north.org/test/offering/3	\N	Offering for sensor 3	\N	\N	F	1970-01-01 00:00:00	1970-01-01 00:00:00	1970-01-01 00:00:00	1970-01-01 00:00:00
4	http://www.52north.org/test/offering/4	\N	Offering for sensor 2	\N	\N	F	1970-01-01 00:00:00	1970-01-01 00:00:00	1970-01-01 00:00:00	1970-01-01 00:00:00
5	http://www.52north.org/test/offering/5	\N	Offering for sensor 5	\N	\N	F	1970-01-01 00:00:00	1970-01-01 00:00:00	1970-01-01 00:00:00	1970-01-01 00:00:00
6	http://www.52north.org/test/offering/6	\N	Offering for sensor 6	\N	\N	F	1970-01-01 00:00:00	1970-01-01 00:00:00	1970-01-01 00:00:00	1970-01-01 00:00:00
7	http://www.52north.org/test/offering/7	\N	Offering for sensor 7	\N	\N	F	1970-01-01 00:00:00	1970-01-01 00:00:00	1970-01-01 00:00:00	1970-01-01 00:00:00
8	http://www.52north.org/test/offering/8	\N	Offering for sensor 8	\N	\N	F	1970-01-01 00:00:00	1970-01-01 00:00:00	1970-01-01 00:00:00	1970-01-01 00:00:00
9	http://www.52north.org/test/offering/developer	\N	Offering for procedure developer	\N	\N	F	1970-01-01 00:00:00	1970-01-01 00:00:00	1970-01-01 00:00:00	1970-01-01 00:00:00
\.


--
-- TOC entry 4031 (class 0 OID 111311)
-- Dependencies: 231
-- Data for Name: proceduredescriptionformat; Type: TABLE DATA; Schema: public; Owner: sos_user
--

COPY proceduredescriptionformat (id, proceduredescriptionformat) FROM stdin;
1	http://www.opengis.net/sensorML/1.0.1
\.


--
-- TOC entry 3997 (class 0 OID 111086)
-- Dependencies: 197
-- Data for Name: procedure; Type: TABLE DATA; Schema: public; Owner: sos_user
--

COPY procedure (id, proceduredescriptionformat, domainid, codespace, name, codespacename, description, deleted, disabled, descriptionfile, referenceflag, typeof, istype, isaggregation, mobile, insitu) FROM stdin;
1	1	http://www.52north.org/test/procedure/1	\N	con terra	\N	\N	F	F	\N	F	\N	F	F	F	T
2	1	http://www.52north.org/test/procedure/2	\N	ESRI	\N	\N	F	F	\N	F	\N	F	F	F	T
3	1	http://www.52north.org/test/procedure/3	\N	Kisters	\N	\N	F	F	\N	F	\N	F	F	F	T
4	1	http://www.52north.org/test/procedure/4	\N	IfGI	\N	\N	F	F	\N	F	\N	F	F	F	T
5	1	http://www.52north.org/test/procedure/5	\N	TU-Dresden	\N	\N	T	F	\N	F	\N	F	F	F	T
6	1	http://www.52north.org/test/procedure/6	\N	Hochschule Bochum	\N	\N	F	F	\N	F	\N	F	F	F	T
7	1	http://www.52north.org/test/procedure/7	\N	ITC	\N	\N	F	F	\N	F	\N	F	F	F	T
8	1	http://www.52north.org/test/procedure/8	\N	DLZ-IT	\N	\N	F	F	\N	F	\N	F	F	T	T
9	1	http://www.52north.org/test/procedure/developer	\N	http://www.52north.org/test/procedure/developer	\N	\N	F	F	\N	F	\N	F	F	F	T
\.


--
-- TOC entry 4045 (class 0 OID 111402)
-- Dependencies: 245
-- Data for Name: unit; Type: TABLE DATA; Schema: public; Owner: sos_user
--

COPY unit (id, unit, name, link) FROM stdin;
1	test_unit_1	\N	\N
2	test_unit_4	\N	\N
3	test_unit_6	\N	\N
4	test_unit_7	\N	\N
5	test_unit_8	\N	\N
\.




--
-- TOC entry 4024 (class 0 OID 111271)
-- Dependencies: 224
-- Data for Name: observationtype; Type: TABLE DATA; Schema: public; Owner: sos_user
--

COPY observationtype (id, type) FROM stdin;
1	http://www.opengis.net/def/observationType/OGC-OM/2.0/OM_Measurement
2	http://www.opengis.net/def/observationType/OGC-OM/2.0/OM_CountObservation
3	http://www.opengis.net/def/observationType/OGC-OM/2.0/OM_TruthObservation
4	http://www.opengis.net/def/observationType/OGC-OM/2.0/OM_CategoryObservation
5	http://www.opengis.net/def/observationType/OGC-OM/2.0/OM_TextObservation
\.


--
-- TOC entry 4022 (class 0 OID 111257)
-- Dependencies: 222
-- Data for Name: observationconstellation; Type: TABLE DATA; Schema: public; Owner: sos_user
--

COPY observationconstellation (id, observableproperty, procedure, observationtype, offering, hiddenchild) FROM stdin;
1	1	1	1	1	F
2	2	2	2	2	F
3	3	3	3	3	F
4	4	4	4	4	F
5	5	5	5	5	F
6	6	6	1	6	F
7	7	7	1	7	F
8	8	8	1	8	F
9	9	9	5	9	F
\.


--
-- TOC entry 4075 (class 0 OID 0)
-- Dependencies: 253
-- Name: observationconstellation_seq; Type: SEQUENCE SET; Schema: public; Owner: sos_user
--

SELECT pg_catalog.setval('observationconstellation_seq', 9, true);


--
-- TOC entry 4040 (class 0 OID 111362)
-- Dependencies: 240
-- Data for Name: dataset; Type: TABLE DATA; Schema: public; Owner: sos_user
--

COPY dataset (id, feature, category, observationconstellation, deleted, published, hiddenchild, firsttimestamp, lasttimestamp, unit, domainid, codespace, name, codespacename, description, valuetype) FROM stdin;
2	3	2	2	F	T	F	2012-11-19 13:00:00	2012-11-19 13:09:00	\N	\N	\N	\N	\N	\N	count
9	10	9	9	F	T	F	2008-10-29 00:00:00	2008-10-29 00:00:00	\N	\N	\N	\N	\N	\N	text
3	4	3	3	F	T	F	2012-11-19 13:00:00	2012-11-19 13:09:00	\N	\N	\N	\N	\N	\N	boolean
10	11	9	9	F	F	F	2008-10-29 00:00:00	2008-10-29 00:00:00	\N	\N	\N	\N	\N	\N	text
11	12	9	9	F	T	F	2008-10-29 00:00:00	2008-10-29 00:00:00	\N	\N	\N	\N	\N	\N	text
12	13	9	9	F	T	F	2012-12-31 23:00:00	2012-12-31 23:00:00	\N	\N	\N	\N	\N	\N	text
6	7	6	6	F	T	F	2012-11-19 13:00:00	2012-11-19 13:09:00	3	\N	\N	\N	\N	\N	quantity
7	8	7	7	F	T	F	2012-11-19 13:00:00	2012-11-19 13:09:00	4	\N	\N	\N	\N	\N	quantity
4	5	4	4	F	T	F	2012-11-19 13:00:00	2012-11-19 13:09:00	\N	\N	\N	\N	\N	\N	category
8	9	8	8	F	T	F	2012-11-19 13:00:00	2012-11-19 13:49:59	5	\N	\N	\N	\N	\N	quantity
1	2	1	1	F	T	F	2012-11-19 13:00:00	2012-11-19 13:09:00	1	\N	\N	\N	\N	\N	quantity-profile
5	6	5	5	T	T	F	2012-11-19 13:00:00	2012-11-19 13:09:00	\N	\N	\N	\N	\N	\N	text
\.


--
-- TOC entry 4021 (class 0 OID 111243)
-- Dependencies: 221
-- Data for Name: observation; Type: TABLE DATA; Schema: public; Owner: sos_user
--

COPY observation (id, phenomenontimestart, phenomenontimeend, resulttime, domainid, codespace, name, codespacename, description, deleted, child, parent, validtimestart, validtimeend, samplinggeometry) FROM stdin;
1	2012-11-19 13:00:00	2012-11-19 13:00:00	2012-11-19 13:00:00	http://www.52north.org/test/profile-observation/1	1	\N	1	\N	F	F	T	\N	\N	\N
10	2012-11-19 13:09:00	2012-11-19 13:09:00	2012-11-19 13:09:00	http://www.52north.org/test/profile-observation/10	1	\N	1	\N	F	F	T	\N	\N	\N
11	2012-11-19 13:00:00	2012-11-19 13:00:00	2012-11-19 13:00:00	\N	1	\N	1	\N	F	F	F	\N	\N	\N
12	2012-11-19 13:01:00	2012-11-19 13:01:00	2012-11-19 13:01:00	\N	1	\N	1	\N	F	F	F	\N	\N	\N
13	2012-11-19 13:02:00	2012-11-19 13:02:00	2012-11-19 13:02:00	\N	1	\N	1	\N	F	F	F	\N	\N	\N
14	2012-11-19 13:03:00	2012-11-19 13:03:00	2012-11-19 13:03:00	\N	1	\N	1	\N	F	F	F	\N	\N	\N
15	2012-11-19 13:04:00	2012-11-19 13:04:00	2012-11-19 13:04:00	\N	1	\N	1	\N	F	F	F	\N	\N	\N
16	2012-11-19 13:05:00	2012-11-19 13:05:00	2012-11-19 13:05:00	\N	1	\N	1	\N	F	F	F	\N	\N	\N
17	2012-11-19 13:06:00	2012-11-19 13:06:00	2012-11-19 13:06:00	\N	1	\N	1	\N	F	F	F	\N	\N	\N
18	2012-11-19 13:07:00	2012-11-19 13:07:00	2012-11-19 13:07:00	\N	1	\N	1	\N	F	F	F	\N	\N	\N
19	2012-11-19 13:08:00	2012-11-19 13:08:00	2012-11-19 13:08:00	\N	1	\N	1	\N	F	F	F	\N	\N	\N
20	2012-11-19 13:09:00	2012-11-19 13:09:00	2012-11-19 13:09:00	\N	1	\N	1	\N	F	F	F	\N	\N	\N
21	2012-11-19 13:00:00	2012-11-19 13:00:00	2012-11-19 13:00:00	\N	1	\N	1	\N	F	F	F	\N	\N	\N
22	2012-11-19 13:01:00	2012-11-19 13:01:00	2012-11-19 13:01:00	\N	1	\N	1	\N	F	F	F	\N	\N	\N
23	2012-11-19 13:02:00	2012-11-19 13:02:00	2012-11-19 13:02:00	\N	1	\N	1	\N	F	F	F	\N	\N	\N
24	2012-11-19 13:03:00	2012-11-19 13:03:00	2012-11-19 13:03:00	\N	1	\N	1	\N	F	F	F	\N	\N	\N
25	2012-11-19 13:04:00	2012-11-19 13:04:00	2012-11-19 13:04:00	\N	1	\N	1	\N	F	F	F	\N	\N	\N
26	2012-11-19 13:05:00	2012-11-19 13:05:00	2012-11-19 13:05:00	\N	1	\N	1	\N	F	F	F	\N	\N	\N
27	2012-11-19 13:06:00	2012-11-19 13:06:00	2012-11-19 13:06:00	\N	1	\N	1	\N	F	F	F	\N	\N	\N
28	2012-11-19 13:07:00	2012-11-19 13:07:00	2012-11-19 13:07:00	\N	1	\N	1	\N	F	F	F	\N	\N	\N
29	2012-11-19 13:08:00	2012-11-19 13:08:00	2012-11-19 13:08:00	\N	1	\N	1	\N	F	F	F	\N	\N	\N
30	2012-11-19 13:09:00	2012-11-19 13:09:00	2012-11-19 13:09:00	\N	1	\N	1	\N	F	F	F	\N	\N	\N
31	2012-11-19 13:00:00	2012-11-19 13:00:00	2012-11-19 13:00:00	\N	1	\N	1	\N	F	F	F	\N	\N	\N
32	2012-11-19 13:01:00	2012-11-19 13:01:00	2012-11-19 13:01:00	\N	1	\N	1	\N	F	F	F	\N	\N	\N
33	2012-11-19 13:02:00	2012-11-19 13:02:00	2012-11-19 13:02:00	\N	1	\N	1	\N	F	F	F	\N	\N	\N
34	2012-11-19 13:03:00	2012-11-19 13:03:00	2012-11-19 13:03:00	\N	1	\N	1	\N	F	F	F	\N	\N	\N
35	2012-11-19 13:04:00	2012-11-19 13:04:00	2012-11-19 13:04:00	\N	1	\N	1	\N	F	F	F	\N	\N	\N
36	2012-11-19 13:05:00	2012-11-19 13:05:00	2012-11-19 13:05:00	\N	1	\N	1	\N	F	F	F	\N	\N	\N
37	2012-11-19 13:06:00	2012-11-19 13:06:00	2012-11-19 13:06:00	\N	1	\N	1	\N	F	F	F	\N	\N	\N
38	2012-11-19 13:07:00	2012-11-19 13:07:00	2012-11-19 13:07:00	\N	1	\N	1	\N	F	F	F	\N	\N	\N
39	2012-11-19 13:08:00	2012-11-19 13:08:00	2012-11-19 13:08:00	\N	1	\N	1	\N	F	F	F	\N	\N	\N
40	2012-11-19 13:09:00	2012-11-19 13:09:00	2012-11-19 13:09:00	\N	1	\N	1	\N	F	F	F	\N	\N	\N
41	2012-11-19 13:00:00	2012-11-19 13:00:00	2012-11-19 13:00:00	\N	1	\N	1	\N	F	F	F	\N	\N	\N
42	2012-11-19 13:01:00	2012-11-19 13:01:00	2012-11-19 13:01:00	\N	1	\N	1	\N	F	F	F	\N	\N	\N
43	2012-11-19 13:02:00	2012-11-19 13:02:00	2012-11-19 13:02:00	\N	1	\N	1	\N	F	F	F	\N	\N	\N
44	2012-11-19 13:03:00	2012-11-19 13:03:00	2012-11-19 13:03:00	\N	1	\N	1	\N	F	F	F	\N	\N	\N
45	2012-11-19 13:04:00	2012-11-19 13:04:00	2012-11-19 13:04:00	\N	1	\N	1	\N	F	F	F	\N	\N	\N
46	2012-11-19 13:05:00	2012-11-19 13:05:00	2012-11-19 13:05:00	\N	1	\N	1	\N	F	F	F	\N	\N	\N
47	2012-11-19 13:06:00	2012-11-19 13:06:00	2012-11-19 13:06:00	\N	1	\N	1	\N	F	F	F	\N	\N	\N
48	2012-11-19 13:07:00	2012-11-19 13:07:00	2012-11-19 13:07:00	\N	1	\N	1	\N	F	F	F	\N	\N	\N
49	2012-11-19 13:08:00	2012-11-19 13:08:00	2012-11-19 13:08:00	\N	1	\N	1	\N	F	F	F	\N	\N	\N
50	2012-11-19 13:09:00	2012-11-19 13:09:00	2012-11-19 13:09:00	\N	1	\N	1	\N	F	F	F	\N	\N	\N
51	2012-11-19 13:00:00	2012-11-19 13:00:00	2012-11-19 13:00:00	\N	1	\N	1	\N	F	F	F	\N	\N	\N
52	2012-11-19 13:01:00	2012-11-19 13:01:00	2012-11-19 13:01:00	\N	1	\N	1	\N	F	F	F	\N	\N	\N
53	2012-11-19 13:02:00	2012-11-19 13:02:00	2012-11-19 13:02:00	\N	1	\N	1	\N	F	F	F	\N	\N	\N
54	2012-11-19 13:03:00	2012-11-19 13:03:00	2012-11-19 13:03:00	\N	1	\N	1	\N	F	F	F	\N	\N	\N
55	2012-11-19 13:04:00	2012-11-19 13:04:00	2012-11-19 13:04:00	\N	1	\N	1	\N	F	F	F	\N	\N	\N
56	2012-11-19 13:05:00	2012-11-19 13:05:00	2012-11-19 13:05:00	\N	1	\N	1	\N	F	F	F	\N	\N	\N
57	2012-11-19 13:06:00	2012-11-19 13:06:00	2012-11-19 13:06:00	\N	1	\N	1	\N	F	F	F	\N	\N	\N
58	2012-11-19 13:07:00	2012-11-19 13:07:00	2012-11-19 13:07:00	\N	1	\N	1	\N	F	F	F	\N	\N	\N
59	2012-11-19 13:08:00	2012-11-19 13:08:00	2012-11-19 13:08:00	\N	1	\N	1	\N	F	F	F	\N	\N	\N
60	2012-11-19 13:09:00	2012-11-19 13:09:00	2012-11-19 13:09:00	\N	1	\N	1	\N	F	F	F	\N	\N	\N
61	2012-11-19 13:00:00	2012-11-19 13:00:00	2012-11-19 13:00:00	\N	1	\N	1	\N	F	F	F	\N	\N	\N
62	2012-11-19 13:01:00	2012-11-19 13:01:00	2012-11-19 13:01:00	\N	1	\N	1	\N	F	F	F	\N	\N	\N
63	2012-11-19 13:02:00	2012-11-19 13:02:00	2012-11-19 13:02:00	\N	1	\N	1	\N	F	F	F	\N	\N	\N
64	2012-11-19 13:03:00	2012-11-19 13:03:00	2012-11-19 13:03:00	\N	1	\N	1	\N	F	F	F	\N	\N	\N
65	2012-11-19 13:04:00	2012-11-19 13:04:00	2012-11-19 13:04:00	\N	1	\N	1	\N	F	F	F	\N	\N	\N
66	2012-11-19 13:05:00	2012-11-19 13:05:00	2012-11-19 13:05:00	\N	1	\N	1	\N	F	F	F	\N	\N	\N
67	2012-11-19 13:06:00	2012-11-19 13:06:00	2012-11-19 13:06:00	\N	1	\N	1	\N	F	F	F	\N	\N	\N
68	2012-11-19 13:07:00	2012-11-19 13:07:00	2012-11-19 13:07:00	\N	1	\N	1	\N	F	F	F	\N	\N	\N
69	2012-11-19 13:08:00	2012-11-19 13:08:00	2012-11-19 13:08:00	\N	1	\N	1	\N	F	F	F	\N	\N	\N
70	2012-11-19 13:09:00	2012-11-19 13:09:00	2012-11-19 13:09:00	\N	1	\N	1	\N	F	F	F	\N	\N	\N
71	2012-11-19 13:00:00	2012-11-19 13:04:59	2012-11-18 13:00:00	http://www.52north.org/test/observation/8_71_resulttime_2012-11-18	1	\N	1	\N	F	F	F	\N	\N	01010000000000000000001C400000000000004940
72	2012-11-19 13:05:00	2012-11-19 13:09:59	2012-11-18 13:00:00	http://www.52north.org/test/observation/8_72_resulttime_2012-11-18	1	\N	1	\N	F	F	F	\N	\N	0101000000CDCCCCCCCCCC1C40CDCCCCCCCC4C4940
73	2012-11-19 13:10:00	2012-11-19 13:14:59	2012-11-18 13:00:00	http://www.52north.org/test/observation/8_73_resulttime_2012-11-18	1	\N	1	\N	F	F	F	\N	\N	01010000003333333333331F40CDCCCCCCCCCC4940
74	2012-11-19 13:15:00	2012-11-19 13:19:59	2012-11-18 13:00:00	http://www.52north.org/test/observation/8_74_resulttime_2012-11-18	1	\N	1	\N	F	F	F	\N	\N	0101000000CDCCCCCCCCCC20409A99999999994940
75	2012-11-19 13:20:00	2012-11-19 13:24:59	2012-11-18 13:00:00	http://www.52north.org/test/observation/8_75_resulttime_2012-11-18	1	\N	1	\N	F	F	F	\N	\N	01010000009A99999999991D409A99999999194940
76	2012-11-19 13:25:00	2012-11-19 13:29:59	2012-11-18 13:00:00	http://www.52north.org/test/observation/8_76_resulttime_2012-11-18	1	\N	1	\N	F	F	F	\N	\N	01010000006666666666661E406666666666664940
77	2012-11-19 13:30:00	2012-11-19 13:34:59	2012-11-18 13:00:00	http://www.52north.org/test/observation/8_77_resulttime_2012-11-18	1	\N	1	\N	F	F	F	\N	\N	010100000000000000000020406666666666664940
78	2012-11-19 13:35:00	2012-11-19 13:39:59	2012-11-18 13:00:00	http://www.52north.org/test/observation/8_78_resulttime_2012-11-18	1	\N	1	\N	F	F	F	\N	\N	010100000000000000000021406666666666664940
79	2012-11-19 13:40:00	2012-11-19 13:44:59	2012-11-18 13:00:00	http://www.52north.org/test/observation/8_79_resulttime_2012-11-18	1	\N	1	\N	F	F	F	\N	\N	010100000033333333333320409A99999999194940
80	2012-11-19 13:45:00	2012-11-19 13:49:59	2012-11-18 13:00:00	http://www.52north.org/test/observation/8_80_resulttime_2012-11-18	1	\N	1	\N	F	F	F	\N	\N	010100000033333333333321400000000000404940
81	2008-10-29 00:00:00	2008-10-29 00:00:00	2008-10-29 00:00:00	\N	1	\N	1	\N	F	F	F	\N	\N	\N
82	2008-10-29 00:00:00	2008-10-29 00:00:00	2008-10-29 00:00:00	\N	1	\N	1	\N	F	F	F	\N	\N	\N
83	2008-10-29 00:00:00	2008-10-29 00:00:00	2008-10-29 00:00:00	\N	1	\N	1	\N	F	F	F	\N	\N	\N
84	2012-12-31 23:00:00	2012-12-31 23:00:00	2012-12-31 22:01:00	\N	1	\N	1	\N	F	F	F	\N	\N	\N
86	2012-11-19 13:00:00	2012-11-19 13:00:00	2012-11-19 13:00:00	http://www.52north.org/test/observation/1_firstValue_vertical_1	1	\N	1	\N	F	T	F	\N	\N	\N
85	2012-11-19 13:00:00	2012-11-19 13:00:00	2012-11-19 13:00:00	http://www.52north.org/test/observation/1_firstValue_vertical_0	1	\N	1	\N	F	T	F	\N	\N	\N
87	2012-11-19 13:09:00	2012-11-19 13:09:00	2012-11-19 13:09:00	http://www.52north.org/test/observation/1_lastValue_vertical_0	1	\N	1	\N	F	T	F	\N	\N	\N
88	2012-11-19 13:09:00	2012-11-19 13:09:00	2012-11-19 13:09:00	http://www.52north.org/test/observation/1_lastValue_vertical_1	1	\N	1	\N	F	T	F	\N	\N	\N
91	2012-11-19 13:00:00	2012-11-19 13:04:59	2012-11-19 13:00:00	http://www.52north.org/test/observation/8_91_resulttime_2012-11-19	1	\N	1	\N	F	F	F	\N	\N	010100000000000000000024400000000000002440
92	2012-11-19 13:05:00	2012-11-19 13:09:59	2012-11-19 13:00:00	http://www.52north.org/test/observation/8_92_resulttime_2012-11-19	1	\N	1	\N	F	F	F	\N	\N	0101000000CDCCCCCCCCCC1C40CDCCCCCCCC4C4940
93	2012-11-19 13:10:00	2012-11-19 13:14:59	2012-11-19 13:00:00	http://www.52north.org/test/observation/8_93_resulttime_2012-11-19	1	\N	1	\N	F	F	F	\N	\N	01010000003333333333331F40CDCCCCCCCCCC4940
94	2012-11-19 13:15:00	2012-11-19 13:19:59	2012-11-19 13:00:00	http://www.52north.org/test/observation/8_94_resulttime_2012-11-19	1	\N	1	\N	F	F	F	\N	\N	0101000000CDCCCCCCCCCC20409A99999999994940
95	2012-11-19 13:20:00	2012-11-19 13:24:59	2012-11-19 13:00:00	http://www.52north.org/test/observation/8_95_resulttime_2012-11-19	1	\N	1	\N	F	F	F	\N	\N	01010000009A99999999991D409A99999999194940
96	2012-11-19 13:25:00	2012-11-19 13:29:59	2012-11-19 13:00:00	http://www.52north.org/test/observation/8_96_resulttime_2012-11-19	1	\N	1	\N	F	F	F	\N	\N	01010000006666666666661E406666666666664940
97	2012-11-19 13:30:00	2012-11-19 13:34:59	2012-11-19 13:00:00	http://www.52north.org/test/observation/8_97_resulttime_2012-11-19	1	\N	1	\N	F	F	F	\N	\N	010100000000000000000020406666666666664940
98	2012-11-19 13:35:00	2012-11-19 13:39:59	2012-11-19 13:00:00	http://www.52north.org/test/observation/8_98_resulttime_2012-11-19	1	\N	1	\N	F	F	F	\N	\N	010100000000000000000021406666666666664940
99	2012-11-19 13:40:00	2012-11-19 13:44:59	2012-11-19 13:00:00	http://www.52north.org/test/observation/8_99_resulttime_2012-11-19	1	\N	1	\N	F	F	F	\N	\N	010100000033333333333320409A99999999194940
100	2012-11-19 13:45:00	2012-11-19 13:49:59	2012-11-19 13:00:00	http://www.52north.org/test/observation/8_100_resulttime_2012-11-19	1	\N	1	\N	F	F	F	\N	\N	010100000000000000000034400000000000003440
\.




COPY datasetobservation (data, dataset) FROM stdin;
1	1
10	1
11	2
12	2
13	2
14	2
15	2
16	2
17	2
18	2
19	2
20	2
21	3
22	3
23	3
24	3
25	3
26	3
27	3
28	3
29	3
30	3
31	4
32	4
33	4
34	4
35	4
36	4
37	4
38	4
39	4
40	4
41	5
42	5
43	5
44	5
45	5
46	5
47	5
48	5
49	5
50	5
51	6
52	6
53	6
54	6
55	6
56	6
57	6
58	6
59	6
60	6
61	7
62	7
63	7
64	7
65	7
66	7
67	7
68	7
69	7
70	7
71	8
72	8
73	8
74	8
75	8
76	8
77	8
78	8
79	8
80	8
81	9
82	10
83	11
84	12
85	1
86	1
87	1
88	1
91	8
92	8
93	8
94	8
95	8
96	8
97	8
98	8
99	8
100	8
\.

--
-- TOC entry 3998 (class 0 OID 111108)
-- Dependencies: 198
-- Data for Name: blobvalue; Type: TABLE DATA; Schema: public; Owner: sos_user
--

COPY blobvalue (observation, value) FROM stdin;
\.


--
-- TOC entry 4014 (class 0 OID 111198)
-- Dependencies: 214
-- Data for Name: featureparameter; Type: TABLE DATA; Schema: public; Owner: sos_user
--

COPY featureparameter (feature, parameter) FROM stdin;
\.


--
-- TOC entry 3999 (class 0 OID 111113)
-- Dependencies: 199
-- Data for Name: booleanparametervalue; Type: TABLE DATA; Schema: public; Owner: sos_user
--

COPY booleanparametervalue (parameter, value) FROM stdin;
\.



COPY parameter (id, name) FROM stdin;
1	depth
2	depth
3	depth
4	depth
\.


--
-- TOC entry 4030 (class 0 OID 111306)
-- Dependencies: 230
-- Data for Name: observationparameter; Type: TABLE DATA; Schema: public; Owner: sos_user
--

COPY observationparameter (parameter, observation) FROM stdin;
1	85
2	86
3	87
4	88
\.



--
-- TOC entry 4001 (class 0 OID 111125)
-- Dependencies: 201
-- Data for Name: booleanvalue; Type: TABLE DATA; Schema: public; Owner: sos_user
--

COPY booleanvalue (observation, value) FROM stdin;
21	T
22	T
23	F
24	T
25	F
26	F
27	T
28	T
29	F
30	T
\.


--
-- TOC entry 4002 (class 0 OID 111132)
-- Dependencies: 202
-- Data for Name: categoryparametervalue; Type: TABLE DATA; Schema: public; Owner: sos_user
--

COPY categoryparametervalue (parameter, value, unit) FROM stdin;
\.



--
-- TOC entry 4004 (class 0 OID 111142)
-- Dependencies: 204
-- Data for Name: categoryvalue; Type: TABLE DATA; Schema: public; Owner: sos_user
--

COPY categoryvalue (observation, value, domainid, name, description) FROM stdin;
31	test_category_0	\N	\N	\N
32	test_category_1	\N	\N	\N
33	test_category_2	\N	\N	\N
34	test_category_3	\N	\N	\N
35	test_category_4	\N	\N	\N
36	test_category_5	\N	\N	\N
37	test_category_6	\N	\N	\N
38	test_category_7	\N	\N	\N
39	test_category_8	\N	\N	\N
40	test_category_9	\N	\N	\N
\.


--
-- TOC entry 4071 (class 0 OID 0)
-- Dependencies: 249
-- Name: codespace_seq; Type: SEQUENCE SET; Schema: public; Owner: sos_user
--

SELECT pg_catalog.setval('codespace_seq', 1, true);


--
-- TOC entry 4006 (class 0 OID 111155)
-- Dependencies: 206
-- Data for Name: complexvalue; Type: TABLE DATA; Schema: public; Owner: sos_user
--

COPY complexvalue (observation) FROM stdin;
\.


--
-- TOC entry 4007 (class 0 OID 111160)
-- Dependencies: 207
-- Data for Name: compositeobservation; Type: TABLE DATA; Schema: public; Owner: sos_user
--

COPY compositeobservation (observation, child) FROM stdin;
\.


--
-- TOC entry 4008 (class 0 OID 111165)
-- Dependencies: 208
-- Data for Name: compositephenomenon; Type: TABLE DATA; Schema: public; Owner: sos_user
--

COPY compositephenomenon (parent, child) FROM stdin;
\.


--
-- TOC entry 4009 (class 0 OID 111170)
-- Dependencies: 209
-- Data for Name: countparametervalue; Type: TABLE DATA; Schema: public; Owner: sos_user
--

COPY countparametervalue (parameter, value) FROM stdin;
\.




--
-- TOC entry 4011 (class 0 OID 111180)
-- Dependencies: 211
-- Data for Name: countvalue; Type: TABLE DATA; Schema: public; Owner: sos_user
--

COPY countvalue (observation, value) FROM stdin;
11	0
12	1
13	2
14	3
15	4
16	5
17	6
18	7
19	8
20	9
\.


--
-- TOC entry 4072 (class 0 OID 0)
-- Dependencies: 250
-- Name: featureofinterest_seq; Type: SEQUENCE SET; Schema: public; Owner: sos_user
--

SELECT pg_catalog.setval('featureofinterest_seq', 13, true);


--
-- TOC entry 4073 (class 0 OID 0)
-- Dependencies: 251
-- Name: featuretype_seq; Type: SEQUENCE SET; Schema: public; Owner: sos_user
--

SELECT pg_catalog.setval('featuretype_seq', 2, true);


--
-- TOC entry 4015 (class 0 OID 111203)
-- Dependencies: 215
-- Data for Name: featurerelation; Type: TABLE DATA; Schema: public; Owner: sos_user
--

COPY featurerelation (parent, child) FROM stdin;
1	2
1	3
1	4
1	5
1	6
1	7
1	8
1	9
1	10
1	11
1	12
1	13
\.


--
-- TOC entry 4016 (class 0 OID 111208)
-- Dependencies: 216
-- Data for Name: geometryvalue; Type: TABLE DATA; Schema: public; Owner: sos_user
--

COPY geometryvalue (observation, value) FROM stdin;
\.



--
-- TOC entry 4018 (class 0 OID 111221)
-- Dependencies: 218
-- Data for Name: numericparametervalue; Type: TABLE DATA; Schema: public; Owner: sos_user
--

COPY numericparametervalue (parameter, value, unit) FROM stdin;
1	10	2
2	20	2
3	15	2
4	12	2
\.


--
-- TOC entry 4019 (class 0 OID 111226)
-- Dependencies: 219
-- Data for Name: numericvalue; Type: TABLE DATA; Schema: public; Owner: sos_user
--

COPY numericvalue (observation, value) FROM stdin;
51	2
52	2.10000000000000009
53	2.20000000000000018
54	2.29999999999999982
55	2.39999999999999991
56	2.5
57	2.60000000000000009
58	2.70000000000000018
59	2.79999999999999982
60	2.89999999999999991
61	3
62	3.10000000000000009
63	3.20000000000000018
64	3.29999999999999982
65	3.39999999999999991
66	3.5
67	3.60000000000000009
68	3.70000000000000018
69	3.79999999999999982
70	3.89999999999999991
71	4
72	4.09999999999999964
73	4.20000000000000018
74	4.29999999999999982
75	4.40000000000000036
76	4.5
77	4.59999999999999964
78	4.70000000000000018
79	4.79999999999999982
80	4.90000000000000036
85	100
86	200
87	300
88	400
91	5
92	5.09999999999999964
93	5.20000000000000018
94	5.29999999999999982
95	5.40000000000000036
96	5.5
97	5.59999999999999964
98	5.70000000000000018
99	5.79999999999999982
100	5.90000000000000036
\.


--
-- TOC entry 4074 (class 0 OID 0)
-- Dependencies: 252
-- Name: observableproperty_seq; Type: SEQUENCE SET; Schema: public; Owner: sos_user
--

SELECT pg_catalog.setval('observableproperty_seq', 9, true);




--
-- TOC entry 4076 (class 0 OID 0)
-- Dependencies: 254
-- Name: observation_seq; Type: SEQUENCE SET; Schema: public; Owner: sos_user
--

SELECT pg_catalog.setval('observation_seq', 84, true);


--
-- TOC entry 4077 (class 0 OID 0)
-- Dependencies: 255
-- Name: observationtype_seq; Type: SEQUENCE SET; Schema: public; Owner: sos_user
--

SELECT pg_catalog.setval('observationtype_seq', 5, true);


--
-- TOC entry 4026 (class 0 OID 111286)
-- Dependencies: 226
-- Data for Name: offeringallowedfeaturetype; Type: TABLE DATA; Schema: public; Owner: sos_user
--

COPY offeringallowedfeaturetype (offering, featuretype) FROM stdin;
1	1
2	1
3	1
4	1
5	1
6	1
7	1
8	1
9	1
\.


--
-- TOC entry 4027 (class 0 OID 111291)
-- Dependencies: 227
-- Data for Name: offeringallowedobservationtype; Type: TABLE DATA; Schema: public; Owner: sos_user
--

COPY offeringallowedobservationtype (offering, observationtype) FROM stdin;
1	1
2	2
3	3
4	4
5	5
6	1
7	1
8	1
9	5
\.


--
-- TOC entry 4034 (class 0 OID 111326)
-- Dependencies: 234
-- Data for Name: relatedfeature; Type: TABLE DATA; Schema: public; Owner: sos_user
--

COPY relatedfeature (id, featureofinterest) FROM stdin;
\.


--
-- TOC entry 4028 (class 0 OID 111296)
-- Dependencies: 228
-- Data for Name: offeringhasrelatedfeature; Type: TABLE DATA; Schema: public; Owner: sos_user
--

COPY offeringhasrelatedfeature (offering, relatedfeature) FROM stdin;
\.


--
-- TOC entry 4078 (class 0 OID 0)
-- Dependencies: 256
-- Name: offering_seq; Type: SEQUENCE SET; Schema: public; Owner: sos_user
--

SELECT pg_catalog.setval('offering_seq', 9, true);


--
-- TOC entry 4029 (class 0 OID 111301)
-- Dependencies: 229
-- Data for Name: offeringrelation; Type: TABLE DATA; Schema: public; Owner: sos_user
--

COPY offeringrelation (parent, child) FROM stdin;
\.


--
-- TOC entry 4079 (class 0 OID 0)
-- Dependencies: 257
-- Name: parameter_seq; Type: SEQUENCE SET; Schema: public; Owner: sos_user
--

SELECT pg_catalog.setval('parameter_seq', 1, false);


--
-- TOC entry 4080 (class 0 OID 0)
-- Dependencies: 258
-- Name: procdescformat_seq; Type: SEQUENCE SET; Schema: public; Owner: sos_user
--

SELECT pg_catalog.setval('procdescformat_seq', 1, true);


--
-- TOC entry 4081 (class 0 OID 0)
-- Dependencies: 259
-- Name: procedure_seq; Type: SEQUENCE SET; Schema: public; Owner: sos_user
--

SELECT pg_catalog.setval('procedure_seq', 9, true);


--
-- TOC entry 4033 (class 0 OID 111321)
-- Dependencies: 233
-- Data for Name: profilevalue; Type: TABLE DATA; Schema: public; Owner: sos_user
--

COPY profilevalue (observation, fromlevel, tolevel, levelunit) FROM stdin;
1	10	20	2
10	10	20	2
\.


--
-- TOC entry 4032 (class 0 OID 111316)
-- Dependencies: 232
-- Data for Name: profileobservation; Type: TABLE DATA; Schema: public; Owner: sos_user
--

COPY profileobservation (observation, child) FROM stdin;
1	85
1	86
10	87
10	88
\.


--
-- TOC entry 4036 (class 0 OID 111336)
-- Dependencies: 236
-- Data for Name: relatedfeaturerole; Type: TABLE DATA; Schema: public; Owner: sos_user
--

COPY relatedfeaturerole (id, relatedfeaturerole) FROM stdin;
\.


--
-- TOC entry 4035 (class 0 OID 111331)
-- Dependencies: 235
-- Data for Name: relatedfeaturehasrole; Type: TABLE DATA; Schema: public; Owner: sos_user
--

COPY relatedfeaturehasrole (relatedfeature, relatedfeaturerole) FROM stdin;
\.


--
-- TOC entry 4082 (class 0 OID 0)
-- Dependencies: 260
-- Name: relatedfeatureid_seq; Type: SEQUENCE SET; Schema: public; Owner: sos_user
--

SELECT pg_catalog.setval('relatedfeature_seq', 1, false);


--
-- TOC entry 4083 (class 0 OID 0)
-- Dependencies: 261
-- Name: relatedfeaturerole_seq; Type: SEQUENCE SET; Schema: public; Owner: sos_user
--

SELECT pg_catalog.setval('relatedfeaturerole_seq', 1, false);


--
-- TOC entry 4037 (class 0 OID 111341)
-- Dependencies: 237
-- Data for Name: relatedobservation; Type: TABLE DATA; Schema: public; Owner: sos_user
--

COPY relatedobservation (id, observation, relatedobservation, role, relatedurl) FROM stdin;
\.


--
-- TOC entry 4084 (class 0 OID 0)
-- Dependencies: 262
-- Name: relatedobservation_seq; Type: SEQUENCE SET; Schema: public; Owner: sos_user
--

SELECT pg_catalog.setval('relatedobservation_seq', 1, false);


--
-- TOC entry 4038 (class 0 OID 111349)
-- Dependencies: 238
-- Data for Name: resulttemplate; Type: TABLE DATA; Schema: public; Owner: sos_user
--

COPY resulttemplate (id, dataset, domainid, resultstructure, resultencoding) FROM stdin;
1	6	http://www.52north.org/test/procedure/6/template/1	<swe:DataRecord xmlns:swe="http://www.opengis.net/swe/2.0" xmlns:xlink="http://www.w3.org/1999/xlink">\n  <swe:field name="phenomenonTime">\n    <swe:TimeRange definition="http://www.opengis.net/def/property/OGC/0/PhenomenonTime">\n      <swe:uom xlink:href="http://www.opengis.net/def/uom/ISO-8601/0/Gregorian"/>\n    </swe:TimeRange>\n  </swe:field>\n  <swe:field name="resultTime">\n    <swe:Time definition="http://www.opengis.net/def/property/OGC/0/ResultTime">\n      <swe:uom code="testunit1"/>\n    </swe:Time>\n  </swe:field>\n  <swe:field name="observable_property_6">\n    <swe:Quantity definition="http://www.52north.org/test/observableProperty/6">\n      <swe:uom code="test_unit_6"/>\n    </swe:Quantity>\n  </swe:field>\n</swe:DataRecord>	<swe:TextEncoding xmlns:swe="http://www.opengis.net/swe/2.0" blockSeparator="#" tokenSeparator=","/>
\.


--
-- TOC entry 4085 (class 0 OID 0)
-- Dependencies: 263
-- Name: resulttemplateid_seq; Type: SEQUENCE SET; Schema: public; Owner: sos_user
--

SELECT pg_catalog.setval('resulttemplate_seq', 1, true);


--
-- TOC entry 4039 (class 0 OID 111357)
-- Dependencies: 239
-- Data for Name: procedurerelation; Type: TABLE DATA; Schema: public; Owner: sos_user
--

COPY procedurerelation (parent, child) FROM stdin;
\.


--
-- TOC entry 4086 (class 0 OID 0)
-- Dependencies: 264
-- Name: dataset_seq; Type: SEQUENCE SET; Schema: public; Owner: sos_user
--

SELECT pg_catalog.setval('dataset_seq', 12, true);


--
-- TOC entry 3583 (class 0 OID 36784)
-- Dependencies: 183
-- Data for Name: spatial_ref_sys; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY spatial_ref_sys  FROM stdin;
\.


--
-- TOC entry 4041 (class 0 OID 111376)
-- Dependencies: 241
-- Data for Name: swedataarrayvalue; Type: TABLE DATA; Schema: public; Owner: sos_user
--

COPY swedataarrayvalue (observation, value) FROM stdin;
\.




--
-- TOC entry 4043 (class 0 OID 111389)
-- Dependencies: 243
-- Data for Name: textparametervalue; Type: TABLE DATA; Schema: public; Owner: sos_user
--

COPY textparametervalue (parameter, value) FROM stdin;
\.


--
-- TOC entry 4044 (class 0 OID 111394)
-- Dependencies: 244
-- Data for Name: textvalue; Type: TABLE DATA; Schema: public; Owner: sos_user
--

COPY textvalue (observation, value, domainid, name, description) FROM stdin;
41	test_text_0	\N	\N	\N
42	test_text_1	\N	\N	\N
43	test_text_2	\N	\N	\N
44	test_text_3	\N	\N	\N
45	test_text_4	\N	\N	\N
46	test_text_5	\N	\N	\N
47	test_text_6	\N	\N	\N
48	test_text_7	\N	\N	\N
49	test_text_8	\N	\N	\N
50	test_text_9	\N	\N	\N
81	Carsten Hollmann	\N	\N	\N
82	Christian Autermann	\N	\N	\N
83	Shane StClair	\N	\N	\N
84	John/Jane Doe	\N	\N	\N
\.


--
-- TOC entry 4087 (class 0 OID 0)
-- Dependencies: 265
-- Name: unitid_seq; Type: SEQUENCE SET; Schema: public; Owner: sos_user
--

SELECT pg_catalog.setval('unit_seq', 5, true);


--
-- TOC entry 4046 (class 0 OID 111410)
-- Dependencies: 246
-- Data for Name: validproceduretime; Type: TABLE DATA; Schema: public; Owner: sos_user
--

COPY validproceduretime (id, procedure, proceduredescriptionformat, starttime, endtime, descriptionxml) FROM stdin;
1	1	1	2017-03-04 13:49:27.394	\N	<sml:SensorML xmlns:sml="http://www.opengis.net/sensorML/1.0.1" version="1.0.1">\n  <sml:member>\n    <sml:System xmlns:swe="http://www.opengis.net/swe/1.0.1" xmlns:swes="http://www.opengis.net/swes/2.0" xmlns:sos="http://www.opengis.net/sos/2.0" xmlns:gml="http://www.opengis.net/gml" xmlns:xlink="http://www.w3.org/1999/xlink" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance">\n      <sml:identification>\n        <sml:IdentifierList>\n          <sml:identifier name="uniqueID">\n            <sml:Term definition="urn:ogc:def:identifier:OGC:1.0:uniqueID">\n              <sml:value>http://www.52north.org/test/procedure/1</sml:value>\n            </sml:Term>\n          </sml:identifier>\n          <sml:identifier name="longName">\n            <sml:Term definition="urn:ogc:def:identifier:OGC:1.0:longName">\n              <sml:value>con terra GmbH (www.conterra.de)</sml:value>\n            </sml:Term>\n          </sml:identifier>\n          <sml:identifier name="shortName">\n            <sml:Term definition="urn:ogc:def:identifier:OGC:1.0:shortName">\n              <sml:value>con terra</sml:value>\n            </sml:Term>\n          </sml:identifier>\n        </sml:IdentifierList>\n      </sml:identification>\n      <sml:capabilities name="featuresOfInterest">\n        <swe:SimpleDataRecord>\n          <swe:field name="featureOfInterestID">\n            <swe:Text>\n              <swe:value>http://www.52north.org/test/featureOfInterest/1</swe:value>\n            </swe:Text>\n          </swe:field>\n        </swe:SimpleDataRecord>\n      </sml:capabilities>\n      <sml:position name="sensorPosition">\n        <swe:Position referenceFrame="urn:ogc:def:crs:EPSG::4326">\n          <swe:location>\n            <swe:Vector gml:id="STATION_LOCATION">\n              <swe:coordinate name="easting">\n                <swe:Quantity axisID="x">\n                  <swe:uom code="degree"/>\n                  <swe:value>7.727958</swe:value>\n                </swe:Quantity>\n              </swe:coordinate>\n              <swe:coordinate name="northing">\n                <swe:Quantity axisID="y">\n                  <swe:uom code="degree"/>\n                  <swe:value>51.883906</swe:value>\n                </swe:Quantity>\n              </swe:coordinate>\n              <swe:coordinate name="altitude">\n                <swe:Quantity axisID="z">\n                  <swe:uom code="m"/>\n                  <swe:value>52.0</swe:value>\n                </swe:Quantity>\n              </swe:coordinate>\n            </swe:Vector>\n          </swe:location>\n        </swe:Position>\n      </sml:position>\n      <sml:inputs>\n        <sml:InputList>\n          <sml:input name="test_observable_property_1">\n            <swe:ObservableProperty definition="http://www.52north.org/test/observableProperty/1"/>\n          </sml:input>\n        </sml:InputList>\n      </sml:inputs>\n      <sml:outputs>\n        <sml:OutputList>\n          <sml:output name="test_observable_property_1">\n            <swe:Category definition="http://www.52north.org/test/observableProperty/1">\n              <swe:codeSpace xlink:href="test_unit_1"/>\n            </swe:Category>\n          </sml:output>\n        </sml:OutputList>\n      </sml:outputs>\n    </sml:System>\n  </sml:member>\n</sml:SensorML>
2	2	1	2017-03-04 13:49:27.951	\N	<sml:SensorML xmlns:sml="http://www.opengis.net/sensorML/1.0.1" version="1.0.1">\n  <sml:member>\n    <sml:System xmlns:swe="http://www.opengis.net/swe/1.0.1" xmlns:swes="http://www.opengis.net/swes/2.0" xmlns:sos="http://www.opengis.net/sos/2.0" xmlns:gml="http://www.opengis.net/gml" xmlns:xlink="http://www.w3.org/1999/xlink" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance">\n      <sml:identification>\n        <sml:IdentifierList>\n          <sml:identifier name="uniqueID">\n            <sml:Term definition="urn:ogc:def:identifier:OGC:1.0:uniqueID">\n              <sml:value>http://www.52north.org/test/procedure/2</sml:value>\n            </sml:Term>\n          </sml:identifier>\n          <sml:identifier name="longName">\n            <sml:Term definition="urn:ogc:def:identifier:OGC:1.0:longName">\n              <sml:value>ESRI (www.esri.com)</sml:value>\n            </sml:Term>\n          </sml:identifier>\n          <sml:identifier name="shortName">\n            <sml:Term definition="urn:ogc:def:identifier:OGC:1.0:shortName">\n              <sml:value>ESRI</sml:value>\n            </sml:Term>\n          </sml:identifier>\n        </sml:IdentifierList>\n      </sml:identification>\n      <sml:capabilities name="featuresOfInterest">\n        <swe:SimpleDataRecord>\n          <swe:field name="featureOfInterestID">\n            <swe:Text>\n              <swe:value>http://www.52north.org/test/featureOfInterest/2</swe:value>\n            </swe:Text>\n          </swe:field>\n        </swe:SimpleDataRecord>\n      </sml:capabilities>\n      <sml:position name="sensorPosition">\n        <swe:Position referenceFrame="urn:ogc:def:crs:EPSG::4326">\n          <swe:location>\n            <swe:Vector gml:id="STATION_LOCATION">\n              <swe:coordinate name="easting">\n                <swe:Quantity axisID="x">\n                  <swe:uom code="degree"/>\n                  <swe:value>-117.195711</swe:value>\n                </swe:Quantity>\n              </swe:coordinate>\n              <swe:coordinate name="northing">\n                <swe:Quantity axisID="y">\n                  <swe:uom code="degree"/>\n                  <swe:value>34.056517</swe:value>\n                </swe:Quantity>\n              </swe:coordinate>\n              <swe:coordinate name="altitude">\n                <swe:Quantity axisID="z">\n                  <swe:uom code="m"/>\n                  <swe:value>52.0</swe:value>\n                </swe:Quantity>\n              </swe:coordinate>\n            </swe:Vector>\n          </swe:location>\n        </swe:Position>\n      </sml:position>\n      <sml:inputs>\n        <sml:InputList>\n          <sml:input name="test_observable_property_2">\n            <swe:ObservableProperty definition="http://www.52north.org/test/observableProperty/2"/>\n          </sml:input>\n        </sml:InputList>\n      </sml:inputs>\n      <sml:outputs>\n        <sml:OutputList>\n          <sml:output name="test_observable_property_2">\n            <swe:Count definition="http://www.52north.org/test/observableProperty/2"/>\n          </sml:output>\n        </sml:OutputList>\n      </sml:outputs>\n    </sml:System>\n  </sml:member>\n</sml:SensorML>
3	3	1	2017-03-04 13:49:28.117	\N	<sml:SensorML xmlns:sml="http://www.opengis.net/sensorML/1.0.1" version="1.0.1">\n  <sml:member>\n    <sml:System xmlns:swe="http://www.opengis.net/swe/1.0.1" xmlns:swes="http://www.opengis.net/swes/2.0" xmlns:sos="http://www.opengis.net/sos/2.0" xmlns:gml="http://www.opengis.net/gml" xmlns:xlink="http://www.w3.org/1999/xlink" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance">\n      <sml:identification>\n        <sml:IdentifierList>\n          <sml:identifier name="uniqueID">\n            <sml:Term definition="urn:ogc:def:identifier:OGC:1.0:uniqueID">\n              <sml:value>http://www.52north.org/test/procedure/3</sml:value>\n            </sml:Term>\n          </sml:identifier>\n          <sml:identifier name="longName">\n            <sml:Term definition="urn:ogc:def:identifier:OGC:1.0:longName">\n              <sml:value>Kisters AG (www.kisters.de)</sml:value>\n            </sml:Term>\n          </sml:identifier>\n          <sml:identifier name="shortName">\n            <sml:Term definition="urn:ogc:def:identifier:OGC:1.0:shortName">\n              <sml:value>Kisters</sml:value>\n            </sml:Term>\n          </sml:identifier>\n        </sml:IdentifierList>\n      </sml:identification>\n      <sml:capabilities name="featuresOfInterest">\n        <swe:SimpleDataRecord>\n          <swe:field name="featureOfInterestID">\n            <swe:Text>\n              <swe:value>http://www.52north.org/test/featureOfInterest/3</swe:value>\n            </swe:Text>\n          </swe:field>\n        </swe:SimpleDataRecord>\n      </sml:capabilities>\n      <sml:position name="sensorPosition">\n        <swe:Position referenceFrame="urn:ogc:def:crs:EPSG::4326">\n          <swe:location>\n            <swe:Vector gml:id="STATION_LOCATION">\n              <swe:coordinate name="easting">\n                <swe:Quantity axisID="x">\n                  <swe:uom code="degree"/>\n                  <swe:value>6.1320144042060925</swe:value>\n                </swe:Quantity>\n              </swe:coordinate>\n              <swe:coordinate name="northing">\n                <swe:Quantity axisID="y">\n                  <swe:uom code="degree"/>\n                  <swe:value>50.78570661296184</swe:value>\n                </swe:Quantity>\n              </swe:coordinate>\n              <swe:coordinate name="altitude">\n                <swe:Quantity axisID="z">\n                  <swe:uom code="m"/>\n                  <swe:value>52.0</swe:value>\n                </swe:Quantity>\n              </swe:coordinate>\n            </swe:Vector>\n          </swe:location>\n        </swe:Position>\n      </sml:position>\n      <sml:inputs>\n        <sml:InputList>\n          <sml:input name="test_observable_property_3">\n            <swe:ObservableProperty definition="http://www.52north.org/test/observableProperty/3"/>\n          </sml:input>\n        </sml:InputList>\n      </sml:inputs>\n      <sml:outputs>\n        <sml:OutputList>\n          <sml:output name="test_observable_property_3">\n            <swe:Boolean definition="http://www.52north.org/test/observableProperty/3"/>\n          </sml:output>\n        </sml:OutputList>\n      </sml:outputs>\n    </sml:System>\n  </sml:member>\n</sml:SensorML>
4	4	1	2017-03-04 13:49:28.281	\N	<sml:SensorML xmlns:sml="http://www.opengis.net/sensorML/1.0.1" version="1.0.1">\n  <sml:member>\n    <sml:System xmlns:swe="http://www.opengis.net/swe/1.0.1" xmlns:swes="http://www.opengis.net/swes/2.0" xmlns:sos="http://www.opengis.net/sos/2.0" xmlns:gml="http://www.opengis.net/gml" xmlns:xlink="http://www.w3.org/1999/xlink" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance">\n      <sml:identification>\n        <sml:IdentifierList>\n          <sml:identifier name="uniqueID">\n            <sml:Term definition="urn:ogc:def:identifier:OGC:1.0:uniqueID">\n              <sml:value>http://www.52north.org/test/procedure/4</sml:value>\n            </sml:Term>\n          </sml:identifier>\n          <sml:identifier name="longName">\n            <sml:Term definition="urn:ogc:def:identifier:OGC:1.0:longName">\n              <sml:value>Institute for Geoinformatics (http://ifgi.uni-muenster.de/en)</sml:value>\n            </sml:Term>\n          </sml:identifier>\n          <sml:identifier name="shortName">\n            <sml:Term definition="urn:ogc:def:identifier:OGC:1.0:shortName">\n              <sml:value>IfGI</sml:value>\n            </sml:Term>\n          </sml:identifier>\n        </sml:IdentifierList>\n      </sml:identification>\n      <sml:capabilities name="featuresOfInterest">\n        <swe:SimpleDataRecord>\n          <swe:field name="featureOfInterestID">\n            <swe:Text>\n              <swe:value>http://www.52north.org/test/featureOfInterest/4</swe:value>\n            </swe:Text>\n          </swe:field>\n        </swe:SimpleDataRecord>\n      </sml:capabilities>\n      <sml:position name="sensorPosition">\n        <swe:Position referenceFrame="urn:ogc:def:crs:EPSG::4326">\n          <swe:location>\n            <swe:Vector gml:id="STATION_LOCATION">\n              <swe:coordinate name="easting">\n                <swe:Quantity axisID="x">\n                  <swe:uom code="degree"/>\n                  <swe:value>7.593655600000034</swe:value>\n                </swe:Quantity>\n              </swe:coordinate>\n              <swe:coordinate name="northing">\n                <swe:Quantity axisID="y">\n                  <swe:uom code="degree"/>\n                  <swe:value>51.9681661</swe:value>\n                </swe:Quantity>\n              </swe:coordinate>\n              <swe:coordinate name="altitude">\n                <swe:Quantity axisID="z">\n                  <swe:uom code="m"/>\n                  <swe:value>52.0</swe:value>\n                </swe:Quantity>\n              </swe:coordinate>\n            </swe:Vector>\n          </swe:location>\n        </swe:Position>\n      </sml:position>\n      <sml:inputs>\n        <sml:InputList>\n          <sml:input name="test_observable_property_4">\n            <swe:ObservableProperty definition="http://www.52north.org/test/observableProperty/4"/>\n          </sml:input>\n        </sml:InputList>\n      </sml:inputs>\n      <sml:outputs>\n        <sml:OutputList>\n          <sml:output name="test_observable_property_4">\n            <swe:Quantity definition="http://www.52north.org/test/observableProperty/4">\n              <swe:uom code="test_unit_4"/>\n            </swe:Quantity>\n          </sml:output>\n        </sml:OutputList>\n      </sml:outputs>\n    </sml:System>\n  </sml:member>\n</sml:SensorML>
5	5	1	2017-03-04 13:49:28.441	\N	<sml:SensorML xmlns:sml="http://www.opengis.net/sensorML/1.0.1" version="1.0.1">\n  <sml:member>\n    <sml:System xmlns:swe="http://www.opengis.net/swe/1.0.1" xmlns:swes="http://www.opengis.net/swes/2.0" xmlns:sos="http://www.opengis.net/sos/2.0" xmlns:gml="http://www.opengis.net/gml" xmlns:xlink="http://www.w3.org/1999/xlink" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance">\n      <sml:identification>\n        <sml:IdentifierList>\n          <sml:identifier name="uniqueID">\n            <sml:Term definition="urn:ogc:def:identifier:OGC:1.0:uniqueID">\n              <sml:value>http://www.52north.org/test/procedure/5</sml:value>\n            </sml:Term>\n          </sml:identifier>\n          <sml:identifier name="longName">\n            <sml:Term definition="urn:ogc:def:identifier:OGC:1.0:longName">\n              <sml:value>Technical University Dresden (http://tu-dresden.de/en)</sml:value>\n            </sml:Term>\n          </sml:identifier>\n          <sml:identifier name="shortName">\n            <sml:Term definition="urn:ogc:def:identifier:OGC:1.0:shortName">\n              <sml:value>TU-Dresden</sml:value>\n            </sml:Term>\n          </sml:identifier>\n        </sml:IdentifierList>\n      </sml:identification>\n      <sml:capabilities name="featuresOfInterest">\n        <swe:SimpleDataRecord>\n          <swe:field name="featureOfInterestID">\n            <swe:Text>\n              <swe:value>http://www.52north.org/test/featureOfInterest/5</swe:value>\n            </swe:Text>\n          </swe:field>\n        </swe:SimpleDataRecord>\n      </sml:capabilities>\n      <sml:position name="sensorPosition">\n        <swe:Position referenceFrame="urn:ogc:def:crs:EPSG::4326">\n          <swe:location>\n            <swe:Vector gml:id="STATION_LOCATION">\n              <swe:coordinate name="easting">\n                <swe:Quantity axisID="x">\n                  <swe:uom code="degree"/>\n                  <swe:value>13.72375999999997</swe:value>\n                </swe:Quantity>\n              </swe:coordinate>\n              <swe:coordinate name="northing">\n                <swe:Quantity axisID="y">\n                  <swe:uom code="degree"/>\n                  <swe:value>51.02881</swe:value>\n                </swe:Quantity>\n              </swe:coordinate>\n              <swe:coordinate name="altitude">\n                <swe:Quantity axisID="z">\n                  <swe:uom code="m"/>\n                  <swe:value>52.0</swe:value>\n                </swe:Quantity>\n              </swe:coordinate>\n            </swe:Vector>\n          </swe:location>\n        </swe:Position>\n      </sml:position>\n      <sml:inputs>\n        <sml:InputList>\n          <sml:input name="test_observable_property_5">\n            <swe:ObservableProperty definition="http://www.52north.org/test/observableProperty/5"/>\n          </sml:input>\n        </sml:InputList>\n      </sml:inputs>\n      <sml:outputs>\n        <sml:OutputList>\n          <sml:output name="test_observable_property_5">\n            <swe:Text definition="http://www.52north.org/test/observableProperty/5"/>\n          </sml:output>\n        </sml:OutputList>\n      </sml:outputs>\n    </sml:System>\n  </sml:member>\n</sml:SensorML>
6	6	1	2017-03-04 13:49:28.575	\N	<sml:SensorML xmlns:sml="http://www.opengis.net/sensorML/1.0.1" version="1.0.1">\n  <sml:member>\n    <sml:System xmlns:swe="http://www.opengis.net/swe/1.0.1" xmlns:swes="http://www.opengis.net/swes/2.0" xmlns:sos="http://www.opengis.net/sos/2.0" xmlns:gml="http://www.opengis.net/gml" xmlns:xlink="http://www.w3.org/1999/xlink" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance">\n      <sml:identification>\n        <sml:IdentifierList>\n          <sml:identifier name="uniqueID">\n            <sml:Term definition="urn:ogc:def:identifier:OGC:1.0:uniqueID">\n              <sml:value>http://www.52north.org/test/procedure/6</sml:value>\n            </sml:Term>\n          </sml:identifier>\n          <sml:identifier name="longName">\n            <sml:Term definition="urn:ogc:def:identifier:OGC:1.0:longName">\n              <sml:value>Hochschule Bochum - Bochum University of Applied Sciences (http://www.hochschule-bochum.de/en/)</sml:value>\n            </sml:Term>\n          </sml:identifier>\n          <sml:identifier name="shortName">\n            <sml:Term definition="urn:ogc:def:identifier:OGC:1.0:shortName">\n              <sml:value>Hochschule Bochum</sml:value>\n            </sml:Term>\n          </sml:identifier>\n        </sml:IdentifierList>\n      </sml:identification>\n      <sml:capabilities name="featuresOfInterest">\n        <swe:SimpleDataRecord>\n          <swe:field name="featureOfInterestID">\n            <swe:Text>\n              <swe:value>http://www.52north.org/test/featureOfInterest/6</swe:value>\n            </swe:Text>\n          </swe:field>\n        </swe:SimpleDataRecord>\n      </sml:capabilities>\n      <sml:position name="sensorPosition">\n        <swe:Position referenceFrame="urn:ogc:def:crs:EPSG::4326">\n          <swe:location>\n            <swe:Vector gml:id="STATION_LOCATION">\n              <swe:coordinate name="easting">\n                <swe:Quantity axisID="x">\n                  <swe:uom code="degree"/>\n                  <swe:value>7.270806</swe:value>\n                </swe:Quantity>\n              </swe:coordinate>\n              <swe:coordinate name="northing">\n                <swe:Quantity axisID="y">\n                  <swe:uom code="degree"/>\n                  <swe:value>51.447722</swe:value>\n                </swe:Quantity>\n              </swe:coordinate>\n              <swe:coordinate name="altitude">\n                <swe:Quantity axisID="z">\n                  <swe:uom code="m"/>\n                  <swe:value>52.0</swe:value>\n                </swe:Quantity>\n              </swe:coordinate>\n            </swe:Vector>\n          </swe:location>\n        </swe:Position>\n      </sml:position>\n      <sml:inputs>\n        <sml:InputList>\n          <sml:input name="test_observable_property_6">\n            <swe:ObservableProperty definition="http://www.52north.org/test/observableProperty/6"/>\n          </sml:input>\n        </sml:InputList>\n      </sml:inputs>\n      <sml:outputs>\n        <sml:OutputList>\n          <sml:output name="test_observable_property_6">\n            <swe:Category definition="http://www.52north.org/test/observableProperty/6">\n              <swe:codeSpace xlink:href="test_unit_6"/>\n            </swe:Category>\n          </sml:output>\n        </sml:OutputList>\n      </sml:outputs>\n    </sml:System>\n  </sml:member>\n</sml:SensorML>
7	7	1	2017-03-04 13:49:28.826	\N	<sml:SensorML xmlns:sml="http://www.opengis.net/sensorML/1.0.1" version="1.0.1">\n  <sml:member>\n    <sml:System xmlns:swe="http://www.opengis.net/swe/1.0.1" xmlns:swes="http://www.opengis.net/swes/2.0" xmlns:sos="http://www.opengis.net/sos/2.0" xmlns:gml="http://www.opengis.net/gml" xmlns:xlink="http://www.w3.org/1999/xlink" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance">\n      <sml:identification>\n        <sml:IdentifierList>\n          <sml:identifier name="uniqueID">\n            <sml:Term definition="urn:ogc:def:identifier:OGC:1.0:uniqueID">\n              <sml:value>http://www.52north.org/test/procedure/7</sml:value>\n            </sml:Term>\n          </sml:identifier>\n          <sml:identifier name="longName">\n            <sml:Term definition="urn:ogc:def:identifier:OGC:1.0:longName">\n              <sml:value>ITC - University of Twente (http://www.itc.nl/)</sml:value>\n            </sml:Term>\n          </sml:identifier>\n          <sml:identifier name="shortName">\n            <sml:Term definition="urn:ogc:def:identifier:OGC:1.0:shortName">\n              <sml:value>ITC</sml:value>\n            </sml:Term>\n          </sml:identifier>\n        </sml:IdentifierList>\n      </sml:identification>\n      <sml:capabilities name="featuresOfInterest">\n        <swe:SimpleDataRecord>\n          <swe:field name="featureOfInterestID">\n            <swe:Text>\n              <swe:value>http://www.52north.org/test/featureOfInterest/7</swe:value>\n            </swe:Text>\n          </swe:field>\n        </swe:SimpleDataRecord>\n      </sml:capabilities>\n      <sml:position name="sensorPosition">\n        <swe:Position referenceFrame="urn:ogc:def:crs:EPSG::4326">\n          <swe:location>\n            <swe:Vector gml:id="STATION_LOCATION">\n              <swe:coordinate name="easting">\n                <swe:Quantity axisID="x">\n                  <swe:uom code="degree"/>\n                  <swe:value>4.283393599999954</swe:value>\n                </swe:Quantity>\n              </swe:coordinate>\n              <swe:coordinate name="northing">\n                <swe:Quantity axisID="y">\n                  <swe:uom code="degree"/>\n                  <swe:value>52.0464393</swe:value>\n                </swe:Quantity>\n              </swe:coordinate>\n              <swe:coordinate name="altitude">\n                <swe:Quantity axisID="z">\n                  <swe:uom code="m"/>\n                  <swe:value>52.0</swe:value>\n                </swe:Quantity>\n              </swe:coordinate>\n            </swe:Vector>\n          </swe:location>\n        </swe:Position>\n      </sml:position>\n      <sml:inputs>\n        <sml:InputList>\n          <sml:input name="test_observable_property_7">\n            <swe:ObservableProperty definition="http://www.52north.org/test/observableProperty/7"/>\n          </sml:input>\n        </sml:InputList>\n      </sml:inputs>\n      <sml:outputs>\n        <sml:OutputList>\n          <sml:output name="test_observable_property_7">\n            <swe:Category definition="http://www.52north.org/test/observableProperty/7">\n              <swe:codeSpace xlink:href="test_unit_7"/>\n            </swe:Category>\n          </sml:output>\n        </sml:OutputList>\n      </sml:outputs>\n    </sml:System>\n  </sml:member>\n</sml:SensorML>
8	8	1	2017-03-04 13:49:28.965	\N	<sml:SensorML xmlns:sml="http://www.opengis.net/sensorML/1.0.1" version="1.0.1">\n  <sml:member>\n    <sml:System xmlns:swe="http://www.opengis.net/swe/1.0.1" xmlns:swes="http://www.opengis.net/swes/2.0" xmlns:sos="http://www.opengis.net/sos/2.0" xmlns:gml="http://www.opengis.net/gml" xmlns:xlink="http://www.w3.org/1999/xlink" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance">\n      <sml:identification>\n        <sml:IdentifierList>\n          <sml:identifier name="uniqueID">\n            <sml:Term definition="urn:ogc:def:identifier:OGC:1.0:uniqueID">\n              <sml:value>http://www.52north.org/test/procedure/8</sml:value>\n            </sml:Term>\n          </sml:identifier>\n          <sml:identifier name="longName">\n            <sml:Term definition="urn:ogc:def:identifier:OGC:1.0:longName">\n              <sml:value>Bundesanstalt für IT-Dienstleistungen im Geschäftsbereich des BMVBS (http://www.dlz-it.de)</sml:value>\n            </sml:Term>\n          </sml:identifier>\n          <sml:identifier name="shortName">\n            <sml:Term definition="urn:ogc:def:identifier:OGC:1.0:shortName">\n              <sml:value>DLZ-IT</sml:value>\n            </sml:Term>\n          </sml:identifier>\n        </sml:IdentifierList>\n      </sml:identification>\n      <sml:capabilities name="featuresOfInterest">\n        <swe:SimpleDataRecord>\n          <swe:field name="featureOfInterestID">\n            <swe:Text>\n              <swe:value>http://www.52north.org/test/featureOfInterest/8</swe:value>\n            </swe:Text>\n          </swe:field>\n        </swe:SimpleDataRecord>\n      </sml:capabilities>\n      <sml:position name="sensorPosition">\n        <swe:Position referenceFrame="urn:ogc:def:crs:EPSG::4326">\n          <swe:location>\n            <swe:Vector gml:id="STATION_LOCATION">\n              <swe:coordinate name="easting">\n                <swe:Quantity axisID="x">\n                  <swe:uom code="degree"/>\n                  <swe:value>10.94306000000006</swe:value>\n                </swe:Quantity>\n              </swe:coordinate>\n              <swe:coordinate name="northing">\n                <swe:Quantity axisID="y">\n                  <swe:uom code="degree"/>\n                  <swe:value>50.68606</swe:value>\n                </swe:Quantity>\n              </swe:coordinate>\n              <swe:coordinate name="altitude">\n                <swe:Quantity axisID="z">\n                  <swe:uom code="m"/>\n                  <swe:value>52.0</swe:value>\n                </swe:Quantity>\n              </swe:coordinate>\n            </swe:Vector>\n          </swe:location>\n        </swe:Position>\n      </sml:position>\n      <sml:inputs>\n        <sml:InputList>\n          <sml:input name="test_observable_property_8">\n            <swe:ObservableProperty definition="http://www.52north.org/test/observableProperty/8"/>\n          </sml:input>\n        </sml:InputList>\n      </sml:inputs>\n      <sml:outputs>\n        <sml:OutputList>\n          <sml:output name="test_observable_property_8">\n            <swe:Category definition="http://www.52north.org/test/observableProperty/8">\n              <swe:codeSpace xlink:href="test_unit_8"/>\n            </swe:Category>\n          </sml:output>\n        </sml:OutputList>\n      </sml:outputs>\n    </sml:System>\n  </sml:member>\n</sml:SensorML>
9	9	1	2017-03-04 13:49:29.263	\N	<sml:SensorML xmlns:sml="http://www.opengis.net/sensorML/1.0.1" version="1.0.1">\n  <sml:member>\n    <sml:ProcessModel xmlns:swe="http://www.opengis.net/swe/1.0.1" xmlns:gml="http://www.opengis.net/gml" xmlns:xlink="http://www.w3.org/1999/xlink" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" gml:id="developer">\n      <gml:description>52°North developer process</gml:description>\n      <gml:name>http://www.52north.org/test/procedure/developer</gml:name>\n      <sml:identification>\n        <sml:IdentifierList>\n          <sml:identifier name="uniqueID">\n            <sml:Term definition="urn:ogc:def:identifier:OGC:uniqueID">\n              <sml:value>http://www.52north.org/test/procedure/developer</sml:value>\n            </sml:Term>\n          </sml:identifier>\n        </sml:IdentifierList>\n      </sml:identification>\n      <sml:inputs>\n        <sml:InputList>\n          <sml:input name="community">\n            <swe:Text definition="http://www.52north.org/test/observableProperty/community"/>\n          </sml:input>\n        </sml:InputList>\n      </sml:inputs>\n      <sml:outputs>\n        <sml:OutputList>\n          <sml:output name="developer">\n            <swe:Text definition="http://www.52north.org/test/observableProperty/developer"/>\n          </sml:output>\n        </sml:OutputList>\n      </sml:outputs>\n      <sml:method>\n        <sml:ProcessMethod>\n          <gml:description>52deg;North Sensor Observation Service development method</gml:description>\n          <sml:contact xlink:arcrole="author">\n            <sml:ResponsibleParty>\n              <sml:individualName>Carsten Hollmann</sml:individualName>\n              <sml:organizationName>52deg;North Initiative for Geospatial Open Source Software GmbH</sml:organizationName>\n              <sml:positionName>code manager</sml:positionName>\n              <sml:contactInfo>\n                <sml:phone>\n                  <sml:voice>+49 (0)251 396371 0</sml:voice>\n                </sml:phone>\n                <sml:address>\n                  <sml:deliveryPoint>Martin-Luther-King-Weg 24</sml:deliveryPoint>\n                  <sml:city>Muenster</sml:city>\n                  <sml:administrativeArea>North Rhine-Westphalia</sml:administrativeArea>\n                  <sml:postalCode>48155</sml:postalCode>\n                  <sml:country>Germany</sml:country>\n                  <sml:electronicMailAddress>info@52north.org</sml:electronicMailAddress>\n                </sml:address>\n              </sml:contactInfo>\n            </sml:ResponsibleParty>\n          </sml:contact>\n          <sml:rules>\n            <sml:RulesDefinition>\n              <gml:description>Inputs are the specifications and the idea, Output is the SOS service</gml:description>\n            </sml:RulesDefinition>\n          </sml:rules>\n          <sml:algorithm>\n            <sml:AlgorithmDefinition>\n              <gml:description>Spec/Idea to code</gml:description>\n            </sml:AlgorithmDefinition>\n          </sml:algorithm>\n        </sml:ProcessMethod>\n      </sml:method>\n    </sml:ProcessModel>\n  </sml:member>\n</sml:SensorML>
\.


--
-- TOC entry 4088 (class 0 OID 0)
-- Dependencies: 266
-- Name: validproceduretime_seq; Type: SEQUENCE SET; Schema: public; Owner: sos_user
--

SELECT pg_catalog.setval('validproceduretime_seq', 9, true);



--
-- TOC entry 4048 (class 0 OID 111426)
-- Dependencies: 248
-- Data for Name: xmlparametervalue; Type: TABLE DATA; Schema: public; Owner: sos_user
--

COPY xmlparametervalue (parameter, value) FROM stdin;
\.


-- Completed on 2017-07-18 15:11:04 CEST

--
-- PostgreSQL database dump complete
--

