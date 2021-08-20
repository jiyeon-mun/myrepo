package com.kh.exam16;

import java.util.StringTokenizer;

public class Sample5 {

	public static void main(String[] args) {
		String str = "StringTokenizer로 문자열을 분리하는 예제";
		StringTokenizer st = new StringTokenizer(str," "); // 공백으로 분리
		
		// 분리 기준 요소가 있는지 반복해서 확인하고 true인 경우
		while(st.hasMoreElements()) {
			// 분리된 문자열 중 앞의 문자열을 가져온다.
			System.out.println(st.nextToken());	
		}
		
	}

}
