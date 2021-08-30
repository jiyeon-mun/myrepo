package com.kh.practice.chap01_ploy.view;

import java.util.Scanner;
import com.kh.practice.chap01_ploy.controller.LibraryController;

public class LibraryMenu {
	private LibraryController lc = new LibraryController();
	private Scanner sc = new Scanner(System.in);
	
	public void mainMenu() {
		String menu = "==== 메뉴 ====\n";
		menu+="1. 마이페이지\n";
		menu+="2. 도서 전체 조회\n";
		menu+="3. 도서 검색\n";
		menu+="4. 도서 대여하기\n";
		menu+="9. 프로그램 종료하기\n";
		menu+="메뉴번호 : ";
		
		while(true) {
			System.out.print(menu);
			switch(sc.nextInt()) {
			case 1:
				sc.nextLine();	lc.myinfo();	break;
			case 2:
				sc.nextLine();	this.selectAll();;	break;
			case 3:
				sc.nextLine();	this.searchBook();	break;
			case 4:
				sc.nextLine();	this.rentBook();	break;
			case 9:
				return;
			}
		}
	}
	
	public void selectAll() {}
	
	public void searchBook() {}
	
	public void rentBook() {}
}
