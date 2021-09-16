SET SERVEROUTPUT ON;

BEGIN
    DBMS_OUTPUT.PUT_LINE('Hello PL/SQL');
END;
/

DECLARE
    ID NUMBER := 5;
    NAME VARCHAR2(10);
BEGIN
    ID := ID+1;
    NAME := 'LIGHT';
    DBMS_OUTPUT.PUT_LINE('번호: ' || ID);
    DBMS_OUTPUT.PUT_LINE('이름: ' || NAME);
END;
/

-- 사용자 입력(정수입력)
DECLARE
    INPUT_NUM NUMBER;
    VAL NUMBER;
BEGIN
    VAL := &INPUT_NUM;
    DBMS_OUTPUT.PUT_LINE('입력한 정수값 : ' || VAL);
END;
/

-- 선택문
DECLARE
    INPUT_NUM NUMBER;
    VAL NUMBER;
BEGIN
    VAL := &INPUT_NUM;
    IF(MOD(VAL,2)=0) THEN
        DBMS_OUTPUT.PUT_LINE('EVEN NUMBER');
    ELSE
        DBMS_OUTPUT.PUT_LINE('ODD NUMBER');
    END IF;
END;
/
DECLARE
    INPUT_NUM NUMBER;
    VAL NUMBER;
BEGIN
    VAL := &INPUT_NUM;
    IF (MOD(VAL,2)=0) THEN
        DBMS_OUTPUT.PUT_LINE('EVEN NUMBER');
    ELSIF (MOD(VAL,2)=1) THEN
        DBMS_OUTPUT.PUT_LINE('ODD NUMBER');
    END IF;
END;
/

-- 반복문
DECLARE
    INPUT_NUM NUMBER;
    VAL NUMBER;
BEGIN
    VAL := &INPUT_NUM;
    LOOP -- 무한 반복 가능
        DBMS_OUTPUT.PUT_LINE('반복문 입니다. : ' || VAL);
        VAL := VAL-1;
        IF VAL = 0 THEN EXIT;
        END IF;
    END LOOP;
END;
/
BEGIN
    FOR I IN 0..3 LOOP
        DBMS_OUTPUT.PUT_LINE('반복문 입니다. : ' || I);
    END LOOP;
END;
/
BEGIN
    FOR I IN REVERSE 0..3 LOOP -- REVERSE 역순
        DBMS_OUTPUT.PUT_LINE('반복문 입니다. : ' || I);
    END LOOP;
END;
/
DECLARE
    VAL NUMBER;
BEGIN
    VAL := 0;
    WHILE VAL<3 LOOP
        DBMS_OUTPUT.PUT_LINE('WHILE 반복문 입니다. : ' || VAL);
        VAL := VAL+1;
    END LOOP;
END;
/


-- SELECT : 단일행의 결과만 반환
-- INTO: DECLARE 에서 선언한 변수에 SELECT 조회 결과를 집어넣는다.
--       선언한 변수와 조회 컬럼의 순서와 자료형을 잘 맞춰라.
DECLARE
    FNAME EMPLOYEES.FIRST_NAME%TYPE; -- 자료형 및 자료형의 크기 등 참조
    LNAME EMPLOYEES.LAST_NAME%TYPE;
    SALARY EMPLOYEES.SALARY%TYPE;
BEGIN
    SELECT FIRST_NAME
         , LAST_NAME
         , SALARY
      INTO FNAME, LNAME, SALARY
      FROM EMPLOYEES
     WHERE EMPLOYEE_ID = 100;

    DBMS_OUTPUT.PUT_LINE('성 : ' || FNAME);
    DBMS_OUTPUT.PUT_LINE('이름 : ' || LNAME);
    DBMS_OUTPUT.PUT_LINE('급여액 : ' || SALARY);
END;
/
-- 테이블 전체를 참조하는 경우
DECLARE
    EMP EMPLOYEES%ROWTYPE;
BEGIN
    SELECT *
      INTO EMP
      FROM EMPLOYEES
     WHERE EMPLOYEE_ID = 100;

    DBMS_OUTPUT.PUT_LINE('성 : ' || EMP.LAST_NAME);
    DBMS_OUTPUT.PUT_LINE('이름 : ' || EMP.FIRST_NAME);
    DBMS_OUTPUT.PUT_LINE('급여액 : ' || EMP.SALARY);
END;
/

-- EXCEPTION 예외처리
-- NO_DATA_FOUND 에러 메시지
DECLARE
    EMP EMPLOYEES%ROWTYPE;
BEGIN
    SELECT *
      INTO EMP
      FROM EMPLOYEES
     WHERE EMPLOYEE_ID = 99;

    DBMS_OUTPUT.PUT_LINE('성 : ' || EMP.LAST_NAME);
    DBMS_OUTPUT.PUT_LINE('이름 : ' || EMP.FIRST_NAME);
    DBMS_OUTPUT.PUT_LINE('급여액 : ' || EMP.SALARY);
EXCEPTION
    WHEN NO_DATA_FOUND THEN
        DBMS_OUTPUT.PUT_LINE('해당 데이터가 존재하지 않습니다.');
