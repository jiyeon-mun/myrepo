package com.kh.exam6;

import java.util.Scanner;

public class PracIF1 {

	// 키보드 입력값 받기
	static Scanner sc = new Scanner(System.in);

	public static void ex1() {
		System.out.println("문제 1.");
		/*
		 * 영문자 알파벳 범위의 ASCII 코드 번호를 입력받은 경우에만 해당하는 문자를
		 * 출력하고 범위를 벗어난 경우에는 "ASCII 코드 영문자 범위를 벗어났습니다."
		 * 라는 메시지를 출력한다. 
		 * (ASCII 코드 영문자 범위 : 대문자65~90, 소문자97~122)
		 */
		 int num;

	     System.out.print("영문자 범위의 ASCII 코드 번호 입력 : ");
	     num = sc.nextInt(); sc.nextLine();
	        
	     // %d는 입력한 정수값, %c는 입력한 코드의 영문자 값
	     if (num >= 'A' && num < 'Z') { // A:65 ~ Z:90
	         System.out.printf("입력한 ASCII 코드 %d의 영문자는 %c 입니다.\n", num, num);
	     } else if (num >= 'a' && num <= 'z') { // a:97 ~ z:122
	         System.out.printf("입력한 ASCII 코드 %d의 영문자는 %c 입니다.\n", num, num);
	     } else {
	         System.out.println("ASCII 코드 영문자 범위를 벗어났습니다.");
	     }

	}

	public static void ex2() {
		System.out.println("문제 2.");
		/*
		 * 국어, 영어, 수학 세 과목의 시험 점수를 입력 받아 총점과 평균을 구하고
		 * 평균이 60점 이상인 경우에 "합격입니다." 메시지를 출력하고 60점 이상이
		 * 아닌 경우에 "불합격입니다." 메시지를 출력한다.
		 */
		int mth,kor,eng;
	    int total=0;
	    double avg=0;

	    System.out.print("국어점수 입력 (정수만) : ");
	    kor=sc.nextInt(); sc.nextLine();
	    System.out.print("수학점수 입력 (정수만) : ");
	    mth=sc.nextInt(); sc.nextLine();
	    System.out.print("영어점수 입력 (정수만) : ");
	    eng=sc.nextInt(); sc.nextLine();

	    total = mth + kor + eng;
	    avg = (double)total / 3;
	    System.out.println("총점 : " + total);
	    System.out.printf("평균 : %.2f\n", avg);

	    if (avg >= 60) {
	        System.out.println("합격입니다.");
	    } else {
	        System.out.println("불합격입니다.");
	    }

	}

	public static void ex3() {
		System.out.println("문제 3.");
		/*
		 * 2021년 7월에 한하여 1 ~ 31 일 범위의 일자값을 입력받고 해당 일자의
		 * 요일을 출력하게 한다. 입력값의 범위를 벗어난 경우 "1 ~ 31 사이의 값을
		 * 입력하세요." 라는 메시지를 출력한다.
		 */
		int date;

		System.out.print("2021년 7월에 한하여 1 ~ 31 일 범위의 일자값을 입력 : ");
		date = sc.nextInt();
		if (date >= 1 && date < 32) {
			
			// if문 이용: if() els if() 나열하여 이용하면 된다.

			// swtich문 이용. 조건식의 결과값에 맞는 case값에 대한 실행문 출력 후 break문으로 인해 탈출한다.
			switch (date % 7) {
			case 0:
				System.out.println("수요일");	break;
			case 1:
				System.out.println("목요일");	break;
			case 2:
				System.out.println("금요일");	break;
			case 3:
				System.out.println("토요일");	break;
			case 4:
				System.out.println("일요일");	break;
			case 5:
				System.out.println("월요일");	break;
			case 6:
				System.out.println("화요일");	break;
			}

			switch (date % 7) {
			// case 3과 case 4에 대한 실행문. 여러 케이스에 대한 실행문 작성법.
			case 3:
			case 4: 
				System.out.println("주말입니다.");	break;
			// 일치하는 case문이 없을 때 수행(= else). break문이 없어도 switch문 탈출한다.
			default: 
				System.out.println("주중입니다.");
			}
		} else {
			System.out.println("1 ~ 31 사이의 값을 입력하세요.");
		}
	}

