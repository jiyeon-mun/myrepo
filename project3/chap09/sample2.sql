/*
    1. 재고관리를 위한 테이블 생성
        테이블 명 : PRODUCTS
        컬럼명  데이터타입      제약조건        비고
           PID  VARCHAR2(6)     Primary Key     문자와 숫자의 조합으로 만들어진 코드를 사용한다.
         PNAME  VARCHAR2(30)    NOT NULL        제품 이름
        AMOUNT  NUMBER          NOT NULL        제품의 단가
           CNT  NUMBER          NOT NULL        제품의 수량

        테이블 명 : PROD_INOUT
        컬럼명  데이터타입      제약조건        비고
            ID  NUMBER          Primary Key     제품 입고 출고내역을 식별하기 위한 번호, 자동증가 기능을 활용한다.
        IN_OUT  CHAR(1)         CHECK           I:입고, O:출고 임을 구분하는 컬럼
           PID  VARCHAR2(6)     Foreign Key     PRODUCTS 테이블을 참조하는 외래키로 입출고된 제품을 구분한다.
        AMOUNT  NUMBER          NOT NULL        입출고 시점의 제품 단가
           CNT  NUMBER          NOT NULL        입출고된 제품의 수량, DEFAULT(1)
         PRICE  NUMBER          NOT NULL        입출고 시점의 제품 전체 금액(단가 x 수량)
                                                입고 제품에는 10% 할인된 금액으로 기록되어야 한다.
                                                출고 제품에는 10% 부가세가 포함된 금액으로 기록되어야 한다.
                                                소수점은 절삭한다.
    INOUT_DATE  DATE                            입출고 날짜, DEFAULT(SYSDATE)
*/
CREATE TABLE PRODUCTS(
      PID     VARCHAR2(6)
    , PNAME   VARCHAR2(30)
    , AMOUNT  NUMBER
    , CNT     NUMBER
);
COMMENT ON COLUMN PRODUCTS.PID IS '문자와 숫자의 조합으로 만들어진 코드 사용';
COMMENT ON COLUMN PRODUCTS.PNAME IS '제품 이름';
COMMENT ON COLUMN PRODUCTS.AMOUNT IS '제품 단가';
COMMENT ON COLUMN PRODUCTS.CNT IS '제품 수량';
ALTER TABLE PRODUCTS ADD CONSTRAINT PROD_PID_PK PRIMARY KEY(PID);
ALTER TABLE PRODUCTS MODIFY PNAME CONSTRAINT PROD_PNAME_NN NOT NULL;
ALTER TABLE PRODUCTS MODIFY AMOUNT CONSTRAINT PROD_AMOUNT_NN NOT NULL;
ALTER TABLE PRODUCTS MODIFY CNT CONSTRAINT PROD_CNT_NN NOT NULL;

DROP TABLE PROD_INOUT;
CREATE TABLE PROD_INOUT(
      ID            NUMBER
    , IN_OUT        CHAR(1)
    , PID           VARCHAR2(6)
    , AMOUNT        NUMBER
    , CNT           NUMBER      DEFAULT(1)
    , PRICE         NUMBER
    , INOUT_DATE    DATE        DEFAULT(SYSDATE)
);
ALTER TABLE PROD_INOUT ADD CONSTRAINT PROD_INOUT_ID_PK PRIMARY KEY(ID);
ALTER TABLE PROD_INOUT ADD CONSTRAINT PROD_INOUT_IN_OUT CHECK(IN_OUT IN ('I','O'));
ALTER TABLE PROD_INOUT ADD CONSTRAINT PROD_INOUT_PID_FK FOREIGN KEY(PID) REFERENCES PRODUCTS(PID);
ALTER TABLE PROD_INOUT MODIFY AMOUNT CONSTRAINT PROD_INOUT_AMOUNT_NN NOT NULL;
ALTER TABLE PROD_INOUT MODIFY CNT CONSTRAINT PROD_INOUT_CNT_NN NOT NULL;
ALTER TABLE PROD_INOUT MODIFY PRICE CONSTRAINT PROD_INOUT_PRICE_NN NOT NULL;


