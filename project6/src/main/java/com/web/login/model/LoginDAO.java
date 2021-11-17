package com.web.login.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.jspweb.dbconn.OracleCRUD;

public class LoginDAO extends OracleCRUD {
	
	public LoginDTO select(String username) {
		String query = "SELECT * FROM MEMBERS"
				+ " WHERE USERNAME = '" + username + "'";
		LoginDTO data = null;
		try {
			ResultSet res = this.occ.sendQuery(query);
			
			if(res.next()) {
				data = new LoginDTO(
						res.getString("USERNAME"),
						res.getString("PASSWORD"));
			}
			res.close();
			occ.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return data;
	}

}
