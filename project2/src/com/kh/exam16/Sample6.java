package com.kh.exam16;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

public class Sample6 {

	public static void ex1() {
		Date date = new Date();
		
		// Fri Aug 20 10:32:42 KST 2021 형시그로 출력됨
		System.out.println(date);
		
		// 1970년 1월 1일 0시 0분 0초를 기준으로 얼마나 지났는지 초단위로 표기
		System.out.println(date.getTime());
		
		String sDate = "%tY년";
		System.out.println(String.format(sDate, date));
		
		sDate = "%tm월";
		System.out.println(String.format(sDate, date));
		
		sDate = "%td일";
		System.out.println(String.format(sDate, date));
		
		sDate = "%tH시";
		System.out.println(String.format(sDate, date));
		
		sDate = "%tM분";
		System.out.println(String.format(sDate, date));
		
		sDate = "%tS초";
		System.out.println(String.format(sDate, date));
		
		sDate = "%tL밀리초";
		System.out.println(String.format(sDate, date));

		sDate = "%1$tY-%1stm-%1$td %1$tH:%1$tM:%1$tS.%1$tL";
		System.out.println(String.format(sDate, date));
	}
	
	public static void ex2() {
		// Calendar date = new Calendar(); new 이용한 객체생성 불가
		Calendar date = Calendar.getInstance();

		int year = date.get(Calendar.YEAR);
		System.out.println(year + "년");
		
		int month = date.get(Calendar.MONTH) + 1; // MONTH는 0부터 시작됨.
		System.out.println(month + "월");
		
		int day = date.get(Calendar.DATE);
		System.out.println(day + "일");
		
		int hour = date.get(Calendar.HOUR);
		System.out.println(hour + "시");
		
		int min = date.get(Calendar.MINUTE);
		System.out.println(min + "분");
		
		int scd = date.get(Calendar.SECOND);
		System.out.println(scd + "초");
		
		int mills = date.get(Calendar.MILLISECOND);
		System.out.println(mills + "밀리초");
		
		System.out.println("현재 날짜: "+date.getTime());
		
		date.add(Calendar.YEAR, -1);
		System.out.println("이전 년도 날짜: "+date.getTime());
		date.add(Calendar.MONTH, 2);
		System.out.println("2개월 뒤: "+date.getTime());
		date.add(Calendar.DATE, 7);
		System.out.println("일주일 뒤: "+date.getTime());
	}
	
	public static void ex3() {
		// Calendar클래스의 후손 클래스
		GregorianCalendar date = new GregorianCalendar();

		int year = date.get(Calendar.YEAR);
		System.out.println(year + "년");

		int month = date.get(Calendar.MONTH) + 1; // MONTH는 0부터 시작됨.
		System.out.println(month + "월");

		int day = date.get(Calendar.DATE);
		System.out.println(day + "일");

		int hour = date.get(Calendar.HOUR);
		System.out.println(hour + "시");

		int min = date.get(Calendar.MINUTE);
		System.out.println(min + "분");

		int scd = date.get(Calendar.SECOND);
		System.out.println(scd + "초");

		int mills = date.get(Calendar.MILLISECOND);
		System.out.println(mills + "밀리초");

		date.add(Calendar.YEAR, -1);
		System.out.println("이전 년도 날짜: " + date.getTime());

		date = new GregorianCalendar(); // 현재시간 리셋
		date.add(Calendar.MONTH, 2);
		System.out.println("2개월 뒤: " + date.getTime());
		
		date = new GregorianCalendar();
		date.add(Calendar.DATE, 7);
		System.out.println("일주일 뒤: " + date.getTime());

		// 윤년 확인
		System.out.println(date.isLeapYear(2020));
		
		// 타임존 설정 후 해당 타임존의 시간 출력
		System.out.println(date.getTimeZone().getDisplayName());
		System.out.println(date.toZonedDateTime());
		
		date.setTimeZone(TimeZone.getTimeZone("America/Los_Angeles"));
		System.out.println(date.getTimeZone().getDisplayName());
		System.out.println(date.toZonedDateTime());
		
		date.setTimeZone(TimeZone.getTimeZone("Asia/Tokyo"));
		System.out.println(date.getTimeZone().getDisplayName());
		System.out.println(date.toZonedDateTime());
		
		date.setTimeZone(TimeZone.getTimeZone("Asia/Seoul"));
		System.out.println(date.getTimeZone().getDisplayName());
		System.out.println(date.toZonedDateTime());
		
		date.setTimeZone(TimeZone.getTimeZone("Europe/London"));
		System.out.println(date.getTimeZone().getDisplayName());
		System.out.println(date.toZonedDateTime());
		
		date.setTimeZone(TimeZone.getTimeZone("Europe/Vatican"));
		System.out.println(date.getTimeZone().getDisplayName());
		System.out.println(date.toZonedDateTime());		
	}
	
	public static void ex4() {
		GregorianCalendar gc = new GregorianCalendar();
		SimpleDateFormat dFormat = new SimpleDateFormat("yyyy-MM-dd");
		
		String date = dFormat.format(gc.getTime());
		System.out.println(date);
		
		dFormat.applyPattern("yyyy-MM-dd HH:mm:ss.sss");
		date = dFormat.format(gc.getTime());
		System.out.println(date);
	}
	
	public static void main(String[] args) {
		// ex4();
		ex3();
		// ex2();
		// ex1();
	}
}
