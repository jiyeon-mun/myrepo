package com.kh.exam17.arraylist;

import java.util.*;

import com.kh.exam17.arraylist.sample1.plusq.QnASample1;

public class Sample1 {
	
	public static void ex1() {
		List<Integer> aList = new ArrayList<Integer>(); // 다형성 접목
		
		// 주어진 객체 맨 끝에 추가
		aList.add(10);	aList.add(20);	aList.add(30);
		System.out.println(aList);
		
		// 지정한 인덱스에 객체 추가
		aList.add(1, 40);
		System.out.println(aList);
		
		// 지정한 인덱스의 데이터 수정
		aList.set(2, 24);
		System.out.println(aList);
		
		// 주어진 객체가 존재하는지 검색
		boolean resBool = aList.contains(10);
		System.out.println(resBool); // true/false
		
		// 주어진 인덱스로 저장된 객체 가져오기
		// 인덱스 범위를 벗어나면 에러
		int resInt = aList.get(0);
		System.out.println(resInt);
		
		// iterator(): 반복자 객체 반환해주는 메서드
		Iterator<Integer> iter = aList.iterator();
		while(iter.hasNext()) {
			System.out.println("Iterator로 추출 -> "+iter.next());
		}
		
		for(Integer i:aList) {
			System.out.println("for each로 추출 -> "+i);
		}
		
		// 컬렉션이 비어 있는지 조사
		// aList.clear(); // 컬렉션의 모든 객체 제거
		resBool=aList.isEmpty();
		System.out.println("aList의 내용이 비어있습니까? -> "+resBool);
		
		// 저장되어 있는 전체 객체 수
		resInt=aList.size();
		System.out.println("aList의 객체 수 -> "+resInt);
		
		// 주어진 인덱스로 객체 삭제; 정수값은 인덱스로 인식함
		// 삭제할 인덱스의 데이터를 반환시키고 삭제함.
		resInt=aList.remove(0);
		System.out.println(resInt+"  이(가) 삭제되어 "+aList+" 가 남았습니다.");
		
		// 주어진 객체를 찾아서 삭제 (주의: 정수데이터는 인덱스로 인식하기 때문에 Integer로 랩핑해야 함.)
		//resBool=aList.remove(Integer.valueOf(22));
		resBool=aList.remove(new Integer(22));
		System.out.println("객체 삭제가 되었습니까? -> "+resBool);
	}
	
	public static void main(String[] args) {
		//ex1();
		
		QnASample1 ans = new QnASample1();
		//ans.ex2();
		//ans.ex3();
		//ans.ex4();
		//ans.ex5();
		//ans.ex6();
		ans.ex7();
		//ans.ex8();
	}
}
