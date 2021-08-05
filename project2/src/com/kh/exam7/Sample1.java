package com.kh.exam7;

class Other{
	public void method() {
		System.out.println("OUTPUT");
	}
	
	public static void fc() {
		System.out.println("output");
	}
	
	public final void method1() {
		System.out.println("final은 상속관계에서 오버라이딩을 하지 못하게 한다.");
		// 오버라이딩: 덮어쓰기 => final은 한 번 초기화하면 더이상 새로운 값을 정의하지 못하게 한다.
	}
}

public class Sample1 {
	
	public static void ex1() {
		System.out.println("Q1");
	}

	public static void main(String[] args) {
		Other oth = new Other();
		oth.method();
		
		Other.fc(); // 다른 클래스의 static으로 정의된 메서드에 접근할 때 별도의 객체 생성없이 접근한다.
		
		ex1();
		// 같은 클래스 내 static으로 선언한 메서드에 접근.
		// 자신의 클래스 내 정의되었기 때문에 클래스명 생략.

	}

}
