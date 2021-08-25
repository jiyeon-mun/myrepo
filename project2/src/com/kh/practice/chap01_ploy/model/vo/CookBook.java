package com.kh.practice.chap01_ploy.model.vo;

public class CookBook extends Book {
	private boolean coupon;
	
	public CookBook() {}
	public CookBook(String title, String auther, String publisher, boolean coupon) {
		super(title, auther, publisher);
		this.coupon=coupon;
	}
	
	public boolean isCoupon() {
		return coupon;
	}
	public void setCoupon(boolean coupon) {
		this.coupon = coupon;
	}
	
	@Override
	public String toString() {
		return "CookBook [coupon=" + coupon + ", getTitle()=" + getTitle() + ", getAuther()=" + getAuther()
				+ ", getPublisher()=" + getPublisher() + "]";
	}
}
