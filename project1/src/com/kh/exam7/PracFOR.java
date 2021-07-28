package com.kh.exam7;

import java.util.Scanner;

public class PracFOR {

	static Scanner sc=new Scanner(System.in);
	
	public static void ex1() {
		int num;
		
		System.out.println("정수값을 입력해주세요.");
		System.out.print(": ");
		num=sc.nextInt();	sc.nextLine();
		
		for(int i=1;i<=num;i++) {
			System.out.println(i);
		}
	}
	public static void ex2() {
		int num;
		
		System.out.println("정수값을 입력해주세요.");
		System.out.print(": ");
		num=sc.nextInt();	sc.nextLine();
		
		for(int i=num;i>=1;i--) {
			System.out.println(i);
		}
		
	}
	public static void ex3() {
		int num;
		
		System.out.println("정수값을 입력해주세요.");
		System.out.print(": ");
		num=sc.nextInt();	sc.nextLine();
		if(num>=1&&num<101) {
			System.out.println("지정된 범위 1 ~ 100을 만족하였습니다.");
		} 
		else {
			for(int i=1;i<=3;i++) {
				System.out.println("지정된 범위 1 ~ 100을 만족하지 못하였습니다.");
				System.out.println("정수값을 다시 입력해주세요.");
				System.out.print(": ");	sc.nextLine();
				
				num=sc.nextInt();
				if(num>=1&&num<101) {
					System.out.println("지정된 범위 1 ~ 100을 만족하였습니다.");
					break;
				} 
			}
			// System.out.println("재입력 최대 횟수를 초과합니다.");
		}
	}
	
	public static void ex4() {
		int num;
		
		System.out.println("정수값을 입력해주세요.");
		System.out.print(": ");
		num=sc.nextInt();	sc.nextLine();
		
		for(int i=1;i<=num;i++) {
			System.out.printf("%d ",i);
		}
	}
	
	public static void ex5() {
		int num;
		
		System.out.println("정수값을 입력해주세요.");
		System.out.print(": ");
		num=sc.nextInt();	sc.nextLine();
		
		for(int i=1;i<=num;i++) {
			System.out.printf("%d ",100+i);
		}
	}
	
	public static void ex6() {
		int num;
		int sum=0;
		
		System.out.println("정수값을 입력해주세요.");
		System.out.print(": ");
		num=sc.nextInt();	sc.nextLine();
		
		for(int i=1;i<=num;i++) {
			System.out.printf("%d ",i);
			sum+=i;
		}
		System.out.printf("\n");
		System.out.println("누적합 : "+sum);
	}
	
	public static void ex7() {
		int num;
		
		System.out.print("정수 입력 : ");
		num=sc.nextInt(); sc.nextLine();
		
		for(int i=3;i<=num;) {
			System.out.printf("%d ",i);
			i+=3;
		}
	}
	
	public static void ex8() {
		String fname;
		int fnum;
		
		System.out.print("파일명 입력 : ");
		fname=sc.nextLine();
		
		System.out.print("생성 파일 수 : ");
		fnum=sc.nextInt(); sc.nextLine();
		System.out.println("결과");
		for(int i=1;i<=fnum;i++) {
			if(i==1) {
				System.out.printf("\t%s 생성 완료!\n",fname);
			}
			else {
				System.out.printf("\t%s[%d] 생성 완료!\n",fname,i);
			}
		}
		
	}
	
	public static void ex9() {
		int num1, num2;
		char op;
		double result;
		
		for(;;) {
			System.out.print("숫자 입력1 : ");
			num1=sc.nextInt(); sc.nextLine();
			
			System.out.print("연산자 입력 : ");
			op=sc.nextLine().charAt(0);
			if(op=='z') {break;}
			switch(op) { // switch문 내 break는 switch문에 대한 강제종료이다. for문과는 관계없다.
			case '+':
				System.out.print("숫자 입력2 : ");
				num2=sc.nextInt(); sc.nextLine();
				System.out.println("결과");
				result=num1+num2;
				System.out.printf("\t%d %c %d = %.2f\n", num1,op,num2,result);
				System.out.println();	break;
			case '-':
				System.out.print("숫자 입력2 : ");
				num2=sc.nextInt(); sc.nextLine();
				System.out.println("결과");
				result=num1-num2;
				System.out.printf("\t%d %c %d = %.2f\n", num1,op,num2,result);
				System.out.println();	break;
			case '*':
				System.out.print("숫자 입력2 : ");
				num2=sc.nextInt(); sc.nextLine();
				System.out.println("결과");
				result=num1*num2;
				System.out.printf("\t%d %c %d = %.2f\n", num1,op,num2,result);
				System.out.println();	break;
			case '/':
				System.out.print("숫자 입력2 : ");
				num2=sc.nextInt(); sc.nextLine();
				System.out.println("결과");
				result=(double)num1/num2;
				System.out.printf("\t%d %c %d = %.2f\n", num1,op,num2,result);
				System.out.println();	break;
			default:
				System.out.println("잘못된 연산자입니다.");
				System.out.println();	break;
			}
		}
	} 
	
	public static void main(String[] args) {
		// ex1();
		// ex2();
		// ex3();
		// ex4();
		// ex5();
		// ex6();
		// ex7();
		// ex8();
		ex9();
	}

}
