-- 계정 테이블
CREATE TABLE SPRINGWEB.MEMBERS(
      ID        NUMBER
    , USERNAME  VARCHAR2(32)
    , PASSWORD  VARCHAR2(32)
    , JOINDATE  DATE        
    , LOGINDATE DATE
    , DORMANT   CHAR(1)      -- 휴면 계정인지 구분
    , EXPIRE    CHAR(1)      -- 탈퇴 계정인지 구분
    , STAFF     CHAR(1)      -- 사이트 관리 직원인지 구분
    , ADMIN     CHAR(1)      -- 사이트 관리자인지 구분
);
ALTER TABLE SPRINGWEB.MEMBERS ADD CONSTRAINT MEMBERS_ID_PK PRIMARY KEY(ID);
ALTER TABLE SPRINGWEB.MEMBERS MODIFY USERNAME CONSTRAINT MEMBERS_USERNAME_NN NOT NULL;
ALTER TABLE SPRINGWEB.MEMBERS MODIFY PASSWORD CONSTRAINT MEMBERS_PASSWORD_NN NOT NULL;
ALTER TABLE SPRINGWEB.MEMBERS MODIFY JOINDATE DEFAULT(SYSDATE);
ALTER TABLE SPRINGWEB.MEMBERS MODIFY LOGINDATE DEFAULT(SYSDATE);
ALTER TABLE SPRINGWEB.MEMBERS MODIFY DORMANT DEFAULT('N');
ALTER TABLE SPRINGWEB.MEMBERS MODIFY EXPIRE DEFAULT('N');
ALTER TABLE SPRINGWEB.MEMBERS MODIFY STAFF DEFAULT('N');
ALTER TABLE SPRINGWEB.MEMBERS MODIFY ADMIN DEFAULT('N');

CREATE SEQUENCE SPRINGWEB.MEMBERS_SEQ NOCACHE;


-- 계정 회원 정보 테이블
CREATE TABLE SPRINGWEB.MEMBERS_INFO(
      ID        NUMBER
    , FIRSTNAME VARCHAR2(32)
    , LASTNAME  VARCHAR2(32)
    , BIRTHDAY  DATE
    , EMAIL1    VARCHAR2(100)
    , EMAIL2    VARCHAR2(100)
);
ALTER TABLE SPRINGWEB.MEMBERS_INFO ADD CONSTRAINT MEMBERS_INFO_ID_PK PRIMARY KEY(ID);
ALTER TABLE SPRINGWEB.MEMBERS_INFO ADD CONSTRAINT MEMBERS_INFO_ID_FK FOREIGN KEY(ID) REFERENCES SPRINGWEB.MEMBERS(ID);

SELECT springweb.MEMBERS_SEQ.NEXTVAL FROM DUAL;


-- 초기 데이터
INSERT INTO SPRINGWEB.MEMBERS VALUES(
	   springweb.MEMBERS_SEQ.NEXTVAL
	 , 'admin', 'admin', SYSDATE, SYSDATE ,'N' , 'N' , 'Y', 'Y');
INSERT INTO springweb.MEMBERS_INFO VALUES(
	   springweb.MEMBERS_SEQ.CURRVAL
	 , '관리자', '관리자', null, 'admin@sample.com', 'admin@example.com');

INSERT INTO SPRINGWEB.MEMBERS VALUES(
	   springweb.MEMBERS_SEQ.NEXTVAL
	 , 'staff1', 'staff1', SYSDATE, SYSDATE ,'N' , 'N' , 'Y', 'N');
INSERT INTO springweb.MEMBERS_INFO VALUES(
	   springweb.MEMBERS_SEQ.CURRVAL
	 , '직원1', '직원1', null, 'staff1@sample.com', 'staff1@example.com'); 