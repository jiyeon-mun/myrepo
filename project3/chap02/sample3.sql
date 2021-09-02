-- 테이블의 정보를 간략히 보여줌 : not null 제약조건 확인 할 수 있음.
DESC SUBJECT_T;

-- 제약조건 조회
SELECT * FROM USER_CONSTRAINTS; -- 접속 계정 테이블 전체에 대해서
SELECT * FROM USER_CONSTRAINTS WHERE table_name = 'SUBJECT_T';

DROP TABLE SUBJECT_T;

/*
CREATE TABLE subject_t(
    s_id NUMBER PRIMARY KEY,  -- 컬럼 레벨로 작성
    s_name VARCHAR2(30) UNIQUE,
    s_teacher VARCHAR2(30) NOT NULL
);

CREATE TABLE subject_t(
    s_id NUMBER,
    s_name VARCHAR2(30),
    s_teacher VARCHAR2(30) NOT NULL,
    -- 테이블 레벨
    PRIMARY KEY(s_id),
    UNIQUE(s_name)
);
*/
CREATE TABLE subject_t(
    s_id NUMBER,
    s_name VARCHAR2(30),
    s_teacher VARCHAR2(30)
);
ALTER TABLE subject_t ADD CONSTRAINT SUBJECT_T_S_ID_PK PRIMARY KEY(s_id);
ALTER TABLE subject_t ADD CONSTRAINT SUBJECT_T_S_NAME_UK UNIQUE(s_name);
ALTER TABLE subject_t MODIFY s_teacher CONSTRAINT SUBJECT_T_S_TEACHER_NN NOT NULL;

COMMENT ON COLUMN subject_t.s_id IS '과목번호(코드)';
COMMENT ON COLUMN subject_t.s_name IS '과목명';
COMMENT ON COLUMN subject_t.s_teacher IS '해당 과목 담당 선생님';

INSERT INTO subject_t VALUES(1, '국어', '박수현');
-- NOT NULL 제약조건 위반
-- INSERT INTO subject_t(s_id, s_name) VALUES(2, '영어');

INSERT INTO subject_t VALUES(2, '영어', '김장훈');
-- UNIQUE 제약조건 위반
-- INSERT INTO subject_t VALUES(2, '영어', '박조원');

INSERT INTO subject_t VALUES(3, '수학', '이창훈');

SELECT * FROM subject_t;

-- 학생 정보를 저장하기 위한 데이터베이스 테이블을 생성해보시오.
-- 학생 정보에는 학생코드(PK), 학생이름(NN), 반, 성별, 담임 이 있다.

DROP TABLE student_t;
CREATE TABLE student_t(
    s_id NUMBER,
    s_name VARCHAR2(30),
    s_class NUMBER,
    gender CHAR(1), -- CHECK(gender IN ('m', 'w')),
    s_teacher VARCHAR(30)
    -- CHECK(gender IN ('m', 'w'))
);
ALTER TABLE student_t ADD CONSTRAINT STUDENT_S_ID_PK PRIMARY KEY(s_id);
ALTER TABLE student_t MODIFY s_name CONSTRAINT STUDENT_S_NAME_NN NOT NULL;
ALTER TABLE student_t ADD CONSTRAINT STUDENT_GENDER_CK CHECK(gender IN ('m', 'w'));

INSERT INTO student_t VALUES(1, '홍길동', 1, 'm', '박수현');

COMMENT ON COLUMN student_t.s_id IS '학생번호(코드)';
COMMENT ON COLUMN student_t.s_name IS '학생이름';
COMMENT ON COLUMN student_t.s_class IS '소속 반';
COMMENT ON COLUMN student_t.gender IS '성별';
COMMENT ON COLUMN student_t.s_teacher IS '담당 선생님';

SELECT * FROM USER_CONSTRAINTS WHERE table_name = 'STUDENT_T';


-- 교사 정보를 관리하기 위한 teacher_t 테이블을 생성한다.
-- 이 테이블에는 t_id, t_name, t_type, s_part 컬럼이 사용된다.
-- t_id : 교사코드, 정수코드, PK
-- t_name : 교사명, 문자열(50자), NN
-- t_type : 교사구분(담임교사:m, 일반교사:n, 시간교사:t)
-- s_part : 담당과목, 정수코드, NN
DROP TABLE teacher_t;
CREATE TABLE teacher_t(
    t_id NUMBER,
    t_name VARCHAR2(150),
    t_type CHAR(1) DEFAULT('M'), -- 기본값으로 M을 가진다.
    s_part NUMBER
);
ALTER TABLE teacher_t ADD CONSTRAINT TEACHER_T_ID_PK PRIMARY KEY(t_id);
ALTER TABLE teacher_t MODIFY t_name CONSTRAINT TEACHER_T_NAME_NN NOT NULL;
ALTER TABLE teacher_t ADD CONSTRAINT TEACHER_T_TYPE CHECK(t_type IN ('M', 'N', 'T'));
ALTER TABLE teacher_t MODIFY s_part CONSTRAINT TEACHER_S_PART_NN NOT NULL;

COMMENT ON COLUMN teacher_t.t_id IS '교사코드';
COMMENT ON COLUMN teacher_t.t_name IS '교사명';
COMMENT ON COLUMN teacher_t.t_type IS '교사구분(담임교사:M, 일반교사:N, 시간교사:T)';
COMMENT ON COLUMN teacher_t.s_part IS '담당과목';

SELECT * FROM ALL_ALL_TABLES WHERE table_name = 'TEACHER_T';
SELECT * FROM ALL_TAB_COLUMNS WHERE table_name = 'TEACHER_T';
SELECT * FROM ALL_COL_COMMENTS WHERE table_name = 'TEACHER_T';
SELECT * FROM USER_CONSTRAINTS WHERE table_name = 'TEACHER_T';