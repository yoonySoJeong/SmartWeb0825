CREATE TABLE NOTICE
(
        NO NUMBER PRIMARY KEY,
        TITLE VARCHAR2(100),
        CONTENT VARCHAR2(100),
        CREATED DATE,
        LASTMODIFIED DATE
);

CREATE SEQUENCE NOTICE_SEQ NOCACHE;