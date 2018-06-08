-- Table: finomyrs.taxation

--DROP TABLE finomyrs.taxation;

CREATE TABLE finomyrs.taxation
(
  "taxationId" integer NOT NULL DEFAULT nextval('finomyrs."taxation_taxationId_seq"'::regclass),
  active boolean NOT NULL,  
  category text NOT NULL,
  name text NOT NULL,
  "assetClass" text NOT NULL,
  "taxRate" numeric(19,2) NOT NULL,
  "indexationAllowed" boolean DEFAULT FALSE,
  created timestamp without time zone,
  "createdBy" text,
  "lastUpdated" timestamp without time zone,
  "lastUpdatedBy" text,  
  CONSTRAINT taxation_pkey PRIMARY KEY ("taxationId")
)
WITH (
  OIDS=FALSE
);
ALTER TABLE finomyrs.taxation
  OWNER TO postgres;

---
CREATE TABLE finomyrs.taxation
(
  "taxationId" integer NOT NULL,
  active boolean,
  "assetClass" character varying(255),
  category character varying(255),
  created timestamp without time zone,
  "createdBy" character varying(255),
  "lastUpdated" timestamp without time zone,
  "lastUpdatedBy" character varying(255),
  name character varying(255),
  "taxRate" numeric(19,2),
  CONSTRAINT taxation_pkey PRIMARY KEY ("taxationId")
)
WITH (
  OIDS=FALSE
);
ALTER TABLE finomyrs.taxation
  OWNER TO postgres;
