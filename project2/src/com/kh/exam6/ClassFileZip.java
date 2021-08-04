package com.kh.exam6;
//0804 클래스 실습예제

// public 접근제한자로 다른 패키지의 클래스에 접근가능.
import com.kh.exam6.member.*;
import com.kh.exam6.product.*;
import com.kh.exam6.shape.*;

//class Member {
//	private String memberId="sce9853";
//	private String memberPwd="******";
//	private String memberName="nick";
//	private int age=24;
//	private char gender='f';
//	private String phone="01012345678";
//	private String email="@@@@@@@";
//	
//	public Member() {} // 기본생성자
//	
//	public void changeName(String name) {
//		memberName=name;
//	}
//	public void printName() {
//		System.out.println(memberId+"\n"+memberPwd+"\n"+memberName+"\n"
//				+age+"\n"+gender+"\n"+phone+"\n"+email);
//	}
//	
//}
//
//class Product {
//	
//	private String pName = "키보드";
//	private int price = 25000;
//	private String band = "OXOX";
//	
//	public Product() {}
//	
//	public void info() {
//		System.out.println(pName+"\n"+price+"\n"+band);
//	}
//}
//
//class Circle {
//	private double pi = 3.14;
//	private int radius = 1;
//	
//	public Circle() {}
//	
//	public void incrementRadius() {
//		// 반지름 1증가
//		radius++;
//		//System.out.println("반지름: "+radius);
//		getAreaOfCircle();
//		getSizeOfCircle();
//	}
//	public void getAreaOfCircle() {
//		// 원의 넓이: 반지름*반지름*3.14(PI)
//		System.out.println("원의 넓이: "+radius*radius*pi);
//	}
//	public void getSizeOfCircle() {
//		// 원의 둘레: 2*3.14(PI)*반지름
//		System.out.println("원의 둘레: "+2*radius*pi);
//	}
//
//}

public class ClassFileZip {

	public static void main(String[] args) {
		
		Member m = new Member();
		m.changeName("moon");
		m.printName();
		
		System.out.println();
		
		Circle c = new Circle();
		c.getAreaOfCircle();
		c.getSizeOfCircle();
		c.incrementRadius();
		
		System.out.println();
		
		Product p = new Product();
		p.info();

	}

}
