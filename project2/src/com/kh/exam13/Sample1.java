package com.kh.exam13;

public class Sample1 {
	
	public static void main(String[] args) {
		/*
		 * 다형성
		 * (객체배열): 하나의 부모클래스 타입의 배열공간에 여러 종류의 자식클래스 객체 저장
		 * 컴파일시점에서는 부모객체를 다루나 런타임시점에서는 자식을 다룸
		 */
		Shape[] s1 = new Shape[3];
		s1[0] = new Triangle(10,20);
		s1[1] = new Square(20,20);
		s1[2] = new Circle(10);
		
		// 부모클래스 이용해 생성한 객체배열 각 인덱스에 자식클래스 저장
		// 부모클래스 객체 이용해 메서드에 접근하므로
		// Circle 자식클래스의 자체생성변수인 radius와 관련된 setter() 메서드를 사용할 수 없다.
		s1[0].setWidth(15);
		s1[1].setWidth(25);
		s1[2].setWidth(25);
		System.out.println(s1[0].getWidth()+"|"+s1[1].getWidth()+"|"+s1[2].getWidth());
		
		/*
		 * 다운캐스팅
		 * : 부모클래스 인덱스로 자식클래스에서 새롭게 생성한 멤버변수 접근
		 * 
		 * s1[2].setRadius(25); 사용불가
		 * ? 부모클래스는 상속받은 자식클래스에서 새롭게 생성한 멤버변수, 메서드에 대해 알지 못함
		 */
		((Circle)s1[2]).setRadius(35);
		System.out.println(s1[0].getWidth()+"|"+s1[1].getWidth()+"|"+((Circle)s1[2]).getRadius());
		
		/*
		 * instanceof 연산자
		 * 부모객체배열변수 s에 대해 Circle클래스 타입일 때 
		 * true이면 다운캐스팅하여 radius값 출력
		 * false이면 부모클래스의 setWidth() 메서드를 상속받아 width값 출력
		 */
		for(Shape s:s1) {
			if(s instanceof Circle) {
				((Circle)s).setRadius(0);
				System.out.println(((Circle)s).getRadius()+" Circle클래스");
			} else {
				s.setWidth(45);
				System.out.println(s.getWidth()+" not Circle클래스");
			}
		}
		
		System.out.println("==========================");
		// 배열의 길이가 7인 Shape[] 객체 배열을 생성
		// 삼각형, 사각형, 원 객체가 번갈아가며, 순차적으로 저장되도록 한다.
		// 삼각형, 사각형의 경우 너비, 높이가 각 객체에 저장 후 넓이를 출력한다.
		// 원의 경우 반지름을 각 객체에 저장 후 넓이와 PI 값을 출력
		// 너비, 높이, 반지름은 반복문이 반복할 때 마다 3씩 증가하면서 커진 값이 사용되도록 한다.
		Shape[] shapes = new Shape[7];

		for (int i = 0; i < shapes.length; i++) {
			int val = (i + 1) + (i * 3); // 너비, 높이, 반지름
			if (i % 3 == 0) {
				shapes[i] = new Triangle(val, val);
			} else if (i % 3 == 1) {
				shapes[i] = new Square(val, val);
			} else if (i % 3 == 2) {
				shapes[i] = new Circle(val);
			}
		}
		
		for (Shape s : shapes) {
			if(s instanceof Circle) {
				Circle c = (Circle) s; // 다운캐스팅
				System.out.println(c.getArea()+"|"+c.getPI());
			} else {
				System.out.println(s.getArea());
			}
		}		
	}

}
