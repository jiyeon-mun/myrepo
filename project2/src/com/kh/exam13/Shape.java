package com.kh.exam13;

public class Shape {
	private int width;
	private int height;
	
	public Shape(int width, int height) {
		this.width=width;
		this.height=height;
	}
	
	public int getArea() {
		return this.width*this.height;
	}

}
