package com.kh.practice.chap01_ploy.model.vo;

public class Anibook extends Book {
	private int accessAge;
	
	public Anibook() {}
	public Anibook(String title, String auther, String publisher, int accessAge) {
		super(title,auther,publisher);
		this.accessAge=accessAge;
	}
	
	public int getAccessAge() {
		return accessAge;
	}
	public void setAccessAge(int accessAge) {
		this.accessAge = accessAge;
	}
	
	@Override
	public String toString() {
		return "Anibook [accessAge=" + accessAge + ", getTitle()=" + getTitle() + ", getAuther()=" + getAuther()
				+ ", getPublisher()=" + getPublisher() + "]";
	}
}
