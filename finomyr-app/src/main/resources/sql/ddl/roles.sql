-- Table: "finomyrs".roles

-- DROP TABLE "FinomyrBkup".roles_bkup;

-- CREATE TABLE "FinomyrBkup"."roles_bkup" AS (select * from "finomyrs"."roles");

--DROP TABLE "finomyrs"."roles";

CREATE TABLE "finomyrs"."roles"
(
  "roleId" integer NOT NULL,
  role text NOT NULL,
  CONSTRAINT "roles_pkey" PRIMARY KEY ("roleId")
)
WITH (
  OIDS=FALSE
);
ALTER TABLE "finomyrs"."roles"
  OWNER TO postgres;
  
---INSERT---
INSERT INTO "finomyrs"."roles" VALUES (2,'ADMIN'); 
INSERT INTO "finomyrs"."roles" VALUES (default,'USER');  