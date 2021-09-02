-- 테이블 생성
CREATE TABLE sample_t(
    s_id NUMBER,
    name VARCHAR2(50),
    today DATE,
    t_stamp TIMESTAMP
);

-- 생성한 테이블 확인
SELECT * FROM ALL_ALL_TABLES; -- 전체 계정
SELECT * FROM ALL_ALL_TABLES WHERE owner = 'USER1'; -- USER1 계정
SELECT * FROM ALL_ALL_TABLES WHERE owner = 'USER1' AND table_name = 'SAMPLE_T'; -- USER1 계정에서 SAMPLE_T 테이블

-- 생성한 테이블의 컬럼 확인
SELECT * FROM ALL_TAB_COLUMNS WHERE table_name LIKE 'SAMPLE_T%';

-- 테이블 수정 - 새로운 컬럼 추가
ALTER TABLE sample_t ADD gender CHAR(1);
-- 테이블 수정 - 기존 컬럼 수정
ALTER TABLE sample_t MODIFY name VARCHAR2(100);
-- 테이블 수정 - 기존 컬럼 삭제
ALTER TABLE sample_t DROP COLUMN t_stamp;
-- 컬럼명 변경
ALTER TABLE sample_t RENAME COLUMN name TO s_name;
-- 테이블 이름 변경
ALTER TABLE sample_t RENAME TO sample_table;

-- 테이블 제거
DROP TABLE sample_table;


-- 과목 정보를 저장하기 위한 데이터베이스 테이블을 생성해보시오.
-- 과목 정보에는 과목명, 과목코드, 과목담당 이 있다.
CREATE TABLE subject_t(
    s_id NUMBER,
    s_name VARCHAR2(30),
    s_teacher VARCHAR2(30)
);
-- 컬럼 별 코멘트(주석) 달기
COMMENT ON COLUMN subject_t.s_id IS '과목번호(코드)';
COMMENT ON COLUMN subject_t.s_name IS '과목명';
COMMENT ON COLUMN subject_t.s_teacher IS '해당 과목 담당 선생님';

-- SUBJECT_T 명칭의 테이블이 생성됐는지 테이블 목록 조회
SELECT * FROM ALL_ALL_TABLES WHERE table_name = 'SUBJECT_T';
-- 생성한 SUBJECT_T 테이블을 컬럼 조회
SELECT * FROM ALL_TAB_COLUMNS WHERE table_name = 'SUBJECT_T';
-- SUBJECT_T 테이블의 각 컬럼들의 코멘트 확인
SELECT * FROM ALL_COL_COMMENTS WHERE table_name = 'SUBJECT_T';

-- 학생 정보를 저장하기 위한 데이터베이스 테이블을 생성해보시오.
-- 학생 정보에는 학생코드, 학생이름, 반, 성별, 담임 이 있다.
CREATE TABLE student_t(
    s_id NUMBER,
    s_name VARCHAR2(30),
    s_class NUMBER,
    gender CHAR(1),
    s_teacher VARCHAR(30)
);
COMMENT ON COLUMN student_t.s_id IS '학생번호(코드)';
COMMENT ON COLUMN student_t.s_name IS '학생이름';
COMMENT ON COLUMN student_t.s_class IS '소속 반';
COMMENT ON COLUMN student_t.gender IS '성별';
COMMENT ON COLUMN student_t.s_teacher IS '담당 선생님';

SELECT * FROM ALL_ALL_TABLES WHERE owner = 'USER1' AND table_name = 'STUDENT_T';
SELECT * FROM ALL_TAB_COLUMNS WHERE table_name = 'STUDENT_T';
SELECT * FROM ALL_COL_COMMENTS WHERE table_name = 'STUDENT_T';