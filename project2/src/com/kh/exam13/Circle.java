package com.kh.exam13;

public class Circle extends Shape {
	private int radius;
	private double PI = 3.141592;
	
	public Circle(int radius) {
		super(radius, radius);
		this.radius=radius;
	}

	public int getRadius() {
		return radius;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}

	// 오버라이드 사용하여
	// setWidth(), setHeight() 메서드를
	// radius 멤버 변수의 값을 추가 저장하는 것으로 재정의
	@Override
	public void setWidth(int radius) {
		super.setWidth(radius);
		this.radius=radius;
	}

	@Override
	public void setHeight(int radius) {
		super.setHeight(radius);
		this.radius=radius;
	}

	// PI 값에 대한 추가 속성을 정의 후
	// setter/getter 생성.
	public double getPI() {
		return PI;
	}

	public void setPI(double pI) {
		PI = pI;
	}
	
	// 원의넓이: radius*radius*PI
	@Override
	public int getArea() {
		return (int)(this.getHeight()*this.getWidth()*this.PI);
		// return (int)(super.getArea()*this.PI); 부모클래스 내 해당 메서드가 추상메서드가 아닐 때
	}	
}
