package com.kh.exam17.arraylist.sample1.plusq;

import java.text.SimpleDateFormat;
import java.util.*;

public class QnASample1 {
	public static Scanner sc = new Scanner(System.in);
	public static Random rd = new Random();
	
	public static void ex8() {
		/*
		 * 사용자 입력으로 정수 데이터를 받아 ArrayList 에 저장 후
		 * ArrayList에 저장된 모든 정수의 합을 구하여 출력한다.
		 * (단, 사용자 입력은 한 번만 사용한다.)
		 */
		
//		 String은 import.java.lang패키지에 포함된 클래스이다.(import java.lang.String;)
//		 String Class는 문자 문자열을 나타낸다.
//		 java에서 모든 문자열 리터럴(literals)은 String 클래스의 인스턴스(객체)로 구현된다.
		 
		System.out.print("띄어쓰기를 구분자로하는 정수 데이터 입력: ");
		// 입력한 정수값에 대해 띄어쓰기를 구분하여 String 배열로 저장
		String[] inputs = sc.nextLine().split(" ");
		
		// ArrayList 클래스에는 Integer 타입 객체들만 저장됨
		List<Integer> iList = new ArrayList<Integer>();
		for(String s:inputs) {
			// String -> int
			// Integer.parseInt(String s) : 입력받은 문자열을 Integer로 변환하고, 기본자료형(primitive type) int 값을 리턴; 기본자료형 반환
			// Integer.valueof(String s) : 입력받은 문자열을 Integer로 변환하고, Integer Object를 리턴; 객체 반환
			// Java 1.5 에서 Autoboxing and Unboxing in Java 가 도입된 이후로 차이는 거의 없음. 둘 중 필요에 맞게 적절히 사용해라.
			iList.add(Integer.parseInt(s));
		}
		System.out.println(iList);
		
		int sum=0;
		for(int i:iList) {
			sum+=i;
		}
		System.out.println(sum);
	}
	
	public static void ex2() {
		/*
		 * 사용자 입력으로 실수 데이터를 받아 ArrayList 에 저장 후
		 * ArrayList에 저장된 모든 실수의 합과 평균을 구하여 출력한다.
		 * (단, 사용자 입력은 한 번만 사용한다.)
		 */
		System.out.print("띄어쓰기를 구분자로하는 실수 데이터 입력: ");
		String[] inputs = sc.nextLine().split(" ");
		
		List<Float> dList = new ArrayList<Float>();
		for(String s:inputs) {
			dList.add(Float.parseFloat(s));
		}
		System.out.println(dList);
		
		float sum=0;
		for(float d:dList) {
			sum+=d;
		}
		System.out.println("총합: "+sum);
		System.out.printf("평균: %.2f",sum/dList.size()); // 소수점 둘째 자리까지
	}
	
	public static void ex3() {
		/*
		 * 다음의 요구사항을 잘 보고 요구사항에 맞도록 구현한다.
		 * 	- 사용자 입력으로 정수 데이터를 받아 ArrayList 에 저장을 해야 한다.
		 * 	- 사용자 입력으로 하나의 정수 데이터를 입력 할 수 있지만 2개 이상의 정수를 입력 하기도 한다.
		 * 	- 동일한 정수 데이터는 ArrayList에 저장되지 않도록 한다.
		 */
		System.out.print("띄어쓰기를 구분자로하는 정수 데이터 입력: ");
		String[] inputs = sc.nextLine().split(" ");
		
		// ArrayList의 초기 저장 용량은 10
		// size() 메소드는 ArrayList에 저장되어 있는 전체 객체 수를 리턴한다.
		//				초기 ArrayList의 size는 0이다.
		List<Integer> iList = new ArrayList<Integer>();
		
		// 입력한 문자열 정수값들 모두에 대해 정수형으로 변경하여 중복인지 검사
		for(String s:inputs) {
			int tmp = Integer.parseInt(s);
			if(!iList.contains(tmp)) {
				iList.add(tmp);
			}
		}
		System.out.println(iList);
	}
	public static void ex3_oth() {
		List<Integer> intList = new ArrayList<Integer>();
		
		while(true) {			
			System.out.println("공백을 구분자로 사용하여 다음 내용에 맞은 데이터를 입력하세요.");
			System.out.print("정수값을 한 개 이상 입력하세요. : ");
			String[] inputs=sc.nextLine().split(" ");
			
			try {
				for(String s:inputs) {
					intList.add(Integer.valueOf(s));
				}
				System.out.print(intList+" | "); // 중복을 제거하지 않은 상태
				System.out.println(intList.size());
			} catch(Exception e) {
				System.out.println("정수만 입력해주세요.(띄어쓰기 구분)");
				intList.clear(); continue; // 지금까지 저장된 ArrayList 지우고 정수입력으로 돌아가기
			}
			
			// ArrayList 내 중복 검사 및 제거
			for(int i=0;i<intList.size();i++) { // i번 객체를
				for(int j=0;j<i;j++) { // (i-1)번 까지의 객체들과 비교
					if(intList.get(i)==intList.get(j)) {
						// 중복의 경우 중복되는 i번 객체를 제거하고 해당 자리수도 하나 지운다.
						System.out.println("중복 객체 요소: "+intList.get(i)+" | 중복 객체의 인덱스: "+i);
						intList.remove(i); System.out.println("인덱스 "+i+"번의 중복 객체가 제거된 ArrayList: "+intList);
						i--; // 중복값이 있던 인덱스에 새로운 값을 넣을 수 있게 자리수를 하나 지움.
						
					}
				}
			} // 중복검사 for문 종료 괄호
			break;
		} // 무한반복 while문 종료 괄호
		System.out.println(intList);
	}
	
