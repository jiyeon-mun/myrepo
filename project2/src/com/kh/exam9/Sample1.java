package com.kh.exam9;

public class Sample1 {
	
	public static void ex1() {
		Prac1 p = new Prac1();
		
		System.out.println("----짝수/홀수 구분----");
		p.isEven(10);	p.isEven(11);
		p.isOdd(10);	p.isOdd(11);
		
		System.out.println("----배수여부 확인----");
		p.isMulti(10);	p.isMulti(15);
		p.isMulti(10,3);	p.isMulti(15,3);
		p.isMulti(10,5);	p.isMulti(15,3);
		
		System.out.println("----최대값 구하기----");
		p.max(10,20);	p.max(10,5);
		
		int[] arr1= {1,7,9,3,8};
		p.max(arr1);
		
		System.out.println("----최소값 구하기----");
		p.min(10,20);	p.min(10,5);
		
		int[] arr2= {1,7,9,3,8};
		p.min(arr2);
	}

	public static void ex2() {
		Prac2 p = new Prac2();
		
		System.out.println("----짝수/홀수 구분----");
		System.out.println("짝수 "+p.isEven(10));
		System.out.println("짝수 "+p.isEven(11));
		System.out.println("홀수 "+p.isOdd(10));
		System.out.println("홀수 "+p.isOdd(11));
		
		System.out.println("----배수여부 확인----");
		System.out.println("2의배수 "+p.isMulti(10));
		System.out.println("2의배수 "+p.isMulti(15));
		System.out.println("3의배수 "+p.isMulti(10,3));
		System.out.println("3의배수 "+p.isMulti(15,3));
		System.out.println("5의배수 "+p.isMulti(10,5));
		System.out.println("5의배수 "+p.isMulti(15,5));
		
		System.out.println("----최대값 구하기----");
		System.out.println("max: "+p.max(10,20));
		System.out.println("max: "+p.max(10,5));
		
		int[] arr1= {1,7,9,3,8};
		System.out.println("max: "+p.max(arr1));
		
		System.out.println("----최소값 구하기----");
		System.out.println("min: "+p.min(10,20));
		System.out.println("min: "+p.min(10,5));
		
		int[] arr2= {1,7,9,3,8};
		System.out.println("max: "+p.max(arr2));
	}
	
	public static void main(String[] args) {
		//ex1();
		ex2();
	}

}
