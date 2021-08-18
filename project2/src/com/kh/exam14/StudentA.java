package com.kh.exam14;

public class StudentA extends NativePerson implements Sports {

	@Override
	public void run() {
		System.out.println(this.getName()+": 운동부는 뛸 수 있습니다.");
		System.out.println();
	}
	
}
