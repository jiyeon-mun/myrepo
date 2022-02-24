package com.my.web.board.model;

import java.util.*;
//import java.sql.Date;

public class BoardDTO {
	
    private int id;
    private int memid;
    private String title;
    private String content;
    private Date createdate;
    private Date updatedate;
    private char deleted;
    private int vcnt;
    private int gcnt;
    private int bcnt;
    private String memname; // memid 이용하여 MEMBERS 테이블에서 username 값 가져오도록
    
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getMemid() {
		return memid;
	}

	public void setMemid(int memid) {
		this.memid = memid;
	}
	
	public String getMemname() {
		return memname;
	}

	public void setMemname(String memname) {
		this.memname = memname;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getContent() {
		return content;
	}
	
	public void setContent(String content) {
		this.content = content;
	}
	
	public Date getCreatedate() {
		return createdate;
	}
	
	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}
	
	public Date getUpdatedate() {
		return updatedate;
	}
	
	public void setUpdatedate(Date updatedate) {
		this.updatedate = updatedate;
	}
	
	public char getDeleted() {
		return deleted;
	}
	
	public void setDeleted(char deleted) {
		this.deleted = deleted;
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
	
	public int getBcnt() {
		return bcnt;
	}
	
	public void setBcnt(int bcnt) {
		this.bcnt = bcnt;
	}

	@Override
	public String toString() {
		return "BoardDTO [id=" + id + ", memid=" + memid + ", memname=" + memname + ", title=" + title + ", content="
				+ content + ", createdate=" + createdate + ", updatedate=" + updatedate + ", deleted=" + deleted
				+ ", vcnt=" + vcnt + ", gcnt=" + gcnt + ", bcnt=" + bcnt + "]";
	}

}