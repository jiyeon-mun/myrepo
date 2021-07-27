package com.kh.exam6;

import java.util.Scanner;

public class IFSatement {

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		int a;

		System.out.print("정수값 입력 : ");
		a = sc.nextInt();
		sc.nextLine(); // 정수값 입력식 쓰고 꼭 이 문장을 적자!

		if (a > 10) {
			System.out.println("a에 저장된 값은 10 보다 큼니다.");
		}

		int b;
		System.out.print("정수값 입력 : ");
		b = sc.nextInt();
		sc.nextLine();

		if (b % 5 == 0) {
			System.out.print("b에 저장된 값은 5의 배수입니다.");
		} else {
			System.out.print("b에 저장된 값은 5의 배수가 아닙니다.");
		}

	}

}
