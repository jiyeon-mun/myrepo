package com.kh.practice.point.view;

import java.util.Scanner;

import com.kh.practice.point.controller.CircleController;
import com.kh.practice.point.controller.RectangleController;

public class PointMenu {
	private Scanner sc = new Scanner(System.in);
	private CircleController cc = new CircleController();
	private RectangleController rc = new RectangleController();
	
	public void mainMenu() {
		String menu = "===== 메뉴 =====\n";
		menu += "1. 원\n";
		menu += "2. 사각형\n";
		menu += "9. 끝내기\n";
		menu += "메뉴 번호 : ";
		while(true) {
			System.out.print(menu);
			switch(this.sc.nextInt()) {
				case 1:
					sc.nextLine();	this.circleMenu();	break;
				case 2:
					sc.nextLine();	this.rectangleMenu();	break;
				case 9:
					return; // 종료
			}
		}
	}
	
	public void circleMenu() {
		String menu = "===== 원 메뉴 =====\n";
		menu += "1. 원 둘레\n";
		menu += "2. 원 넓이\n";
		menu += "9. 메인으로\n";
		menu += "메뉴 번호 : ";
		System.out.print(menu);
		switch(this.sc.nextInt()) {
			case 1:
				sc.nextLine();	this.calcCircum();	break;
			case 2:
				sc.nextLine();	this.calcCircleArea();	break;
			case 9:
				return; // mainMenu()으로
		}
	}
	
	public void rectangleMenu() {
		String menu = "===== 사각형 메뉴 =====\n";
		menu += "1. 사각형 둘레\n";
		menu += "2. 사각형 넓이\n";
		menu += "3. 사각형 쪼개기\n";
		menu += "9. 메인으로\n";
		menu += "메뉴 번호 : ";
		System.out.print(menu);
		switch(this.sc.nextInt()) {
			case 1:
				sc.nextLine();	this.calcPerimeter();	break;
			case 2:
				sc.nextLine();	this.calcRectArea();	break;
			case 3:
				sc.nextLine();	this.calcRectSplit();	break;
			case 9:
				return; // mainMenu()으로
		}
	}
	
	public void calcCircum() { // 원 둘레
		int x, y, radius;
		
		System.out.print("x 좌표 : ");
		x = this.sc.nextInt();	sc.nextLine();
		
		System.out.print("y 좌표 : ");
		y = this.sc.nextInt();	sc.nextLine();
		
		System.out.print("반지름 : ");
		radius = this.sc.nextInt();	sc.nextLine();
		
		String circum = cc.calcCircum(x, y, radius);
		System.out.println(circum);
	}
	
	public void calcCircleArea() { // 원 넓이
		int x, y, radius;
		
		System.out.print("x 좌표 : ");
		x = this.sc.nextInt();	sc.nextLine();
		
		System.out.print("y 좌표 : ");
		y = this.sc.nextInt();	sc.nextLine();
		
		System.out.print("반지름 : ");
		radius = this.sc.nextInt();	sc.nextLine();
		
		String area = cc.calcArea(x, y, radius);
		System.out.println(area);
	}
	
	public void calcPerimeter() { // 사각형 둘레
		int x, y, width, height;
		
		System.out.print("x 좌표 : ");
		x = this.sc.nextInt();	sc.nextLine();
		
		System.out.print("y 좌표 : ");
		y = this.sc.nextInt();	sc.nextLine();
		
		System.out.print("높이 : ");
		height = this.sc.nextInt();	sc.nextLine();
		
		System.out.print("너비 : ");
		width = this.sc.nextInt();	sc.nextLine();
		
		String perimeter = rc.calcPerimeter(x, y, height, width);
		System.out.println(perimeter);
	}
	
	public void calcRectArea() { // 사각형 높이
		int x, y, width, height;
		
		System.out.print("x 좌표 : ");
		x = this.sc.nextInt();	sc.nextLine();
		
		System.out.print("y 좌표 : ");
		y = this.sc.nextInt();	sc.nextLine();
		
		System.out.print("높이 : ");
		height = this.sc.nextInt();	sc.nextLine();
		
		System.out.print("너비 : ");
		width = this.sc.nextInt();	sc.nextLine();
		
		String area = rc.calcArea(x, y, height, width);
		System.out.println(area);
	}
	
	public void calcRectSplit() { // 사각형 분할
		int x, y, split;
		float width, height;
		
		System.out.print("x 좌표 : ");
		x = this.sc.nextInt();	sc.nextLine();
		
		System.out.print("y 좌표 : ");
		y = this.sc.nextInt();	sc.nextLine();
		
		System.out.print("높이 : ");
		height = this.sc.nextFloat();	sc.nextLine();
		
		System.out.print("너비 : ");
		width = this.sc.nextFloat();	sc.nextLine();
		
		System.out.print("분리 갯수 : ");
		split = this.sc.nextInt();	sc.nextLine();
		
		String sp = rc.calcSplit(x, y, height, width, split);
		System.out.println(sp);
	}
}
