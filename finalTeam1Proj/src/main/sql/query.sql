-- 회원 테이블
CREATE TABLE finaladmin.MEMBERS(
    MID         NUMBER        PRIMARY KEY,
    USERNAME    VARCHAR2(50)  NOT NULL,
    PASSWORD    VARCHAR2(50)  NOT NULL,
    JOINDATE    DATE          DEFAULT(SYSDATE),
    LOGINDATE   DATE          DEFAULT(SYSDATE)
);
CREATE SEQUENCE finaladmin.MEMBERS_SEQ NOCACHE;


-- 애완동물 테이블
CREATE TABLE finaladmin.PETS(
    PNO      NUMBER PRIMARY KEY,
    MID      NUMBER,                  -- 펫 주인 구별
    SID  NUMBER DEFAULT(1),       -- 1:강아지, 2:고양이, 3:기타
    PETNAME  VARCHAR2(50) NOT NULL,
    SEX      CHAR(1) DEFAULT('F'),    -- F:암컷, M:수컷
    BIRTHDAY DATE DEFAULT(SYSDATE),
    AGE      NUMBER DEFAULT(0),
    FOREIGN KEY (MID) REFERENCES finaladmin.MEMBERS(MID) ON DELETE CASCADE
);
CREATE SEQUENCE finaladmin.PETS_SEQ NOCACHE;


-- 펫 등록 시 펫 이미지 등록 테이블
CREATE TABLE finaladmin.PET_FILES(
    PFNO       NUMBER          PRIMARY KEY,
    PNO         NUMBER,                       -- 몇 번에 등록된 펫의 이미지인지 구분
    FILENAME    VARCHAR2(100)   NOT NULL,
    FILEURL     VARCHAR2(1000)  NOT NULL,
    FILESIZE    NUMBER          DEFAULT(0),
    FOREIGN KEY (PNO) REFERENCES finaladmin.PETS(PNO) ON DELETE CASCADE
);
CREATE SEQUENCE finaladmin.PET_FILES_SEQ NOCACHE;


-- 게시판 테이블
CREATE TABLE finaladmin.BOARD(
    BNO         NUMBER          PRIMARY KEY,
    CID         NUMBER          DEFAULT(1),     -- 1: 의료/건강, 2:감동, 3:입양공고, 4:재미, 5:상품평
    MID         NUMBER,                         -- 게시글 작성자 번호; MEMBERS 테이블과 JOIN 문 이용하여 작성자 도출
    TITLE       VARCHAR2(200)   NOT NULL,
    CONTENT     VARCHAR2(4000)  NOT NULL,
    VCNT        NUMBER          DEFAULT(0),
    GCNT        NUMBER          DEFAULT(0),
    BCNT        NUMBER          DEFAULT(0),
    WRITEDATE   DATE DEFAULT(SYSDATE),
    FOREIGN KEY (MID) REFERENCES finaladmin.MEMBERS(MID) ON DELETE CASCADE
);
CREATE SEQUENCE finaladmin.BOARD_SEQ NOCACHE;


-- 게시판 카테고리 테이블
CREATE TABLE finaladmin.BOARD_CAT(
    BCNO       NUMBER          PRIMARY KEY,
    NANE        VARCHAR2(100)   NOT NULL,
    DISABLED    CHAR(1)         DEFAULT('N')    -- N: 선택되지 않음, Y: 선택됨
);
CREATE SEQUENCE finaladmin.BOARD_CAT_SEQ NOCACHE;


-- 게시판 첨부파일 테이블
CREATE TABLE finaladmin.BOARD_FILES(
    BFNO       NUMBER          PRIMARY KEY,
    BNO         NUMBER,                         -- 몇 번 게시글의 이미지인지 구분
    FILENAME    VARCHAR2(100)   NOT NULL,
    FILEURL     VARCHAR2(1000)  NOT NULL,
    FILESIZE    NUMBER          DEFAULT(0),
    FOREIGN KEY (BNO) REFERENCES finaladmin.BOARD(BNO) ON DELETE CASCADE
);
CREATE SEQUENCE finaladmin.BOARD_FILES_SEQ NOCACHE;


-- 일기장 테이블
CREATE TABLE finaladmin.DIARY(
    DNO         NUMBER          PRIMARY KEY,
    MID         NUMBER,                         -- 작성자 번호; MEMBERS 테이블과 JOIN 문 이용하여 작성자 도출
    CONTENT     VARCHAR2(4000)  NOT NULL,
    GCNT        NUMBER          DEFAULT(0),
    WRITEDATE   DATE            DEFAULT(SYSDATE),
    FOREIGN KEY (MID) REFERENCES finaladmin.MEMBERS(MID) ON DELETE CASCADE
);
CREATE SEQUENCE finaladmin.DIARY_SEQ NOCACHE;


-- 일기장 첨부파일 테이블
CREATE TABLE finaladmin.DIARY_FILES(
    DFNO       NUMBER          PRIMARY KEY,
    DNO         NUMBER,                         -- 몇 번 일기장 글의 이미지인지 구분
    FILENAME    VARCHAR2(100)   NOT NULL,
    FILEURL     VARCHAR2(1000)  NOT NULL,
    FILESIZE    NUMBER          DEFAULT(0),
    FOREIGN KEY (DNO) REFERENCES finaladmin.DIARY(DNO) ON DELETE CASCADE
);
CREATE SEQUENCE finaladmin.DIARY_FILES_SEQ NOCACHE;


