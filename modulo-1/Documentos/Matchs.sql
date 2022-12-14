CREATE USER GEEKERS IDENTIFIED BY oracle;
GRANT CONNECT TO GEEKERS;
GRANT CONNECT, RESOURCE, DBA TO GEEKERS;
GRANT CREATE SESSION TO GEEKERS;
GRANT DBA TO GEEKERS;
GRANT CREATE VIEW, CREATE PROCEDURE, CREATE SEQUENCE to GEEKERS;
GRANT UNLIMITED TABLESPACE TO GEEKERS;
GRANT CREATE MATERIALIZED VIEW TO GEEKERS;
GRANT CREATE TABLE TO GEEKERS;
GRANT GLOBAL QUERY REWRITE TO GEEKERS;
GRANT SELECT ANY TABLE TO GEEKERS;


CREATE TABLE "USUARIO" (
  "id_usuario" NUMBER,
  "nome" VARCHAR2(225) NOT null ,
  "email" VARCHAR2(225) NOT null ,
  "telefone" VARCHAR2(225) NOT null ,
  "senha" VARCHAR2(225) NOT null ,
  "dataNascimento" date NOT null ,
  "sexo" CHAR(1) NOT null ,
  PRIMARY KEY ("id_usuario")
);

CREATE TABLE "HOBBIE" (
  "id_hobbies" NUMBER NOT null,
  "tipo_hobbie" char(1) NOT NULL,
  "descricao" VARCHAR2(225) NOT null,
  "id_usuario" NUMBER,
  PRIMARY KEY ("id_hobbies"),
   CONSTRAINT "FK_HOBBIE_USUARIO_ID_USUARIO"
   FOREIGN KEY ("id_usuario")
   REFERENCES "USUARIO"("id_usuario")
);

CREATE TABLE "COMENTARIO" (
  "id_comentario" NUMBER,
  "comentario" VARCHAR2(225) NOT null,
  "id_usuario" NUMBER NOT null,
  PRIMARY KEY ("id_comentario"),
  CONSTRAINT "FK_COMENT_USUARIO_ID_USUARIO"
   FOREIGN KEY ("id_usuario")
   REFERENCES "USUARIO"("id_usuario")
);

CREATE TABLE "DESAFIO" (
  "id_desafio" NUMBER,
  "pergunta" VARCHAR2(225),
  "resposta" VARCHAR2(225),
  "id_usuario" NUMBER,
  PRIMARY KEY ("id_desafio"),
  CONSTRAINT "FK_DESAFIO_USUARIO_ID_USUARIO"
   FOREIGN KEY ("id_usuario")
   REFERENCES "USUARIO"("id_usuario")
);

CREATE TABLE "MATCH" (
  "id_match" NUMBER,
  "id_usuario" NUMBER,
  PRIMARY KEY ("id_match"),
  CONSTRAINT "FK_NATCH_USUARIO_ID_USUARIO"
   FOREIGN KEY ("id_usuario")
   REFERENCES "USUARIO"("id_usuario")
);

CREATE SEQUENCE SEQ_USUARIO
START WITH 1
INCREMENT BY 1
NOCACHE NOCYCLE;

CREATE SEQUENCE SEQ_HOBBIE
START WITH 1
INCREMENT BY 1
NOCACHE NOCYCLE;

CREATE SEQUENCE SEQ_DESAFIO
START WITH 1
INCREMENT BY 1
NOCACHE NOCYCLE;

CREATE SEQUENCE SEQ_MATCH
START WITH 1
INCREMENT BY 1
NOCACHE NOCYCLE;

CREATE SEQUENCE SEQ_COMENTARIO
START WITH 1
INCREMENT BY 1
NOCACHE NOCYCLE;


INSERT INTO USUARIO("id_usuario", "nome" , "email" , "telefone" , "senha" , "dataNascimento" , "sexo")
VALUES (SEQ_USUARIO.nextval, 'Kaio', 'Kaio@dbc.com', '99831234124', '1234', TO_DATE('14-03-2002', 'dd-mm-yyyy'), 'M');
INSERT INTO USUARIO("id_usuario", "nome" , "email" , "telefone" , "senha" , "dataNascimento" , "sexo")
VALUES (SEQ_USUARIO.nextval, 'Ricardo', 'Ricardo@dbc.com', '99831234124', '1234', TO_DATE('14-03-2002', 'dd-mm-yyyy'), 'M');
INSERT INTO USUARIO("id_usuario", "nome" , "email" , "telefone" , "senha" , "dataNascimento" , "sexo")
VALUES (SEQ_USUARIO.nextval, 'Felipe', 'Felipe@dbc.com', '99831234124', '1234', TO_DATE('14-03-2002', 'dd-mm-yyyy'), 'M');

INSERT INTO HOBBIE ("id_hobbies", "tipo_hobbie", "descricao", "id_usuario")
VALUES (SEQ_HOBBIE.nextval , 1, 'jogo pokemon', 1);
INSERT INTO HOBBIE ("id_hobbies", "tipo_hobbie", "descricao", "id_usuario")
VALUES (SEQ_HOBBIE.nextval , 2, 'leio 1984', 2);

INSERT INTO COMENTARIO ("id_comentario", "comentario", "id_usuario")
VALUES (SEQ_COMENTARIO.nextval, 'BELO PERFIL', 1);
INSERT INTO COMENTARIO ("id_comentario", "comentario", "id_usuario")
VALUES (SEQ_COMENTARIO.nextval, 'PARABENS', 1);

INSERT INTO MATCH("id_match", "id_usuario")
VALUES (SEQ_MATCH.NEXTVAL, 1);
INSERT INTO MATCH("id_match", "id_usuario")
VALUES (SEQ_MATCH.NEXTVAL, 2);
