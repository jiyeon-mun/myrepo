package com.kh.exam10;

class Subject {
	
	private String name;
	private int jumsu;
	private int min;// 기존점수범위 최소값 0
	private int max = 100; // 기존점수범위 최대값 100
	
	public Subject() {
		System.out.println("sub1 생성자 호출: " + this.name + " " + this.jumsu);
	}
	public Subject(String name) {
		this.name = name;
		System.out.println("sub2 매개변수 생성자 호출: " + this.name + " " + this.jumsu);
	}
	public Subject(String name, int num) {
		this.name = name;
		this.jumsu = num;
		System.out.println("sub3 매개변수 생성자 호출: " + this.name + " " + this.jumsu);
		System.out.println();
	}
	
	// setter 메소드: 필드에 변경할 값을 전달받아 필드 값을 변경하는 메소드; 함수호출; void set필드명([자료형 변수명]){}
	// getter 메소드: 필드에 기록된 값을 읽어서 요청한 쪽으로 값을 넘기는 메소드; return 반환값; 반환형 get필드명(){}
	// setter, getter 꼭 세트로 작성하는 점 유의!
	public void setName(String name) {
		this.name = name;
		// 함수호출로 받아오는 인자값을 클래스에서 캡슐화한 name에 저장
	}
	public String getName() {
		return this.name;
		// setName() 메소드로 변경한 필드값을 요청한 쪽으로 반환
	}
	
