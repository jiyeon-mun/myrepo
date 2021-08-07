package com.kh.exam08;

public class Prac2 {
	
	public int method1() {
		return 10;
	}

	public int method1(int x) {
		x+=10;
		return x;
	}
	
	public int method1(double x) {
		int y = 0;
		y = (int) x + 10;
		return y;
	}
	
	public boolean method2(int x) {
		if(x%2==0){
			return true; // return 이후 메서드 종료. 결과 반환하고 호출문으로 돌아간다.
		} else {
			return false;
		}
	}
	
	public int[] method3(int x) {
		int[] arr = new int[x];
		return arr; // 참조주소 반환
	}
	
	public int[] method3(int x, int y) {
		int[] arr = new int[x];
		for(int i=0;i<arr.length;i++) {
			arr[i]=y;
		}
		return arr;
	}

}
