package com.kh.exam13;

public class Triangle extends Shape {
	public Triangle(int width, int height) {
		super(width, height);
	}

	// 오버라이드를 사용하여
	// getArea() 메서드를 재정의
	@Override
	public int getArea() {
		return this.getHeight()*this.getWidth()/2;
		// return super.getArea()/2; 부모클래스 내 해당 메서드가 추상메서드가 아닐 때
	}
}
