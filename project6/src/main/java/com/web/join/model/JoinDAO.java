package com.web.join.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.jspweb.dbconn.OracleCloudConnect;

public class JoinDAO {
	OracleCloudConnect occ;
	
	public JoinDAO() {
		try {
			this.occ = new OracleCloudConnect();
			this.occ.connection();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("JoinDAO 생성자 동작에서 에러 발생");
		}
		
	}

	public JoinDTO select(String username) {
		String query = "SELECT * FROM MEMBERS"
				+ " WHERE USERNAME = '" + username + "'";
		JoinDTO data = null;
		try {
			ResultSet res = this.occ.sendQuery(query); // 0, 1, n 개의 결과값
			if(res.next()) { // next() 사용가능하면 조회됐다는 의미
				data = new JoinDTO(
						res.getInt("ID"),
						res.getString("USERNAME"),
						res.getString("PASSWORD"),
						res.getString("EAMIL"));
				return data;
			}
			res.close();
			occ.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("JoinDAO select() 메서드 동작 에러 발생");
		}

		return data;
	}

	public void close() {
		try {
			occ.connectionClose();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("JoinDAO close() 메서드 동작 에러 발생");
		}
	}
	
	public boolean insert(JoinDTO dto) {
		String query = "INSERT INTO MEMBERS VALUES("
				+ "MEMBERS_SEQ.NEXTVAL,"
				+ "'" + dto.getUsername() + "',"
				+ "'" + dto.getPassword() + "',"
				+ "'" + dto.getEmail() + "')";
		int res = 0;
		try {
			res = occ.insertQuery(query);
			occ.close();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("JoinDAO insert() 메서드 동작 에러 발생");
		}
		
		return res == 1 ? true : false;
	}

	public void commit() {
		try {
			occ.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("JoinDAO commit() 메서드 동작 에러 발생");
		}
	}

	public void rollback() {
		try {
			occ.rollback();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("JoinDAO rollback() 메서드 동작 에러 발생");
		}
	}

}
