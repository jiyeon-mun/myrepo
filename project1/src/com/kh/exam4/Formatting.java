package com.kh.exam4;

public class Formatting {

	public static void main(String[] args) {
		int age = 34;
		String name = "홍길동";

		System.out.printf("%s 님의 나이는 %d 입니다.\n", name, age); //printf는 %형식지정자 사용하여 출력
		System.out.println(name + " 님의 나이는 " + age + " 세 입니다.");//print, println은 형식없이 출력

		double temp = 37.8;
		System.out.printf("현재 온도는 %f 도 입니다.\n", temp); // 소수점 아래 6자리까지. 빈 자리 값은 0으로
		System.out.printf("현재 온도는 %.2f 도 입니다.\n", temp); // 소수점 아래 2자리까지. 빈 자리 값은 0
	}

}
