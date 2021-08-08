package com.kh.exam7;

import java.util.Scanner;

public class PracFOR {

	static Scanner sc=new Scanner(System.in);
	
	public static void ex1() {
		/*
		 * 정수값을 입력받아 1 부터 입력받은 값까지 1씩 증가된 값을 출력하는
		 * 코드를 작성한다.
		 * 
		 * 예)
		 * 		정수 입력 : 3
		 * 		1
		 * 		2
		 * 		3
		 */
		int num;
		
		System.out.println("정수값을 입력해주세요.");
		System.out.print(": ");
		num=sc.nextInt();	sc.nextLine();
		
		// for문
		for(int i=1;i<=num;i++) {
			System.out.println(i);
		}
		
		// while문
		int i=1;
		while(i<=num){
			System.out.println(i);
			i++;
		}
	}
	
	public static void ex2() {
		/*
		 * 정수값을 입력받고 입력받은 값부터 1씩 감소된 값을 출력하는 코드를 작성한다.
		 * 
		 * 예)
		 * 		정수 입력 : 3
		 * 		3
		 * 		2
		 * 		1
		 */
		int num;
		
		System.out.println("정수값을 입력해주세요.");
		System.out.print(": ");
		num=sc.nextInt();	sc.nextLine();
		
		// for문
		for(int i=num;i>=1;i--) {
			System.out.println(i);
		}
		
		// while문
		int i=num;
		while(i>=1){
			System.out.println(i);
			i--;
		}
	}
	
	public static void ex3() {
		/*
		 * 정수값을 입력받을 때 지정된 범위의 입력값이 아닌 경우 최대 3번 다시
		 * 입력 받을 수 있도록하는 코드를 작성한다.
		 * (지정된 범위는 1 ~ 100 사이의 값이다.)
		 */
		int num;

		// 정수 입력 기회 최대 3번까지
		for(int i = 1; i <= 3; i++) {
			System.out.print("정수 입력 : ");
			num = sc.nextInt();	sc.nextLine();
			
			// 입력 정수값이 범위 내인 경우
			if(num >= 1 && num <= 100) {
				System.out.println("정상적으로 입력하였습니다.");
				break; // 반복문 탈출하며 프로그램 종료
			}
			// 입력 정수값이 범위 내가 아닌 경우
			else {
				// 힌트출력 최대 2번까지, 3번째에는 프로그램 종료 (? 정수 입력 기회가 최대 3번까지이므로)
				if(i != 3) {
					System.out.println("다시 입력하세요. 1 ~ 100 까지 만 입력해야 합니다.");
				} else {
					System.out.println("주어진 기회를 모두 소모하였습니다.");
				}
			}
		}
	}
	
	public static void ex4() {
		/*
		 * ex1() 처럼 동작하는 코드를 작성한다. 단, 출력 메시지는 다음과 같이 나오도록 한다.
		 * 
		 * 예)
		 * 		정수 입력 : 3
		 * 		1 2 3 
		 */
		int num;
		
		System.out.println("정수값을 입력해주세요.");
		System.out.print(": ");
		num=sc.nextInt();	sc.nextLine();
		
		for(int i=1;i<=num;i++) {
			System.out.printf("%d ",i);
		}
	}
	
	public static void ex5() {
		/*
		 * ex4() 처럼 동작하는 코드를 작성한다. 단, 1 부터 시작하는 값이 아닌 100 부터 시작하는
		 * 형태로 나오게 한다.
		 * 
		 * 예)
		 * 		정수 입력 : 3
		 * 		100 101 102
		 */
		int num;
		
		System.out.println("정수값을 입력해주세요.");
		System.out.print(": ");
		num=sc.nextInt();	sc.nextLine();
		
		for(int i=1;i<=num;i++) {
			System.out.printf("%d ",100+i);
		}
		System.out.println();
		for(int i = 100; i < 100 + num; i++) {
			System.out.print(i+" ");
		}
	}
	
	public static void ex6() {
		/*
		 * 정수값을 입력받아 1 부터 입력받은 값까지 1씩 증가된 값을 누적하여 합을 구하는 코드를
		 * 작성한다.
		 * 
		 * 예 1.)
		 * 		정수 입력 : 3
		 * 		누적합 : 6
		 * 
		 * 예 2.)
		 * 		정수 입력 : 5
		 * 		누적합 : 15
		 * 
		 * 예 3.)
		 * 		정수 입력 : 10
		 * 		누적합 : 55
		 */
		int num;
		int sum=0;
		
		System.out.println("정수값을 입력해주세요.");
		System.out.print(": ");
		num=sc.nextInt();	sc.nextLine();
		
		for(int i=1;i<=num;i++) {
			// System.out.printf("%d ",i); // i값 변천사
			sum+=i;
		}
		System.out.printf("\n");
		System.out.println("누적합 : "+sum);
	}
	
