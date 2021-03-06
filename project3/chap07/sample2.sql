SELECT * FROM TB_STUDENT;
DESC TB_STUDENT;

DROP TABLE IDX_TEST;
-- 테이블 생성할 때 PRIMARY KEY, UNIQUE 부여 시 자동으로 인덱스 생성됨
CREATE TABLE IDX_TEST(
      STUDENT_NO        VARCHAR2(10)    -- PRIMARY KEY
    , STUDENT_NAME      VARCHAR2(50)    NOT NULL
    , STUDENT_SSN       VARCHAR2(14)    -- UNIQUE
    , STUDENT_ADDRESS   VARCHAR2(100)
);
INSERT INTO IDX_TEST(
    SELECT STUDENT_NO
         , STUDENT_NAME
         , STUDENT_SSN
         , STUDENT_ADDRESS
      FROM TB_STUDENT
);

-- ROWID : 테이블에서 행의 위치를 지정하는 논리적인 주소값으로 
--         중복되지 않으며 새로운 행을 추가할 때마다 그 값은 자동으로 생성된다.
SELECT ROWID
     , STUDENT_NO
     , STUDENT_NAME
     , STUDENT_SSN
     , STUDENT_ADDRESS
  FROM TB_STUDENT;

-- 테이블에서 사용하고 있는 인덱스 확인
SELECT * FROM USER_IND_COLUMNS WHERE TABLE_NAME = 'IDX_TEST';

CREATE UNIQUE INDEX IDX_TEST_STUDENT_NO ON IDX_TEST(STUDENT_NO);
DROP INDEX IDX_TEST_STUDENT_NO;
CREATE UNIQUE INDEX IDX_TEST_STUDENT_NO ON IDX_TEST(STUDENT_NO DESC);

CREATE INDEX IDX_TEST_STUDENT_NAME ON IDX_TEST(STUDENT_NAME);
DROP INDEX IDX_TEST_STUDENT_NAME;

CREATE INDEX IDX_TEST_STUDENT_NAME_SSN ON IDX_TEST(STUDENT_NAME, STUDENT_SSN);
DROP INDEX IDX_TEST_STUDENT_NAME_SSN;

CREATE INDEX IDX_TEST_STUDENT_SSN ON IDX_TEST(SUBSTR(STUDENT_SSN, 1, 6));
DROP INDEX IDX_TEST_STUDENT_SSN;

-- 인덱스로 정렬된 데이터 보기 테스트
SELECT STUDENT_NAME
     , STUDENT_SSN
  FROM IDX_TEST
 WHERE STUDENT_SSN > '0';

-- 기존 인덱스 삭제
DROP INDEX IDX_TEST_STUDENT_SSN;

-- 내림차순으로 정렬될 수 있도록 인덱스 생성
CREATE INDEX IDX_TEST_STUDENT_SSN ON IDX_TEST(STUDENT_SSN DESC);

-- 인덱스 생성 후 다시 조회
SELECT STUDENT_NAME
     , STUDENT_SSN
  FROM IDX_TEST
 WHERE STUDENT_SSN > '0';