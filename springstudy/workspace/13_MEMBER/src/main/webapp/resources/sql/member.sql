DROP TABLE MEMBER;
CREATE TABLE MEMBER
(
    NO NUMBER PRIMARY KEY,
    ID VARCHAR2(32) NOT NULL UNIQUE,
    PW VARCHAR2(64),  -- ��ȣȭ�� ��й�ȣ �ִ� 32����Ʈ (1����Ʈ�� 2���ڷ� ǥ��)
    NAME VARCHAR2(32),
    EMAIL VARCHAR2(100) NOT NULL UNIQUE, -- �̸��� ���� ������ �ߺ� ����
    STATE NUMBER(1), -- ���� ���� (���� : 1, Ż�� : -1) (����, ������, Ż�� ��� ���� ���� �и� ����)
    REGISTED DATE -- ������
);

DROP SEQUENCE MEMBER_SEQ;
CREATE SEQUENCE MEMBER_SEQ NOCACHE;
    