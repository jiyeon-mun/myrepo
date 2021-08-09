package com.kh.exam02.oth;

// public 접근제한자: 외부에서 접근가능
public class OtherPackage {
	public int attribute = 200;
	public OtherPackage() {}; // OtherPackage 클래스의 기본생성자

}

// (defualt) 접근제한자: 같은 패키지 내에서만 접근 가능
// 생략된 형태로 클래스 작성하면 default 접근제한자 취급
class OtherPackage2{
	public int attribute = 300;
	public OtherPackage2() {}; // OtherPackage2 클래스의 기본생성자
}
