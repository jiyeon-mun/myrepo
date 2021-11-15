package com.web.bookmark.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.jspweb.dbconn.OracleCloudConnect;

public class BookMarkDAO {
	// database 연결 및 작업
	private OracleCloudConnect occ;

	public BookMarkDAO() {
		try {
			this.occ = new OracleCloudConnect();
			this.occ.connection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<BookMarkDTO> select() { // database 조회
		List<BookMarkDTO> datas = new ArrayList<BookMarkDTO>();

		String query = "SELECT * FROM BOOKMARK ORDER BY B_ID";
		ResultSet res; // SQL 질의 결과값
		try {
			res = occ.sendQuery(query);
			while(res.next()) {
				BookMarkDTO dto = new BookMarkDTO();
				dto.setAlias(res.getString("B_ALIAS"));
				dto.setUrl(res.getString("B_URL"));
				datas.add(dto);
			}
			res.close();
			occ.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return datas;
	}

	public boolean insert(BookMarkDTO dto) { // database 등록
		String query = "INSERT INTO BOOKMARK VALUES("
				+ "BOOKMARK_SEQ.NEXTVAL, "
				+ "'" + dto.getAlias() + "', "
				+ "'" + dto.getUrl() + "')";

		int res = 0;
		try {
			res = occ.insertQuery(query); // OracleCloudConnect 클래스의 insertQuery() 반환타입 int
			occ.close(); // 자원반납 close()
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return res == 1 ? true : false; // 데이터 삽입 성공 시 1 반환
	}

	public void commit() {
		try {
			occ.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void rollback() {
		try {
			occ.rollback();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void close() {
		try {
			occ.connectionClose();
		} catch (SQLException e) {
			e.printStackTrace(); // 모든 작업 완료 후 연결을 끊기 위한 close()
		}
	}
}