/*
    2. 1번에서 만든 테이블의 기본 데이터를 추가한다.
        - PRODUCTS 테이블에는 다음의 데이터를 추가한다.
            PID:A00001  PNAME:투명박스       AMOUNT:15,000   CNT:10
            PID:A00002  PNAME:텀블러         AMOUNT:10,000   CNT:15
            PID:A00003  PNAME:마스크(10개입) AMOUNT:5,000    CNT:20
            PID:A00004  PNAME:투명테이프     AMOUNT:1,000    CNT:30
            PID:A00005  PNAME:종이컵(355ml)  AMOUNT:2,000    CNT:40

        - PROD_INOUT과 PRODUCTS 테이블에는 다음 설명에 맞게 데이터가 추가 및 변경될 수 있게 한다.
            투명박스 2개를 2021년 01월 02일에 출고하였다.
            텀블러 1개를 2021년 01월 03일에 출고하였다.
            마스크 10개를 2021년 01월 05일에 출고하였다.
            종이컵 5개를 2021년 01월 12일에 출고하였다.
            마스크 20개를 2021년 01월 15일에 입고하였다.
            투명테이프 2개를 2021년 01월 17일에 출고하였다.
            종이컵 10개를 2021년 01월 21일에 출고하였다.
            투명박스 7개를 2021년 01월 25일에 입고하였다.
*/
INSERT INTO PRODUCTS VALUES('A00001', '투명박스', 15000, 10);
INSERT INTO PRODUCTS VALUES('A00002', '텀블러', 10000, 15);
INSERT INTO PRODUCTS VALUES('A00003', '마스크(10개입)', 5000, 20);
INSERT INTO PRODUCTS VALUES('A00004', '투명테이프', 1000, 30);
INSERT INTO PRODUCTS VALUES('A00005', '종이컵(355ml)', 2000, 40);

DROP SEQUENCE PROD_INOUT_SEQ;
CREATE SEQUENCE PROD_INOUT_SEQ;
INSERT INTO PROD_INOUT VALUES(PROD_INOUT_SEQ.NEXTVAL, 'O'
                            , (SELECT PID FROM PRODUCTS WHERE PNAME = '투명박스')
                            , (SELECT AMOUNT FROM PRODUCTS WHERE PNAME = '투명박스')
                            , 2, 0, TO_DATE('20210102', 'yyyymmdd'));
INSERT INTO PROD_INOUT VALUES(PROD_INOUT_SEQ.NEXTVAL, 'O'
                            , (SELECT PID FROM PRODUCTS WHERE PNAME = '텀블러')
                            , (SELECT AMOUNT FROM PRODUCTS WHERE PNAME = '텀블러')
                            , 1, 0, TO_DATE('20210103', 'yyyymmdd'));
INSERT INTO PROD_INOUT VALUES(PROD_INOUT_SEQ.NEXTVAL, 'O'
                            , (SELECT PID FROM PRODUCTS WHERE PNAME = '마스크(10개입)')
                            , (SELECT AMOUNT FROM PRODUCTS WHERE PNAME = '마스크(10개입)')
                            , 10, 0, TO_DATE('20210105', 'yyyymmdd'));
INSERT INTO PROD_INOUT VALUES(PROD_INOUT_SEQ.NEXTVAL, 'O'
                            , (SELECT PID FROM PRODUCTS WHERE PNAME = '종이컵(355ml)')
                            , (SELECT AMOUNT FROM PRODUCTS WHERE PNAME = '종이컵(355ml)')
                            , 5, 0, TO_DATE('20210112', 'yyyymmdd'));
INSERT INTO PROD_INOUT VALUES(PROD_INOUT_SEQ.NEXTVAL, 'I'
                            , (SELECT PID FROM PRODUCTS WHERE PNAME = '마스크(10개입)')
                            , (SELECT AMOUNT FROM PRODUCTS WHERE PNAME = '마스크(10개입)')
                            , 20, 0, TO_DATE('20210115', 'yyyymmdd'));
INSERT INTO PROD_INOUT VALUES(PROD_INOUT_SEQ.NEXTVAL, 'O'
                            , (SELECT PID FROM PRODUCTS WHERE PNAME = '투명테이프')
                            , (SELECT AMOUNT FROM PRODUCTS WHERE PNAME = '투명테이프')
                            , 2, 0, TO_DATE('20210117', 'yyyymmdd'));
