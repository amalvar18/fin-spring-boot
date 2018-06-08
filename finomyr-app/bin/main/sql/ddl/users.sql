-- Table: "finomyrs"."users"

-- DROP TABLE "FinomyrBkup".users_bkup;

-- CREATE TABLE "FinomyrBkup"."users_bkup" AS (select * from "finomyrs"."users");

--DROP TABLE "finomyrs"."users";

CREATE TABLE "finomyrs"."users"
(
  "userId" integer NOT NULL,
  active boolean NOT NULL DEFAULT false,
  email text NOT NULL,
  password text NOT NULL,
  "firstName" text NOT NULL,
  "lastName" text NOT NULL,
  CONSTRAINT "users_pkey" PRIMARY KEY ("userId")
)
WITH (
  OIDS=FALSE
);
ALTER TABLE "finomyrs"."users"
  OWNER TO postgres;
  
--INSERT
INSERT INTO "finomyrs"."users"(
"userId", email, password, "firstName", "lastName", active)
VALUES (1, 'lamavar98misc@outlook.com', '$2a$10$.L99TAIxplXZe7TdKCP4H.kRNmYn601SJ/kUstBICqsys8FQTwzhi', 'amal', 'v', true);

INSERT INTO "finomyrs"."users"(
        "userId", email, password, "firstName", "lastName", active)
VALUES (2, 'testuser@test.com', 'test987', 'test', 'user', true);

INSERT INTO "finomyrs"."users"(
        "userId", email, password, "firstName", "lastName", active)
VALUES (3, 'inactiveTestUser@test.com', 'test123', 'inactive', 'testuser', false);
  
 ---------------------

CREATE TABLE "finomyrs"."users"
(
  "userId" bigserial NOT NULL,
  email text NOT NULL,
  password text NOT NULL,
  "firstName" text NOT NULL,
  "lastName" text NOT NULL,
  active integer NOT NULL DEFAULT 0,
  CONSTRAINT "pk_users_userId" PRIMARY KEY ("userId"),
  CONSTRAINT "check_active" CHECK (active=0 OR active=1)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE "finomyrs"."users"
  OWNER TO postgres;
  
--INSERT  
INSERT INTO "finomyrs"."users"(
"userId", email, password, "firstName", "lastName", active)
VALUES (1, 'lamavar98misc@outlook.com', '$2a$10$.L99TAIxplXZe7TdKCP4H.kRNmYn601SJ/kUstBICqsys8FQTwzhi', 'amal', 'v', 1);

INSERT INTO "finomyrs"."users"(
        "userId", email, password, "firstName", "lastName", active)
VALUES (2, 'testuser@test.com', 'test987', 'test', 'user', 0);