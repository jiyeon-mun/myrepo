package com.my.web.board.model;

public class UploadFileDTO {
	private int id;
	private int bno;
	private String fileName;
	private String fileUrl;
	private long fileSize;
	
	public UploadFileDTO() {}
	
	public UploadFileDTO(int id, int bno, String fileName, String fileUrl, long fileSize) {
		this.id = id;
		this.bno = bno;
		this.fileName = fileName;
		this.fileUrl = fileUrl;
		this.fileSize = fileSize;
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
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
