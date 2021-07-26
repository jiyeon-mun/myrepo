package com.kh.exam4;

public class Variable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		boolean b1 = true;
		char c1 = 'a';
		char c2 = 97; // 97이 정수가 아닌 ASCII 코드값으로 인식; char은 문자 하나 취급하는 변수
		short s1 = 125;
		int i1 = 1024;
		long l1 = 4096;
		float f1 = 3.14f;
		String str1 = "기차" + 123 + 45 + "출발"; // 왼쪽 피연산자 2개씩 계산
		String str2 = 123 + 45 + "기차" + "출발"; // 123+45는 정수, 168+기차 는 정수+문자

		System.out.println(c1);
		System.out.println(c2);
		System.out.println(str1);
		System.out.println(str2);
	}

}
