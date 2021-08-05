package com.kh.exam9;

import java.util.Arrays;

public class Prac1 {
	
	public void isEven(int x) {
		int i=x;
		if(i%2==0) {
			System.out.println(i+" 짝수: "+"true");
		} else {
			System.out.println(i+" 짝수: "+"false");
		}
	}
	public void isOdd(int x) {
		int i=x;
		if(i%2==1) {
			System.out.println(i+" 홀수: "+"true");
		} else {
			System.out.println(i+" 홀수: "+"false");
		}
	}
	
	public void isMulti(int x) {
		int i=x;
		if(i%2==0) {
			System.out.println(i+" 2의배수: "+"true");
		} else {
			System.out.println(i+" 2의배수: "+"false");
		}
	}
	public void isMulti(int x,int y) {
		if(x%y==0) {
			System.out.println(x+" "+y+"의배수: "+"true");
		} else {
			System.out.println(x+" "+y+"의배수: "+"false");
		}
	}
	
	public void max(int x, int y) {
		if(x>y) {
			System.out.println("max: "+x);
		} else {
			System.out.println("max: "+y);
		}
	}
	public void max(int[] x) {
//		System.out.println(Arrays.toString(x)); // 매개변수 배열 출력
		int Max=x[0];
//		System.out.println(Max); // Max로 지정한 초기값 출력
		for(int i=0;i<x.length;i++) {
			if(Max<x[i]) {
				Max=x[i];
			}
		}
		System.out.println("max: "+Max);
	}
	
	public void min(int x, int y) {
		if(x>y) {
			System.out.println("min: "+y);
		} else {
			System.out.println("min: "+x);
		}
	}
	public void min(int[] x) {
		int Min=x[0];
		for(int i=0;i<x.length;i++) {
			if(Min>x[i]) {
				Min=x[i];
			}
		}
		System.out.println("min: "+Min);
	}
	
	

}
