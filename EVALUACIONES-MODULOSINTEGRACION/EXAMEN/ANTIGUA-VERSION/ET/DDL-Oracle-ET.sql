CREATE TABLE producto (
    pr_id            NUMBER NOT NULL,
    pr_nombre        VARCHAR2(45),
    pr_moneda        VARCHAR2(15),
    pr_valormoneda   NUMBER(5,2)
);

ALTER TABLE producto ADD CONSTRAINT producto_pk PRIMARY KEY ( pr_id );