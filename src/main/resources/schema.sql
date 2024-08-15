CREATE TABLE IF NOT EXISTS public.devices (
	id int4 NOT NULL,
	"name" varchar(255) NULL,
	brand varchar(255) NULL,
	model varchar(255) NULL,
	os varchar(255) NULL,
	CONSTRAINT devices_os_check CHECK (((os)::text = ANY ((ARRAY['ANDROID'::character varying, 'IOS'::character varying])::text[]))),
	CONSTRAINT devices_pkey PRIMARY KEY (id)
);

CREATE SEQUENCE  IF NOT EXISTS public.devices_seq
	INCREMENT BY 50
	MINVALUE 1
	MAXVALUE 9223372036854775807
	START 1
	CACHE 1
	NO CYCLE;