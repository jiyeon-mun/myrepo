package com.kh.exam7;

import java.util.Scanner;

public class PracWHILE {
	
	static Scanner sc = new Scanner(System.in);

	public static void ex1() {
		// ASCII코드 영문자 소문자.(97~122). while문 이용.
		int wnum=97;
		while(wnum<=121) {
			System.out.print((char)wnum+", ");
			wnum++;
		}
		if(wnum=='z') {
			System.out.print((char)wnum);
		}
		System.out.print("\n");
		
		// for문 이용
		int fnum;
		for(fnum=97;fnum<=121;fnum++) {
			System.out.print((char)fnum+", ");
		}
		if(fnum=='z') {
			System.out.print((char)fnum);
		}
		
		
	}
	
	public static void ex2() {
		// ASCII코드 영문자 대문자.(65~90). while문
		int num=90;
		
		while(num>65) {
			System.out.print((char)num+", ");
			num--;
		}
		if(num=='A') {
			System.out.print((char)num);
		}
		System.out.print("\n");
		
		// for문 이용
		int fnum;
		for(fnum=90;fnum>65;fnum--) {
			System.out.print((char)fnum+", ");
		} // fnum=65=A
		if(fnum=='A') {
			System.out.print((char)fnum);
		}
	}
	
	public static void ex3() {
		int num=1;
		
		System.out.print("for문 중첩반복 결과\n");
		for(int i=1;i<=4;i++) {
			for(int j=1;j<=5;j++) {
				System.out.print(num+"\t");
				num++;
			}
			System.out.print("\n");
		}
		
		System.out.print("\n");
		
		System.out.print("while문 중첩반복 결과\n");
		num=1;
		int i=1;
		while(i<=4) {
			int j=1;
			while(j<=5) {
				System.out.print(num+"\t");
				j++;
				num++;
			}
			System.out.print("\n");
			i++;
		}
		
	}
	
	public static void ex4() {
		int num1,num2,num3;
		int count=0;
		
		System.out.print("최소값 : ");
		num1=sc.nextInt(); sc.nextLine();
		System.out.print("최대값 : ");
		num2=sc.nextInt(); sc.nextLine();
		System.out.print("열 수 : ");
		num3=sc.nextInt(); sc.nextLine();
		
		System.out.print("for문 결과\n");
		for(int j=num1;j<=num2;j++) {
			System.out.print(j+"\t");
			count+=1;
			if(count%num3==0) {
				System.out.print("\n");
			}
		}
		System.out.print("\n");
		System.out.print("\n");
		
		System.out.print("while문 결과\n");
		int i=num1;
		while(i<=num2) {
			System.out.print(i+"\t");
			count+=1;
			i++;
			if(count%num3==1) {
			System.out.print("\n");
			}
		}
		
	}
	
	public static void ex5() {
		int num; // 입력받는 배수 값
		int count; // 100 ~ 999 범위 내 '입력받은 배수 값' 배수 존재 개수
		int lnum; // 100 미만 중 '입력받은 배수 값'의 최대 배수 값
		
		System.out.print("배수 값 : ");
		num=sc.nextInt(); sc.nextLine();
		
		count=999/num-100/num;
		lnum=100/num*num;
		
		System.out.print("for문 결과\n");
		for(int i=1;i<=count;i++) {
			System.out.print(lnum+num*i+" ");
			if(i%5==0) {
				System.out.print("\n");
			}
		}
		System.out.print("\n");
		System.out.print("\n");
		
		System.out.print("while문 결과\n");
		int j=1;
		while(j<=count) {
			System.out.print(lnum+num*j+" ");
			j++;
			if(j%5==1) {
				System.out.print("\n");
			}
		}

	}
	
	public static void ex6() {
		String str;
		int len;
		int count=0;
		
		System.out.print("String text = ");
		str=sc.nextLine();
		len=str.length();
		
		System.out.print("while문 결과\n");
		int j=0;
		while(j<len) {
			switch(str.charAt(j)) { // a,e,i,o,u와 비교 하여 있으면 count 1씩 증가
			case 'a':
				count+=1; System.out.println(count+" a"); break; // 하나의 위치에 대한 문자 비교 후 break. 다음 위치의 문자로
			case 'e':
				count+=1; System.out.println(count+" e"); break;
			case 'i':
				count+=1; System.out.println(count+" i"); break;
			case 'o':
				count+=1; System.out.println(count+" o"); break;
			case 'u':
				count+=1; System.out.println(count+" u"); break;
			}
			j++;
		}
		System.out.println("문자열 내 \'a, e, i, o, u\' 개수는 "+count+" 입니다.");
		
		System.out.print("\n");
		
		System.out.print("for문 결과\n");
		count=0; // while문 for문 결과 동시 비교로 인해 초기화 한다.
		for(int i=0;i<len;i++) { // 문자 위치 한 개씩 
			switch(str.charAt(i)) { // a,e,i,o,u와 비교 하여 있으면 count 1씩 증가
			case 'a':
				count+=1; System.out.println(count+" a"); break; // 하나의 위치에 대한 문자 비교 후 break. 다음 위치의 문자로
			case 'e':
				count+=1; System.out.println(count+" e"); break;
			case 'i':
				count+=1; System.out.println(count+" i"); break;
			case 'o':
				count+=1; System.out.println(count+" o"); break;
			case 'u':
				count+=1; System.out.println(count+" u"); break;
			}
		}
		System.out.println("문자열 내 \'a, e, i, o, u\' 개수는 "+count+" 입니다.");
		
		
		
	}
	
	public static void main(String[] args) {
		//ex1();
		//ex2();
		ex3();
		//ex4();
		//ex5();
		//ex6();

	}

}