INSERT INTO PROD_INOUT VALUES(PROD_INOUT_SEQ.NEXTVAL, 'O'
                            , (SELECT PID FROM PRODUCTS WHERE PNAME = '종이컵(355ml)')
                            , (SELECT AMOUNT FROM PRODUCTS WHERE PNAME = '종이컵(355ml)')
                            , 10, 0, TO_DATE('20210121', 'yyyymmdd'));
INSERT INTO PROD_INOUT VALUES(PROD_INOUT_SEQ.NEXTVAL, 'I'
                            , (SELECT PID FROM PRODUCTS WHERE PNAME = '투명박스')
                            , (SELECT AMOUNT FROM PRODUCTS WHERE PNAME = '투명박스')
                            , 7, 0, TO_DATE('20210125', 'yyyymmdd'));

-- UPDATE 방법1
UPDATE PROD_INOUT
   SET PRICE = (AMOUNT * CNT) - FLOOR((AMOUNT * CNT) * 0.1)
 WHERE IN_OUT = 'I';
UPDATE PROD_INOUT
   SET PRICE = (AMOUNT * CNT) + FLOOR((AMOUNT * CNT) * 0.1)
 WHERE IN_OUT = 'O';

-- UPDATE방법2
UPDATE PROD_INOUT
   SET PRICE = (CASE WHEN IN_OUT = 'I' THEN
                         (AMOUNT * CNT) - FLOOR((AMOUNT * CNT) * 0.1)
                     WHEN IN_OUT = 'O' THEN
                         (AMOUNT * CNT) + FLOOR((AMOUNT * CNT) * 0.1)
                 END);

SELECT * FROM PROD_INOUT;


/*
       3. 1월 1달간 출고 내역을 조회하시오.
        제품코드    제품명      단가        수량        금액
        A00001      투명박스    15,000      2           33,000
        A00002      텀블러      10,000      1           11,000
        A00003      마스크      5,000       10          55,000
        ....
*/
SELECT A.PID AS 제품코드
     , A.PNAME AS 제품명
     , A.AMOUNT AS 단가
     , SUM(B.CNT) AS 수량
     , SUM(B.PRICE) AS 금액
  FROM PRODUCTS A JOIN PROD_INOUT B
    ON A.PID = B.PID
 WHERE IN_OUT = 'O'
   AND TO_CHAR(INOUT_DATE,'YYYYMM') = '202101'
 GROUP BY A.PID, A.PNAME, A.AMOUNT
 ORDER BY 1;


/*
    4. 1월 1달간의 입/출고 내역을 다음과 같이 나오도록 조회하시오.
        제품코드    제품명      입고량      출고량
        A00001      투명박스    7           2
        A00002      텀블러      0           1
        A00003      마스크      20          10
        총합                    xx          xx
*/
SELECT DECODE(A.PID,NULL,'총합',A.PID) AS 제품코드
     , A.PNAME AS 제품명
     , SUM(DECODE(IN_OUT,'I',B.CNT,0)) AS 입고량
     , SUM(DECODE(IN_OUT,'O',B.CNT,0))  AS 출고량
  FROM PRODUCTS A JOIN PROD_INOUT B
    ON A.PID = B.PID
 WHERE TO_CHAR(INOUT_DATE,'YYYYMM') = '202101'
 GROUP BY A.PID, PNAME
UNION
SELECT '총합' AS 제품코드
     , NULL AS 제품명
     , SUM(DECODE(IN_OUT,'I',B.CNT,0)) AS 입고량
     , SUM(DECODE(IN_OUT,'O',B.CNT,0))  AS 출고량
  FROM PRODUCTS A JOIN PROD_INOUT B
    ON A.PID = B.PID
 WHERE TO_CHAR(INOUT_DATE,'YYYYMM') = '202101';



/*
    5. 3번, 4번 조회 쿼리를 VIEW 로 만들어본다.
*/
CREATE OR REPLACE VIEW V_TYPE_BY_PROD_OUT
AS
SELECT EXTRACT(YEAR FROM INOUT_DATE) AS Y
     , EXTRACT(MONTH FROM INOUT_DATE) AS M
     , A.PID AS 제품코드
     , A.PNAME AS 제품명
     , A.AMOUNT AS 단가
     , SUM(B.CNT) AS 수량
     , TO_CHAR(SUM(B.PRICE),'999,999,999') AS 금액
  FROM PRODUCTS A JOIN PROD_INOUT B
    ON A.PID = B.PID
 WHERE IN_OUT = 'O'
 GROUP BY A.PID, A.PNAME, A.AMOUNT, EXTRACT(YEAR FROM INOUT_DATE), EXTRACT(MONTH FROM INOUT_DATE)
 ORDER BY 1;

