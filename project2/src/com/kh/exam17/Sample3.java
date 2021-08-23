package com.kh.exam17;

import java.util.*;

class Subject {
	private int score;
	private String name;
	
	public Subject(String name, int score) {
		this.name=name;
		this.score=score;
	}
	
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "Subject [score=" + score + ", name=" + name + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) // 객체 자체 비교; 단, 객체 참조 주소는 서로 다름.
			return true;
		System.out.println("this == obj -> " + this + "|" + obj);
		if (obj == null)
			return false;
		if (getClass() != obj.getClass()) // 같은 클래스인지
			return false;
		System.out.println("getClass() != obj.getClass() -> " + getClass() + "|" + obj.getClass());
		
		Subject other = (Subject) obj; // 각각의 멤버변수값 비교
		System.out.println("return -> " + Objects.equals(name, other.name) + "|" + (score == other.score));
		
		 //return Objects.equals(name, other.name) && score == other.score;
		 return Objects.equals(name, other.name);
		// indexOf()는 객체 속성(멤버변수) 모두 또는 속성 중 하나만 비교해서 같다고 취급할 수 있음.
	}
	
}

public class Sample3 {

	public static void main(String[] args) {
		List<Subject> sList = new ArrayList<Subject>();
		sList.add(new Subject("과학",70));
		sList.add(new Subject("영어",90));
		sList.add(new Subject("국어",85));
		
		Subject s = new Subject("국어", 85);
		
		// Override된 equals()로 비교; 객체의 속성 모두에 대해 비교
//		boolean resBool = sList.contains(s);
//		System.out.println("contains 최종결과: "+resBool);
		
		// Override된 equals()로 비교; 객체 속성 모두에 대해서도 가능하나
		// 속성 중 하나만 비교해서 같다고 취급할 수 있다.
		int resInt = sList.indexOf(s);
		System.out.println("indesOf 최종결과: "+resInt); // 동일한 속성이 없다면 -1
	}

}
