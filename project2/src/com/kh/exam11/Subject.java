package com.kh.exam11;

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