	public static void ex7() {
		/*
		 * 정수값을 입력받아 1 부터 입력받은 값까지 출력을 하는 코드를 작성한다. 단, 3의 배수에
		 * 해당하는 값만을 출력하도록 한다.
		 * 
		 * 예)
		 * 		정수 입력 : 10
		 * 		3 6 9
		 */
		int num;
		
		System.out.print("정수 입력 : ");
		num=sc.nextInt(); sc.nextLine();
		
		// 풀이(1). 3부터 3씩 더함으로써 3의 배수 출력
		for(int i=3;i<=num;) {
			System.out.printf("%d ",i);
			i+=3; // 증감식을 for문 {}내로 빼는 경우
		}
		for (int i = 3; i <= num; i += 3) { // 증감식을 for문 ()에 넣는 경우
			System.out.printf("%d ",i);
		}
		
		// 풀이(2). 1부터 증가하는 i값을 3으로 나눴을 때 나머지가 0인 조건에 대해 3의 배수 출력
		for(int i=1;i<=num;i++){
			if(i%3==0){
				System.out.print(i+" ");
			}
		}
	}
	
	public static void ex8() {
		/*
		 * 사용자가 입력한 문자열을 기반으로 파일명이 자동으로 생성되는 프로그램을 만들려고 한다.
		 * 다음의 요구 사항을 파악하여 사용자가 원하는 기능이 동작하도록 코드를 작성하시오.
		 * 
		 * 1. 임의의 파일명을 입력할 수 있어야 한다.
		 * 2. 파일은 1개를 생성할 수도 있지만 원하는 경우 2개 이상도 생성할 수 있다.
		 * 3. 만약 2개 이상의 파일을 생성하는 경우 2번째 파일 부터는 파일명 뒤에 "[2]" 접미사가 붙는다.
		 * 4. 3번 요구사항의 접미사 숫자값은 2 로 고정하는 것이 아니라 파일 수에 맞추어 1씩 증가해야 한다.
		 * 
		 * 예 1.)
		 * 		파일명 입력 : newFile
		 * 		생성 파일수 : 1
		 * 		결과
		 * 			newFile 생성 완료!
		 * 
		 * 예 2.)
		 * 		파일명 입력 : newFile
		 * 		생성 파일수 : 3
		 * 		결과
		 * 			newFile 생성 완료!
		 * 			newFile[2] 생성 완료!
		 * 			newFile[3] 생성 완료!
		 */
		String fname;
		int fnum;
		
		System.out.print("파일명 입력 : ");
		fname=sc.nextLine();
		System.out.print("생성 파일 수 : ");
		fnum=sc.nextInt(); sc.nextLine();
		System.out.println("결과");
		
		for(int i=1;i<=fnum;i++) {
			// 파일생성수가 1일 때는 "파일명 생성 완료!"
			if(i==1) {
				System.out.printf("\t%s 생성 완료!\n",fname);
			}
			// 파일생성수가 2개이상에 대해서 2번째 파일부터는 "파일명[2] 생성 완료!"...
			else {
				System.out.printf("\t%s[%d] 생성 완료!\n",fname,i);
			}
		}
		
		String text=""; // 출력문을 계속해서 문자열을 더해가면서 출력
		// 파일 생성 수에 대해
		// 1번째 생성은 "파일명 생성 완료!"
		if(fnum >= 1) {
			text = text + fname + " 생성 완료!\n";
		}
		// 2번째 생성부터는 "파일명[i] 생성 완료!"
		for(int i = 2; i <= fnum; i++) {
			text = text + fname + "[" + i + "]" + " 생성 완료!\n";
			// 문자열+다른자료형 => 문자열
		}
		System.out.println(text);
	}
	
