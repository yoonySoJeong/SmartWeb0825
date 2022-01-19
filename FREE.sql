SELECT B.RN, B.FNO, B.WRITER, B.CONTENT
  FROM (SELECT ROWNUM AS RN, A.FNO, A.WRITER, A.CONTENT
          FROM (SELECT FNO, WRITER, CONTENT
          FROM FREE
         ORDER BY FNO DESC) A) B
 WHERE B.RN BETWEEN 1 AND 3;        -- BEGIN / END ���� �ڸ�
-- ROWNUM == �� ��ȣ BEGIN, END ������ ROWNUM!! FNO�� ������ �ƴ� ����!!!
-- ROWNUM : RN :: RN�� ������ �ȴ� BEGIN, END  ** RN�� ���� Į���̴�.
-- 1. �ֽ� �Խñ��� DESC ����, �װ��� A��� �θ� 
-- 2. �ű�ٰ� ���ȣ�� ���� �װ��� B (B: ����, ���ȣ ����),
-- 3. ���� ����� B���� BEGIN, END�� ����