END;
/
-- TOO_MANY_ROWS 에러 메시지
DECLARE
    EMP EMPLOYEES%ROWTYPE;
BEGIN
    SELECT *
      INTO EMP
      FROM EMPLOYEES
     WHERE SALARY > 10000;

    DBMS_OUTPUT.PUT_LINE('성 : ' || EMP.LAST_NAME);
    DBMS_OUTPUT.PUT_LINE('이름 : ' || EMP.FIRST_NAME);
    DBMS_OUTPUT.PUT_LINE('급여액 : ' || EMP.SALARY);
EXCEPTION
    WHEN NO_DATA_FOUND THEN
        DBMS_OUTPUT.PUT_LINE('해당 데이터가 존재하지 않습니다.');
    WHEN TOO_MANY_ROWS THEN
        DBMS_OUTPUT.PUT_LINE('너무 많은 행 데이터가 있습니다.');
END;
/


-- TB_STUDENT, TB_DEPARTMENT, ...
-- 학과번호를 입력하면 해당 학과의 이름, 카테고리, 개설여부, 최대인원, 실인원
-- 정보가 출력될 수 있도록 한다.

-- VIEW 생성
CREATE VIEW V_DEPT_INFO AS
    SELECT A.DEPARTMENT_NO AS 학과코드
         , A.DEPARTMENT_NAME AS 학과명
         , A.CATEGORY AS 분류
         , A.OPEN_YN AS 개설여부
         , A.CAPACITY AS 정원
         , COUNT(*) AS 현재인원
      FROM TB_DEPARTMENT A JOIN TB_STUDENT B
        ON A.DEPARTMENT_NO = B.DEPARTMENT_NO
     GROUP BY A.DEPARTMENT_NO, A.DEPARTMENT_NAME
            , A.CATEGORY, A.OPEN_YN, A.CAPACITY;

-- 사용자 정수 입력에 대한 단일행
DECLARE
    R V_DEPT_INFO%ROWTYPE;
    DEPT_CODE NUMBER;
BEGIN
    SELECT *
      INTO R
      FROM V_DEPT_INFO
     WHERE 학과코드 = TRIM(TO_CHAR(&DEPT_CODE, '000'));

    DBMS_OUTPUT.PUT_LINE(R.학과명 || ' | ' || R.분류 || ' | ' || R.개설여부 || ' | ' || R.정원  || ' | ' || R.현재인원);
EXCEPTION
    WHEN NO_DATA_FOUND THEN
        DBMS_OUTPUT.PUT_LINE('해당 데이터가 존재하지 않습니다.');
    WHEN TOO_MANY_ROWS THEN
        DBMS_OUTPUT.PUT_LINE('너무 많은 행 데이터가 있습니다.');
END;
/

-- 반복문 이용한 VIEW의 전체 행 출력
DECLARE
    R V_DEPT_INFO%ROWTYPE;
BEGIN
    FOR R IN (SELECT * FROM V_DEPT_INFO) LOOP
        DBMS_OUTPUT.PUT_LINE(R.학과명 || ' | ' || R.분류 || ' | ' || R.개설여부 || ' | ' || R.정원  || ' | ' || R.현재인원);
    END LOOP;
EXCEPTION
    WHEN TOO_MANY_ROWS THEN
        DBMS_OUTPUT.PUT_LINE('너무 많은 행 데이터가 있습니다.');
END;
/

-- PL/SQL 에서 테이블은 일종의 일차원 배열이라 생각해라.
-- 테이블은 크기에 제한이 없으며, 그 ROW의 수는 데이터가 들어옴에 따라 자동 증가한다.
-- BINARY_INTEGER 타입의 인덱스 번호로 순서가 정해진다.
-- 하나의 테이블에 한 개의 컬럼 데이터를 저장한다.
-- TYPE table_name IS TABLE OF datatype INDEX BY BINARY INTEGER; 선언
DECLARE
    -- NAME_ARRARY은 V_DEPT_INFO.학과명%TYPE 즉, VARCHAR 타입을 의미하고,
    -- ARR_NAME 은 그러한 NAME_ARRAY 타입을 가지는 변수이다.
    -- BINARY_INTEGER 타입의 인덱스 번호 시작이 0부터 임을 지정한다.
    TYPE NAME_ARRAY IS TABLE OF V_DEPT_INFO.학과명%TYPE INDEX BY BINARY_INTEGER;
    ARR_NAME NAME_ARRAY;
    IDX BINARY_INTEGER := 0;
BEGIN
    -- R 은 V_DEPT_INFO 뷰의 행을 하나씩 반복해서 담는다.
    -- IDX 는 1부터 시작하며, R.학과명을 저장하는 ARR_NAME 변수의 IDX 가 1씩 증가한다.
    FOR R IN (SELECT * FROM V_DEPT_INFO) LOOP
        IDX := IDX + 1;
        ARR_NAME(IDX) := R.학과명;
    END LOOP;

    -- I 는 ARR_NAME 에 저장한 R.학과명 데이터의 인덱스 번호
    -- 저장한 데이터 출력
    FOR I IN 1..IDX LOOP
        DBMS_OUTPUT.PUT_LINE(ARR_NAME(I) || ' ' || I);
    END LOOP;
