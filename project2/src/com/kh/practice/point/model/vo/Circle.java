package com.kh.practice.point.model.vo;

public class Circle extends Point {
	private int radius;
	
	public Circle() {}
	public Circle(int x, int y, int radius) {
		super(x,y); // 부모생성자 호출
		this.radius=radius;
	}
	
	public int getRadius() {
		return radius;
	}
	public void setRadius(int radius) {
		this.radius = radius;
	}
	
	@Override
	public String toString() {
		return "Circle [radius=" + this.radius + ", getX()=" + this.getX() + ", getY()=" + this.getY() + "]";
	}	
}