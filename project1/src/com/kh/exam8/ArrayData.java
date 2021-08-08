package com.kh.exam8;

// 배열 관련 Arrays이용 시 import필수
import java.util.Arrays;
import java.util.Scanner;

public class ArrayData {

	static Scanner sc = new Scanner(System.in);
	
	public static void sample1() {
		// 정수 배열 생성
		int[] iArr = new int[5];
		// 배열명=배열의 시작주소(참조주소)
		System.out.println(iArr); 

		// 정수 배열에 접근
		// 배열 선언 후 초기화하지 않는다면 배열은 자동으로 0으로 초기화된다.
		System.out.println(iArr[0]); // 0
		System.out.println(iArr[1]); // 0
		System.out.println(iArr[2]); // 0
		System.out.println(iArr[3]); // 0
		System.out.println(iArr[4]); // 0
	}

	public static void sample2() {
		int[] iArr = new int[5];
		
		// 반복문을 사용하여 정수 배열에 접근
		for(int i=0; i<=(iArr.length -1);i++) {
			System.out.println(iArr[i]);
		}
	}

	public static void sample3() {
		// 배열 선언과 동시에 초기화.
		// int[] iArr = { 1, 2, 3, 4, 5 };
		int[] iArr = new int[] { 1, 2, 3, 4, 5 };
		
		
		for(int i=0; i<=(iArr.length -1);i++) {
			System.out.println(iArr[i]);
		}
	}
	
	public static void sample4() {
		// 선언 후 초기화
		
		int[] iArr = new int[5];
		// 초기화를 위해 반복문 사용
		for(int i = 0; i <= (iArr.length - 1); i++) {
			iArr[i] = i + 1;
			System.out.println(iArr[i]);
		}
	}
	
	public static void sample5() {
		// 다양한 종류의 배열
		boolean[] boolArr = new boolean[] {true, false};
		byte[] bArr = new byte[] {1, 2, 3, 4, 5};
		char[] cArr = new char[] {'a', 'b', 'c', 'd'};
		double[] dArr = new double[] {1.0, 2.0, 3.0};
		String[] sArr = new String[] {"hello", "hi", "안녕하세요"};
		
		for(int i = 0; i <= (boolArr.length - 1); i++) {
			System.out.print(i + ":" + boolArr[i] + " ");
		}
		
		System.out.println();
		
		for(int i = 0; i <= (bArr.length - 1); i++) {
			System.out.print(i + ":" + bArr[i] + " ");
		}
		
		System.out.println();
		
		for(int i = 0; i <= (cArr.length - 1); i++) {
			System.out.print(i + ":" + cArr[i] + " ");
		}
		
		System.out.println();
		
		for(int i = 0; i <= (dArr.length - 1); i++) {
			System.out.print(i + ":" + dArr[i] + " ");
		}
		
		System.out.println();
		
		for(int i = 0; i <= (sArr.length - 1); i++) {
			System.out.print(i + ":" + sArr[i] + " ");
		}
		// System.out.println(boolArr);
		// System.out.println(bArr);
		// System.out.println(cArr);
		// System.out.println(dArr);
		// System.out.println(sArr);
	}
	
	public static void sample6() {
		// 배열 복사
		int x1 = 10;
		int x2 = x1;
		System.out.println("x1:" + x1 + " |x2:" + x2); // x1:10, x2:10
		
		x1 = 15;
		x2 = 25;
		System.out.println("x1:" + x1 + " |x2:" + x2); // x1:15, x2:25
		
		System.out.println("-----배열 복사(얕은 복사)-----");
		
		int[] iArr1 = new int[] {1, 2, 3, 4};
		int[] iArr2 = iArr1;
		for(int i = 0; i < iArr1.length; i++) {
			System.out.println("iArr1[" + i + "]:" + iArr1[i] + "|iArr2[" + i + "]:" + iArr2[i]);
		}
		
		System.out.println("-----배열 복사 후 값 변경-----");
		// 동일한 참조값으로 변경을 하기 때문에 iArr1 이나 iArr2 모두 변경된 것으로 보임
		iArr1[0] = 15; // iArr2[0]도 15의 값을 가짐
		iArr2[3] = 25; // iArr1[3] 역시 25의 값을 가짐
		for(int i = 0; i < iArr1.length; i++) {
			System.out.println("iArr1[" + i + "]:" + iArr1[i] + "|iArr2[" + i + "]:" + iArr2[i]);
		}
		
		System.out.println("-----참조값 확인-----");
		// 동일한 참조주소를 가짐으로써
		// 어떤 하나의 배열 요소에 다른 값을 넣어도 다른 배열에 영향을 미친다.
		System.out.println("iArr1 참조값 : " + iArr1);
		System.out.println("iArr2 참조값 : " + iArr2);
	}
	
	public static void sample7() {
		// 배열의 깊은 복사 방법 1
		int[] iArr1 = new int[] {1, 2, 3, 4};
		int[] iArr2 = new int[iArr1.length]; // iArr2[] = {0, 0, 0, 0}
		
		System.out.println("-----배열 복사(깊은 복사)-----");
		for (int i = 0; i < iArr1.length; i++) {
			// iArr1[i]의 요소값들이 iArr2[i]의 위치에 값만 복사됨
			iArr2[i] = iArr1[i];
		}
		for (int i = 0; i < iArr1.length; i++) {
			System.out.println("iArr1[" + i + "]:" + iArr1[i] + "|iArr2[" + i + "]:" + iArr2[i]);
		}
		
		System.out.println("-----배열 복사 후 값 변경-----");
		// 원하는 배열에 대해 원하는 요소의 값만 변경됨
		// 각 배열요소 값에 대한 변경이 다른 배열에 영향을 미치지 않음
		iArr1[0] = 15;
		iArr2[3] = 25;
		for (int i = 0; i < iArr1.length; i++) {
			System.out.println("iArr1[" + i + "]:" + iArr1[i] + "|iArr2[" + i + "]:" + iArr2[i]);
		}
		
		System.out.println("-----참조값 확인-----");
		// 두 배열의 참조주소가 서로 다름
		System.out.println("iArr1 참조값 : "+iArr1);
		System.out.println("iArr2 참조값 : "+iArr2);
	}
	
