package com.kh.exam6;

import java.util.Scanner;

public class PracIF1 {

	static Scanner sc = new Scanner(System.in);

	public static void ex1() {
		// ASCII 코드 영문자 범위 : 대문자65~90, 소문자97~122; 0~127
		int a;

		System.out.print("0 ~ 127 범위의 정수만 입력 : ");
		a = sc.nextInt();
		sc.nextLine();

		if (a >= 65 && a < 91 || a >= 97 && a < 123) {
			System.out.printf("%c\n", a);
		} else {
			System.out.println("ASCII 코드 영문자 범위를 벗어났습니다.");
		}

	}

	public static void ex2() {
		int ks, es, ms;
		int total;
		float avg;

		System.out.print("국어 점수 입력(단, 정수로 입력) : ");
		ks = sc.nextInt();
		sc.nextLine();
		System.out.print("영어 점수 입력(단, 정수로 입력) : ");
		es = sc.nextInt();
		sc.nextLine();
		System.out.print("수학 점수 입력(단, 정수로 입력) : ");
		ms = sc.nextInt();
		sc.nextLine();

		total = ks + es + ms;
		avg = total / 3;
		System.out.println("점수 총합은 " + total + " 입니다.");
		System.out.printf("점수 평균은 %.2f 입니다.\n", avg);

		if (avg >= 60) {
			System.out.println("합격입니다.");
		} else {
			System.out.println("불합격입니다.");
		}

	}

	public static void ex3() {

		int date;

		System.out.print("2021년 7월에 한하여 1 ~ 31 일 범위의 일자값을 입력 : ");
		date = sc.nextInt();
		if (date >= 1 && date < 32) {
//			if (date % 7 == 1) {
//				System.out.println("목요일");
//			} else if (date % 7 == 2) {
//				System.out.println("금요일");
//			} else if (date % 7 == 3) {
//				System.out.println("토요일");
//			} else if (date % 7 == 4) {
//				System.out.println("일요일");
//			} else if (date % 7 == 5) {
//				System.out.println("월요일");
//			} else if (date % 7 == 6) {
//				System.out.println("화요일");
//			} else if (date % 7 == 0) {
//				System.out.println("수요일");
//			}

			// swtich문 이용. break란 조건식에 맞는 값만 출력할 수 있게 해준다!!
			switch (date % 7) {
			case 0:
				System.out.println("수요일");
				break;
			case 1:
				System.out.println("목요일");
				break;
			case 2:
				System.out.println("금요일");
				break;
			case 3:
				System.out.println("토요일");
				break;
			case 4:
				System.out.println("일요일");
				break;
			case 5:
				System.out.println("월요일");
				break;
			case 6:
				System.out.println("화요일");
				break;
			}

			switch (date % 7) {
			case 3:
			case 4: // 여러 케이스 작성. 범위지정.
				System.out.println("주말입니다.");
				break;
			default:
				System.out.println("주중입니다.");
			}
		} else {
			System.out.println("1 ~ 31 사이의 값을 입력하세요.");
		}
	}

	public static void ex4() {
		int age;

		System.out.print("나이 입력 : ");
		age = sc.nextInt();
		sc.nextLine();
		if (age >= 1 && age < 5) {
			System.out.println("영유아 입니다.");
		} else if (age >= 5 && age < 10) {
			System.out.println(" 어린이 입니다.");
		} else if (age >= 10 && age < 20) {
			System.out.println("10대 입니다.");
		} else if (age >= 20 && age < 30) {
			System.out.println("20대 입니다.");
		} else if (age >= 30 && age < 40) {
			System.out.println("30대 입니다.");
		} else if (age >= 40 && age < 50) {
			System.out.println("40대 입니다.");
		} else if (age >= 50 && age < 60) {
			System.out.println("50대 입니다.");
		} else {
			System.out.println("노년층 입니다");
		}

	}

	public static void ex5() {
		int cm, kg;
		double bmi;
		double m;

		System.out.print("키(cm) 입력(정수 입력) : ");
		cm = sc.nextInt();
		sc.nextLine();
		System.out.print("체중(kg) 입력(정수 입력) : ");
		kg = sc.nextInt();
		sc.nextLine();

		m = cm / 100.0; // cm -> m로 변환.
		// m = cm / 100 + cm % 100 / 10 * 0.1 + cm % 100 % 10 * 0.01;
		// System.out.println(m);
		bmi = kg / (m * m);
		// System.out.println(bmi);
		if (bmi < 18.5) {
			System.out.println("저체중");
		} else if (bmi >= 18.5 && bmi < 23) {
			System.out.println("정상");
		} else if (bmi >= 23 && bmi < 25) {
			System.out.println("과체중");
		} else if (bmi >= 25 && bmi < 30) {
			System.out.println("비만");
		} else if (bmi >= 30) {
			System.out.println("고도비만");
		}

	}

