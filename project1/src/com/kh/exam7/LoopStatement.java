package com.kh.exam7;

public class LoopStatement {

	public static void sample1() {
		int i;
		for(i=1;i<=5;i++) {
			System.out.println(i+" 번째 반복");
		}
		System.out.println("최종 i의 값은 "+i);
	}
	
	public static void sample3() {
		int i=1;
		for(;i<=5;i++) { // 초기식 생략. 조건식, 증감식도 각각 생략 가능.
			System.out.println(i+" 번째 반복");
		}
	}
	
	public static void sample4() {
		for(int i=1;i<=5;) { // for문 작성시 () 내 증감식 생략의 경우 증감식은 {반복문 내}에 반드시 적어준다. 
			i+=2; // i값 조건식 내에서 2씩 증가. 증감식 숫자 자유설정 가능.
			System.out.println(i+" 번째 반복");
		}
	}
	
	public static void sample6() {
		for(;;) { // 초기식, 조건식, 증감식 모두 생략의 경우 무한반복 한다
			System.out.println("무한 반복!!");
		}
	}
	
	public static void sample7() {
		int i=1; //초기값
		for(;;) { 
			System.out.println(i+" 입니다."); // 실행문
			i++; // 증감식
			if(i>5) { // 조건식
				break; // 반복 강제 종료
			}
		}
	}
	public static void main(String[] args) {
		// sample1();
		// sample3();
		// sample4();
		// sample6();
		sample7();
	}

}
