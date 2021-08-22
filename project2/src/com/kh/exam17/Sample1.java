package com.kh.exam17;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
// import java.util.ArrayList; import java.util.List; import java.util.Random;
// import java.util.Date;

public class Sample1 {
	public static Scanner sc = new Scanner(System.in);
	public static Random rd = new Random();
	public static Date date1 = new Date();
	public static Calendar date2 = Calendar.getInstance();
	
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
		/*
		 * 사용자 입력으로 정수 데이터를 받아 ArrayList 에 저장 후
		 * ArrayList에 저장된 모든 정수의 합을 구하여 출력한다.
		 * (단, 사용자 입력은 한 번만 사용한다.)
		 */
		System.out.println("공백을 구분자로 사용하여 다음 내용에 맞은 데이터를 입력하세요.");
		System.out.print("정수값을 2개 이상 입력하세요. : ");
		// 입력된 정수값들 띄어쓰기로 구분하여 문자열 배열에 각각의 요소로 저장
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
		/*
		 * 사용자 입력으로 실수 데이터를 받아 ArrayList 에 저장 후
		 * ArrayList에 저장된 모든 실수의 합과 평균을 구하여 출력한다.
		 * (단, 사용자 입력은 한 번만 사용한다.)
		 */
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
		/*
		 * 다음의 요구사항을 잘 보고 요구사항에 맞도록 구현한다.
		 * 	- 사용자 입력으로 정수 데이터를 받아 ArrayList 에 저장을 해야 한다.
		 * 	- 사용자 입력으로 하나의 정수 데이터를 입력 할 수 있지만 2개 이상의 정수를 입력 하기도 한다.
		 * 	- 동일한 정수 데이터는 ArrayList에 저장되지 않도록 한다.
		 */
	}
	// 4번) 풀이1
	public static void ex4_1() {
		System.out.println("공백을 구분자로 사용하여 다음 내용에 맞은 데이터를 입력하세요.");
		System.out.print("정수값을 한 개 이상 입력하세요. : ");
		// 정수입력값을 저장한 문자열배열을 정수형배열로 바꿈
		String[] inputs=sc.nextLine().split(" ");
		
		int cnt=inputs.length;
		int[] intInputs= new int[cnt]; // 문자열정수값을 정수형으로 변환하여 저장할 졍수형 배열
		int idx1=0;
		for(String s:inputs) {
			if(idx1<intInputs.length) {
				intInputs[idx1++]=Integer.parseInt(s); // parseInt()의 반환되는 결과값은 int 기본자료형
				// 문자열 반환 시 기본자료형(primitive type)으로 받고 싶을 때는 parseInt(),
				//				new Integer() 객체로 반환하고 싶으면 valueOf() 사용
			}
		}
		System.out.println(Arrays.toString(intInputs)); // 입력값들 정수배열로 저장됐는지 확인
		
		// 입력된 정수들을 저장한 정수배열 중 중복값은 제거한 새로운 정수배열 생성
		// 동적 배열 이용
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
		
		// 입력정수값 중 중복이 제거된 정수배열 요소를 ArrayList에 하나씩 삽입
		List<Integer> intArr = new ArrayList<Integer>();
		int idx2=0;
		for(int i:noDuplicate) {
			if(idx2<noDuplicate.length) {
				intArr.add(idx2++, i);
			}
		}
		System.out.println(intArr);
	}
	// 4번) 풀이2
	public static void ex4_2() {
		List<Integer> intList = new ArrayList<Integer>();
		
		while(true) {			
			System.out.println("공백을 구분자로 사용하여 다음 내용에 맞은 데이터를 입력하세요.");
			System.out.print("정수값을 한 개 이상 입력하세요. : ");
			String[] inputs=sc.nextLine().split(" ");
			
			try {
				for(String s:inputs) {
					intList.add(Integer.valueOf(s));
				}
				System.out.print(intList+" | "); // 중복을 제거하지 않은 상태
				System.out.println(intList.size());
			} catch(Exception e) {
				System.out.println("정수만 입력해주세요.(띄어쓰기 구분)");
				intList.clear(); continue; // 저장된 ArrayList 지우고 정수입력으로 돌아가기
			}
			
			// ArrayList 내 중복 검사 및 제거
			for(int i=0;i<intList.size();i++) { // i번 객체를
				for(int j=0;j<i;j++) { // (i-1)번 까지의 객체들과 비교
					if(intList.get(i)==intList.get(j)) {
						// 중복의 경우 중복되는 i번 객체를 제거하고 해당 자리수도 하나 지운다.
						System.out.println("중복 객체 요소: "+intList.get(i)+" | 중복 객체의 인덱스: "+i);
						intList.remove(i); System.out.println("인덱스 "+i+"번의 중복 객체가 제거된 ArrayList: "+intList);
						i--; // 중복값이 있던 인덱스에 새로운 값을 넣을 수 있게 자리수를 하나 지움.
						
					}
				}
			}
			break;
		}
		System.out.println(intList);
		
	}
	
	public static void ex5() {
		/*
		 * 사용자 입력으로 최소값, 최대값, 갯수를 입력받아 다음 요구사항에 맞도록 구현한다.
		 * 	- 최소값, 최대값은 랜덤을 통해 생성할 값의 범위이다.
		 * 	- 갯수는 랜덤을 통해 생성할 값의 수량 이다.
		 * 	- 생성된 랜덤값은 ArrayList 에 저장한다.
		 * 	- ArrayList에 저장한 정수는 중복이 없어야 한다.
		 */
		List<Integer> intArr = new ArrayList<Integer>();
		
		System.out.println("공백을 구분자로 사용하여 다음 내용에 맞은 데이터를 입력하세요.");
		System.out.print("최대값, 최소값, 갯수를 순서대로 입력하세요. : ");
		
		String[] inputs = sc.nextLine().split(" ");
		int max = Integer.parseInt(inputs[0]); // 최대값
		int min = Integer.parseInt(inputs[1]); // 최소값
		int cnt = Integer.parseInt(inputs[2]); // 범위 사이의 랜덤 생성값 개수
		
		// 지정한 범위 내 입력한 갯수만큼 중복이 없는 랜덤 생성값을 정수형 리스트에 저장한다.
		// 생성된 랜덤값이 리스트 내 존재하지 않는 경우에만 리스트 마지막 위치에 추가한다.
		// 중복된 랜덤생성값의 경우 현재 인덱스에 대해 난수를 재생성 하도록 한다.
		for (int i = 0; i < cnt; i++) {
			// 최소값~최대값 범위 내 랜덤 난수 출력
			int rdNum = min + rd.nextInt((max - min) + 1); // (int)((Math.random()*(max-min+1))+min)
			
			if (!intArr.contains(rdNum)) {
				intArr.add(rdNum);
			}
			else {
				i--; // 현재인덱스 유지 및 반복문으로 다시 돌아감
			}

		}
		System.out.println(intArr);
	}
	
	public static void ex6() {
		/*
		 * 현재 날짜를 구한 후 ArrayList에 년, 월, 일, 시간, 분, 초 데이터가
		 * 저장되도록 한다.
		 */
		System.out.println("현재 날짜 출력: "+date1); // Sat Aug 21 12:36:35 KST 2021 형식
		
		List<String> strList = new ArrayList<String>();
		// Date 클래스 format() 메서드 사용
		String sdate1 = "%tY년";
		strList.add(String.format(sdate1, date1)); // date1을 sdate1 형식으로 포맷함.
		sdate1 = "%tm월";
		strList.add(String.format(sdate1, date1));
		sdate1 = "%td일";
		strList.add(String.format(sdate1, date1));
		sdate1 = "%tH시";
		strList.add(String.format(sdate1, date1));
		sdate1 = "%tM분";
		strList.add(String.format(sdate1, date1));
		sdate1 = "%tS초";
		strList.add(String.format(sdate1, date1));
		
		System.out.println(strList);
	}
	
	public static void ex7() {
		/*
		 * 3초에 한번씩 정기적으로 1 ~ 99 사이의 랜덤값을 ArrayList 에 저장을 하도록 한다
		 * ArrayList 에 저장하는 데이터는 10개로 제한한다.
		 */
		List<Integer> intList = new ArrayList<Integer>();
		
		System.out.println(date2.getTime()); // 현재 시간 출력 확인
		
		// Thread클래스의 sleep()메서드
		// 		실행 중인 스레드 일정 시간 멈추게 만듦. 밀리세컨드 단위 사용.
		//		try-catch문으로 감싸주고, catch 블록에서 잡힌 InterruptedException은 무시.
		for(int i=0;i<10;i++) {
			try {
				int elements = rd.nextInt(99) + 1; // (int) (Math.random() * 99 + 1)
				
				// sleep()메서드 이용하여 3초간 일시정지
				// 멈춘 시간에 대해 3초 추가 후 (? 3초간 일시정지 후 랜덤값을 출력하도록 코딩하였으므로 )
				// 생성된 랜덤값 ArrayList에 저장
				Thread.sleep(3000);
				date2.add(Calendar.SECOND, 3);
				String msg = date2.get(Calendar.HOUR)+":"+date2.get(Calendar.MINUTE)+":"+date2.get(Calendar.SECOND);
				
				System.out.print((i+1)+"회: "+elements+" | ");System.out.println(msg); // 3초 후에 출력되는지 확인
				intList.add(elements);
				
			} catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println(intList);
	}
	
	public static void ex8() {
		/*
		 * 3초에 한번씩 정기적으로 1 ~ 99 사이의 랜덤값을 ArrayList 에 저장을 할 때 저장 시간도
		 * 같이 ArrayList에 저장하도록 하며 저장하는 데이터는 10개로 제한한다.
		 * (단, 중복 데이터는 저장이 안되도록 하며, ArrayList를 2개 이용하도록 한다. 시간은 년월일
		 * 시분초까지만 저장하도록 한다.)
		 */
		List<Integer> intList = new ArrayList<Integer>(); // 랜덤값 저장
		List<String> strList = new ArrayList<String>(); // 시간 저장
		System.out.println(date2.getTime()); // 시작시간 확인; 현재시간
		
		for(int i=0;i<10;i++) {
			try {
				int elements = rd.nextInt(99) + 1;

				if(!intList.contains(elements)) {
					// 생성된 랜덤값이 ArrayList에 존재하지 않는 신규값인 경우
					// 3초 후 정기적으로 생성되는 랜덤값을 ArrayList 에 저장한다.
					Thread.sleep(3000);
					date2.add(Calendar.SECOND, 3);
					
					// 3초마다 생성되는 랜덤값의 저장 시간을 저장하기 위해서
					int year = date2.get(Calendar.YEAR); // 년
					int month = date2.get(Calendar.MONTH) + 1; // MONTH는 0부터 시작됨. 월
					int day = date2.get(Calendar.DATE); // 일
					int hour = date2.get(Calendar.HOUR); // 시
					int min = date2.get(Calendar.MINUTE); // 분
					int scd = date2.get(Calendar.SECOND); //초
					String msg = year+"년 "+month+"월 "+day+"일 "+hour+":"+min+":"+scd;
					
					System.out.print((i+1)+"회: "+elements+" | ");
					System.out.println(msg);
					
					intList.add(elements);
					strList.add(msg);
				}
				else {
					// 3초마다 생성된 랜덤값이 ArrayList 내 이미 존재하는 경우
					// 현재 인덱스에서 랜덤값을 재생성 한다.
					System.out.println("Duplicate!!"); // 중복여부 확인
					i--;
				}
				
			} catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
		// 출력
		System.out.println(intList);
		System.out.println(strList);
		System.out.println(date2.getTime()); // 종료시간 확인; 현재시간
	}
	
	public static void ex9() {
		/*
		 * ArrayList 에 다음의 단어를 미리 초기화 한 후 다음 요구사항에 맞는 프로그램을 작성한다.
		 * 	- abstract, continue, for, new, switch, default, package,
		 * 	  synchronized, boolean, do, if, private, this, break,
		 * 	  double, implements, protected, throw, byte, else, import,
		 * 	  public, throws, case, instanceof, return, catch, extends,
		 * 	  int, short, try, char, final, interface, static, void,
		 * 	  class, finally, long, float, super, while
		 * 	- ArrayList에 저장된 문자열을 랜덤으로 출력하게 만든다.
		 * 	- 랜덤으로 출력된 문자열을 사용자 입력으로 사용자가 입력하게 만든다.
		 * 	- 사용자가 입력한 데이터가 출력된 문자열과 동일하면 다음 문자열이 다시 랜덤으로 출력되게 한다.
		 * 	- 위 과정을 10번 반복하여 모든 문자열을 입력한 총 시간과 정확하게 입력한 문자열의 수, 잘못
		 * 	  입력한 문자열의 수를 테이블 형태로 출력하게 한다. 
		 */
		// csv파일 읽기
		List<List<String>> aList = new ArrayList<List<String>>(); // csv파일 읽고 저장할 ArrayList
		BufferedReader br = null;
		try {
			br = Files.newBufferedReader(Paths.get("C:\\Users\\Default\\Documents\\ArrayListEg.csv"));
			String line="";
			while((line=br.readLine())!=null) {
				List<String> tmpList = new ArrayList<String>();
				String[] arr = line.split(",");
				tmpList=Arrays.asList(arr);
				System.out.println(tmpList);
				aList.add(tmpList);
			}
		}catch(FileNotFoundException e){
            e.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        }finally{
            try{
                if(br != null){
                    br.close();
                }
            }catch(IOException e){
                e.printStackTrace();
            }
        }
		
	}
	
	public static void main(String[] args) {
		ex9();
		//ex8();
		//ex7();
		//ex6();
		//ex5();
		//ex4_2();
		//ex3();
		//ex2();
		//ex1();
	}
}