	public static void ex4() {
		/*
		 * 사용자 입력으로 최소값, 최대값, 갯수를 입력받아 다음 요구사항에 맞도록 구현한다.
		 * 	- 최소값, 최대값은 랜덤을 통해 생성할 값의 범위이다.
		 * 	- 갯수는 랜덤을 통해 생성할 값의 수량 이다.
		 * 	- 생성된 랜덤값은 ArrayList 에 저장한다.
		 * 	- ArrayList에 저장한 정수는 중복이 없어야 한다.
		 */	
		System.out.print("띄어쓰기를 구분자로하고 최소값, 최대값, 갯수를 순서대로 입력하세요. : ");
		String[] inputs = sc.nextLine().split(" ");
		int min = Integer.parseInt(inputs[0]);
		int max = Integer.parseInt(inputs[1]);
		int cnt = Integer.parseInt(inputs[2]);
		
		List<Integer> iList = new ArrayList<Integer>();
		
		for(int i=1;i<=cnt;i++) {
			int rdNum = min + rd.nextInt((max - min) + 1); // (int)((Math.random()*(max-min+1))+min); min부터 max까지 범위
			if(!iList.contains(rdNum)) {
				iList.add(rdNum);
				System.out.println(iList);
			} else {
				System.out.println("Duplication Number : "+rdNum);
				i--;
			}
		}
		System.out.println("최종 ArrayList : "+iList);
	}
	
	public static void ex5() {
		/*
		 * 현재 날짜를 구한 후 ArrayList에 년, 월, 일, 시간, 분, 초 데이터가
		 * 저장되도록 한다.
		 */
		SimpleDateFormat df = new SimpleDateFormat("yyyy년 MM월 dd일 hh시 mm분 ss초");
		System.out.println(df.format(new Date()));
		String[] sArr = df.format(new Date()).split(" ");
		
		List<String> sList = new ArrayList<String>();
		for(String s:sArr) {
			sList.add(s);
		}
		System.out.println(sList);
	}
	public static void ex5_oth() {
		// GregorianCalendar클래스는 Calendar클래스의 후손 클래스이나
		// Calendar클래스와 달리 new 연산자를 이용해 객체를 생성할 수 있다.
		// Calendar date = Calendar.getInstance(); Calendar클래스는 getInstance() 메서드 이용하여 객체 생성
		GregorianCalendar gc = new GregorianCalendar();
		System.out.println(gc.getTime()); // 현재시간 확인. Tue Aug 24 00:35:33 KST 2021 형식.
		
		List<Integer> iList = new ArrayList<Integer>();
		iList.add(gc.get(Calendar.YEAR));
		iList.add(gc.get(Calendar.MONTH)+1); // MONTH는 0부터 시작됨.
		iList.add(gc.get(Calendar.DATE));
		iList.add(gc.get(Calendar.HOUR));
		iList.add(gc.get(Calendar.MINUTE));
		iList.add(gc.get(Calendar.SECOND));
		
		System.out.println(iList);
	}
	
