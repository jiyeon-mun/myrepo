package com.my.web.account.model;

import java.sql.Date;

public class AccountDTO {
	private int id;
	private String username;
	private String password;
	private Date joinDate;
	private Date loginDate;
	private char dormant;
	private char expire;
	private char staff;
	private char admin;
	
	public AccountDTO() {}

	public AccountDTO(int id, String username, String password) {
		this.id = id;
		this.username = username;
		this.password = password;
	}

	public AccountDTO(int id, String username, String password, Date joinDate, Date loginDate) {
		this(id, username, password);
		this.joinDate = joinDate;
		this.loginDate = loginDate;
	}

	public AccountDTO(int id, String username, String password, Date joinDate, Date loginDate, char dormant,
			char expire, char staff, char admin) {
		this(id, username, password, joinDate, loginDate);
		this.dormant = dormant;
		this.expire = expire;
		this.staff = staff;
		this.admin = admin;
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public Date getJoinDate() {
		return joinDate;
	}
	
	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}
	
	public Date getLoginDate() {
		return loginDate;
	}
	
	public void setLoginDate(Date loginDate) {
		this.loginDate = loginDate;
	}
	
	public char getDormant() {
		return dormant;
	}
	
	public void setDormant(char dormant) {
		this.dormant = dormant;
	}
	
	public char getExpire() {
		return expire;
	}
	
	public void setExpire(char expire) {
		this.expire = expire;
	}
	
	public char getStaff() {
		return staff;
	}
	
	public void setStaff(char staff) {
		this.staff = staff;
	}
	
	public char getAdmin() {
		return admin;
	}
	
	public void setAdmin(char admin) {
		this.admin = admin;
	}
	
}
