package com.kh.exam10;

class Square {
	public int width;
	public int height;
	
	public Square() {
		this.width = 1;
		this.height = 1;
	}
	
	public Square(int width, int height) {
		this.width = width;
		this.height = height;
	}
	
	public int area() {
		return this.width * this.height;
	}
}


public class Sample1 {

	public static void main(String[] args) {
		/*
		 * 클래스를 사용하여 인스턴스(객체)를 만들고 만들어진 인스턴스를 사용하는 코드를
		 * 보고 해당 코드에 적합한 클래스를 작성해보도록 한다.
		 */
   // 클래스명 객체명 = new 생성자; 객체 생성 및 할당
		Square s = new Square();
		s.width = 100; // Square클래스 내 멤버변수
		s.height = 50; // public 접근제한자로 정의되었기 때문에 외부 클래스에서 인스턴스 이용하여 접근 가능
		
		// 위에서 변경한 width, height 속성으로 넓이 계산을 하여 리턴.
		int area = s.area();
		
		System.out.println("사각형의 너비는 " + s.width + " 입니다.");
		System.out.println("사각형의 높이는 " + s.height + " 입니다.");
		System.out.println("사각형의 넓이는 " + area + " 입니다.");
		
		// Square 클래스의 또 다른 인스턴스 생성 및 할당
		// 2개의 정수형 매개변수를 갖는 생성자 이용
		Square s1 = new Square(10, 20);
		
		System.out.println("사각형의 너비는 " + s1.width + " 입니다.");
		System.out.println("사각형의 높이는 " + s1.height + " 입니다.");
		System.out.println("사각형의 넓이는 " + s1.area() + " 입니다.");
		
	}

}
