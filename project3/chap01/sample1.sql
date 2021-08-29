-- 주석
/*
멀티 라인 주석

ctrl + e : 커서가 위치한 문장 실행
ctrl + r : 전체 문장 실행
*/

-- 계정 생성(ADMIN 외 추가 생성)
CREATE USER user1 IDENTIFIED BY KHpass1234567890;

-- 계정 확인
SELECT * FROM ALL_USERS WHERE USERNAME = 'USER1';

/* 계정 암호 수정
ALTER USER user1 IDENTIFIED_BY 변경할 비밀번호 입력;
*/

-- 생성한 계정에 권한 부여
GRANT CONNECT, RESOURCE TO user1;
-- 모든 테이블의 데이터 추가, 수정, 삭제 권한 부여
GRANT INSERT ANY TABLE, UPDATE ANY TABLE, DELETE ANY TABLE TO user1;
--뷰 테이블 생성 권한 부여
GRANT CREATE VIEW TO user1;
-- 테이블스페이스(USERS) 사용 권한 부여
ALTER USER user1 quota 50M ON USERS;

-- 권한 확인(소문자로 계정을 만들어도 대문자로 사용하자!)
SELECT * FROM DBA_ROLE_PRIVS WHERE grantee = 'USER1';
SELECT * FROM USER_ROLE_PRIVS;