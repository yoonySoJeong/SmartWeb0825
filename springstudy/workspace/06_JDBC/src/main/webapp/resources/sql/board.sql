CREATE TABLE BOARD
(
    NO NUMBER PRIMARY KEY,
    WRITER VARCHAR2(100),
    TITLE VARCHAR2(100),
    CONTENT VARCHAR2(100),
    CREATED VARCHAR2(10),
    LASTMODIFIED VARCHAR2(10)
);
CREATE SEQUENCE BOARD_SEQ NOCACHE;

INSERT INTO board VALUES (BOARD_SEQ.NEXTVAL, 'YOON', '����', '����', SYSDATE, SYSDATE);