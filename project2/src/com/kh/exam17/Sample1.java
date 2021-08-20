package com.kh.exam17;

import java.util.*;
//import java.util.ArrayList; import java.util.List; import java.util.Random;

public class Sample1 {
	public static Scanner sc = new Scanner(System.in);
	public static Random rd = new Random();
	
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

	public static void ex2() {
		System.out.println("공백을 구분자로 사용하여 다음 내용에 맞은 데이터를 입력하세요.");
		System.out.print("정수값을 2개 이상 입력하세요. : ");
		String[] inputs=sc.nextLine().split(" ");
		// System.out.println(Arrays.toString(inputs));		
		
		List<Integer> intArr = new ArrayList<Integer>();
		
		// 입력한 데이터들 정수형으로 바꾸어 컬렉션에 저장
		int idx=0;
		for(String s:inputs) {
			if(idx<inputs.length) {
				intArr.add(idx++,Integer.parseInt(s));
			}
		}
//		for(int i=0;i<inputs.length;i++) {
//		intArr.add(i, Integer.parseInt(inputs[i]));
//	}
		System.out.println(intArr);
		
		// 컬렉션에 저장된 데이터들 반복자리턴 이용해 합계 구하기
		int sum=0;
		Iterator<Integer> iter = intArr.iterator();
		while(iter.hasNext()) {
			sum+=iter.next();
		}
		System.out.println(sum);
	}
	
	public static void ex3() {
		System.out.println("공백을 구분자로 사용하여 다음 내용에 맞은 데이터를 입력하세요.");
		System.out.print("실수값을 2개 이상 입력하세요. : ");
		String[] inputs=sc.nextLine().split(" ");
		
		List<Float> floatArr = new ArrayList<Float>();
		
		int idx=0;
		for(String s:inputs) {
			if(idx<inputs.length) {
				floatArr.add(idx++,Float.parseFloat(s));
			}
		}
		System.out.println(floatArr);
		
		float sum=0;
		Iterator<Float> iter = floatArr.iterator();
		while(iter.hasNext()) {
			sum+=iter.next();
		}
		System.out.println(sum);
		System.out.printf("%.2f",sum/floatArr.size());
	}
	
	public static void ex4() {
		System.out.println("공백을 구분자로 사용하여 다음 내용에 맞은 데이터를 입력하세요.");
		System.out.print("정수값을 한 개 이상 입력하세요. : ");
		
		// 정수입력값을 저장한 문자열배열을 정수형배열로 바꿈
		String[] inputs=sc.nextLine().split(" ");
		int cnt=inputs.length;
		int[] intInputs= new int[cnt];
		int idx1=0;
		for(String s:inputs) {
			if(idx1<intInputs.length) {
				intInputs[idx1++]=Integer.parseInt(s);
			}
		}
		System.out.println(Arrays.toString(intInputs)); // 입력값들 정수배열로 저장됐는지 확인
		
		// 입력된 정수들을 저장한 정수배열 중 중복값은 제거한 새로운 정수배열 생성
		boolean isDuplicate=false;
		int[] noDuplicate = new int[0];
		for(int i=0;i<intInputs.length;i++) {
			for(int j=0;j<noDuplicate.length;j++) {
				if(intInputs[i]==noDuplicate[j]) {
					isDuplicate=true;
					break;
				}
			}
			if(!isDuplicate) {
				int[] noDuplicateCopy = new int[noDuplicate.length+1];
				System.arraycopy(noDuplicate, 0, noDuplicateCopy, 0, noDuplicate.length);
				noDuplicate=noDuplicateCopy;
				noDuplicate[noDuplicate.length-1]=intInputs[i];
			}
			isDuplicate=false;
		}
		System.out.println(Arrays.toString(noDuplicate)); // 입력값 중 중복이 제거된 요소만 저장한 정수배열 확인 출력
		
		List<Integer> intArr = new ArrayList<Integer>();
		int idx2=0;
		for(int i:noDuplicate) {
			if(idx2<noDuplicate.length) {
				intArr.add(idx2++, i);
			}
		}
		System.out.println(intArr);
	}
	
	public static void ex5() {
		/*
		 * 사용자 입력으로 최소값, 최대값, 갯수를 입력받아 다음 요구사항에 맞도록 구현한다.
		 * 	- 최소값, 최대값은 랜덤을 통해 생성할 값의 범위이다.
		 * 	- 갯수는 랜덤을 통해 생성할 값의 수량 이다.
		 * 	- 생성된 랜덤값은 ArrayList 에 저장한다.
		 * 	- ArrayList에 저장한 정수는 중복이 없어야 한다.
		 */
		System.out.println("공백을 구분자로 사용하여 다음 내용에 맞은 데이터를 입력하세요.");
		System.out.print("최대값, 최소값, 갯수를 순서대로 입력하세요. : ");
		
		String[] inputs = sc.nextLine().split(" ");
		int max = Integer.parseInt(inputs[0]); // 최대값
		int min = Integer.parseInt(inputs[1]); // 최소값
		int cnt = Integer.parseInt(inputs[2]); // 범위 사이의 랜덤 생성값 개수
		
		//System.out.println(max+"|"+min+"|"+cnt); // 각각의 최대값, 최소값, 갯수가 정수형으로 저장됐는지 확인
		
		List<Integer> intArr = new ArrayList<Integer>();
		// 지정한 범위 내 입력한 갯수만큼 중복이 없는 랜덤 생성값을 정수형 리스트에 저장한다.
		for (int i = 0; i < cnt; i++) {
			// 최소값~최대값 범위 내 랜덤 난수 출력
			int rdNum = min + rd.nextInt((max - min) + 1);
			// 생성된 랜덤값이 리스트 내 존재하지 않는 경우에만 리스트 마지막 위치에 추가
			if (!intArr.contains(rdNum)) {
				intArr.add(rdNum);
			}
			// 중복된 랜덤생성값의 경우 현재 인덱스에 대해 난수를 재생성 하도록 한다.
			else {
				--i; // 현재인덱스 유지 및 반복문으로 다시 돌아감
			}

		}
		System.out.println(intArr);
		
		
	}
	
	public static void ex6() {}
	
	public static void ex7() {}
	
	public static void ex8() {}
	
	public static void ex9() {}
	
	public static void main(String[] args) {
		ex9();
		ex8();
		ex7();
		ex6();
		ex5();
		//ex4();
		//ex3();
		//ex2();
		//ex1();
	}
}
