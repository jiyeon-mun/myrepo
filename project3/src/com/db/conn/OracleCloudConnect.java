package com.db.conn;

import java.io.*;
import java.sql.*;
import java.util.Properties;

import oracle.jdbc.OracleConnection;
import oracle.jdbc.pool.OracleDataSource;

public class OracleCloudConnect {
	private final String DB_URL = "jdbc:oracle:thin:@mydb_medium?TNS_ADMIN=C:/Users/wldus/Oracle/network/admin/Wallet_myDB";
//	private final String USERNAME = "user1";
//	private final String PASSWORD = ""; // 패스워드는 빼고 깃허브에 저장하자
	private Properties info = new Properties();
	private OracleDataSource ods = null;
	private OracleConnection conn = null;
	private Statement stat = null;
	private ResultSet rs = null;
	
	// 초기화 블럭; 코드 내 계정 정보없이 계정에 접근; Properties 활용
	{
		// 사용자 홈 디렉터리 경로를 알아낸다
		String userHome = System.getenv("user.home");
		try {
			// 사용자 홈 디렉터리에 위치한 oracle_connection.prop 파일 열기
			// info.load(new FileReader(userHome+"/oracle_connection.prop"));
			
			// 현재 위치에서의 oracle_connection.prop 파일 열기
			info.load(new FileReader("oracle_connection.prop"));
			
			// 상위 위치에서 oracle_connection.prop 파일 열기
			// info.load(new FileReader("../oracle_connection.prop"));
	
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
		/* JDBC 사용하여 Oracle Database 연결 하기위한 과정
		 * 1. 데이터베이스 연결 구성 정보 생성
		 * 2. 생성된 연결 구성 정보로 데이터베이스 연결
		 * 3. Statement 생성
		 * 4. Query 전송
		 * 5. 결과 받기
		 * 6. 모든 자원 반납 -> close();
		 */
		
		// OracleDatabase 에 접속하기 위한 설정
//		this.info.put(OracleConnection.CONNECTION_PROPERTY_USER_NAME, USERNAME);
//		this.info.put(OracleConnection.CONNECTION_PROPERTY_PASSWORD, PASSWORD);
		this.ods = new OracleDataSource();
		this.ods.setURL(DB_URL);
		this.ods.setConnectionProperties(this.info);
	}

	public void connection() throws SQLException {
		// OracleDatabase 에 접속
		this.conn = (OracleConnection) ods.getConnection();
	}

	public ResultSet sendQuery(String query) throws SQLException {
		// OracleDatabase 에 접속 후 Query 전송
		this.stat = this.conn.createStatement();
		this.rs = this.stat.executeQuery(query); // 실행 결과로 ResultSet 을 받아온다.
		return rs;
	}

	public void close() throws SQLException {
		// 모든 작업 완료 후에는 자원 반납 하기위해 close();
		this.rs.close();
		this.stat.close();
	}

	public void connectionClose() throws SQLException {
		// 모든 작업 완료 후에는 연결을 끊기 위해 close();
		this.conn.close();
	}

	public static void main(String[] args) {
		try {
			OracleCloudConnect occ = new OracleCloudConnect();

			occ.connection();

											// SELECT문에 ;(세미콜론) 쓰지 않는다.
			ResultSet res = occ.sendQuery("SELECT EMPLOYEE_ID, FIRST_NAME FROM EMPLOYEES");
			while (res.next()) {
				// 숫자는 컬럼을 의미; EMPLOYEE_ID 이 NUMBER 타입, FIRST_NAME 이 VARCHAR 타입이므로 getInt, getString 으로 맞춰준다.
				System.out.println(res.getInt(1) + " | " + res.getString(2));
			}
			occ.close();
			occ.connectionClose();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