	public static void sample8() {
		// 깊은 복사를 사용하여 배열의 크기 늘리기.
		int[] iArr1 = new int[] { 1, 2, 3, 4 };
		
		System.out.println("-----배열 크기 늘리기 전-----");
		for (int i = 0; i < iArr1.length; i++) {
			System.out.println("iArr1[" + i + "]:" + iArr1[i]);
		}
		
		/*
		 * 기존배열크기+1의 크기를 갖는 새로운 배열을 만든다.
		 * 새로운 배열에 기존 배열의 요소값을 (같은 위치로) 깊은 복사한다.
		 * (! 새로운배열은 기존배열의 크기+1이므로 배열 마지막 위치는 0으로 초기화된다.(정수배열의 경우))
		 * 얕은복사를 활용하여 기존배열크기를 새로운배열의 크기만큼 늘린다.
		 * 크기가 늘어난 기존배열에 대해서 마지막 인덱스에 원하는 값을 저장해도 되고 안해도 되고...
		 */
		int[] iArr2 = new int[iArr1.length + 1]; // iArr1.length=4 -> iArr2.length=5
		// 깊은복사
		for (int i = 0; i < iArr1.length; i++) {
			iArr2[i] = iArr1[i];
			// iArr2[]는 iArr1[]과 동일한 위치에 동일한 요소값을 가지게된다.
		}
		//System.out.println(Arrays.toString(iArr2)); // [1,2,3,4,0]
		
		System.out.println("-----배열 크기 늘린 후-----");
		 // 얕은복사를 통해 기존 배열 크기를 새로운 배열 크기만큼 증가시킴
		iArr1=iArr2;
		//System.out.println(Arrays.toString(iArr1)); // [1,2,3,4,0]
		
		// 배열의 마지막 index(iArr[4])에 값 5 저장. 생략가능
		iArr1[iArr2.length-1]=5;
		
		for(int i=0;i<iArr1.length;i++) {
			System.out.println("iArr1[" + i + "]:" + iArr1[i]);
		}
	}
	
	public static void sample9() {
		// 깊은 복사를 사용하여 배열의 크기 줄이기.
		int[] iArr1 = new int[] {1, 2, 3, 4};
		
		System.out.println("-----배열의 크기를 줄이기 전-----");
		for(int i = 0; i < iArr1.length; i++) {
			System.out.println("iArr1[" + i + "]:" + iArr1[i]);
		}
		
		int[] iArr2 = new int[iArr1.length - 1];
		for(int i = 0; i < iArr2.length; i++) {
			iArr2[i] = iArr1[i];
		}
		
		System.out.println("-----배열의 크기를 줄인 후-----");
		iArr1 = iArr2;
		
		for(int i = 0; i < iArr1.length; i++) {
			System.out.println("iArr1[" + i + "]:" + iArr1[i]);
		}
	}
	
	public static void sample10() {
		int[] iArr = new int[0];
		int num;
		int sum=0;
		
		// -1 입력하면 무한반복 프로그램 종료
		while(true) {
			System.out.println("1 ~ 49 사이의 정수 값을 입력해주세요.(-1 입력하면 종료)");
			System.out.print(": ");
			num = sc.nextInt(); sc.nextLine();
			// 입력정수가 -1이 아닌 경우 깊은복사로 입력한 정수들의 합 구하기
			if(num!=-1) {
				int[] copyNum = new int[iArr.length + 1];
				
				// 깊은복사를 통해 새로운배열에 기존배열 값들 복사
				// System.arraycopy(); for문을 이용한 깊은복사와 동일
				//              원본   원본복사위치    복사본     복사본복사위치 복사할길이(원본길이)
				System.arraycopy(iArr,	 0, 	copyNum,	0, 			iArr.length); 
//				for(int i=0;i<iArr.length;i++) {
//					copyNum[i]=iArr[i];
//				}
				
				// 얕은복사로 기존 배열 크기 증가		
				iArr=copyNum;
				
				// 배열크기가 증가한 기존 배열의 마지막 인덱스에 입력한 정수값 저장
				iArr[iArr.length-1]=num;
				// 입력한 값들의 합 구하기
				// 입력한 횟수만큼 배열 크기 증가 및 입력값들 배열 내 마지막 인덱스에 저장됨
				System.out.println("iArr[]: " + Arrays.toString(iArr));
				
				sum+=num;
			}
			else {
				break;
			}
		}
		System.out.println();
		System.out.println("입력한 정수들의 합은 : " + sum);
//		System.out.println("iArr[]: " + Arrays.toString(iArr)); // 배열 확인
	}
	
	public static void main(String[] args) {
		//sample1();
		//sample2();
		//sample3();
		//sample4();
		//sample5();
		//sample6();
		//sample7();
		//sample8();
		//sample9();
		sample10();
	}

}
