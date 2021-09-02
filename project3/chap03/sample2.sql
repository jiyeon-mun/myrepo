-- 오라클 제공 함수
-- 임시테이블 DUAL 이용
SELECT * FROM DUAL;

SELECT ROUND(1.1234, 2), ROUND(1.4567, 3)  -- 반올림
     , TRUNC(1.1234, 2), TRUNC(1.4567, 3)  -- 버림
     , POWER(2, 2), POWER(3, 2)            -- 제곱
     , MOD(5, 2), MOD(7, 5)                -- 나머지
  FROM DUAL;

SELECT LOWER('ABCD'), UPPER('abcd')         -- 대소문자 변환
     , CONCAT('abcd', 'efgh')               -- 문자열 결합
     , LTRIM(' abcd'), RTRIM('abcd ')       -- 왼쪽/오른쪽 공백제거
     , LTRIM('---abcd---', '-')             -- 왼쪽/오른쪽에 있는 문자를 제거(지정한 문자에 대해 제거)
     , RTRIM('---abcd---', '-')
     , TRIM('   abcd   '), TRIM('-' FROM '---abcd---')
  FROM DUAL;

SELECT SUBSTR('substr', 4, 3)
     , SUBSTR('문자열자르기', 4, 3)
     , REPLACE('str_replace', 'replace', '바꾸기')
     , LENGTH('문자열길이'), LENGTHB('문자열길이')  -- LENGTH : 문자개수 / LENGTHB : BYTE 반환
  FROM DUAL;

SELECT NVL(NULL, 1), NVL('널아님', 1)
     , NVL2(NULL, 1, 2), NVL2('널아님', 1, 2)
  FROM DUAL;

-- DECODE(표현식, 조건1, 결과1, 조건2, 결과2,..., DEFAULT)
--      조건: 해당값이 참인지 거짓인지 판단
--      결과: 해당 조건이 일치하는 경우 반환값
--      DEFAULT: 모든 조건이 불일치 시 반환값
-- DECODE 함수 (소괄호) 내 데이터 개수는 짝수로 지정한다.
SELECT DECODE('VAL1', 'VAL2', 'VAL3', 'VAL4')
     , DECODE('VAL2', 'VAL2', 'VAL3', 'VAL4')
     , DECODE('VAL2', 'VAL2', 'VAL3', 'VAL4')
     , DECODE('VAL1', 'VAL2', 'VAL3', 'VAL4', 'VAL5', 'VAL6')
     , DECODE('VAL2', 'VAL2', 'VAL3', 'VAL4', 'VAL5', 'VAL6')
     , DECODE('VAL4', 'VAL2', 'VAL3', 'VAL4', 'VAL5', 'VAL6')
  FROM DUAL;

-- SYSDATE : 시스템의 현재 날짜 정보
SELECT SYSDATE
     , TO_CHAR(SYSDATE, 'yyyy-mm-dd')
     , TO_CHAR(SYSDATE, 'yyyy-mm-dd hh:mi:ss')
     , SYSTIMESTAMP, TO_CHAR(SYSTIMESTAMP, 'yyyy-mm-dd')
     , TO_CHAR(SYSTIMESTAMP, 'yyyy-mm-dd hh:mi:ss')
  FROM DUAL;

-- 문자열 데이터 '210505' 를 '2021년 5월 5일' 로 표현될 수 있도록 
SELECT TO_CHAR(TO_DATE('210505','YYMMDD'),'YYYY"년 "MM"월 "DD"일"')
  FROM DUAL;

SELECT TO_DATE('2021-09-01', 'yyyy-mm-dd')
     , TO_TIMESTAMP('2021-09-01', 'yyyy-mm-dd')
  FROM DUAL;

-- SYSDATE 에서 년, 월, 일 분리해서 출력
-- SYSTIMESTAMP 에서 시간, 분, 초 부분 분리하여 출력
SELECT SYSDATE FROM DUAL; -- 01-9-21 형식(일-월-년)
SELECT SYSTIMESTAMP FROM DUAL;-- 01-9-21 05.22.15.934075000 AM +00:00 형식
SELECT EXTRACT(YEAR FROM SYSDATE)
     , EXTRACT(MONTH FROM SYSDATE)
     , EXTRACT(DAY FROM SYSDATE)
     , EXTRACT(HOUR FROM SYSTIMESTAMP)
     , EXTRACT(MINUTE FROM SYSTIMESTAMP)
     , EXTRACT(SECOND FROM SYSTIMESTAMP)
  FROM DUAL;

-- 두 날짜 간의 개월 수 차이; 왼쪽이 기준
SELECT MONTHS_BETWEEN(SYSDATE, TO_DATE('2021-01','YYYY-MM')) -- 후(양수)
     , MONTHS_BETWEEN(TO_DATE('2021-01','YYYY-MM'), SYSDATE) -- 전(음수)
  FROM DUAL;

SELECT TO_NUMBER('10'), TO_CHAR(10)
     , TO_NUMBER('10.5'), TO_CHAR(10.5)
  FROM DUAL;


SELECT * FROM EMPLOYEES;
SELECT EMPLOYEE_ID
    , CONCAT(FIRST_NAME, ' ' || LAST_NAME) AS NAME -- (FIRST_NAME || ' ' || LAST_NAME) AS NAME
    , LOWER(CONCAT(EMAIL,'@employee.com')) AS EMAIL
    , REPLACE(PHONE_NUMBER,'.','-') AS PHONE_NUMBER
    , TO_CHAR(HIRE_DATE,'YYYY-MM-DD') AS HIRE_DATE
    , TRUNC((SYSDATE-HIRE_DATE) / 365, 0) AS "근속년"
    , JOB_ID
    , SALARY
    , NVL(COMMISSION_PCT,0.0) AS COMMISSION_PCT
    , SALARY * (1 + NVL(COMMISSION_PCT, 0)) AS "추가급여"
    , MANAGER_ID
    , DEPARTMENT_ID
  FROM EMPLOYEES;
 -- WHERE HIRE_DATE BETWEEN TO_DATE('1987-01-01','YYYY-MM-DD')
 --                     AND TO_DATE('1989-12-31','YYYY-MM-DD');


-- EMP테이블의 EMAIL컬럼에서 _앞이 3글자인 사원을 조회하는 구문
-- 특수문자 _나 % 처럼 와일드카드문자와 패턴이 동일한 경우
--          와일드카드문자패턴기호(_ OR %) 앞에 임의로 특수문자(#,@ 등)를 사용하고
--          ESCAPE OPTION으로 등록(ESCAPE '#' / ESCAPE '@' 등)하여 처리한다.
SELECT *
  FROM EMP
 WHERE EMAIL LIKE '___#_%' ESCAPE '#';