	public static void ex9() {
		/*
		 * 사칙연산 계산기 프로그램
		 * 간단한 사칙 연산을 수행하는 계산기 프로그램 코드를 작성하시오.
		 * 이 프로그램은 계속 동작이 이루어 지도록 한다. 필요한 경우
		 * 연사자 입력에서 z 를 입력하면 종료가 되도록 한다.
		 * 
		 * 예 1.)
		 * 		숫자 입력1 : 10
		 * 		연산자 입력 : +
		 * 		숫자 입력2 : 20
		 * 		결과
		 * 			10 + 20 = 30
		 * 
		 * 예 2.)
		 * 		숫자 입력1 : 10
		 * 		연산자 입력 : /
		 * 		숫자 입력2 : 20
		 * 		결과
		 * 			10 / 20 = 0.5
		 */
		int num1, num2, res; // res: 정수입력값에 대해서 +,-,*의 정수 결과값
		char op;
		double res1; // res1: 정수입력값의 / 결과에 대한 실수 결과값
		
		// 내 방식
		// 연산자 입력에서 z문자 입력 전까지 프로그램이 계속해서 동작하는 무한반복 프로그램
		for(;;) {
			System.out.print("숫자 입력1 : ");
			num1=sc.nextInt(); sc.nextLine();
			
			System.out.print("연산자 입력 : ");
			// 입력한 문자열에 대해서 0번째 위치의 문자만을 가져온다.
			op=sc.nextLine().charAt(0); 
			
			// z문자 입력 시 무한반복 프로그램이 종료한다.
			if(op=='z') {
				System.out.println("사칙연산 프로그램을 종료 합니다.");	
				break;
			}
			
			// cahrAt(0)으로 가져온 문자가 case 상수값 중 하나일 때 case내 실행문 동작
			// switch문 내 break는 switch문에 대한 강제종료이다. for문과는 관계없다.
			switch(op) {
			case '+':
				System.out.print("숫자 입력2 : ");
				num2=sc.nextInt(); sc.nextLine();
				System.out.println("결과");
				res=num1+num2;
				System.out.printf("\t%d %c %d = %d\n", num1,op,num2,res);
				System.out.println();	break;
			case '-':
				System.out.print("숫자 입력2 : ");
				num2=sc.nextInt(); sc.nextLine();
				System.out.println("결과");
				res=num1-num2;
				System.out.printf("\t%d %c %d = %d\n", num1,op,num2,res);
				System.out.println();	break;
			case '*':
				System.out.print("숫자 입력2 : ");
				num2=sc.nextInt(); sc.nextLine();
				System.out.println("결과");
				res=num1*num2;
				System.out.printf("\t%d %c %d = %d\n", num1,op,num2,res);
				System.out.println();	break;
			case '/':
				System.out.print("숫자 입력2 : ");
				num2=sc.nextInt(); sc.nextLine();
				System.out.println("결과");
				res1=(double)num1/num2;
				System.out.printf("\t%d %c %d = %.2f\n", num1,op,num2,res1);
				System.out.println();	break;
			
			// default문: case 상수값 외 다른 입력값들에 대해서 처리한다.
			// default문은 break;가 없어도 switch문을 종료하고 다시 반복문으로 돌아간다. 
			default:
				System.out.println("잘못된 연산자입니다.");
				System.out.println();
			}
		}
		
		/*
		 * 강사님 방식
		 * 이중for문; 무한반복 안에 무한반복
		 * 두 번째 for문은 숫자입력1란에 Scanner객체 입력값이 정수인 경우에만 break로 탈출 후 다음 연산자 입력이 실행됨
		 * 정수가 아닌 경우 다시 두 번째 for문 상단으로 돌아간다.
		*/
		// 프로그램 전체에 대한 무한반복으로 연산자에 z문자 입력전까지 사칙연산 프로그램을 반복한다.
		for(;;) {
			// 처음 정수입력란의 Scanner객체 입력이 정수인 경우인지 아닌지 판별하여 재입력 여부를 반복한다.
			for(;;) {
				System.out.print("숫자 입력 1 : ");
				
				// if문 사용해서 Scanner객체 입력값이 정수인 경우 break로 두 번째 for문 탈출 후
				// 처음 for문의 수행될 문장인 "연산자 입력: "으로 넘어간다.
				if(sc.hasNextInt()) { 
					num1 = sc.nextInt();	sc.nextLine();
					break;
				}
				// 입려값이 정수가 아니면 다시 두 번째 for문으로 돌아간다.
				else {
					System.out.println("정수로만 입력하세요.");
					sc.nextLine();	// 잘못 입력한 내용을 버퍼에서 제거하기 위해 사용.
				}
			}
			
			System.out.print("연산자 입력 : ");
			op = sc.nextLine().charAt(0);
			
			if(op == 'z') {
				System.out.println("사칙연산 프로그램을 종료 합니다.");
				break;
			}
			
			System.out.print("숫자 입력 2 : ");
			num2 = sc.nextInt();	sc.nextLine();
			
			switch(op) {
				case '+':
					res = num1 + num2;
					System.out.printf("%d %c %d = %d\n", num1, op, num2, res);
					break;
				case '-':
					res = num1 - num2;
					System.out.printf("%d %c %d = %d\n", num1, op, num2, res);
					break;
				case '*':
					res = num1 * num2;
					System.out.printf("%d %c %d = %d\n", num1, op, num2, res);
					break;
				case '/':
					res1 = (double)num1 / num2;
					System.out.printf("%d %c %d = %.2f\n", num1, op, num2, res1);
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
