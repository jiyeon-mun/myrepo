package com.kh.exam16;

import java.util.Date;

public class Sample2 {

	public static void main(String[] args) {
		// 문자열을 기본 자료형으로 변환
		int resInt = Integer.parseInt("12345");
		System.out.println(resInt+10);
		double resDouble = Double.parseDouble("123.456");
		System.out.println(resDouble+10); // 부정확한 실수가 출력된다.
		
		// 기본 자료형을 문자열로 변환(기존 방법)
		String resStr = ""+resInt;
		System.out.println(resStr+".");
		resStr = ""+resDouble;
		System.out.println(resStr+".");
		
		// 기본 자료형을 문자열로 변환(Wrapper 이용 방법)
		resStr=Integer.valueOf(resInt).toString();
		System.out.println(resStr+".");
		resStr=Double.valueOf(resDouble).toString();
		System.out.println(resStr+".");
		
		// 성능 측정
		Date start, end;
		start = new Date(); // 시작시간 기록
		for (int i = 0; i < 99999; i++) {
			resStr = "" + resInt;
		}
		end = new Date(); // 종료시간 기록
		System.out.println("성능 측정 결과: " + (end.getTime() - start.getTime())); // 시간의 차

		start = new Date();
		for (int i = 0; i < 99999; i++) {
			resStr = Integer.valueOf(resInt).toString();
		}
		end = new Date();
		System.out.println("성능 측정 결과: " + (end.getTime() - start.getTime()));
	}

}
