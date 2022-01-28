package com.my.web.account.model;

import java.sql.Date;

public class JoinVO {
	private String username;
	private String password;
	private String passchk;
	private Date joinDate;
	private Date loginDate;
	private String email1;
	private String email2;
	private Date birthday;
	
	public JoinVO() {}

	public JoinVO(String username, String password, String passchk) {
		this.username = username;
		this.password = password;
		this.passchk = passchk;
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

	public String getPasschk() {
		return passchk;
	}

	public void setPasschk(String passchk) {
		this.passchk = passchk;
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

	public String getEmail1() {
		return email1;
	}

	public void setEmail1(String email1) {
		this.email1 = email1;
	}

	public String getEmail2() {
		return email2;
	}

	public void setEmail2(String email2) {
		this.email2 = email2;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	@Override
	public String toString() {
		return "JoinVO [username=" + username + ", password=" + password + ", passchk=" + passchk + ", joinDate="
				+ joinDate + ", loginDate=" + loginDate + ", email1=" + email1 + ", email2=" + email2 + ", birthday="
				+ birthday + "]";
	}
}
