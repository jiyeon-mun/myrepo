package com.jspweb.dbconn;

import java.io.*;
import java.sql.*;
import java.util.Properties;

import oracle.jdbc.OracleConnection;
import oracle.jdbc.pool.OracleDataSource;

public class OracleCloudConnect {
	private final String DB_URL = "jdbc:oracle:thin:@mydb_medium?TNS_ADMIN=C:/Users/wldus/Oracle/network/admin/Wallet_myDB";
	private Properties info = new Properties();
	private OracleDataSource ods = null;
	private OracleConnection conn = null;
	private Statement stat = null;
	
	// 초기화 블럭
	{
		// 사용자 홈 디렉터리 경로를 알아낸다.
		String userHome = System.getProperty("user.home");
		try {
			info.load(new FileReader(userHome + "/oracle_connection.prop"));
		} catch (FileNotFoundException e) {
			System.out.println("oracle_connection.prop 파일을 찾을 수 없습니다.");
			System.out.println("기본 연결 계정을 사용합니다.");
			info.setProperty("user", "user");
			info.setProperty("password", "password");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public OracleCloudConnect() throws SQLException {
		// OracleDatabase에 접속하기 위한 설정
		this.ods = new OracleDataSource();
		this.ods.setURL(DB_URL);
		this.ods.setConnectionProperties(this.info);
	}

	public void connection() throws SQLException {
		// OracleDatabase에 접속
		this.conn = (OracleConnection) ods.getConnection();
		this.conn.setAutoCommit(false);
	}

	public ResultSet sendQuery(String query) throws SQLException {
		// OracleDatabase에 접속 후 Query 전송
		this.stat = this.conn.createStatement();
		return this.stat.executeQuery(query);	// 실행 결과로 ResultSet을 받아온다.;
	}

	public int insertQuery(String query) throws SQLException {
		this.stat = this.conn.createStatement();
		return this.stat.executeUpdate(query);
	}

	public void close() throws SQLException {
		// 모든 작업을 완료 후에는 자원을 반납 하기위해 close();
		this.stat.close();
	}

	public void connectionClose() throws SQLException {
		// 모든 작업을 완료한 후에는 연결을 끊기 위해 close();
		this.conn.close();
	}

	public void commit() throws SQLException {
		this.conn.commit();
	}

	public void rollback() throws SQLException {
		this.conn.rollback();
	}

}
