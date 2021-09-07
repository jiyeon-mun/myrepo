-- SELECT 절에 서브쿼리 사용 -> Scalar(스칼라) Sub Query
-- 스칼라 : 단일 값, 정해진 값
SELECT EMPLOYEE_ID
     , FIRST_NAME
     , LAST_NAME
     , EMAIL
     , PHONE_NUMBER
     , HIRE_DATE
     , JOB_ID
     , (SELECT JOB_TITLE
          FROM JOBS B
         WHERE B.JOB_ID = A.JOB_ID) AS JOB_TITLE
     , SALARY
     , COMMISSION_PCT
     , MANAGER_ID
     , DEPARTMENT_ID
     , (SELECT DEPARTMENT_NAME
          FROM DEPARTMENTS C
         WHERE C.DEPARTMENT_ID = A.DEPARTMENT_ID) AS DEPARTMENT_NAME
  FROM EMPLOYEES A;

-- WHERE 절에 서브쿼리 사용 -> 상호연관 서브쿼리
SELECT *
  FROM EMPLOYEES
 WHERE SALARY <= (SELECT AVG(SALARY) FROM EMPLOYEES);

SELECT *
  FROM EMPLOYEES
 WHERE EMPLOYEE_ID IN (SELECT DISTINCT MANAGER_ID FROM EMPLOYEES WHERE MANAGER_ID IS NOT NULL);

-- FROM 절에 서브쿼리 사용 -> Inline View(인라인 뷰)
SELECT *
  FROM (SELECT EMPLOYEE_ID
             , FIRST_NAME
             , LAST_NAME
          FROM EMPLOYEES);

WITH TEMP AS (
    SELECT EMPLOYEE_ID
         , FIRST_NAME
         , LAST_NAME
      FROM EMPLOYEES
)
SELECT * FROM TEMP;



-- 랭킹 조회
SELECT *
  FROM (SELECT EMPLOYEE_ID
             , FIRST_NAME
             , LAST_NAME
             , SALARY
             -- SALARY 를 내림차순으로 정렬하여 RANK 부여하는데 RANK 가 10 이하까지 정렬
             -- 단, 중복된 급여로 인한 중복 순위의 경우 중복 개수만큼 다음의 순위가 없다.
             -- 예를 들어 2등이 2번 중복되면 3등이 존재하지 않고 바로 4등으로 넘어감.
             , RANK() OVER(ORDER BY SALARY DESC) AS "RANK"
          FROM EMPLOYEES)
 WHERE "RANK" <= 10;

SELECT *
  FROM (SELECT EMPLOYEE_ID
             , FIRST_NAME
             , LAST_NAME
             , SALARY
             -- SALARY 를 내림차순으로 정렬하여 RANK 부여하는데 RANK 가 10 이하까지 정렬
             -- 중복 순위의 개수에 연연하지 않음. 중복 순위가 있어도 그 다음 순위로 RANK 부여한다.
             , DENSE_RANK() OVER(ORDER BY SALARY DESC) AS "RANK"
          FROM EMPLOYEES)
 WHERE "RANK" <= 10;



-- 모든 조회 결과에는 코드가 아닌 식별가능한 값도 조회되어야 한다.

-- 1. 매니저가 존재하는 부서의 사원들을 조회
--    (DEPARTMENTS, EMPLOYEES)
SELECT B.EMPLOYEE_ID
     , B.FIRST_NAME
     , B.LAST_NAME
     , B.DEPARTMENT_ID
     , (SELECT A.DEPARTMENT_NAME
          FROM DEPARTMENTS A
         WHERE A.DEPARTMENT_ID = B.DEPARTMENT_ID) AS DEPARTMENT_NAME
     , B.MANAGER_ID
  FROM EMPLOYEES B
 WHERE B.DEPARTMENT_ID IN (SELECT DEPARTMENT_ID
                          FROM DEPARTMENTS
                         WHERE MANAGER_ID IS NOT NULL)
 ORDER BY 1;

SELECT A.EMPLOYEE_ID
     , A.FIRST_NAME
     , A.LAST_NAME
     , B.DEPARTMENT_ID
     , B.DEPARTMENT_NAME
     , A.MANAGER_ID
  FROM EMPLOYEES A JOIN DEPARTMENTS B
    ON B.DEPARTMENT_ID = A.DEPARTMENT_ID
 WHERE B.MANAGER_ID IS NOT NULL
 ORDER BY 1;

