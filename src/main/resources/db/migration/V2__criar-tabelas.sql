
CREATE SEQUENCE RESIDUOS_SEQ
    START WITH 1
    INCREMENT BY 1
    NOCACHE
    NOCYCLE;

CREATE TABLE TBL_AGENDAMENTO (
                                 ID INTEGER DEFAULT RESIDUOS_SEQ.NEXTVAL NOT NULL,
                                 DIA_COLETA DATE NOT NULL,
                                 ENDERECO VARCHAR2(300) NOT NULL,
                                 NUMERO INTEGER NOT NULL,
                                 TOKEN  INTEGER NOT NULL
);
