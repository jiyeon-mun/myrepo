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
	
	public static void sample8() {
		for(int i=1;i<=9;i++) {
			for(int j=1;j<=9;j++) {
				System.out.println(i+" * "+j+" = "+i*j);
			}
		}
	}
	
	public static void sample9() {
		char star='*';
		for(int i=1;i<=5;i++) {
			for(int j=1;j<=5;j++) {
				System.out.print(star);
			}
			System.out.println();
		}
	}
	
	public static void sample10() {
		int num=1;
		
		for(int i=1;i<=6;i++) {
			for(int j=1;j<=7;j++) {
				System.out.print(num++ +" ");
			}
			System.out.println();
		}
		System.out.print("\n");
		
		for(int i=0;i<6;i++) {
			for(int j=1;j<=7;j++) {
				System.out.print((i*7)+j+" ");
			}
			System.out.print("\n");
		}
	}
	
	public static void sample11() {
		int count=0;
		// ASCII 코드 이용. 대문자 A의 ASCII 값은 65. 영문자는 26글자.
		for(int c=65;c<=(65+26-1);c++) {
			System.out.print((char)c+" ");
			count+=1;
			if(count%6==0) {
				System.out.print("\n");
			}
		}
		System.out.print("\n");
		
		int code=65;
		
		for(int i=0;i<5;i++) {
			for(int j=1;j<=6;j++) {
				System.out.print((char)code+" ");
				code++;
				if(code>'Z') {
					break;
				}
			}
			System.out.print("\n");
		}
	}
	
	public static void main(String[] args) {
		// sample1();
		// sample3();
		// sample4();
		// sample6();
		// sample7();
		// sample8();
		// sample9();
		// sample10();
		sample11();
	}

}
