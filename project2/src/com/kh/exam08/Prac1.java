package com.kh.exam08;

import java.util.Arrays;

class MyData {
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
		System.out.println("method1 동작!");
	}
	
	// 매개변수가 기본자료형인 메서드
	public void method2(boolean b) {
		System.out.println("method2 동작! 전달받은 매개변수 -> " + b);
	}
	
	// 메서드 오버로딩
	public void method2(int i) {
		System.out.println("method2 동작! 전달받은 매개변수 -> " + i);
	}
	
	public void method2(double d) {
		System.out.println("method2 동작! 전달받은 매개변수 -> " + d);
	}
	
	public void method2(String s) {
		System.out.println("method2 동작! 전달받은 매개변수 -> " + s);
	}
	
	// 매개변수가 배열인 메서드
	public void method2(int[] i) {
		i[0] = 10;
		System.out.println("method2 동작! 전달받은 매개변수 -> "
				+ Arrays.toString(i));
	}
	
	// 매개변수가 2개 이상
	public void method3(boolean b, int i, double d) {
		System.out.println("method3 동작! 전달받은 매개변수 -> "
				+ b + ", " + i + ", " + d);
	}
	
	public void method3(int[] i, double[] d) {
		for(int idx = 0; idx < i.length; idx++) {
			i[idx] = i[idx] + 5;
		}
		for(int idx = 0; idx < d.length; idx++) {
			d[idx] = d[idx] + 5;
		}
		System.out.println("method3 동작! 전달받은 매개변수 -> "
				+ Arrays.toString(i) + ", " + Arrays.toString(d));
	}
	
	// 매개변수가 가변인자인 메서드
	public void method4(int ... x) {
		System.out.println("method4 동작 전달박은 매개변수 -> " + x);
		System.out.println("method4 동작 전달박은 매개변수 -> " + Arrays.toString(x));
	}
	
	// 매개변수가 클래스인 메서드
	public void method5(MyData data) {
		data.name = "홍길동";
		data.num = 30;
		data.arr = new int[] {10, 20, 30};
	}
}