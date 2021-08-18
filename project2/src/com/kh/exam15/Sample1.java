package com.kh.exam15;

import java.util.Arrays;

public class Sample1 {

	public static void main(String[] args) {
		
		Book[] books = new Book[5];
		books[0] = new Novel("해리포터1", "문학수첩", "판타지", "J.K 롤링", 300);
		books[1] = new Comics("원피스", "밝은세상", "무협만화", "일본인",15, 244);
		books[2] = new Magazine("Ceci", "허스트중앙", "편집부", "여성/남성", 112);
		books[3] = new Novel("해리포터2", "문학수첩", "판타지", "J.K 롤링", 298);
		books[4] = new Comics("케로로", "아랑", "코믹", "개구리",13, 333);
		
		for(Book b:books) {
			System.out.println(b);
			// 객체배열 각 인덱스의 주소가 출력된다.
			// 각 클래스에 toString() 을 오버라이딩 하여 객체배열 내 저장된 정보를 출력할 수 있도록 한다.
		}
		
		System.out.println();
		
		/*
		 * 위의 Book 배열 객체에서 소설책, 코믹스, 잡지를 분류하고 분류된 객체를 각 배열
		 * (Novel 배열, Comics 배열, Magazine 배열)로 이동 시킨다.
		 * 동적 배열이 어려우면 정적 배열로 만들어서 진행해도 됨.
		 */
		Novel[] novels=null;		int nCnt=0;
		Comics[] comices=null;		int cCnt=0;
		Magazine[] magazines=null;	int mCnt=0;
		// 부모클래스타입 배열 내 각각의 자식클래스 개수 카운팅 
		for(Book b:books) {
			if(b instanceof Novel) {
				nCnt++; // 2개
			} else if(b instanceof Comics) {
				cCnt++; // 2개
			} else if(b instanceof Magazine) {
				mCnt++; // 1개
			}
		}
		
		// 분류된 객체들 개수만큼 각각의 자식클래스타입 객체배열 크기 지정 
		novels = new Novel[nCnt];
		comices = new Comics[cCnt];
		magazines = new Magazine[mCnt];
		// 부모클래스 객체배열 내 저장된 자식클래스 내용을 분류하여
		// 자식클래스별 객체배열에 따로 저장
		nCnt = cCnt = mCnt = 0;
		for(Book b:books) {
			if(b instanceof Novel) {
				novels[nCnt++] = (Novel)b;
			} else if(b instanceof Comics) {
				comices[cCnt++] = (Comics)b;
			} else if(b instanceof Magazine) {
				magazines[mCnt++] = (Magazine)b;
			}
		}
		// 분류된 자식클래스 객체배열 확인
		System.out.println(Arrays.toString(novels));
		System.out.println(Arrays.toString(comices));
		System.out.println(Arrays.toString(magazines));
		
	}

}