	public void setJumsu(int num) {
		// 점수의 범위 변경으로 0->min, 100->max로 변경됨
		if(this.min <= num && num <= this.max) {
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
		// return this.jumsu >= 0 && this.jumsu <= 100 ? true : false;
	}
	
	public String getGrade() {		
		// 점수범위에 따라 등급 지정
		double p = this.max / 100.0;
		if (this.jumsu <= this.max && this.jumsu >= ((double) this.max / 100 * 90)) {
			return "A";
		} else if(this.jumsu < (p * 90) && this.jumsu >= (p * 80)) {
			return "B";
		} else if(this.jumsu < (p * 80) && this.jumsu >= (p * 70)) {
			return "C";
		} else if(this.jumsu < (p * 70) && this.jumsu >= (p * 60)) {
			return "D";
		} else {
			return "F";
		}
		
		// 기존점수범위(0~100)에 따라 등급 지정
//		if(this.jumsu <= 100 && this.jumsu >= 90) {
//			return "A";
//		} else if(this.jumsu < 90 && this.jumsu >= 80) {
//			return "B";
//		} else if(this.jumsu < 80 && this.jumsu >= 70) {
//			return "C";
//		} else if(this.jumsu < 70 && this.jumsu >= 60) {
//			return "D";
//		} else {
//			return "F";
//		}s
	}
	
	public void setRangeJumsu(int min, int max) {
		// 기존점수범위(0~100)를 메서드를 통해 전달받은 매개변수(min ~ max)범위로 제한
		// 이미 점수가 입력되어 있는 상태에서 범위가 변경되면 기존 점수도 범위에 맞추어 재설정 되어야 한다.
		this.min = min;
		this.max = max;
		if(this.jumsu>0) {
			System.out.println((double) this.jumsu / 100 * max);
			this.setJumsu((int) ((double) this.jumsu / 100 * max));
			// setJumsu메서드의 매개변수는 자료형이 int형
		}
	}
	public int[] getRangeJumsu() {
		return new int[] { min, max }; // 배열요소로 반환
	}
	
	public boolean equalSubject(Subject s) {
		//System.out.println("\nsub1과목명: "+this.name+" |sub2과목명: "+s.name);
		return this.name.equals(s.name);
		// 두 과목명이 서로 같으면 true, 다르면 false 반환
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

public class Sample3 {

	public static void main(String[] args) {
		// 과목 클래스
		// 아래와 같은 다양한 방식으로 과목 클래스의 인스턴스(객체) 생성 가능
		// 클래스명 객체변수명 = new 클래스명();
		// 클래스명(); 은 생성자 호출을 의미
		Subject sub1 = new Subject();			// 매개변수가 없는 기본생성자 호출 및 인스턴스 sub1 생성
		Subject sub2 = new Subject("국어");		// 과목명을 매개변수로 전달하는 생성자 호출 및 인스턴스 sub2 생성
		Subject sub3 = new Subject("수학", 80);	// 과목명과 점수를 매개변수로 전달하는 생성자 호출 및 인스턴스 sub3 생성
		
		sub1.setName("영어");		// 과목명을 별도의 Setter 이용하여 저장 가능
		
		/*
		 * 점수는 0 ~ 100 사이의 정수만 입력받아 저장할 수 있다.
		 * 범위를 벗어난 값의 입력이 있는 경우 -1 이 저장되도록 한다.
		 */
		// 점수를 별도의 Setter 이용하여 저장 가능
		sub1.setJumsu(70); // 영어 70점
		sub2.setJumsu(88); // 국어 88점
		System.out.println("sub1 과목명, 점수(0~100) 확인: " + sub1.getName() + " " + sub1.getJumsu());
		System.out.println("sub2 과목명, 점수(0~100) 확인: " + sub2.getName() + " " + sub2.getJumsu());
		System.out.println("sub3 과목명, 점수(0~100) 확인: " + sub3.getName() + " " + sub3.getJumsu());
		
		/*
		 * 저장된 점수가 올바른 범위의 점수인지 확인하는 메서드이다.
		 * 올바른 점수인 경우 true, 올바르지 않은 경우 false 를 반환한다.
		 */
		if(sub1.isValid()) {
			System.out.println("sub1: 점수가 유효합니다.");
		} else {
			System.out.println("sub1: 점수가 유효하지 않습니다.");
		}
		if(sub1.isValid()) {
			System.out.println("sub2: 점수가 유효합니다.");
		} else {
			System.out.println("sub2: 점수가 유효하지 않습니다.");
		}
		if(sub1.isValid()) {
			System.out.println("sub3: 점수가 유효합니다.");
		} else {
			System.out.println("sub3: 점수가 유효하지 않습니다.");
		}
		
		/*
		 * 저장된 점수를 기반으로 등급 반환, 등급은 A ~ D 그리고 F
		 * A 등급은 100 ~ 90 이상
		 * B 등급은 90 미만 ~ 80 이상
		 * C 등급은 80 미만 ~ 70 이상
		 * D 등급은 70 미만 ~ 60 이상
		 * F 등급은 60 미만
		 */
		System.out.println(
				"sub1 등급: " + sub1.getGrade() + " |sub2 등급: " + sub2.getGrade() + " |sub3 등급: " + sub3.getGrade()+"\n");

		/* 
		 * 점수의 입력 범위를 한정하기 위한 메서드이다. 기본값으로 0 ~ 100 의 범위가 설정되어 있지만
		 * 아래의 메서드를 통해 입력 범위를 제한 할 수 있다.
		 * 이미 점수가 입력되어 있는 상태에서 범위가 변경되면 기존 점수도 범위에 맞추어 재설정 되어야 한다.
		 */
		// 기존의 0~100의 범위 점수가 호출함수에 전달한 인자의 범위 점수로 한정된다.; 백분율
		sub1.setRangeJumsu(0, 20); // sub1에 대해 점수의 입력 범위를 0 ~ 10 으로 한정한다.
		sub2.setRangeJumsu(0, 20); // sub2에 대해 점수의 입력 범위를 0 ~ 20 으로 한정한다.
		sub3.setRangeJumsu(0, 20); // sub2에 대해 점수의 입력 범위를 0 ~ 20 으로 한정한다.
		System.out.println("점수변환 확인1: "+sub1.getJumsu());
		System.out.println("점수변환 확인2: "+sub2.getJumsu());
		System.out.println("점수변환 확인3: "+sub3.getJumsu());
		
		// 점수의 입력 범위를 확인 할 수 있게 만들어 주는 메서드이다.
		int[] rg = sub1.getRangeJumsu(); // 배열요소로 반환됨
		
		// 점수의 범위가 변경이 되면 등급 또한 변경된 범위에 맞추어 계산이 이루어져야 한다.
		System.out.println(
				"sub1 등급: " + sub1.getGrade() + " |sub2 등급: " + sub2.getGrade() + " |sub3 등급: " + sub3.getGrade()+"\n");
		
		// 동일한 과목인지 비교하는 메서드이다.
		if(sub1.equalSubject(sub2)) {
			System.out.println("동일한 과목 입니다.");
		} else {
			System.out.println("동일한 과목이 아닙니다.");
		}
		
		/* 
		 * 점수를 비교하는 메서드이다.
		 * 이 메서드는 gt, lt, ge, le, eq, nq 의 추가 메서드도 만들어서 동작하게 한다.
		 * gt : 큰값인지 비교하기 위해 사용
		 * ge : 크거나 같은 값인지 비교하기 위해 사용
		 * lt : 작은값인지 비교하기 위해 사용
		 * le : 작거나 같은값인지 비교하기 위해 사용
		 * eq : 같은 값인지 비교하기 위해 사용
		 * nq : 다른 값인지 비교하기 위해 사용
		 */
		if(sub1.gt(sub2)) {
			System.out.println(sub1.getName() + "가 " + sub2.getName() + "의 점수보다 더 높습니다.");
			System.out.println(
					sub1.getName() + "점수: " + sub1.getJumsu() + " | " + sub2.getName() + "점수: " + sub2.getJumsu());
		}

	}

}
