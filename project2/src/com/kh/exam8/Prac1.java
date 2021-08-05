package com.kh.exam8;

import java.util.Arrays;

class MyData{
	public int num;
	public String name;
	public int[] arr;
}

public class Prac1 {
	/*
	 * 메소드 매개변수
	 */
	
	// 매개변수가 없는 메서드
	public void method1() {
		System.out.println("method1 동작");
	}
	
	 // 매개변수가 기본자료형인 메서드
	public void method2(boolean b) {
		System.out.println("method2 동적! 전달받은 매개변수 -> "+b);
	}
	
	// 메서드 오버로딩
	public void method2(int i) {
		System.out.println("method2 동적! 전달받은 매개변수 -> "+i);
	}
	public void method2(double d) {
		System.out.println("method2 동적! 전달받은 매개변수 -> "+d);
	}
	public void method2(String s) {
		System.out.println("method2 동적! 전달받은 매개변수 -> "+s);
	}

	// 매개변수가 배열인 메서드
	public void method2(int[] iArr) {
		
		iArr[0]=10; // iArr[]의 요소값 변경
		System.out.println("method2 동적! 전달받은 매개변수 -> "+iArr); // 배열명: 시작주소 출력
		System.out.println("method2 동적! 전달받은 매개변수 -> "+Arrays.toString(iArr)); // 배열요소 출력
	}
	
	// 매개변수가 2개 이상
	public void method2(boolean b, int i, double d) {
		System.out.println("method2 동적! 전달받은 매개변수 -> "+b+", "+i+", "+d);
	}
	
	public void method3(int[] i, double[] d) {
		System.out.println("method2 동적! 전달받은 매개변수 -> "+i+", "+d);
		System.out.println("method2 동적! 전달받은 매개변수 -> "+Arrays.toString(i)+", "+Arrays.toString(d));
	}
	
	// 매개변수가 가변인자인 메서드
	public void method4(int ...x) {
		System.out.println("method4 동작 전달받은 매개변수 -> " + x);
		System.out.println("method4 동작 전달받은 매개변수 -> " + Arrays.toString(x));
	}
	
	// 매개변수가 클래스인 메서드
	public void method5(MyData data) {
		data.name="홍길동";
		data.num=30;
		data.arr = new int[] { 10, 20, 30 };
	}
}
