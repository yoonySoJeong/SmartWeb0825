/* table */
DROP TABLE pboard;
CREATE TABLE pboard
(
	idx			NUMBER,
	title 		VARCHAR2(100),
	writer 		VARCHAR2(100),
	content 	VARCHAR2(1000),
	register	VARCHAR2(10),
	PRIMARY KEY(idx)
);
/* register : string --> 작성일 */

/* sequence */
DROP SEQUENCE pboard_seq;
CREATE SEQUENCE pboard_seq INCREMENT BY 1 START WITH 1000 NOCYCLE NOCACHE;
