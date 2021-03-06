-- 현재 접속한 계정의 권한으로 접근할 수 있는 모든 테이블 목록 조회
SELECT * FROM ALL_ALL_TABLES;
SELECT * FROM DBA_TABLES;
SELECT * FROM ALL_OBJECTS WHERE OBJECT_TYPE = 'TABLE';

-- 현재 접속한 계정이 소유하고 있는 모든 테이블 목록 조회
SELECT * FROM TABS;
SELECT * FROM USER_OBJECTS WHERE OBJECT_TYPE = 'TABLE';
SELECT * FROM USER_TABLES;

-- 테이블 코멘트(주석) 조회
SELECT * FROM USER_TAB_COMMENTS; -- 테이블 전체
SELECT * FROM ALL_TAB_COMMENTS WHERE TABLE_NAME = '테이블명'; -- 특정 테이블

-- 테이블명으로 컬럼 조회
SELECT * FROM USER_TAB_COLUMNS; -- 테이블 전체
SELECT * FROM COLS WHERE TABLE_NAME = 'COUNTRIES';
SELECT * FROM ALL_TAB_COLUMNS WHERE TABLE_NAME = 'COUNTRIES';

--  컬럼명으로 테이블 찾기
SELECT 
    TABLE_NAME, COLUMN_NAME 
FROM 
	ALL_TAB_COLUMNS 
WHERE COLUMN_NAME LIKE '%컬럼명%';

-- 전체 컬럼 코멘트 조회
SELECT * FROM USER_COL_COMMENTS;