	public static void ex4() {
		System.out.println("문제 4.");
		/*
		 * 나이를 입력하면 해당 나이대를 출력하도록 한다.
		 * 
		 * 예 1.)
		 * 		나이 입력 : 21
		 * 		20대 입니다.
		 * 
		 * 예 2.)
		 * 		나이 입력 : 12
		 * 		청소년 입니다.
		 * 
		 * 1 ~ 4 세까지는 영유아, 5 ~ 9 세까지는 어린이, 10 ~ 19 세까지는 청소년
		 * 20 ~ 100 까지는 20대, 30대, 40대, 50대 형식으로 변환하여 출력한다.
		 */
		int age;

		System.out.print("나이 입력 : ");
		age = sc.nextInt();	sc.nextLine();
		
		if (age >= 1 && age < 5) {
			System.out.println("영유아 입니다.");
		} else if (age >= 5 && age < 10) {
			System.out.println(" 어린이 입니다.");
		} else if (age >= 10 && age < 20) {
			System.out.println("청소년 입니다.");
		} else if (age >= 20 && age < 100) {
			System.out.println(age / 10 * 10 + " 대 입니다");
		} else {
			System.out.println("1 ~ 99 사이의 값을 입력해주세요.");
        }

	}

	public static void ex5() {
		System.out.println("문제 5.");
		/*
		 * 키(cm)와, 체중(kg)을 입력하여 BMI 지수를 구하고 BMI 지수에 해당하는 정상, 과체중,
		 * 비만, 고도비만 등의 정보를 출력하도록 한다.
		 * 
		 * BMI 지수의 계산식 -> BMI = 체중(kg) / (키(m) * 키(m))
		 * 
		 * BMI 지수에 따른 정보
		 * 		18.5 미만 : 저체중
		 * 		18.5 이상 ~ 23 미만 : 정상
		 * 		23 이상 ~ 25 미만 : 과체중
		 * 		25 이상 ~ 30 미만 : 비만
		 * 		30 이상 : 고도비만
		 */
		int cm, kg;
		double m; // bmi 지수 계산을 위해 cm를 m로 표현
		double bmi;
		

		System.out.print("키(cm) 입력(정수 입력) : ");
		cm = sc.nextInt();	sc.nextLine();
		System.out.print("체중(kg) 입력(정수 입력) : ");
		kg = sc.nextInt();	sc.nextLine();

		m = cm / 100.0; // cm -> m로 변환. 소수점 아래 2자리까지.
		
		bmi = kg / (m * m);
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
		/*
		 * 시간과 분을 따로 입력받고 추가로 분을 더 입력받아 입력받은 시간에서 추가로 입력한 분의
		 * 더한 시간을 출력하도록 한다. 입력 시간은 24시간 형식을 입력 받고 출력 시간은 오전/오후
		 * 를 구분하는 12시간 형식을 출력하도록 한다.
		 * 		- 24시간 형식의 12시 30분은 12시간 형식의 오후 12시 30분 이다.
		 * 		- 24시간 형식의 00시 30분은 12시간 형식의 오전 12시 30분 이다.
		 * 		- 24시간 형식의 23시 30분은 12시간 형식의 오후 11시 30분 이다.
		 * 		- 24시간 형식의 11시 30분은 12시간 형식의 오전 11시 30분 이다.
		 * 
		 * 예 1.)
		 * 		시간 입력 : 23
		 * 		분 입력 : 50
		 * 		추가 분 입력 : 20
		 * 		입력 시간에서 20분을 추가한 시간은 오전 12시 10분 입니다.
		 * 
		 * 0 ~ 23 시간의 입력 범위를 넘기면 지정한 범위의 값을 입력하도록하는 메시지 출력
		 */
	}

