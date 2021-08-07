package com.kh.exam09;

public class Prac2 {

	public boolean isEven(int x) {
		int i=x;
		if(i%2==0) {
			return true;
		} 
		return false; // else 생략하고 return 사용가능.
	}
//	public boolean isOdd(int x) {
//		int i=x;
//		if(i%2==1) {
//			return true;
//		} else {
//			return false;
//		}
//	}
	// isOdd는 isEven 결과의 반대값. 정의한 메서드로 결과값 반환 가능하다.
	public boolean isOdd2(int num) {
		return !this.isEven(num);
	}
	
//	public boolean isMulti(int x) {
//		int i=x;
//		if(i%2==0) {
//			return true;
//		} else {
//			return false;
//		}
//	}
	public boolean isMulti2(int num) {
		return this.isEven(num);
	}
	
	public boolean isMulti(int x,int y) {
		if(x%y==0) {
			return true;
		} else {
			return false;
		}
	}
	
	public int max(int x, int y) {
		if(x>y) {
			return x;
		} else {
			return y;
		}
	}
	public int max(int[] x) {
//		System.out.println(Arrays.toString(x)); // 매개변수 배열 출력
		int Max=x[0];
//		System.out.println(Max); // Max로 지정한 초기값 출력
		for(int i=0;i<x.length;i++) {
			if(Max<x[i]) {
				Max=x[i];
			}
		}
		return Max;
	}
	
	public int min(int x, int y) {
		if(x>y) {
			return y;
		} else {
			return x;
		}
	}
	public int min(int[] x) {
		int Min=x[0];
		for(int i=0;i<x.length;i++) {
			if(Min>x[i]) {
				Min=x[i];
			}
		}
		return Min;
	}
}
