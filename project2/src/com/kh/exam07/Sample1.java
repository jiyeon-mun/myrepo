package com.kh.exam07;

class Other {
	public void method() {
		System.out.println("메서드 실행이 잘 되었습니다.");
	}
	
	public static void function() {
		System.out.println("함수 실행이 잘 되었습니다.");
	}
	
	public final void method1() {
		System.out.println("final은 상속 관계에서 오버라이딩을 하지 못하게 한다.");
	}
}

public class Sample1 {
	
	public static void ex1() {
		System.out.println("문제 1.");
	}

	public static void main(String[] args) {
		Other oth = new Other();
		oth.method();
		
		// 다른 클래스의 static으로 정의된 메서드에 접근할 때 별도의 객체 생성없이 접근한다.
		Other.function();
		
		ex1();
		// 자신의 클래스 내 static으로 선언한 메서드이기 때문에
		// 자신의 클래스명은 생략해되 되었던 것
		Sample1.ex1();
	}

}