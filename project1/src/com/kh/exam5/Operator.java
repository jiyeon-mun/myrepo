package com.kh.exam5;

public class Operator {

	public static void main(String[] args) {
		// 전위 연산
		int x1 = 10;
		int y1 = ++x1; // +1연산 실행 후 다른 연산 실행 => x1값에 +1연산 실행 후 그 값을 y1에 저장

		System.out.println("전위 연산 결과 : " + y1);

		// 후위 연산
		int x2 = 10;
		int y2 = x2++; // 다른 연산 우선 실행 후 +1 연산 실행 => x2를 y2에 저장 후 x2에 대해서 +1연산 실행

		System.out.println("후위 연산 결과 : " + y2);

		System.out.println("x1 : " + x1 + " | x2 :" + x2);
		System.out.println("y1 : " + y1 + " | y2 :" + y2);

		// 0으로 나누기 계산을 하면 Infinity
		double z6 = 10 / 0.0;
		System.out.println("나머지 결과 : " + z6);

		// 비교 연산. 결과는 항상 boolean; true, false 값
		int a = 10, b = 20;

		boolean c1 = a == b; // 같은지 비교
		boolean c2 = a != b; // 다른지 비교

		System.out.println("a==b -> " + c1);
		System.out.println("a!=b -> " + c2);

		// 문자 비교
		char d1 = 'a';
		boolean d2 = d1 == 'a';
		boolean d3 = d1 == 'b';
		boolean d4 = d1 == 98; // 98은 ASCII 코드 값

		System.out.println("d1=='a' -> " + d2);
		System.out.println("d1=='b' -> " + d3);
		System.out.println("d1==98 -> " + d4);

		// 문자열 비교
		String s1 = "abcd";
		String s2 = new String("abcd");

		// 주소값(참조위치값)이 비교된다! s1, s2는 주소값을 의미
		boolean s3 = s1 == "abcd";
		boolean s4 = s2 == "abcd";

		// 이렇게 비교하지 마세요. 주소와 값 비교에 대한 내용이다.
		System.out.println("s1 == \"abcd\" -> " + s3);
		System.out.println("s2 == \"abcd\" -> " + s4);

		// 문자열 비교는 항상 equals 메서드 사용하기!
		boolean s5 = s2.equals("abcd");
		System.out.println("s2.equals(\"abcd\") -> " + s5);
		
		
	}

}