-- 일기장 댓글 테이블
CREATE TABLE finaladmin.DIARY_REPLY(
    DRNO NUMBER PRIMARY KEY,
    DNO NUMBER,                         -- 몇 번 일기장 글의 댓글인지 구분
    MID NUMBER,                         -- 댓글 작성자 번호; MEMBERS 테이블과 JOIN 문 이용하여 작성자 도출
    CONTENT VARCHAR2(1000),
    WRITEDATE DATE DEFAULT(SYSDATE),
    FOREIGN KEY (DNO) REFERENCES finaladmin.DIARY(DNO) ON DELETE CASCADE,
    FOREIGN KEY (MID) REFERENCES finaladmin.MEMBERS(MID) ON DELETE CASCADE
);
CREATE SEQUENCE finaladmin.DIARY_REPLY_SEQ NOCACHE;



-- 초기 데이터 삽입

/*
 * 회원 샘플 데이터
 */
INSERT INTO finaladmin.MEMBERS VALUES(
    finaladmin.MEMBERS_SEQ.NEXTVAL, 'user1', 'user1', SYSDATE, SYSDATE
);

INSERT INTO finaladmin.MEMBERS VALUES(
    finaladmin.MEMBERS_SEQ.NEXTVAL, 'user2', 'user2', SYSDATE, SYSDATE
);

INSERT INTO finaladmin.MEMBERS VALUES(
    finaladmin.MEMBERS_SEQ.NEXTVAL, 'user3', 'user3', SYSDATE, SYSDATE
);

/*
 * 펫 샘플 데이터
 */
INSERT INTO finaladmin.PETS(PNO, MID, SID, PETNAME, SEX, BIRTHDAY, AGE) VALUES(
    finaladmin.PETS_SEQ.NEXTVAL, 1, 1, 'dog1', 'F', SYSDATE, 3
);

INSERT INTO finaladmin.PETS(PNO, MID, SID, PETNAME, SEX, BIRTHDAY, AGE) VALUES(
    finaladmin.PETS_SEQ.NEXTVAL, 1, 3, 'parrot1', 'M', SYSDATE, 4
);

INSERT INTO finaladmin.PETS(PNO, MID, SID, PETNAME, SEX, BIRTHDAY, AGE) VALUES(
    finaladmin.PETS_SEQ.NEXTVAL, 2, 1, 'dog2', 'F', SYSDATE, 1
);

INSERT INTO finaladmin.PETS(PNO, MID, SID, PETNAME, SEX, BIRTHDAY, AGE) VALUES(
    finaladmin.PETS_SEQ.NEXTVAL, 2, 2, 'cat1', 'F', SYSDATE, 5
);

INSERT INTO finaladmin.PETS(PNO, MID, SID, PETNAME, SEX, BIRTHDAY, AGE) VALUES(
    finaladmin.PETS_SEQ.NEXTVAL, 3, 3, 'tuttle1', 'M', SYSDATE, 10
);

INSERT INTO finaladmin.PETS(PNO, MID, SID, PETNAME, SEX, BIRTHDAY, AGE) VALUES(
    finaladmin.PETS_SEQ.NEXTVAL, 3, 3, 'hamster1', 'F', SYSDATE, 1
);

/*
 * 게시판 샘플 데이터; 첨부파일이 없는
 */
INSERT INTO finaladmin.BOARD(BNO, CID, MID, TITLE, CONTENT) VALUES(
    finaladmin.BOARD_SEQ.NEXTVAL, 1, 1, '샘플용 게시글 1', '이 게시글은 샘플입니다.'
);

INSERT INTO finaladmin.BOARD(BNO, CID, MID, TITLE, CONTENT) VALUES(
    finaladmin.BOARD_SEQ.NEXTVAL, 2, 1, '샘플용 게시글 2', '이 게시글은 샘플입니다.'
);

INSERT INTO finaladmin.BOARD(BNO, CID, MID, TITLE, CONTENT) VALUES(
    finaladmin.BOARD_SEQ.NEXTVAL, 3, 2, '샘플용 게시글 3', '이 게시글은 샘플입니다.'
);

INSERT INTO finaladmin.BOARD(BNO, CID, MID, TITLE, CONTENT) VALUES(
    finaladmin.BOARD_SEQ.NEXTVAL, 4, 3, '샘플용 게시글 4', '이 게시글은 샘플입니다.'
);

INSERT INTO finaladmin.BOARD(BNO, CID, MID, TITLE, CONTENT) VALUES(
    finaladmin.BOARD_SEQ.NEXTVAL, 5, 1, '샘플용 게시글 5', '이 게시글은 샘플입니다.'
);

INSERT INTO finaladmin.BOARD(BNO, CID, MID, TITLE, CONTENT) VALUES(
    finaladmin.BOARD_SEQ.NEXTVAL, 2, 2, '샘플용 게시글 6', '이 게시글은 샘플입니다.'
);

