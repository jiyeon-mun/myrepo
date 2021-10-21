package com.kh.exam02;

//다른 패키지의 클래스를 가져올 때 import하기
// com.kh.exam02.oth 패키지의 OtherPackage를 사용하겠다
import com.kh.exam02.oth.OtherPackage;

// com.kh.exam02.oth 하위 모든 클래스를 포함하겠다는 의미이나
// default 접근제한자를 사용하는 OtherPackage2 클래스를 가져오지 못함
// com.kh.exam02.oth 패키지 하위의 2개의 클래스 중 OtherPackage 클래스만 가져온다.
// import com.kh.exam02.oth.*;

/*
* 클래스 접근 제한자.
* 		public : 모든 영역에서 사용 가능
* 		default : 동일 패키지 영역에서만 사용 가능
*/

public class Sample1 {

	public static void main(String[] args) {
		SamePackage same = new SamePackage();
		System.out.println("SamePackage 접근 가능 -> " + same.attribute);
		
		// package com.kh.exam02.oth;
		// 다른 패키지의 클래스를 가져올 때 import하기
		OtherPackage other = new OtherPackage();
		System.out.println("OtherPackage 접근 가능 -> " + other.attribute);
		
//		default 접근제한자를 사용하는 다른 패키지의 클래스를 가져오지 못함
//		OtherPackage2 other2 = new OtherPackage2();
//		System.out.println("OtherPackage2 접근 가능 -> " + other2.attribute);
	}

}
