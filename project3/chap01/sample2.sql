SELECT * FROM employees;

-- SELECT 절에서 산술 연산 사용
-- 작성한 내용대로 컬럼명이 생성됨
-- 컬럼과 리터럴 연결 시 작은 따옴표(') 이용; FIRST_NAME과 LAST_NAME 사이에 공백 생성
SELECT FIRST_NAME || ' ' || LAST_NAME
    , SALARY * 12
    FROM employees;

-- 컬럼 별칭 부여 (AS 별칭명)
-- 별칭명 사이에 공백 사용 시 큰 따옴표 이용
SELECT FIRST_NAME || ' ' || LAST_NAME AS "이 름"
    , SALARY * 12 AS 연봉
    FROM employees;

-- 중복 데이터 제거 후 조회 (조회하려는 컬럼에 대한 행 데이터 관련)
SELECT DISTINCT DEPARTMENT_ID AS 부서ID, MANAGER_ID AS 관리자ID
    FROM EMPLOYEES;

-- WHERE 절을 사용하여 조건 검색
/*
    <순서>
1. FROM 절 테이블 확인
2. WHERE 절 조건 확인
3. SELECET 절 조회 내용 확인
*/
SELECT DEPARTMENT_ID
    , FIRST_NAME
    , LAST_NAME
  FROM EMPLOYEES
 WHERE DEPARTMENT_ID = 30;
-- 같다= / 같지않다!=

SELECT DEPARTMENT_ID
    , FIRST_NAME
    , LAST_NAME
    , SALARY
  FROM EMPLOYEES
 WHERE SALARY >= 10000;

-- NULL은 조건 사용 불가; 참/거짓의 결과가 나올 수 없음
-- NULL 관련 참/거짓 값을 가지고 싶다면 IS NULL / IS NOT NULL 이용해라.
-- NULL = NULL 이런 형식은 사용할 수 없다.
SELECT *
  FROM EMPLOYEES
 WHERE NULL IS NULL
   AND DEPARTMENT_ID = 30;

-- 연산 우선순위는 () 소괄호로 조정해서 사용할 수 있다.
SELECT EMPLOYEE_ID
    , SALARY
    , DEPARTMENT_ID
  FROM EMPLOYEES
 WHERE DEPARTMENT_ID = 50 OR DEPARTMENT_ID = 60 AND SALARY >= 5000;
-- DEPARTMENT_ID가 50 또는 60인 그리고 SALARY가 5000이상인 각 조건들에 만족하는 컬럼의 데이터 출력

SELECT EMPLOYEE_ID
    , SALARY
    , DEPARTMENT_ID
  FROM EMPLOYEES
 WHERE (DEPARTMENT_ID = 50 OR DEPARTMENT_ID = 60) AND SALARY >= 5000;
-- DEPARTMENT_ID가 50 또는 60이면서 SALARY가 5000이상인 조건을 만족하는 컬럼의 데이터 출력

 -- 임시 테이블 DUAL : 산술 연산 검증
 SELECT 1 + 1 FROM DUAL;