CREATE OR REPLACE VIEW V_TYPE_BY_PROD_IN
AS
SELECT EXTRACT(YEAR FROM INOUT_DATE) AS Y
     , EXTRACT(MONTH FROM INOUT_DATE) AS M
     , A.PID AS 제품코드
     , A.PNAME AS 제품명
     , A.AMOUNT AS 단가
     , SUM(B.CNT) AS 수량
     , TO_CHAR(SUM(B.PRICE),'999,999,999') AS 금액
  FROM PRODUCTS A JOIN PROD_INOUT B
    ON A.PID = B.PID
 WHERE IN_OUT = 'I'
 GROUP BY A.PID, A.PNAME, A.AMOUNT, EXTRACT(YEAR FROM INOUT_DATE), EXTRACT(MONTH FROM INOUT_DATE)
 ORDER BY 1;

SELECT * FROM V_TYPE_BY_PROD_IN WHERE Y = 2021 AND M = 1;
SELECT * FROM V_TYPE_BY_PROD_OUT WHERE Y = 2021 AND M = 1;


CREATE OR REPLACE VIEW V_TYPE_BY_PRODUCTS_INOUT
AS
SELECT EXTRACT(YEAR FROM INOUT_DATE) AS Y
     , EXTRACT(MONTH FROM INOUT_DATE) AS M
     , DECODE(A.PID,NULL,'총합',A.PID) AS 제품코드
     , A.PNAME AS 제품명
     , SUM(DECODE(IN_OUT,'I',B.CNT,0)) AS 입고량
     , SUM(DECODE(IN_OUT,'O',B.CNT,0))  AS 출고량
  FROM PRODUCTS A JOIN PROD_INOUT B
    ON A.PID = B.PID
 GROUP BY EXTRACT(YEAR FROM INOUT_DATE), EXTRACT(MONTH FROM INOUT_DATE), A.PID, PNAME
UNION
SELECT EXTRACT(YEAR FROM INOUT_DATE) AS Y
     , EXTRACT(MONTH FROM INOUT_DATE) AS M
     , '총합' AS 제품코드
     , NULL AS 제품명
     , SUM(DECODE(IN_OUT,'I',B.CNT,0)) AS 입고량
     , SUM(DECODE(IN_OUT,'O',B.CNT,0))  AS 출고량
  FROM PRODUCTS A JOIN PROD_INOUT B
    ON A.PID = B.PID
 GROUP BY EXTRACT(YEAR FROM INOUT_DATE), EXTRACT(MONTH FROM INOUT_DATE);

SELECT * FROM V_TYPE_BY_PRODUCTS_INOUT WHERE Y = 2021 AND M = 1;


/*
    6. 5번에서 생성한 VIEW 를 프로시져로 만들어서 월별 또는 년도별로도 조회할 수 있게 만들어본다.
*/
CREATE OR REPLACE PROCEDURE PROC_TYPE_BY_PRODUCTS(I_TYPE IN CHAR, I_YEAR IN NUMBER, I_MONTH IN NUMBER)
IS
    TYPE_ERROR EXCEPTION;
BEGIN
    IF I_TYPE IN ('i', 'I', 'in', 'IN') THEN
        FOR REC IN (SELECT 제품명,단가,수량,금액 FROM V_TYPE_BY_PROD_IN WHERE Y = I_YEAR AND M = I_MONTH) LOOP
            DBMS_OUTPUT.PUT_LINE(REC.제품명||'|'||REC.단가||'|'||REC.수량||'|'||REC.금액);
        END LOOP;
    ELSIF I_TYPE IN ('o', 'O', 'out', 'OUT') THEN
        FOR REC IN (SELECT 제품명,단가,수량,금액 FROM V_TYPE_BY_PROD_OUT WHERE Y = I_YEAR AND M = I_MONTH) LOOP
            DBMS_OUTPUT.PUT_LINE(REC.제품명||'|'||REC.단가||'|'||REC.수량||'|'||REC.금액);
        END LOOP;
    ELSE
        RAISE TYPE_ERROR;
    END IF;

