-- ORDER BY 절 : 조회 결과에 대해 정렬을 하기 위해 사용
-- 오름차순(ASC), 내림차순(DESC) 정렬을 할 수 있으며, 기본은 오름차순이다.
-- 여러 컬럼에 대해 정렬을 할 수 있다.
-- SELECT 절, FROM 절, WHERE 절 들보다 가장 마지막에 실행된다.

SELECT *
  FROM TB_STUDENT
 ORDER BY DEPARTMENT_NO; -- (ASC) 오름차순 기본

SELECT *
  FROM TB_STUDENT
 ORDER BY DEPARTMENT_NO DESC; -- DESC 내림차순

SELECT *
  FROM TB_STUDENT
 ORDER BY DEPARTMENT_NO, STUDENT_NAME;

SELECT *
  FROM TB_STUDENT
 ORDER BY DEPARTMENT_NO, STUDENT_NAME DESC;

SELECT *
  FROM TB_STUDENT
 ORDER BY DEPARTMENT_NO DESC, STUDENT_NAME;

-- 숫자는 컬럼명 위치
-- 2: DEPARTMENT_NO, 3: STUDENT_NAME
SELECT *
  FROM TB_STUDENT
 ORDER BY 2, 3 DESC;

-- ORDER BY 절에서는 별칭명을 컬럼명 대신 사용 가능
SELECT DEPARTMENT_NO AS "학과번호"
     , STUDENT_NAME AS "학생명"
     , STUDENT_ADDRESS AS "학생 주소"
  FROM TB_STUDENT
 ORDER BY 학과번호;

-- COACH_PROFESSOR_NO 컬럼 데이터들 중 NULL 값을 가진 행 먼저 출력
SELECT *
  FROM TB_STUDENT
 ORDER BY DEPARTMENT_NO, COACH_PROFESSOR_NO NULLS FIRST;

-- SUBSTR(STUDENT_SSN,1,6) : STUDENT_SSN 컬럼 데이터값(문자열) 중 1번째 자리부터 6개의 데이터요소들에 대해; 생년월일
-- RR 은 1900년대를 포함; 50년 기준으로 50년 이상이면 1900년대, 50년 미만이면 2000년대
SELECT *
  FROM TB_STUDENT
 ORDER BY TO_DATE(SUBSTR(STUDENT_SSN,1,6),'RRMMDD');



-- GROUP BY 절 : 동일한 컬럼값을 가지는 행 데이터에 대해 그룹화를 시켜 집계함수를 사용한 정보 조회를 위해 사용
-- SELECT 절에 명시한 컬럼에 대해 그룹화를 시킨다.
-- 집계함수 : COUNT(), MAX(), MIN(), SUM(), AVG(), ...
SELECT * FROM USER_COL_COMMENTS WHERE TABLE_NAME = 'TB_GRADE';
SELECT * FROM TB_GRADE ORDER BY TERM_NO, STUDENT_NO;

SELECT DEPARTMENT_NO
     -- , COUNT(DEPARTMENT_NO) AS 학과별인원
     , COUNT(*) AS 학과별인원
  FROM TB_STUDENT
GROUP BY DEPARTMENT_NO
ORDER BY 학과별인원;

SELECT DEPARTMENT_NO AS 학과번호
     , ABSENCE_YN AS 휴학유무
     , COUNT(*) AS 학과별인원
  FROM TB_STUDENT
 GROUP BY DEPARTMENT_NO, ABSENCE_YN
 ORDER BY 학과번호;

-- 학생별 학점 총점
SELECT STUDENT_NO AS 학생번호
     , SUM(POINT) AS 총점
  FROM TB_GRADE
 GROUP BY STUDENT_NO
 ORDER BY 학생번호;

-- 학기별 평균 점수
SELECT TERM_NO AS 학기번호
     , AVG(POINT) AS 평균
  FROM TB_GRADE
 GROUP BY TERM_NO
 ORDER BY 학기번호;

-- 학기별 최고 점수
SELECT TERM_NO AS 학기번호
     , MAX(POINT) AS 최고점수
  FROM TB_GRADE
 GROUP BY TERM_NO
 ORDER BY 학기번호;

-- 년도별 최고/최저 점수
SELECT SUBSTR(TERM_NO, 1, 4) AS 년도별
     , MAX(POINT) AS 최고점수
     , MIN(POINT) AS 최저점수
  FROM TB_GRADE
 GROUP BY SUBSTR(TERM_NO, 1, 4)
 ORDER BY 년도별;



-- EMPLOYEES 테이블에서 JOB_ID 별 인원 수를 파악하는 쿼리문을 만드시오.
SELECT JOB_ID
     , COUNT(*) AS "JOB_ID 별 인원수"
  FROM EMPLOYEES
 GROUP BY JOB_ID
 ORDER BY JOB_ID DESC;

-- EMPLOYEES 테이블에서 DEPARTMENT_ID 별 인원 수를 파악하는 쿼리문을 만드시오.
SELECT DEPARTMENT_ID
     , COUNT(*) AS "DEPARTMENT_ID 별 인원수"
  FROM EMPLOYEES
 GROUP BY DEPARTMENT_ID
 ORDER BY DEPARTMENT_ID DESC;

-- EMPLOYEES 테이블에서 DEPARTMENT_ID 별 SALARY 가 가장 높은 금액이 얼마인지 구하는 쿼리문을 만드시오.
SELECT DEPARTMENT_ID
     , COUNT(*) AS "DEPARTMENT_ID 별 인원수"
     , MAX(SALARY) AS "DEPARTMENT_ID 별 최고 급여"
  FROM EMPLOYEES
 GROUP BY DEPARTMENT_ID
 ORDER BY DEPARTMENT_ID;


SELECT * FROM EMPLOYEES;