package com.web.guestbook.model;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GuestBookDTO { // 객체
	private int id;
	private String ipaddr;
	private String context="";
	private Date date;
	
	public GuestBookDTO() {} // 기본 생성자
	
	public GuestBookDTO(String ipaddr, String context) {
		this.ipaddr=ipaddr;
		this.context=context;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public void setId(String id) {
		//  int					 String
		this.id = Integer.parseInt(id); // int로 형변환
	}
	
	public String getIpaddr() {
		return ipaddr;
	}
	public void setIpaddr(String ipaddr) {
		this.ipaddr = ipaddr;
	}
	
	public String getContext() {
		return context;
	}
	public void setContext(String context) {
		this.context = context;
	}
	
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	public void setResultSet(ResultSet res) throws SQLException {
		this.id = res.getInt("G_ID");
		this.context = res.getString("G_CONTEXT");
		this.ipaddr = res.getString("G_IPADDR");
		this.date = res.getDate("G_DATE");
	}
}
