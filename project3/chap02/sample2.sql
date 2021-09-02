-- 반드시 chap02/sample1.sql 의 테이블을 생성 후 진행.

-- 컬럼명에 맞게 데이터 삽입; 테이블 행의 증가 INSERT
INSERT INTO subject_t VALUES(1, '홍길동', '박수현');
INSERT INTO subject_t(s_id, s_name) VALUES(2, '김조한');
INSERT INTO subject_t(s_id, s_name) VALUES(3, '박지한');
INSERT INTO subject_t(s_id, s_name) VALUES(4, '최성준');
INSERT INTO subject_t(s_id, s_name) VALUES(5, '이아란');

-- 수정/삭제 작업을 하기 전 검색으로 확인한다.
SELECT * FROM subject_t WHERE s_id = 1;

-- 컬렁명에 맞게 데이터 수정 UPDATE; WHERE 조건문 이용해 필요한 행에 대해서만
UPDATE subject_t SET s_name = '국어' WHERE s_id = 1;
UPDATE subject_t SET s_name = '영어', s_teacher = '김조한' WHERE s_id = 2;
UPDATE subject_t SET s_name = '수학' WHERE s_id = 3;
UPDATE subject_t SET s_name = '사회', s_teacher = '최성준' WHERE s_id = 4;
UPDATE subject_t SET s_name = '과학', s_teacher = '이아란' WHERE s_id = 5;

-- s_id 가 3 인 데이터 행 삭제
DELETE FROM subject_t WHERE s_id = 3;

SELECT * FROM subject_t;


INSERT INTO student_t VALUES(1, '홍길동', 1, 'M', '박수현');
INSERT INTO student_t VALUES(2, '김장현', 1, 'M', '박수현');
INSERT INTO student_t VALUES(3, '박지연', 1, 'W', '박수현');

INSERT INTO student_t VALUES(4, '고주성', 2, 'M', '최성준');
INSERT INTO student_t VALUES(5, '최창훈', 2, 'M', '최성준');
INSERT INTO student_t VALUES(6, '하라연', 2, 'W', '최성준');

INSERT INTO student_t VALUES(7, '김연우', 3, 'M', '이아란');
INSERT INTO student_t VALUES(8, '박지안', 3, 'W', '이아란');
INSERT INTO student_t VALUES(9, '이가은', 3, 'W', '이아란');

SELECT * FROM student_t;