-- Table: finomyrs."investmentType"

--DROP TABLE finomyrs."investmentType";

CREATE TABLE finomyrs."investmentType"
(
  "investmentTypeId" integer NOT NULL DEFAULT nextval('finomyrs."investmentType_investmentTypeId_seq"'::regclass),
  active boolean DEFAULT true,
  comments text,
  "displayName" text,
  "parentId" integer,
  "rootId" integer,
  "taxationId" integer,
  CONSTRAINT "investmentType_pkey" PRIMARY KEY ("investmentTypeId"),
  CONSTRAINT "fk_taxation_taxationId" FOREIGN KEY ("taxationId")
      REFERENCES finomyrs.taxation ("taxationId") MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
ALTER TABLE finomyrs."investmentType"
  OWNER TO postgres;
