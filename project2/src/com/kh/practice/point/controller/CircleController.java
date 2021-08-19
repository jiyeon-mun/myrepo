package com.kh.practice.point.controller;

import com.kh.practice.point.model.vo.Circle;

public class CircleController {
	private Circle c = new Circle();
	
	public String calcArea(int x, int y, int radius) {
		// 전달받은 매개변수를 Circle생성자 인스턴스 c를 이용해 초기화
		c.setX(x);	c.setY(y);	c.setRadius(radius);
		double area = Math.PI * radius * radius;
		return c.toString() + " / " + area;
	}
	
	
	public String calcCircum(int x, int y, int radius) {
		c.setX(x);	c.setY(y);	c.setRadius(radius);
		double area = Math.PI * radius * 2;
		return c.toString() + " / " + area;
	}
}