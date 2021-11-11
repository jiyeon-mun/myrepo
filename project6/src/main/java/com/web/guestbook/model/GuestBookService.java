package com.web.guestbook.model;

import java.sql.SQLException;
import java.util.List;

public class GuestBookService {
	private GuestBookDAO dao = null;
	
	public GuestBookService() {
		try {
			this.dao = new GuestBookDAO();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public boolean add(GuestBookDTO dto) { // 방명록 추가 실행
		try {
			if(dao.insert(dto)) {
	        	dao.commit();
	        	return true;
	        } else {
	        	dao.rollback();
	        	return false;
	        }
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}
	
	public List<GuestBookDTO> getList() { // 방명록 조회결과 출력
		List<GuestBookDTO> datas = null;
		
		try {
			datas = dao.select();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return datas;
	}
}