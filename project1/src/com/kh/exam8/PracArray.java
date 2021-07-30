package com.kh.exam8;

import java.util.Scanner;
import java.util.Arrays;

public class PracArray {
	
	static Scanner sc = new Scanner(System.in);

	public static void ex1() {
		int iArr[] = new int[10];

		for (int i = 1; i <= iArr.length; i++) {
			iArr[i-1]=i;
			System.out.println("iArr[" + (i - 1) + "]" + " : " + i);
		}
		System.out.print(Arrays.toString(iArr)); // 배열 출력
	}

	public static void ex2() {
		int[] iArr = new int[10];
		
		for (int i = 0; i < iArr.length; i++) {
			iArr[i]=2*(i+1);
			System.out.println("iArr[" + i + "]" + " : " + iArr[i]);
		}
		System.out.print(Arrays.toString(iArr));
	}

	public static void ex3() {
		int[] iArr = new int[20];
		int num=99;
		
		for (int i = 0; i < iArr.length; i++) {
			iArr[i]=num;
			System.out.println("iArr[" + i + "]" + " : " + iArr[i]);
			num-=2;
		}
		System.out.print(Arrays.toString(iArr));
	}

	public static void ex4() {
		int[] iArr = new int[26];
		char c='A';
		
		// 영문자 대문자 ASCII코드 번호 65~90.
		for (int i = 0; i < 26; i++) {
			iArr[i]=c++;
			System.out.println("iArr[" + i + "]" + " : " + iArr[i]);
		}
		System.out.print(Arrays.toString(iArr));
		
	}

	public static void ex5() {
		int size;
		int value=100;
		
		System.out.print("생성할 배열 크기 입력 : ");
		size=sc.nextInt(); sc.nextLine();
		int[] iArr = new int[size]; // 입력한 크기를 갖는 정수 배열 생성
		
		for(int i=0;i<size;i++) {
			iArr[i]=value++;
			System.out.println("iArr[" + i + "]" + " : " + iArr[i] );
		}
		System.out.print(Arrays.toString(iArr));
	}

	public static void ex6() {
		int size;
		
		System.out.print("생성할 배열 크기 입력 : ");
		size=sc.nextInt(); sc.nextLine();
		String[] sArr = new String[size]; // 입력한 크기를 갖는 정수 배열 생성
		
	}
	
	public static void ex7() {
	}

	public static void main(String[] args) {
		//ex1();
		//ex2();
		//ex3();
		//ex4();
		ex5();
		//ex6();
		ex7();

	}

}
