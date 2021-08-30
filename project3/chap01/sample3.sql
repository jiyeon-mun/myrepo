-- use1 계정(스키마) 가 가지고 있는 모든 테이블에 대한 조회
-- 현재 계정의 DB를 보여줌
SELECT * FROM USER_TABLES;
-- 각 테이블의 컬럼 및 데이터 조회
SELECT * FROM EMPLOYEES;
SELECT * FROM JOBS;
SELECT * FROM JOB_HISTORY;
SELECT * FROM LOCATIONS;
SELECT * FROM COUNTRIES;
SELECT * FROM REGIONS;
SELECT * FROM DEPARTMENTS;

-- dapartments 테이블에서 departments_name 이 Marketing 인 데이터 조회
SELECT * FROM DEPARTMENTS WHERE DEPARTMENT_NAME = 'Marketing';

-- dapartments 테이블에서 dapartments_name 이 IT 가 포함된 데이터 조회
SELECT * FROM DEPARTMENTS WHERE DEPARTMENT_NAME LIKE '%IT%';

-- LOCATIONS 테이블에서 COUNTRY_ID 가 US 인 데이터 조회할 때 STREET_ADDRESS, POSTAL_CODE, CITY 컬럼 조회
SELECT STREET_ADDRESS, POSTAL_CODE, CITY
  FROM LOCATIONS
 WHERE COUNTRY_ID = 'US';

-- LOCATIONS 테이블에서 POSTAL_CODE 가 5자리인 데이터 조회
 SELECT * FROM LOCATIONS WHERE POSTAL_CODE LIKE '_____';

-- EMPLOYEES 테이블에서 MANAGER_ID 가 100 이고, DEPARTMENT_ID 가 50인 데이터 조회
SELECT * FROM EMPLOYEES
 WHERE MANAGER_ID = 100 AND DEPARTMENT_ID =50;

-- EMPLOYEES 테이블에서 COMMISSION_PCT 가 NULL 이 아니면서 SALARY 가 10000 이상인 데이터 조회
SELECT * FROM EMPLOYEES
 WHERE COMMISSION_PCT IS NOT NULL AND SALARY >= 10000;

-- 위에서 조회한 모든 영문 컬럼을 한글로 바꾸어 조회하시오.
-- (AS 별칭명) 사용
SELECT * FROM COUNTRIES;
SELECT COUNTRY_ID AS 국가코드
    , COUNTRY_NAME AS 국가명
    , REGION_ID AS 지역코드
  FROM COUNTRIES;