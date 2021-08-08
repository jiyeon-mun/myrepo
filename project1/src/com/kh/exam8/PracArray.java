package com.kh.exam8;

import java.util.Scanner;
import java.util.Arrays;
import java.util.Random;

public class PracArray {
	
	static Scanner sc = new Scanner(System.in);
	static Random rd = new Random();

	public static void ex1() {
		/*
		 * 길이가 10 인 정수 배열을 선언하고 1 ~ 10까지의 값을 배열에
		 * 초기화하는 코드를 작성
		 */
		int iArr[] = new int[10];

		// 배열 초기화
		for(int i=0;i<iArr.length;i++) {
			iArr[i]=i+1;
		}
		
		// 배열 출력
		System.out.println(Arrays.toString(iArr));
		// 확인 출력
		for(int i = 0; i < iArr.length; i++) {
			System.out.println("iArr[" + i + "] -> " + iArr[i]);
		} 
	}

	public static void ex2() {
		/*
		 * 길이가 10 인 정수 배열을 선언하고 짝수에 해당하는 값을 배열에 순차적으로
		 * 초기화하는 코드를 작성
		 */
		int[] iArr = new int[10];
		
		for (int i = 0; i < iArr.length; i++) {
			iArr[i]=2*(i+1);
			System.out.println("iArr[" + i + "]" + " : " + iArr[i]);
		}
		System.out.print(Arrays.toString(iArr));
	}

	public static void ex3() {
		/*
		 * 길이가 20 인 정수 배열을 선언하고 홀수에 해당하는 값을 배열에 순차적으로
		 * 초기화하는 코드를 작성
		 * 단, 99 부터 역순으로 초기화값을 저장한다.
		 * 
		 * int[] iArr = new int[20];
		 * int[0] = 99;	int[1] = 97;
		 * int[2] = 95;	int[3] = 93;
		 * ...
		 */
		int[] iArr = new int[20];
		
		for (int i = 0; i < iArr.length; i++) {
			iArr[i]=99-(2*i);
			System.out.println("iArr[" + i + "]" + " : " + iArr[i]);
		}
		System.out.print(Arrays.toString(iArr));
	}

	public static void ex4() {
		/*
		 * 길이가 26 인 정수 배열을 선언하고 아스키 문자 영문자(대문자)를 순차적으로
		 * 초기화하는 코드를 작성
		 */
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
		/*
		 * 생성할 배열의 크기를 사용자 입력을 이용하여 생성한 후 100 부터 배열의 크기만큼
		 * 초기화를 진행한다.
		 */
		int size;
		int value=100;
		
		System.out.print("생성할 배열 크기 입력 : ");
		size=sc.nextInt(); sc.nextLine();
		int[] iArr = new int[size]; // 입력한 정수만큼의 크기를 갖는 정수 배열 생성
		
		for(int i=0;i<size;i++) {
			iArr[i]=value++;
			System.out.println("iArr[" + i + "]" + " : " + iArr[i] );
		}
		System.out.print(Arrays.toString(iArr));
	}

	public static void ex6() {
		/*
		 * 생성할 배열의 크기를 사용자 입력을 이용하여 생성한 후 다시 사용자 입력을 이용하여
		 * 사용자가 직접 배열의 크기 만큼 초기화 할 수 있도록 한다.
		 * (생성 할 배열 타입은 문자열로 한다.)
		 */
		int size;
		String text; // 문자열 입력받을 변수를 생성
		
		System.out.print("생성할 배열 크기 입력 : ");
		size=sc.nextInt(); sc.nextLine();
		String[] sArr = new String[size]; // 입력한 크기만큼의 문자열 배열 생성
		
		for(int i=0;i<sArr.length;i++) {
			System.out.print("초기화할 문자열 입력 : ");
			
			text=sc.nextLine();	// 입력받은 문자열 변수에 저장
			sArr[i]=text; // 변수에 저장한 문자열을 각 배열 요소 위치에 하나씩 저장.
	
//			sArr[i]=sc.nextLine(); // 문자열 입력받는 변수없이 입력과 동시에 배열에 저장할 수 있음
			
			System.out.println("sArr[" + i + "]" + " : " + sArr[i] );
		}
		System.out.print(Arrays.toString(sArr));
		
	}
	
