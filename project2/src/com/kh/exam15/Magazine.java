package com.kh.exam15;

public class Magazine extends Book {
	private String name;
	private String company;
	private String editor;
	private String type;
	
	public Magazine(String name, String company, String editor,
			String type, int totalPageNum) {
		super(totalPageNum);
		this.name = name;
		this.company = company;
		this.editor = editor;
		this.type = type;
	}
	
	@Override
	public void read() {
		System.out.println(this.name+" 잡지를 읽습니다.");
	}
	
	public void QRCapture() {
		System.out.println("QR 캡처로 해당 상품 구매 페이지로 이동할 수 있습니다.");
	}

	@Override
	public String toString() {
		return "Magazine [제목=" + this.name + ", 출판사=" + this.company + ", 에디터=" + this.editor + ", 종류=" + this.type
				+ ", " + super.toString() + "]";
	}
}
