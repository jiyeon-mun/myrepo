package com.web.bookmark.model;

public class BookMarkDTO {
	private String alias = "";
	private String url = "";
	
	public BookMarkDTO() {}
	
	public BookMarkDTO(String alias, String url) {
		this.alias=alias;
		this.url=url;
	}

	public String getAlias() {
		return alias;
	}
	public void setAlias(String alias) {
		this.alias = alias;
	}

	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
}
