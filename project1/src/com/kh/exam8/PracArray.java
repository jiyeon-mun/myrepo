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

	// 가위, 바위, 보 랜덤 출력_ 강사님 방식: 승률 추가
	public static void ex8() {
		String player;
		String computer = "";
		int[] score = new int[3];	// 0: 승, 1: 패, 2: 무
		boolean exitFlag = false;
		
		while(true) { // 게임 무한반복
		
			while(true) { // 사용자 입력의 무한반복으로 "종료" 입력 시 종료 조건을 통해 게임의 무한반복이 종료된다.
				System.out.print("가위, 바위, 보 중 하나 입력 : ");
				player = sc.nextLine();
				if(player.equals("가위") || player.equals("바위") || player.equals("보")
						|| player.equals("종료")) { // 사용자 입력
					if (player.equals("종료")) {exitFlag = true;} // 종료 입력 시
					
					break; // 사용자 입력 하면 입력문이 끝나고 switch문으로 넘어간다.
				}
			}
			
			if (exitFlag) { // 무한 반복 종료
				break;
			}
			
			switch(rd.nextInt(3)) {
				case 0:
					computer = "가위";	break;
				case 1:
					computer = "바위";	break;
				case 2:
					computer = "보";		break;
			}
			
			if(player.equals("가위")) {
				if(computer.equals("바위")) {
					System.out.println("컴퓨터 승");
					score[1] += 1;
				} else if(computer.equals("보")) {
					System.out.println("플레이어 승");
					score[0] += 1;
				} else if(computer.equals("가위")) {
					System.out.println("무승부");
					score[2] += 1;
				}
				
			} else if(player.equals("바위")) {
				if(computer.equals("바위")) {
					System.out.println("무승부");
					score[2] += 1;
				} else if(computer.equals("보")) {
					System.out.println("컴퓨터 승");
					score[1] += 1;
				} else if(computer.equals("가위")) {
					System.out.println("플레이어 승");
					score[0] += 1;
				}
				
			} else if(player.equals("보")) {
				if(computer.equals("바위")) {
					System.out.println("플레이어 승");
					score[0] += 1;
				} else if(computer.equals("보")) {
					System.out.println("무승부");
					score[2] += 1;
				} else if(computer.equals("가위")) {
					System.out.println("컴퓨터 승");
					score[1] += 1;
				}
				
			}
			
			System.out.println("현재 플레이어의 스코어는 : "+score[0]+" 승 "+score[1]+" 패 "+score[2]+" 무 입니다.");
		} // 게임 무한반복의 while문 괄호
		
		System.out.println(Arrays.toString(score)); // 사용자 승,패,무 저장한 배열 출력
	}
	
	// 가위, 바위, 보 랜덤 출력 내 방식_ 배열이용
	public static void ex10() {
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
	
	
	public static void ex11() {
		// 사용자 입력을 통해 과목 정보를 입력 받는다.
		// 사용자 입력이 계속 이루어 질 때마다 배열의 크기를 +1씩 늘려 입력한 만큼 저장하게 한다.
		// 사용자 입력이 "종료"인 경우 더 이상 입력을 받지 않고 최종 입력된 모든 과목 정보를 출력.
		/*
		 *  1. 배열의 크기가 0 인 문자열 배열을 생성
		 *  2. 사용자 입력을 계속 받을 수 있도록 무한 반복문 작성
		 *  3. 무한 반복문 안에서 사용자 입력을 받도록 작성
		 *  4. 사용자 입력값이 종료가 아니면 기존 배열 크기 +1을 한 새로운 배열 생성
		 *  5. 새로 생성한 배열에는 기존 배열의 데이터를 깊을 복사로 저장
		 *  6. 복사본의 참조 주소를 기존 배열 변수에서 사용할 참조 주소로 저장(얕은 복사)
		 *  7. 4번에서 입력받은 데이터를 새로 추가된 배열의 마지막 인덱스에 저장
		 *  8. 4번에서 입력받은 데이터가 종료인 경우 무한 반복문을 종료할 수 있게 한다.
		 *  9. 8번에서 최종 무한 반복이 종료되면 배열에 저장된 데이터를 출력.
		 */
		
		String info=""; // 과목명 입력
		String[] sub = new String[0]; // 과목명 저장할 배열 선언 및 초기화. 아직 입력하지 않았으니 0으로 초기화
		
		while(true) { // 무한반복_ "종료" 입력 전까지 과목명 무한으로 입력하도록
			System.out.print("과목명 입력 : ");
			info=sc.nextLine();
			if(!info.equals("종료")) { // 과목명 데이터 입력에 대해서
				
				// 배열 크기를 늘려서 깊은 복사를 하기 위한 영역
				String[] copySub = new String[sub.length + 1]; // 기존 배열 크기 +1을 한 새로운 문자열 배열 생성. 
				// System.out.println(Arrays.toString(copySub)); //계속해서 기존 배열에 +1한 배열크기의 새로운 배열이 생성된다!(초기화는 null값)
				
				for(int i=0;i<sub.length;i++) {
					copySub[i]=sub[i]; // 새로운 배열에 기존 배열의 데이터 값을 깊은 복사. 데이터 값만 복사한다.
				}
				sub=copySub; // sub배열과 copySub 배열의 참조값과 동일(얕은 복사 이용).
				sub[sub.length-1]=info; // 입력한 데이터를 기존 배열의 마지막 index에 저장.
			} 
			else { // "종료" 입력하면 입력 종료 및 무한반복 종료
				break;
			}
		}
		for(int i=0;i<sub.length;i++) { // 입력한 과목명을 저장한 배열에 대한 데이터 출력 및 확인
			System.out.println("sub[" + i + "]:" + sub[i]);
		}
		System.out.println(Arrays.toString(sub));
	}
		
	public static void ex12() {
		int num;
		int[] iArr = new int[0];
		int sum=0;
		
		while(true) {
			System.out.println("1 ~ 49 사이의 정수 값을 입력해주세요.(-1 입력하면 종료)");
			System.out.print(": ");
			num = sc.nextInt(); sc.nextLine();
			
			if(num!=-1) {
				int[] copyNum = new int[iArr.length + 1];
				
				for(int i=0;i<iArr.length;i++) {
					copyNum[i]=iArr[i]; // 값 복사
				}
				iArr=copyNum;
				iArr[iArr.length-1]=num;
				sum+=num; // 입력값들 반복해서 덧셈
				// System.out.println("iArr[]: " + Arrays.toString(iArr)); // 입력값들 배열 내 마지막 index에 저장됨.
			}
			else {
				break;
			}
		}
		System.out.println();
		System.out.println("최종 iArr[]: " + Arrays.toString(iArr));
		System.out.println("입력한 정수들의 합은 : " + sum);
	}
	
	public static void ex13() {
		String text;
		String[] msgArr = new String[0];
		
		System.out.println("영문자 문자열을 입력해주세요.");
		System.out.print(": ");
		text = sc.nextLine();
		
	}
	
	public static void ex14() {
		String[] sArr = new String[] { "국어", "수학", "영어", "과학", "사회" };
		String deleteSubject = "";
		
		System.out.println("현재 등록된 과목 : "+Arrays.toString(sArr));
		System.out.print("제거할 과목명을 입력해주세요 : ");
		
		deleteSubject=sc.nextLine();
		for(int i=0;i<sArr.length;i++) {
			
		}
	}
	
	public static void main(String[] args) {
		//ex1();
		//ex2();
		//ex3();
		//ex4();
		//ex5();
		//ex6();
		//ex7();
		//ex8();
		//ex10();
		//ex9();
		
		//ex11();
		ex12();
		
		

	}

}
