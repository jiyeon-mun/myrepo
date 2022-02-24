package com.kh.team1.board.model;

public class BoardCategoryDTO {
	private int bcid;
	private String catname;
	private char disabled;
	
	public int getBcid() {
		return bcid;
	}
	public void setBcid(int bcid) {
		this.bcid = bcid;
	}
	public String getCatname() {
		return catname;
	}
	public void setCatname(String catname) {
		this.catname = catname;
	}
	public char getDisabled() {
		return disabled;
	}
	public void setDisabled(char disabled) {
		this.disabled = disabled;
	}
	
}


