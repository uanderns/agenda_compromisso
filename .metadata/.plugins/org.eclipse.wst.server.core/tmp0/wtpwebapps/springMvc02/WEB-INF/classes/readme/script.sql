CREATE DATABASE SPRINGMVC02;
USE SPRINGMVC02;

CREATE TABLE TBL_USUARIO (
    COD_USU INTEGER AUTO_INCREMENT,
    NOME_USU VARCHAR(150) NOT NULL,
    EMAIL_USU VARCHAR(100) NOT NULL UNIQUE,
    SENHA_USU VARCHAR(50) NOT NULL,
    DTCRIACAO_USU DATE NOT NULL,
    PRIMARY KEY (COD_USU)
);
    
DESC TBL_USUARIO;


CREATE TABLE TBL_COMPROMISSO (
    COD_COMP INTEGER AUTO_INCREMENT,
    NOME_COMP VARCHAR(150) NOT NULL,
    DATA_COMP DATE NOT NULL,
    HORA_COMP VARCHAR(5) NOT NULL,
    DESCRICAO_COMP VARCHAR(1000) NOT NULL,
    TIPO_COMP VARCHAR(20) NOT NULL,
    PRIORIDADE_COMP VARCHAR(10) NOT NULL,
    COD_USU INTEGER NOT NULL,
    PRIMARY KEY (COD_COMP),
    FOREIGN KEY (COD_USU)
        REFERENCES TBL_USUARIO (COD_USU)
);

ALTER TABLE TBL_COMPROMISSO 
ADD CONSTRAINT CHECK_TIPO_COMP
CHECK(TIPO_COMP 
IN ('Estudo', 'Trabalho', 'Familia', 'Lazer', 'Outros'));

ALTER TABLE TBL_COMPROMISSO 
ADD CONSTRAINT CHECK_PRIORIDADE_COMP
CHECK(PRIORIDADE_COMP 
IN ('Baixa', 'Media', 'Alta'));