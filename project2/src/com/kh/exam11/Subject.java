package com.kh.exam11;

/*
 * 과목명, 점수 입력 객체배열 저장 관리 클래스
 * 		과목명: 중복허용X, "종료" 문자열 입력 전까지 무한반복
 * 		점수: 입력한 과목명에 대한 점수 입력
 * 			 기본적으로 점수 입력범위는 0~100 사이이나 다른 값으로 제한 가능하며
 * 			 제한된 범위에 맞춰서 점수별 등급 지정 또한 해당 범위에 맞춘다.
 */
public class Subject {
	private String name;
	private int jumsu;
	private static double[] dblGrade = {100.0, 90.0, 80.0, 70.0, 60.0, 0.0};
	private static final String[] GRADE = {"A", "B", "C", "D", "F"};
	
	public Subject() {}
	
	public Subject(String name) {
		this.name = name;
	}
	
	public Subject(String name, int num) {
		this.name = name;
		this.jumsu = num;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setJumsu(int num) {
		if(Subject.dblGrade[Subject.dblGrade.length - 1] <= num && num <= Subject.dblGrade[0]) {
			this.jumsu = num;
		} else {
			this.jumsu = -1;
		}
	}
	
	public int getJumsu() {
		return this.jumsu;
	}
	
	public boolean isValid() {
		return this.jumsu == -1 ? false : true;
	}
	
	public String getGrade() {
		if(this.jumsu == Subject.dblGrade[0]) {
			return Subject.GRADE[0];
		} else {
			for(int i = 0; i < Subject.dblGrade.length - 1; i++) {
				if(this.jumsu < Subject.dblGrade[i] &&
						this.jumsu >= Subject.dblGrade[i+1]) {
					return Subject.GRADE[i];
				}
			}
		}
		return Subject.GRADE[Subject.GRADE.length - 1];
	}
	
	public void jumsuConversion() {
		if(this.jumsu > 0) {
			this.setJumsu((int)((double)this.jumsu / 100 * Subject.dblGrade[0]));
		}
	}
	
	public static void setRangeJumsu(int min, int max) {
		Subject.dblGrade[Subject.dblGrade.length - 1] = min;
		Subject.dblGrade[0] = max;
		
		for(int i = 1; i < Subject.dblGrade.length - 1; i++) {
			Subject.dblGrade[i] = max / 100.0 * (100 - i * 10);
		}

	}
	
	public static int[] getRangeJumsu() {
		return new int[] {(int)Subject.dblGrade[Subject.dblGrade.length - 1],
				(int)Subject.dblGrade[0]};
	}
	
	public boolean equalSubject(Subject s) {
		return this.name.equals(s.name);
	}
	
	public boolean gt(Subject s) {
		return this.jumsu > s.jumsu;
	}
	
	public boolean ge(Subject s) {
		return this.jumsu >= s.jumsu;
	}
	
	public boolean lt(Subject s) {
		return this.jumsu < s.jumsu;
	}
	
	public boolean le(Subject s) {
		return this.jumsu <= s.jumsu;
	}
	
	public boolean eq(Subject s) {
		return this.jumsu == s.jumsu;
	}
	
	public boolean nq(Subject s) {
		return this.jumsu != s.jumsu;
	}
}
