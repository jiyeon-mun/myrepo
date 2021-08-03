package com.kh.exam8;

import java.util.Arrays;

public class Review0803 {
	/*
	 * 배열 복사 : 얕은복사, 깊은복사
	 * 2차 배열
	*/
	
	public static void review1() {
		// 2차배열: 배열 안의 요소가 배열로 구성. 배열명[행][열];
		
		int[][] arr = new int[2][4];
		
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr[i].length;j++) {
				arr[i][j]=i+j;
			}
			System.out.println("arr["+i+"]: "+Arrays.toString(arr[i]));
		}
		// 다차원배열 출력(단, 한 줄 출력)
		System.out.println("arr[2][4]: "+Arrays.deepToString(arr));
		// replace(기존문자 바꿀문자) 이용하여 배열 형식대로 출력
		System.out.println(Arrays.deepToString(arr).replace("], [", "]\n["));
	}
	
	public static void review2() {
		// 배열 선언과 동시 및 초기화.
		
		int[][] arr = new int[][] {{1,2,3},{4,5,6}};
		System.out.println(Arrays.deepToString(arr));
		// 선언 및 초기화한 2차배열 출력 및 확인
		
		// 2차배열 각 행에 배열 저장 및 출력
		for(int i=0;i<arr.length;i++) {
			System.out.println(Arrays.toString(arr[i]));
			
		}
		
		// 2차원배열 각 요소에 접근하여 배열 형식대로 출력
		for(int i=0;i<arr.length;i++) {
			int[] inArr = arr[i]; // arr[][]의 각 행에 접근하는 배열 inArr[]선언 및 초기화. inArr[0] & inArr[1]
			for(int j=0;j<inArr.length;j++) { // inArr[0]에 저장된 배열 요소에 접근. inArr[1]에 저장된 배열 요소에 접근. 
				System.out.print(inArr[j]+" ");
			}
			System.out.println();
		}
	}
	
	public static void review3() {
		//2차배열 복사
		int[][] arr = new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		int[][] arrCopy = new int[3][3];
		
		arrCopy=arr; // 얕은복사
		System.out.println("-----참조값 확인-----");
		System.out.println("arr[][] 참조주소: "+Arrays.toString(arr));
		System.out.println("arrCopy[][] 참조주소: "+Arrays.toString(arrCopy));
		
		arr[2][2]=24;
		// 얕은복사의 경우 두 배열의 참조값이 동일하므로 어떤 하나의 배열에 대한 요소값 변경 시 연관된 다른 하나의 배열의 요소값도 함께 변경된다.
		// accCopy[2][2]=24;
		
		System.out.println("-----arrCopy-----");
		System.out.println(Arrays.toString(arrCopy[0]));
		System.out.println(Arrays.toString(arrCopy[1]));
		System.out.println(Arrays.toString(arrCopy[2]));
		
		System.out.println("-----arr-----");
		System.out.println(Arrays.toString(arr[0]));
		System.out.println(Arrays.toString(arr[1]));
		System.out.println(Arrays.toString(arr[2]));
	}
	
	public static void review4() {
		// 2차배열에서의 깊은복사는 꼭 반복문을 한 번 이용해야한다.
		
		int[][] arr = new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		int[][] arrCopy = new int[3][3];
		
		// 깊은복사 과정
		for (int i = 0; i < arr.length; i++) {
			System.arraycopy(arr[i], 0, arrCopy[i], 0, arr[i].length);
			//arrCopy[i]=arr[i].clone();
		}
		arr[2][2]=24; 
		// 깊은복사로 인해 서로 다른 참조주소를 갖는 배열.
		// 어떤 하나의 배열 요소값을 변경해도 다른 배열에 영향을 끼치지 않는다.
		
		System.out.println("-----참조값 확인-----");
		System.out.println("arr[][] 참조주소: "+Arrays.toString(arr));
		System.out.println("arrCopy[][] 참조주소: "+Arrays.toString(arrCopy));
		
		System.out.println("-----arrCopy-----");
		System.out.println(Arrays.toString(arrCopy[0]));
		System.out.println(Arrays.toString(arrCopy[1]));
		System.out.println(Arrays.toString(arrCopy[2]));
		
		System.out.println("-----arr-----");
		System.out.println(Arrays.toString(arr[0]));
		System.out.println(Arrays.toString(arr[1]));
		System.out.println(Arrays.toString(arr[2]));
		
	}
	
	public static void review5() {
		// 가변 길이 배열
		
		int[][] arr = new int[3][];
		arr[0] = new int[4];
		arr[1] = new int[3];
		arr[2] = new int[6];
		
		// 배열요소 0으로 초기화됨
//		System.out.println(Arrays.deepToString(arr));
//		System.out.println(Arrays.deepToString(arr).replace("], [", "]\n[")); // 2차배열 형태로 출력
		
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j] + ":" + i + "|" + j + "\t");
				//System.out.print(arr[i][j]+" ");
				
			}
			System.out.println(); // 행구분
		}
	}
	
	public static void review6() {
		// 2차동적배열
		
		int[][] arr = new int[3][];
		arr[0] = new int[] { 1, 2, 3, 4 };
		arr[1] = new int[] { 5, 6, 7, 8, 9, 10 };
		arr[2] = new int[] { 11, 12, 13 };
		
		int[][] arrCopy=new int[arr.length+1][]; // arr.length=3
		
		// 깊은복사 과정
		for (int i = 0; i < arr.length; i++) {
			arrCopy[i]=arr[i].clone(); 
			// System.arraycopy(arr[i], 0, arrCopy[i], 0, arr[i].length);는 사용할 수 없다. 2차배열 행이 서로 다름.
		}
		
		// 참조주소 서로 다른 경우
		arr[2][2]=24;
		System.out.println("-----arrCopy-----");
		System.out.println(Arrays.toString(arrCopy[0])); // [1, 2, 3, 4]
		System.out.println(Arrays.toString(arrCopy[1])); // [5, 6, 7, 8, 9, 10]
		System.out.println(Arrays.toString(arrCopy[2])); // [11, 12, 13]
		
		System.out.println("-----arr-----");
		System.out.println(Arrays.toString(arr[0])); // [1, 2, 3, 4]
		System.out.println(Arrays.toString(arr[1])); // [5, 6, 7, 8, 9, 10]
		System.out.println(Arrays.toString(arr[2])); // [11, 12, 24]
		
		System.out.println("-----------------------------");
		
		arr = arrCopy; // 얕은복사로 참조주소 동일
		System.out.println(Arrays.deepToString(arr));
		
		arr[arr.length - 1] = new int[] { 14, 15, 16, 17 };
		System.out.println(Arrays.deepToString(arr));		
	}
	
	public static void qu1() {
		/*
		 * 다음의 정수 배열이 있다.
		 * 		37, 92, 58, 46, 94, 29, 25, 58
		 * 
		 * 위 배열에서 짝수에 해당하는 값과 홀수에 해당하는 값을 별도의 짝수값만 저장하는 짝수배열
		 * 홀수값만 저장하는 홀수배열로 분리하여 저장하도록 한다.
		 * 동적배열
		 */
		
		int[] arr = new int[] {37, 92, 58, 46, 94, 29, 25, 58};
		
		int[] arrOdd = new int[0]; // 홀수배열
		int[] arrEven = new int[0]; // 짝수배열
		
		for(int i=0;i<arr.length;i++) {
			if(arr[i]%2==0) { // 짝수배열 짝수 저장
				int[] arrEvenCopy = new int[arrEven.length + 1];
				
				System.arraycopy(arrEven, 0, arrEvenCopy, 0, arrEven.length);
				arrEven=arrEvenCopy;
				arrEven[arrEven.length-1]=arr[i];
			}
			else { // 홀수배열 홀수 저장
				int[] arrOddCopy = new int[arrOdd.length + 1];
				
				System.arraycopy(arrOdd, 0, arrOddCopy, 0, arrOdd.length);
				arrOdd=arrOddCopy;
				arrOdd[arrOdd.length-1]=arr[i];
			}
		}
		System.out.println("arrEven[]: "+Arrays.toString(arrEven));
		System.out.println("arrOdd[]: "+Arrays.toString(arrOdd));
		
	}
	
	public static void qu2() {
		/*
		 * 다음의 정수 배열이 있다.
		 * 		37, 92, 58, 46, 94, 29, 25, 58
		 * 
		 * 위 배열에서 가장 큰값과 가장 작은 값만을 분리하여 별도의 하나의 배열에 저장하도록 한다.
		 */
		
		int[] arr = new int[] {37, 92, 58, 46, 94, 29, 25, 58};
		
		int[] minmax = new int[2];
		minmax[0] = arr[0]; // 최소값
		minmax[1] = arr[0]; // 최대값
		
		for(int i=0;i<arr.length;i++) {
			if(minmax[0]>arr[i]) { // 최소값 찾기
				minmax[0]=arr[i];
				System.out.println("DEBUG -> "+minmax[0]);
			}
			if(minmax[1]<arr[i]) { // 최대값 찾기
				minmax[1]=arr[i];
				System.out.println("DEBUG -> "+minmax[1]);
			}
		}
		System.out.println("minmax[]: "+Arrays.toString(minmax));
	}
	
	public static void qu3() {
		/*
		 * 다음의 정수 배열이 있다.
		 * 		37, 92, 58, 46, 94, 29, 25, 58
		 * 
		 * 위 배열에서 중복된 값을 찾아 중복이 없는 새로운 배열을 만든다.
		 * 
		 * 		1. 배열의 크기가 0 인 새로운 배열을 생성한다.
		 * 		2. 기존 정수 배열의 0번 인덱스의 정수 값이 새로 생성된 배열안에 동일한
		 * 		값으로 저장되어 있는지 검사한다.
		 * 		3. 동일한 값이 없으면 새로 생성된 배열의 크기를 늘린 후 기존 정수 배열의
		 * 		   0번 인덱스의 값을 추가한다.
		 * 		4. 2번 과정과 동일하지만 기존 정수 배열의 1번 인덱스로 진행한다.
		 * 		5. 3번 과정과 동일하지만 1번 인덱스의 값을 추가해야 한다.
		 * 		6. 2 ~ 3번 과정이 계속 반복되는 구조이며, 2번 과정도 새로 생성된 배열을
		 * 		   반복하여 중복 검사를 하기 때문에 중첩반복문의 형태를 가진다.
		 * 		   중첩반복문 => 기존 배열 요소값을 새로 생성된 배열 요소들과 차례로 비교 후 기존 배열 요수 수만큼 반복
		 * 		7. 3번 과정의 동일한 값이 있으면 새로운 배열을 생성하고 동일한 값이 없으면
		 * 		   새로운 배열을 생성하지 않고 그냥 넘어가는 형식의 조건문을 만들기 위해서
		 * 		   flag 기법을 활용하면 된다.
		 */
		
		int[] arr = new int[] {46, 92, 58, 46, 92, 29, 25, 58};
		System.out.println("초기배열 arr[]: "+Arrays.toString(arr));
		
		int[] noDuplicate = new int[0];
		boolean is_duplicate=false; // 중복여부 체크 변수이용
		
		for (int i = 0; i < arr.length; i++) { // 기존 정수 배열의 0번 인덱스 정수 값을
			for (int j = 0; j < noDuplicate.length; j++) { // 새로 생성된 배열 안에 요소들과 모두 비교하여 동일한 값으로 저장되어 있는지 확인;
				if(arr[i]==noDuplicate[j]) { // 중복된 값이 있는 경우
					is_duplicate=true; // 중복 여부 true
					break; // 기존 배열 0번 인덱스 정수값을 새로 생성된 배열안의 모든 요소들과 비교하는 것을 중단하고
						   // 비교했던 기존배열 요소의 다음 요소인 1번 인덱스 정수값을 비교하도록한다.
						   // arr[] 배열안의 모든 요소들에 대해 반복을 진행한다.
				}
			}
			// 중복되지 않는 경우 중복이 없는 새로운 배열을 만든다.
			if(!is_duplicate) { 
				int[] noDuplicateCopy = new int[noDuplicate.length + 1];
				System.arraycopy(noDuplicate, 0, noDuplicateCopy, 0, noDuplicate.length);
				noDuplicate=noDuplicateCopy;
				noDuplicate[noDuplicate.length-1]=arr[i];
			}
			is_duplicate=false; 
			// 중복여부 false일 때 기존 배열 요소를 새로 생성한 배열 요소 전체와 비교하는 것을 반복하도록 한다.
			// for (int i = 0; i < arr.length; i++)로 돌아간다.
		}
		System.out.println("정수배열에서 중복 제거한 noDuplicate[]: "+Arrays.toString(noDuplicate));
	}
	
	public static void qu4() {
		/*
		 * 다음의 정수 배열이 있다.
		 * 		37, 92, 58, 46, 94, 29, 25, 58
		 * 
		 * 위 배열에서 짝수에 해당하는 값과 홀수에 해당하는 값을 하나의 배열 내 별도의 짝수값만 저장하는 짝수배열,
		   홀수값만 저장하는 홀수배열로 분리하여 저장하도록 한다.(정적배열)
		 */
		
		int[] arr = new int[] {37, 92, 58, 46, 94, 29, 25, 58};
		
		int[][] evenodd = new int[2][8];
		int idx_odd=0; // 홀수배열 인덱스
		int idx_even=0; // 짝수배열 인덱스
		
		for(int i=0;i<arr.length;i++) {
			if(arr[i]%2==0) {
				// 짝수값 저장
				evenodd[0][idx_even]=arr[i];
				idx_even++;
			}
			else {
				// 홀수값 저장
				evenodd[1][idx_odd]=arr[i];
				idx_odd++;
			}
		}
		System.out.println(Arrays.deepToString(evenodd).replace("], [", "]\n["));
	}
	
	public static void qu5() {
		/*
		 * 다음의 정수 배열이 있다.
		 * 		37, 92, 58, 46, 94, 29, 25, 58
		 * 
		 * 위 배열에서 짝수에 해당하는 값과 홀수에 해당하는 값을 하나의 배열 내 별도의 짝수값만 저장하는 짝수배열,
		 * 홀수값만 저장하는 홀수배열로 분리하여 저장하도록 한다.(동적배열)
		 */
		
		int[] arr = new int[] {37, 92, 58, 46, 94, 29, 25, 58};
		
		int[][] evenodd = new int[2][]; 
		// 행 별로 짝수값만, 홀수값만 따로 저장하도록 하는 2차원배열로 각 짝수, 홀수 개수만큼 열단위 인덱스를 가지도록 하는 동적배열
		
		int[] arrOdd = new int[0]; // 홀수저장배열
		int[] arrEven = new int[0]; // 짝수저장배열
		
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] % 2 == 0) {
				// 짝수값 저장하도록 짝수저장 배열 크기 늘려서 저장
				int[] arrOddCopy = new int[arrOdd.length + 1];
				System.arraycopy(arrOdd, 0, arrOddCopy, 0, arrOdd.length);
				arrOdd=arrOddCopy;
				arrOdd[arrOdd.length-1]=arr[i];
			}
			else {
				// 홀수값 저장하도록 홀수저장 배열 크기 늘려서 저장
				int[] arrEvenCopy = new int[arrEven.length + 1];
				System.arraycopy(arrEven, 0, arrEvenCopy, 0, arrEven.length);
				arrEven=arrEvenCopy;
				arrEven[arrEven.length-1]=arr[i];
			}
		}
		// 2차원 동적배열에 각 행에 따라 짝수배열, 홀수배열에 접근
		evenodd[0]=arrEven;
		evenodd[1]=arrOdd;
		
		System.out.println(Arrays.deepToString(evenodd).replace("], [", "]\n["));
	}
	
	public static void main(String[] args) {
		//review1();
		//review2();
		//review3();
		//review4();
		//review5();
		//review6();
		
		//qu1();
		//qu2();
		//qu3();
		//qu4();
		qu5();
		

	}

}
