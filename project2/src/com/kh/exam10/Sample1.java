package com.kh.exam10;

class Square {
	int width;
	int height;
	
	// 같은 클래스 내 매개변수가 있는 생성자가 존재하면
	// JVM이 기본생성자를 자동으로 생성해주지 않는다.
	public Square() {} 
	
	public int area() {
		return width*height;
	}
	
	// 매개변수가 있는 생성자
	public Square(int width, int height) {
		this.width = width;
		this.height = height;
	}
	
}

public class Sample1 {

	public static void main(String[] args) {
		Square s = new Square();
		s.width=100;
		s.height=50;
		
		int area=s.area();
		
		System.out.println("사각형 너비: " + s.width);
		System.out.println("사각형 높이: " + s.height);
		System.out.println("사각형 넓이: " + s.area());
		
		Square s1 = new Square(10, 20); // 매개변수가 있는 생성자
		
		System.out.println("사각형 너비: " + s1.width);
		System.out.println("사각형 높이: " + s1.height);
		System.out.println("사각형 넓이: " + s1.area());

	}

}
