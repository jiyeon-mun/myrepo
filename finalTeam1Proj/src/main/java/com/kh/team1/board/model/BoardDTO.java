package com.kh.team1.board.model;

import java.sql.Date;

public class BoardDTO {
	private int bno;
	private int catid;
	private String catname;
	private int mid;
	private String username;
	private String title;
	private int vcnt;
	private int gcnt;
	private Date writeDate;
	private String content;
	private int bcnt;
	
	private String fileName;
	private String fileUrl;
	private long fileSize;
	
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getFileUrl() {
		return fileUrl;
	}
	public void setFileUrl(String fileUrl) {
		this.fileUrl = fileUrl;
	}
	public long getFileSize() {
		return fileSize;
	}
	public void setFileSize(long fileSize) {
		this.fileSize = fileSize;
	}
	// 검색필터
//	private int type;
//	private int search;
//	
//	public int getType() {
//		return type;
//	}
//	public void setType(int type) {
//		this.type = type;
//	}
//	public int getSearch() {
//		return search;
//	}
//	public void setSearch(int search) {
//		this.search = search;
//	}
	
	public BoardDTO() {}
	
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getBcnt() {
		return bcnt;
	}
	public void setBcnt(int bcnt) {
		this.bcnt = bcnt;
	}
	public int getBno() {
		return bno;
	}
	public void setBno(int bno) {
		this.bno = bno;
	}
	public int getCatid() {
		return catid;
	}
	public void setCatid(int catid) {
		this.catid = catid;
	}
	public String getCatname() {
		return catname;
	}
	public void setCatname(String catname) {
		this.catname = catname;
	}
	public int getMid() {
		return mid;
	}
	public void setMid(int mid) {
		this.mid = mid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getVcnt() {
		return vcnt;
	}
	public void setVcnt(int vcnt) {
		this.vcnt = vcnt;
	}
	public int getGcnt() {
		return gcnt;
	}
	public void setGcnt(int gcnt) {
		this.gcnt = gcnt;
	}
	public Date getWriteDate() {
		return writeDate;
	}
	public void setWriteDate(Date writeDate) {
		this.writeDate = writeDate;
	}
	
}
