package com.kh.exam05;

class Other {
	int x;
	private int y; // 메서드를 통해 접근하도록 함
	
	// this: 모든 인스턴스 메소드에 숨겨진 채로 존재하는 레퍼런스로 할당된 객체를 가르킴
	//		함수 실행 시 전달되는 객체의 주소를 자동으로 받음
	public Other() {
		System.out.println("this -> " + this);
		// 전달 객체 oth1의 주소를 받아 출력
	}
	
	public Other(int x) {
		this.x = x;
	}

	// 매개변수 명과는 관계없이 타입이 int로 동일하기 때문에 안됨.
//	public Other(int y) {
//		this.y = y;
//	}
	
	public Other(int x, int y) {
		// 전달 객체 oth2의 주소를 받아 출력
		System.out.println("this -> " + this);
		this.x = x; // 해당주소 x에는 전달받은 인자값 x 저장; 10
		this.y = y; // 해당주소 y에는 전달받은 인자값 y 저장; 20
	}
	
	// 매개변수 명이 다르다고 해서 오버로딩이 되는건 아님
//	public Other(int y, int x) {
//		this.y = y;
//		this.x = x;
//	}
	
	// private 접근제한자를 가지는 멤버변수 y에 접근하기 위해서
	public int getY() {
		return this.y;
	}
}

public class SampleClass {

	public static void main(String[] args) {
		Other oth1 = new Other();
		System.out.println("oth1 -> " + oth1); // 객체 주소출력
		// 기본생성자 Other() 호출
		
		Other oth2 = new Other(10, 20);
		System.out.println("oth2 -> " + oth2); // 객체 주소출력
		// 매개변수로 정수타입 변수 2개를 가지는 생성자 Other(int, int) 호출
		
		System.out.println(oth1.x + " | " + oth2.x);
		
		// System.out.println(oth1.y + " | " + oth2.y)
		// 작성불가(? 멤버변수y 접근제한자가 private)
		// public으로 선언된 멤버함수를 통해 접근하도록 한다.
		System.out.println(oth1.getY() + " | " + oth2.getY());
	}

}
