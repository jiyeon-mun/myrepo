package com.kh.exam8;

import java.util.Arrays;

public class PracArray1 {

	public static void ex1() {
		int[] arr = new int[] { 37, 92, 58, 46, 94, 29, 25, 58 };
		
		// 정적배열: 기존에 생성된 배열로 배열의 크기를 늘리거나 줄일 수 없다.
		int[] odd = new int[0];
		int[] even = new int[0];
		
		for(int i=0;i<arr.length;i++) {
			
			if(arr[i]%2==0) {
				// even number
				
				int[] copyeven = new int[even.length + 1];
				// 기존의 정적 배열을 크기를 늘리거나 줄일 수 있는 새로운 동적 배열을 생성한다.
				System.arraycopy(even, 0, copyeven, 0, even.length); 
				// 기존에 생성된 배열에 저장된 데이터를 새로 생성된 배열에서도 사용할 수 있도록 한다.
				// 단, 동적배열의 배열크기 변화로 데이터 요소 값이 추가되거나 부족할 수 있다.
				// => 기존 even[]배열크기+1 크기를 가지는 copyeven[] 배열을 계속해서 생성.
				// => 따라서 기존 evev[] 배열에서 가지는 값들을 copyeven[] 배열에 계속해서 복사.
				// arr[]배열의 크기만큼 반복한다.
				
				even=copyeven;
				// 새로 생성된 배열을 이용하자!
				// 새로 생성된 copyeven[] 배열의 주소를 even[] 배열 주소에 대입
				// 참조주소 동일
				even[even.length-1]=arr[i];
				// 배열크기+1로 늘어난 even[]의 마지막 index에 짝수값을 저장.
				
				System.out.println("DEBUG -> "+Arrays.toString(even));
				// 과정확인
				
			} else {
				// odd number
				
				int[] copyodd = new int[odd.length + 1];
				System.arraycopy(odd, 0, copyodd, 0, odd.length); 
				odd=copyodd;
				odd[odd.length-1]=arr[i];
				
			}
		}
		System.out.println("홀수배열 odd[]:"+Arrays.toString(odd));
		System.out.println("짝수배열 even[]:"+Arrays.toString(even));
	}
	
	public static void ex2() {
		int[] arr = new int[] { 37, 92, 58, 46, 94, 29, 25, 58 };
		int[] minmax = new int[2];
		int min = arr[0];
		int max = arr[0];
		System.out.println("min: "+min+" | max: "+max);
		
		
		for(int i=0;i<arr.length;i++) {
			if(min>arr[i]) {
				min=arr[i];
				minmax[0]=min;
				System.out.println("-----minmax[0] 최소값 구하기 과정-----");
				System.out.println("DEBUG -> "+minmax[0]);
			}
			if(max<arr[i]) {
				max=arr[i];
				minmax[1]=max;
				System.out.println("-----minmax[1] 최소값 구하기 과정-----");
				System.out.println("DEBUG -> "+minmax[1]);
			}
			
		}
		System.out.println("minmax[]:"+Arrays.toString(minmax));
	}
	
	public static void ex3() {
		
		
		int[] arr = new int[] { 37, 92, 58, 46, 92, 29, 29, 58 };
		int[] noDuplicate = new int[0];
		boolean isDuplicate = false;
		
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < noDuplicate.length; j++) {
				if (arr[i] == noDuplicate[j]) {
					isDuplicate = true; // 비교하는 기존배열 요소가 새로 생성된 배열 요소 내 있는 경우 중복됨을 변수를 이용해 컴퓨터에 저장한다.
					break; // 새로 생성된 배열에 기존배열의 요소가 있는 경우 다음 기존배열 요소 비교로 넘어간다.
				}
			} // 기존배열 요소 하나의 값을 새로 생성한 배열 요소 전체에 대해 비교 후
			if(!isDuplicate) { // 중복됨의 변수에 대해 반대 => 중복되지 않는 기존배열 요소에 대해서
				int[] noDuplicateCopy = new int[noDuplicate.length + 1];
				System.arraycopy(noDuplicate, 0, noDuplicateCopy, 0, noDuplicate.length); 
				noDuplicate=noDuplicateCopy;
				noDuplicate[noDuplicate.length - 1] = arr[i];
			}
			isDuplicate = false; // 중복되지 않으면 다시 기존배열 비교구문으로 넘어간다.
		}
		System.out.println("noDuplicate[]:"+Arrays.toString(noDuplicate));
	}
	
	public static void ex4() {
		// 정적배열
		
		int[] arr = new int[] { 37, 92, 58, 46, 94, 29, 25, 58 };
		int[][] arrEvenOdd = new int[2][8];		
		// arrEvenOdd[0] : 짝수저장
		// arrEvenOdd[1] : 홀수저장
		
		int idx1=0; // 짝수용 인덱스
		int idx2=0; // 홀수용 인덱스
		
		for(int i=0;i<arr.length;i++) {

			if(arr[i]%2==0) {
				arrEvenOdd[0][idx1]=arr[i];
				System.out.println("DEBUG -> " + arrEvenOdd[0][idx1]);
				idx1++;
			}
			else {
				arrEvenOdd[1][idx2]=arr[i];
				System.out.println("DEBUG -> " + arrEvenOdd[0][idx1]);
				idx2++;
			}
		}
		System.out.println("arrEvenOdd[0]:"+Arrays.toString(arrEvenOdd[0]));
		System.out.println("arrEvenOdd[1]:"+Arrays.toString(arrEvenOdd[1]));
	}
	
	public static void ex5() {
		// 동적배열
		
		int[] arr = new int[] { 37, 92, 58, 46, 94, 29, 25, 58 };
		int[][] arrEvenOdd = new int[2][];
		
		int[] odd = new int[0];
		int[] even = new int[0];
		
		for(int i=0;i<arr.length;i++) {
			
			if(arr[i]%2==0) {
				// even number
				
				int[] copyeven = new int[even.length + 1];
				System.arraycopy(even, 0, copyeven, 0, even.length); 			
				even=copyeven;
				even[even.length-1]=arr[i];			
			} 
			else {
				// odd number
				
				int[] copyodd = new int[odd.length + 1];
				System.arraycopy(odd, 0, copyodd, 0, odd.length); 
				odd=copyodd;
				odd[odd.length-1]=arr[i];	
			}
		}
		arrEvenOdd[0]=even;
		arrEvenOdd[1]=odd;
		
		System.out.println("arrEvenOdd[0]:"+Arrays.toString(arrEvenOdd[0]));
		System.out.println("arrEvenOdd[1]:"+Arrays.toString(arrEvenOdd[1]));
		
		System.out.println(Arrays.deepToString(arrEvenOdd));
		// 2차배열 출력
		
		System.out.println("arrEvenOdd[]:"+Arrays.toString(arrEvenOdd));
		// 1행 각각의 열의 주소 출력
	}
	
	public static void main(String[] args) {
		//ex1();
		//ex2();
		//ex3();
		//ex4();
		ex5();
	}

}