INSERT INTO finaladmin.BOARD(BNO, CID, MID, TITLE, CONTENT) VALUES(
    finaladmin.BOARD_SEQ.NEXTVAL, 2, 3, '샘플용 게시글 7', '이 게시글은 샘플입니다.'
);

INSERT INTO finaladmin.BOARD(BNO, CID, MID, TITLE, CONTENT) VALUES(
    finaladmin.BOARD_SEQ.NEXTVAL, 3, 3, '샘플용 게시글 8', '이 게시글은 샘플입니다.'
);

INSERT INTO finaladmin.BOARD(BNO, CID, MID, TITLE, CONTENT) VALUES(
    finaladmin.BOARD_SEQ.NEXTVAL, 4, 3, '샘플용 게시글 9', '이 게시글은 샘플입니다.'
);

INSERT INTO finaladmin.BOARD(BNO, CID, MID, TITLE, CONTENT) VALUES(
    finaladmin.BOARD_SEQ.NEXTVAL, 5, 3, '샘플용 게시글 10', '이 게시글은 샘플입니다.'
);

INSERT INTO finaladmin.BOARD(BNO, CID, MID, TITLE, CONTENT) VALUES(
    finaladmin.BOARD_SEQ.NEXTVAL, 1, 1, '샘플용 게시글 11', '이 게시글은 샘플입니다.'
);

/*
 * 게시판 카테고리 종류 데이터 샘플
 */
INSERT INTO finaladmin.BOARD_CAT VALUES(
    finaladmin.BOARD_CAT_SEQ.NEXTVAL, '의료/건강', 'N'
);

INSERT INTO finaladmin.BOARD_CAT VALUES(
    finaladmin.BOARD_CAT_SEQ.NEXTVAL, '감동', 'N'
);

INSERT INTO finaladmin.BOARD_CAT VALUES(
    finaladmin.BOARD_CAT_SEQ.NEXTVAL, '입양 공고', 'N'
);

INSERT INTO finaladmin.BOARD_CAT VALUES(
    finaladmin.BOARD_CAT_SEQ.NEXTVAL, '재미', 'N'
);

INSERT INTO finaladmin.BOARD_CAT VALUES(
    finaladmin.BOARD_CAT_SEQ.NEXTVAL, '상품평', 'N'
);



-- 조회, 수정, 삭제 SQL 문 작성

/*
 * 로그인을 위한 조회
 */
SELECT * FROM finaladmin.MEMBERS;
SELECT * FROM finaladmin.MEMBERS WHERE USERNAME='user1' AND PASSWORD='user1';

/*
 * 로그인 회원이 등록한 펫 조회
 */
SELECT A.PNO, A.MID, B.USERNAME, A.SID, A.PETNAME, A.SEX, A.BIRTHDAY, A.AGE
  FROM finaladmin.PETS A
  JOIN finaladmin.MEMBERS B
    ON A.MID = B.MID
 WHERE A.MID = 1; --  WHERE B.USERNAME = 'user1';

/*
 * 게시판 전체 목록 조회
 */
SELECT A.BNO, A.CID, B.NAME AS "CATNAME", A.MID, C.USERNAME AS "MEMNAME", A.TITLE, A.VCNT, A.GCNT, A.WRITEDATE
  FROM finaladmin.BOARD A
  JOIN finaladmin.BOARD_CAT B
    ON A.CID = B.ID
  JOIN finaladmin.MEMBERS C
    ON A.MID = C.MID
 ORDER BY A.BNO DESC;

/*
 * 특정 계정에 대한 id 값 가져오기
 */
SELECT MID FROM MEMBERS WHERE USERNAME = '특정 계정명';

/*
 * 계정의 번호를 이용한 작성자별 게시글 조회
 */
SELECT A.BNO, A.CID, A.MID, B.USERNAME AS "MEMNAME", A.TITLE, A.VCNT, A.GCNT, A.WRITEDATE
  FROM finaladmin.BOARD A
  JOIN finaladmin.MEMBERS B
    ON A.MID = B.MID
 WHERE A.MID = 1;

/*
 * 제목별 게시글 조회
 */
SELECT A.BNO, A.CID, A.MID, B.USERNAME AS "MEMNAME", A.TITLE, A.VCNT, A.GCNT, A.WRITEDATE
  FROM finaladmin.BOARD A
  JOIN finaladmin.MEMBERS B
    ON A.MID = B.MID
 WHERE A.TITLE = '샘플용 게시글 1';

/*
 * 게시글 상세 조회 / UPDATE 에서도 사용
 */
SELECT A.BNO, A.CID, B.NAME AS "CATNAME", A.MID, C.USERNAME AS "MEMNAME", A.TITLE, A.CONTENT, A.VCNT, A.GCNT, A.BCNT, A.WRITEDATE
  FROM finaladmin.BOARD A
  JOIN finaladmin.BOARD_CAT B
    ON A.CID = B.ID
  JOIN finaladmin.MEMBERS C
    ON A.MID = C.MID
 WHERE A.BNO = 1;