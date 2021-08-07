package com.kh.exam08;

import java.util.Arrays;

public class Sample1 {
	
	public static void example1() {
		Prac1 p = new Prac1();
		
		p.method1();
		p.method2(true);
		p.method2(1.123);
		p.method2(2021);
		p.method2("hello");
		
		int[] x = { 1, 2, 3, 4 };
		p.method2(x); 
		// 배열명: 배열 시작주소=배열의 첫번째 원소의 주소
		// 즉, 참조주소를 전달하게 됨으로써 x[]와 iArr[]의 참조주소가 동일해진다.
		System.out.println("method2 동적! 전달받은 매개변수 -> "+Arrays.toString(x));
		
		p.method2(false, 123, 2.457);
		
		double[] y = { 1.1, 2.2, 3.3 };
		p.method3(x, y);
		
		p.method4();
		p.method4(1);
		p.method4(1, 2);
		p.method4(1, 2, 3, 4, 5);
		// 가변인자 매개변수: 정수값으로 매개변수 전달하면 결과로 배열이 만들어진다.
		
		MyData d = new MyData();
		p.method5(d);
		System.out.println(d.name+"|"+d.num+"|"+Arrays.toString(d.arr));
		
		p.method5(new MyData());
	}
	
	public static void example2() {
		Prac2 p = new Prac2();
		
		System.out.println(p.method1());
		System.out.println(p.method1(5));
		System.out.println(p.method1(1.234));
		
		System.out.println(p.method2(10)+"|"+p.method2(11));
		
		int[] a=p.method3(5);
		System.out.println(a+"|"+a.length+"|"+Arrays.toString(a)); // 참조주소|배열크기|배열 출력
		
		int[] b = p.method3(5, 10);
		System.out.println(b+"|"+b.length+"|"+Arrays.toString(b));
		
	}

	public static void main(String[] args) {
		//example1();
		example2();
	}	

}