	public static void ex6() {
		int hour, min, pmin;
		int nhour, nmin;
		String msg;

		System.out.print("시간 입력(0 ~ 23) : ");
		hour = sc.nextInt();
		sc.nextLine();
		System.out.print("분 입력(0 ~ 60) : ");
		min = sc.nextInt();
		sc.nextLine();
		System.out.print("추가 분 입력(0 ~ 60) : ");
		pmin = sc.nextInt();
		sc.nextLine();

		if (hour >= 0 && hour < 24) {
			if ((min >= 0 && min < 60) && (pmin >= 0 && pmin < 60)) {
				nhour = hour;
				nmin = min + pmin;
				if (nmin >= 60) { // 추가분을 더한 새로운 분이 60분 이상인 경우
					nhour += 1; // 기존 시간에서 한시간이 증가
					nmin %= 60;
					if (nhour == 24) {
						nhour = 0;
					}
					if (nhour >= 0 && nhour < 12) { // 한시간이 증가한 시간이 0~11시 사이일 때 오전
						msg = "오전";
						System.out.printf("입력 시간에서 %d분을 추가한 시간은 %s %d시 %d분 입니다.\n", pmin, msg, nhour, nmin);
					} else { // 한시간이 증가한 시간이 12~23시일 때 오후
						nhour -= 12;
						msg = "오후";
						System.out.printf("입력 시간에서 %d분을 추가한 시간은 %s %d시 %d분 입니다.\n", pmin, msg, nhour, nmin);
					}
				} else { // 추가분을 더했으나 60분 이하인 경우
					if (nhour >= 0 && nhour < 12) { // 기존시간을 그대로 받은 시간의 범위로 오전/오후를 나눈다.
						msg = "오전";
						System.out.printf("입력 시간에서 %d분을 추가한 시간은 %s %d시 %d분 입니다.\n", pmin, msg, nhour, nmin);
					} else {
						nhour -= 12;
						msg = "오후";
						System.out.printf("입력 시간에서 %d분을 추가한 시간은 %s %d시 %d분 입니다.\n", pmin, msg, nhour, nmin);
					}
				}
			} else {
				System.out.println("0 ~ 59분 사이의 값을 입력해주세요.");
			}
		} else {
			System.out.println("0 ~ 23시간 사이의 값을 입력해주세요.");
		}
	}

	public static void ex7() {
		char op;

		System.out.print("사칙연산 기호를 입력하세요 : ");

		op = sc.nextLine().charAt(0); // 숫자는 입력받은 문자의 위치로 0부터 시작
		switch (op) {
		case '+':
			System.out.println("더하기 기호를 입력했습니다.");
			break;
		case '-':
			System.out.println("더하기 기호를 입력했습니다.");
			break;
		case '/':
			System.out.println("더하기 기호를 입력했습니다.");
			break;
		case '*':
			System.out.println("더하기 기호를 입력했습니다.");
			break;
		default:
			System.out.println("사칙연산 기호가 아닙니다.");

		}
	}

	public static void ex8() {
		String op;

		System.out.println("\"더하기, 곱하기, 나누기, 빼기\" 중 하나를 선택하여 입력하세요.");
		System.out.print(": ");

		op = sc.nextLine();
		switch (op) {
		case "더하기":
			System.out.println("더하기는 + 기호를 사용합니다.");
			break;
		case "빼기":
			System.out.println("빼기는 - 기호를 사용합니다.");
			break;
		case "곱하기":
			System.out.println("곱하기는 * 기호를 사용합니다.");
			break;
		case "나누기":
			System.out.println("나누기는 / 기호를 사용합니다.");
			break;
		default:
			System.out.println("\"더하기, 빼기, 곱하기, 나누기\" 중 하나를 입력하세요.");
		}
	}

	public static void ex9() { // 단위 변환 프로그램. switch문 이용
		String unit;
		double num;
		double chnum;

		System.out.print("단위변환 입력 : ");
		unit = sc.nextLine();
		switch (unit) {
		case "cm":
			System.out.println("cm 값을 입력하면 m 값으로 변환 합니다.");
			System.out.printf("%s 입력 : ", unit);
			num = sc.nextDouble();	sc.nextLine();
			chnum = num / 100.0;
			System.out.println("결과 : " + chnum + "m 입니다.");
			break;
		case "kg":
			System.out.println("kg 값을 입력하면 g 값으로 변환 합니다.");
			System.out.printf("%s 입력 : ", unit);
			num = sc.nextDouble();	sc.nextLine();
			chnum = num * 1000.0;
			System.out.println("결과 : " + chnum + "g 입니다.");
			break;
		case "Byte":
			System.out.println("Byte 값을 입력하면 KByte 값으로 변환 합니다.");
			System.out.printf("%s 입력 : ", unit);
			num = sc.nextDouble();	sc.nextLine();
			chnum = num / 1024.0;
			System.out.println("결과 : " + chnum + "KByte 입니다.");
			break;
		case "g":
			System.out.println("g 값을 입력하면 kg 값으로 변환 합니다.");
			System.out.printf("%s 입력 : ", unit);
			num = sc.nextDouble();	sc.nextLine();
			chnum = num / 1000.0;
			System.out.println("결과 : " + chnum + "kg 입니다.");
			break;
		case "m":
			System.out.println("m 값을 입력하면 cm 값으로 변환 합니다.");
			System.out.printf("%s 입력 : ", unit);
			num = sc.nextDouble();	sc.nextLine();
			chnum = num * 100.0;
			System.out.println("결과 : " + chnum + "cm 입니다.");
			break;
		case "KByte":
			System.out.println("KByte 값을 입력하면 Byte 값으로 변환 합니다.");
			System.out.printf("%s 입력 : ", unit);
			num = sc.nextDouble();	sc.nextLine();
			chnum = num * 1024.0;
			System.out.println("결과 : " + chnum + "Byte 입니다.");
			break;
		default:
			System.out.println("단위를 잘못 입력하셨습니다.");
		}
	}

	public static void main(String[] args) {
		// ex1();
		// ex2();
		// ex3();
		// ex4();
		// ex5();
		// ex6();
		// ex7();
		// ex8();
		ex9();
	}

}
