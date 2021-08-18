package com.kh.exam14;

public class StudentB extends Foreigner implements Art {

	@Override
	public void draw() {
		System.out.println(this.getName()+": 미술부는 그릴 수 있습니다.");
	}
	
}
