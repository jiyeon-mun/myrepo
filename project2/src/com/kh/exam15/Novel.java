package com.kh.exam15;

public class Novel extends Book {
	private String name;
	private String company;
	private String genre;
	private String writer;
	
	/*
	 * Implicit super constructor Book() is undefined for default constructor. Must define an explicit constructor
	 * 
	 * 1. 부모클래스에 기본생성자 명시적으로 작성한다.
	 * 2. 부모클래스 내 매개변수생성자처럼 자식클래스 내에도 매개변수생성자 만들고 부모생성자를 사용하도록 한다.
	 */	
	public Novel(String name, String company, String genre, String writer, int totalPageNum) {
		super(totalPageNum);
		this.name = name;
		this.company = company;
		this.genre = genre;
		this.writer = writer;
	}

	@Override
	public void read() {
		System.out.println(this.name+" 책을 읽습니다.");
	}
	
	public void search(String search) {
		System.out.println(search+" 내용을 "+this.name+"에서 검색합니다.");
	}

	@Override
	public String toString() {
		return "Novel [제목=" + this.name + ", 출판사=" + this.company + ", 장르=" + this.genre + ", 작가=" + this.writer
				+ ", " + super.toString() + "]";
	}
	
	

}
