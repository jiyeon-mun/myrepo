package com.kh.practice.point.model.vo;

public class Rectangle extends Point {
	private float width;
	private float height;
	
	public Rectangle() {}
	public Rectangle(int x, int y, float width, float height) {
		super(x, y);
		this.width = width;
		this.height = height;
	}
	
	public float getWidth() {
		return width;
	}
	public void setWidth(float width) {
		this.width = width;
	}
	public float getHeight() {
		return height;
	}
	public void setHeight(float height) {
		this.height = height;
	}
	
	@Override
	public String toString() {
		return "Rectangle [width=" + this.width + ", height=" + this.height 
				+ ", getX()=" + this.getX() + ", getY()=" + this.getY() + "]";
	}
}