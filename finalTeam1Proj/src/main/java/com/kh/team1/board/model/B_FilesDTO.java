package com.kh.team1.board.model;

public class B_FilesDTO {
	private int bfid;
	private int bno;
	private String fileName;
	private String fileUrl;
	private long fileSize;
	
	public int getBfid() {
		return bfid;
	}
	public void setBfid(int bfid) {
		this.bfid = bfid;
	}
	public int getBno() {
		return bno;
	}
	public void setBno(int bno) {
		this.bno = bno;
	}
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
	
}
