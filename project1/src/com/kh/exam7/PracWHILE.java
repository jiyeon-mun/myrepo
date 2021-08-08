package com.kh.exam7;


import java.util.Scanner;

public class PracWHILE {
	
	static Scanner sc = new Scanner(System.in);

	public static void ex1() {
		/*
		 * 영문자 소문자 a ~ z 까지 츨력하시오.
		 * ASCII코드 번호 영문자 소문자:97~122
		 * a, b, c, d, e, f, g ... x, y, z
		 */
		System.out.println("For 문으로 출력한 결과");
		for(char c='a';c<='z';c++){
			System.out.print(c);
			if(c!='z'){
				System.out.print(", ");
			}
		}

		System.out.println("\nWhile 문으로 출력한 결과");
		char c='a';
		while(c<'z'){
			System.out.print(c+", "); // a, b, ...y, 
			c++;
		} // c에 대한 후치증가로 c의 값은 z를 가진다.
		if(c=='z'){
			System.out.print(c);
		}
		
		System.out.println("\nDo~While 문으로 출력한 결과");
		c='a';
		do {
			System.out.print(c);
			if(c!='z'){
				System.out.print(", ");
			}
			c++;
		} while(c<='z');
	}
	
	public static void ex2() {
		/*
		 * 영문자 대문자를 역순으로 츨력하시오.
		 * ASCII코드 번호 영문자 대문자:65~90
		 * Z, Y, X, ... D, C, B, A
		 */
		System.out.println("For 문으로 출력한 결과");
		for(char c='Z';c>='A';c--){
			System.out.print(c);
			if(c!='A'){
				System.out.print(", ");
			}
		}
		
		System.out.println("\nWhile 문으로 출력한 결과");
		char c='Z';
		while(c>='A') {
			System.out.print(c);
			if(c!='A'){
				System.out.print(", ");
			}
			c--;
		}
		
		System.out.println("\nDo~While 문으로 출력한 결과");
		c='Z';
		do {
			System.out.print(c);
			if(c!='A'){
				System.out.print(", ");
			}
			c--;
		} while(c>='A');
	}
	
	public static void ex3() {
		/*
		 * 다음과 같은 형식의 출력이 나오도록 하시오.
		 * 
		 * 1	2	3	4	5
		 * 6	7	8	9	10
		 * 11	12	13	14	15
		 * 16	17	18	19	20
		 */
		System.out.println("------중첩반복을 사용하여 출력------");

		System.out.println("For 문으로 출력한 결과");
		int num=1;
		for(int i=0;i<4;i++){ // 4행
			for(int j=0;j<5;j++){ // 5열
				System.out.print((num++)+"\t"); // 후치증가: 출력 후 +1연산 수행
			}
			System.out.println();
		}
		System.out.println("\nWhile 문으로 출력한 결과");
		num=1;
		int i=0;
		while(i<4){ // 4행
			int j=0; // 행별로 5열 리셋
			while(j<5){ // 5열
				System.out.print((num++)+"\t");
				j++;
			}
			System.out.println();
			i++;
		}
		
		System.out.println("\n------중첩반복을 사용하지 않고 출력------");
		
		System.out.println("For 문으로 출력한 결과");
		// 1부터 1씩 증가하여 20까지의 숫자 범위에 대해서
		for(int x=1;x<=20;x++){
			System.out.print(x+"\t");
			// 증가하는 x값이 5의 배수일 때 개행
			// 하나의 행에 5열씪 나열 후 개행
			if(x%5==0){
				System.out.println(); // System.out.print("\n");
			}
		}
		System.out.println("\nWhile 문으로 출력한 결과");
		int x=1;
		while(x<=20) {
			System.out.print(x+"\t");
			if(x%5==0){
				System.out.println();
			}
			x++;
		}
		
	}
	
	public static void ex4() {
		/*
		 * 사용자가 입력한 정수값 범위에 해당하는 값만 출력하시오.
		 * 
		 * 예)
		 * 		최소값 : 11
		 * 		최대값 : 99
		 * 		열 수 : 10
		 * 
		 * 		11	12	13	14	15	16	17	18	19	20
		 * 		21	22	23	24	25	26	27	28	29	30
		 * 		...
		 * 		...
		 * 		91	92	93	94	95	96	97	98	99	
		 */
		int num1,num2,num3;
		int count=0; // num1 ~ num2 사이의 값 출력 시 카운팅 횟수
		
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
		
		count=0; // for문과 공유하기 때문에 초기에 설정한 것처럼 0으로 초기화 해서 while문에서 사용
		
		while(i<=num2) {
			System.out.print(i+"\t");
			count+=1; // 숫자 출력마다 개수 카운팅
			i++;
			if(count==num3) { // 카운팅 수와 열 수가 동일 할 때
				System.out.print("\n"); // 개행
				count=0; // 다시 카운팅 횟수를 0으로 초기화하여 다음 줄에서 다시 1부터 카운트하여 열수와 동일할 때 개행시킴.
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
		while(j<=count) { // 출력되는 값에 대한 위치 지정
			System.out.print(lnum+num*j+" ");
			if(j%5==0) {
				
				System.out.print("\n");
			}
			j++;
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
