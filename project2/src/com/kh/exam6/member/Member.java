package com.kh.exam6.member;

public class Member {
	private String memberId="sce9853";
	private String memberPwd="******";
	private String memberName="nick";
	private int age=24;
	private char gender='f';
	private String phone="01012345678";
	private String email="@@@@@@@";
	
	public Member() {} // 기본생성자
	
	public void changeName(String name) {
		memberName=name;
	}
	public void printName() {
		System.out.println(memberId+"\n"+memberPwd+"\n"+memberName+"\n"
				+age+"\n"+gender+"\n"+phone+"\n"+email);
	}

}
