package com.kh.exam13;

public abstract class Shape {
	private int width;
	private int height;
	
	public Shape(int width, int height) {
		this.width=width;
		this.height=height;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}
	
//	public int getArea() {
//		return this.width*this.height;
//	}

	// 추상메서드
	// 메서드 선언만 하며, 몸체는 존재한지 않음
	// 상속 시 반드시 자식클래스에서 구현해야 하는, 오버라이딩이 강제화된 메서드
	// 메서드에 대한 정의가 자식클래스마다 다 다른 경우 주로 사용
	public abstract int getArea();
}
