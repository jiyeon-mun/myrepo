package com.kh.exam08;

class MyData2 {
	public int num;
	public String name;
	public int[] arr;
}

public class Prac2 {
	public int method1() {
		return 10;
	}
	
	public int method1(int x) {
		x = x + 10;
		return x;
	}
	
	public int method1(double x) {
		int y = 0;
		y = (int)x + 10;
		return y;
	}
	
	public boolean method2(int x) {
		if(x % 2 == 0) {
			return true;
		} else {
			return false;
		}
	}
	
	public int[] method3(int x) {
		int[] arr = new int[x];
		return arr;
	}
	
	public int[] method3(int x, int y) {
		int[] arr = new int[x];
		for(int i = 0; i < arr.length; i++) {
			arr[i] = y;
		}
		return arr;
	}
	
	public MyData2 method4() {
		MyData2 rt = new MyData2();
		rt.num = 10;
		rt.name = "홍길동";
		rt.arr = new int[] {1, 2, 3, 4};
		return rt;
	}
	
	public MyData2 method4(String name) {
		MyData2 rt = new MyData2();
		rt.num = 10;
		rt.name = name;
		rt.arr = new int[] {1, 2, 3, 4};
		return rt;
	}
	
}