EXCEPTION
    WHEN TYPE_ERROR THEN
        DBMS_OUTPUT.PUT_LINE('타입은 반드시 i, o, in, out 중 하나를 사용해야 합니다.');
END;
/
EXEC PROC_TYPE_BY_ACCOUNT('OUT', 2021, 1);


/*
    7. 제품을 출고할 때 PRODUCTS 에 기록된 수량도 같이 반영이 될 수 있도록 프로시저를 만들어 동작시킨다.
       단 수량이 부족하면 출고 작업이 이루어지지 않게 ROLLBACK 을 동작시키는 것으로 한다.
*/
CREATE OR REPLACE PROCEDURE PROC_PROD_OUT(i_pid IN VARCHAR2, i_pname IN VARCHAR2, i_cnt NUMBER)
IS
    var_count   NUMBER; -- PRODUCTS 테이블 제품의 수량; CNT
    var_amount  NUMBER; -- PRODUCTS 테이블 입출고 시점의 제품 단가; AMOUNT
    var_price   NUMBER; -- PRODUCTS 테이블 입출고 시점의 제품 전체 금액(단가 x 수량); PRICE
    is_exists   NUMBER; -- i_pid, i_pname 가 PRODUCTS 테이블의 PID, PNAME 과 동일한 경우 1, 아니면 0
    no_data     EXCEPTION; -- 프로시저 호출 시 제품명 또는 제품코드가 올바르지 않을 경우 예외처리
    count_negative  EXCEPTION; -- 재고 출고 후 PRODUCTS 테이블 각 제품 CNT 가 0 보다 작을 경우 예외처리
BEGIN
    SELECT CASE WHEN EXISTS(SELECT * FROM PRODUCTS WHERE PID = i_pid AND PNAME = i_pname) THEN 1
                ELSE 0 END
      INTO is_exists FROM DUAL;

    IF is_exists = 1 THEN
        SELECT CNT, AMOUNT INTO var_count, var_amount FROM PRODUCTS
         WHERE PID = i_pid AND PNAME = i_pname;
    ELSE
        RAISE no_data;
    END IF;

    var_price := (var_amount * i_cnt) + FLOOR(var_amount * i_cnt * 0.1);
    INSERT INTO PROD_INOUT VALUES(PROD_INOUT_SEQ.NEXTVAL, 'O', i_pid, var_amount, i_cnt, var_price, SYSDATE);
    UPDATE PRODUCTS SET CNT = CNT - i_cnt WHERE PID = i_pid AND PNAME = i_pname;
    DBMS_OUTPUT.PUT_LINE(i_pname || ' 제품을 ' || i_cnt || ' 개 출고 하였습니다.');

    -- 출고 후 PRODUCTS 테이블의 각 제품의 재고 CNT 를 var_count 에 저장한다.
    SELECT CNT INTO var_count FROM PRODUCTS
     WHERE PID = i_pid AND PNAME = i_pname;
    -- 이 때 var_count 수량이 0보다 작을 경우(수량 부족의 경우) count_negative 오류 발생
    IF var_count < 0 THEN RAISE count_negative; END IF;

EXCEPTION
    WHEN no_data THEN
        DBMS_OUTPUT.PUT_LINE('제품명 또는 제품코드가 올바르지 않습니다.');
    WHEN count_negative THEN
        DBMS_OUTPUT.PUT_LINE('재고가 마이너스가 되면 안됩니다. 다시 롤백합니다.');
        ROLLBACK;
END;
/

CREATE OR REPLACE PROCEDURE PROC_PROD_OUT(I_PID IN VARCHAR2, I_PNAME IN VARCHAR2, I_CNT IN NUMBER)
IS
    VAR_COUNT  NUMBER;  VAR_AMOUNT NUMBER;
    VAR_PRICE  NUMBER;
    IS_EXISTS  NUMBER;
    NO_DATA    EXCEPTION;