	public static void ex6_me() { // 강사님 방식이 훨씬 간단하다,,ㅎ
		System.out.println("문제 6.");
		
		int hour, min, pmin; // 입력받을 시간, 분, 추가분
        int nhour, nmin; // 추가분 입력으로 인해 바뀌게 되는 시간, 분 (시간은 바뀔 수도, 안바뀔 수도 있다.)
        String msg=""; // 오전, 오후 구분
        
        System.out.print("시간 입력(0 ~ 23) : ");
		hour = sc.nextInt();    sc.nextLine();
		System.out.print("분 입력(0 ~ 59) : ");
		min = sc.nextInt();    sc.nextLine();
		System.out.print("추가 분 입력 : ");
		pmin = sc.nextInt();    sc.nextLine();
        
        // 시간 입력 범위 (0~23)내, 분 입력 범위 (0~59) 내
        if(hour>=0&&hour<24){ 
            if(min>=0&&min<60){
                System.out.println("입력한 시간 : "+hour+"시 "+min+"분");
                
                // 새로운 분은 입력분에 추가분을 더한 값
                nmin=min+pmin; 
                
                // 추가분을 더한 결과값이 60 이상일 때 변경되는 시간과 분에 대한 환원 코드
                if(nmin>=60){
                    nhour=hour+(nmin/60);
                    nmin%=60;
                   
                    // 변경되는 시간이 24시간이 넘어가면 24로 나머지 계산하여 남은 값을 시간으로 취함
                    // 24시=>오전 0시(=>오전12시), 25시=>오전 1시...
					if(nhour>=24){
                        nhour%=24;
                        
                        // 오전/오후 구분
                        if(nhour>=0&&nhour<12){
                            if(nhour==0){nhour=12;} // 0시=>오전12시
                            msg="오전";
                            System.out.printf("입력한 시간에서 %d분을 추가한 시간은 %s %d시 %d분 입니다.", pmin,msg,nhour,nmin);
                        } else if(nhour>=12&&nhour<24){
                            nhour-=12; // 15시=>3시, 17시=>5시...
                            msg="오후";
                            System.out.printf("입력한 시간에서 %d분을 추가한 시간은 %s %d시 %d분 입니다.", pmin,msg,nhour,nmin);
                        }
                        
                    }
					// 변경되는 시간이 24시간을 넘어가지 않는 경우
					else{
                        // 오전/오후 구분
                        if(nhour>=0&&nhour<12){
                            msg="오전";
                            System.out.printf("입력한 시간에서 %d분을 추가한 시간은 %s %d시 %d분 입니다.", pmin,msg,nhour,nmin);
                        } else if(nhour>=12&&nhour<24){
                            nhour-=12;
                            msg="오후";
                            System.out.printf("입력한 시간에서 %d분을 추가한 시간은 %s %d시 %d분 입니다.", pmin,msg,nhour,nmin);
                        }
                     }       
                } 
                
                // 추가분을 더한 결과값이 60분 미만일 때  
                else{
                    // 시간 변경 없음
                    nhour=hour;
                    
                    // 오전/ 오후 구분
                    if(nhour>=0&&nhour<12){
                        if(nhour==0){nhour=12;} // 0시=>오전12시
                        msg="오전";
                        System.out.printf("입력한 시간에서 %d분을 추가한 시간은 %s %d시 %d분 입니다.", pmin,msg,nhour,nmin);
                    } else if(nhour>=12&&nhour<24){
                        nhour-=12;
                        msg="오후";
                        System.out.printf("입력한 시간에서 %d분을 추가한 시간은 %s %d시 %d분 입니다.", pmin,msg,nhour,nmin);
                    }
                }
                
            // 입력분의 범위 초과 시  
            } else{
                System.out.println("0 ~ 59 분 사이의 숫자를 입력해주세요.");
            }
        // 입력시간의 범위 초과 시
        } else{
            System.out.println("0 ~ 23 시간 사이의 숫자를 입력해주세요.");
        }
	}
	
	public static void ex6_lecturer() {
		System.out.println("문제 6.");
		
		int hour, minute, addMinute; // 시간, 분, 추가분

		System.out.print("시간 입력 : ");
		hour = sc.nextInt();	sc.nextLine();

		System.out.print("분 입력 : ");
		minute = sc.nextInt();	sc.nextLine();

		System.out.print("추가 분 입력 : ");
		addMinute = sc.nextInt();	sc.nextLine();

		// 시간 입력 범위 내, 분 입력 범위 내
		if(hour >= 0 && hour <= 23) {
			if(minute >= 0 && minute < 60) {
				
				// 입력 분에 추가분 더함.
				minute = minute + addMinute;
				
				// 추가분을 더한 결과가 60을 넘으면 시간, 분 변경 코드
				if(minute >= 60) {
					hour = hour + (minute / 60);
					minute = minute % 60;
				}
				
				// 24 시간이 넘어가면 24로 나머지 계산하여 나머지 값을 시간으로 취함
				// (* 24시간이 넘어가지 않는다면 바로 326줄부터 실행)
				if(hour >= 24) {
					hour = hour % 24;
				}
				// 24시간이 넘든 안넘든 실행함
				if(hour == 0) { // 0시 => 오전 12시 
					System.out.printf("입력 시간에서 %d 분을 추가한 시간은 오전 12시 %d분 입니다.",
							addMinute, minute);
				} else if(hour == 12) {
					System.out.printf("입력 시간에서 %d 분을 추가한 시간은 오후 12시 %d분 입니다.",
							addMinute, minute);
				} else if(hour >= 1 && hour <= 11) {
					System.out.printf("입력 시간에서 %d 분을 추가한 시간은 오전 %d시 %d분 입니다.",
							addMinute, hour, minute);
				} else if(hour >= 13 && hour <= 23) { // 13시 => 오전 1시, 14시 => 오전 2시...
					System.out.printf("입력 시간에서 %d 분을 추가한 시간은 오후 %d시 %d분 입니다.",
							addMinute, hour - 12, minute);
				}

			} else {
				System.out.println("0 ~ 59 사이의 분을 입력하세요.");
			}
		} else {
			System.out.println("0 ~ 23 사이의 시간을 입력하세요.");
		}
		
	}

