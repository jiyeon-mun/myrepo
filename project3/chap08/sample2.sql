CREATE OR REPLACE PROCEDURE PROC_EMPLOYEES IS
BEGIN
    FOR R IN (SELECT * FROM EMPLOYEES WHERE ROWNUM <= 3) LOOP
        DBMS_OUTPUT.PUT_LINE(R.EMPLOYEE_ID || ' | ' || CONCAT(R.FIRST_NAME,R.LAST_NAME));
    END LOOP;
END;
/
EXEC PROC_EMPLOYEES;

-- 매개변수 프로시저 생성
CREATE OR REPLACE
PROCEDURE PROC_EMPLOYEES(top_n IN NUMBER := 3) IS -- 매개변수 없이 프로시저 호출하는 경우 기본값 사용
BEGIN
    FOR R IN (SELECT * FROM EMPLOYEES WHERE ROWNUM <= top_n) LOOP
        DBMS_OUTPUT.PUT_LINE(R.EMPLOYEE_ID || ' | ' || CONCAT(R.FIRST_NAME,R.LAST_NAME));
    END LOOP;
END;
/
EXEC PROC_EMPLOYEES;
EXEC PROC_EMPLOYEES(5);

-- 매개변수 2개 프로시저 생성
CREATE OR REPLACE
PROCEDURE PROC_EMPLOYEES(top_n IN NUMBER := 3, job IN VARCHAR2 := '') IS
BEGIN
    FOR R IN (SELECT * FROM (SELECT *
                               FROM EMPLOYEES
                              WHERE JOB_ID LIKE '%' || job || '%')
                      WHERE ROWNUM <= top_n) LOOP
        DBMS_OUTPUT.PUT_LINE(R.EMPLOYEE_ID || ' | ' || CONCAT(R.FIRST_NAME, R.LAST_NAME));
    END LOOP;
END;
/
EXEC PROC_EMPLOYEES;
EXEC PROC_EMPLOYEES(5);
EXEC PROC_EMPLOYEES(5, 'IT');

-- 생성된 프로시저 텍스트로 출력하기
SELECT * FROM USER_SOURCE WHERE NAME = 'PROC_EMPLOYEES';


CREATE OR REPLACE
PROCEDURE PROC_STD_PROF_INFO(hidden IN BOOLEAN := TRUE) IS -- 기본값 TRUE
    HIDDEN_YN   BOOLEAN;
BEGIN
    HIDDEN_YN := hidden;
    FOR R IN (SELECT * FROM V_STD_PROF_INFO) LOOP
        DBMS_OUTPUT.PUT(R.NAME || ' | ');

        IF HIDDEN_YN THEN -- TRUE
            DBMS_OUTPUT.PUT(SUBSTR(R.SSN, 1, 8) || '******' || ' | ');
        ELSE -- FALSE
            DBMS_OUTPUT.PUT(R.SSN || ' | ');
        END IF;

        DBMS_OUTPUT.PUT(R.ADDR);
        DBMS_OUTPUT.PUT_LINE('');
    END LOOP;
END;
/
EXEC PROC_STD_PROF_INFO;
EXEC PROC_STD_PROF_INFO(FALSE);


-- 지역변수 top_n IN : 매개변수를 받아오겠다
-- 지역변수 total OUT : 매개변수를 보내주겠다 (RETURN 역할); total 이라는 변수 공간에 값을 보내준다.
CREATE OR REPLACE
PROCEDURE PROC_EMPLOYEES(top_n IN NUMBER := 3, total OUT NUMBER) IS
BEGIN
    total := 0;
    FOR R IN (SELECT * FROM EMPLOYEES WHERE ROWNUM <= top_n) LOOP
        DBMS_OUTPUT.PUT_LINE(R.EMPLOYEE_ID || ' | ' || CONCAT(R.FIRST_NAME,R.LAST_NAME));
        total := total + R.SALARY;
    END LOOP;
END;
/

-- 전역 변수 ret_val는 구문 내 선언된 지역변수이자 OUT 매개변수인 total의 값을 받는다.
VARIABLE ret_val NUMBER;
-- 전역 변수 앞에 콜론(:) 필수; (콜론(:)은 전역변수를 바인드해라; 전역변수 필수로 존재해야 한다.)
EXEC PROC_EMPLOYEES(5, :ret_val);
PRINT ret_val; -- OUT 변수 ret_val에 저장된 값 출력

DECLARE
    ret_val NUMBER; -- 지역변수
BEGIN
    -- PROC_EMPLOYEES(5, :ret_val); -- VARIABLE 선언된 전역변수
    PROC_EMPLOYEES(5, ret_val);

    DBMS_OUTPUT.PUT_LINE(ret_val); -- DECLARE 선언된 지역변수
    -- DBMS_OUTPUT.PUT_LINE(:ret_val); -- VARIABLE 선언된 전역변수
END;
/