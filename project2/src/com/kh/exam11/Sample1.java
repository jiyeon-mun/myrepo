package com.kh.exam11;

import java.util.Scanner;

public class Sample1 {
	
	static Scanner sc = new Scanner(System.in);
	
	public void ex1() {
		Subject[] subjects = new Subject[3];
		subjects[0] = new Subject("국어", 70);
		subjects[1] = new Subject("영어", 80);
		subjects[2] = new Subject("수학", 90);
		
		// 1. 사용자 입력을 받아서 과학 과목과 점수 85 를 입력받아서 배열의 마지막 인덱스에 추가
		// 단 점수의 경우 0 ~ 100 사이의 입력이 아니면 계속 입력	받을 수 있게 한다.
		
		// 2. 과목명에서 종료라는 문자열이 입력되기 전까지 계속 정보를 입력받아 Subject 클래스의
		// 인스턴스가 Subjects 객체 배열에 추가될 수 있게 한다.(동적 배열)
		
		// 3. 새로운 과목을 추가 할 때 기존에 저장된 과목이 이미 존재하는 경우
		// 다시 과목명을 입력하도록 한다.(배열에 저장된 Subject 객체를 전체 탐색해야 함. - 반복 필요.)
		
		/*
		 * 과목명 입력란 무한반복
		 * 입력 과목명에 배열 내 중복되는 경우
		 * "종료" 입력 전까지
		 */
		while(true) {
			boolean isDuplicate = false; // 중복판별변수
			
			System.out.print("과목명 입력 : ");
			String name = sc.nextLine();
			
			if(!name.equals("종료")) {
				/*
				 * 입력한 과목명이 기존 배열 내 중복하는지 확인
				 * 중복되는 경우 중복판별변수 isDuplicate가 true값을 가짐
				 */
				
				// for each 문
				// 전체탐색에 사용됨(인덱스번호 사용하지 않음)
				// s에 subjects 인덱스 요소 다 저장됨
				for(Subject s:subjects) {
					if(name.equals(s.getName())) {
						isDuplicate = true; // 중복됨
					}
				}
//				for(int i = 0; i < subjects.length; i++) { // 인덱스 번호 필요 시 사용
//					if(name.equals(subjects[i].getName())) {
//						isDuplicate = true; // 중복됨
//					}
//				}
				
				if(!isDuplicate) { // 입력한 과목명이 배열 내 중복이 false인 경우
					
					Subject[] copy = new Subject[subjects.length + 1];
					System.arraycopy(subjects, 0, copy, 0, subjects.length);
//					for(int i=0;i<subjects.length;i++) {
//						copy[i]=subjects[i];
//					}
					
					int last = copy.length - 1;
					// 매개변수로 문자열과 정수를 갖는 생성자 Subject 호출
					// 입력한 과목명 name과 -1을 Subject 클래스의 멤버변수 name, jumsu의 값으로 전달된다.
					// -1: isValid() 메서드 활용하기 위해서
					copy[last] = new Subject(name, -1);
					
					// isValid반환값 !fale = true가 되면서
					// while(ture) 무한반복문: 범위 내 점수 입력이 맞는지 확인하면서 아닌 경우 점수 재입력을 반복한다.
					while(!copy[last].isValid()) { 
						System.out.print(copy[last].getName() + " 점수 : ");
						copy[last].setJumsu(sc.nextInt());	sc.nextLine();
						
						if(!copy[last].isValid()) {
							System.out.println("점수는 " + Subject.getRangeJumsu()[0] +
									" ~ " + Subject.getRangeJumsu()[1] + "범위로 입력해야 합니다.");
						}
					}
					
					// 아래 등급지정 for문에서 subjects 객체배열 사용하기에
					// 얕은복사로 두 배열의 각 행의 참조주소 동일하게 한다.
					subjects = copy;
					
				} else {
					// 입력한 과목명이 배열 내 중복이 true인 경우
					// 과목명 재입력으로 돌아감
					System.out.println("이미 존재하는 과목명 입니다.");
				}
				
			} else { 
				// 과목명에 "종료" 문자열 입력하면 무한반복 탈출하고
				// 아래 과목별 점수, 등급 출력 for문으로 이동
				break;
			}
		} // 과목명 무한 입력 while문 종료 괄호
		

		for(Subject s:subjects) {
			System.out.println(s.getName() + " 점수 : " +
					s.getJumsu());
			System.out.println("등급 : " + s.getGrade());
		}
//		for(int i = 0; i < subjects.length; i++) {
//			System.out.println(subjects[i].getName() + " 점수 : " +
//					subjects[i].getJumsu());
//			System.out.println("등급 : " + subjects[i].getGrade());
//		}
	}
	
	public static void main(String[] args) {
		
		// Student클래스 인스턴스 std 생성
		// 매개변수로 문자열, 정수를 갖는 Student 생성자 호출
		Student std = new Student("홍길동", 30);
		
		// 과목추가
		// Subject 클래스 인스턴스 생성 및 매개변수로 문자열, 정수를 갖는 Subject생성자 호출
		Subject sub = new Subject("국어",70);
		std.addSubject(sub);
		sub = new Subject("영어",65);
		std.addSubject(sub);
		sub = new Subject("수학",97);
		std.addSubject(sub);
		
		System.out.println(std.getName()+" 학생의 총점은 "+std.total());
		System.out.println(std.getName()+" 학생의 평균은 "+std.avg());

		
	}
}