	public static void ex6() {
		/*
		 * 3초에 한번씩 정기적으로 1 ~ 99 사이의 랜덤값을 ArrayList 에 저장을 하도록 한다
		 * ArrayList 에 저장하는 데이터는 10개로 제한한다.
		 */
		// gcEnd-gcStart 3초
		GregorianCalendar gcStart = new GregorianCalendar(); // 한 개의 객체 생성 시간
		SimpleDateFormat df = new SimpleDateFormat("yyyy MM dd hh:mm:ss");
		System.out.println("현재시간 출력: "+df.format(new Date()));
		
		List<Integer> iList  = new ArrayList<Integer>();
		// 랜덤 객체 10개까지만 저장
		// 한 개의 객체 생성 후 3초 뒤 다음 객체 생성하도록
		while(iList.size()<10) {
			GregorianCalendar gcEnd = new GregorianCalendar();
			if ((gcStart.get(Calendar.SECOND) + 3) % 60 == gcEnd.get(Calendar.SECOND)) {
				iList.add(rd.nextInt(99)+1); // 1~99 랜덤값 ArrayList에 저장
				System.out.println(iList);
				gcStart=gcEnd; // 한 개 생성 후 3초가 지난 시간은 다음 객체의 생성 시작 시간
			}
		}	
		System.out.println("\n랜덤 데이터 출력: "+iList);
	}
	
	public static void ex7() {
		/*
		 * 3초에 한번씩 정기적으로 1 ~ 99 사이의 랜덤값을 ArrayList 에 저장을 할 때 저장 시간도
		 * 같이 ArrayList에 저장하도록 하며 저장하는 데이터는 10개로 제한한다.
		 * 3초마다 생성된 랜덤값이 중복값인 경우 다시 3초를 기다린 후 랜덤값이 생성되어야 한다.
		 * (단, 중복 데이터는 저장이 안되도록 하며, ArrayList를 2개 이용하도록 한다. 시간은 년월일
		 * 시분초까지만 저장하도록 한다.)
		 */
		List<Integer> iList = new ArrayList<Integer>(); // 랜덤값 객체 저장
		List<String> sList = new ArrayList<String>(); // 랜덤값 저장 시간 객체 저장
		
		GregorianCalendar gcStart = new GregorianCalendar();
		GregorianCalendar gcEnd = null;
		SimpleDateFormat df = new SimpleDateFormat("yyyy MM dd hh:mm:ss");
		System.out.println("현재시간 출력: "+df.format(new Date()));
		
		// ArrayList에 객체 저장은 10개까지
		// 각각의 객체는 3초마다 생성되는데
		// 생성된 랜덤 객체값이 ArrayList 내에 이미 존재하는 경우 다시 3초 후 재생성
		// 한 객체 생성&저장 시간 3초 후 다음 객체 생성&저장
		while(iList.size()<10) {
			gcEnd = new GregorianCalendar();
			if ((gcStart.get(Calendar.SECOND) + 3) % 60 == gcEnd.get(Calendar.SECOND)) {
				int rdNum=rd.nextInt(99)+1;
				if(!iList.contains(rdNum)) {
					iList.add(rdNum);
					sList.add(df.format(gcEnd.getTime()));
					System.out.println(iList);
					System.out.println(sList);
				}
				else {
					System.out.println("Duplication Number!!"+rdNum);
				}
				gcStart=gcEnd; // 다음객체 생성은 이전객체 저장 이후 3초가 지난 시점에 진행됨.
			}
		}
	}
	
	public static void ex9() {
		/*
		 * ArrayList 에 다음의 단어를 미리 초기화 한 후 다음 요구사항에 맞는 프로그램을 작성한다.
		 * 	- abstract, continue, for, new, switch, default, package,
		 * 	  synchronized, boolean, do, if, private, this, break,
		 * 	  double, implements, protected, throw, byte, else, import,
		 * 	  public, throws, case, instanceof, return, catch, extends,
		 * 	  int, short, try, char, final, interface, static, void,
		 * 	  class, finally, long, float, super, while
		 * 	- ArrayList에 저장된 문자열을 랜덤으로 출력하게 만든다.
		 * 	- 랜덤으로 출력된 문자열을 사용자 입력으로 사용자가 입력하게 만든다.
		 * 	- 사용자가 입력한 데이터가 출력된 문자열과 동일하면 다음 문자열이 다시 랜덤으로 출력되게 한다.
		 * 	- 위 과정을 10번 반복하여 모든 문자열을 입력한 총 시간과 정확하게 입력한 문자열의 수, 잘못
		 * 	  입력한 문자열의 수를 테이블 형태로 출력하게 한다. 
		 */
	}
	

	public static void main(String[] args) {
		//ex8();
		//ex2();
		//ex3();
		//ex4();
		//ex5();
		//ex6();
		ex7();

	}

}
