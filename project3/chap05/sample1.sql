-- JOIN : 2개 이상의 테이블에서 데이터를 조회하기 위해 사용하는 구문
--        집합 구문과는 다르게 쿼리 결과에 대한 무조건적인 집합(쿼리)셋을 구하는 것이 아닌
--        쿼리 결과에 대한 결합 조건이 있다.
--        집합 구문은 행(로우) 데이터에 대한 추가가 이루어 지지만. JOIN 은 열(컬럼) 데이터에 대한
--        추가가 이루어 진다.

-- Oracle 전용 구문; JOIN 역할; WHERE 문 이용
SELECT *
  FROM EMPLOYEES, DEPARTMENTS
 WHERE EMPLOYEES.DEPARTMENT_ID = DEPARTMENTS.DEPARTMENT_ID;

-- JOIN 형식
-- ON()은 연결에 사용하는 컬럼명이 다른 경우에 사용하나, 같은 경우에도 아래와 같은 형식으로 사용됨.
SELECT *
  FROM EMPLOYEES JOIN DEPARTMENTS
    ON (EMPLOYEES.DEPARTMENT_ID = DEPARTMENTS.DEPARTMENT_ID);
-- 연결에 사용하는 컬럼명이 같은 경우 USING() 사용함.
-- 공통되는 컬럼과 그 데이터값이 첫번째 열로 온다.
SELECT *
  FROM EMPLOYEES JOIN DEPARTMENTS USING(DEPARTMENT_ID);


-- 조인을 수행하는 테이블의 컬럼이 동일한 이름을 사용하는 경우 테이블명.컬럼명 으로 구분시킨다.
SELECT EMPLOYEES.EMPLOYEE_ID AS 사원코드
     , CONCAT(EMPLOYEES.FIRST_NAME, ' ' || EMPLOYEES.LAST_NAME) AS 사원명
     , EMPLOYEES.DEPARTMENT_ID AS 부서코드
     , DEPARTMENTS.DEPARTMENT_NAME AS 부서명
  FROM EMPLOYEES JOIN DEPARTMENTS
    ON (EMPLOYEES.DEPARTMENT_ID = DEPARTMENTS.DEPARTMENT_ID);

-- 테이블명에 별칭을 부여할 수 있음.
SELECT A.EMPLOYEE_ID AS 사원코드
     , CONCAT(A.FIRST_NAME, ' ' || A.LAST_NAME) AS 사원명
     , A.DEPARTMENT_ID AS 부서코드
     , B.DEPARTMENT_NAME AS 부서명
  FROM EMPLOYEES A JOIN DEPARTMENTS B
    ON (A.DEPARTMENT_ID = B.DEPARTMENT_ID);

-- 조인 조건의 컬럼명이 동일한 경우 USING 을 사용하여 결합시킬 수 있다.
SELECT A.EMPLOYEE_ID AS 사원코드
     , CONCAT(A.FIRST_NAME, ' ' || A.LAST_NAME) AS 사원명
     , DEPARTMENT_ID AS 부서코드
     , B.DEPARTMENT_NAME AS 부서명
  FROM EMPLOYEES A JOIN DEPARTMENTS B
 USING (DEPARTMENT_ID);


-- 2개 이상의 테이블에 대한 조인
SELECT A.EMPLOYEE_ID AS 사원코드
     , CONCAT(A.FIRST_NAME, ' ' || A.LAST_NAME) AS 사원명
     , DEPARTMENT_ID AS 부서코드
     , B.DEPARTMENT_NAME AS 부서명
     , JOB_ID AS 직업코드
     , C.JOB_TITLE AS 직업명
  FROM EMPLOYEES A JOIN DEPARTMENTS B
 USING (DEPARTMENT_ID)
  JOIN JOBS C
 USING (JOB_ID);


-- 아래의 테이블의 DEPARTMENT_NO, COACH_PROFESSOR_NO 를 활용하여 학과명, 교수명 컬럼이
-- 조회될 수 있도록 JOIN 을 사용
SELECT A.STUDENT_NO
     , A.STUDENT_NAME
     , A.DEPARTMENT_NO
     , B.DEPARTMENT_NAME
     , A.COACH_PROFESSOR_NO
     , C.PROFESSOR_NAME
  FROM TB_STUDENT A JOIN TB_DEPARTMENT B
    ON A.DEPARTMENT_NO = B.DEPARTMENT_NO
  JOIN TB_PROFESSOR C
    ON A.COACH_PROFESSOR_NO = C.PROFESSOR_NO;


-- OUTER JOIN : 일반 JOIN 과는 다르게 결합 조건에 부합하는 데이터가 없어도 조회 결과로 나올 수
--              있게 한다. 왼쪽 테이블을 기준으로 조회결과가 나오게 할때에는 LEFT OUTER JOIN
--              오른쪽 테이블을 기준으로 조회결과가 나오게 할떄에는 RIGHT OUTER JOIN
SELECT EMPLOYEE_ID
     , FIRST_NAME
     , LAST_NAME
     , DEPARTMENT_ID
  FROM EMPLOYEES WHERE EMPLOYEE_ID BETWEEN 175 AND 180;

SELECT A.EMPLOYEE_ID
     , A.FIRST_NAME
     , A.LAST_NAME
     , A.DEPARTMENT_ID
     , B.DEPARTMENT_NAME
  FROM EMPLOYEES A JOIN DEPARTMENTS B
    ON A.DEPARTMENT_ID = B.DEPARTMENT_ID
 WHERE A.EMPLOYEE_ID BETWEEN 175 AND 180;
-- EMPLOYEE_ID 가 WHERE 조건은 만족하나 행에 NULL 값 데이터를 갖는 경우 해당 행은 JOIN 하지 않음. 

SELECT A.EMPLOYEE_ID
     , A.FIRST_NAME
     , A.LAST_NAME
     , A.DEPARTMENT_ID
     , B.DEPARTMENT_NAME
  FROM EMPLOYEES A LEFT OUTER JOIN DEPARTMENTS B
    ON A.DEPARTMENT_ID = B.DEPARTMENT_ID
 WHERE A.EMPLOYEE_ID BETWEEN 175 AND 180;
-- WHERE 조건은 만족하는 EMPLOYEE_ID 의 행 데이터값들 모두 출력(NULL 값도)


WITH L_TB AS (
    SELECT 1 AS ID, '가' AS NAME FROM DUAL
    UNION ALL
    SELECT 2 AS ID, '나' AS NAME FROM DUAL
    UNION ALL
    SELECT 3 AS ID, '다' AS NAME FROM DUAL
), R_TB AS (
    SELECT 1 AS ID, '라' AS NAME FROM DUAL
    UNION ALL
    SELECT 2 AS ID, '마' AS NAME FROM DUAL
    UNION ALL
    SELECT 4 AS ID, '바' AS NAME FROM DUAL
)
SELECT *
  FROM L_TB A CROSS JOIN R_TB B;
    -- ON A.ID = B.ID;
-- CROSS JOIN : 카테시안 곱으로
-- 검색되는 데이터 수는 '행의 컬럼 수 * 또 다른 행의 컬럼 수'