package com.kh.exam4;

import java.util.Scanner;

public class InputScanner {

	// 클래스 변수; 클래스 안 어디에서도 사용 가능
	static Scanner sc = new Scanner(System.in); // 정해진 형식

	// 메인 메서드
	public static void main(String[] args) {
		// 지역변수는 선언된 메서드 내에서만 사용 가능		
		
		System.out.print("당신의 나이를 입력하세요. : ");
		int age;
		age = sc.nextInt(); // 정수입력값만 받음
		
		// nextInt()로 입력받은 정수값 뒤에 \r\n 값이 있어서 이를 처리하기 위해 사용.
		// 입력하지 않으면 Console에 이상값
		sc.nextLine();
		
		System.out.print("당신의 이름를 입력하세요. : ");
		String name;
		name = sc.nextLine();		

		System.out.printf("당신의 나이는 %d 입니다\n", age);
		System.out.printf("당신의 이름은 %s 입니다\n", name);
		
		/*
		System.out.print("당신의 이름를 입력하세요. : ");
		String name;
		name = sc.nextLine();

		System.out.print("당신의 나이를 입력하세요. : ");
		int age;
		age = sc.nextInt(); // 정수입력값만 받음

		System.out.printf("당신의 이름은 %s 입니다\n", name);
		System.out.printf("당신의 나리은 %d 입니다\n", age);*/

	}

}
