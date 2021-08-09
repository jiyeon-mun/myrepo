package com.kh.exam8;

import java.util.Arrays;

public class PracArray1 {

	public static void ex1() {
		/*
		 * 다음의 정수 배열이 있다.
		 * 		37, 92, 58, 46, 94, 29, 25, 58
		 * 
		 * 위 배열에서 짝수에 해당하는 값과 홀수에 해당하는 값을 별도의 짝수값만 저장하는 짝수배열
		 * 홀수값만 저장하는 홀수배열로 분리하여 저장하도록 한다.
		 * 정적배열: 기존에 생성된 배열로 배열의 크기를 늘리거나 줄일 수 없다.
		 * 동적배열: 기존에 생성된 배열의 크기를 복사한 것으로 크기를 늘리거나 줄일 수 있다.
		 */
		int[] arr = new int[] { 37, 92, 58, 46, 94, 29, 25, 58 };
		int[] odd = new int[0]; // 정적배열
		int[] even = new int[0]; // 정적배열
		
		System.out.println(Arrays.toString(arr));
		
		for(int i=0;i<arr.length;i++) {
			
			if(arr[i]%2==0) {
				// even number
				
				int[] copyeven = new int[even.length + 1]; // 동적배열
				System.arraycopy(even, 0, copyeven, 0, even.length); 
//				for(int j=0;j<even.length;j++) {
//					copyeven[j]=even[j];
//				}
				even=copyeven;
				even[even.length-1]=arr[i];
			} else {
				// odd number
				int[] copyodd = new int[odd.length + 1]; // 동적배열
				System.arraycopy(odd, 0, copyodd, 0, odd.length); 
				odd=copyodd;
				odd[odd.length-1]=arr[i];
			}
		}
		System.out.println("홀수배열 odd[]:"+Arrays.toString(odd));
		System.out.println("짝수배열 even[]:"+Arrays.toString(even));
	}
	
	public static void ex2() {
		/*
		 * 다음의 정수 배열이 있다.
		 * 		37, 92, 58, 46, 94, 29, 25, 58
		 * 
		 * 위 배열에서 가장 큰값과 가장 작은 값만을 분리하여 별도의 하나의 배열에 저장하도록 한다.
		 */
		int[] arr = new int[] { 37, 92, 58, 46, 94, 29, 25, 58 };
		int[] minmax = new int[2]; // 정적배열
		System.out.println(Arrays.toString(minmax)); // 생성한 정적배열 확인
		
		// 큰값/작은값에 대한 비교를 위해 미리 0번 인덱스의 값을 배열에 넣는다.
		int min=arr[0]; // min 초기화
		int max=arr[0]; // max 초기화
		System.out.println("min: "+min+" | max: "+max); // min, max 확인
		
		// 이미 0번 인덱스의 값은 배열안에 넣어 두었기 때문에 1번 인덱스부터 반복을 진행한다.
		for(int i=1;i<arr.length;i++) {
			if(min>arr[i]) { // 최소값 구하기
				min=arr[i];
				minmax[0]=min;
//				System.out.println("-----minmax[0] 최소값 구하기 과정-----");
//				System.out.println("DEBUG -> "+minmax[0]);
			}
			if(max<arr[i]) { // 최대값 구하기
				max=arr[i];
				minmax[1]=max;
//				System.out.println("-----minmax[1] 최소값 구하기 과정-----");
//				System.out.println("DEBUG -> "+minmax[1]);
			}
		}
		System.out.println("minmax[]:"+Arrays.toString(minmax));
	}
	
	public static void ex3() {
		/*
		 * 다음의 정수 배열이 있다.
		 * 		37, 92, 58, 46, 94, 29, 25, 58
		 * 
		 * 위 배열에서 중복된 값을 찾아 중복이 없는 새로운 배열을 만든다.
		 * 		1. 배열의 크기가 0 인 새로운 배열을 생성한다.
		 * 		2. 기존 정수 배열의 0번 인덱스의 정수 값이 새로 생성된 배열안에 동일한
		 * 		값으로 저장되어 있는지 검사한다.
		 * 		3. 동일한 값이 없으면 새로 생성된 배열의 크기를 늘린 후 기존 정수 배열의
		 * 		   0번 인덱스의 값을 추가한다.
		 * 		4. 2번 과정과 동일하지만 기존 정수 배열의 1번 인덱스로 진행한다.
		 * 		5. 3번 과정과 동일하지만 1번 인덱스의 값을 추가해야 한다.
		 * 		6. 2 ~ 3번 과정이 계속 반복되는 구조이며, 2번 과정도 새로 생성된 배열을
		 * 		   반복하여 중복 검사를 하기 때문에 중첩반복문의 형태를 가진다.
		 * 		7. 3번 과정의 동일한 값이 있으면 새로운 배열을 생성하고 동일한 값이 없으면
		 * 		   새로운 배열을 생성하지 않고 그냥 넘어가는 형식의 조건문을 만들기 위해서
		 * 		   flag 기법을 활용하면 된다.
		 */
		int[] arr = new int[] { 37, 92, 58, 46, 92, 29, 29, 58 };
		int[] noDuplicate = new int[0];
		boolean isDuplicate = false;
		
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < noDuplicate.length; j++) {
				// 비교하는 기존배열 요소가 새로 생성된 배열 요소 내 있는 경우
				// 요소의 중복됨을 변수를 이용해 컴퓨터에 저장하고 true
				// 다음 기존배열 요소 비교로 넘어간다. i의 증가
				if (arr[i] == noDuplicate[j]) {
					isDuplicate = true;
					break;
				}
			} // 기존배열 요소 하나의 값을 새로 생성한 배열 요소 전체에 대해 비교 후
			
