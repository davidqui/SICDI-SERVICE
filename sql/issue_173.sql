-- -----------------------------------------------------------------------------
-- 2018-07-16 edison.gonzalez@controltechcg.com Feature #173 (SICDI-Controntech)
-- feature-173
-- Creación de la tabla en la cual se guardaran los usuarios con acceso al servicio
-- web.
-- -----------------------------------------------------------------------------

CREATE TABLE "DOC"."USUARIO_WS"(
    "USU_ID"        NUMBER(*,0)     NOT NULL,
    "USU_CODIGO"    VARCHAR2(32)    NOT NULL,
    "USU_CLAVE"     VARCHAR2(32)    NOT NULL,
    CONSTRAINT "USUARIO_WS_PK" PRIMARY KEY ("USU_ID")
);

CREATE SEQUENCE  "DOC"."USUARIO_WS_SEQ"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 1;

COMMENT ON COLUMN DOC.USUARIO_WS.USU_ID     IS 'Identificador único de la tabla';
COMMENT ON COLUMN DOC.USUARIO_WS.USU_CODIGO IS 'Código del usuario';
COMMENT ON COLUMN DOC.USUARIO_WS.USU_CLAVE  IS 'Clave del usuario';

CREATE INDEX USUARIO_WS_IDX1 ON USUARIO_WS(USU_CODIGO);

INSERT INTO USUARIO_WS(USU_ID, USU_CODIGO, USU_CLAVE) values(USUARIO_WS_SEQ.nextval, 'ORFEO', '200a63a876e348fba487e7c2f71621eb');
commit;