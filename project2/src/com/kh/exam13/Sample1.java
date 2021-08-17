package com.kh.exam13;

public class Sample1 {
	
	public static void main(String[] args) {
		Square[] sArr =  new Square[2];
		sArr[0] = new Square(10,20);	sArr[1] = new Square(20,20);
		System.out.println(sArr[0].getArea()+" | "+sArr[1].getArea());
		
		Triangle[] tArr = new Triangle[2];
		tArr[0] = new Triangle(10,20);	tArr[1] = new Triangle(20,20);
		System.out.println(tArr[0].getArea()+" | "+tArr[1].getArea());
		
		/*
		 * 다형성
		 * (객체배열): 하나의 부모클래스 타입의 배열공간에 여러 종류의 자식클래스 객체 저장
		 */
		Shape[] s1 = new Shape[2];
		s1[0] = new Triangle(10,20);	s1[1] = new Square(10,20);
	}

}
