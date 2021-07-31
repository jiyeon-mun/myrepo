package com.kh.exam8;

import java.util.Scanner;
import java.util.Arrays;
import java.util.Random;

public class PracArray {
	
	static Scanner sc = new Scanner(System.in);
	static Random rd = new Random();

	public static void ex1() {
		int iArr[] = new int[10];

		for (int i = 1; i <= iArr.length; i++) {
			iArr[i-1]=i;
			System.out.println("iArr[" + (i - 1) + "]" + " : " + i);
		}
		System.out.print(Arrays.toString(iArr)); // 배열 출력
	}

	public static void ex2() {
		int[] iArr = new int[10];
		
		for (int i = 0; i < iArr.length; i++) {
			iArr[i]=2*(i+1);
			System.out.println("iArr[" + i + "]" + " : " + iArr[i]);
		}
		System.out.print(Arrays.toString(iArr));
	}

	public static void ex3() {
		int[] iArr = new int[20];
		int num=99;
		
		for (int i = 0; i < iArr.length; i++) {
			iArr[i]=num;
			System.out.println("iArr[" + i + "]" + " : " + iArr[i]);
			num-=2;
		}
		System.out.print(Arrays.toString(iArr));
	}

	public static void ex4() {
		int[] iArr = new int[26];
		char c='A';
		
		// 영문자 대문자 ASCII코드 번호 65~90.
		for (int i = 0; i < iArr.length; i++) {
			iArr[i]=c++;
			System.out.println("iArr[" + i + "]" + " : " + (char)iArr[i]);
		}
		System.out.print(Arrays.toString(iArr));		
	}

	public static void ex5() {
		int size;
		int value=100;
		
		System.out.print("생성할 배열 크기 입력 : ");
		size=sc.nextInt(); sc.nextLine();
		int[] iArr = new int[size]; // 입력한 크기를 갖는 정수 배열 생성
		
		for(int i=0;i<size;i++) {
			iArr[i]=value++;
			System.out.println("iArr[" + i + "]" + " : " + iArr[i] );
		}
		System.out.print(Arrays.toString(iArr));
	}

	public static void ex6() {
		int size;
		String text; // 문자열 입력받을 변수를 생성
		
		System.out.print("생성할 배열 크기 입력 : ");
		size=sc.nextInt(); sc.nextLine();
		String[] sArr = new String[size]; // 입력한 크기만큼의 문자열 배열 생성
		
		for(int i=0;i<sArr.length;i++) {
			System.out.print("초기화할 문자열 입력 : ");
			
			// sArr[i]=sc.nextLine(); 문자열 입력받는 변수없이 입력과 동시에 배열에 저장.
			text=sc.nextLine();	// 입력받은 문자열 변수에 저장
			sArr[i]=text; // 변수에 저장한 문자열을 각 배열 요소 위치에 하나씩 저장.
	
			System.out.println("sArr[" + i + "]" + " : " + sArr[i] );
		}
		System.out.print(Arrays.toString(sArr));
		
	}
	
	public static void ex7() {
		int date;
		String[] day= {"수요일","목요일","금요일","토요일","일요일","월요일","화요일"};
		
		for(;;) {
			System.out.println("1 ~ 31일 사이 날짜 입력");
			System.out.print(": ");
			date=sc.nextInt(); sc.nextLine();
			
			if(date>=1&&date<32) {
				System.out.println(": "+day[date%7]+"\n");
			}else {
				System.out.println("1 ~ 31일 사이 숫자를 입력해주세요.\n");
			}
		}

		
	}

	public static void ex8() {
		String[] game= {"가위","바위","보"}; // 사용자 입력과 비교하는 컴퓨터 랜덤을 배열로 저장
		String text; // 사용자 입력
		
		for(;;) { // exit 입력 전까지 무한반복
			
			int i=rd.nextInt(game.length); // i는 0, 1, 2 중 랜덤 반복. 배열길이 이용.
			
			// 랜덤 출력 확인
//			System.out.print(i+" ");
//			System.out.println(game[i]);
			
			System.out.print("\"가위, 바위, 보\" 중 하나 입력 : ");
			text=sc.nextLine();
			
			// String 비교는 .equals() 사용한다!!
			if(text.equals(game[i])) { // 사용자 입력이 배열에 저장된 랜덤과 동일하다면
				System.out.println("random : "+game[i]); // 확인용 랜덤 출력
				System.out.println("무승부\n");
			}
			else if(text.equals("가위")) { // 사용자 입력이 가위인 경우
				System.out.println("random : "+game[i]);
				if(game[i].equals("바위")) {System.out.println("사용자 패\n");} // 배열랜덤이 '바위'인 경우 사용자의 패
				else if(game[i].equals("보")) {System.out.println("사용자 승\n");} // 배열 랜덤이 '보'인 경우 사용자의 승
			}
			else if(text.equals("바위")) {
				System.out.println("random : "+game[i]);
				if(game[i].equals("가위")) {System.out.println("사용자 승\n");}
				else if(game[i].equals("보")) {System.out.println("사용자 패\n");}
			}
			else if(text.equals("보")) {
				System.out.println("random : "+game[i]);
				if(game[i].equals("가위")) {System.out.println("사용자 패\n");}
				else if(game[i].equals("바위")) {System.out.println("사용자 승\n");}
			}
			else if(text.equals("exit")) { // 게임종료 조건; 제일 처음 조건으로 적자!
				System.out.println("게임종료"); 	break;
			}
			else {
				System.out.println("\"가위, 바위, 보\" 중 하나 입력해주세요.\n");
			}
			
		}
	}
	
	public static void ex9() {
		int me;
		int num=rd.nextInt(101); // 임의의 값 범위 내 랜덤으로
		System.out.println(num); // 임의의 값이 무엇인지 확인하는 출력
		
		System.out.print("정수 입력 : ");
		me=sc.nextInt(); sc.nextLine();
		
		for(;;) { // 임의의 값 입력할 때까지 Up & Down 무한반복. 
		
			if(me>num) {
				System.out.println("Down\n");
				System.out.print(": ");
				me=sc.nextInt(); sc.nextLine();
			}
			else if(me<num) {
				System.out.println("Up\n");
				System.out.print(": ");
				me=sc.nextInt(); sc.nextLine();
			}
			else if(me==num) {
				System.out.println("Correct!\n");	break; // 랜덤으로 생성된 임의의 값을 찾으면 반복문 종료
			}
		}
	}
	
	public static void ex10() {}
	
	public static void ex11() {}
	
	public static void main(String[] args) {
		//ex1();
		//ex2();
		//ex3();
		ex4();
		//ex5();
		//ex6();
		//ex7();
		//ex8();
		//ex9();
		

	}

}
