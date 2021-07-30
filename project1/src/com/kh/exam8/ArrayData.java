package com.kh.exam8;

public class ArrayData {

	public static void sample1() {
		int[] iArr = new int[5];

		System.out.println(iArr); // 출력문에 '배열명'만 입력시 배열의 시작주소가 출력됨.

		// 배열 선언 후 초기화하지 않는다면 배열은 자동으로 0으로 초기화된다.
		System.out.println(iArr[0]);
		System.out.println(iArr[1]);
		System.out.println(iArr[2]);
		System.out.println(iArr[3]);
		System.out.println(iArr[4]);
	}

	public static void sample2() {
		int[] iArr = new int[5];
		
		for(int i=0; i<=(iArr.length -1);i++) {
			System.out.println(iArr[i]);
		}
	}

	public static void sample3() {
		// 배열 선언과 동시에 초기화.
		// int[] iArr = {1,2,3,4,5}; 와 동일
		int[] iArr= new int[] {1,2,3,4,5};
		
		for(int i=0; i<=(iArr.length -1);i++) {
			System.out.println(iArr[i]);
		}
	}


	public static void main(String[] args) {
		//sample1();
		//sample2();
		sample3();
	}

}
