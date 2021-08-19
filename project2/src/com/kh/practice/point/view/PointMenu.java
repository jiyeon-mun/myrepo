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
	
	/*
	 * 다른 메서드들 내 공통적으로 적용되는 코드 따로 메서드로 정의해두기
	 * 		- 정수형 문자열 입력, 입력문자열을 정수형으로 변환
	 * 		- 정수배열 이용
	 * 
	 * 		1. 입력을 요구하는 수량만큼 입력되지 않은 경우 모자른 입력값에 대해 1로 초기화한다.
	 * 		2. 입력한 정수 문자열을 공백으로 분리하여 문자열 배열 내 각 데이터 요소로 저장
	 * 		3. 분리된 정수 문자열을 정수형으로 바꾸어 전달된 count(입력받아야 하는 정수문자열 개수)를 크기로 지정한 정수배열에 차례로 저장하는데
	 * 		  입력값이 정수배열의 크기를 다 채우고 넘어가는 경우 더이상 저장하지 않음
	 */
	private int[] multiInput(int count) {
		int[] inputs = new int[count];
		for(int i=0;i<inputs.length;i++) {
			inputs[i]=1;
		}
		
		String[] temp =this.sc.nextLine().split(" ");
		
		int idx=0;
		for(String s:temp) {
			if(idx<inputs.length) {
				inputs[idx++]=Integer.parseInt(s);
			} else {
				break;
			}
		}
		return inputs;
	}
	
	// 원 둘레
	public void calcCircum() {
		// 입력값들 정수형으로 저장할 배열 생성; 필요한 입력값 개수에 맞춰서 생성
		int[] inputs = new int[3];
		
		System.out.println("공백을 구분자로 사용하여 다음 내용에 맞은 데이터를 입력하세요.");
		System.out.print("x, y 좌표, 반지름을 순서대로 입력하세요. : ");
		inputs = multiInput(3); // 공통코드 함수 호출, 3개의 값이 입력되어야 한다.
		
		String circum = cc.calcCircum(inputs[0], inputs[1], inputs[2]);
		System.out.println(circum);
	}
	
	// 원 넓이
	public void calcCircleArea() {
		int[] inputs = new int[] {1, 1, 1};
		
		System.out.println("공백을 구분자로 사용하여 다음 내용에 맞은 데이터를 입력하세요.");
		System.out.print("x, y 좌표, 반지름을 순서대로 입력하세요. : ");
		inputs = multiInput(3);
		
		String area = cc.calcArea(inputs[0], inputs[1], inputs[2]);
		System.out.println(area);
	}
	
	// 사각형 둘레
	public void calcPerimeter() {
		int[] inputs = new int[4];
		
		System.out.println("공백을 구분자로 사용하여 다음 내용에 맞은 데이터를 입력하세요.");
		System.out.print("x, y 좌표, 높이, 너비 순서대로 입력하세요. : ");
		inputs = multiInput(4);
		
		String perimeter = rc.calcPerimeter(inputs[0], inputs[1], inputs[2], inputs[3]);
		System.out.println(perimeter);
	}
	
	// 사각형 높이
	public void calcRectArea() {		
		int[] inputs = new int[] {0, 0, 0, 0};
		
		System.out.println("공백을 구분자로 사용하여 다음 내용에 맞은 데이터를 입력하세요.");
		System.out.print("x, y 좌표, 높이, 너비 순서대로 입력하세요. : ");
		inputs = multiInput(4);
		
		String area = rc.calcArea(inputs[0], inputs[1], inputs[2], inputs[3]);
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
