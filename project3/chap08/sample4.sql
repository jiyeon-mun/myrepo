/*
    아직 부서 배정을 받지 못한 직원을 찾아서 적절한 부서로 배정받을 수 있는 프로시저를 생성한다.
        - 부서는 없지만 담당 관리직원이 있는 경우 관리직원의 부서로 배정한다.
        - 담당 관리직원도 없는 경우 직무코드에 맞는 부서로 배정한다.
        - 작업이 완료 된 후에는 배정이 완료된 인원 수를 알 수 있도록 메시지를 출력한다.
*/
CREATE OR REPLACE PROCEDURE 부서배정(count OUT NUMBER) -- 로직을 따라 부서배정을 완료한 직원수를 내보낸다.
IS
    DEPT_CODE   EMPLOYEES.DEPARTMENT_ID%TYPE; -- 부서코드
    CNT         NUMBER := 0; -- 로직을 따라 부서배정을 완료한 직원수(부서 배정 카운트 횟수)
    no_data     EXCEPTION; -- 사용자 정의 EXCEPTION
BEGIN
    FOR rec IN (SELECT * FROM EMPLOYEES WHERE DEPARTMENT_ID IS NULL) LOOP -- 부서 배정을 받지 못한 직원 수만큼 반복
        IF rec.MANAGER_ID IS NOT NULL THEN  -- 담당 관리직원이 있어 관리직원의 부서로 배정
            SELECT DEPARTMENT_ID
              INTO DEPT_CODE
              FROM EMPLOYEES
             WHERE EMPLOYEE_ID = rec.MANAGER_ID;
        ELSE                                -- 담당 관리직원이 없다면 직무코드에 맞는 부서로 배정
         -- 부서가 정해지지 않은 사원의 직무코드와 동일한 직무코드에 대해서 부서코드가 반드시 존재해야 하며
         -- 결과로 보여지는 부서코드 중 중복을 제거한다.
            SELECT DISTINCT DEPARTMENT_ID
              INTO DEPT_CODE
              FROM EMPLOYEES
             WHERE JOB_ID = rec.JOB_ID
               AND DEPARTMENT_ID IS NOT NULL;
        END IF;

        IF DEPT_CODE IS NULL THEN
            RAISE no_data; -- 강제로 에러 발생; EXCEPTION에서 별도의 처리
        ELSE -- 부서 배정; 횟수 카운트
            UPDATE EMPLOYEES
               SET DEPARTMENT_ID = DEPT_CODE
             WHERE EMPLOYEE_ID = rec.EMPLOYEE_ID;

            CNT := CNT + 1;
            DEPT_CODE := NULL; -- 부서 배정 후 부서코드 비우기; 반복을 위해서
        END IF;
    END LOOP;

    count := CNT;
    COMMIT; -- ROLLBACK 후 에러없이 잘 동작한다면 COMMIT 실행 -> 부서배정이 이루어진다.
    -- ROLLBACK;
EXCEPTION
    WHEN no_data THEN
        DBMS_OUTPUT.PUT_LINE('작업 중 문제가 발생하여 롤백하였습니다.');
        ROLLBACK; -- 제일 최근에 COMMIT 했던 상태로 돌아감
END;
/
VARIABLE CNT NUMBER; -- 로직을 따라 몇 번의 부서배정이 이루어졌는지 그 횟수 결과 출력
EXEC 부서배정(:CNT);
PRINT CNT;
-- COMMIT 완료 후엔 no rows selected
SELECT * FROM EMPLOYEES WHERE DEPARTMENT_ID IS NULL;



/*
    KOR_DATE 함수를 만들어서 모든 날짜관련 데이터는 xxxx년 xx월 xx일로 변환될 수 있는
    함수를 생성한다.
*/
CREATE OR REPLACE FUNCTION KOR_DATE(D DATE) RETURN VARCHAR
IS
BEGIN
    RETURN TO_CHAR(D,'YYYY"년" MM"월" DD"일"');
END;
/
SELECT KOR_DATE(HIRE_DATE) FROM EMPLOYEES;