	public static void ex7() {
		/*
		 * 2021년 7월에 한정하여 사용자 입력을 통해 일자 데이터를 입력 받고 해당하는 일자가
		 * 어떤 요일인지 알려주는 코드를 배열을 활용하여 작성한다.
		 */
		int date;
		String[] day= {"수요일","목요일","금요일","토요일","일요일","월요일","화요일"};
		// day[0]=수요일, day[1]=목요일, day[2]=금요일, day[3]=토요일, day[4]=일요일, day[5]=월요일, day[6]=화요일
		
		System.out.println("1 ~ 31일 사이 날짜 입력");
		System.out.print(": ");
		date=sc.nextInt(); sc.nextLine();
		
		if(date>=1&&date<32) {
			System.out.println(": "+day[date%7]+"\n");
		}else {
			System.out.println("1 ~ 31일 사이 숫자를 입력해주세요.\n");
		}		
	}
	
	public static void ex8() {
		// 가위바위보 게임 -> 사용자 입력으로 사용자가 가위 또는 바위 또는 보를 입력하는 것만으로 동작.
		
		/*
		 * 1. 사용자 / 컴퓨터가 임의의 가위, 바위, 보를 입력
		 *     - 사용자는 Scanner 를 사용하여 입력 (직접 가위, 바위, 보 중 하나 입력)
		 *     - 컴퓨터는 Random 를 사용하여 입력 (0, 1, 2 중 하나를 임의로 생성)
		 *     - Random 을 통해 생성된 0, 1, 2 의 값은 각각 가위, 바위, 보로 치환하여 동작하게 한다.
		 *
		 * 2. 승부 비교를 위한 조건문 작성
		 *     - 가위 : 바위 -> 바위 승, 가위 : 보 -> 가위 승, 가위 : 가위 -> 무승부
		 *     - 바위 : 바위 -> 무승부,  바위 : 보 -> 보 승,  바위 : 가위 -> 바위 승
		 *     - 보 : 바위 -> 보 승,    보 : 보 -> 무승부,   보 : 가위 -> 가위 승
		 *  
		 * 3. 2번 비교 결과에 따른 승, 패, 무 저장해두어 승률을 출력
		 */
	}

	// 강사님 방식: 승률 추가
	public static void ex8_lecture() {
		String player;
		String computer = "";
		int[] score = new int[3];	// 0: 승, 1: 패, 2: 무
		String[] sArr = {"가위", "바위", "보"};
		boolean exitFlag = false; // 종료판별변수
		
		// "종료"입력 전까지 게임 무한반복
		while(true) { 
			// 사용자 입력을 요구하는 출력문 무한반복
			// "종료" 입력 시 종료 조건을 통해 게임의 무한반복이 종료된다.
			while(true) {
				System.out.print("가위, 바위, 보 중 하나 입력 : ");
				player = sc.nextLine();
				
				// 사용자 입력: "가위, 바위, 보, 종료"만 가능
				// "종료" 입력 시
				// 종료판별변수는 true
				if(player.equals("가위") || player.equals("바위") || player.equals("보")
						|| player.equals("종료")) { 
					if (player.equals("종료")) {exitFlag = true;}
					
					// 1. 사용자 입력값이 "가위, 바위, 보" 중 하나인 경우 입력문이 끝나고 195줄의 if문으로 넘어간다.
					// 2. 사용자 입력값이 "종료"인 경우 사용자입력을 요구하는 출력문의 무한반복이 종료된다.
					break;
				}
			}
			// 종료판별변수가 true인 경우 가위바위보 게임에 대한 무한반복 종료
			if (exitFlag) {
				break; // 게임종료
			}
			
			// 컴퓨터는 가위,바위,보 중 랜덤 값을 갖음
			computer = sArr[rd.nextInt(3)];
			System.out.println("컴퓨터 랜덤 출력: "+computer); // 확인
			
			// 사용자 입력값에 대해서 
			// 가위별, 바위별, 보별 누구의 승인지 출력하고, 사용자의 승패무를 기록한다. 
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
			// 한 게임할 때마다 기록한 사용자 승패무 출력
			System.out.println("현재 플레이어의 스코어는 : "+score[0]+" 승 "+score[1]+" 패 "+score[2]+" 무 입니다.");
			
		} // 게임 무한반복의 while문 괄호
		System.out.println("사용자의 게임 최종 스코어는 : "+score[0]+" 승 "+score[1]+" 패 "+score[2]+" 무 입니다.");
//		System.out.println(Arrays.toString(score)); // 사용자 승,패,무 저장한 배열 출력
	}
	
