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
		
		System.out.println("==========================================================================");
		
		Novel[] novels=null;		int nCnt=0; // books배열 내 소설 개수
		Comics[] comices=null;		int cCnt=0; // books배열 내 코믹 개수
		Magazine[] magazines=null;	int mCnt=0; // books배열 내 잡지 개수
		for(Book b:books) {
			if(b instanceof Novel) {
				nCnt++;
			} else if(b instanceof Comics) {
				cCnt++;
			} else if(b instanceof Magazine) {
				mCnt++;
			}
		}
		
		novels = new Novel[nCnt];
		comices = new Comics[cCnt];
		magazines = new Magazine[mCnt];
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
		System.out.println(Arrays.toString(novels));
		System.out.println(Arrays.toString(comices));
		System.out.println(Arrays.toString(magazines));
		
	}

}
