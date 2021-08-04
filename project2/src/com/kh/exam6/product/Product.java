package com.kh.exam6.product;

public class Product {

	private String pName = "키보드";
	private int price = 25000;
	private String band = "OXOX";
	
	public Product() {}
	
	public void info() {
		System.out.println(pName+"\n"+price+"\n"+band);
	}
}