	// 가위, 바위, 보 랜덤 출력 내 방식_ 배열이용
	public static void ex8_me() {

		// 사용자 입력과 비교하는 컴퓨터 랜덤 출력값을 배열로 저장
		String[] game= {"가위","바위","보"};
		String text;
		
		// exit 입력 전까지 게임 무한반복
		for(;;) {
			
			// game.length=3
			// 게임의 무한반복 내 i는 0, 1, 2 중 랜덤 반복
			// 컴퓨터 출력값 배열에 랜덤으로 접근하기 위해
			int i=rd.nextInt(game.length);
			
			System.out.print("\"가위, 바위, 보\" 중 하나 입력 : ");
			text=sc.nextLine();
			
			// String 비교는 .equals() 사용한다!!
			// 사용자 입력값이 배열에 저장된 랜덤값과 동일하다면
			// 사용자 입력값이 컴퓨터가 랜덤으로 출력하는 배열요소값과 동일하다면
			if(game[i].equals(text)) {
				System.out.println("random : "+game[i]); // 확인용 컴퓨터 랜덤 출력
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
			// 가위, 바위, 보, exit 사용자 입력값 외 나머지 문자열이 입력되면
			// for문 무한반복
			else {
				System.out.println("\"가위, 바위, 보\" 중 하나 입력해주세요.\n");
			}
			
		}
	}	
	
	public static void ex9() {
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
		String[] sub = new String[0]; // 입력한 과목명 저장할 빈 형태의 문자열 배열
		
		 // 무한반복: "종료" 입력 전까지 과목명을 무한으로 입력할 수 있도록
		while(true) {
			System.out.print("과목명 입력 : ");
			info=sc.nextLine();
			
			// 과목명 데이터 입력에 대해서 "종료" 입력하지 않는다면
			// 입력한 데이터를 배열에 저장
			// 이 과정이 "종료"입력전까지 무한히 반복된다.
			if(!info.equals("종료")) {
				
				// 기존배열크기+1의 새로운 배열 생성
				// 새로운 비열에 
				String[] copySub = new String[sub.length + 1];
				
				// 깊은복사
				// System.arraycopy(sub, 0, copySub, 0, sub.length);
				for(int i=0;i<sub.length;i++) {
					copySub[i]=sub[i];
					//copySub[i]=sub[i].clone(); 사용불가: String 타입 객체는 clone()메서드로 복제불가
				}
				
				// 얕은복사: 두 배열변수 참조주소가 동일, 동일한 크기
				sub=copySub;
				sub[sub.length-1]=info; // 입력한 데이터를 기존 배열의 마지막 index에 저장.
			} 
			else { // "종료" 입력하면 입력 종료 및 무한반복 종료
				break;
			}
		} // 무한반복 while()의 괄호
		
		// 입력한 과목명을 저장한 배열에 대한 데이터 출력 및 확인
		for(int i=0;i<sub.length;i++) {
			System.out.println("sub[" + i + "]:" + sub[i]);
		}
		System.out.println(Arrays.toString(sub)); // 입력데이터 저장 배열 출력
	}
		
	public static void ex10() {
		/*
		 * 1 ~ 49 사이의 정수 값을 사용자 입력을 통해 입력 받고 이를 정수 배열에 저장을 한다.
		 * -1 이 입력될 때 까지 배열의 크기를 +1씩 증가시키면서 사용자 입력 값을 배열에 저장을 하며
		 * -1 이 입력되어 더 이상 사용자 입력을 받지 않을 때 배열에 저장된 모든 값의 합을 출력한다.
		 */
		int num;
		int[] iArr = new int[0];
		int sum=0;
		
		while(true) {
			System.out.println("1 ~ 49 사이의 정수 값을 입력해주세요.(-1 입력하면 종료)");
			System.out.print(": ");
			num = sc.nextInt(); sc.nextLine();
			
			if(num!=-1) {
				int[] copyNum = new int[iArr.length + 1];
				
				// System.arraycopy(iArr, 0, copyNum, 0, iArr.length);
				for(int i=0;i<iArr.length;i++) {
					copyNum[i]=iArr[i];
					//copyNum[i]=iArr[i].clone(); 사용불가: copyNum[]이 privative type int로 clone()을(를) 호출할 수 없음
				}
				
				iArr=copyNum;
				iArr[iArr.length-1]=num;
				sum+=num;
			}
			else {
				break;
			}
		}
		
		System.out.println("최종 iArr[]: " + Arrays.toString(iArr));
		System.out.println("입력한 정수들의 합은 : " + sum);
	}
	
	public static void ex11() {
		/*
		 * 사용자로 부터 임의의 문자열을 입력 받은 후
		 * a, e, i, o, u 문자가 포함되어 있을 때마다 문자 배열에 저장을 한 후 배열의 길이를
		 * 출력하여 얼마나 포함되어 있는지 확인하게 한다.
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
		 * 
		 * System.arraycopy() 활용할 수 있으면 활용한다.
		 */
		String text;
		char[] arr = new char[0];
		int cnt=0;
		
		System.out.println("영문자 문자열을 입력해주세요.");
		System.out.print(": ");
		text = sc.nextLine();

		for(int i=0;i<text.length();i++) {
			switch(text.charAt(i)) {
			case 'a':	case 'e':	case 'i':	case 'o':	case 'u':
				char[] arrCopy = new char[arr.length + 1];
				System.arraycopy(arr, 0, arrCopy, 0, arr.length);
//				for(int j=0;j<arr.length;j++) {
//					arrCopy[j]=arr[j];
//				}
				arr=arrCopy;
				arr[arr.length-1]=text.charAt(i);
				cnt+=1;
			}
		}
		System.out.println("a, e, i, o, u 문자가 " + cnt + "개 있습니다.");
		System.out.println(Arrays.toString(arr));
	}
	
	public static void ex12() {
		/*
		 *  국어, 영어, 수학, 과학, 사회 과목정보가 있는 배열이 있다.
		 *  위 배열에서 사용자가 제거하기 원하는 과목을 입력하면 배열에서 제거될 수 있도록 한다.
		 *  System.arraycopy() 활용할 수 있으면 활용한다.
		 */
		String[] arrSubject = new String[] {"국어", "영어", "수학", "과학", "사회"};
		String deleteSubject;
		int deleteIndex = -1;
		
		System.out.println("현재 등록된 과목 -> " + Arrays.toString(arrSubject));
		System.out.print("제거 할 과목명 입력 : ");
		
		deleteSubject = sc.nextLine();
		
		// 입력한 데이터가 배열 내 있는지 확인하고
		// 있다면 삭제할 위치를 확인한다.
		for(int i = 0; i < arrSubject.length; i++) {
			if(arrSubject[i].equals(deleteSubject)) {
				deleteIndex = i;
				break;
			}
		}
		
		// 삭제할 데이터가 있는 경우
		// 삭제할 데이터만 빼고 나머지 복사
		if(deleteIndex >= 0) {
			// 데이터 삭제로 배열크기감소
			String[] arrSubjectCopy = new String[arrSubject.length - 1];
			int j; // 줄어든 새로운 배열 크기에 대한 인덱스

			for(int i = 0; i < arrSubjectCopy.length; i++) {
				if(i != deleteIndex) {
					j = i;
				}
				else {
					j = i + 1;
				}
				arrSubjectCopy[i] = arrSubject[j];
			}
			
			arrSubject = arrSubjectCopy;
			
			System.out.println("삭제를 완료하였습니다.");
			System.out.println(Arrays.toString(arrSubject));
		} else {
			System.out.println("삭제할 데이터를 찾을 수 없습니다.");
		}
	}
	
	public static void ex13() {
		// 업앤 다운. -> 임의의 값을 하나 생성하고 사용자가 일정 범위의 정수값 안에서 정수를 입력하면
		//            미리 생성된 값과 비교를 통해 업 또는 다운 으로 힌트를 주어 최종 생성값을 맞추는 게임.

	}
	
	public static void ex13_1() {
		int me;
		int num=rd.nextInt(101); // 임의의 값 범위 내 랜덤으로
		System.out.println(num); // 임의의 값이 무엇인지 확인하는 출력
		
		System.out.print("정수 입력 : ");
		me=sc.nextInt(); sc.nextLine();
		
		// 입력한 값이 임의의 값과 동일할 때까지 Up & Down 무한반복
		for(;;) { 
			// 사용자입력값이 임의의값보다 클 때
			if(me>num) {
				System.out.println("Down\n");
				System.out.print(": ");
				me=sc.nextInt(); sc.nextLine();
			}
			// 사용자입력값이 임의의값보다 작을 때
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
	
	public static void ex13_2() {
		int me;
		int num=rd.nextInt(101);
		boolean exitFlag=false; // 입력값 종료조건 판별 변수
		
		System.out.println(num);
		
		// Up&Down 게임에 대한 무한반복
		while(true) {
			
			// 게임 내 입력값 받는 출력문에 대한 무한반복
			while(true) {
				System.out.print("1~100 사이의 정수 입력 (0입력하면 종료): ");
				me=sc.nextInt(); sc.nextLine();
				
				// 허용되는 입력값은 1~100 사이의 정수, 종료조건인 0
				if(me>=1&&me<101||me==0) {
					// 종료조건인 0 입력 시
					if(me==0) {
						exitFlag=true; // 종료조건 판별 변수는 true
					}
					
					// 1. 입력값이 1~100 사이의 정수일 때 547줄의 if문으로 가서 종료조건 변수가 게임종료에 만족하는지 판별 
					// 2. 입력값이 종료조건이 0일 때 입력값을 요구하는 출력문의 무한반복이 종료됨
					break;
				}
			}
			// Up&Down 게임 종료조건
			// 1. 사용자가 0을 입력하면 종료조건 판별변수인 exitFlag가 true가 되고 게임이 종료된다.
			// 2. 사용자가 1~100 사이의 정수 입력하면 exitFlag는 false로 입력값에 대해 up&down을 진행한다.
			if(exitFlag) {
				break;
			}
			// 입력값이 조건문에 해당하면 실행문을 수행하고 다시 입력값을 요구하는 두번째 무한반복으로 돌아간다.
			if(me>num) {
				System.out.println("Down\n");
			} else if(me<num) {
				System.out.println("Up\n");
			} else if(me==num) {
				System.out.println("Correct!\n");
				break;
			}
		} // 첫번째 무한반복에 대한 괄호
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
		//ex8_lecture();
		//ex8_me();
		
		//ex9();
		//ex10();
		//ex11();
		ex12();
		
		//ex13_1();
		//ex13_2();
		

	}

}
