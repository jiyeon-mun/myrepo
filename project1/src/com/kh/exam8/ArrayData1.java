package com.kh.exam8;

import java.util.Arrays;

public class ArrayData1 {

	public static void sample1() {
		int[][] arr = new int[3][4];
		
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr[i].length;j++) {
				arr[i][j]=i+j;
			}
			System.out.println("arr["+i+"]:"+Arrays.toString(arr[i]));
		}
	}
	
	public static void sample2() {
		int[][] arr = new int[][] { { 1, 2, 3 }, { 4, 5, 6 } };
		
		for(int i=0;i<arr.length;i++) {
			System.out.println(i+" "+Arrays.toString(arr[i]));
		}
		
		//System.out.println("arr[]:"+Arrays.toString(arr));
	}
	
	public static void sample3() {
		// 2차 배열 복사
		int[][] arr = new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		int[][] arrCopy = new int[3][3];
		
		//arrCopy=arr;
		// 얕은복사: 두 배열의 참조값 동일. 하나의 배열 요소값 변경 시 다른 하나의 배열 역시 같은 값으로 변경
		
		// 2차배열에서는 System.arraycopy(원본배열, 0, 새로운배열, 0, 복사할요소길이);을 이용해도 얕은복사 취급한다.
		// 반복문 꼭 한 번 작성하자!
		// 2차배열 깊은복사. 배열크기 증가는 불가.
		for(int i=0;i<arr.length;i++) {
			//System.arraycopy(arr[i], 0, arrCopy[i], 0, arr.length);
			arrCopy[i]=arr[i].clone(); // clone()메서드: 원본 객체를 새로운 객체레 복제.
		}
		arr[0][1]=20;
		
		System.out.println("-----arrCopy-----");
		System.out.println(Arrays.toString(arrCopy[0]));
		System.out.println(Arrays.toString(arrCopy[1]));
		System.out.println(Arrays.toString(arrCopy[2]));
		
		System.out.println("-----arr-----");
		System.out.println(Arrays.toString(arr[0]));
		System.out.println(Arrays.toString(arr[1]));
		System.out.println(Arrays.toString(arr[2]));
		
	}
	
	public static void sample4() {
		// 가변길이 배열 : 2차배열의 길이가 다르게 구성된 배열
		int[][] arr = new int[3][];
		
		arr[0] = new int[4];
		arr[1] = new int[3];
		arr[2] = new int[6];
		
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j] + ":" + i + "|" + j + "\t");
			}
			System.out.println();
		}
		System.out.println(Arrays.deepToString(arr));
	}
	
	public static void sample5() {
		// 2차배열_동적배열
		int[][] arr = new int[3][];
		
		arr[0] = new int[] { 1, 2, 3, 4 };
		arr[1] = new int[] { 5, 6, 7, 8, 9, 10 };
		arr[2] = new int[] { 11, 12, 13 };
		
		int[][] arrCopy = new int[arr.length + 1][];
		for (int i = 0; i < arr.length; i++) {
			arrCopy[i]=arr[i].clone(); // 깊은 복사
		}
		arr=arrCopy;
		arr[arr.length - 1] = new int[] { 14, 15, 16, 17 };
		
		System.out.println(Arrays.deepToString(arr));
		System.out.println(Arrays.deepToString(arrCopy));
		
		//System.out.println(Arrays.deepToString(arr).replace("], [","],\n["));
		// replace(기존문자, 바꿀문자)
	}
	
	public static void main(String[] args) {
		//sample1();
		//sample2();
		//sample3();
		//sample4();
		sample5();
	}

}
