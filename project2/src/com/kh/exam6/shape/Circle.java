package com.kh.exam6.shape;

public class Circle {

	private double pi = 3.14;
	private int radius = 1;
	
	public Circle() {}
	
	public void incrementRadius() {
		// 반지름 1증가
		radius++;
		//System.out.println("반지름: "+radius);
		getAreaOfCircle();
		getSizeOfCircle();
	}
	public void getAreaOfCircle() {
		// 원의 넓이: 반지름*반지름*3.14(PI)
		System.out.println("원의 넓이: "+radius*radius*pi);
	}
	public void getSizeOfCircle() {
		// 원의 둘레: 2*3.14(PI)*반지름
		System.out.println("원의 둘레: "+2*radius*pi);
	}
}