			// 중복되지 않는 기존배열 요소에 대해서; false
			// 중복이 없는 새로운 배열요소들을 하나씩 추가할 동적배열 생성
			if(!isDuplicate) {
				int[] noDuplicateCopy = new int[noDuplicate.length + 1];
				System.arraycopy(noDuplicate, 0, noDuplicateCopy, 0, noDuplicate.length); 
				noDuplicate=noDuplicateCopy;
				noDuplicate[noDuplicate.length - 1] = arr[i];
			}
			// 중복되지 않으면 다시 기존배열 비교구문으로 돌아감; 첫번째 for문
			isDuplicate = false;
		} // 기존배열요소에 대한 모든 중복확이 끝나면
		// 중복되지 않은 요소들을 저장한 배열 출력
		System.out.println("noDuplicate[]:"+Arrays.toString(noDuplicate));
	}
	
	public static void ex4() {
		/*
		 * 다음의 정수 배열이 있다.
		 * 		37, 92, 58, 46, 94, 29, 25, 58
		 * 
		 * 위 배열에서 짝수에 해당하는 값과 홀수에 해당하는 값을 별도의 짝수값만 저장하는 짝수배열
		 * 홀수값만 저장하는 홀수배열로 분리하여 저장하도록 한다.(정적배열)
		 */
		int[] arr = new int[] { 37, 92, 58, 46, 94, 29, 25, 58 };
		int[][] arrEvenOdd = new int[2][8];	// 정적배열	
		// arrEvenOdd[0] : 짝수저장 행
		// arrEvenOdd[1] : 홀수저장 행
		
		int idx1=0; // 짝수용 인덱스
		int idx2=0; // 홀수용 인덱스
		
		for(int i=0;i<arr.length;i++) {
			if(arr[i]%2==0) {
				// 짝수저장 행에 짝수 요소들 맨 앞의 열부터 하나씩 저장
				arrEvenOdd[0][idx1]=arr[i];
				System.out.println("DEBUG -> " + arrEvenOdd[0][idx1]);
				idx1++;
			}
			else {
				// 홀수저장 행에 홀수 요소들 맨 앞의 열부터 하나씩 저장
				arrEvenOdd[1][idx2]=arr[i];
				System.out.println("DEBUG -> " + arrEvenOdd[0][idx1]);
				idx2++;
			}
		}
		System.out.println("arrEvenOdd[0]:"+Arrays.toString(arrEvenOdd[0]));
		System.out.println("arrEvenOdd[1]:"+Arrays.toString(arrEvenOdd[1]));
	}
	
	public static void ex5() {
		/*
		 * 다음의 정수 배열이 있다.
		 * 		37, 92, 58, 46, 94, 29, 25, 58
		 * 
		 * 위 배열에서 짝수에 해당하는 값과 홀수에 해당하는 값을 별도의 짝수값만 저장하는 짝수배열
		 * 홀수값만 저장하는 홀수배열로 분리하여 저장하도록 한다.
		 * (동적배열): 배열 내 짝수, 홀수 개수만큼 각각의 행에 요소들 저장
		 */
		int[] arr = new int[] { 37, 92, 58, 46, 94, 29, 25, 58 };
		int[][] arrEvenOdd = new int[2][]; // 동적배열
		// arrEvenOdd[0] : 짝수 저장
		// arrEvenOdd[1] : 홀수 저장
		
		int[] odd = new int[0];
		int[] even = new int[0];
		
		for(int i=0;i<arr.length;i++) {
			if(arr[i]%2==0) {
				// even number
				// 동적배열 생성하여 짝수 개수만큼 짝수저장행에 출력
				int[] copyeven = new int[even.length + 1];
				System.arraycopy(even, 0, copyeven, 0, even.length); 			
				even=copyeven;
				even[even.length-1]=arr[i];			
			} 
			else {
				// odd number
				// 동적배열 생성하여 홀수 개수만큼 홀수저장행에 출력
				int[] copyodd = new int[odd.length + 1];
				System.arraycopy(odd, 0, copyodd, 0, odd.length); 
				odd=copyodd;
				odd[odd.length-1]=arr[i];	
			}
		}
		arrEvenOdd[0]=even; // 2차원 배열 arr에서 0행은 짝수요소들 개수만큼 출력
		arrEvenOdd[1]=odd; // 2차원 배열 arr에서 1행은 홀수요소들 개수만큼 출력
		
		System.out.println("arrEvenOdd[0]:"+Arrays.toString(arrEvenOdd[0]));
		System.out.println("arrEvenOdd[1]:"+Arrays.toString(arrEvenOdd[1]));
		
		System.out.println(Arrays.deepToString(arrEvenOdd)); // 2차배열 출력
		
		System.out.println("arrEvenOdd[]:"+Arrays.toString(arrEvenOdd));
		// 2차원배열의 각각의 행에 대한 참조주소 출력
		// 2차원 배열에서 각 행은 각각 다른 참조주소를 가진다.
	}
	
	public static void main(String[] args) {
		//ex1();
		//ex2();
		//ex3();
		//ex4();
		ex5();
	}

}
