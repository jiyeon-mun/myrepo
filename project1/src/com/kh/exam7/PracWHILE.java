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
		
		System.out.print("최소값 : ");
		num1=sc.nextInt(); sc.nextLine();
		System.out.print("최대값 : ");
		num2=sc.nextInt(); sc.nextLine();
		System.out.print("열 수 : ");
		num3=sc.nextInt(); sc.nextLine();
		
		System.out.println("------출력되는 숫자들을 개수를 카운팅하여 개행시킴------");
		
		System.out.print("for문 결과\n");
		int count=0; // num1 ~ num2 사이의 값 출력마다 카운팅한 횟수
		for(int j=num1;j<=num2;j++) {
			System.out.print(j+"\t");
			// 숫자 출력마다 개수 카운팅
			count+=1;
			if(count%num3==0) {
				System.out.print("\n");
			}
		}
		System.out.println("\nWhile 문으로 출력한 결과");
		int i=num1;
		count=0;
		while(i<=num2) {
			System.out.print(i+"\t");
			count+=1;
			i++;
			// 카운팅수와 열수가 동일 할 때 개행을 시킨다.
			// 숫자를 입력한 열수만큼 출력 후 개행
			if(count==num3) { 
				System.out.print("\n");
				// 다시 카운팅 횟수를 0으로 초기화하여 다음 줄(행)에서 다시 1부터 카운트하여 열수와 동일할 때 개행시킴.
				count=0;
			}
		}
		
		System.out.println("\n\n------출력되는 숫자들을 열수만큼 나열 후 개행------");
		// 증가되면서 출력하는 정수들을 나열하면서 증가하는 정수값이 열수값과 동일할 때 개행을 시킨다.
		
		System.out.println("For 문으로 출력한 결과");
		for(int j=num1;j<=num2;j++){
			System.out.print(j+"\t");
			if(j%num3==0){
				System.out.println();
			}
		}
		System.out.println("\nWhile 문으로 출력한 결과");
		int j=num1;
		while(j<=num2){
			System.out.print(j+"\t");
			if(j%num3==0){
				System.out.println();
			}
			j++;
		}
		
	}
	
	public static void ex5() {
		/*
		 * 100 ~ 999 범위에 해당하는 배수 값을 출력한다.
		 * 출력할 배수 값은 사용자 입력을 통해 알아낸다.
		 * 
		 * 예)
		 * 		배수 값 : 13
		 * 		104		117		130		143		156	
		 * 		169		...		
		 * 		...
		 * 		...		...		...		988		
		 */
		int num;

		System.out.print("배수 값: ");
		num=sc.nextInt(); sc.nextLine();

		System.out.print(" for문 결과\n");
		int cnt=0; // 개행을 위한 열수 카운팅 횟수
		for(int i=100;i<1000;i++){
			// 범위 내 배수값 출력마다 열수 카운팅+1
			if(i%num==0){
				System.out.print(i+"\t");
				cnt+=1;
				// 5열마다 개행
				if(cnt%5==0){
					System.out.println();
				}
			}
		}
		System.out.println("\n\n While 문으로 출력한 결과");
		cnt=0;
		int i=100;
		while(i<1000){
			if(i%num==0){
				System.out.print(i+"\t");
				cnt+=1;
				if(cnt%5==0){
					System.out.println();
				}
			}
			i++;
		}
	}
	
	public static void ex6() {
		/*
		 * 사용자로 부터 임의의 문자열을 입력 받은 후
		 * a, e, i, o, u 문자가 얼마나 포함되어 있는지 확인하는 코드를 작성한다.
		 * 
		 * Tip 1.) 사용자가 입력한 문자열의 문자를 탐색하기 위해 .charAt(index) 메서드를
		 * 활용한다.
		 * 		String text = "hello";
		 * 		text.charAt(0); // 'h'
		 * 		text.charAt(1); // 'e'
		 * 		text.charAt(2); // 'l'
		 * 
		 * Tip 2.) 문자열의 길이를 알기 위해 .length() 메서드를 사용한다.
		 * 		String text = "hello";
		 * 		text.length(); // 5
		 */
		String text;
		int cnt=0; // 문자열 내 a,e,i,o,u 존재 개수 카운팅 횟수
		
		System.out.print("문자열 입력 : ");
		text = sc.nextLine();
		int len=text.length();

		System.out.print(" for문 결과\n");
		for(int i=0;i<len;i++){
			// 문자열에서 한글자씩 가져와 a,e,i,o,u가 있는지 비교
			switch(text.charAt(i)){
			// 여러 케이스에 대한 실행할 문장들
			// case 상수값이 a,e,i,o,u에 대해서 아래 실행문들을 모두 수행한다.
			case 'a':
			case 'e':
			case 'i':
			case 'o':
			case 'u':
				cnt += 1;
				System.out.print(text.charAt(i) + " "); // 문자열 내 어떤 a,e,i,o,u가 있는지 확인 출력
				break;
				// 문자열의 i번째 위치에 a,e,i,o,u 중 하나가 발견되면 위의 실행문을 수행하고
				// switch문을 탈출하여 다시 for문으로 돌아간다.
			}
		}
		System.out.println("\n입력한 문자열 내 a, e, i, o, u 문자의 존재 개수: "+cnt);

		System.out.println("\n\n While 문으로 출력한 결과");
		cnt=0;
		int i=0;
		while(i<len){
			switch(text.charAt(i)){
			case 'a':
			case 'e':
			case 'i':
			case 'o':
			case 'u':
				cnt += 1;
				System.out.print(text.charAt(i) + " ");
				break;
			}
			i++;
		}
		System.out.println("\n입력한 문자열 내 a, e, i, o, u 문자의 존재 개수: "+cnt);
	}
	
	public static void main(String[] args) {
		//ex1();
		//ex2();
		//ex3();
		//ex4();
		//ex5();
		ex6();

	}

}
