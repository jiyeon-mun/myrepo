package com.kh.practice.chap01_ploy.model.vo;

public class Book {
	private String title;
	private String auther;
	private String publisher;
	
	public Book() {}
	public Book(String title, String auther, String publisher) {
		this.title=title;
		this.auther=auther;
		this.publisher=publisher;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuther() {
		return auther;
	}
	public void setAuther(String auther) {
		this.auther = auther;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	
	@Override
	public String toString() {
		return "Book [title=" + title + ", auther=" + auther + ", publisher=" + publisher + "]";
	}
}