	public static void ex7() {
		System.out.println("문제 7.");
		
		char op;

		System.out.print("사칙연산 기호를 입력하세요 : ");

		// charAt(숫자): String으로 저장된 문자열 중 한 글자만 선택해서 char 타입으로 변환. 숫자는 0부터 시작
		// 입력받은 문자열 중 0번째 위치의 한 글자를 op에 저장
		op = sc.nextLine().charAt(0);
		
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
		System.out.println("문제 8.");
		
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

	public static void ex9() {
		System.out.println("문제 9.");
		/*
		 * 단위 변환 프로그램 만들기
		 * 
		 * 1. cm -> m 로 변환 또는 m -> cm 로 변환 하는 기능을 만든다.
		 * 2. g -> kg 으로, kg -> g 으로 변환하는 기능을 만든다.
		 * 3. Byte -> KByte 로, KByte 를 Byte로 변환하는 기능을 만든다.
		 * 
		 * 각각의 기능은 처음 입력하는 단위가 무엇인가에 따라 바뀌게 된다.
		 * 
		 * 예 1.)
		 * 		단위변환 입력 : cm
		 * 		cm 값을 입력하면 m 값으로 변환 합니다.
		 * 		cm 입력 : 100
		 * 		결과 : 1.0m 입니다.
		 * 
		 * 예 2.)
		 * 		단위변환 입력 : KByte
		 * 		KByte 값을 입력하면 Byte 값으로 변환 합니다.
		 * 		KByte 입력 : 1
		 * 		결과 : 1024.0Byte 입니다.
		 */
		
		String unit; // 변환할 단위
		double num; // 숫자 입력
		double chnum; // 단위변환에 따른 변환된 값

		System.out.print("단위변환 입력 : ");
		unit = sc.nextLine();
		
		// 입력한 단위에 대해서 단위변환 진행
		switch (unit) {
		case "cm":
			System.out.println("cm 값을 입력하면 m 값으로 변환 합니다.");
			System.out.printf("%s 입력 : ", unit);
			num = sc.nextDouble();	sc.nextLine();
			chnum = num / 100.0; // 단위변환에 따른 값 변환. cm -> m; 1m = 100cm
			System.out.println("결과 : " + chnum + "m 입니다.");
			break;
		case "kg":
			System.out.println("kg 값을 입력하면 g 값으로 변환 합니다.");
			System.out.printf("%s 입력 : ", unit);
			num = sc.nextDouble();	sc.nextLine();
			chnum = num * 1000.0; // kg -> g; 1g = 0.001kg
			System.out.println("결과 : " + chnum + "g 입니다.");
			break;
		case "Byte":
			System.out.println("Byte 값을 입력하면 KByte 값으로 변환 합니다.");
			System.out.printf("%s 입력 : ", unit);
			num = sc.nextDouble();	sc.nextLine();
			chnum = num / 1024.0; // Byte -> KByte; 1KB = 1024Byte
			System.out.println("결과 : " + chnum + "KByte 입니다.");
			break;
		case "g":
			System.out.println("g 값을 입력하면 kg 값으로 변환 합니다.");
			System.out.printf("%s 입력 : ", unit);
			num = sc.nextDouble();	sc.nextLine();
			chnum = num / 1000.0; // g -> kg; 1kg = 1000g
			System.out.println("결과 : " + chnum + "kg 입니다.");
			break;
		case "m":
			System.out.println("m 값을 입력하면 cm 값으로 변환 합니다.");
			System.out.printf("%s 입력 : ", unit);
			num = sc.nextDouble();	sc.nextLine();
			chnum = num * 100.0; // m -> cm; 1cm = 0.01m
			System.out.println("결과 : " + chnum + "cm 입니다.");
			break;
		case "KByte":
			System.out.println("KByte 값을 입력하면 Byte 값으로 변환 합니다.");
			System.out.printf("%s 입력 : ", unit);
			num = sc.nextDouble();	sc.nextLine();
			chnum = num * 1024.0; // KByte -> Byte; 1Byte = 1/1024KB
			System.out.println("결과 : " + chnum + "Byte 입니다.");
			break;
		default:
			System.out.println("단위를 잘못 입력하셨습니다.");
		}
	}

	public static void main(String[] args) {
		 //ex1();
		 //ex2();
		 //ex3();
		 //ex4();
		 //ex5();
		 ex6_me();
		 ex6_lecturer();
		 //ex7();
		 //ex8();
		 //ex9();
	}

}
