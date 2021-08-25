package com.kh.practice.chap01_ploy.controller;

import com.kh.practice.chap01_ploy.model.vo.Book;
import com.kh.practice.chap01_ploy.model.vo.Member;

public class LibraryController {
	private Member mem = null;
	private Book[] bList = new Book[5];
	
	public void inserMember(Member mem) {}
	
	public Member myinfo() {
		return mem;
	}
	
	public Book[] selecAll() {
		return bList;
	}
	
	public Book[] searchBook(String keyword) {
		return bList;
	}
	
	public int rentBook(int index) {
		return index;
	}
}
