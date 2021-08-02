package com.kh.exam8;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayData {

	static Scanner sc = new Scanner(System.in);
	
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

	public static void sample6() {
		int[] iArr1= new int[] {1,2,3,4};
		
		System.out.println("-----배열 복사(얕은 복사)-----");
		
		int[] iArr2=iArr1;
		for (int i = 0; i < iArr1.length; i++) {
			System.out.println("iArr1[" + i + "]:" + iArr1[i] + "|iArr2[" + i + "]:" + iArr2[i]);
		}
		
		System.out.println("-----배열 복사 후 값 변경-----");
		
		// 동일한 참조값으로 변경하기 때문에 iArr1, iArr2 모두 변경됨
		iArr1[0]=15; // iArr2 배열의 값도 변경됨
		iArr2[3]=25; // iArr1 배열의 값도 변경됨
		for (int i = 0; i < iArr1.length; i++) {
			System.out.println("iArr1[" + i + "]:" + iArr1[i] + "|iArr2[" + i + "]:" + iArr2[i]);
		}
		
		System.out.println("-----참조값 확인-----");
		// 동일한 참조값을 갖는다. 그렇기때문에 각 배열 값 변경 시 다른 배열도 함께 변경된다.
		System.out.println("iArr1 참조값 : "+iArr1); // 출력 시 나오는 값은 실제 주소가 아님.
		System.out.println("iArr2 참조값 : "+iArr2);
	}
	
	public static void sample7() {
		int[] iArr1 = new int[] { 1, 2, 3, 4 };
		int[] iArr2 = new int[iArr1.length];
		
		System.out.println("-----배열 복사(깊은 복사)-----");
		for(int i=0;i<iArr1.length;i++) {
			iArr2[i]=iArr1[i]; // 값만 복사되며, 참조값은 서로 다름.
		}
		for(int i=0;i<iArr1.length;i++) {
			System.out.println("iArr1[" + i + "]:" + iArr1[i] + "|iArr2[" + i + "]:" + iArr2[i]);
		}
		
		System.out.println("-----배열 복사 후 값 변경-----");
		// 원하는 배열에 대해 원하는 요소의 값만 변경됨. 참조값이 서로 다르기 때문에
		iArr1[0]=15; 
		iArr2[3]=25;
		for(int i=0;i<iArr1.length;i++) {
			System.out.println("iArr1[" + i + "]:" + iArr1[i] + "|iArr2[" + i + "]:" + iArr2[i]);
		}
		
		System.out.println("-----참조값 확인-----");
		System.out.println("iArr1 참조값 : "+iArr1);
		System.out.println("iArr2 참조값 : "+iArr2);
	}
	
	public static void sample8() {
		// 깊은 복사를 사용하여 배열의 크기 늘리기.
		int[] iArr1 = new int[] { 1, 2, 3, 4 };
		
		System.out.println("-----배열 크기 늘리기 전-----");
		for(int i=0;i<iArr1.length;i++) {
			System.out.println("iArr1[" + i + "]:" + iArr1[i]);
		}
		
		System.out.println();
		
		int[] iArr2 = new int[iArr1.length+1]; // iArr2 배열의 크기는 iArr1 배열의 크기+1
		for(int i=0;i<iArr1.length;i++) {
			iArr2[i]=iArr1[i]; 
			//System.out.println("iArr2[" + i + "]:" + iArr2[i]);
		}
		//System.out.println(Arrays.toString(iArr2)); // [1,2,3,4,0]
		
		System.out.println();
		
		iArr1=iArr2; // 얕은 복사 활용하여 배열 크기 늘리기.
		// System.out.println(Arrays.toString(iArr1)); // [1,2,3,4,0]
		
		iArr1[iArr2.length-1]=5; // 마지막 index(iArr[3])에 값 5 저장
		
		System.out.println("-----배열 크기 늘린 후-----");
		for(int i=0;i<iArr1.length;i++) {
			System.out.println("iArr1[" + i + "]:" + iArr1[i]);
		}
	}
	
	public static void sample10() {
		int num;
		int[] iArr = new int[0];
		int sum=0;
		
		while(true) {
			System.out.println("1 ~ 49 사이의 정수 값을 입력해주세요.(-1 입력하면 종료)");
			System.out.print(": ");
			num = sc.nextInt(); sc.nextLine();
			
			if(num!=-1) {
				int[] copyNum = new int[iArr.length + 1];
				
				// 새로운 배열에 기존 배열 값 복사
				System.arraycopy(iArr,	 0, 		copyNum, 0, 		iArr.length); 
							// 원본배열명, 원본복사위치, 복사본배열명, 복사본복사위치, 복사할길이(원본배열길이)
//				for(int i=0;i<iArr.length;i++) {
//					copyNum[i]=iArr[i]; // 값 복사
//				}
				iArr=copyNum;
				System.out.println("copyNum[]: " + Arrays.toString(copyNum));
				// 새로운 배열에 기존 배열의 데이터 값들이 복사. 추가된 +1의 자리엔 0값으로 초기화됨.
				
				iArr[iArr.length-1]=num;
				sum+=num; // 입력값들 반복해서 덧셈
				System.out.println("iArr[]: " + Arrays.toString(iArr)); // 입력값들 배열 내 마지막 index에 저장됨.
			}
			else {
				break;
			}
		}
		System.out.println();
		System.out.println("입력한 정수들의 합은 : " + sum);
	}
	
	public static void main(String[] args) {
		//sample1();
		//sample2();
		//sample3();
		//sample6();
		//sample7();
		//sample8();
		sample10();
	}

}
