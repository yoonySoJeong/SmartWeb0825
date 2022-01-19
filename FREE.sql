SELECT B.RN, B.FNO, B.WRITER, B.CONTENT
  FROM (SELECT ROWNUM AS RN, A.FNO, A.WRITER, A.CONTENT
          FROM (SELECT FNO, WRITER, CONTENT
          FROM FREE
         ORDER BY FNO DESC) A) B
 WHERE B.RN BETWEEN 1 AND 3;        -- BEGIN / END 결정 자리
-- ROWNUM == 행 번호 BEGIN, END 기준이 ROWNUM!! FNO가 기준이 아님 주의!!!
-- ROWNUM : RN :: RN이 기준이 된다 BEGIN, END  ** RN은 가상 칼럼이다.
-- 1. 최신 게시글을 DESC 정렬, 그것을 A라고 부름 
-- 2. 거기다가 행번호를 붙임 그것이 B (B: 정렬, 행번호 붙음),
-- 3. 최종 결과인 B에서 BEGIN, END를 구함