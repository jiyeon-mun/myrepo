package com.kh.exam14;

public class Foreigner extends Person {
	private String fNumber; // 외국인등록번호
	private int durationDay; // 체류기간
	
	public String getfNumber() {
		return fNumber;
	}

	public void setfNumber(String fNumber) {
		this.fNumber = fNumber;
	}

	public int getDurationDay() {
		return durationDay;
	}

	public void setDurationDay(int durationDay) {
		this.durationDay = durationDay;
	}

	// 연장 체류기간 계산
	public void extduration(int day) {
		this.durationDay+=day;
	}
	
}
