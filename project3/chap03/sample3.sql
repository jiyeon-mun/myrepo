SELECT * FROM EMPLOYEES;
SELECT * FROM ALL_TAB_COLUMNS WHERE TABLE_NAME = 'EMPLOYEES';

-- 1.  EMPLOYEES테이블에서 COMMISSION_PCT 의 값이 NULL이 아닌 정보 조회
SELECT *
  FROM EMPLOYEES
 WHERE COMMISSION_PCT IS NOT NULL;

-- 2.  EMPLOYEES테이블에서 커미션을 받지 못하는 직원 조회
SELECT FIRST_NAME || ' ' || LAST_NAME AS NAME
     , COMMISSION_PCT
  FROM EMPLOYEES
 WHERE COMMISSION_PCT IS NULL;

-- 3.  EMPLOYEES테이블에서 관리자가 없는 직원 정보 조회
SELECT FIRST_NAME || ' ' || LAST_NAME AS NAME
     , MANAGER_ID
  FROM EMPLOYEES
 WHERE MANAGER_ID IS NULL;

-- 4.  EMPLOYEES테이블에서 급여가 10000 이상 받는 직원 조회
SELECT FIRST_NAME || ' ' || LAST_NAME AS NAME
     , SALARY
  FROM EMPLOYEES
 WHERE SALARY >= 10000;

-- 5.  EMPLOYEES테이블에서 급여가 500만원 이하로 받는 직원 조회(현재 환율을 적용하여 조회)
SELECT FIRST_NAME || ' ' || LAST_NAME AS NAME
     , (SALARY * 1156) AS SALARY
  FROM EMPLOYEES
 WHERE SALARY * 1156 <= 5000000;

-- 6.  EMPLOYEES테이블에서 사원번호, 사원명, 직급, 입사일 조회(입사일은 xxxx년 xx월 xx일 형식)
SELECT EMPLOYEE_ID AS 사원번호
     , FIRST_NAME || ' ' || LAST_NAME AS 사원명
     , JOB_ID AS 직급
     , TO_CHAR(HIRE_DATE, 'yyyy') || '년 ' ||
       TO_CHAR(HIRE_DATE, 'mm') || '월 ' ||
       TO_CHAR(HIRE_DATE, 'dd') || '일' AS 입사일
     , TO_CHAR(HIRE_DATE, 'yyyy"년" mm"월" dd"일"') AS 입사일2
     , EXTRACT(YEAR FROM HIRE_DATE) || '년 ' ||
       EXTRACT(MONTH FROM HIRE_DATE) || '월 ' ||
       EXTRACT(DAY FROM HIRE_DATE) || '일' AS 입사일3
  FROM EMPLOYEES;

-- 7.  EMPLOYEES테이블에서 사번, 사원명, 급여, 연봉 조회(연봉은 급여*12)
-- 9999...숫자의 최대 길이만큼; 천 단위 콤마 찍기
SELECT EMPLOYEE_ID AS 사원번호
     , FIRST_NAME || ' ' || LAST_NAME AS 사원명
     , TO_CHAR(SALARY, '999,999,999') AS 급여
     , TO_CHAR((SALARY * 12), '999,999,999') AS 연봉
  FROM EMPLOYEES;

-- 8.  EMPLOYEES테이블에서 사번, 사원명, 급여, 연봉 조회(커미션이 있는 경우 연봉에 커미션 추가)
-- NVL(P1, P2) : NULL 로 되어 있는 컬럼의 값을 인자로 지정한 숫자/문자로 변경하여 반환
-- P1 : NULL 데이터를 처리할 컬럼명 혹은 값, P2 : NULL 값을 대체하고자 하는 값
SELECT EMPLOYEE_ID AS 사원번호
     , FIRST_NAME || ' ' || LAST_NAME AS 사원명
     , TO_CHAR(SALARY, '999,999,999') AS 급여
     , NVL(COMMISSION_PCT, 0) AS 커미션
     , TO_CHAR((SALARY * 12), '999,999,999') AS 연봉
     , TO_CHAR((SALARY * (1 + NVL(COMMISSION_PCT, 0)) * 12), '999,999,999') AS 커미션포함연봉
  FROM EMPLOYEES;

-- 9.  EMPLOYEES테이블에서 1(1 ~ 3월)분기에 입사한 직원의 정보 조회
SELECT FIRST_NAME || ' ' || LAST_NAME AS 사원명
     , TO_CHAR(HIRE_DATE, 'yyyy"년" mm"월" dd"일"') AS 입사일
  FROM EMPLOYEES
 WHERE TO_CHAR(HIRE_DATE, 'mm') <= 3;
-- WHERE EXTRACT(MONTH FROM HIRE_DATE) <= 3;

-- 10. EMPLOYEES테이블에서 90년도 이후에 입사한 직원 조회
SELECT FIRST_NAME || ' ' || LAST_NAME AS 사원명
     , TO_CHAR(HIRE_DATE, 'yyyy"년" mm"월" dd"일"') AS 입사일
  FROM EMPLOYEES
 WHERE TO_CHAR(HIRE_DATE, 'yyyy') >= 1990;
-- WHERE EXTRACT(YEAR FROM HIRE_DATE) >= 1990;

-- 11. EMPLOYEES테이블에서 입사일로부터 30년 이상 근무한 직원의 정보 조회
SELECT FIRST_NAME || ' ' || LAST_NAME AS 사원명
     , TO_CHAR(HIRE_DATE, 'yyyy"년" mm"월" dd"일"') AS 입사일
  FROM EMPLOYEES
 WHERE MONTHS_BETWEEN(SYSDATE, HIRE_DATE) / 12 >= 30;

SELECT TO_DATE('900101', 'yymmdd') FROM DUAL;
SELECT FIRST_NAME || ' ' || LAST_NAME AS 사원명
     , TO_CHAR(HIRE_DATE, 'yyyy"년" mm"월" dd"일"') AS 입사일
     , HIRE_DATE
     , TO_DATE('900101', 'yymmdd') -- 90년  2000년대의 90년도
     , TO_DATE('900101', 'rrmmdd') -- 00 ~ 49년 2000년대, 50 ~ 99년 1900년대
     , TO_CHAR(TO_DATE('900101', 'yymmdd'), 'yyyymmdd') -- 20900101
     , TO_CHAR(TO_DATE('900101', 'rrmmdd'), 'yyyymmdd') -- 19900101
  FROM EMPLOYEES;
 WHERE HIRE_DATE >= TO_DATE('900101', 'yymmdd'); -- 오류: YY 에서 90은 2000년대의 2090년을 의미