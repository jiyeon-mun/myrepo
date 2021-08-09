package com.kh.exam01;

//현실세계에 존재하는 사물, 개념을 프로그램에 추상화하여 클래스로 정의한다.
class Person1 {
	// 사물 또는 개념이 가지고 있는 "속성"을 프로그램의 "멤버 변수/필드" 로 추상화.
	String name = "홍길동";
	String pNo;
	String phone;
	String address;
	int age;
	char gender;
}

/* 
* 캡슐화 : 객체를 다른 외부 객체와 구분하여 내부의 데이터 자원에 임의로 접근하지 못하게 하기 위한 방법
* 		캡슐화 원칙에 따라 "멤버 변수/필드"는 private 접근제한자로 사용한다.
* 		외부에서 "멤버 변수/필드" 에 직접 접근을 하지 못하지만 메서드를 통해 간접적으로 접근할 수 있게
* 		만들어 준다.
*/
class Person2 {
	// 멤버변수 접근권한 private
	private String name = "홍길동";
	private String pNo;
	private String phone;
	private String address;
	private int age;
	private char gender;
	
	// 멤버변수 접근권한을 public으로 설정하여 멤버변수에 접근
	public String getName() {
		return name;
	}
}
	
public class Sample1 {

	public static void main(String[] args) {
		// 인스턴스화 : 클래스로 정의된 객체를 프로그램으로 동작하기 위해 메모리에 저장
		// 인스턴스 : 인스턴스화를 거쳐 생성된 객체.
		Person1 p1 = new Person1();
		System.out.println(p1.name);
		
		Person2 p2 = new Person2();
		// 캡슐화로 인해 직접적인 접근 불가.
		// p2.name = "홍길동";
		
		// 외부에 공개된 메서드를 통해 접근
		System.out.println(p2.getName());

	}

}
