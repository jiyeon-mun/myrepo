package com.kh.exam4;

import java.util.Scanner;

public class Prac1 {

	/*
	 * 국어, 영어, 수학 세 과목의 점수를 입력 받아서 총점과 평균을 구하고 출력하는 코드 작성 점수는 반드시 실수형으로 입력받고 총점은 반드시
	 * 정수로 저장 및 출력해라
	 */

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		float ks, es, ms;
		int total;
		float avg;

		System.out.print("국어 점수를 입력하세요 : ");
		ks = sc.nextFloat();
		sc.nextLine();

		System.out.print("영어 점수를 입력하세요 : ");
		es = sc.nextFloat();
		sc.nextLine();

		System.out.print("수학 점수를 입력하세요 : ");
		ms = sc.nextFloat();
		sc.nextLine();

		total = (int) (ks + es + ms);
		avg = (ks + es + ms) / 3;

		// 입력된 실수 값들 다 합한 후 정수형 변환. 소수점 아래 버림
		System.out.printf("점수의 총점은 %d 입니다.\n", total);
		System.out.printf("점수의 평균은 %.2f 입니다.\n", avg);

	}

}
