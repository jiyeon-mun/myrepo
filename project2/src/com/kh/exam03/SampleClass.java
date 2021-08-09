package com.kh.exam03;

/*
 * static : 멤버 변수/필드에 이 예약어를 사용하면 동일 클래스로 만들어진 모든 인스턴스들 간에
 * 		공유할 수 있는 변수/필드로 사용할 수 있다.
 */
class Other {
	static int share = 100;
	int noShare = 200;
	
	// Other 클래스의 기본생성자
	public Other() {
		noShare = 300;
	}
}

public class SampleClass {

	public static void main(String[] args) {
		Other oth1 = new Other();
		Other oth2 = new Other();
		
		System.out.println(oth1.noShare + "|" + oth2.noShare);
		System.out.println(oth1.share + "|" + oth2.share);
		
		oth1.noShare = 250;
		
		// static 예약어를 사용하는 필드에 대해서는 인스턴스가 아닌 클래스로 접근하여 사용.
		// oth2.share = 150; //인스턴스로 접근한 경우
		Other.share = 150;
		
		// 변경 선택한 객체에 대해서만 변경값 적용
		System.out.println(oth1.noShare + "|" + oth2.noShare);
		// 모든 객체에 대해서 변경값 적용
		System.out.println(oth1.share + "|" + oth2.share);
	}

}