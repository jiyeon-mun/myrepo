package com.kh.exam6.member;

public class Member {
	private String memberId="sce9853";
	private String memberPwd="******";
	private String name="nick";
	private int age=24;
	private char gender='f';
	private String phone="01012345678";
	private String email="@@@@@@@";
	
	public Member() {} // 기본생성자
	
	public void changeName(String name) {
//		name=name; // 클래스변수와 메서드의 변수 구분이 어려움
		this.name=name; // this.를 붙여서 클래스변수임을 구분한다. 이름이 같은 경우 주로 사용하나 웬만하면 꼭 사용하자!
	}
	public void printName() {
		System.out.println(memberId+"\n"+memberPwd+"\n"+this.name+"\n"
				+age+"\n"+gender+"\n"+phone+"\n"+email);
	}

}