BEGIN
    -- ORACLE 에서 EXISTS(서브쿼리) 는 서브쿼리 결과가 한 건이라도 존재하면 TRUE, 없으면 FALSE 를 리턴한다.
    -- WHERE 문에서 조건으로 / CASE 문에서 조건으로 사용됨.
    SELECT CASE WHEN EXISTS(SELECT * FROM PRODUCTS WHERE PID = I_PID AND PNAME = I_PNAME) THEN 1
                ELSE 0
           END -- CASE 문의 END
      INTO IS_EXISTS
      FROM DUAL;

    IF IS_EXISTS = 1 THEN
        SELECT CNT, AMOUNT
          INTO VAR_COUNT, VAR_AMOUNT
          FROM PRODUCTS
         WHERE PID = I_PID AND PNAME = I_PNAME;
    ELSE
        RAISE NO_DATA;
    END IF;

    -- 제품코드, 제품명, 출고수량 매개변수로 갖는 프로시저를 호출하고, 조건에 맞는다면
    -- PRODUCTS 테이블에서 CNT, AMOUNT의 값을 받아와서 VAR_COUNT, VAR_AMOUNT 에 저장한다.
    -- VAR_CNT, VAR_AMOUNT 를 이용해 VAR_PRICE 를 구한다.
    -- PROD_INOUT 테이블 컬럼들 순서 및 데이터 형식에 맞게 데이터 삽입하고 (제품출고로 인한 데이터 변경작업)
    -- PRODUCTS 테이블의 CNT 에서 출고수량(I_CNT)만큼 뺀다. (제품출고로 인한 데이터 변경작업)
    IF VAR_COUNT >= I_CNT THEN
        VAR_PRICE := FLOOR((VAR_AMOUNT * I_CNT) * 1.1); -- FLOOR() 소수점 버림 함수
        INSERT INTO PROD_INOUT VALUES(PROD_INOUT_SEQ.NEXTVAL, 'O', I_PID, VAR_AMOUNT, I_CNT, VAR_PRICE, SYSDATE);
        UPDATE PRODUCTS SET CNT = CNT - I_CNT WHERE PID = I_PID AND PNAME = I_PNAME;
        DBMS_OUTPUT.PUT_LINE(I_PNAME || ' 제품을' || I_CNT || '개 출고 하였습니다.');
    ELSE
        DBMS_OUTPUT.PUT_LINE('수량이 부족합니다.');
    END IF;

EXCEPTION
    WHEN NO_DATA THEN
        DBMS_OUTPUT.PUT_LINE('제품명 또는 제품코드가 올바르지 않습니다.');
END;
/

-- 생성한 프로시저 매개변수 맞춰서 호출한다.
-- 호출한 프로시저들의 매개변수가 조건에 맞는다면 위 구문에서 출고작업이 이루어진다.
EXEC PROC_PROD_OUT('A00001','투명박스',3);
EXEC PROC_PROD_OUT('A00002','텀블러',100);
EXEC PROC_PROD_OUT('A00003','마스크(20개입)',10);
EXEC PROC_PROD_OUT('A00005','종이컵(355ml)', 100);
-- 출고작업 결과 확인
SELECT * FROM PROD_INOUT; -- 출고 작업이 이루어질 때마다 새로운 ROW 가 생성됨.
SELECT * FROM PRODUCTS; -- 각 제품의 CNT 에서 출고수량 I_CNT 만큼 제품수량이 빠진다.


/*
    8. 제품 출고 단가는 PRODUCTS 테이블의 금액을 기준으로 사용하지만 입고의 경우 별도의 입고 단가액을 작성하면
       PRODUCTS 테이블의 금액이 변경되게 할 것이다. 그리고 기존에 존재하지 않은 제품을 입고하는 경우에도 자동
       적으로 PRODUCT 테이블에 새로운 제품 정보가 저장되도록 할 것이다.
       위에서 설명하는 내용대로 동작할 수 있는 프로서저를 만들어 제고관리가 이루어 질 수 있도록 하시오.
       PROC_PROD_IN('제품코드', '제품명', 수량, 단가) 형식으로 사용
            A. 기존에 존재하는 제품코드, 제품명의 경우 해당 제품에 대한 수량을 입력한 수량만큼 증가시킨다.
            B. 기존에 존재하는 제품코드, 제품명이나 단가가 입력된 단가와 다른 경우 입력된 단가로 수정한다.
            C. 기존에 존재하지 않는 제품코드인 경우 새로운 제품으로 추가한다.
            D. 기존에 존재하는 제품코드이나 제품명이 다른 경우 어떠한 작업도 수행하지 않는다.
*/