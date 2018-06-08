-- Table: "finomyrs"."userRole"

--DROP TABLE "FinomyrBkup"."userRole_bkup";

-- CREATE TABLE "FinomyrBkup"."userRole_bkup" AS (select * from "finomyrs"."userRole");

--DROP TABLE "finomyrs"."userRole";

CREATE TABLE "finomyrs"."userRole"
(
  "userId" integer NOT NULL,
  "roleId" integer NOT NULL,
  CONSTRAINT "userRole_pkey" PRIMARY KEY ("userId", "roleId"),
  CONSTRAINT "fk_userRole_roles" FOREIGN KEY ("roleId")
      REFERENCES "finomyrs".roles ("roleId") MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT "fk_userRole_users" FOREIGN KEY ("userId")
      REFERENCES "finomyrs"."users" ("userId") MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
ALTER TABLE "finomyrs"."userRole"
  OWNER TO postgres;
  
---INSERT---
INSERT INTO "finomyrs"."userRole"(
            "userId", "roleId")
    VALUES (1, 1);
    
INSERT INTO "finomyrs"."userRole"(
        "userId", "roleId")
VALUES (1, 2);

INSERT INTO "finomyrs"."userRole"(
        "userId", "roleId")
VALUES (2, 2);

INSERT INTO "finomyrs"."userRole"(
    "userId", "roleId")
VALUES (3, 2);  