-- 2. 유럽, 아메리카, 아시아, 중앙아시아/아프리카 지역(REGIONS)에 있는 부서의 수를 조회
--    (REGIONS, COUNTRIES, LOCATIONS , DEPARTMENTS)
SELECT D.REGION_ID
     , D.REGION_NAME
     , COUNT(A.DEPARTMENT_ID) AS "대륙별 부서의 수"
  FROM DEPARTMENTS A JOIN LOCATIONS B
    ON A.LOCATION_ID = B.LOCATION_ID
  JOIN COUNTRIES C
    ON B.COUNTRY_ID = C.COUNTRY_ID
  JOIN REGIONS D
    ON C.REGION_ID = D.REGION_ID
 GROUP BY D.REGION_ID, D.REGION_NAME;

-- 3. 모든 부서의 위치(주소)를 조회
--    (REGIONS, COUNTRIES, LOCATIONS, DEPARTMENTS)
SELECT A.DEPARTMENT_NAME
     , B.STREET_ADDRESS
     , B.POSTAL_CODE
     , B.CITY
     , B.STATE_PROVINCE
     , C.COUNTRY_NAME
     , D.REGION_NAME
  FROM DEPARTMENTS A JOIN LOCATIONS B
    ON A.LOCATION_ID = B.LOCATION_ID
  JOIN COUNTRIES C
    ON C.COUNTRY_ID = B.COUNTRY_ID
  JOIN REGIONS D
    ON D.REGION_ID = C.REGION_ID;

-- 4. 아메리카 지역에 해당하는 부서와 소속 사원들을 조회
--    (REGIONS, COUNTRIES, LOCATIONS, DEPARTMENTS, EMPLOYEES)
SELECT B.DEPARTMENT_NAME
     , A.EMPLOYEE_ID
     , CONCAT(A.FIRST_NAME,' ' || A.LAST_NAME) AS "NAME"
     , E.REGION_NAME
  FROM EMPLOYEES A JOIN DEPARTMENTS B
    ON A.DEPARTMENT_ID = B.DEPARTMENT_ID
  JOIN LOCATIONS C
    ON C.LOCATION_ID = B.LOCATION_ID
  JOIN COUNTRIES D
    ON D.COUNTRY_ID = C.COUNTRY_ID
  JOIN REGIONS E
    ON E.REGION_ID = D.REGION_ID
 -- WHERE E.REGION_ID = 2
 WHERE E.REGION_NAME = 'Americas'
 ORDER BY 1;

-- 5. 소속 지역별 평균급여 랭크 조회(지역은 대륙단위로 묶어서 한다.)
--    (REGIONS, COUNTRIES, LOCATIONS, DEPARTMENTS, EMPLOYEES)
SELECT RANK() OVER(ORDER BY AVG(A.SALARY) DESC) AS 순위
     , E.REGION_NAME
     , AVG(A.SALARY) AS 평균급여
  FROM EMPLOYEES A JOIN DEPARTMENTS B
    ON A.DEPARTMENT_ID = B.DEPARTMENT_ID
  JOIN LOCATIONS C
    ON C.LOCATION_ID = B.LOCATION_ID
  JOIN COUNTRIES D
    ON D.COUNTRY_ID = C.COUNTRY_ID
  JOIN REGIONS E
    ON E.REGION_ID = D.REGION_ID
 GROUP BY E.REGION_NAME;

SELECT * FROM EMPLOYEES;
SELECT * FROM COUNTRIES;
SELECT * FROM REGIONS;
-- 6. 국가별 평균급여 랭크 조회
--    (COUNTRIES, LOCATIONS, DEPARTMENTS, EMPLOYEES)
SELECT RANK() OVER(ORDER BY AVG(A.SALARY) DESC) AS 랭킹
     , AVG(A.SALARY) AS 평균급여
     , D.COUNTRY_NAME AS 국가명
  FROM EMPLOYEES A JOIN DEPARTMENTS B
    ON A.DEPARTMENT_ID = B.DEPARTMENT_ID
  JOIN LOCATIONS C
    ON B.LOCATION_ID = C.LOCATION_ID
  JOIN COUNTRIES D
    ON C.COUNTRY_ID = D.COUNTRY_ID
 GROUP BY D.COUNTRY_NAME;

-- 7. 국가별/부서별 평균급여 조회(전체 평균 및 국가 단위 평균, 부서 단위 평균의 통계가 필요)
--    (COUNTRIES, LOCATIONS, DEPARTMENTS, EMPLOYEES)
SELECT AVG(A.SALARY) AS 평균급여
     , D.COUNTRY_NAME AS 국가명
     , B.DEPARTMENT_NAME AS 부서명
  FROM EMPLOYEES A JOIN DEPARTMENTS B
    ON A.DEPARTMENT_ID = B.DEPARTMENT_ID
  JOIN LOCATIONS C
    ON B.LOCATION_ID = C.LOCATION_ID
  JOIN COUNTRIES D
    ON C.COUNTRY_ID = D.COUNTRY_ID
 GROUP BY CUBE(D.COUNTRY_NAME, B.DEPARTMENT_NAME);