EXCEPTION
    WHEN NO_DATA_FOUND THEN
        DBMS_OUTPUT.PUT_LINE('해당 데이터가 존재하지 않습니다.');
END;
/



-- 구구단을 출력하는 PL/SQL 작성
BEGIN
    FOR X IN 1..9 LOOP
        FOR Y IN 1..9 LOOP
            DBMS_OUTPUT.PUT(X || '*' || Y || ' = ' || X*Y || '    ');
            -- DBMS_OUTPUT은 메시지를 버퍼에 저장하고 버퍼로부터 메시지를 읽어오기 위한 인터페이스를 제공하는 패키지
            -- PUT 프로시저는 하나의 라인을 여러번에 걸쳐서 저장. EOL 문자가 첨부되지 않아 개행X, 버퍼비우기X
        END LOOP;
        DBMS_OUTPUT.PUT_LINE('');
        -- 32768byte, 버퍼에 저장되는 메시지의 마지막 라인 끝에 EOL 문자를 첨부한다. 개행O
    END LOOP;
END;
/

DECLARE
    X NUMBER;
    Y NUMBER;
BEGIN
    X:=1;
    WHILE X < 10 LOOP
        Y:=1;
        WHILE Y < 10 LOOP
            DBMS_OUTPUT.PUT(X||'*'||Y||' = '||X*Y||'    ');
            Y := Y+1;
        END LOOP;
        DBMS_OUTPUT.PUT_LINE('');
        X := X+1;
    END LOOP;
END;
/
-- 테이블 타입; 하나의 컬럼 데이터
DECLARE
    TYPE NUM_ARRY IS TABLE OF NUMBER INDEX BY BINARY_INTEGER;
    RESULTS NUM_ARRY;
    IDX BINARY_INTEGER := 1; -- BINARY_INTEGER 타입의 인덱스 번호가 1부터 시작
BEGIN
    FOR X IN 1..9 LOOP
        FOR Y IN 1..9 LOOP
            RESULTS(IDX) := X * Y;
            IDX := IDX + 1;
        END LOOP;
    END LOOP;
    FOR I IN 1..IDX-1 LOOP
        DBMS_OUTPUT.PUT_LINE(RESULTS(I));
    END LOOP;
END;
/


-- TB_PROFESSOR, TB_STUDENT 의 이름, 주민번호, 주소 를 출력하는 PL/SQL 작성
-- 주민번호의 경우 마지막 7자리에 대해 ******* 로 처리될 수 있도록 한다.
-- 사용자 입력으로 'HIDE' 단어 입력을 받으면 ******* 로 처리되게 한다.

CREATE VIEW V_STD_PROF_INFO AS
SELECT STUDENT_NAME AS NAME
     , STUDENT_SSN AS SSN
     , STUDENT_ADDRESS AS ADDR
  FROM TB_STUDENT
UNION ALL -- 중복상관없이 합집합
SELECT PROFESSOR_NAME AS NAME
     , PROFESSOR_SSN AS SSN
     , PROFESSOR_ADDRESS AS ADDR
  FROM TB_PROFESSOR;
SELECT * FROM V_STD_PROF_INFO;

DECLARE
    HIDDEN_YN   BOOLEAN;        -- 사용자 입력값이 'HIDE'인지 맞으면 TRUE,  틀리면 FALSE
    INPUT       VARCHAR2(10);   -- 사용자 입력값을 받을 변수
    INPUT_VAL   VARCHAR2(10);   -- 사용자 입력값 저장 변수
BEGIN
    INPUT_VAL := '&INPUT';
    IF INPUT_VAL = 'HIDE' THEN
        HIDDEN_YN := TRUE;
    ELSE
        HIDDEN_YN := FALSE;
    END IF;

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


-- EMPLOYEES 테이블에서 직원들의 급여와 직원이름을 출력할 때 커미션이 있는 지원은
-- 커미션을 포함하여 계산하여 출력 할 때 "(커미션 포함)" 이라는 내용과 같이
-- 출력되도록 PL/SQL 작성

CREATE VIEW V_CMS_EMP AS
SELECT CONCAT(FIRST_NAME, ' '||LAST_NAME) AS NAME
     , NVL2(COMMISSION_PCT,1+COMMISSION_PCT||' (커미션 포함)','0') AS COMMISSION_PCT
     , SALARY * (NVL(COMMISSION_PCT,0)+1) AS COMMISSION_SAL
  FROM EMPLOYEES
 ORDER BY 1;

DECLARE
    R V_CMS_EMP%ROWTYPE;
BEGIN
    FOR R IN (SELECT * FROM V_CMS_EMP) LOOP
        DBMS_OUTPUT.PUT_LINE(R.NAME||' | '||R.COMMISSION_PCT||' | '||R.COMMISSION_SAL);
    END LOOP;
EXCEPTION
    WHEN TOO_MANY_ROWS THEN
        DBMS_OUTPUT.PUT_LINE('너무 많은 행 데이터가 있습니다.');
END;