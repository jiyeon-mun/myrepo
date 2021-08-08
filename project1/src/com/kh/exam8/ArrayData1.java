package com.kh.exam8;

import java.util.Arrays;

public class ArrayData1 {

	public static void sample1() {
		/*
		 * 2차 배열
		 * 		배열안에 요소가 배열로 구성되어 있는 것을 말한다.(표, 테이블과 같은 구조)
		 */
		int[][] arr = new int[3][4]; //[행][열]
		
		// 배열길이로 접근하자
		for(int i=0;i<arr.length;i++) { // 행: 3; 0,1,2
			for(int j=0;j<arr[i].length;j++) { // 열: 4; 0,1,2,3
				arr[i][j]=i+j;
			}
			// Arrays.toString(배열명): 1차원 배열에 대한 형태 출력
			// 2차원 배열에서는 Arrays.toString(배열명[행])의 형태로 출력해라
			System.out.println("arr["+i+"]:"+Arrays.toString(arr[i]));
		}
	}
	
	public static void sample2() {
		// int[][] arr1 = { { 1, 2, 3 }, { 4, 5, 6 } };
		int[][] arr = new int[][] { { 1, 2, 3 }, { 4, 5, 6 } }; // 2행 3열
		
		for(int i=0;i<arr.length;i++) { // arr.length=2; 2행
			System.out.println(Arrays.toString(arr[i]));
			// 각 행에 대한 요소값 출력 
		}
		
		// 2차원배열에서 Arrays.toString(배열명)은 2차배열 각 행에 대한 참조주소 출력
		// 각 행의 주소가 다르다!
		System.out.println("arr[]:"+Arrays.toString(arr));
	}
	
	public static void sample3() {
		// 2차 배열 복사
		int[][] arr = new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		int[][] arrCopy = new int[3][3];
		
		/*
		 * 얕은복사
		 * 두 배열의 참조값 동일
		 * 하나의 배열 요소값 변경 시 다른 하나의 배열 역시 같은 값으로 변경됨
		 * arrCopy=arr;
		 * System.arraycopy(원본배열명, 원본의 복사시작위치, 새로운배열명, 새배열의 복사값받을위치, 복사할요소길이);
		 * 
		 * 깊은복사
		 * 반복문을 꼭 한 번 작성한 후 반복문 내 
		 * System.arraycopy(); 또는 새배열[i]=기존배열[i].clone(); 작성
		 * 											clone()메서드: 어떤 객체에 대해 똑같은 객체를 복제
		 */

		// 2차배열 깊은복사. 배열크기 증가는 불가.
		for(int i=0;i<arr.length;i++) {
			//System.arraycopy(arr[i], 0, arrCopy[i], 0, arr.length);
			arrCopy[i]=arr[i].clone();
		}
		
		arr[0][1]=20;
		// 기존 배열 요소값 변경해도 깊은복사한 새로운 배열 요소에는 영향을 끼치지 않는다.
		
		System.out.println("-----arrCopy-----");
		System.out.println(Arrays.toString(arrCopy[0])); // [1, 2, 3]
		System.out.println(Arrays.toString(arrCopy[1])); // [4, 5, 6]
		System.out.println(Arrays.toString(arrCopy[2])); // [7, 8, 9]
		
		System.out.println("-----arr-----");
		System.out.println(Arrays.toString(arr[0])); // [1, 20, 3]
		System.out.println(Arrays.toString(arr[1])); // [4, 5, 6]
		System.out.println(Arrays.toString(arr[2])); // [7, 8, 9]
		
		System.out.println("-----참조값 확인-----");
		// 깊은복사로 하였으므로 두 배열의 참조주소가 서로 다르다.
		System.out.println("arr 참조값 : " + arr);
		System.out.println("arrCopy 참조값 : " + arrCopy);
		
	}
	
	public static void sample4() {
		// 가변길이 배열 : 2차배열의 길이가 다르게 구성된 배열
		int[][] arr = new int[3][];
		// 각 행에 대한 배열요소의 개수가 각각 다름
		arr[0] = new int[4];
		arr[1] = new int[3];
		arr[2] = new int[6];
		
		for (int i = 0; i < arr.length; i++) { // 행수 3; 0,1,2
			for (int j = 0; j < arr[i].length; j++) { // 각 행에 대한 열수 4/3/6
				System.out.print(arr[i][j] + ":" + i + "|" + j + "\t");
			}
			System.out.println(); // 하나의 행에 대한 요소 출력 후 개행
		}
		// 2차배열출력은 Arrays.deepToString(배열명)을 이용해라
		// 단, 한 줄 출력으로 결과값이 나옴
		System.out.println(Arrays.deepToString(arr));
	}
	
	public static void sample5() {
		// 2차배열_동적배열
		int[][] arr = new int[3][];
		
		arr[0] = new int[] { 1, 2, 3, 4 };
		arr[1] = new int[] { 5, 6, 7, 8, 9, 10 };
		arr[2] = new int[] { 11, 12, 13 };
		
		int[][] arrCopy = new int[arr.length + 1][];
		// 깊은 복사
		for (int i = 0; i < arr.length; i++) {
			arrCopy[i]=arr[i].clone();
		}
		
		// 얕은복사
		// 기존배열크기 새로운배열크기만큼 증가
		// 하나의 객체를 두 변수가 참조. 동일한 참조주소
		arr=arrCopy; 
		
		arr[arr.length - 1] = new int[] { 14, 15, 16, 17 };
		
		System.out.println(Arrays.deepToString(arr).replace("], [","],\n["));
		// 											replace(기존문자, 바꿀문자)
	}
	
	public static void main(String[] args) {
		//sample1();
		//sample2();
		//sample3();
		//sample4();
		sample5();
	}

}
