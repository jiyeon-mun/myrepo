package com.kh.exam16;

import java.util.Arrays;

public class Sample1 {

	public static void main(String[] args) {
		String str = "문자열 생성";
		boolean resBool = str.equals("동일 문자열 확인");
		System.out.println(resBool);
		
		str="문자열에서 일부 문자만 추출";
		char resChar = str.charAt(0); // 인덱스는 0부터 시작
		System.out.println(resChar);
		
		str="문자열의 길이를 구함";
		int resInt = str.length(); // 문자열 길이는 1부터 시작
		System.out.println(resInt);
		
		str = "문자열과 문자열 붙이기";
		String resStr1 = str.concat(" / 메서드 이용 문자열이 붙었습니다.");
		String resStr2 =" / 이것은 +연산자 이용";
		System.out.println(resStr1);
		System.out.println(str+resStr2);
		
		str = "\t\t불필요한 앞/뒤 공백 제거\t\t";
		String resStr = str.trim();
		System.out.println(resStr);
		
		str = "문자열에서 지정한 문자열의 위치 찾기";
		resInt  = str.indexOf("문자열");
		System.out.println(resInt);
		
		// 이전에 찾은 위치 다음 인덱스부터 해당 문자열 다시 찾기
		resInt = str.indexOf("문자열",resInt+1);
		System.out.println(resInt);
		str = "이 문자열에는 다양한 문자들이 포함되어 있는 문자열 입니다.";
		resInt = str.indexOf("문자"); // 2번 위치
		System.out.println(resInt);
		resInt = str.indexOf("문자",resInt+1); // index3 위치부터 문자 찾음; 12번 위치
		System.out.println(resInt); 
		resInt = str.indexOf("문자",resInt+1); // index13 위치부터 문자 찾음; 15번 위치
		System.out.println(resInt);
		resInt = str.indexOf("문자",resInt+1); // index16 위치부터 문자 찾음; -1; 없음
		System.out.println(resInt);
		
		/*
		 * 문자열에서 특정 문자열의 모든 위치를 찾아 배열에 담는 코드
		 * 동적배열 이용
		 */
		int[] resIntArr = new int[0];
		int idx=-1; // 처음은 0부터 시작하도록 & 반복할 때마다 다음 위치부터 찾을 수 있도록
		while(true) {
			if (str.indexOf("문자", idx + 1) != -1) { // 처음은 0부터 시작하도록 & 반복할 때마다 다음 위치부터 찾을 수 있도록
				int[] tmp = new int[resIntArr.length+1];
				System.arraycopy(resIntArr, 0, tmp, 0, resIntArr.length);
				idx=str.indexOf("문자", idx + 1); // 찾은 위치 기록하고 배열에 저장 후 다음 인덱스부터 다시 찾기
				tmp[tmp.length-1]=idx;
				resIntArr=tmp;
			} else {
				break;
			}
		}
		System.out.println(Arrays.toString(resIntArr));
		
		str = String.format("정수 포맷: %d", 10);
		System.out.println(str);
		str = String.format("실수 포맷: %.2f", 10.1234);
		System.out.println(str);
		str = String.format("천단위구분 포맷: %,.2f", 123456.789); // 천단위구분은 ,(쉼표) 넣기
		System.out.println(str);
		str = String.format("문자열 포맷: %s", "여기 문자열 포맷");
		System.out.println(str);
		str = String.format("일정한 영역에서 오른쪽 정렬 포맷: %5d", 123); // ~~123 (~은 공백)
		System.out.println(str);
		str = String.format("일정한 영역에서 왼쪽 정렬 포맷: %-5d", 123); //123~~ (~은 공백)
		System.out.println(str);
		str = String.format("일정한 영역에서 오른쪽 정렬 포맷: %5s", "abc"); // ~~123 (~은 공백)
		System.out.println(str);
		str = String.format("일정한 영역에서 왼쪽 정렬 포맷: %-5s", "abc"); //123~~ (~은 공백)
		System.out.println(str);
		str = String.format("빈 공간 0으로 채우기 포맷: %05d", 123);
		System.out.println(str);
		
		str = String.format("%s의 나이는 %d세 입니다.", "홍길동",30);
		System.out.println(str);
		// 매개변수 맞는 위치 지정: $부호 사용; 위치값			  1$	2$
		str = String.format("%2$s의 나이는 %1$d세 입니다.", 30, "홍길동");
		System.out.println(str);
		str = "아스키 코드 %1$d는 아스키 문자 %1$c 입니다.";
		resStr = String.format(str, 65);
		System.out.println(resStr);
	}
}
