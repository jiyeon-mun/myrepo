package com.kh.exam15;

public abstract class Book implements Page {

	private int totalPageNum;
	private int currentPageNum;
	
	//public Book() {}
	public Book(int totalPageNum) {
		this.totalPageNum=totalPageNum;
	}
	
	@Override
	public void read() {
		System.out.println("책을 읽습니다.");
	}
	
	public void page(int pageNum) {
		this.currentPageNum=pageNum;
	}
	public void next() {
		this.currentPageNum++;
	}
	public void prev() {
		this.currentPageNum--;
	}

	// setter, getter 둘 다 모두 만들 필요 없다.
	public int getTotalPageNum() {
		return totalPageNum;
	}

	public int getCurrentPageNum() {
		return currentPageNum;
	}

	// 상속의 성질 이용
	// 부모클래스에서 공통적인 내용 한 번에 toString()
	// 자식클래스에서 결합하여 사용
	@Override
	public String toString() {
		return "총페이지=" + this.totalPageNum + ", 현재페이지=" + this.currentPageNum;
	}

}
